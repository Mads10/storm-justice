package collisions;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.*;
import com.badlogic.gdx.math.*;

public class CircleCollider extends Collider {
	
	/**
	 * Create a CircleCollider given a mapObject;
	 * @param object
	 */
	public CircleCollider(MapObject object) {
		Circle circle = ((CircleMapObject) object).getCircle();
		setColliderShape(circle);
	}
	
	/**
	 * Create a Circle collider given the radius and centre coordinates of the circle.
	 */
	public CircleCollider(float x, float y, float radius) {
		Circle circle = new Circle(x, y, radius);
		setColliderShape(circle);
	}
	
	/**
	 * Create a Circle collider given the radius and Vector2 representing centre.
	 */
	public CircleCollider(Vector2 centre, float radius) {
		Circle circle = new Circle(centre, radius);
		setColliderShape(circle);
	}
	
	/**
	 * Create a Circle collider given the Vector2 representing a point on its circumference and a Vector2 representing centre.
	 */
	public CircleCollider(Vector2 centre, Vector2 edge) {
		Circle circle = new Circle(centre, edge);
		setColliderShape(circle);
	}
	
	/**
	 * Check if this collider intersects with the given rectangle.
	 * @param rectangle
	 * @return
	 */
	public boolean intersects(RectangleCollider rectangle) {
		Rectangle other = (Rectangle) rectangle.getColliderShape();
		if (Intersector.overlaps((Circle) this.getColliderShape(), other)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if this collider intersects with the given rectangle.
	 * @param otherCircle
	 * @return
	 */
	public boolean intersects(CircleCollider otherCircle) {
		Circle other = (Circle) otherCircle.getColliderShape();
		if (Intersector.overlaps((Circle) this.getColliderShape(), other)) {
			return true;
		}
		return false;
	}
}
