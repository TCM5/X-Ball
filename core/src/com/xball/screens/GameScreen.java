package com.xball.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.xball.actors.Ball;
import com.xball.game.XBallGame;

public class GameScreen extends AbstractScreen{

	private OrthographicCamera camera;
	
	public GameScreen() {
		super();
		
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.position.set(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,0f);
		camera.update();
			}

	@Override
	public void dispose() {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void render(float delta) {
		super.render(delta);
		
	}

	@Override
	public void show() {}

	@Override
	public void hide() {}

	@Override
	public void resize(int width, int height) {}

	public OrthographicCamera getCamera() {
		return camera;
	}

}