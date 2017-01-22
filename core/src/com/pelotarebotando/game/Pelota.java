package com.pelotarebotando.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by dario on 22/01/17.
 */

public class Pelota {

    private ShapeRenderer pelota;
    private float radio;
    private float x;
    private float y;
    private Color color;

    private float velocidadX = 2;
    private float velocidadY = 2;

    boolean flagDirecion = false;

    public Pelota(float x, float y, float radio, Color color){
        this.radio = radio;
        this.x = x;
        this.y = y;
        this. color = color;
        pelota = new ShapeRenderer();
    }


    public void inicializarPelota(){
        pelota.begin(ShapeType.Filled);
        pelota.setColor(color);
    }

    public void actualizarPosicion(){
        if(y == 480  - radio/2){
            velocidadY = velocidadY * -1;
        }
        if(x == 800 - radio/2){
            velocidadX = velocidadX * -1;
        }
        if(y == 0 + radio/2){
            velocidadY = velocidadY * -1;
        }
        if (x == 0 + radio/2){
            velocidadX = velocidadX * -1;
        }

        x += velocidadX;
        y += velocidadY;

        pelota.circle(x, y, 20); //x, y, radio
        pelota.end();
    }


}
