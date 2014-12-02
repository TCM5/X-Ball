package com.xball.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Actor {

	protected Texture texture;
	protected Vector2 pos, direction ;
	public Actor(Texture texture, Vector2 pos, Vector2 dir) {
		this.texture = texture;
		this.pos = pos;
		direction = dir;
	}

	public abstract void update();

	public void render(SpriteBatch sb) {
		sb.draw(texture, pos.x, pos.y);
	}

	public Vector2 getPosition() {
		return pos;
	}

	public void setDirection(float x, float y) {
		direction.set(x, y);
		direction.scl(Gdx.graphics.getDeltaTime());
	}

}

