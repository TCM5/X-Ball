package com.xball.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.xball.actors.BallsManager;
import com.xball.camera.OrthoCamera;

public class GameScreen extends Screen{

	private OrthoCamera camera;
	private BallsManager ballM;


	@Override
	public void create() {
		camera = new OrthoCamera();
		ballM = new BallsManager();
	}



	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		ballM.render(sb);
		sb.end();

	}
	@Override
	public void update() {

		camera.update();
		ballM.update();
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