package actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import collisions.RectangleCollider;
import screen.DialogueScreen;

public class NPC extends Actor {
	
	private DialogueScreen dialogue;
	private String[] NPCDialogue;
	
	private RectangleCollider talkingDistance;
	
	private Texture texture;
	private Sprite sprite;
	
	protected NPC(float X, float Y, int state, String texturePath) {
		super(X, Y, state);
		
		texture = new Texture(Gdx.files.internal(texturePath));
		sprite = new Sprite(texture);
		
		dialogue = new DialogueScreen();
		sprite.setX((float) X);
		sprite.setY((float) Y);
		
		System.out.println(sprite.getHeight());
		System.out.println(sprite.getWidth());
		
		Rectangle rect = sprite.getBoundingRectangle();
		
		//Adjust the bounding box.
		rect.setSize(rect.getWidth()*3, rect.getHeight()*3);
		rect.setY(rect.getY() - rect.getHeight() / 2);
		rect.setX(rect.getX() - rect.getWidth() / 2);
		
		talkingDistance = new RectangleCollider(rect);
		
	}
	
	/**
	 * Show the NPC's dialogue.
	 */
	public boolean showDialogue () {
		//Render the dialogue screen.
		dialogue.render(0f);
		if (dialogue.isCompleted()) {
			dialogue.reset();
			return false;
		}
		else { 
			return true;
		}
	}
	
	/**
	 * Get the collider object that represents the NPC's talkingDistance.
	 * @return
	 */
	public RectangleCollider getTalkingCollider() {
		return talkingDistance;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	/**
	 * Set the dialogue for this NPC.
	 * @param dialogue
	 */
	protected void setDialogue(String[] dialogue) {
		this.dialogue.setDialogue(dialogue);
		System.out.println();
	}

	public DialogueScreen getDialogue() {
		return dialogue;
	}
	
}
