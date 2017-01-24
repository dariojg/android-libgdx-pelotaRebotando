package com.pelotarebotando.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.pelotarebotando.game.PelotaRebotando;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		//TODO problemas con el render al girar dispositivo
		config.useGyroscope = true;
		config.useAccelerometer = false;
		config.useCompass = false;
		initialize(new PelotaRebotando(), config);
	}
}
