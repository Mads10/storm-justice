package items;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class HealthItem implements Item {
	
	public Texture texture;
	public Sprite sprite;

	
	public HealthItem(int X, int Y, String textureFilePath) {
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


	@Override
	public void createItem(ArrayList<Item> list, int x, int y, String filePath) {
		// TODO Auto-generated method stub
		list.add(new HealthItem(x, y, filePath));
		
	}

}
