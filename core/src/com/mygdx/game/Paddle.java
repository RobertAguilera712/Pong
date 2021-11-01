package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
	private float x; 
	private float y; 
	private float width;
	private float height;
	public float dy;
	
	public Paddle(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.dy = 0;
	}
	
	public void update(float dt) {
		if (this.dy < 0) {
			this.y = Math.max(0, this.y + this.dy * dt);
		}else {
			this.y = Math.min(GameData.WORLD_HEIGHT - this.height,
					this.y + this.dy * dt);
		}
	}
	
	public void render(ShapeRenderer shape) {
		shape.rect(this.x, this.y, this.width, this.height);
	}

}
