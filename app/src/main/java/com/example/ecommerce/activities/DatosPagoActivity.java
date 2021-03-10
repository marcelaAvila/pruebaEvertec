package com.example.ecommerce.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.ecommerce.R;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.ecommerce.Constantes.CEDULA;
import static com.example.ecommerce.Constantes.CELULAR;
import static com.example.ecommerce.Constantes.CODIGOSE;
import static com.example.ecommerce.Constantes.CORREO;
import static com.example.ecommerce.Constantes.FECHAVEN;
import static com.example.ecommerce.Constantes.NOMBRE;
import static com.example.ecommerce.Constantes.NUMTARCREDIT;

public class DatosPagoActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNombre, etCedula, etCorreo, etCelular, etNumeroTarjeta, etFechaVen, etCodigo;
    Button btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_pago);

        bindUI();

    }

    public void bindUI() {
        etNombre = (EditText) findViewById(R.id.etNombre);
        etCedula = (EditText) findViewById(R.id.etCedula);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etNumeroTarjeta = (EditText) findViewById(R.id.etNumeroTarjeta);
        etFechaVen = (EditText) findViewById(R.id.etFechaVen);
        etCodigo = (EditText) findViewById(R.id.etCodigo);
        etCelular = (EditText) findViewById(R.id.etCelular);
        btNext = (Button) findViewById(R.id.btNext);
        btNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btNext:
                enviarvalidador();
                break;
        }
    }

    public void enviarvalidador() {
        boolean cancel = false;
        View focusView = null;

        String etNombre1, etCedula1, etCorreo1, etNumeroTarjeta1, etFechaVen1, etCodigo1, etCelular1;
        etNombre1 = etNombre.getText().toString();
        etCedula1 = etCedula.getText().toString();
        etCorreo1 = etCorreo.getText().toString();
        etNumeroTarjeta1 = etNumeroTarjeta.getText().toString();
        etFechaVen1 = etFechaVen.getText().toString();
        etCodigo1 = etCodigo.getText().toString();
        etCelular1 = etCelular.getText().toString();

        if (TextUtils.isEmpty(etNombre1)) {

            etNombre.setError("Este campo es requerido");
            focusView = etNombre;
            cancel = true;
        } else if (TextUtils.isEmpty(etCedula1)) {

            etCedula.setError("Este campo es requerido");
            focusView = etCedula;
            cancel = true;
        } else if (TextUtils.isEmpty(etCorreo1)) {
            etCorreo.setError("Este campo es requerido");
            focusView = etCorreo;
            cancel = true;
        } else if (TextUtils.isEmpty(etNumeroTarjeta1)) {
            etNumeroTarjeta.setError("Este campo es requerido");
            focusView = etNumeroTarjeta;
            cancel = true;
        } else if (TextUtils.isEmpty(etFechaVen1)) {
            etFechaVen.setError("Este campo es requerido");
            focusView = etFechaVen;
            cancel = true;
        } else if (TextUtils.isEmpty(etCodigo1)) {
            etCodigo.setError("Este campo es requerido");
            focusView = etCodigo;
            cancel = true;
        } else if (TextUtils.isEmpty(etCelular1)) {
            etCelular.setError("Este campo es requerido");
            focusView = etCelular;
            cancel = true;
        }


        if (cancel) {
            focusView.requestFocus();
        } else {
            gotoNext();
        }
    }

    public void gotoNext() {
        Intent intent = new Intent(DatosPagoActivity.this,ConfirmacionPagoActivity.class);
        intent.putExtra(NOMBRE, etNombre.getText().toString());
        intent.putExtra(CEDULA, etCedula.getText().toString());
        intent.putExtra(CORREO, etCorreo.getText().toString());
        intent.putExtra(CELULAR, etCelular.getText().toString());
        intent.putExtra(NUMTARCREDIT, etNumeroTarjeta.getText().toString());
        intent.putExtra(FECHAVEN, etFechaVen.getText().toString());
        intent.putExtra(CODIGOSE, etCodigo.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}