package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.stormjustice.Run;

import actors.NPC;
import actors.OldManNPC;
import main.Player;
import map.Map;

public class ShopScreen implements Screen{
	
	Player player;
	Map map;
	NPC npc;
	
	public boolean showingDialogue = false;
	
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	
	private Stage stage;
	private Run game;
	
	public ShopScreen(final Run game) {
		stage = new Stage();
		map = new Map("shopMap.tmx");
		renderer = new OrthogonalTiledMapRenderer(map.renderMap());
		//CAM
		camera = new OrthographicCamera();
		
		player = new Player(50, 550);
		npc = new OldManNPC(300, 685, 0);
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.setView(camera);
		renderer.render();
		
		//Renders Player
		renderer.getBatch().begin();
		player.getSprite().draw(renderer.getBatch());
		npc.getSprite().draw(renderer.getBatch());
		renderer.getBatch().end();
		
		camera.position.set(player.getSprite().getX(), player.getSprite().getY(), 0);
		camera.update();
		
		if (showingDialogue) {
			showingDialogue = npc.showDialogue();
		} else {
			showingDialogue = player.controls(map, npc);
		}
		
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

}
