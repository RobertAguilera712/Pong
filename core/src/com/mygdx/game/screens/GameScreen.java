package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Ball;
import com.mygdx.game.Font;
import com.mygdx.game.GameData;
import com.mygdx.game.Paddle;
import com.mygdx.game.Player;
import com.mygdx.game.Pong;

public class GameScreen implements Screen{
	
	private final Pong game;
	private final OrthographicCamera camera;
	private final Player player1;
	private final Player player2;
	final Ball ball;
	
	public GameScreen(Pong game) {
		this.game = game;
		this.camera = new OrthographicCamera();
		camera.setToOrtho(false, GameData.WORLD_WIDTH, GameData.WORLD_HEIGHT);
		
		player1 = new Player(new Paddle(10, 30, 5, 30));
		player2 = new Player(new Paddle(GameData.WORLD_WIDTH - 12.5f, 
				GameData.WORLD_HEIGHT - 60, 5, 30));
		this.ball = new Ball(GameData.WORLD_WIDTH / 2 - 2,
				GameData.WORLD_HEIGHT / 2 -2, 4, 4);
		
		GameData.state = "start";
		
		Gdx.input.setInputProcessor(new GameScreenInput(this));
	}
	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public void update(float dt) {
		if (Gdx.input.isKeyPressed(Keys.W)) {
			player1.paddle.dy = GameData.PADDLE_SPEED;
		}else if (Gdx.input.isKeyPressed(Keys.S)) {
			player1.paddle.dy =  - GameData.PADDLE_SPEED;
		}else {
			player1.paddle.dy = 0;
		}

		if (Gdx.input.isKeyPressed(Keys.UP)) {
			player2.paddle.dy = GameData.PADDLE_SPEED;
		}else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			player2.paddle.dy =  - GameData.PADDLE_SPEED;
		}else {
			player2.paddle.dy = 0;
		}
		
		if (GameData.state.equals("play")) {
			ball.update(dt);
		}
		
		player1.update(dt);
		player2.update(dt);
	}

	@Override
	public void render(float delta) {
		update(delta);
		// TODO Auto-generated method stub
		ScreenUtils.clear(GameData.backgroundColor);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		game.batch.end();
		
		game.shape.setProjectionMatrix(camera.combined);
		
		game.shape.begin(ShapeType.Filled);
		player1.render(game.shape);
		player2.render(game.shape);
		ball.render(game.shape);
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
