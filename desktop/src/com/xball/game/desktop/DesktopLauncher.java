package com.xball.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.xball.game.XBallGame;
import com.xball.statics.Sizes;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "X-Ball";
		cfg.height = Sizes.HEIGHT;
		cfg.width = Sizes.WIDTH;
		new LwjglApplication(new XBallGame(), cfg);
	}
}
