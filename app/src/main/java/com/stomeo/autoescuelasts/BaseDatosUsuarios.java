package com.stomeo.autoescuelasts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class BaseDatosUsuarios extends AdminSQLite {

    public Context context;

    public BaseDatosUsuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarUsuario(String email, String nombreUsuario, String contrasenia) {

        long id = 0;

        try {
            AdminSQLite dbHelper = new AdminSQLite(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("email", email);
            values.put("nombreUsuario", nombreUsuario);
            values.put("contrasenia", contrasenia);

            id = db.insert("usuarios", null, values);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public Cursor consultarUsuario(String email, String contrasenia) throws SQLException {
        Cursor cursor;
        cursor = this.getReadableDatabase().query
                ("usuarios", new String[]
                                {"email", "contrasenia"},
                        "email like '" + email + "' " +
                                " and contrasenia like '" + contrasenia + "'",
                        null, null, null, null);

        return cursor;
    }
}
