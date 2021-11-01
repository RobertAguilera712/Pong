package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player {
	private int score;
	public Paddle paddle;
	
	public Player(Paddle paddle) {
		this.score = 0;
		this.paddle = paddle;
	}
	
	public void raiseScore() {
		this.score++;
	}
	
	public void resetScore() {
		this.score = 0;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public String getStringScore() {
		return String.valueOf(this.score);
	}
	
	public void update(float dt) {
		this.paddle.update(dt);
	}
	
	public void render(ShapeRenderer shape) {
		this.paddle.render(shape);
	}

}
