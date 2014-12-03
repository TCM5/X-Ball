package com.xball.actors;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.xball.game.TextureManager;
import com.xball.statics.Sizes;

public class BallsManager {

	private ArrayList<Ball> balls = new ArrayList<Ball>();

	public BallsManager() {
		initPosition();



	}

	private void initPosition(){

		for(int i = 0; i < 5 ; i++){
			float x = MathUtils.random(0, Sizes.WIDTH - TextureManager.PLAYER.getWidth());
			balls.add(new Ball(new Vector2(x, Sizes.HEIGHT - TextureManager.PLAYER.getHeight()*2), new Vector2(0,
					-MathUtils.random(1,2))));
		}		
	}

	private void checkCollision(){
		for(Ball ball: balls){

			if(ball.getPosition().y <= 0 ){
				ball.setDirection(0, ball.getInitDir().y*-1);
			}

			if(ball.getPosition().y >= Sizes.HEIGHT - TextureManager.PLAYER.getHeight() ){
				ball.setDirection(0, ball.getInitDir().y*-1);
			}
		}
	}

	public void update(){
		for(Ball ball : balls){
			ball.update();
			checkCollision();
		}

	}

	public void render(SpriteBatch sb){
		for(Ball ball : balls){
			ball.render(sb);
		}
	}

}
