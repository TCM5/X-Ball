package com.xball.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {

	public static Texture ball_all = new Texture(Gdx.files.internal("ball_all.png"));
	public static Texture ball_b = new Texture(Gdx.files.internal("ball_blue.png"));
	public static Texture ball_r = new Texture(Gdx.files.internal("ball_red.png"));
	public static Texture ball_y = new Texture(Gdx.files.internal("ball_yellow.png"));
	
	
	public static Texture TESTING = new Texture(Gdx.files.internal("test.png"));
	public static Texture SPLASH = new Texture(Gdx.files.internal("splash.png"));
}
