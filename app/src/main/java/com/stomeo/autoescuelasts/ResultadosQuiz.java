package com.stomeo.autoescuelasts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultadosQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_resultados);

        Button volver = findViewById(R.id.volver);

        TextView respuestasCorrectas = findViewById(R.id.respuestasCorrectas);
        TextView respuestasIncorrectas = findViewById(R.id.respuestasIncorrectas);

        int getRespuestasCorrectas = getIntent().getIntExtra("correctas", 0);
        int getRespuestasIncorrectas = getIntent().getIntExtra("incorrectas", 0);

        respuestasCorrectas.setText(String.valueOf(getRespuestasCorrectas));
        respuestasIncorrectas.setText(String.valueOf(getRespuestasIncorrectas));

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultadosQuiz.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}