package com.magali.closetorganizerdos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Magali on 14/05/2015.
 */
public class Prenda implements Serializable{
    private int idPrenda;
    private ArrayList OpcionesTipoPrenda = new ArrayList();
    private ArrayList OpcionesTemporadaPrenda = new ArrayList();
    private ArrayList OpcionesOcasionPrenda = new ArrayList();
    private ArrayList OpcionesMaterialPrenda = new ArrayList();
    private ArrayList OpcionesColorPrenda = new ArrayList();
    private String anotaciones;
    private String urlFoto;

    @Override
    public String toString() {
        return "Prenda{" +
                "idPrenda=" + idPrenda +
                ", anotaciones='" + anotaciones + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                ", tipoPrenda='" + tipoPrenda + '\'' +
                ", temporada='" + temporada + '\'' +
                ", ocasion='" + ocasion + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Prenda(int idPrenda, String tipoPrenda, String temporada, String ocasion, String material, String color, String urlFoto, String anotaciones) {
        this.idPrenda = idPrenda;
        this.tipoPrenda = tipoPrenda;
        this.temporada = temporada;
        this.ocasion = ocasion;
        this.material = material;
        this.color = color;
        this.urlFoto = urlFoto;
        this.anotaciones = anotaciones;
    }

    private String tipoPrenda = null;
    private String temporada = null;
    private String ocasion = null;

    public String getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(String tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getOcasion() {
        return ocasion;
    }

    public void setOcasion(String ocasion) {
        this.ocasion = ocasion;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String material = null;
    private String color = null;


    public Prenda() {
        OpcionesTipoPrenda.add("Shirt");
        OpcionesTipoPrenda.add("Trousers");
        OpcionesTipoPrenda.add("Pullover");
        OpcionesTipoPrenda.add("Dress");
        OpcionesTipoPrenda.add("Jacket");
        OpcionesTipoPrenda.add("Shoes");
        OpcionesTipoPrenda.add("Jumpsuit");
        OpcionesTipoPrenda.add("Skirt");
        OpcionesTipoPrenda.add("Shorts");
        OpcionesTipoPrenda.add("Belt");
        OpcionesTipoPrenda.add("Leggins");
        OpcionesTipoPrenda.add("Hat");
        OpcionesTemporadaPrenda.add("Summer");
        OpcionesTemporadaPrenda.add("Autumn");
        OpcionesTemporadaPrenda.add("Winter");
        OpcionesTemporadaPrenda.add("Spring");
        OpcionesOcasionPrenda.add("Formal");
        OpcionesOcasionPrenda.add("Casual");
        OpcionesOcasionPrenda.add("Sport");
        OpcionesMaterialPrenda.add("Cotton");
        OpcionesMaterialPrenda.add("Jeans");
        OpcionesMaterialPrenda.add("Silk");
        OpcionesMaterialPrenda.add("Wool");
        OpcionesMaterialPrenda.add("Leather");
        OpcionesMaterialPrenda.add("Lycra");
        OpcionesMaterialPrenda.add("Velvet");
        OpcionesMaterialPrenda.add("Gauze");
        OpcionesMaterialPrenda.add("Polyester");
        OpcionesColorPrenda.add("White");
        OpcionesColorPrenda.add("Black");
        OpcionesColorPrenda.add("Grey");
        OpcionesColorPrenda.add("Red");
        OpcionesColorPrenda.add("Blue");
        OpcionesColorPrenda.add("Green");
        OpcionesColorPrenda.add("Brown");
        OpcionesColorPrenda.add("Beige");
        OpcionesColorPrenda.add("Pink");
        OpcionesColorPrenda.add("Purple");
        OpcionesColorPrenda.add("Orange");
        OpcionesColorPrenda.add("Yellow");
        OpcionesColorPrenda.add("Multicolor");

        this.idPrenda = 0;
        this.anotaciones = "";
        this.urlFoto = "";
    }

    public int getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(int idPrenda) {
        this.idPrenda = idPrenda;
    }

    //obtener listas para mostrar en interfaz
    public ArrayList getOpcionesTipoPrenda() {
        return OpcionesTipoPrenda;
    }

    public ArrayList getOpcionesOcasionPrenda() {
        return OpcionesOcasionPrenda;
    }
    public ArrayList getOpcionesTemporadaPrenda() {
        return OpcionesTemporadaPrenda;
    }

    public ArrayList getOpcionesMaterialPrenda() {
        return OpcionesMaterialPrenda;
    }

    public ArrayList getOpcionesColorPrenda() {
        return OpcionesColorPrenda;
    }


    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
