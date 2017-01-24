package com.pelotarebotando.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;


/**
 * Created by dario on 22/01/17.
 */

public class Pelota {

    private ShapeRenderer pelota;
    private Vector2 tamanioPantalla; //ajaa de libgdx vector 2 dimensiones, pioola!
    protected float radio;
    protected Vector2 posicion;
    protected Vector2 velocidad;
    protected Color color;


    public Pelota(float x, float y, float radio, Color color){
        posicion =  new Vector2(x, y);
        velocidad = new Vector2(5, 5);
        this.radio = radio;
        this.color = color;
        tamanioPantalla = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        pelota = new ShapeRenderer();
    }


    public void inicializarPelota(){
        pelota.begin(ShapeType.Filled);
        pelota.setColor(color);
    }

    public void actualizarPosicion(){

        posicion.x += velocidad.x;
        posicion.y += velocidad.y;

        if(estoyEnUnBordeY()) {
            cambiarDireccionY();
        }

        if(estoyEnUnBordeX()) {
            cambiarDireccionX();
        }

        pelota.circle(posicion.x, posicion.y, radio);
        pelota.end();
    }

    protected void cambiarDireccionY(){
        velocidad.y = velocidad.y * - 1;
    }

    protected void cambiarDireccionX(){
        velocidad.x = velocidad.x * -1;
    }

    protected boolean estoyEnUnBordeY(){
        return posicion.y == tamanioPantalla.y  - radio/2 || posicion.y <= radio;
    }

    protected boolean estoyEnUnBordeX(){
        return posicion.x == tamanioPantalla.x - radio/2 || posicion.x <= radio;
    }

}
