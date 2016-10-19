package com.example.kellyjohanazapataestrada.practica6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity
{

    ListView lv;
    ArrayList<String>lista;
    ArrayAdapter adaptador;


    MisFavoritos misFavoritos;
    SQLiteDatabase dbMisfavoritos;
    ContentValues dataBD2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        misFavoritos = new MisFavoritos(this,"dbMisfavoritos",null,1);
        dbMisfavoritos = misFavoritos.getWritableDatabase();

        lv=(ListView)findViewById(R.id.list2);
        lista = llenar_lv();
        adaptador= new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adaptador);
    }

    public ArrayList llenar_lv()
    {
        ArrayList<String> lista = new ArrayList<>();

        misFavoritos = new MisFavoritos(this,"dbMisfavoritos",null,1);
        dbMisfavoritos = misFavoritos.getWritableDatabase();

        String q = "SELECT * FROM MISFAVORITOS";
        Cursor c = dbMisfavoritos.rawQuery(q, null);
        if(c.moveToFirst())
        {
            do {
                    lista.add(c.getString(0));
            }
            while(c.moveToNext());
        }
        return lista;
    }
}
