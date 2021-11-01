package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Font;
import com.mygdx.game.GameData;
import com.mygdx.game.Pong;

public class MainMenuScreen implements Screen {
	
	private final Pong game;
	private final OrthographicCamera camera;
	
	public MainMenuScreen(final Pong game) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, GameData.WORLD_WIDTH, GameData.WORLD_HEIGHT);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		if (Gdx.input.isKeyPressed(Keys.ANY_KEY)) {
			game.setScreen(new GameScreen(game));
			dispose();
		}
		
		ScreenUtils.clear(GameData.backgroundColor);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		

		game.batch.begin();
		
		game.fontLayout.setText(Font.SMALL, "Press any key to start");
		Font.SMALL.draw(game.batch, game.fontLayout,
				GameData.WORLD_WIDTH / 2 - game.fontLayout.width / 2,
				GameData.WORLD_HEIGHT / 2 + game.fontLayout.height / 2);
		
		game.batch.end();
		
		game.shape.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
	}

}
