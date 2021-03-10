package com.example.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecommerce.ProductosItem;
import com.example.ecommerce.R;
import com.example.ecommerce.Utils;
import com.example.ecommerce.adapter.AdapterProductos;
import com.example.ecommerce.repository.dbRepository;

import java.util.ArrayList;

import static com.example.ecommerce.Utils.updateCountCar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerProductos;
    TextView txtBadge;
    private ImageView ivCard;
    AdapterProductos adapterProductos;
    ArrayList<ProductosItem> productosItems;
    private dbRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindUI();
        repository = Utils.getInstanceRepository(getApplicationContext());
        productosItems = new ArrayList<>();
        productosItems = this.getAllItems();
        adapterProductos = new AdapterProductos(productosItems, this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerProductos.setLayoutManager(llm);
        recyclerProductos.setAdapter(adapterProductos);

        updateCountCar(this, txtBadge, repository);
    }

    public void bindUI() {
        recyclerProductos = (RecyclerView) findViewById(R.id.recyclerProductos);
        txtBadge = findViewById(R.id.cart_badge);
        ivCard = findViewById(R.id.imgcart);
        ivCard.setOnClickListener(this);
    }

    private ArrayList<ProductosItem> getAllItems(){
        final ArrayList<ProductosItem> names = new ArrayList<>();
        return new ArrayList<ProductosItem>(){{
            add(new ProductosItem("1","Producto 1", "Descripcion de producto 1", 0,21000));
            add(new ProductosItem("2","Producto 2", "Descripcion de producto 2", 0,13000));
            add(new ProductosItem("3","Producto 3", "Descripcion de producto 3", 0,10000));
            add(new ProductosItem("4","Producto 4", "Descripcion de producto 4", 0,9000));
            add(new ProductosItem("5","Producto 5", "Descripcion de producto 5", 0,20000));
            add(new ProductosItem("6","Producto 6", "Descripcion de producto 6", 0,10000));
            add(new ProductosItem("7","Producto 7", "Descripcion de producto 7", 0,15000));
        }};
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, CartActivity.class);
        startActivity(i);
    }
}