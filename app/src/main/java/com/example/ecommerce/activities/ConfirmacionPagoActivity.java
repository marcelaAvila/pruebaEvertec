package com.example.ecommerce.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ecommerce.R;
import com.example.ecommerce.pojo.processTransaction.auth;
import com.example.ecommerce.pojo.processTransaction.buyer;
import com.example.ecommerce.pojo.processTransaction.instrument.card;
import com.example.ecommerce.pojo.processTransaction.instrument.credit;
import com.example.ecommerce.pojo.processTransaction.instrument.instrument;
import com.example.ecommerce.pojo.processTransaction.payer;
import com.example.ecommerce.pojo.processTransaction.payment.amount;
import com.example.ecommerce.pojo.processTransaction.payment.details;
import com.example.ecommerce.pojo.processTransaction.payment.payment;
import com.example.ecommerce.pojo.processTransaction.payment.taxes;
import com.example.ecommerce.pojo.processTransaction.process;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.ecommerce.Constantes.CEDULA;
import static com.example.ecommerce.Constantes.CELULAR;
import static com.example.ecommerce.Constantes.CODIGOSE;
import static com.example.ecommerce.Constantes.CORREO;
import static com.example.ecommerce.Constantes.FECHAVEN;
import static com.example.ecommerce.Constantes.LOCALE;
import static com.example.ecommerce.Constantes.LOGIN;
import static com.example.ecommerce.Constantes.NOMBRE;
import static com.example.ecommerce.Constantes.NUMTARCREDIT;
import static com.example.ecommerce.Constantes.TRANKEY;
import static com.example.ecommerce.Constantes.USERAGENT;
import static com.example.ecommerce.Utils.encodeToSHA256;
import static com.example.ecommerce.Utils.encodeTobase64;

public class ConfirmacionPagoActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txNombre, txCedula, txCorreo, txCelular, txNumeroTarjeta, txFechaVen, txCodigo;
    Button btAtras, btConfirmar;

    String nombre, cedula, correo, celular, numTarjeta, fechaVen, codigo;

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_pago);
        bindUI();
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().disableHtmlEscaping().create();

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null) {
            nombre = parametros.getString(NOMBRE);
            cedula = parametros.getString(CEDULA);
            correo = parametros.getString(CORREO);
            celular = parametros.getString(CELULAR);
            numTarjeta = parametros.getString(NUMTARCREDIT);
            fechaVen = parametros.getString(FECHAVEN);
            codigo = parametros.getString(CODIGOSE);

        }

        txNombre.setText("Nombre: " + nombre);
        txCedula.setText("Cedula: " + cedula);
        txCelular.setText("Celular: " + celular);
        txCorreo.setText("Correo: " + correo);
        txNumeroTarjeta.setText("Numero de la tarjeta de credito: " + numTarjeta);
        txFechaVen.setText("Fecha de vencimiento: " + fechaVen);
        txCodigo.setText("Codigo de seguridad: " + codigo);


    }

    public void bindUI() {
        txNombre = (TextView) findViewById(R.id.txNombre);
        txCedula = (TextView) findViewById(R.id.txCedula);
        txCorreo = (TextView) findViewById(R.id.txCorreo);
        txNumeroTarjeta = (TextView) findViewById(R.id.txNumeroTarjeta);
        txFechaVen = (TextView) findViewById(R.id.txFechaVen);
        txCodigo = (TextView) findViewById(R.id.txCodigo);
        txCelular = (TextView) findViewById(R.id.txCelular);
        btAtras = (Button) findViewById(R.id.btAtras);
        btConfirmar = (Button) findViewById(R.id.btConfirmar);
        btAtras.setOnClickListener(this);
        btConfirmar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btAtras:
                finish();
                break;
            case R.id.btConfirmar:
                guardarDatos();
                break;
        }
    }

    public void guardarDatos() {
        createJSON();

        gotoNext();
    }

    public void createJSON() {

        Random aleatorio = new Random(System.currentTimeMillis());
        // Producir nuevo int aleatorio entre 0 y 99
        int intAletorio = aleatorio.nextInt(100000);

        String nonce = String.valueOf(intAletorio);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ",Locale.UK);
        String seed = sdf.format(new Date());

        String cadena = nonce + seed + TRANKEY;

        auth auth = new auth();
        auth.setLogin(LOGIN);
        auth.setTranKey(encodeTobase64(encodeToSHA256(cadena)));
        auth.setNonce(encodeTobase64(nonce));
        auth.setSeed(seed);


        details details = new details();
        details.setAmount(2);
        details.setKind("shipping");

        taxes taxes = new taxes();
        taxes.setAmount(4.8);
        taxes.setBase(40);
        taxes.setKind("ice");

        amount amount = new amount();
        amount.setCurrency("COP");
        amount.setTotal(0.0);
        amount.setDetails(details);
        amount.setTaxes(taxes);

        payment payment = new payment();
        payment.setReference("TEST_20171108_144400");
        payment.setDescription("Ipsam quia sunt dolore minus atque blanditiis corrupti.");
        payment.setAmount(amount);

        card card = new card();
        card.setNumber(numTarjeta);
        card.setExpirationYear(fechaVen);
        card.setExpirationMonth(fechaVen);
        card.setCvv(codigo);

        credit credit = new credit();
        credit.setCode("1");
        credit.setGroupCode("P");
        credit.setInstallment("24");
        credit.setType("02");

        instrument instrument = new instrument();
        instrument.setCard(card);
        instrument.setCredit(credit);
        instrument.setOtp("a8ecc59c2510a8ae27e1724ebf4647b5");

        payer payer = new payer();
        payer.setDocument(cedula);
        payer.setDocumentType("CC");
        payer.setEmail(correo);
        payer.setMobile(celular);
        payer.setName(nombre);
        payer.setSurname(nombre);

        buyer buyer = new buyer();
        payer.setDocument(cedula);
        payer.setDocumentType("CC");
        payer.setEmail(correo);
        payer.setMobile(celular);
        payer.setName(nombre);
        payer.setSurname(nombre);

        process process = new process();
        process.setAuth(auth);
        process.setBuyer(buyer);
        process.setInstrument(instrument);
        process.setIpAddress(getIP());
        process.setLocale(LOCALE);
        process.setPayer(payer);
        process.setPayment(payment);
        process.setUserAgent(USERAGENT);

        String jsonString = gson.toJson(auth);
        System.out.println(jsonString);
    }

    public static String getIP(){
        List<InetAddress> addrs;
        String address = "";
        try{
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for(NetworkInterface intf : interfaces){
                addrs = Collections.list(intf.getInetAddresses());
                for(InetAddress addr : addrs){
                    if(!addr.isLoopbackAddress() && addr instanceof Inet4Address){
                        address = addr.getHostAddress().toUpperCase(new Locale("es", "MX"));
                    }
                }
            }
        }catch (Exception e){
            Log.w("ERROR IP", "Ex getting IP value " + e.getMessage());
        }
        return address;
    }

    public void gotoNext() {
        /*Intent intent = new Intent(CapturaDatosActivity.this,FotoActivity.class);
        startActivity(intent);*/


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}