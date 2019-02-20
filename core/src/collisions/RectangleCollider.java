package collisions;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.*;
import com.badlogic.gdx.math.*;

public class RectangleCollider extends Collider {
	
	/**
	 * Create a CircleCollider given a mapObject;
	 * @param object
	 */
	public RectangleCollider(MapObject object) {
		Rectangle rect = ((RectangleMapObject) object).getRectangle();
		setColliderShape(rect);
	}
	
	/**
	 * Create a RectangleCollider given the centre coordinates, the width and height of the rectangle.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public RectangleCollider(float x, float y, float width, float height) {
		Rectangle rect = new Rectangle(x, y, width, height);
		setColliderShape(rect);
	}
	
	/**
	 * Create a RectangleCollider given a rectangle.
	 * @param rect
	 */
	public RectangleCollider(Rectangle rect) {
		setColliderShape(rect);
	}
	
	/**
	 * Check if this collider intersects with the given rectangle.
	 * @param rectangle
	 * @return
	 */
	public boolean intersects(RectangleCollider rectangle) {
		Rectangle other = (Rectangle) rectangle.getColliderShape();
		if (Intersector.overlaps((Rectangle) this.getColliderShape(), other)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if this collider intersects with the given circle.
	 * @param otherCircle
	 * @return
	 */
	public boolean intersects(CircleCollider otherCircle) {
		Circle other = (Circle) otherCircle.getColliderShape();
		if (Intersector.overlaps(other, (Rectangle) this.getColliderShape())) {
			return true;
		}
		return false;
	}
}
