package com.magali.closetorganizerdos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.SkuDetails;
import com.magali.closetorganizer.R;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;

import java.io.IOException;


public class MainActivity extends Activity {


    private ImageButton buttonNuevaPrenda = null;
    private ImageButton buttonArmario = null;
    private ImageButton buttonInformacion = null;
    private ImageButton buttonAjustes = null;
    BillingProcessor bp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdBuddiz.setPublisherKey("6b2cded8-0a47-476b-b5de-b633c08fad36");
        AdBuddiz.cacheAds(this); // this = current Activity

        try {
            inicializar();
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonNuevaPrenda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                AdBuddiz.showAd(MainActivity.this);
                Intent i = new Intent(MainActivity.this,CrearPrendaActivity.class);
                startActivity(i);
            }});


        buttonArmario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
               AdBuddiz.showAd(MainActivity.this);
               Intent i = new Intent(MainActivity.this, PrimerFiltroActivity.class);
               startActivity(i);
            }
        });

        buttonInformacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                Intent i = new Intent(MainActivity.this,TutorialActivity.class);
                startActivity(i);
            }
        });

        buttonAjustes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                Intent i = new Intent(MainActivity.this,AjustesActivity.class);
                startActivity(i);
            }
        });


    }


    private void inicializar() throws IOException {
        ImageView iv = (ImageView)findViewById(R.id.imageViewFondotrans);
        iv.setAlpha(100);
        buttonNuevaPrenda = (ImageButton)findViewById(R.id.buttonNuevaPrenda);
        buttonArmario = (ImageButton)findViewById(R.id.buttonArmario);
        buttonInformacion = (ImageButton)findViewById(R.id.buttonInfo);
        buttonAjustes = (ImageButton)findViewById(R.id.buttonAjustes);
    }


}
