package com.example.ecommerce.repository;

import android.content.Context;

import com.example.ecommerce.database.AppDatabase;

public class dbRepository {
    private Context context;

    private AppDatabase appDatabase;

    private com.example.ecommerce.repository.carritoRepository carritoRepository;

    public dbRepository(Context context) {
        this.context = context;
        this.appDatabase = AppDatabase.getDatabase(context);

        this.carritoRepository = new carritoRepository(context, appDatabase);
    }

    public carritoRepository getCarritoRepository() {
        return carritoRepository;
    }
}
