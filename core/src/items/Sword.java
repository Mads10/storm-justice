package items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Sword implements Item{
	
	public Texture texture;
	public Sprite sprite;

	public Sword(float X, float Y, String textureFilePath) {
		// TODO Auto-generated constructor stub
		texture = new Texture(textureFilePath);
		sprite = new Sprite(texture);
		this.sprite.setPosition(X, Y);
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return texture;
	}

	@Override
	public void setTexture(Texture texture) {
		// TODO Auto-generated method stub
		this.texture = texture;
	}

	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return sprite;
	}

	@Override
	public void setSprite(Sprite sprite) {
		// TODO Auto-generated method stub
		this.sprite = sprite;
	}

}
