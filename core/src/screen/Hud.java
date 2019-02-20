package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import main.Player;

public class Hud {
	public Stage stage;
	private com.badlogic.gdx.utils.viewport.Viewport viewPort;

	private HealthBar health;

	public Hud(SpriteBatch batch, float x, float y) {
		viewPort = new com.badlogic.gdx.utils.viewport.FitViewport(1280.0F, 960.0F);
		stage = new Stage(this.viewPort, batch);

		Table table = new Table();
		table.top();
		table.setFillParent(true);

		health = new HealthBar(145, 8);
		health.getHealth();

		health.setPosition(x, y);
		stage.addActor(table);
		stage.addActor(this.health);
	}

	public void resetHealth() {
		health.setValue(1.0F);
	}

	public void reduceHealth(float hitValue) {
		health.setValue(health.getValue() - hitValue);
	}

	public float getHealth() {
		return health.getValue();
	}
}
