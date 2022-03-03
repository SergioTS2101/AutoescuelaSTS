package com.stomeo.autoescuelasts;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ClaseActivity extends AppCompatActivity {
    private Button btn_fecha;
    private EditText etFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase);

        btn_fecha = findViewById(R.id.btn_Fecha);
        etFecha = findViewById(R.id.etFecha);

    }

    public void onClickFecha(View v) {
        if (v == btn_fecha) {
            final Calendar calendario = Calendar.getInstance();
            int dia = calendario.get(Calendar.DAY_OF_MONTH);
            int mes = calendario.get(Calendar.MONTH);
            int anio = calendario.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> etFecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year), dia, mes, anio);
            AlertDialog.Builder alerta = new AlertDialog.Builder(ClaseActivity.this);
            alerta.setMessage("¿Está seguro de que desea tener su clase este día?").setCancelable(false).setPositiveButton("Sí", (dialog, which) -> {
                Toast.makeText(ClaseActivity.this, "Su clase en el día elegido ha quedado registrada", Toast.LENGTH_LONG).show();
                finish();
            }).setNegativeButton("No", (dialog, which) -> {
                Toast.makeText(ClaseActivity.this, "Su clase en el  día elegido ha sido cancelada", Toast.LENGTH_LONG).show();
                finish();
            });
            AlertDialog titulo = alerta.create();
            titulo.setTitle("Programar clase");
            titulo.show();
            datePickerDialog.show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        AlertDialog.Builder alerta = new AlertDialog.Builder(ClaseActivity.this);
        alerta.setCancelable(false).setPositiveButton("Sí", (dialog, which) -> {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }).setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        AlertDialog titulo = alerta.create();
        titulo.setTitle("¿Desea salir de la aplicación?");
        titulo.show();
        return super.onKeyDown(keyCode, event);
    }
}