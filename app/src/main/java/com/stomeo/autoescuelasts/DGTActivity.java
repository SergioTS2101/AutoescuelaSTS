package com.stomeo.autoescuelasts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DGTActivity extends AppCompatActivity {

    private EditText etDireccion;
    private EditText etAsunto;
    private EditText etMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dgt_activity);

        etDireccion = findViewById(R.id.etDireccion);
        etAsunto = findViewById(R.id.etAsunto);
        etMensaje = findViewById(R.id.etMensaje);
    }

    public void enviar (View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{etDireccion.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT,etAsunto.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT,etMensaje.getText().toString());
        startActivity(intent);
    }
}