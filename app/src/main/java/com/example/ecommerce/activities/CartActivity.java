package com.example.ecommerce.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.R;
import com.example.ecommerce.Utils;
import com.example.ecommerce.adapter.AdapterCarrito;
import com.example.ecommerce.database.Entity.carritoEntity;
import com.example.ecommerce.repository.dbRepository;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    private AdapterCarrito adapterCarrito;
    private RecyclerView recyclerCart;
    private TextView subtotal;
    private Button btnTotal;

    private dbRepository repository;

    private int valorTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        subtotal = findViewById(R.id.subtotal);
        btnTotal = findViewById(R.id.btnTotal);
        btnTotal.setOnClickListener(this);
        adapterCarrito = new AdapterCarrito(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerCart = findViewById(R.id.recyclerCart);
        recyclerCart.setLayoutManager(linearLayoutManager);
        recyclerCart.setAdapter(adapterCarrito);

        repository = Utils.getInstanceRepository(this);

        setObserver();
    }

    private void setObserver() {
        repository.getCarritoRepository().getAll().observe(
                this, new Observer<List<carritoEntity>>() {
                    @Override
                    public void onChanged(@Nullable List<carritoEntity> carritoEntities) {
                        adapterCarrito.addAll(carritoEntities);
                        calcularTotales();
                    }
                }
        );
    }


    private void calcularTotales() {
        valorTotal = repository.getCarritoRepository().getValorTotal();
        String valorPagar = Utils.nf().format(valorTotal);
        String totalPagar = "Total a pagar" + " " + valorPagar;
        subtotal.setText(valorPagar);
        btnTotal.setText(totalPagar);
    }

    @Override
    public void onClick(View view) {
        if (view == btnTotal) {
            if (adapterCarrito.getItemCount() != 0) {

                Intent intent = new Intent(this,PagoActivity.class);
                startActivity(intent);

            } else {
                Toast.makeText(getApplicationContext(),"No hay productos",Toast.LENGTH_LONG).show();
            }
        }
    }
}
