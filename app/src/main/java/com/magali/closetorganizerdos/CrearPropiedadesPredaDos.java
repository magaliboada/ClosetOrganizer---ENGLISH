package com.magali.closetorganizerdos;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.magali.closetorganizer.R;

/**
 * Created by Magali on 17/05/2015.
 */
public class CrearPropiedadesPredaDos extends Activity{

    private Spinner spinnerMaterial = null;
    private Spinner spinnerColor = null;
    private ImageButton buttonAceptar = null;
    private Prenda nuevaPrenda = null;
    private ImageView imageViewPrenda = null;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearpropiedadesprenda2);
        nuevaPrenda = (Prenda)getIntent().getSerializableExtra("nuevaPrenda");

        iniciar();
        iniciarSpinner();

        spinnerColor.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        switch(position) {
                            case 0:
                                imageViewPrenda.setBackgroundColor(Color.rgb(255, 255, 255));
                                break;
                            case 1:
                                imageViewPrenda.setBackgroundColor(Color.rgb(0, 0, 0));
                                break;
                            case 2:
                                imageViewPrenda.setBackgroundColor(Color.rgb(152, 161, 146));
                                break;
                            case 3:
                                imageViewPrenda.setBackgroundColor(Color.rgb(255, 0, 0));
                                break;
                            case 4:
                                imageViewPrenda.setBackgroundColor(Color.rgb(0, 102, 255));
                                break;
                            case 5:
                                imageViewPrenda.setBackgroundColor(Color.rgb(35, 155, 22));
                                break;
                            case 6:
                                imageViewPrenda.setBackgroundColor(Color.rgb(108, 77, 22));
                                break;
                            case 7:
                                imageViewPrenda.setBackgroundColor(Color.rgb(208, 184, 152));
                                break;
                            case 8:
                                imageViewPrenda.setBackgroundColor(Color.rgb(243, 169, 231));
                                break;
                            case 9:
                                imageViewPrenda.setBackgroundColor(Color.rgb(145, 41, 128));
                                break;
                            case 10:
                                imageViewPrenda.setBackgroundColor(Color.rgb(250, 160, 42));
                                break;
                            case 11:
                                imageViewPrenda.setBackgroundColor(Color.rgb(255, 255, 100));
                                break;
                            case 12:
                                imageViewPrenda.setBackgroundColor(Color.rgb(139, 126, 124));
                                break;
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                    //add some code here
                }
        );


        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                nuevaPrenda.setColor(spinnerColor.getSelectedItem().toString());
                nuevaPrenda.setMaterial(spinnerMaterial.getSelectedItem().toString());
                View parent = (View)v.getParent();
                insertarValores(parent);
                finish();
            }

        });
    }

    private void iniciarSpinner() {


        ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(this, R.layout.stylespinner, nuevaPrenda.getOpcionesMaterialPrenda());
        spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaterial.setAdapter(spinnerArrayAdapter5);

        ArrayAdapter<String> spinnerArrayAdapter6 = new ArrayAdapter<String>(this, R.layout.stylespinner, nuevaPrenda.getOpcionesColorPrenda());
        spinnerArrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColor.setAdapter(spinnerArrayAdapter6);
    }

    private void iniciar() {
        spinnerMaterial = (Spinner)findViewById(R.id.spinnerMaterial);
        spinnerColor = (Spinner)findViewById(R.id.spinnerColor);

        buttonAceptar = (ImageButton)findViewById(R.id.buttonAceptar);
        imageViewPrenda = (ImageView)findViewById(R.id.imageViewPrenda);
        spinnerColor.bringToFront();
        ImageView iv = (ImageView)findViewById(R.id.imageView6);
        iv.bringToFront();
    }

    public void insertarValores(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"prova", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String idPrenda = null;
        String tipoPrenda = nuevaPrenda.getTipoPrenda();
        String ocasion = nuevaPrenda.getOcasion();
        String temporada = nuevaPrenda.getTemporada();
        String color = nuevaPrenda.getColor();
        String material = nuevaPrenda.getMaterial();
        String urlFoto = nuevaPrenda.getUrlFoto();
        String anotaciones = nuevaPrenda.getAnotaciones();
        ContentValues registro = new ContentValues();  //es una clase para guardar datos
        registro.put("idPrenda", idPrenda);
        registro.put("tipoPrenda", tipoPrenda);
        registro.put("ocasion", ocasion);
        registro.put("temporada", temporada);
        registro.put("color", color);
        registro.put("material", material);
        registro.put("anotaciones", anotaciones);
        registro.put("urlFoto", urlFoto);
        bd.insert("Prenda", null, registro);
        bd.close();


    }

}
