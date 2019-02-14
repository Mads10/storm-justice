package actors;

public class Enemy extends Actor {

	private Item item;
	
	public Enemy(double X, double Y, int state) {
		super(X, Y, state);
		
	}
	
	public Enemy(double X, double Y, int state, Item carriedItem) {
		super(X, Y, state);
		item = carriedItem;
	}

	public void giveItem(Item item) {
		this.item = item;
	}
	
	public boolean removeItem() {
		if(item == null) {
			return false;
		}
		else {
			item = null;
			return true;
		}
	}
	
	
}
