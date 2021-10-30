package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenu implements Screen {
	
	final Pong game;
	OrthographicCamera camera;
	final float PADDLE_SPEED = 200;
	Paddle player1;
	Paddle player2;
	int player1Score;
	int player2Score;
	
	public MainMenu(final Pong game) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Pong.WORLD_WIDTH, Pong.WORLD_HEIGHT);
		
		player1 = new Paddle(10, 30, 5, 30);
		player2 = new Paddle(Pong.WORLD_WIDTH - 10 - 2.5f,
				Pong.WORLD_HEIGHT - 60, 5, 30);
		
		player1Score = 0;
		player1Score = 0;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Keys.W)) {
			player1.setDy(PADDLE_SPEED);
		} else if (Gdx.input.isKeyPressed(Keys.S)) {
			player1.setDy(-PADDLE_SPEED);
		}else {
			player1.setDy(0);
		}

		if (Gdx.input.isKeyPressed(Keys.UP)) {
			player2.setDy(PADDLE_SPEED);
		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			player2.setDy(-PADDLE_SPEED);
		}else {
			player2.setDy(0);
		}

		
		player1.update(delta);
		player2.update(delta);
		
		ScreenUtils.clear(40/255f, 45/255f, 52/255f, 1);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		

		game.batch.begin();
		
		game.fontLayout.setText(Font.SMALL, "Hello Pong!");
		Font.SMALL.draw(game.batch, game.fontLayout,
				Pong.WORLD_WIDTH / 2 - game.fontLayout.width / 2,
				Pong.WORLD_HEIGHT - 20);
		
		game.fontLayout.setText(Font.BIG, String.valueOf(player1Score));
		Font.BIG.draw(game.batch, game.fontLayout,
				Pong.WORLD_WIDTH / 2 - game.fontLayout.width / 2
				- game.fontLayout.width * 2,
				Pong.WORLD_HEIGHT - Pong.WORLD_HEIGHT / 3);

		game.fontLayout.setText(Font.BIG, String.valueOf(player2Score));
		Font.BIG.draw(game.batch, game.fontLayout,
				Pong.WORLD_WIDTH / 2 - game.fontLayout.width / 2
				+ game.fontLayout.width * 2,
				Pong.WORLD_HEIGHT - Pong.WORLD_HEIGHT / 3);
		
		game.batch.end();
		
		game.shape.setProjectionMatrix(camera.combined);
		
		game.shape.begin(ShapeType.Filled);
		player1.render(game.shape);
		player2.render(game.shape);

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
		// TODO Auto-generated method stub
		
	}

}
