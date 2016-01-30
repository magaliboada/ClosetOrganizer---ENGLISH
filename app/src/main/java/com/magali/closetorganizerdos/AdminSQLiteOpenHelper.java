package com.magali.closetorganizerdos;

/**
 * Created by Magali on 12/05/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    //llamamos al constructor
    public AdminSQLiteOpenHelper(Context context, String nombre, CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    //creamos la tabla
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Prenda("+
                "idPrenda INTEGER NOT NULL PRIMARY KEY,"+
                "tipoPrenda VARCHAR(20) NOT NULL,"+
                "ocasion VARCHAR(20) NOT NULL,"+
                "temporada VARCHAR(20) NOT NULL,"+
                "color VARCHAR(20) NOT NULL,"+
                "material VARCHAR(20) NOT NULL,"+
                "anotaciones TEXT,"+
                "urlFoto TEXT)");

        //USUARIO
        db.execSQL("create table Usuario(" +
                "correoUsuario VARCHAR(50) NOT NULL PRIMARY KEY," +
                "fechaNacimiento DATE," +
                "nombre VARCHAR(20) NOT NULL," +
                "apellido VARCHAR(20) NOT NULL)");

    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        /*
        //borrar tablas si existen
        db.execSQL("drop table if exists Prenda");
        db.execSQL("drop table if exists Usuario");*/
        //crear tablas de nuevo
        db.execSQL(
                "create table if not exists Prenda(" +
                        "idPrenda INTEGER NOT NULL PRIMARY KEY"+
                        "tipoPrenda VARCHAR(20) NOT NULL," +
                        "ocasion VARCHAR(20) NOT NULL," +
                        "temporada VARCHAR(20) NOT NULL," +
                        "color VARCHAR(20) NOT NULL," +
                        "material VARCHAR(20) NOT NULL," +
                        "anotaciones TEXT," +
                        "urlFoto TEXT," + ")" +
                        "ENGINE = InnoDB;"    );

        //USUARIO
        db.execSQL("create table if not exists Usuario(" +
                "correoUsuario VARCHAR(50) NOT NULL PRIMARY KEY," +
                "fechaNacimiento DATE," +
                "nombre VARCHAR(20) NOT NULL," +
                "apellido VARCHAR(20) NOT NULL)" +
                "ENGINE = InnoDB;"        );
    }
}