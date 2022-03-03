package com.stomeo.autoescuelasts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<ArrayListElementos> elements;
    private Switch switchTema;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchTema = findViewById(R.id.switchTema);

        preferences = getSharedPreferences("night", 0);
        boolean valor = preferences.getBoolean("night_mode", false);
        if (valor) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            switchTema.setChecked(true);
        }

        switchTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchTema.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    switchTema.setChecked(true);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("night_mode", true);
                    editor.apply();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    switchTema.setChecked(false);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("night_mode", false);
                    editor.apply();
                }
            }
        });

        inicializar();
    }

    public void inicializar() {
        elements = new ArrayList<>();
        elements.add(new ArrayListElementos("Leer teoría"));
        elements.add(new ArrayListElementos("Vídeos teoría"));
        elements.add(new ArrayListElementos("Programar clase"));
        elements.add(new ArrayListElementos("Enviar correo a la DGT"));
        elements.add(new ArrayListElementos("Activar sonido"));

        MiAdaptador miAdaptador = new MiAdaptador(this, elements, new MiAdaptador.OnItemClickListener() {
            @Override
            public void onItemClick(ArrayListElementos item) {
                iniciarActividad(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(miAdaptador);
    }

    public void iniciarActividad(ArrayListElementos item) {
        switch (item.getOpcion()) {
            case "Leer teoría": {
                Intent intent = new Intent(this, TemasTeoriaActivity.class);
                intent.putExtra("ArrayListElementos", item);
                startActivity(intent);
                break;
            }
            case "Vídeos teoría": {
                Intent intent = new Intent(this, TemasVideosActivity.class);
                intent.putExtra("ArrayListElementos", item);
                startActivity(intent);
                break;
            }
            case "Programar clase": {
                Intent intent = new Intent(this, ClaseActivity.class);
                intent.putExtra("ArrayListElementos", item);
                startActivity(intent);
                break;
            }
            case "Enviar correo a la DGT": {
                Intent intent = new Intent(this, DGTActivity.class);
                intent.putExtra("ArrayListElementos", item);
                startActivity(intent);
                break;
            }
            default: {
                Intent intent = new Intent(this, Musica.class);
                intent.putExtra("ArrayListElementos", item);
                startActivity(intent);
                break;
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setCancelable(false).setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog titulo = alerta.create();
        titulo.setTitle("¿Desea salir de la aplicación?");
        titulo.show();
        return super.onKeyDown(keyCode, event);
    }

}