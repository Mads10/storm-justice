package items;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Coin implements Item {
	
	public Texture texture;
	public Sprite sprite;

	public Coin(float X, float Y, String textureFilePath) {
		// TODO Auto-generated constructor stub
		texture = new Texture(textureFilePath);
		sprite = new Sprite(texture);
		this.sprite.setPosition(X, Y);
	}

	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	@Override
	public Sprite getSprite() {
		return sprite;
	}

	@Override
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public void createItem(ArrayList<Item> list, int x, int y, String filePath) {
		list.add(new Coin(x, y, filePath));
		
	}

}
