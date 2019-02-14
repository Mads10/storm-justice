package collisions;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

public class RayCast {
	//The distance of the vector.
	private float distance;
	//The ray collider object.
	private Ray ray;
	//Current origin and direction.
	private Vector3 currentOrigin;
	private Vector3 currentDirection;
	

	public RayCast(float distance, Vector2 origin, Vector2 direction) {
		this.distance = distance;
		//Converting 2D Vectors to 3D (fake 2D) vectors.
		currentOrigin = new Vector3(origin.x, 0, origin.y);
		currentDirection = new Vector3(direction.x, 0, direction.y);
		//Create ray.
		this.ray = new Ray(currentOrigin, currentDirection);
	}
	
	/**
	 * Return the vector of the ray, which is the end point of the ray.
	 * @return
	 */
	public Vector2 getVector2D() {
		Vector3 out = null;
		ray.getEndPoint(out, distance);
		return new Vector2(out.x, out.z);
	}
	
	/**
	 * Return the vector of the ray, which is the end point of the ray.
	 * @return
	 */
	public Vector3 getVector3D() {
		Vector3 out = null;
		ray.getEndPoint(out, distance);
		return out;
	}
	
	/**
	 * Set the origin of the vector.
	 * @param origin
	 */
	public void setOrigin(Vector2 origin) {
		currentOrigin = new Vector3(origin.x, 0, origin.y);
		ray.set(currentOrigin, currentDirection);
	}
	
	/**
	 * Set the direction of the vector.
	 * @param direction
	 */
	public void setDirection(Vector2 direction) {
		currentDirection = new Vector3(direction.x, 0, direction.y);
		ray.set(currentOrigin, currentDirection);
	}
	
	/**
	 * Set both direction and origin of the vector.
	 */
	public void setOriginAndDirection(Vector2 origin, Vector2 direction) {
		currentDirection = new Vector3(direction.x, 0, direction.y);
		currentOrigin = new Vector3(origin.x, 0, origin.y);
		ray.set(currentOrigin, currentDirection);
	}
}
