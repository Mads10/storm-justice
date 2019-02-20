package collisions;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.*;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;


public abstract class Collider {
	
	private Shape2D colliderShape;
		
	protected Collider() {}
	
	/**
	 * Method to instantiate a colliderType given a MapObject, detects the type of map object and reacts accordingly.
	 * @param object
	 * @return
	 * @throws IllegalStateException
	 */
	public static Collider createCollider(MapObject object) throws IllegalStateException {
		if (object instanceof RectangleMapObject) {
			return new RectangleCollider(object);
		} else if (object instanceof EllipseMapObject) {
			return new CircleCollider(object);
		} else if (object instanceof PolygonMapObject) {
			return new PolygonCollider(object);
		} else {
			System.out.println(object.getClass());
			throw new IllegalStateException("The type of collider object is not supported.");
		}
	}
	
	
	/**
	 * Check if a point is within the polygon given the coordinates of that point.
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean vertexIntersection(float x, float y) {
		if (getColliderShape().contains(x, y)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if a point is within a polygon given the Vector2 representing that point.
	 * @param vector 
	 * @return
	 */
	public boolean vertexIntersection(Vector2 vector) {
		if (getColliderShape().contains(vector)) {
			return true;
		}
		return false;
	}
	
	protected void setColliderShape(Shape2D shape) {
		colliderShape = shape;
	}
	
	protected Shape2D getColliderShape() {
		return colliderShape;
	}
	//public boolean intersection();
	
}
