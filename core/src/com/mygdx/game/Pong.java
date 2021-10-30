package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Pong extends Game {

	SpriteBatch batch;
	ShapeRenderer shape;
	GlyphLayout fontLayout;
	final static float WORLD_WIDTH = 352;
	final static float WORLD_HEIGHT = 198;
	

	@Override
	public void create() {
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		fontLayout = new GlyphLayout();
		
		this.setScreen(new MainMenu(this));
	}
	
	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		shape.dispose();
		Font.dispose();
	}

}
