package com.xball.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.xball.game.XBallGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "X-Ball";
		cfg.height = 480;
		cfg.width = 640;
		new LwjglApplication(new XBallGame(), cfg);
	}
}
