package com.example.ecommerce.interfaces;

import com.example.ecommerce.database.Entity.carritoEntity;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface carritoInterface extends BaseRepositoryInterface<carritoEntity> {

    int getValorTotal();
    void addRemoveProducto(carritoEntity carrito, boolean isAdd);
    LiveData<Integer> getCantidadTotal();
    LiveData<List<carritoEntity>> getAll();
    carritoEntity getCarrito(String sku);
    void deleteAll();
}
