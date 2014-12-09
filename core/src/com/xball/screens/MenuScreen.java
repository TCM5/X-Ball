package com.xball.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MenuScreen extends AbstractScreen{

	private Stage stage;
	private Table table;
	private TextButton start, credits;
	private Skin skin;

	public MenuScreen(){
		stage = new Stage();
		skin = new Skin();

		table = new Table();
		start = new TextButton("START", skin);
		credits = new TextButton("TEXT", skin);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		Gdx.gl.glClearColor(1,1,1,1); 
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void show() {
		super.show();

		table.add(start).row();
		table.add(credits).row();

		stage.addActor(table);
	}

	@Override
	public void dispose() {
		super.dispose();
		stage.dispose();
		skin.dispose();
	}
}
