package com.xball.managers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;

public class AssetsManager{

	public static final AssetManager assetManager = new AssetManager();
	
	
	/**
	 *  SOUNDS
	 */
	public static final String SOUND_TEST = "test.mp3";

	/**
	 *  TEXTURES
	 */

	
	public static void load(){
		assetManager.load(SOUND_TEST, Sound.class);
	}
	
	public static void dispose(){
		
	}
	
	


}


