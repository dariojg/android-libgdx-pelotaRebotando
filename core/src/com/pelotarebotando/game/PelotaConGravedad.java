package com.pelotarebotando.game;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by dario on 22/01/17.
 */

public class PelotaConGravedad extends Pelota {


    public PelotaConGravedad(float x, float y, float radio, Color color) {
        super(x, y, radio, color);
        velocidadX = 5;
        velocidadY = 5;
    }

    @Override
    public void actualizarPosicion() {
        velocidadY -= 0.6; //TODO mejorar frenado de la pelota que no sea tan brusco y que se baje la mitad fuera de la pantalla
        if(posicionY < 0){
            velocidadY = 0;
            velocidadX = 0;
        }
        super.actualizarPosicion();
    }


}
