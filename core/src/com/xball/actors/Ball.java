package com.xball.actors;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.xball.game.TextureManager;
import com.xball.statics.Sizes;

public class Ball extends Actor{

	private static  float initX = MathUtils.random(0, Sizes.WIDTH - TextureManager.PLAYER.getWidth());
	private static float initY = Sizes.HEIGHT + TextureManager.PLAYER.getHeight();
	private static float speedY = -MathUtils.random(0,3);
	private int test;

	public Ball(){
		super(TextureManager.PLAYER, new Vector2(initX, initY), new Vector2(0,speedY));
		System.out.println(initX);
	}

	@Override
	public void update(){
		pos.add(direction);
	}






}
