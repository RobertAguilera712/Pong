package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.screens.MainMenuScreen;

public class Pong extends Game {

	public SpriteBatch batch;
	public ShapeRenderer shape;
	public GlyphLayout fontLayout;
	

	@Override
	public void create() {
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		fontLayout = new GlyphLayout();
		
		this.setScreen(new MainMenuScreen(this));
	}
	
	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void dispose() {
		this.getScreen().dispose();
		batch.dispose();
		shape.dispose();
		Font.dispose();
	}

}
