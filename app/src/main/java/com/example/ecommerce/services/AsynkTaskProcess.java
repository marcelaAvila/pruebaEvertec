package com.example.ecommerce.services;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;


import com.example.ecommerce.ObjectHttp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;

import static com.example.ecommerce.Constantes.URLPROCESSTRANSACTION;


public class AsynkTaskProcess extends AsyncTask<Void, Void, Boolean> {

    private Activity activity;
    private String parametros;
    String respuesta;
    Boolean estado;

    public AsynkTaskProcess(Activity activity,String parametros) {
        this.activity = activity;
        this.parametros = parametros;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        try {

            ObjectHttp httResponse = new ObjectHttp(activity);
            String responseStr = httResponse.obtenerHttpConDatos(URLPROCESSTRANSACTION,parametros);

            JSONObject jsonObject = new JSONObject(responseStr);

            estado = jsonObject.getBoolean("error");
            respuesta = jsonObject.getString("message");

            return true;

        } catch (ProtocolException e) {
            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
