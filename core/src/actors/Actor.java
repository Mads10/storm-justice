package actors;

public abstract class Actor {

	protected double posX;
	protected double posY;
	protected int state;
	protected boolean hasChanged;


	public Actor(double X, double Y, int state) {
		posX = X;
		posY = Y;
		this.state = state;
		hasChanged = true;
	}

	public double getX() {
		return posX;
	}

	public void setX(double posX) {
		if(this.posX != posX){
			hasChanged = true;
		}
		this.posX = posX;
	}

	public double getY() {
		return posY;
	}

	public void setY(double posY) {
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

	public void change(){
		hasChanged = false;
	}

	public boolean getHasChanged(){
		return hasChanged;
	}

}