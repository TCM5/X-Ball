package com.xball.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.xball.managers.TextureManager;

public class Ball extends Actor{
	private World world;
	private int RANDOM_X = MathUtils.random(50, 100);
	private int RANDOM_Y = MathUtils.random(50, 100);

	public Ball(World world){
		this.world = world;
	}

	public void start(){
		BodyDef bodyDef2 = new BodyDef();  

		bodyDef2.type = BodyType.DynamicBody;  
		bodyDef2.position.set(200,200);  
		Body body2 = world.createBody(bodyDef2);  
		CircleShape dynamicCircle2 = new CircleShape();

		dynamicCircle2.setRadius(15f);  
		FixtureDef fixtureDef2 = new FixtureDef();  
		body2.setLinearVelocity(new Vector2(RANDOM_X, RANDOM_Y));
		fixtureDef2.shape = dynamicCircle2;  
		fixtureDef2.density = 1.0f;  
		fixtureDef2.friction = 0.0f;  
		fixtureDef2.restitution = 1;  
		body2.createFixture(fixtureDef2);  

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.begin();
		batch.draw(TextureManager.PLAYER, 0, 0);
		batch.end();


	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
	}




}
