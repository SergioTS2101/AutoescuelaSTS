package com.stomeo.autoescuelasts.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.stomeo.autoescuelasts.AdminSQLite;
import com.stomeo.autoescuelasts.BaseDatosUsuarios;
import com.stomeo.autoescuelasts.MainActivity;
import com.stomeo.autoescuelasts.R;


public class SignUpFragment extends Fragment {

    private EditText email;
    private EditText nombreUsuario;
    private EditText contrasenia;

    private CheckBox terminos;

    public SignUpFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.signup_activity, container, false);
        AdminSQLite adminSQLite = new AdminSQLite(getActivity());

        Button crear = myView.findViewById(R.id.btn_crear);
        email = myView.findViewById(R.id.etEmailSU);
        nombreUsuario = myView.findViewById(R.id.etUsuarioSU);
        contrasenia = myView.findViewById(R.id.etContraseñaSU);
        terminos  = myView.findViewById(R.id.cbTerminos);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail = email.getText().toString();
                String getNombreUsuario = nombreUsuario.getText().toString();
                String getContrasenia = contrasenia.getText().toString();

                BaseDatosUsuarios baseDatosUsuarios = new BaseDatosUsuarios(getActivity());
                long id = baseDatosUsuarios.insertarUsuario(getEmail, getNombreUsuario, getContrasenia);

                if ((id > 0) && terminos.isChecked()) {
                    Toast.makeText(getActivity(), "Registro completado", Toast.LENGTH_LONG).show();
                    limpiar();
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity(), "Error al registrarse", Toast.LENGTH_LONG).show();
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
}