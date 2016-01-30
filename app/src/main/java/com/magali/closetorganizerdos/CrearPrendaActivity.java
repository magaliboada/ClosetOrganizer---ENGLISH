package com.magali.closetorganizerdos;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.magali.closetorganizer.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Magali on 14/05/2015.
 */
public class CrearPrendaActivity extends Activity{

    private TextView parametroURL;
    private ImageButton botonCamara = null;
    private ImageButton botonGaleria = null;
    private ImageButton botonAceptar = null;
    private ImageView imagenSeleccionada = null;
   private static final int CAMERA_REQUEST = 200;
    private static final int SELECT_PHOTO = 100;
    private boolean imagenSel = false;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearprenda);

        inicializar();


        botonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //camera stuff
                Intent imageIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                String nom = getCode();

                //folder stuff
                File imagesFolder = new File(Environment.getExternalStorageDirectory(), "Closet");
                imagesFolder.mkdirs();

                File image = new File(imagesFolder, "CL_" + nom + ".png");
                Uri uriSavedImage = Uri.fromFile(image);


                parametroURL.setText(image.getPath());

                imageIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                startActivityForResult(imageIntent, CAMERA_REQUEST);


            }

        });

        botonGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);


            }

        });

        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(imagenSel)
                {
                    Intent i = new Intent(CrearPrendaActivity.this, CrearPropiedadesPrenda.class);
                    i.putExtra("urlFoto", parametroURL.getText().toString());
                    startActivity(i);
                    finish();
                }
            }

        });



    }


    private void inicializar() {
        botonCamara = (ImageButton)findViewById(R.id.buttonCamara);
        botonGaleria = (ImageButton)findViewById(R.id.buttonGaleria);
        botonAceptar = (ImageButton)findViewById(R.id.buttonAceptar);
        imagenSeleccionada = (ImageView)findViewById(R.id.imageViewPrenda);
        parametroURL = (TextView)findViewById(R.id.parametroURL);

    }

    @SuppressLint("SimpleDateFormat")
    private String getCode()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        String date = dateFormat.format(new Date() );
        String photoCode = "pic_" + date;
        return photoCode;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode)
        {
            case SELECT_PHOTO:
            if(resultCode == RESULT_OK)
            {
                Uri selectedImage = data.getData();
                String x = getRealPathFromURI(selectedImage);
                InputStream imageStream = null;
                try {
                    imageStream = getContentResolver().openInputStream(selectedImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                parametroURL.setText(x);
                Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
                Bitmap myBitmap = reduceImage(x);
                imagenSeleccionada.setImageBitmap(myBitmap);
                imagenSel = true;
            }break;

            case CAMERA_REQUEST:
            if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
            {
                String imatge = parametroURL.getText().toString();
                File imgFile = new  File(imatge);
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse(imatge)));

                Bitmap myBitmap = reduceImage(imgFile.getAbsolutePath());
                imagenSeleccionada.setImageBitmap(myBitmap);
                imagenSel = true;


            }
            break;


        }

    }

    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }


    public Bitmap reduceImage(String originalPath)
    {
        // Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        o.inPurgeable = true;
        o.inInputShareable = true;
        BitmapFactory.decodeFile(originalPath, o);

        // The new size we want to scale to
        final int REQUIRED_SIZE = 320;

        // Find the correct scale value. It should be the power of 2.
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inPurgeable = true;
        o2.inInputShareable = true;
        o2.inSampleSize = scale;
        Bitmap bitmapScaled = null;
        bitmapScaled = BitmapFactory.decodeFile(originalPath, o2);

        return bitmapScaled;
    }


}
