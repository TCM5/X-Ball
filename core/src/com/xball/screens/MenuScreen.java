package com.xball.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.xball.actors.Ball;
import com.xball.camera.OrthoCamera;

public class MenuScreen extends Screen{

	private OrthoCamera camera;
	private Ball player;


	@Override
	public void create() {
		camera = new OrthoCamera();
		player = new Ball(new Vector2(300, 300));
	}



	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		player.render(sb);
		sb.end();

	}
	@Override
	public void update() {

		camera.update();
		player.update();
	}
	@Override
	public void resize(int width, int height) {
		camera.resize();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}