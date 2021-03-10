package com.example.ecommerce.database.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ecommerce.database.Entity.carritoEntity;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface carritoDao {

    @Insert(onConflict = REPLACE)
    long addCarrito(carritoEntity productos);

    @Update
    int updateCarrito(carritoEntity productos);

    @Delete
    void deleteCarrito(carritoEntity productos);

    @Query("DELETE FROM Carrito")
    void deleteAllCarrito();

    @Query("SELECT * FROM Carrito ORDER BY nombre")
    LiveData<List<carritoEntity>> getAllCarrito();

    @Query("SELECT IFNULL(SUM(cantidad), 0) FROM Carrito")
    LiveData<Integer> getCantidadTotal();

    @Query("SELECT SUM(valor * cantidad) FROM Carrito")
    int getValorTotal();

    @Query("SELECT * FROM Carrito WHERE id = :sku LIMIT 1")
    carritoEntity getCarrito(String sku);
}
