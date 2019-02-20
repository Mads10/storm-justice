package com.stormjustice;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screen.Level1Screen;
import screen.Menu;
import screen.Settings;
import screen.ShopScreen;

public class Run extends Game{

	
	public static final int WIDTH = 1280, Height = 720;
	//creation of all the command objects
	public SpriteBatch batch;
    Texture img;
    private Game game;
    public static AssetManager manager;
	
	public Run() {
	}
	
	@Override
	public void create () {
//		setScreen(render);
		game = this;
		batch = new SpriteBatch();
		this.setScreen(new Menu(this));
		
		manager = new AssetManager();
		manager.load("music.mp3", Music.class);
		manager.finishLoading();
	}
	
	
	@Override
	public void dispose () {
		super.dispose();
	}

	@Override
	public void render () {
		super.render();
	}
	
	public void resize(int width, int height) {
		super.resize(width, height);
	}
	
	public void pause() {
		super.pause();
	}
	
	public void resume() {
		super.resume();
	}
	
    public void Level1Screen() {
      	Level1Screen lvl1 = new Level1Screen(this);
        setScreen(lvl1);
    	
    }
    public void MainMenuScreen() {
    	Menu menu = new Menu(this);
        setScreen(menu);
    	
    }
    
    public void SettingsScreen() {
	    Settings set = new Settings(this);
	    setScreen(set);
    }
    
    public void ShopScreen() {
    	ShopScreen shop = new ShopScreen(this);
    	setScreen(shop);
    }

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	private void next(){
		/*
		 * First, gets a list of commands from the Controls, and pushes them into the simulation queue.
		 * Sim will then read these commands and interpret them.
		 * Commands are stored as char for the sake of storage size and error minimisation.
		 * Queue type recommended for instruction storage in simulation in case of frameskips.
		 */

//		char[] inputs = inputReader.getNewCommands(); //changed from getNextInput in uml to allow for multiple inputs per frame.
//		for(char input : inputs){
//			sim.addInput(input);
//		}

		//sim.parseInputs();//perform all inputs in the queue. If two actions contradict, find a way to pick only one. (i.e. if trying to move left and right at the same time)

		//sim.moveAI(); //instructs the sim to carry out all non-player actions: moving enemies according to their AI, making projectiles continue to move, having actors attack and be created or destroyed as needed.

		/*
		 * Second, retrieves a list of all actors that have moved or changed state from the simulation.
		 * Then passes these changed actors to the render, to be updated.
		 * Optimisation will be important here, as we want to minimise both rendering times and data redundancy.
		 *
		 */

		//ArrayList<Actor> changed = sim.getChangedActors();
		//render.updateActors(changed);

		/*
		 * Thirdly, updates the player health and potentially other stats based on the actions performed this turn.
		 * Then update SimRender with the player stats so it can display them. ***Commented out until we make health a part of the UI***
		 */

		//player1.modHealth(sim.getPlayerHealthStatus(1)); // the '1' is referring to player 1, it can be redundant for now but will help later if we ever try to work out co-op.
		//render.setPlayerHealth(player1.getHealth);

		//Finally, repeats the game loop. Must stay at the end of next.
		//next();
	}


}

	/*
	 * Newly required methods in other classes:
	 * Simulation:
	 * -addInput
	 * -parseInput
	 * -moveAI
	 * -getChangedActors
	 * -getPlayerHealthStatus
	 * SimRender:
	 * updateActors
	 * Controls:
	 * -getNewCommands
	 * player1.modHealth
	 */
