package com.xball.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Wall {

	World world;

	public Wall(World world) {
		this.world = world;
	}

	public void start(){

		BodyDef bodyDef2 = new BodyDef();  
		bodyDef2.type = BodyType.StaticBody;  
		bodyDef2.position.set(0, 10f);  
		Body body2 = world.createBody(bodyDef2);  
		PolygonShape dynamicCircle2 = new PolygonShape();
	
		dynamicCircle2.setAsBox(Gdx.graphics.getWidth(), 10f); 
		FixtureDef fixtureDef2 = new FixtureDef();  
		fixtureDef2.shape = dynamicCircle2;  
		body2.createFixture(fixtureDef2);  
		
////////////////////////////////////////////
		BodyDef bodyDef3 = new BodyDef();  
		bodyDef3.type = BodyType.StaticBody;  
		bodyDef3.position.set(0, Gdx.graphics.getHeight() -10f);  
		Body body3 = world.createBody(bodyDef3);  
		PolygonShape dynamicCircle3= new PolygonShape();
	
		dynamicCircle3.setAsBox(Gdx.graphics.getWidth(), 10f); 
		FixtureDef fixtureDef3 = new FixtureDef();  
		fixtureDef3.shape = dynamicCircle3;  
		body3.createFixture(fixtureDef3);  
		
		///////////////////////////////////////////
		BodyDef bodyDef4 = new BodyDef();  
		bodyDef4.type = BodyType.StaticBody;  
		bodyDef4.position.set(10f, 0);  
		Body body4 = world.createBody(bodyDef4);  
		PolygonShape dynamicCircle4 = new PolygonShape();
	
		dynamicCircle4.setAsBox(10f, Gdx.graphics.getHeight()); 
		FixtureDef fixtureDef4= new FixtureDef();  
		fixtureDef4.shape = dynamicCircle4;  
		body4.createFixture(fixtureDef4);  
//		////////////////////////////////////////////
		BodyDef bodyDef5 = new BodyDef();  
		bodyDef5.type = BodyType.StaticBody;  
		bodyDef5.position.set(Gdx.graphics.getWidth()-10f, 0);  
		Body body5 = world.createBody(bodyDef5);  
		PolygonShape dynamicCircle5 = new PolygonShape();
	
		dynamicCircle5.setAsBox(10f, Gdx.graphics.getHeight()); 
		FixtureDef fixtureDef5 = new FixtureDef();  
		fixtureDef5.shape = dynamicCircle5;  
		body5.createFixture(fixtureDef5);  
		/////////////////////////////////////
	
	}
	
}
