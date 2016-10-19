/*package com.example.kellyjohanazapataestrada.practica6;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;


public class PerfilActivity extends NavigationDraActivity {

    private ViewPager mViewPager;
    String user,pass,email;
    String promo;
    private DrawerLayout drawerLayout;
    private String[] opciones = new String[] {"Mi Perfil", "Menu", "Healthy","Promociones"};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_Healthy);

        user = getIntent().getExtras().getString("usuario");
        pass = getIntent().getExtras().getString("pass");
        email = getIntent().getExtras().getString("email");
        promo = getIntent().getExtras().getString("promo");

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_perfil, contentFrameLayout);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pag_perfil);
        mViewPager.setAdapter(pagerAdapter);

        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener(){
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }
        };
        ActionBar.Tab tab = actionBar.newTab().setText(R.string.Perfil).setTabListener(tabListener);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText(R.string.Favoritos).setTabListener(tabListener);
        actionBar.addTab(tab);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }
        });
        listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opciones));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case(0):
                        Intent intento1=new Intent(PerfilActivity.this,PerfilActivity.class);
                        intento1.putExtra("user", user);
                        intento1.putExtra("pass", pass);
                        intento1.putExtra("email", email);
                        intento1.putExtra("promo", promo);
                        startActivity(intento1);
                        finish();
                        break;
                    case(1):
                        Intent intento2=new Intent(PerfilActivity.this,MenuActivity.class);
                        intento2.putExtra("usuario", user);
                        intento2.putExtra("pass", pass);
                        intento2.putExtra("email", email);
                        intento2.putExtra("promo", promo);
                        startActivity(intento2);
                        finish();
                        break;
                    case(2):
                        Intent intento=new Intent(PerfilActivity.this,HealthyActivity.class);
                        intento.putExtra("usuario", user);
                        intento.putExtra("pass", pass);
                        intento.putExtra("email", email);
                        intento.putExtra("promo", promo);
                        startActivity(intento);
                        finish();
                        break;
                    case(3):
                        Intent intent=new Intent(PerfilActivity.this,MainActivity.class);
                        intent.putExtra("usuario", user);
                        intent.putExtra("pass", pass);
                        intent.putExtra("email", email);
                        intent.putExtra("promo", promo);
                        startActivity(intent);
                        finish();
                        break;
                }
                listView.setItemChecked(i,true);
                drawerLayout.closeDrawer(listView);
            }
        });
    }
    public class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Intent intento1=new Intent(PerfilActivity.this,Perfil2Fragment.class);
                    intento1.putExtra("user", user);
                    intento1.putExtra("pass", pass);
                    intento1.putExtra("email", email);
                    intento1.putExtra("promo", promo);
                    startActivity(intento1);
                    finish();
                    return new Perfil2Fragment();
                case 1: return new FavoritosFragment();
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
            case R.id.mCerrar:
                SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor= preferencias.edit();
                editor.putString("cerrar", "si");
                editor.commit();
                Intent intento3=new Intent(this,LogginActivity.class);
                intento3.putExtra("user", user);
                intento3.putExtra("pass", pass);
                intento3.putExtra("email", email);
                startActivity(intento3);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
*/

package com.example.kellyjohanazapataestrada.practica6;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends NavigationDraActivity
{

    String user,pass,email;
    String promo;
    TextView tUsuario,tContrasena,tCorreo;
    private String[] opciones = new String[] {"Mi Perfil", "Menu", "Healthy","Promociones"};
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToggle;
    SharedPreferences preferencias;
    String preferencia1,preferencia2,preferencia3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_perfil, contentFrameLayout);

        tUsuario=(TextView)findViewById(R.id.txtLogin2);
        tContrasena=(TextView)findViewById(R.id.txtPass2);
        tCorreo=(TextView)findViewById(R.id.txtEmail2);

        user=getIntent().getExtras().getString("user");
        pass=getIntent().getExtras().getString("pass");
        email=getIntent().getExtras().getString("email");
        promo = getIntent().getExtras().getString("promo");

        preferencias = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        preferencia1=preferencias.getString("user","");
        preferencia2=preferencias.getString("pass","");
        preferencia3=preferencias.getString("email","");

        tUsuario.setText(preferencia1);
        tContrasena.setText(preferencia2);
        tCorreo.setText(preferencia3);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
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
                        break;
                    case(1):
                        Intent intento1=new Intent(PerfilActivity.this,MenuActivity.class);
                        intento1.putExtra("user", user);
                        intento1.putExtra("pass", pass);
                        intento1.putExtra("email", email);
                        intento1.putExtra("promo", promo);
                        startActivity(intento1);
                        finish();
                        break;
                    case(2):
                        Intent intento=new Intent(PerfilActivity.this,HealthyActivity.class);
                        intento.putExtra("user", user);
                        intento.putExtra("pass", pass);
                        intento.putExtra("email", email);
                        intento.putExtra("promo", promo);
                        startActivity(intento);
                        finish();
                        break;
                    case(3):
                        Intent intent=new Intent(PerfilActivity.this,MainActivity.class);
                        intent.putExtra("user", user);
                        intent.putExtra("pass", pass);
                        intent.putExtra("email", email);
                        intent.putExtra("promo", promo);
                        startActivity(intent);
                        finish();
                        break;
                    case(4):
                        Intent intento4=new Intent(PerfilActivity.this,FavoritosActivity.class);
                        intento4.putExtra("user", user);
                        intento4.putExtra("pass", pass);
                        intento4.putExtra("email", email);
                        intento4.putExtra("promo", promo);
                        startActivity(intento4);
                        finish();
                        break;
                }
                listView.setItemChecked(i,true);
                drawerLayout.closeDrawer(listView);
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.abierto, R.string.cerrado){
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

        };

        drawerLayout.setDrawerListener(drawerToggle);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
            case R.id.mCerrar:
                SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor= preferencias.edit();
                editor.putString("cerrar", "si");
                editor.commit();
                Intent intent=new Intent(this,LogginActivity.class);
                intent.putExtra("user", user);
                intent.putExtra("pass", pass);
                intent.putExtra("email", email);
                startActivity(intent);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}