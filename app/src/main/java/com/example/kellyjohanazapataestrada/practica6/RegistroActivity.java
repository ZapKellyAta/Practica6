package com.example.kellyjohanazapataestrada.practica6;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends LogginActivity
{
    //**********************************************
    //Creamos la base de datos
    Usuarios users;
    SQLiteDatabase dbUsers;
    ContentValues dataBD;
    //*************************************************
    Button btnSign;
    EditText txtUser, txtPass, txtRePass, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //****************************************
        //Base de datos
        users = new Usuarios(this,"dbUsers",null,1);
        dbUsers = users.getWritableDatabase();
        //****************************************

        btnSign = (Button)findViewById(R.id.btnSign);
        txtUser =  (EditText)findViewById(R.id.txtUser);
        txtPass = (EditText)findViewById(R.id.txtPass);
        txtRePass = (EditText)findViewById(R.id.txtRePass);
        txtEmail = (EditText)findViewById(R.id.txtEmail);

        btnSign.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String strUserName = txtUser.getText().toString();
                String strPass = txtPass.getText().toString();
                String strPass2 = txtRePass.getText().toString();
                String strEmail = txtEmail.getText().toString();

                if(TextUtils.isEmpty(strUserName))
                {
                    txtUser.setError("Ingrese Login");
                    Toast.makeText(RegistroActivity.this,"Ingrese Login",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(TextUtils.isEmpty(strPass))
                {
                    txtPass.setError("Ingrese Password");
                    Toast.makeText(RegistroActivity.this,"Ingrese Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(TextUtils.isEmpty(strPass2))
                {
                    txtRePass.setError("Repita Password");
                    Toast.makeText(RegistroActivity.this,"Repita Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(TextUtils.isEmpty(strEmail))
                {
                    txtEmail.setError("Ingrese Email");
                    Toast.makeText(RegistroActivity.this,"Ingrese Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if ((txtPass.getText().toString()).equals(txtRePass.getText().toString())!=true)
                {
                    Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Cursor c = dbUsers.rawQuery("select * FROM USUARIOS WHERE usuario = '"+strUserName+"'",null);
                    if(c.getCount()==0)
                    {
                        bandera = 1;

                        dataBD = new ContentValues();
                        dataBD.put("usuario",strUserName);
                        dataBD.put("contrasena",strPass);
                        dataBD.put("recontrasena",strPass2);
                        dataBD.put("email",strEmail);

                        dbUsers.insert("users",null,dataBD);
                        dbUsers.execSQL("INSERT INTO USUARIOS VALUES(null, '"+strUserName+"','"+strPass+"','"+strPass2+"','"+strEmail+"')");

                        Toast.makeText(getApplicationContext(), "Usuario Registrado exitosamente", Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(getApplicationContext(),LogginActivity.class);
                        intent.putExtra("user", strUserName);
                        intent.putExtra("pass", strPass);
                        intent.putExtra("email", strEmail);
                        Toast.makeText(RegistroActivity.this,"user " + strUserName,Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "El nombre de usuario ya existe", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

}
