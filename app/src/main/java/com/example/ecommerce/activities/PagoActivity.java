package com.example.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.R;
import com.example.ecommerce.Utils;
import com.example.ecommerce.repository.dbRepository;

public class PagoActivity extends AppCompatActivity {

    ImageView btPago, imgcart;
    TextView cart_badge;

    private dbRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);

        btPago = findViewById(R.id.btPago);
        imgcart = findViewById(R.id.imgcart);
        cart_badge = findViewById(R.id.cart_badge);
        imgcart.setVisibility(View.GONE);
        cart_badge.setVisibility(View.GONE);

        repository = Utils.getInstanceRepository(this);

        btPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*repository.getCarritoRepository().deleteAll();
                Toast.makeText(getApplicationContext(),"Se esta procesando el pago",Toast.LENGTH_LONG).show();*/
                Intent intent = new Intent(PagoActivity.this,DatosPagoActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}