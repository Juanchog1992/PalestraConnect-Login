package com.example.palestraconnect;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etCorreo, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCorreo = findViewById(R.id.etCorreo);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {

            String correo = etCorreo.getText().toString();
            String password = etPassword.getText().toString();

            if(correo.equals("admin@palestra.com") &&
                    password.equals("1234")) {

                Intent intent = new Intent(MainActivity.this,
                        HomeActivity.class);

                startActivity(intent);

            } else {

                Toast.makeText(MainActivity.this,
                        "Correo o contraseña incorrectos",
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
}