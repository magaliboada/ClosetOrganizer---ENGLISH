package com.magali.closetorganizerdos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.magali.closetorganizer.R;

/**
 * Created by Magali on 15/05/2015.
 */
public class CrearPropiedadesPrenda extends Activity {

    private ImageView imageViewPrenda = null;
    private Spinner spinnerTipoPrenda = null;
    private Spinner spinnerTemporada = null;
    private Spinner spinnerOcasion = null;
    private Prenda nuevaPrenda = null;
    private ImageButton botonAceptar = null;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearpropiedadesprenda);

        Bundle bundle = getIntent().getExtras();
        String path = bundle.getString("urlFoto");

        iniciar();

       // ColorFilter filter = new LightingColorFilter( Color.BLUE, Color.BLUE);
       // imageViewPrenda.setColorFilter(filter);

        nuevaPrenda.setUrlFoto(path);

        iniciarSpinner();

        spinnerTipoPrenda.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        Drawable drawable =null;
                        switch(position)
                        {
                            case 0:
                                drawable = getResources().getDrawable(
                                        R.drawable.shirt);
                                imageViewPrenda.setImageDrawable(drawable);
                                break;
                            case 1:
                                drawable = getResources().getDrawable(
                                        R.drawable.jeans);
                                imageViewPrenda.setImageDrawable(drawable);
                                break;
                            case 2:
                                drawable = getResources().getDrawable(
                                        R.drawable.pullover);
                                imageViewPrenda.setImageDrawable(drawable);break;
                            case 3:
                                drawable = getResources().getDrawable(
                                        R.drawable.dress);
                                imageViewPrenda.setImageDrawable(drawable);break;
                            case 4:
                                drawable = getResources().getDrawable(
                                        R.drawable.jacket);
                                imageViewPrenda.setImageDrawable(drawable);break;
                            case 5:
                                drawable = getResources().getDrawable(
                                        R.drawable.shoes);
                                imageViewPrenda.setImageDrawable(drawable);break;
                            case 6:
                                drawable = getResources().getDrawable(
                                        R.drawable.mono);
                                imageViewPrenda.setImageDrawable(drawable);break;
                            case 7:
                                drawable = getResources().getDrawable(
                                        R.drawable.skirt1);
                                imageViewPrenda.setImageDrawable(drawable);
                                break;
                            case 8:
                                drawable = getResources().getDrawable(
                                    R.drawable.shorts);
                            imageViewPrenda.setImageDrawable(drawable);break;
                            case 9:
                                drawable = getResources().getDrawable(
                                        R.drawable.belt);
                                imageViewPrenda.setImageDrawable(drawable);break;
                            case 10:
                                drawable = getResources().getDrawable(
                                        R.drawable.leggins);
                                imageViewPrenda.setImageDrawable(drawable);break;
                            case 11:
                                drawable = getResources().getDrawable(
                                        R.drawable.hat);
                                imageViewPrenda.setImageDrawable(drawable);
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                    //add some code here
                }
        );

        spinnerTemporada.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        switch(position) {
                            case 0:
                                imageViewPrenda.setBackgroundColor(Color.rgb(252, 130, 8));
                                break;
                            case 1:
                                imageViewPrenda.setBackgroundColor(Color.rgb(102, 102, 51));
                                break;
                            case 2:
                                imageViewPrenda.setBackgroundColor(Color.rgb(54, 90, 188));
                                break;
                            case 3:
                                imageViewPrenda.setBackgroundColor(Color.rgb(113, 216, 54));
                                break;
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                    //add some code here
                }
        );

        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                nuevaPrenda.setTipoPrenda(spinnerTipoPrenda.getSelectedItem().toString());
                nuevaPrenda.setTemporada(spinnerTemporada.getSelectedItem().toString());
                nuevaPrenda.setOcasion(spinnerOcasion.getSelectedItem().toString());
                Intent i = new Intent(CrearPropiedadesPrenda.this, CrearPropiedadesPredaDos.class);
                i.putExtra("nuevaPrenda", nuevaPrenda);
                startActivity(i);
                finish();
            }

        });

    }

    private void iniciarSpinner() {


        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.stylespinner,nuevaPrenda.getOpcionesTipoPrenda());
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoPrenda.setAdapter(spinnerArrayAdapter);

        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(this, R.layout.stylespinner, nuevaPrenda.getOpcionesTemporadaPrenda());
        spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTemporada.setAdapter(spinnerArrayAdapter2);

        ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(this, R.layout.stylespinner, nuevaPrenda.getOpcionesOcasionPrenda());
        spinnerArrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOcasion.setAdapter(spinnerArrayAdapter3);


    }

    private void iniciar() {
        nuevaPrenda = new Prenda();
        imageViewPrenda = (ImageView)findViewById(R.id.imageViewPrenda);
        spinnerTipoPrenda = (Spinner)findViewById(R.id.spinnerPrenda);
        spinnerTemporada = (Spinner)findViewById(R.id.spinnerTemporada);
        spinnerOcasion = (Spinner)findViewById(R.id.spinnerOcasion);
        botonAceptar = (ImageButton)findViewById(R.id.imageButtonAceptar);

    }
}
