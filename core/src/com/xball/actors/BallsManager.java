package com.xball.actors;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.xball.game.TextureManager;
import com.xball.statics.Sizes;

public class BallsManager {

//	private final float initX = MathUtils.random(0, Sizes.WIDTH - TextureManager.PLAYER.getWidth());
//	private final float initY = Sizes.HEIGHT + TextureManager.PLAYER.getHeight();
//	private final float speedY = -MathUtils.random(0,3);

	private ArrayList<Ball> balls = new ArrayList<Ball>();

	public BallsManager() {
		initPosition();
		System.out.println(TextureManager.PLAYER.getHeight());
	}

	private void initPosition(){

		for(int i = 0; i < 10 ; i++){
			balls.add(new Ball());
		}
	}

	public void update(){
		for(Ball ball : balls){
			ball.update();
		}

	}

	public void render(SpriteBatch sb){
		for(Ball ball : balls){
			ball.render(sb);
		}
	}

}
