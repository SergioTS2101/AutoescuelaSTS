package com.stomeo.autoescuelasts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class TemasActivity extends AppCompatActivity {

    private String temaElegido = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temas_activity);


        CardView tema1 = (CardView) findViewById(R.id.cvTema1);
        CardView tema2 = (CardView) findViewById(R.id.cvTema2);
        CardView tema3 = (CardView) findViewById(R.id.cvTema3);
        CardView tema4 = (CardView) findViewById(R.id.cvTema4);


        tema1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temaElegido = "tema1";
                Intent intent = new Intent(getApplicationContext(), ScrollingActivity.class);
                intent.putExtra("temaElegido", temaElegido);
                startActivity(intent);
            }
        });

        tema2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temaElegido = "tema2";
                Intent intent = new Intent(getApplicationContext(), ScrollingActivity.class);
                intent.putExtra("temaElegido", temaElegido);
                startActivity(intent);
            }
        });

        tema3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temaElegido = "tema3";
                Intent intent = new Intent(getApplicationContext(), ScrollingActivity.class);
                intent.putExtra("temaElegido", temaElegido);
                startActivity(intent);
            }
        });

        tema4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temaElegido = "tema4";
                Intent intent = new Intent(getApplicationContext(), ScrollingActivity.class);
                intent.putExtra("temaElegido", temaElegido);
                startActivity(intent);
            }
        });

    }
}
