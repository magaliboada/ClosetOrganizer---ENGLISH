package com.magali.closetorganizerdos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.magali.closetorganizer.R;

/**
 * Created by Magali on 20/05/2015.
 */
public class gestionPrendaActivity extends Activity{

    private Button botonBorrar=null;
    private Button botonGuardar=null;
    private EditText textoEditar = null;
    private TextView texto = null;
    private int codigo = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionprenda);

        Bundle bundle = getIntent().getExtras();
        String desc = bundle.getString("titulo");

        desc = desc.split(" ")[0];
        final int codigoPrenda = Character.getNumericValue(desc.charAt(0));

        botonBorrar = (Button)findViewById(R.id.buttonBorrar);
        botonGuardar = (Button)findViewById(R.id.buttonGuardar);
        textoEditar = (EditText)findViewById(R.id.textoEditar);
        texto = (TextView)findViewById(R.id.textoVariable);

        codigo=codigoPrenda;
       actualizarLista(codigoPrenda);


        botonBorrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                AlertDialog diaBox = AskOption();
                diaBox.show();

            }
        });




        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(gestionPrendaActivity.this.getApplicationContext(), "prova", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                String anotacion = textoEditar.getText().toString();
                ContentValues registro = new ContentValues();
                registro.put("anotaciones", anotacion);
                int cant = bd.update("Prenda", registro, "idPrenda=" + codigoPrenda, null);
                bd.close();
                finish();
            }

        });


    }


    public void actualizarLista(int codigoPrenda)
    {
        try {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(gestionPrendaActivity.this.getApplicationContext(), "prova", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String consulta = "SELECT anotaciones  FROM Prenda WHERE idPrenda = " + codigoPrenda + ";";
            System.out.println(consulta);
            Cursor fila = bd.rawQuery(consulta, null);

            if (fila.moveToFirst()) {
                String anotaciones = (fila.getString(0));
                textoEditar.setText(anotaciones);
            }
            else
                Toast.makeText(gestionPrendaActivity.this.getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

            bd.close();

        } catch (Exception ex) {
            Toast.makeText(gestionPrendaActivity.this.getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }
    }
    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Delete Wear")
                .setMessage("Are you sure you want to delete this wear?")
                .setIcon(R.drawable.rubbishdos)

                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {

                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(gestionPrendaActivity.this.getApplicationContext(), "prova", null, 1);
                        SQLiteDatabase bd = admin.getWritableDatabase();
                        String id = codigo+"";
                        int cant = bd.delete("Prenda", "idPrenda=" + id, null);
                        bd.close();
                        finish();


                        dialog.dismiss();
                    }

                })



                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();
        return myQuittingDialogBox;

    }

}
