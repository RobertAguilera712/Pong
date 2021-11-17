package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class Ball {
	private float x;
	private float y;
	private float width;
	private float height;
	private float dx;
	private float dy;
	
	public Ball(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.dx = MathUtils.random(1, 3) == 1 ? 100 : -100;
		this.dy = MathUtils.random(-50, 51);
	}
	
	public void reset() {
		this.x = GameData.WORLD_WIDTH / 2 - this.width / 2;
		this.y = GameData.WORLD_HEIGHT / 2 - this.height / 2;
		this.dx = MathUtils.random(1, 3) == 1 ? 100 : -100;
		this.dy = MathUtils.random(-50, 51);
	}
	
	public void update (float dt) {
		this.x += this.dx * dt;
		this.y += this.dy * dt;
	}
	
	public void render(ShapeRenderer shape) {
		shape.rect(this.x, this.y, this.width, this.height);
	}

}
