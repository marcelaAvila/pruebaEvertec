package com.example.ecommerce.repository;

import android.content.Context;

import com.example.ecommerce.interfaces.carritoInterface;
import com.example.ecommerce.database.AppDatabase;
import com.example.ecommerce.database.DAO.carritoDao;
import com.example.ecommerce.database.Entity.carritoEntity;

import java.util.List;

import androidx.lifecycle.LiveData;

public class carritoRepository implements carritoInterface {

    private Context context;

    private carritoDao carritoDao;

    public carritoRepository(Context context, AppDatabase appDatabase) {
        this.context = context;
        carritoDao = appDatabase.carritoDao();
    }

    @Override
    public void addRemoveProducto(carritoEntity carrito, boolean isAdd) {
        int cant = carrito == null ? 0 : carrito.getCantidad();
        //int cant = 0;
        cant = isAdd ? cant + 1 : cant - 1 ;

        if (cant <= 0) {
            cant = 0;
        }

        carrito.setCantidad(cant);

        if (cant == 0) {
            carritoDao.deleteCarrito(carrito);
        } else {
            carritoDao.addCarrito(carrito);
        }

    }

    @Override
    public carritoEntity getCarrito(String sku) {
        return carritoDao.getCarrito(sku);
    }

    @Override
    public int getValorTotal() {
        return carritoDao.getValorTotal();
    }

    @Override
    public LiveData<Integer> getCantidadTotal() {
        return carritoDao.getCantidadTotal();
    }

    @Override
    public LiveData<List<carritoEntity>> getAll() {
        return carritoDao.getAllCarrito();
    }

    @Override
    public void add(carritoEntity entity) {
        carritoDao.addCarrito(entity);
    }

    @Override
    public void update(carritoEntity entity) {
        carritoDao.updateCarrito(entity);
    }

    @Override
    public void delete(carritoEntity entity) {
        carritoDao.deleteCarrito(entity);
    }

    @Override
    public void deleteAll() {
        carritoDao.deleteAllCarrito();
    }
}
