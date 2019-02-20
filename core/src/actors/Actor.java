package actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Actor extends Sprite {

	protected float posX;
	protected float posY;
	protected int state;
	protected boolean hasChanged;
	
	protected float speed = 3.0f;
	
	Sprite sprite;


	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public Actor(float X, float Y, int state) {
		posX = X;
		posY = Y;
		this.state = state;
	}

	public float getX() {
		return posX;
	}

	public void setX(float posX) {
		if(this.posX != posX){
			hasChanged = true;
		}
		this.posX = posX;
	}

	public float getY() {
		return posY;
	}

	public void setY(float posY) {
		if(this.posY != posY){
			hasChanged = true;
		}
		this.posY = posY;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		if(this.state != state){
			hasChanged = true;
		}
		this.state = state;
		hasChanged = true;
	}
	
	public void moveLeft() {
		// TODO Auto-generated method stub
		getSprite().setX(getSprite().getX() - getSpeed());
	}

	public void moveRight() {
		// TODO Auto-generated method stub
		getSprite().setX(getSprite().getX() + getSpeed());
	}

	public void moveUp() {
		// TODO Auto-generated method stub
		getSprite().setY(getSprite().getY() + getSpeed());
	}

	public void moveDown() {
		// TODO Auto-generated method stub
		getSprite().setY(getSprite().getY() - getSpeed());
	}

	public void change(){
		hasChanged = false;
	}

	public boolean getHasChanged(){
		return hasChanged;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}