package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import collisions.RayCast;

public class Player extends Sprite{
	
	//velocity of player
	private float speed = 2.0f;
	private float runningSpeed = 5.0f;
	private boolean running = Gdx.input.isKeyPressed(Keys.SHIFT_LEFT);
	
	private float playerX;
	private float playerY;
	
	private Texture texture = new Texture(Gdx.files.internal("playerSprite.png"));
	private Sprite sprite = new Sprite(texture);

	public Player() {
		this.sprite.setPosition(1000, 616);
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

	public float getRunningSpeed() {
		return runningSpeed;
	}

	public void setRunningSpeed(float runningSpeed) {
		this.runningSpeed = runningSpeed;
	}

	public RayCast getRay() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
	
}
