package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.stormjustice.Run;

public class Pause implements Screen {
	
	private final Run game;
	private Level1Screen level1;
	private Stage stage;
	private Skin skin;
	
	private SpriteBatch batch;
	private final int width, height;
	
    public Pause( Run game, Level1Screen gamescreen) {
		// Game and Game dimensions 
		this.game = game;
		width = game.WIDTH;  
		height = game.Height; 
		level1 = gamescreen;
		skin = new Skin(Gdx.files.internal(Constants.skin));
		stage = new Stage();
		
		// SpriteBatch 
		batch = new SpriteBatch();
		
		Gdx.input.setInputProcessor(stage);
		createPauseButtons(stage);
		
  }
    
    public void createPauseButtons(Stage stage) {
		

		   Button ResumeButton = new TextButton("RESUME",skin,"default");
		   ResumeButton.setSize(Constants.col_width * 2, Constants.row_height);
		   ResumeButton.setPosition(Constants.centerX - ResumeButton.getWidth() / 2,
	                Constants.centerY);

		   ResumeButton.addListener(new InputListener()
	        {
	            @Override
	            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
	            {
	               
	               game.Level1Screen();
	                return true;
	            }
	        });
		   
		   Button MenuButton = new TextButton("MainMenu",skin,"default");
		   MenuButton.setSize(Constants.col_width * 2, Constants.row_height);
		   MenuButton.setPosition(Constants.centerX - MenuButton.getWidth() / 2,
	                Constants.centerY - 130);

		   MenuButton.addListener(new InputListener()
	        {
	            @Override
	            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
	            {
	                game.MainMenuScreen();
	                return true;
	            }
	        });
		   
		   Button SettingsButton = new TextButton("Settings",skin,"default");
		   SettingsButton.setSize(Constants.col_width * 2, Constants.row_height);
		   SettingsButton.setPosition(Constants.centerX - SettingsButton.getWidth() / 2,
	                Constants.centerY - 260);

		   SettingsButton.addListener(new InputListener()
	        {
	            @Override
	            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
	            {
	                game.SettingsScreen();
	                return true;
	            }
	        });
		
	        
	      stage.addActor(MenuButton);
          stage.addActor(ResumeButton);
          stage.addActor(SettingsButton);
    	
	}
    
    
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(float delta) {
		
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
		stage.dispose();
		skin.dispose();
		
	}

}
