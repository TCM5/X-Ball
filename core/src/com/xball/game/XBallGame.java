package com.xball.game;

import com.badlogic.gdx.Game;
import com.xball.screens.GameScreen;
import com.xball.screens.LoadingScreen;


public class XBallGame extends Game {


	@Override
	public void create () {
		setScreen(new GameScreen());
	}
}
