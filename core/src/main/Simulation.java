package main;

import actors.*;
import java.util.ArrayList;

public class Simulation {

	private PlayerModel p1;
	private ArrayList<Actor> entities;

	public Simulation(){
		p1 = new PlayerModel(0, 0, 1);
		entities = new ArrayList<Actor>();
		entities.add(p1);
	}

	public void addInput(char cmd) {
		// TODO Auto-generated method stub
		if(cmd == 'w'){
			p1.setY(p1.getY()+p1.getSpeed());
		}
		if(cmd == 's'){
			p1.setY(p1.getY()-p1.getSpeed());
		}
		if(cmd == 'a'){
			p1.setX(p1.getX()-p1.getSpeed());
		}
		if(cmd == 'd'){
			p1.setX(p1.getX()+p1.getSpeed());
		}
	}


	public void moveAI(){
		//Placeholder for now : eventually, move all AI and projectiles.
	}

	public ArrayList<Actor> getChangedActors(){
		ArrayList<Actor> changedActors = new ArrayList<Actor>();
		for(Actor a : entities){
			if(a.getHasChanged()){
				a.change();
				changedActors.add(a);
			}
		}
		return changedActors;
	}

	public int getPlayerHealthStatus(int player){ //this method may need fixing, it's hardcoded restrictively right now.
		if(p1.getState() == 2){ //2 is placeholder, referring to the state the player is in if they have just taken damage
			return -1;
		}
		else if(p1.getState() == 3){ //Again, placeholder for if the player has just healed.
			return 1;
		}
		else{
			return 0;
		}
	}



}
