package com.xball.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.xball.managers.TextureManager;

public class LoadingScreen extends AbstractScreen{
	private Stage stage;
	private Texture texture;
	private Image loading_image;

	public LoadingScreen() {
		super();
		texture = TextureManager.SPLASH;
		loading_image = new Image(texture);
		stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0,0,1); 
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 

		stage.act(delta); 
		stage.draw(); 
	}

	@Override
	public void show() {
		loading_image.setPosition((Gdx.graphics.getWidth()/2) - loading_image.getWidth()/2,
				(Gdx.graphics.getHeight()/2) - loading_image.getHeight()/2);

		loading_image.addAction(Actions.sequence(Actions.alpha(0)
				,Actions.fadeIn(4f),Actions.delay(2),Actions.fadeOut(2f),Actions.run(new Runnable() {
					@Override
					public void run() {
						((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen());
						System.out.println("LOL");
					}
				})));
		stage.addActor(loading_image);
	}

	@Override
	public void dispose() {
		super.dispose();
		texture.dispose();
		stage.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		stage.getViewport().update(width, height, true);
	}


}
