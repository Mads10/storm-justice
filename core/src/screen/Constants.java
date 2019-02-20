package screen;

import com.badlogic.gdx.Gdx;

public class Constants {
	
	public static final int screenWidth = 
			Gdx.graphics.getWidth();
    public static final int screenHeight = 
    		    Gdx.graphics.getHeight();
    
    //Setting the position of the buttons
    public static final int centerX = screenWidth / 2;
    public static final int centerY = screenHeight / 2;

    //Setting the size of the buttons
    public static final int col_width = screenWidth / 8;
    public static final int row_height = screenHeight / 8;
    
    public static final String skin = "skins/glassy-ui.json";
    public static final String skinAtlas = "skins/ui-orange.atlas";

  //Setting position of toggle music on/off buttons
    public static final int musicX = 1220;
    public static final int musicY = 620;
}
