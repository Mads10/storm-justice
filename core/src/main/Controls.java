package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Controls {

//	  public static boolean[] keys = new boolean[65536];
//
//	  // The GLFWKeyCallback class is an abstract method that
//	  // can't be instantiated by itself and must instead be extended
//	  //
//	  @Override
//	  public void invoke(long window, int key, int scancode, int action, int mods) {
//	    keys[key] = action != GLFW_RELEASE;
//	  }
//
//	  // boolean method that returns true if a given key
//	  // is pressed.
//	  public static boolean isKeyDown(int keycode) {
//	    return keys[keycode];
//	  }
//
	  public char[] getNewCommands(/* SimRender sr, Player p */) {
		  char[] inputlist = new char[5]; //set to 5 because that's how many commands we currently have. Expand if we have more.
//			// exit on escape button press
//			if(KeyboardHandler.isKeyDown(GLFW_KEY_ESCAPE))
//				//glfwSetWindowShouldClose(sr.getWindow(), true); // We will detect this in the string loop
//				inputlist[0] = '*';
//
//			if(KeyboardHandler.isKeyDown(GLFW_KEY_UP) || KeyboardHandler.isKeyDown(GLFW_KEY_W)) {
//					//p.setPosY(p.getPosY() + p.getPlayerSpeed());
//				inputlist[1] = 'W';
//			}
//
//			if(this.isKeyDown(GLFW_KEY_RIGHT) || this.isKeyDown(GLFW_KEY_D)) {
//					//p.setPosX(p.getPosX() + p.getPlayerSpeed());
//				inputlist[2] = 'D';
//			}
//
//			if(this.isKeyDown(GLFW_KEY_DOWN) || this.isKeyDown(GLFW_KEY_S)) {
//					//p.setPosY(p.getPosY() - p.getPlayerSpeed());
//				inputlist[3] = 'S';
//			}
//
//			if(this.isKeyDown(GLFW_KEY_LEFT) || this.isKeyDown(GLFW_KEY_A)) {
//					//p.setPosX(p.getPosX() - p.getPlayerSpeed());
//				inputlist[4] = 'A';
//			}
			return inputlist;
		}
}