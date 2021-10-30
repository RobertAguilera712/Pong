package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Font {
	public static final BitmapFont SMALL = new BitmapFont(Gdx.files.internal("8.fnt"));
	public static final BitmapFont BIG = new BitmapFont(Gdx.files.internal("32.fnt"));
	
	public static void dispose() {
		SMALL.dispose();
		BIG.dispose();
	}
}
