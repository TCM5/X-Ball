package com.xball.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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
	
	BodyDef bodyDef;
	CircleShape dynamicCircle;
	Body body;
	FixtureDef fixtureDef2;
	
	private Sprite sprite;

	public Ball(World world){
		this.world = world;
	}

	public void start(){
		
		bodyDef = new BodyDef();  
		bodyDef.type = BodyType.DynamicBody;  
		bodyDef.position.set(200,200);  
		sprite = new Sprite(randomColor());
		body = world.createBody(bodyDef);  
		
	
		body.setAngularVelocity(1f);
		
		dynamicCircle = new CircleShape();
		dynamicCircle.setRadius((int)((Gdx.graphics.getWidth()/10)/2));  
		
	
		fixtureDef2 = new FixtureDef();  
		
		body.setLinearVelocity(new Vector2(RANDOM_X, RANDOM_Y));
//		
		fixtureDef2.shape = dynamicCircle;  
		fixtureDef2.density = 1.0f;  
		fixtureDef2.friction = 0.0f;  
		fixtureDef2.restitution = 1;  
		
		body.createFixture(fixtureDef2);
	
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		sprite.setSize((Gdx.graphics.getWidth()/10), (Gdx.graphics.getWidth()/10));
		sprite.setPosition(body.getPosition().x - sprite.getWidth()/2, body.getPosition().y -sprite.getHeight()/2);
//		sprite.setRotation(body.getAngle()* MathUtils.degreesToRadians);
		sprite.draw(batch);
			
		
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}


	private Texture randomColor(){
		int random = MathUtils.random(0, 3);
		switch (random){
		case 0:
			return TextureManager.ball_all;
		case 1:
			return TextureManager.ball_b;
		case 2 :
			return TextureManager.ball_r; 
		case 3: 
			return TextureManager.ball_y;
		}
		return TextureManager.ball_all;
		
	}
	
}
