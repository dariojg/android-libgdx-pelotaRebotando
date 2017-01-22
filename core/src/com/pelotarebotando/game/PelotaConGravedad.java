package com.pelotarebotando.game;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by dario on 22/01/17.
 */

public class PelotaConGravedad extends Pelota {


    public PelotaConGravedad(float x, float y, float radio, Color color) {
        super(x, y, radio, color);
        setVelocidadX(5);
        setVelocidadY(-1);
    }

    @Override
    public void actualizarPosicion() {
        setVelocidadY(getVelocidadY() - 1); //Todo, corregir bug al llegar a posicion 0
        super.actualizarPosicion();

    }
}
