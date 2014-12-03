package com.xball.actors;

import com.badlogic.gdx.math.Vector2;
import com.xball.game.TextureManager;

public class Ball extends Actor{


	public Ball(Vector2 pos, Vector2 dir){
		super(TextureManager.PLAYER,pos,dir);
		
	}

	@Override
	public void update(){
		pos.add(direction);
		}
	

	




}
