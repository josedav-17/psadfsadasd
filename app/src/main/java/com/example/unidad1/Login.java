package com.example.unidad1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button btnLogin, link_to_register;
    EditText correo, password;
    TextView  register_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        correo = findViewById(R.id.txtCorreo);
        password = findViewById(R.id.txtPass);

        register_error = findViewById(R.id.register_error);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQlite admin = new AdminSQlite(getApplicationContext(), "Admin", null, 1 );
                SQLiteDatabase db = admin.getWritableDatabase();

                String email = correo.getText().toString();
                String pass = password.getText().toString();

                Cursor fila = db.rawQuery("select Email,pass from usuario where Email='" +
                        email + "' and pass ='" + pass + "'", null);

                if(fila.moveToFirst()){
                    String txtEmail=fila.getString(0);
                    String txtPass=fila.getString(1);
                    if (txtEmail.equals(email) && txtPass.equals(pass)) {
                        Intent i = new Intent(Login.this, Inicio.class);
                        startActivity(i);
                    }
                }
            }
        });

        link_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), RegistroUsuario.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}