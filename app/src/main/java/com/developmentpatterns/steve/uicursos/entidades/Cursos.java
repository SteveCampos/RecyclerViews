package com.developmentpatterns.steve.uicursos.entidades;

import java.util.List;

/**
 * Created by Steve on 16/05/2016.
 */
public class Cursos {

    private String curseName;
    private String hexadecimalColor;
    private String urlImage;
    private List<Clase> listClase;

    public Cursos(String curseName, String hexadecimalColor, String urlImage, List<Clase> listClase) {
        this.curseName = curseName;
        this.hexadecimalColor = hexadecimalColor;
        this.urlImage = urlImage;
        this.listClase = listClase;
    }

    public String getCurseName() {
        return curseName;
    }

    public void setCurseName(String curseName) {
        this.curseName = curseName;
    }

    public String getHexadecimalColor() {
        return hexadecimalColor;
    }

    public void setHexadecimalColor(String hexadecimalColor) {
        this.hexadecimalColor = hexadecimalColor;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public List<Clase> getListClase() {
        return listClase;
    }

    public void setListClase(List<Clase> listClase) {
        this.listClase = listClase;
    }
}
