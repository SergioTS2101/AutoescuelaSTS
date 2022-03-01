package com.stomeo.autoescuelasts;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView preguntas;
    private TextView pregunta;

    private AppCompatButton respuesta1, respuesta2, respuesta3;

    private AppCompatButton siguiente;

    private List<ListaPreguntas> listaPreguntas;

    private int posActualPregunta = 0;

    private String respuestaUsuario = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final TextView temaElegido = findViewById(R.id.tvTitulo);

        ImageView volver = findViewById(R.id.back_btn);

        preguntas = findViewById(R.id.tvTitulo);
        pregunta = findViewById(R.id.pregunta);

        respuesta1 = findViewById(R.id.respuesta1);
        respuesta2 = findViewById(R.id.respuesta2);
        respuesta3 = findViewById(R.id.respuesta3);

        siguiente = findViewById(R.id.siguiente);


        final String getTemaElegido = getIntent().getStringExtra("temaElegido");

        temaElegido.setText(getTemaElegido);

        listaPreguntas = ArrayListPreguntas.getPreguntas(getTemaElegido);

        preguntas.setText((posActualPregunta + 1) + "/" + listaPreguntas.size());
        pregunta.setText(listaPreguntas.get(0).getPregunta());
        respuesta1.setText(listaPreguntas.get(0).getRespuesta1());
        respuesta2.setText(listaPreguntas.get(0).getRespuesta2());
        respuesta3.setText(listaPreguntas.get(0).getRespuesta3());


        respuesta1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (respuestaUsuario.isEmpty()) {
                    respuestaUsuario = respuesta1.getText().toString();

                    respuesta1.setBackgroundResource(R.drawable.round_back_red_stroke);
                    respuesta1.setTextColor(Color.WHITE);

                    mostrarRespuesta();

                    listaPreguntas.get(posActualPregunta).setRespuestaUsuario(respuestaUsuario);
                }
                return true;
            }
        });

        respuesta2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (respuestaUsuario.isEmpty()) {
                    respuestaUsuario = respuesta2.getText().toString();

                    respuesta2.setBackgroundResource(R.drawable.round_back_red_stroke);
                    respuesta2.setTextColor(Color.WHITE);

                    mostrarRespuesta();

                    listaPreguntas.get(posActualPregunta).setRespuestaUsuario(respuestaUsuario);
                }
                return true;
            }
        });

        respuesta3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (respuestaUsuario.isEmpty()) {
                    respuestaUsuario = respuesta3.getText().toString();

                    respuesta3.setBackgroundResource(R.drawable.round_back_red_stroke);
                    respuesta3.setTextColor(Color.WHITE);

                    mostrarRespuesta();

                    listaPreguntas.get(posActualPregunta).setRespuestaUsuario(respuestaUsuario);
                }
                return true;
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (respuestaUsuario.isEmpty()) {
                    Toast.makeText(QuizActivity.this, getString(R.string.elijaRespuesta), Toast.LENGTH_SHORT).show();
                } else {
                    mostrarSiguientePregunta();
                }
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();
            }
        });


    }

    private void mostrarSiguientePregunta() {

        posActualPregunta++;

        if ((posActualPregunta + 1) == listaPreguntas.size()) {
            siguiente.setText(R.string.fin);
        }

        if (posActualPregunta < listaPreguntas.size()) {

            respuestaUsuario = "";

            respuesta1.setBackgroundResource(R.drawable.round_back_white_stroke2);
            respuesta1.setTextColor(Color.parseColor("#1F6BB8"));

            respuesta2.setBackgroundResource(R.drawable.round_back_white_stroke2);
            respuesta2.setTextColor(Color.parseColor("#1F6BB8"));

            respuesta3.setBackgroundResource(R.drawable.round_back_white_stroke2);
            respuesta3.setTextColor(Color.parseColor("#1F6BB8"));

            preguntas.setText((posActualPregunta + 1) + "/" + listaPreguntas.size());
            pregunta.setText(listaPreguntas.get(posActualPregunta).getPregunta());
            respuesta1.setText(listaPreguntas.get(posActualPregunta).getRespuesta1());
            respuesta2.setText(listaPreguntas.get(posActualPregunta).getRespuesta2());
            respuesta3.setText(listaPreguntas.get(posActualPregunta).getRespuesta3());
        } else {

            Intent intent = new Intent(QuizActivity.this, ResultadosQuiz.class);
            intent.putExtra("correctas", getRespuestasCorrectas());
            intent.putExtra("incorrectas", getRespuestasIncorrectas());
            startActivity(intent);

            finish();
        }

    }


    private int getRespuestasCorrectas() {

        int respuestasCorrectas = 0;

        for (int i = 0; i < listaPreguntas.size(); i++) {

            final String getRespuestaUsuario = listaPreguntas.get(i).getRespuestaUsuario();
            final String getRespuesta = listaPreguntas.get(i).getRespuesta();

            if (getRespuestaUsuario.equals(getRespuesta)) {
                respuestasCorrectas++;
            }
        }
        return respuestasCorrectas;
    }

    private int getRespuestasIncorrectas() {

        int respuestasIncorrectas = 0;

        for (int i = 0; i < listaPreguntas.size(); i++) {

            final String getRespuestaUsuario = listaPreguntas.get(i).getRespuestaUsuario();
            final String getRespuesta = listaPreguntas.get(i).getRespuesta();

            if (!getRespuestaUsuario.equals(getRespuesta)) {
                respuestasIncorrectas++;
            }


        }
        return respuestasIncorrectas;
    }


    private void mostrarRespuesta() {

        final String getRespuesta = listaPreguntas.get(posActualPregunta).getRespuesta();

        if (respuesta1.getText().toString().equals(getRespuesta)) {
            respuesta1.setBackgroundResource(R.drawable.round_back_green_stroke2);
            respuesta1.setTextColor(Color.WHITE);
        } else if (respuesta2.getText().toString().equals(getRespuesta)) {
            respuesta2.setBackgroundResource(R.drawable.round_back_green_stroke2);
            respuesta2.setTextColor(Color.WHITE);
        } else if (respuesta3.getText().toString().equals(getRespuesta)) {
            respuesta3.setBackgroundResource(R.drawable.round_back_green_stroke2);
            respuesta3.setTextColor(Color.WHITE);
        }
    }
}
