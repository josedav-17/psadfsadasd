package com.example.unidad1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroUsuario extends AppCompatActivity {

    Button btnRegister;
    EditText documents, correo, pass, nombre;

    TextView link_to_login, register_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        documents = findViewById(R.id.txtDocuments);
        correo = findViewById(R.id.txtCorreo);
        pass = findViewById(R.id.txtPass);
        nombre = findViewById(R.id.txtNombre);

        register_error = findViewById(R.id.register_error);
        link_to_login = findViewById(R.id.link_to_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQlite admin = new AdminSQlite(getApplicationContext(), "Admin", null, 1 );
                SQLiteDatabase db = admin.getWritableDatabase();

                String name = nombre.getText().toString();
                int documento = Integer.parseInt(documents.getText().toString());
                String email = correo.getText().toString();
                String password  = pass.getText().toString();

                ContentValues Datos = new ContentValues();
                Datos.put("documento", documento);
                Datos.put("nombre", name);
                Datos.put("correo", email);
                Datos.put("Contraseña", password);

                db.insert("usuario", null, Datos);
                db.close();

            }
        });

        link_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
