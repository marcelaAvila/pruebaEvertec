package com.example.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecommerce.R;

public class LoginActivity extends AppCompatActivity {

    EditText etUser, etPass;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindUI();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();

                if (login(user, pass)) {
                    goToMain();
                }
            }
        });
    }

    public void bindUI() {
        etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);
        button = (Button) findViewById(R.id.button);

    }

    public boolean login(String user, String pass) {
        String credenciales = "admin";
        if (!user.isEmpty() || !pass.isEmpty()) {
            if (user.equals(credenciales)) {
                if (pass.equals(credenciales)) {
                    return true;
                } else {
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_LONG).show();
                    return false;
                }
            } else {
                Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_LONG).show();
                return false;
            }
        } else {
            Toast.makeText(this, "Existen campos vacios", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    @Override

    public void onBackPressed() {
        finishAffinity();
    }
}