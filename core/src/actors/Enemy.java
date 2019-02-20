package actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import items.Item;
import main.Player;
import screen.Hud;

public class Enemy extends Actor {

	private String itemName;
	private Item item;
	private float speed = 1.0f;
	private int health = 50;
	
	private final float HITVALUE = 0.1f;
	
	boolean isDead = false;
	
	
	private Texture texture;
	private Sprite sprite;
	
	public Enemy(float X, float Y, int state, String carriedItem, String textureFilePath) {
		super(X, Y, state);
		texture = new Texture(Gdx.files.internal(textureFilePath));
		sprite = new Sprite(texture);
		this.sprite.setPosition(X, Y);
		itemName = carriedItem;
	}

	public void attack(Player player, Hud h) {
		if (player.getSprite().getBoundingRectangle().overlaps(this.getSprite().getBoundingRectangle())) {
			player.setHealth(player.getHealth()-0.1f);
			h.reduceHealth(HITVALUE);
			h.getHealth();
		}
		
	}
	
//	public Item dropItem() {
//		
//		return new Item(getSprite().getX(), 
//				getSprite().getY(), 
//				itemName + ".png");
//	}

	
	public boolean removeItem() {
		if(item == null) {
			return false;
		}
		else {
			item = null;
			return true;
		}
	}
	
	public boolean dead() {
		if (getHealth() <= 0) {
			 setDead(true);
		}
		return isDead;
		
	}
	
	public void moveEnemy(Player p) {
		if (this.getSprite().getX() > p.getSprite().getX()) {
			moveLeft();
		} else if (this.getSprite().getX() < p.getSprite().getX()) {
			moveRight();
		} else if (this.getSprite().getX() == p.getSprite().getX()) {
		}
		
		if (this.getSprite().getY() > p.getSprite().getY()) {
			moveDown();
		} else if (this.getSprite().getY() < p.getSprite().getY()) {
			moveUp();
		} else if (this.getSprite().getY() == p.getSprite().getY()) {
		}
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	
}
