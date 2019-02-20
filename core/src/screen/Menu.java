package screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.stormjustice.Run;

public class Menu implements Screen{

	private final Run game;
   

	private Texture background;
	private Stage stage;
	private Skin skin;
	private Texture logo;
	
	

	public Menu(final Run game) {
		
		this.game = game;
		background = new Texture("menuBackground.png");
		logo = new Texture("StormJustice.png");
		skin = new Skin(Gdx.files.internal(Constants.skin));
		stage = new Stage();
		
		
	
		Gdx.input.setInputProcessor(stage);
		createMenuButtons(stage);
		
        
		
	}
	
	public void createMenuButtons(Stage stage){
		Button PlayButton = new TextButton("Play Game",skin,"small");
        PlayButton.setSize(Constants.col_width * 2, Constants.row_height);
        PlayButton.setPosition(Constants.centerX - PlayButton.getWidth() / 2, Constants.centerY -200);

        PlayButton.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                game.Level1Screen();
                return true;
            }
        });
        
        
        Button SettingsButton = new TextButton("Settings",skin,"small");
        SettingsButton.setSize(Constants.col_width * 2, Constants.row_height);
        SettingsButton.setPosition(Constants.centerX - SettingsButton.getWidth() / 2, PlayButton.getY()- Constants.row_height -15);
        
        SettingsButton.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                game.SettingsScreen();
                return true;
            }
        });

        stage.addActor(PlayButton);
        stage.addActor(SettingsButton);
        
        
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
	
		
		game.getBatch().begin();
		game.getBatch().draw(background,0,50, 1300, 800);
		game.getBatch().end();
		
		game.getBatch().begin();
		game.getBatch().draw(logo,Run.WIDTH/2 - (logo.getWidth()*3)/3,400,750, 450);
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
