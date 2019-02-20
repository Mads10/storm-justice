package map;

import java.util.ArrayList;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import collisions.Collider;
import collisions.RayCast;
import main.Player;

public class Map {
	
	//Map data, including entities and colliders.
	//private ArrayList<Scene> scenes;
	//private ArrayList<Entity> entities;
	private ArrayList<Collider> colliders;
	
	//The texture representing the map
	private TiledMap map;
	private String mapPath;
	
	
	public Map (String mapPath) {
		TmxMapLoader loader = new TmxMapLoader();
		map = loader.load(mapPath);
		
		colliders = new ArrayList<Collider>();
		
		MapLayer collisionLayer = map.getLayers().get("collisions");
		MapObjects colliderObjects = collisionLayer.getObjects();
		try {
			for (MapObject colliderObject : colliderObjects) {
				Collider collider = Collider.createCollider(colliderObject);
				colliders.add(collider);
				System.out.println(colliders.toString());
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Provides the data for the map to be rendered.
	 */
	public TiledMap renderMap() {
		/*
		 * Is this all that is required?
		 */

		return map;
	}
	
	/**
	 * Collision check for the player. Detects if the player's forward vector (rayCast) is within the bounds of any of the boxes.
	 * @param player
	 * @return
	 */
	public boolean checkCollisions(Player p) {
		/*
		 * TODO:: Think about colliders within proximity of the given entity to reduce the memory/processing required.
		 */
		RayCast ray = p.getRay();
		float[] point = ray.getEndPos();
		//System.out.println("(" + point[0] + ", " + point[1] + ")");
		for (Collider collider : colliders) {
			if (collider.vertexIntersection(point[0], point[1])) {
				return true;
			}
		}
		
		return false;
	}
}
