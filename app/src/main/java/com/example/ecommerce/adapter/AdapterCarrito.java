package com.example.ecommerce.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecommerce.R;
import com.example.ecommerce.Utils;
import com.example.ecommerce.database.Entity.carritoEntity;
import com.example.ecommerce.repository.dbRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterCarrito extends RecyclerView.Adapter<AdapterCarrito.ViewHolder> {

    private List<carritoEntity> itemsCarrito;
    private Activity activity;
    private dbRepository repository;

    public AdapterCarrito(Activity activity) {
        itemsCarrito = new ArrayList<>();
        this.activity = activity;
        repository = Utils.getInstanceRepository(activity.getApplicationContext());

    }

    public void addAll(List<carritoEntity> carritoEntities) {
        itemsCarrito.clear();
        itemsCarrito.addAll(carritoEntities);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final carritoEntity itemCart = itemsCarrito.get(position);

        holder.txNombre.setText(itemCart.getNombre());
        holder.txDescripcion.setText(itemCart.getDescripcion());
        holder.txValor.setText("$"+String.valueOf(itemCart.getValor()));
        holder.textcantidad.setText(String.valueOf(itemCart.getCantidad()));

        if (itemCart != null) {
            holder.btnminus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addCarrito(itemCart, false);
                }
            });

            holder.btnplus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addCarrito(itemCart, true);
                }
            });
        }
    }

    private void addCarrito(carritoEntity itemCart, boolean isAdd) {
        repository.getCarritoRepository().addRemoveProducto(itemCart, isAdd);
    }


    @Override
    public int getItemCount() {
        return itemsCarrito.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
