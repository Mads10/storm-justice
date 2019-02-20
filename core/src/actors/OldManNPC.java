package actors;

public class OldManNPC extends NPC {

	private static String spritePath = "npc.png";
	
	public OldManNPC(float X, float Y, int state) {
		super(X, Y, state, spritePath);
		
		String[] dialogue = new String[] {
				"Lorem",
				"ipsum",
				"dolor",
				"sit..."
		};
		
		super.setDialogue(dialogue);
	}
}
