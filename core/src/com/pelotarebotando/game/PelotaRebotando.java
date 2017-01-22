package com.pelotarebotando.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PelotaRebotando extends ApplicationAdapter {

	SpriteBatch batch;
	OrthographicCamera camera;

	Pelota pelota;

	@Override
	public void create () {
		pelota =  new Pelota(100, 200, 40, Color.CORAL);

		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		pelota.inicializarPelota();

		batch.begin();
		pelota.actualizarPosicion();
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}