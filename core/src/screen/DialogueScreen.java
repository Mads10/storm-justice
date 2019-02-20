package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

public class DialogueScreen implements Screen{

	private Stage stage;
	private Skin skin;
	private String[] dialogue;
	
	private TextButton dialogueBox;
	
	private int currentDialogue = 0;
	private String currentText;
	
	public DialogueScreen() {
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.absolute("skins/alagard_by_pix3m-d6awiwp.ttf")); 
		BitmapFont font = generator.generateFont(new FreeTypeFontGenerator.FreeTypeFontParameter());
		generator.dispose();
		
		WindowStyle style = new WindowStyle();
		style.titleFont = font;
		
		skin = new Skin();
		skin.add("Alagard", font);
		skin.add("default", style);
		
		TextureAtlas atlas = new TextureAtlas(new FileHandle("skins/dialogue.atlas"));
		skin.addRegions(atlas);
		skin.load(new FileHandle("skins/dialogue.json"));
		
		dialogueBox = new TextButton("", skin);

		dialogueBox.setPosition(0, 0);
		dialogueBox.getLabel().setAlignment(Align.topLeft);
		dialogueBox.getLabel().setWrap(true);
		dialogueBox.padLeft(100);
		dialogueBox.padRight(100);
		dialogueBox.padTop(75);
		dialogueBox.padBottom(75);
		
		dialogueBox.getBackground();
		
		dialogueBox.setWidth(256*5);
		dialogueBox.setHeight(128*3);
		dialogueBox.setScaleX(5);
		dialogueBox.setScaleY(3);
		
		
		dialogueBox.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				changeText();
			}
			
		});
		
		stage.addActor(dialogueBox);
		
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float arg0) {
		
		Gdx.input.setInputProcessor(stage);
		dialogueBox.setText(currentText);
		stage.draw();
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Set the dialogue screen for this dialogueScreen
	 * @param text
	 */
	public void setDialogue(String[] dialogue) {
		this.dialogue = dialogue;
		currentText = dialogue[0];
		currentDialogue = 0;
	}
	
	public void changeText() {
		this.currentDialogue++;
		if (currentDialogue < dialogue.length) {
			currentText = dialogue[currentDialogue];
		} else {
			currentText = null;
		}
	}
	
	public boolean isCompleted() {
		if (currentText == null) {
			return true;
		}
		return false;
	}
	
	public void reset() {
		currentText = dialogue[0];
		currentDialogue = 0;
	}

}
