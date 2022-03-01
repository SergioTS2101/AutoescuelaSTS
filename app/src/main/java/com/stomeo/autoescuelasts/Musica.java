package com.stomeo.autoescuelasts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Musica extends AppCompatActivity {

    private ImageView encender;
    private ImageView apagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musica_activity);

        encender = (ImageView) findViewById(R.id.encender);
        apagar = (ImageView) findViewById(R.id.apagar);

        encender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducir(v);
            }
        });

        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parar(v);
            }
        });

    }

    private void reproducir(View v) {
        startService(new Intent(this, ServicioMusica.class));
    }

    private void parar(View v) {
        stopService(new Intent(this, ServicioMusica.class));
    }


}