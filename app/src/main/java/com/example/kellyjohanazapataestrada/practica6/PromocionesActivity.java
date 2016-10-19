package com.example.kellyjohanazapataestrada.practica6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

public class PromocionesActivity extends NavigationDraActivity {

    String user,pass,email;
    String promo;
    ImageView imagen1,imagen2,imagen3,imagen4,imagen5,imagen6,imagen7;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] opciones = new String[] {"Mi Perfil", "Menu", "Healthy","Promociones"};

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intento = new Intent(PromocionesActivity.this, MainActivity.class);
            intento.putExtra("user", user);
            intento.putExtra("pass", pass);
            intento.putExtra("email", email);
            intento.putExtra("promo", promo);
            startActivity(intento);
            finish();
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_promociones, contentFrameLayout);

        imagen1=(ImageView)findViewById(R.id.iprimera);
        imagen2=(ImageView)findViewById(R.id.isegunda);
        imagen3=(ImageView)findViewById(R.id.itercera);
        imagen4=(ImageView)findViewById(R.id.icuarta);
        imagen5=(ImageView)findViewById(R.id.iquinta);
        imagen6=(ImageView)findViewById(R.id.isexta);
        imagen7=(ImageView)findViewById(R.id.iseptima);

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        user = getIntent().getExtras().getString("user");
        pass = getIntent().getExtras().getString("pass");
        email = getIntent().getExtras().getString("email");
        promo = getIntent().getExtras().getString("promo");

        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        switch (promo){
            case "primero":
                imagen1.setVisibility(View.VISIBLE);
                imagen2.setVisibility(View.GONE);
                imagen3.setVisibility(View.GONE);
                imagen4.setVisibility(View.GONE);
                imagen5.setVisibility(View.GONE);
                imagen6.setVisibility(View.GONE);
                imagen7.setVisibility(View.GONE);
                break;
            case "segundo":
                imagen1.setVisibility(View.GONE);
                imagen2.setVisibility(View.VISIBLE);
                imagen3.setVisibility(View.GONE);
                imagen4.setVisibility(View.GONE);
                imagen5.setVisibility(View.GONE);
                imagen6.setVisibility(View.GONE);
                imagen7.setVisibility(View.GONE);
                break;
            case "tercero":
                imagen1.setVisibility(View.GONE);
                imagen2.setVisibility(View.GONE);
                imagen3.setVisibility(View.VISIBLE);
                imagen4.setVisibility(View.GONE);
                imagen5.setVisibility(View.GONE);
                imagen6.setVisibility(View.GONE);
                imagen7.setVisibility(View.GONE);
                break;
            case "cuarto":
                imagen1.setVisibility(View.GONE);
                imagen2.setVisibility(View.GONE);
                imagen3.setVisibility(View.GONE);
                imagen4.setVisibility(View.VISIBLE);
                imagen5.setVisibility(View.GONE);
                imagen6.setVisibility(View.GONE);
                imagen7.setVisibility(View.GONE);
                break;
            case "quinto":
                imagen1.setVisibility(View.GONE);
                imagen2.setVisibility(View.GONE);
                imagen3.setVisibility(View.GONE);
                imagen4.setVisibility(View.GONE);
                imagen5.setVisibility(View.VISIBLE);
                imagen6.setVisibility(View.GONE);
                imagen7.setVisibility(View.GONE);
                break;
            case "sexto":
                imagen1.setVisibility(View.GONE);
                imagen2.setVisibility(View.GONE);
                imagen3.setVisibility(View.GONE);
                imagen4.setVisibility(View.GONE);
                imagen5.setVisibility(View.GONE);
                imagen6.setVisibility(View.VISIBLE);
                imagen7.setVisibility(View.GONE);
                break;
            case "septimo":
                imagen1.setVisibility(View.GONE);
                imagen2.setVisibility(View.GONE);
                imagen3.setVisibility(View.GONE);
                imagen4.setVisibility(View.GONE);
                imagen5.setVisibility(View.GONE);
                imagen6.setVisibility(View.GONE);
                imagen7.setVisibility(View.VISIBLE);
                break;
        }


        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opciones));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case(0):
                        Intent intent=new Intent(PromocionesActivity.this,PerfilActivity.class);
                        intent.putExtra("user", user);
                        intent.putExtra("pass", pass);
                        intent.putExtra("email", email);
                        intent.putExtra("promo", promo);
                        startActivity(intent);
                        finish();
                        break;
                    case(1):
                        Intent intento1=new Intent(PromocionesActivity.this,MenuActivity.class);
                        intento1.putExtra("user", user);
                        intento1.putExtra("pass", pass);
                        intento1.putExtra("email", email);
                        intento1.putExtra("promo", promo);
                        startActivity(intento1);
                        finish();
                        break;
                    case(2):
                        Intent intento=new Intent(PromocionesActivity.this,HealthyActivity.class);
                        intento.putExtra("user", user);
                        intento.putExtra("pass", pass);
                        intento.putExtra("email", email);
                        intento.putExtra("promo", promo);
                        startActivity(intento);
                        finish();
                        break;
                }
                listView.setItemChecked(i,true);
                drawerLayout.closeDrawer(listView);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
