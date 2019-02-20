package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.stormjustice.Run;

public class Pause implements Screen {
	
	private final Run game;
	private Stage stage;
	private Skin skin;
	
    public Pause(final Run game) {
		
		this.game = game;
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		createPauseButtons(stage);
		
		
  }
    
    public void createPauseButtons(Stage stage){
		

//		   Button PauseButton = new TextButton("RESUME",skin,"default");
//		   PauseButton.setSize(Constants.col_width * 2, Constants.row_height);
//		   PauseButton.setPosition(Constants.centerX - PauseButton.getWidth() / 2,
//	                Constants.centerY);
//
//		   PauseButton.addListener(new InputListener()
//	        {
//	            @Override
//	            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
//	            {
//	                game.SimRenderScreen();
//	                dispose();
//	                return true;
//	            }
//	        });

    	
//    	 Button menuButton = new TextButton("Menu",skin,"small");
//	        menuButton.setSize(Constants.col_width,Constants.row_height);
//	        menuButton.setPosition(Constants.screenHeight - menuButton.getWidth() - 100, Constants.centerY -300 );
//	        
//	       
//	        menuButton.addListener(new InputListener(){
//	            @Override
//	            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//	                game.MainMenuScreen();
//	                return true;
//	            }
//	        });
//	        
//	        stage.addActor(menuButton);
//          stage.addActor(PauseButton);
    	
    	
    	
	}
    
    
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1f, 1f, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
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
		
	}

}
