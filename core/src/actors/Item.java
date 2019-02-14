package actors;

public class Item extends Actor {

	private String name;
	private int id;
	
	public Item(double X, double Y, int state, String itemName, int itemID) {
		super(X, Y, state);
		name = itemName;
		id = itemID;
	}

}
