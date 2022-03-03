package com.stomeo.autoescuelasts.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.stomeo.autoescuelasts.AdminSQLite;
import com.stomeo.autoescuelasts.BaseDatosUsuarios;
import com.stomeo.autoescuelasts.MainActivity;
import com.stomeo.autoescuelasts.R;

public class LoginFragment extends Fragment {

    private EditText email;
    private EditText nombreUsuario;
    private EditText contrasenia;


    public LoginFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.login_activity, container, false);

        AdminSQLite adminSQLite = new AdminSQLite(getActivity());

        Button entrar = myView.findViewById(R.id.btn_entrar);
        email = myView.findViewById(R.id.etEmailLogin);
        nombreUsuario = myView.findViewById(R.id.etUsuarioLogin);
        contrasenia = myView.findViewById(R.id.etContraseñaLogin);

        cargarPreferencias();
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail = email.getText().toString();
                String getContrasenia = contrasenia.getText().toString();

                BaseDatosUsuarios baseDatosUsuarios = new BaseDatosUsuarios(getActivity());
                Cursor cursor = baseDatosUsuarios.consultarUsuario(getEmail, getContrasenia);
                if (cursor.getCount() > 0) {
                    guardarPreferencias();
                    Toast.makeText(getActivity(), "Bienvenido", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                    limpiar();
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity(), "Error en el login", Toast.LENGTH_LONG).show();
                }

            }

        });

        return myView;

    }

    private void limpiar() {
        email.setText("");
        nombreUsuario.setText("");
        contrasenia.setText("");
    }

    private void cargarPreferencias() {
        SharedPreferences preferences = getActivity().getSharedPreferences("Credenciales", Context.MODE_PRIVATE);

        String cargaEmail = preferences.getString("email", "");
        String cargaNombreUsuario = preferences.getString("nombreUsuario", "");
        String cargaContrasenia = preferences.getString("contrasenia", "");

        email.setText(cargaEmail);
        nombreUsuario.setText(cargaNombreUsuario);
        contrasenia.setText(cargaContrasenia);
    }

    private void guardarPreferencias() {
        SharedPreferences preferences = getActivity().getSharedPreferences("Credenciales", Context.MODE_PRIVATE);

        String guardaEmail = email.getText().toString();
        String guardaNombreUsuario = nombreUsuario.getText().toString();
        String guardaContrasenia = contrasenia.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("email", guardaEmail);
        editor.putString("nombreUsuario", guardaNombreUsuario);
        editor.putString("contrasenia", guardaContrasenia);

        email.setText(guardaEmail);
        nombreUsuario.setText(guardaNombreUsuario);
        contrasenia.setText(guardaContrasenia);

        editor.commit();
    }


}