package collisions;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

public class RayCast {
	//The distance of the vector.
	private float distance;
	
	private Vector2 start;
	private Vector2 end;
	private Vector2 directionVector;
	
	public RayCast(float startX, float startY, float endX, float endY) {
		start = new Vector2(startX, startY);
		end = new Vector2(endX, endY);
		
		//directionVector = end.sub(start);
		//distance = directionVector.len();
	}
	
	public void setStartPos(float startX, float startY) {
		start = new Vector2(startX, startY);
		//directionVector = end.sub(start);
		//distance = directionVector.len();
	}
	
	public void setEndPos(float endX, float endY) {
		end = new Vector2(endX, endY);
		//directionVector = end.sub(start);
		//distance = directionVector.len();
	}
	
	public float[] getEndPos() {
		float[] endPoint = new float[] {end.x, end.y};
		return endPoint;
	}
	
}
