package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class SimRender implements Screen{

	Player player;
	
	private TiledMap map;
	
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	
	public SimRender() {
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		//MAP
		TmxMapLoader loader = new TmxMapLoader();
		map = loader.load("mapLibGDX.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		//CAM
		camera = new OrthographicCamera();
		
		player = new Player();
	}
	

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		//Renders window and map
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.setView(camera);
		renderer.render();
		
		//Renders Player
		renderer.getBatch().begin();
		player.getSprite().draw(renderer.getBatch());
		renderer.getBatch().end();
		
		camera.position.set(player.getSprite().getX(), player.getSprite().getY(), 0);
		camera.update();
		
		controls();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		camera.viewportHeight = height;
		camera.viewportWidth = width;
		camera.position.x = player.getSprite().getX();
		camera.position.y = player.getSprite().getY();
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
		map.dispose();
		renderer.dispose();
		
	}
	
	public OrthographicCamera getCamera() {
		return camera;
	}

	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}
	
	public void controls() {
		if (Gdx.input.isKeyPressed(Keys.A)) {
			player.moveLeft();
			System.out.println("A");
		} 
		if (Gdx.input.isKeyPressed(Keys.D)) {
			player.moveRight();
			System.out.println("D");
		}
		if (Gdx.input.isKeyPressed(Keys.W)) {
			player.moveUp();
			System.out.println("W");
			System.out.println(player.getSprite().getY());
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			player.moveDown();
			System.out.println("S");
		}
	}
	
}
