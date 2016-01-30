package com.magali.closetorganizerdos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.magali.closetorganizer.R;

/**
 * Created by Magali on 17/05/2015.
 */
public class PrimerFiltroActivity extends Activity{

    private ImageButton botonCamiseta= null;
    private ImageButton botonPantalones= null;
    private ImageButton botonJersei= null;
    private ImageButton botonVestido= null;
    private ImageButton botonAbrigo= null;
    private ImageButton botonZapatos= null;
    private ImageButton botonMono= null;
    private ImageButton botonFalda= null;
    private ImageButton botonCinturon= null;
    private ImageButton botonShorts= null;
    private ImageButton botonLeggins= null;
    private ImageButton botonSombrero= null;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primerfiltro);


        iniciar();


        botonCamiseta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimerFiltroActivity.this, SegundoFiltroActivity.class);
                i.putExtra("tipoPrenda", "Shirt");
                startActivity(i);
                finish();
            }

        });
        botonPantalones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimerFiltroActivity.this, SegundoFiltroActivity.class);
                i.putExtra("tipoPrenda", "Trousers");
                startActivity(i);
                finish();
            }

        });
        botonJersei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimerFiltroActivity.this, SegundoFiltroActivity.class);
                i.putExtra("tipoPrenda", "Pullover");
                startActivity(i);
                finish();
            }

        });
        botonVestido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimerFiltroActivity.this, SegundoFiltroActivity.class);
                i.putExtra("tipoPrenda", "Dress");
                startActivity(i);
                finish();
            }

        });
        botonAbrigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimerFiltroActivity.this, SegundoFiltroActivity.class);
                i.putExtra("tipoPrenda", "Jacket");
                startActivity(i);
                finish();
            }

        });
        botonZapatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimerFiltroActivity.this, SegundoFiltroActivity.class);
                i.putExtra("tipoPrenda", "Shoes");
                startActivity(i);
                finish();
            }

        });
        botonMono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimerFiltroActivity.this, SegundoFiltroActivity.class);
                i.putExtra("tipoPrenda", "Jumpsuit");
                startActivity(i);
                finish();
            }

        });
        botonFalda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimerFiltroActivity.this, SegundoFiltroActivity.class);
                i.putExtra("tipoPrenda", "Skirt");
                startActivity(i);
                finish();
            }

        });
        botonCinturon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimerFiltroActivity.this, SegundoFiltroActivity.class);
                i.putExtra("tipoPrenda", "Belt");
                startActivity(i);
                finish();
            }

        });

        botonShorts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimerFiltroActivity.this, SegundoFiltroActivity.class);
                i.putExtra("tipoPrenda", "Shorts");
                startActivity(i);
                finish();
            }

        });

        botonLeggins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimerFiltroActivity.this, SegundoFiltroActivity.class);
                i.putExtra("tipoPrenda", "Leggins");
                startActivity(i);
                finish();
            }

        });

        botonSombrero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimerFiltroActivity.this, SegundoFiltroActivity.class);
                i.putExtra("tipoPrenda", "Hat");
                startActivity(i);
                finish();
            }

        });
    }

    private void iniciar() {

        botonCamiseta= (ImageButton)findViewById(R.id.buttonShirt);
        botonPantalones= (ImageButton)findViewById(R.id.buttonPantalones);
        botonJersei= (ImageButton)findViewById(R.id.buttonJersei);
        botonVestido= (ImageButton)findViewById(R.id.buttonVestido);
        botonAbrigo= (ImageButton)findViewById(R.id.buttonAbrigo);
        botonZapatos= (ImageButton)findViewById(R.id.buttonZapatos);
        botonMono= (ImageButton)findViewById(R.id.buttonMono);
        botonFalda= (ImageButton)findViewById(R.id.buttonFalda);
        botonCinturon= (ImageButton)findViewById(R.id.buttonBelt);
        botonShorts= (ImageButton)findViewById(R.id.buttonShorts);
        botonLeggins= (ImageButton)findViewById(R.id.buttonLeggins);
        botonSombrero= (ImageButton)findViewById(R.id.buttonHat);


    }


}
