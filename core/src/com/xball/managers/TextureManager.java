package com.xball.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

@Deprecated
public class TextureManager {

	public static Texture PLAYER = new Texture(Gdx.files.internal("ball.png"));
	public static Texture TESTING = new Texture(Gdx.files.internal("test.png"));
}