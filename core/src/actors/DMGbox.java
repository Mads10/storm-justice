package actors;

public abstract class DMGbox extends Actor {

	/*
	 * An item representing the swing of weapons, or projectiles.
	 */
	
	private char alignment;
	
	public DMGbox(double X, double Y, int state, char alignment) {
		super(X, Y, state);
		this.alignment = alignment;
	}

	public char getAlignment() {
		return alignment;
	}
	
	public void setAlignment(char newAlign) {
		alignment = newAlign;
	}

	/*
	 * Alignment : Who the box hurts
	 * g = good (hurts enemies)
	 * e = evil (hurts player)
	 * p = passive (won't hurt anyone)
	 * d = deadly (hurts all beings)
	 * x = deflecting (kills all other DMGboxes)
	 * o = overriding (kills all DMGboxes and hurts all beings)
	 * more can be added as needed.
	 * Might want to change to a class of its own, if complexity becomes significant. Could also apply to other actors.
	 */
}
