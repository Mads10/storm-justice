package actors;

public class Postcard extends NPC{
	
	private static String spritePath = "postcard.png";

	public Postcard(float X, float Y, int state) {
		super(X, Y, state, spritePath);
		
		String[] dialogue = new String[] {
				"Some words to explain the story before the game",
				"Then something about the mafia/enemies",
				"Then something about the shop and who to meet",
				"COLLECT THE COINS AND DEFEAT THE ENEMINES TO CONTINUE..."
		};
		
		super.setDialogue(dialogue);

	}

}
