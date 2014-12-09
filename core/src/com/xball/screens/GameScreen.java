package com.xball.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.MouseJoint;
import com.badlogic.gdx.physics.box2d.joints.MouseJointDef;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.xball.statics.Config;
import com.xball.actors.Ball;
import com.xball.actors.Wall;

public class GameScreen extends AbstractScreen implements InputProcessor {

	private OrthographicCamera camera;
	private World world;
	private Box2DDebugRenderer debugRenderer;
	private FPSLogger fps_log;
	private ArrayList<Ball> balls = new ArrayList<Ball>();

	SpriteBatch batch;
	int clickeds = 0;

	private BitmapFont font = new BitmapFont();
	private MouseJointDef mjd;
	private MouseJoint joint;

	static final float BOX_STEP=1/60f;  
	static final int BOX_VELOCITY_ITERATIONS=6;  
	static final int BOX_POSITION_ITERATIONS=2;  
	static final float WORLD_TO_BOX=0.01f;  
	static final float BOX_WORLD_TO=100f;  

	public GameScreen() {
		super();
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(this);
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.position.set(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,0f);
		camera.update();

		debugRenderer = new Box2DDebugRenderer();
		fps_log = new FPSLogger();
		world = new World(new Vector2(0,0), false);


		for(int i = 0 ; i < 20 ; i++){
			Ball ball= new Ball(world);
			balls.add(ball);
			ball.start();
			ball.setTouchable(Touchable.enabled);
		}
		Wall wall = new Wall(world);
		wall.start();

		mjd = new MouseJointDef();
		mjd.bodyA = world.createBody(new BodyDef());


	}

	@Override
	public void dispose() {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void render(float delta) {
		super.render(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	


		batch.begin();
		for(Ball b : balls){
			b.draw(batch, delta);
		}
		font.draw(batch, "Clicks: " + clickeds ,25f ,15f); 
		font.draw(batch,"FPS: " + Gdx.graphics.getFramesPerSecond(), 150f, 15f);
		batch.end();

		fps_log.log();

		if(Config.DEBUG_MODE){
			debugRenderer.render(world, camera.combined);  
		}

		world.step(BOX_STEP, BOX_VELOCITY_ITERATIONS, BOX_POSITION_ITERATIONS); 
	}

	@Override
	public void show() {}

	@Override
	public void hide() {}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	private Vector3 tmp = new Vector3();
	private QueryCallback query = new QueryCallback() {

		@Override
		public boolean reportFixture(Fixture fixture) {
			if(fixture.testPoint(tmp.x,tmp.y)){
				mjd.bodyB = fixture.getBody();
				clickeds++;
				System.out.println("CLICKED");
				joint = (MouseJoint) world.createJoint(mjd);
				return false;}
			return false;
		}
	};
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		camera.unproject(tmp.set(screenX,screenY,0));		
		world.QueryAABB(query, tmp.x, tmp.y, tmp.x, tmp.y);


		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		if(world.getJointCount()!= 0)
			world.destroyJoint(joint);
		System.out.println("UNCLICKED");
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}




}