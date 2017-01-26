package com.pelotarebotando.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PelotaRebotando implements ApplicationListener {

	SpriteBatch batch;
	OrthographicCamera camera;
	Pelota pelota;
	PelotaConGravedad pelotaConGravedad;
	BitmapFont font;

	@Override
	public void create () {
		pelota =  new Pelota(100, 100, 20, Color.CORAL);
		pelotaConGravedad = new PelotaConGravedad(20, 460, 20, Color.CYAN);
		font = new BitmapFont();
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);
		font.setColor(Color.CYAN);

		pelota.inicializarPelota();
		pelotaConGravedad.inicializarPelota();
		batch.begin();
		pelota.actualizarPosicion();
		pelotaConGravedad.actualizarPosicion();
		batch.end();

		batch.begin();
		font.draw(batch, "Datos pelota CYAN (con gravedad)", 40, 120);
		font.draw(batch, "=========================", 40, 110);
		font.draw(batch, "Velocidad X: " + pelotaConGravedad.velocidad.x, 40, 90);
		font.draw(batch, "Velocidad Y: " + pelotaConGravedad.velocidad.y, 40, 70);
		font.draw(batch, "Posicion X: " + pelotaConGravedad.posicion.x, 40, 50);
		font.draw(batch, "Posicion Y: " + pelotaConGravedad.posicion.y, 40, 30);
		batch.end();

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}

