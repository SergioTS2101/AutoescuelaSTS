package com.stomeo.autoescuelasts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLite extends SQLiteOpenHelper {

    private final String sqlcreate = "CREATE TABLE usuarios (email text PRIMARY KEY, nombreUsuario text, contrasenia text)";

    public AdminSQLite(@Nullable Context context) {
        super(context, "usuarios", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlcreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versionAnterior, int versionNueva) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usuarios");

        sqLiteDatabase.execSQL(sqlcreate);

    }
}
