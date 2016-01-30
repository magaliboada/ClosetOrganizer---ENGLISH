package com.magali.closetorganizerdos;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.magali.closetorganizer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magali on 17/05/2015.
 */
public class ConsultaPrimerActivity extends Activity implements
        AdapterView.OnItemClickListener {

    private TextView textInfo = null;
    ListView listView;
    List<RowItem> rowItems;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primerconsulta);

        Bundle bundle = getIntent().getExtras();
        Prenda nuevaPrenda2 = (Prenda)bundle.getSerializable("nuevaPrenda");

        System.out.println(nuevaPrenda2.toString());

        int cantidad = 0;

        int idPrenda;
        String tipoPrenda;
        String ocasion ;
        String temporada ;
        String color ;
        String material;
        String urlFoto ;
        String anotaciones ;
        ArrayList<Prenda> prendas = new ArrayList<Prenda>();






        try {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "prova", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String colorConsulta = nuevaPrenda2.getColor();
            String tipoPrendaConsulta = nuevaPrenda2.getTipoPrenda();

            String consulta = null;

            if(colorConsulta.isEmpty())
            {
                consulta = "SELECT idPrenda, tipoPrenda, ocasion, temporada, color, material, urlFoto, anotaciones  FROM Prenda WHERE tipoPrenda = '"+tipoPrendaConsulta +"';";
            }
            else
            {
                consulta = "SELECT idPrenda, tipoPrenda, ocasion, temporada, color, material, urlFoto, anotaciones  FROM Prenda WHERE tipoPrenda = '"+tipoPrendaConsulta +"' and color='"+colorConsulta+"';";
            }

            System.out.println(consulta);
            Cursor fila = bd.rawQuery(consulta, null);

            if (fila.moveToFirst()) {
                do {
                    idPrenda = Integer.parseInt(fila.getString(0));
                    tipoPrenda = (fila.getString(1));
                    ocasion = (fila.getString(2));
                    temporada = (fila.getString(3));
                    color = (fila.getString(4));
                    material = (fila.getString(5));
                    urlFoto = (fila.getString(6));
                    anotaciones = (fila.getString(7));
                    Prenda nuevaPrenda = new Prenda(idPrenda, tipoPrenda, temporada, ocasion, material, color, urlFoto, anotaciones);
                    prendas.add(nuevaPrenda);
                    ++cantidad;

                }while(fila.moveToNext());
            } else
                Toast.makeText(this, "No matches found", Toast.LENGTH_SHORT).show();
            bd.close();

            rowItems = new ArrayList<RowItem>();

            for (int i=0; i<prendas.size();++i)
            {
                RowItem item = new RowItem(prendas.get(i).getUrlFoto(), prendas.get(i).getIdPrenda()+" "+prendas.get(i).getMaterial()+ " "+prendas.get(i).getTipoPrenda() + ", " +prendas.get(i).getOcasion() + " ("+prendas.get(i).getTemporada()+")", prendas.get(i).getAnotaciones());
                rowItems.add(item);
            }

            listView = (ListView) findViewById(R.id.listView1);
            CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.list_item, rowItems);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);





    }
        catch(Exception ex)
        {

        }


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.list_item, rowItems);
        RowItem  item = adapter.getItem(position);

        System.out.println(item.getTitle());

        String titulo = item.getTitle();
        Intent i = new Intent(ConsultaPrimerActivity.this, gestionPrendaActivity.class);
        i.putExtra("titulo", titulo);
        startActivity(i);
        finish();
    }
}
