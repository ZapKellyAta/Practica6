package com.example.kellyjohanazapataestrada.practica6;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MisFavoritos extends SQLiteOpenHelper
{
    private String DATA_BASE_NAME ="Parmessano";
    private int DATA_BASE_VERSION = 1;

    //Creamos la tabla a trabajar
    String sqlCreate = "CREATE TABLE MISFAVORITOS("+"idFavorito INTEGER PRIMARY KEY AUTOINCREMENT," +
            ""+"idUsuario TEXT, "+"idProducto TEXT)";

    public MisFavoritos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(sqlCreate);//Ejecutamos la sentencia anterior
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MISFAVORITOS");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
