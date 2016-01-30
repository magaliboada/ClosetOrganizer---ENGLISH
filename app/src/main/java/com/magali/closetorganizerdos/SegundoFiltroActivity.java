package com.magali.closetorganizerdos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.magali.closetorganizer.R;

/**
 * Created by Magali on 18/05/2015.
 */
public class SegundoFiltroActivity extends Activity{

    private Button botonBlanco = null;
    private Button botonNegro = null;
    private Button botonGris = null;
    private Button botonRojo = null;
    private Button botonAzul = null;
    private Button botonVerde = null;
    private Button botonMarron = null;
    private Button botonBeix = null;
    private Button botonRosa = null;
    private Button botonMorado = null;
    private Button botonNaranja = null;
    private Button botonAmarillo = null;
    private Button botonMulticolor = null;
    private String tipoPrenda = null;
    private Button botonSinFiltro = null;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundofiltro);
        Bundle bundle = getIntent().getExtras();
        tipoPrenda = bundle.getString("tipoPrenda");
        iniciar(bundle);


        botonBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("White");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonNegro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("Black");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonGris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("Grey");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("Red");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("Blue");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("Green");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonMarron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("Brown");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonBeix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("Beige");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonRosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("Pink");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonMorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("Purple");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonNaranja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("Orange");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonAmarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("Yellow");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonMulticolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("Multicolor");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });
        botonSinFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prenda pasarPrenda = new Prenda();
                pasarPrenda.setTipoPrenda(tipoPrenda);

                Intent i = new Intent(SegundoFiltroActivity.this, ConsultaPrimerActivity.class);
                pasarPrenda.setColor("");
                i.putExtra("nuevaPrenda", pasarPrenda);
                startActivity(i);
                finish();
            }

        });



    }

    private void iniciar(Bundle bundle) {

        botonBlanco = (Button)findViewById(R.id.buttonBlanco);
        botonNegro = (Button)findViewById(R.id.buttonNegro);
        botonGris = (Button)findViewById(R.id.buttonGris);
        botonRojo = (Button)findViewById(R.id.buttonRojo);
        botonAzul = (Button)findViewById(R.id.buttonAzul);
        botonVerde = (Button)findViewById(R.id.buttonVerde);
        botonMarron = (Button)findViewById(R.id.buttonMarron);
        botonBeix = (Button)findViewById(R.id.buttonBeix);
        botonRosa = (Button)findViewById(R.id.buttonRosa);
        botonMorado = (Button)findViewById(R.id.buttonMorado);
        botonNaranja = (Button)findViewById(R.id.buttonNaranja);
        botonAmarillo = (Button)findViewById(R.id.buttonAmarillo);
        botonMulticolor = (Button)findViewById(R.id.buttonMulticolor);
        botonSinFiltro = (Button)findViewById(R.id.buttonSinFiltro);

    }
}
