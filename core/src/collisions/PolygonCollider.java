package collisions;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.*;
import com.badlogic.gdx.math.*;

public class PolygonCollider extends Collider {
	
	/**
	 * Create a polygon collider given a map object.
	 */
	public PolygonCollider(MapObject object) {
		Polygon polygon = ((PolygonMapObject) object).getPolygon();
		setColliderShape(polygon);
	}
	
	/**
	 * Create a polygon collider given a map object.
	 */
	public PolygonCollider(float[] vertices) {
		setColliderShape(new Polygon(vertices));
	}
	
	/**
	 * Check if two polygons are overlapping.
	 */
	public boolean intersects(PolygonCollider other) {
		Polygon otherPolygon = (Polygon) other.getColliderShape();
		if (Intersector.overlapConvexPolygons((Polygon) getColliderShape(), otherPolygon)) {
			return true;
		}
		return false;
	}
}
