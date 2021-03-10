package com.example.ecommerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;

import com.example.ecommerce.activities.CartActivity;
import com.example.ecommerce.repository.dbRepository;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

public class Utils {

    private static dbRepository repository = null;

    public static void changeToCarrito(Activity activity) {
        Intent i = new Intent(activity, CartActivity.class);
        activity.startActivity(i);
    }

    public static dbRepository getInstanceRepository(Context context) {
        if (repository == null) {
            repository = new dbRepository(context);
        }
        return repository;
    }

    public static NumberFormat nf() {
        Locale locale = new Locale("es", "CO");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf;
    }

    public static void updateCountCar(LifecycleOwner owner,final TextView textView,final dbRepository repository) {
        repository.getCarritoRepository().getCantidadTotal()
                .observe(owner, new Observer<Integer>() {
                    @Override
                    public void onChanged(@Nullable Integer integer) {
                        textView.setVisibility(integer == 0 ? View.INVISIBLE : View.VISIBLE);
                        textView.setText(String.valueOf(integer));
                    }
                });
    }

    public static String encodeTobase64(String dato) {
        byte[] b = dato.getBytes();
        String datoEncoded = Base64.encodeToString(b,Base64.DEFAULT);
        return datoEncoded;
    }

    public static String encodeToSHA256(String valor){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        byte[] hash = md.digest(valor.getBytes());
        StringBuffer sb = new StringBuffer();

        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}
