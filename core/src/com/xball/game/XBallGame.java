package com.xball.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.xball.actors.Ball;
import com.xball.actors.Wall;
import com.xball.screens.GameScreen;


public class XBallGame extends Game {

	private GameScreen gameScreen;
	private World world;
	private Box2DDebugRenderer debugRenderer;
	private FPSLogger fps_log;

	static final float BOX_STEP=1/60f;  
	static final int BOX_VELOCITY_ITERATIONS=6;  
	static final int BOX_POSITION_ITERATIONS=2;  
	static final float WORLD_TO_BOX=0.01f;  
	static final float BOX_WORLD_TO=100f;  

	@Override
	public void create () {
		setScreen(gameScreen = new GameScreen());
		debugRenderer = new Box2DDebugRenderer();
		fps_log = new FPSLogger();
		world = new World(new Vector2(0,0), false);

		Ball ball2= new Ball(world);
		ball2.start();

		Wall wall = new Wall(world);
		wall.start();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	

		fps_log.log();
		debugRenderer.render(world, gameScreen.getCamera().combined);  
		world.step(BOX_STEP, BOX_VELOCITY_ITERATIONS, BOX_POSITION_ITERATIONS); 
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void dispose() {
		super.dispose();
	}


}
