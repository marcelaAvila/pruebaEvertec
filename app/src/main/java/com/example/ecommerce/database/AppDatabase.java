package com.example.ecommerce.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ecommerce.database.DAO.carritoDao;
import com.example.ecommerce.database.Entity.carritoEntity;

@Database(entities = {carritoEntity.class
}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract carritoDao carritoDao();

    public static AppDatabase getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "ecommerce")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
