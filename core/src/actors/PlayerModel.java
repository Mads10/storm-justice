package actors;

public class PlayerModel extends Actor {

	private double speed;

	public PlayerModel(double X, double Y, int state) {
		super(X, Y, state);
		setSpeed(5);
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

}
