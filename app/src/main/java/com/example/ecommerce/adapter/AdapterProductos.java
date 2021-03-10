package com.example.ecommerce.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecommerce.ProductosItem;
import com.example.ecommerce.R;
import com.example.ecommerce.Utils;
import com.example.ecommerce.database.Entity.carritoEntity;
import com.example.ecommerce.repository.dbRepository;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.ViewHolder> {

    private ArrayList<ProductosItem> names;
    private Activity activity;
    private dbRepository repository;

    public AdapterProductos(ArrayList<ProductosItem> names,Activity activity) {
        this.names = names;
        this.activity = activity;
        repository = Utils.getInstanceRepository(activity.getApplicationContext());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.productos_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,int position) {

        final ProductosItem productosItem = names.get(position);
        holder.txNombre.setText(productosItem.getNombre());
        holder.txDescripcion.setText(productosItem.getDescripcion());
        holder.txValor.setText("$"+String.valueOf(productosItem.getValor()));

        getCantidad(productosItem,holder.textcantidad);

        holder.btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCarrito(true,productosItem, holder.textcantidad);
            }
        });

        holder.btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCarrito(false,productosItem, holder.textcantidad);
            }
        });
    }

    private void addCarrito(Boolean isAdd,ProductosItem productosItem, TextView textcantidad) {
        carritoEntity carrito = repository.getCarritoRepository()
                .getCarrito(productosItem.getId());

        if (carrito == null) {
            carrito = new carritoEntity(
                    productosItem.getId(),
                    productosItem.getNombre(),
                    productosItem.getDescripcion(),
                    productosItem.getCantidad(),
                    productosItem.getValor()
            );
        }

        repository.getCarritoRepository().addRemoveProducto(carrito, isAdd);
        getCantidad(productosItem, textcantidad);

    }

    private void getCantidad(ProductosItem productosItem,TextView textcantidad) {
        carritoEntity carrito = repository.getCarritoRepository()
                .getCarrito(productosItem.getId());
        textcantidad.setText(String.valueOf(carrito == null ? 0 : carrito.getCantidad()));

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardProductos;
        public ImageView imagen;
        public TextView txNombre, txDescripcion, txValor, textcantidad;
        private ImageView btnminus;
        private ImageView btnplus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cardProductos = (CardView) itemView.findViewById(R.id.cardProductos);
            this.imagen = (ImageView) itemView.findViewById(R.id.imagen);
            this.txNombre = (TextView) itemView.findViewById(R.id.txNombre);
            this.txDescripcion = (TextView) itemView.findViewById(R.id.txDescripcion);
            this.txValor = (TextView) itemView.findViewById(R.id.txValor);
            this.textcantidad = (TextView) itemView.findViewById(R.id.textcantidad);

            btnminus = itemView.findViewById(R.id.btnminus);
            btnplus = itemView.findViewById(R.id.btnplus);
        }
    }
}
