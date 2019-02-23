package screen;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.stormjustice.Run;

import actors.Actor;
import actors.Enemy;
import actors.NPC;
import actors.OldManNPC;
import actors.Postcard;
import items.Coin;
import items.HealthItem;
import items.Item;
import main.Player;
import map.Map;

public class Level1Screen implements Screen{

	Player player;
	
	Enemy enemy1;
	Enemy enemy2;
	Enemy enemy3;
	 
	HealthItem hItem;
	
	NPC  npc;
	Map map;
	
	public boolean showingDialogue = false;
	
	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private ArrayList<Actor> actorList = new ArrayList<Actor>();
	
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	
	private int ONE = 1;
	private int TEN = 10;
	private int TEN2 = 10;
	
	private boolean paused;

	private Run game;
	
	private static Texture pausedPng;
	private static Sprite pause;
	private Hud hud;
	
	private Music music;
	private SpriteBatch batch;
	
	
	public Level1Screen(final Run game) {
		this.game = game;
		
		map = new Map("level1.tmx");
		renderer = new OrthogonalTiledMapRenderer(map.renderMap());
		//CAM
		
		camera = new OrthographicCamera();
		
		player = new Player(200, 250);
		
		actorList.add(npc = new Postcard(750, 700, 0));
		
		music = Run.manager.get("music.mp3", Music.class);
		music.setLooping(true);
		music.setVolume(0.3f);
		music.play();
		
		pausedPng = new Texture(Gdx.files.internal("Pause.png"));
		pause = new Sprite(pausedPng);
		pause.flip(false,true);


	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		//MAP
		batch = new SpriteBatch();
		hud = new Hud(batch, Gdx.graphics.getWidth()/100, Gdx.graphics.getHeight() - 25);
		
		

	}
	

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		//Renders window and map
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.setView(camera);
		renderer.render();

		hud.stage.draw();
		
		//Renders Player
		renderer.getBatch().begin();
		
		
		
		for (int j = 0; j < actorList.size(); j++) {
			actorList.get(j).getSprite().draw(renderer.getBatch());
		}
		
		//player.draw(renderer.getBatch());
		player.getSprite().draw(renderer.getBatch());
		if(paused) {
			renderer.getBatch().draw(pausedPng, player.getSprite().getX() - 250, player.getSprite().getY() -300);
		}
		
		for (int i = 0; i < itemList.size(); i++) {
			itemList.get(i).getSprite().draw(renderer.getBatch());
		}
		
	
		
		renderer.getBatch().end();
		
		camera.position.set(player.getSprite().getX(), player.getSprite().getY(), 0);
		camera.update();
		
		if (Gdx.input.isKeyPressed(Keys.P)){
				if(!paused) {
					pause();
				} 
		}
		
		if (Gdx.input.isKeyPressed(Keys.U)) {
			if(paused){
				paused = false;
			}		
		}
		
		if (showingDialogue) {
			showingDialogue = npc.showDialogue();
			while(ONE == 1) {
				actorList.remove(npc);
				createItems(); 
				actorList.add(enemy1 = new  Enemy(100, 100, 0, "coin", "Enemy1.png"));
				ONE--;
			}
			
		} else  if(!paused){
			showingDialogue = player.controls(map, npc);
			if (actorList.contains(enemy1)) {
				enemy1.moveEnemy(player);
				
				while(TEN2 == 1) {
					enemy1.attack(player, hud);
					if (player.getHealth() == 0) {
						//GAME OVER SCREEN
					}
					TEN2 = 10;
				}
				TEN2--;
				
				if (Gdx.input.isKeyPressed(Keys.SPACE)) {
					while(TEN == 1) {
						player.attack(enemy1);
						System.out.println("HIT");
						TEN = 10;
					}
					TEN--;
					if (enemy1.dead()) {
						actorList.remove(enemy1);
					}
				}
			}
			if (itemList.contains(hItem)) {
				player.heal(hItem, hud, 0.5f);
			}	
		}
		
		itemCollision(player, itemList);
		changeLevel(8);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		camera.viewportHeight = height;
		camera.viewportWidth = width;
		camera.position.x = player.getSprite().getX();
		camera.position.y = player.getSprite().getY();
		camera.zoom = 0.50f;
		camera.update();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		paused = true; 
		System.out.println("Paused");
		try {
			Thread.sleep(100);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		dispose();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		map.renderMap().dispose();
		renderer.dispose();
		
	}
	
	public OrthographicCamera getCamera() {
		return camera;
	}

	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}
	
	
	//Creates items
	public void createItems() {
		
//		coin.createItem(itemList, 100, 250, "coin.png");
//		coin.createItem(itemList, 228, 250, "coin.png");
//		coin.createItem(itemList, 356, 250, "coin.png");
//		coin.createItem(itemList, 484, 250, "coin.png");
//		coin.createItem(itemList, 575, 250, "coin.png");
//		coin.createItem(itemList, 575, 378, "coin.png");
//		coin.createItem(itemList, 575, 506, "coin.png");
//		coin.createItem(itemList, 575, 634, "coin.png");
			
			itemList.add(new Coin(228, 250, "coin.png"));

			itemList.add(new Coin(356, 250, "coin.png"));
			
			itemList.add(new Coin(484, 250, "coin.png"));
			
			itemList.add(new Coin(575, 250, "coin.png"));
			
			itemList.add(new Coin(575, 378, "coin.png"));
			
			itemList.add(new Coin(575, 506, "coin.png"));
			
			itemList.add(new Coin(575, 634, "coin.png"));
			
			itemList.add(hItem = new HealthItem(575 , 200, "healthItem.png"));
	}
	
	//Item Collision
	//Finds the rectangle bounds (box around the object) and checks if the players bounds overlaps
	//If they overlap, the item is then removed from its list, which means it will not be rendered in the next update
	public void itemCollision(Player p, ArrayList<Item> list) {
		for (int i = 0; i < list.size(); i++) {
			if ((player.getSprite().getBoundingRectangle().overlaps(list.get(i).getSprite().getBoundingRectangle()))) {
				list.remove(i);
				player.setCoins(player.getCoins() + 1);
			}
		}
	}
	
	public void changeLevel(int coins) {
		if (player.getCoins() == coins) {
			game.ShopScreen();
		}
	}
	
	public void createOneActor(Actor a) {
		int i = 1;
		while(i ==1) {
			actorList.add(a);
			i--;
		}
	}
}
