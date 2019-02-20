package items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public interface Item{

	public Texture getTexture();
	
	public void setTexture(Texture texture);

	public Sprite getSprite();
	
	public void setSprite(Sprite sprite);

}
