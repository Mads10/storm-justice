package screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.stormjustice.Run;

public class Settings implements Screen{

	private Run game;
	private Texture background;
	private Stage stage;
	private Skin skin;
	
	//settings
	private Label titleLabel; 
	private Label volumeMusicLabel;
	private Label volumeSoundLabel;
	private Label musicOnOffLabel;
	private Label soundOnOffLabel;
	
	
	
	public Settings(final Run game) {
		
		this.game = game;
		background = new Texture("menuBackground.png");
		skin = new Skin(Gdx.files.internal(Constants.skin));
		stage = new Stage();
	
		Gdx.input.setInputProcessor(stage);
	}
	
    

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		 Button menuButton = new TextButton("Menu",skin,"small");
	        menuButton.setSize(Constants.col_width,Constants.row_height);
	        menuButton.setPosition(Constants.screenHeight - menuButton.getWidth() - 100, Constants.centerY -300 );
	        
	       
	        menuButton.addListener(new InputListener(){
	            @Override
	            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
	                game.MainMenuScreen();
	                return true;
	            }
	        });
	        
	        stage.addActor(menuButton);
	
	}
     	

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
		
		game.getBatch().begin();
		game.getBatch().draw(background,0,50, 1300, 670);
		game.getBatch().end();
		
		
   
        stage.act();
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		skin.dispose();
		stage.dispose();
		background.dispose();
	}

}

	

