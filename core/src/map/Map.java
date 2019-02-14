package map;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import collisions.CircleCollider;
import collisions.Collider;
import collisions.Collider;
import collisions.RayCast;
import collisions.RectangleCollider;

import main.Player;

public class Map {
	
	//Map data, including entities and colliders.
	//private ArrayList<Scene> scenes;
	//private ArrayList<Entity> entities;
	private ArrayList<Collider> colliders;
	
	//The texture representing the map
	//private Texture background;
	private TiledMap map;
	private String mapPath;
	
	//Width and height of maps
	private static final int mapWidth = 40;
	private static final int mapHeight = 40;
	
	public Map (String mapPath, String colliderPath, String entityPath) {
		//background = new Texture(imagePath);
		TmxMapLoader loader = new TmxMapLoader();
		map = loader.load(mapPath);
		
		TiledMapTileLayer collisionLayer = (TiledMapTileLayer) map.getLayers().get("collisions");
		MapObjects colliderObjects = collisionLayer.getObjects();
		try {
			for (MapObject colliderObject : colliderObjects) {
				Collider collider = Collider.createCollider(colliderObject);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		//OLD
		//colliders = CollisionFileReader.readCollisionFile(colliderPath);
	
		//entities = entityFileReader.readEntityFile(entityPath);
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
	 * Iterates over the colliders in the level to determine if the given entity is colliding with any of them.
	 * @param e
	 * @return
	 */
//	public boolean checkCollisions(Player p) {
//		/*
//		 * TODO:: Think about colliders within proximity of the given entity to reduce the memory/processing required.
//		 */
//		/*
//		 * Collider entityCollider = e.getCollider();
//		 
//		for (Collider worldCollider : colliders) {
//			if(worldCollider.checkCollision(entityCollider)) {
//				return true;
//			}
//		}
//		return false;
//		*/
//	
//		RectangleCollider entityCollider = (RectangleCollider) p.getCollider();
//		for (ColliderNew collider : colliders) {
//			if (collider instanceof CircleCollider) {
//				if (((CircleCollider) collider).intersects(entityCollider)) {
//					return true;
//				}
//			} else if (collider instanceof RectangleCollider) {
//				if (((RectangleCollider) collider).intersects(entityCollider)) {
//					return true;
//				}
//			}
//			
//		}
//		return false;
//	}
	
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
		Vector2 point = ray.getVector2D();
		for (Collider collider : colliders) {
			if (collider.vertexIntersection(point)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	/*
	 * Collisions:		
	 * 		Currently using two forms of collisions. May be able to take ideas from previous iteration and apply to the newest one.
	 * 		Goal is to prevent libGDX from being used throughout all classes, by abstracting in some way. Is this necessary with 
	 * 		Rectangle objects? 
	 * 
	 * 	- 2 Collision versions resulted from developed understanding of libGDX.
	 *  - Could still keep wrapper classes.
	 *  - Still have JSONFile reading. Should we keep as reference? Could be useful?
	 *  - Should expand the actors package to be much more of a hierarchy. 
	 * 
	 */
}
