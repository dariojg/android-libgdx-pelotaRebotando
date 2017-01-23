package com.pelotarebotando.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;

import java.util.Map;

/**
 * Created by dario on 22/01/17.
 */

public class Pelota {

    private ShapeRenderer pelota;

    protected float radio;
    protected float posicionX;
    protected float posicionY;
    protected Color color;
    protected float velocidadX = 5;
    protected float velocidadY = 5;


    public Pelota(float x, float y, float radio, Color color){
        this.radio = radio;
        this.posicionX = x;
        this.posicionY = y;
        this.color = color;
        pelota = new ShapeRenderer();
    }


    public void inicializarPelota(){
        pelota.begin(ShapeType.Filled);
        pelota.setColor(color);
    }

    public void actualizarPosicion(){

        posicionX += velocidadX;
        posicionY += velocidadY;

        if(estoyEnUnBordeY()) {
            cambiarDireccionY();
        }

        if(estoyEnUnBordeX()) {
            cambiarDireccionX();
        }

        pelota.circle(posicionX, posicionY, radio);
        pelota.end();
    }

    protected void cambiarDireccionY(){
        velocidadY = velocidadY * - 1;
    }

    protected void cambiarDireccionX(){
        velocidadX = velocidadX * -1;
    }

    protected boolean estoyEnUnBordeY(){
       return posicionY == 480  - radio/2 || posicionY <= radio;
    }

    protected boolean estoyEnUnBordeX(){
        return posicionX == 800 - radio/2 || posicionX <= radio;
    }

}
