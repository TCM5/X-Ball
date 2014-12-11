package com.xball.game;

import com.badlogic.gdx.Game;
import com.xball.managers.AssetsManager;
import com.xball.screens.GameScreen;


public class XBallGame extends Game {


	@Override
	public void create () {
		AssetsManager.load();
		AssetsManager.assetManager.finishLoading();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose() {
		super.dispose();
		AssetsManager.dispose();
	}
}
