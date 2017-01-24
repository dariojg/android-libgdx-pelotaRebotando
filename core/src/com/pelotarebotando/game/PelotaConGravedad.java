package com.pelotarebotando.game;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by dario on 22/01/17.
 */

public class PelotaConGravedad extends Pelota {


    public PelotaConGravedad(float x, float y, float radio, Color color) {
        super(x, y, radio, color);
        velocidad.x = 5;
        velocidad.y = 5;
    }

    @Override
    public void actualizarPosicion() {
        //TODO mejorar frenado de la pelota y que se baje la mitad fuera de la pantalla.
        velocidad.y -= 0.6;
        if(posicion.y < 0){
            velocidad.y = 0;
            velocidad.x = 0;
        }
        super.actualizarPosicion();
    }


}
