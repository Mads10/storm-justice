package main;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import actors.Enemy;
import actors.NPC;
import map.Map;

import collisions.RayCast;
import collisions.RectangleCollider;

public class Player extends Sprite{
	
	//velocity of player
	private float speed = 5.0f;
	private float runningSpeed = 7.5f;
	private float health = 1.0f;
	
	private int coins = 0;
	
	private float playerX;
	private float playerY;
	
	private RayCast forwardVector;
	
	private Texture texture = new Texture(Gdx.files.internal("playerSprite.png"));
	private Sprite sprite = new Sprite(texture);
	

	private static final int FRAMECOLS = 3, FRAMEROWS = 4;
	
	Animation<TextureRegion> walkAnimation;
	Texture walkSheet;
	TextureRegion region;
	float stateTime;

	public Player(float x, float y) {
		playerX = x;
		playerY = y;
		this.sprite.setPosition(x, y);
	}
	
	public void createAnimation() {

		// Load the sprite sheet as a Texture
		walkSheet = new Texture(Gdx.files.internal("walking.png"));

		// Use the split utility method to create a 2D array of TextureRegions. This is 
		// possible because this sprite sheet contains frames of equal size and they are 
		// all aligned.
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, 
				walkSheet.getWidth() / FRAMECOLS,
				walkSheet.getHeight() / FRAMEROWS);

		// Place the regions into a 1D array in the correct order, starting from the top 
		// left, going across first. The Animation constructor requires a 1D array.
		TextureRegion[] walkFrames = new TextureRegion[FRAMECOLS * FRAMEROWS];
		int index = 0;
		for (int i = 0; i < FRAMEROWS; i++) {
			for (int j = 0; j < FRAMECOLS; j++) {
				walkFrames[index++] = tmp[i][j];
			}
		}

		// Initialize the Animation with the frame interval and array of frames
		walkAnimation = new Animation(0.025f, walkFrames);
		
		stateTime = 0f;
		region=walkAnimation.getKeyFrame(0);
	}
	
	public void act(float delta) {
		stateTime += delta;
		region = walkAnimation.getKeyFrame(stateTime, true);
	}
	
	@Override
	public void draw(Batch batch) {
		batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getRunningSpeed() {
		return runningSpeed;
	}

	public void setRunningSpeed(float runningSpeed) {
		this.runningSpeed = runningSpeed;
	}

	public RayCast getRay() {
		// TODO Auto-generated method stub
		return forwardVector;
	}
	
	public void resetForwardVector() {
		forwardVector = new RayCast(getSprite().getX(), getSprite().getY(), getSprite().getX(), getSprite().getY());
	}
	
	public void move(String direction) {
		//Set the x and y position of the player to the end point of the forwardVector.
		
		//float[] currentEndPosition = forwardVector.getEndPos();
		
		if (direction == "LEFT") {
			forwardVector.setEndPos(getSprite().getX() - getRunningSpeed(), getSprite().getY());
		} else if (direction == "RIGHT") {
			forwardVector.setEndPos(getSprite().getX() + getRunningSpeed(), getSprite().getY());
		} else if (direction == "UP") {
			forwardVector.setEndPos(getSprite().getX(), getSprite().getY() + getRunningSpeed());
		} else if (direction == "DOWN") {
			forwardVector.setEndPos(getSprite().getX(), getSprite().getY() - getRunningSpeed());
		}
	}
	
	public RectangleCollider getCollider() {
		return new RectangleCollider(sprite.getBoundingRectangle());
	}
	
	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	public boolean showInventory() {
		boolean showingInventory = false;
		if (Gdx.input.isKeyPressed(Keys.I)) {
			showingInventory = true;
		}
		return showingInventory;
	}
	
	public boolean controls(Map map, NPC npc) {
		boolean showingDialogue = false;
		resetForwardVector();
		
		if (Gdx.input.isKeyPressed(Keys.A)) {
			move("LEFT");
			if (!map.checkCollisions(this)) {
				moveLeft();
			}

		} 
		if (Gdx.input.isKeyPressed(Keys.D)) {
			move("RIGHT");
			if (!map.checkCollisions(this)) {
				moveRight();
			}

		}
		if (Gdx.input.isKeyPressed(Keys.W)) {
			move("UP");
			if (!map.checkCollisions(this)) {
				moveUp();
			}
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			move("DOWN");
			if (!map.checkCollisions(this)) {
				moveDown();
			}
		}
		
		if (getCollider().intersects(npc.getTalkingCollider())) {
			if (Gdx.input.isKeyPressed(Keys.ENTER)) {
				showingDialogue = true;
			}
		}
		return showingDialogue;
	}
	public void moveLeft() {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
			getSprite().setX(getSprite().getX() - getRunningSpeed());
		} else {
			getSprite().setX(getSprite().getX() - getSpeed());
		}
	}

	public void moveRight() {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
			getSprite().setX(getSprite().getX() + getRunningSpeed());
		} else {
			getSprite().setX(getSprite().getX() + getSpeed());
		}
	}

	public void moveUp() {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
			getSprite().setY(getSprite().getY() + getRunningSpeed());
		} else {
			getSprite().setY(getSprite().getY() + getSpeed());
		}
	}

	public void moveDown() {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
			getSprite().setY(getSprite().getY() - getRunningSpeed());
		} else {
			getSprite().setY(getSprite().getY() - getSpeed());
		}
	}
	
	public void attack(Enemy enemy) {
		if (enemy.getSprite().getBoundingRectangle().overlaps(this.getSprite().getBoundingRectangle())) {
			enemy.setHealth(enemy.getHealth() - 25);
		}
	}

	public float getHealth() {
		return health;
	}

	public void setHealth(float health) {
		this.health = health;
	}

	public TextureRegion getRegion() {
		return region;
	}

	public void setRegion(TextureRegion region) {
		this.region = region;
	}
	
	
}
