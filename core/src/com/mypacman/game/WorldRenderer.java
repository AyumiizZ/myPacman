package com.mypacman.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private World world;
	private PacmanGame pacmanGame;
	private SpriteBatch batch;
	private Texture pacmanImg;
	private MazeRenderer mazeRenderer;
	public WorldRenderer(PacmanGame pacmanGame, World world) {
		this.pacmanGame = pacmanGame;
		batch = pacmanGame.batch;
		this.world = world;
		pacmanImg = new Texture("pacman.png");
		mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
	}
	public void render(float delta) {
		mazeRenderer.render();
		SpriteBatch batch = pacmanGame.batch;
		batch.begin();
		Vector2 pos = world.getPacman().getPosition();
		batch.draw(pacmanImg, pos.x, pos.y);
		batch.end();
	}
}
