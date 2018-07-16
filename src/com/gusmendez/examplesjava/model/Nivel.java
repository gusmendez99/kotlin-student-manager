package com.gusmendez.examplesjava.model;

import java.util.ArrayList;

public class Nivel {

    private String nombre;
    private ArrayList<Grado> grados;

    public Nivel(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Grado> getGrados() {
        return grados;
    }

    public Grado getGrado(String nombre) {
        for(Grado grado: grados){
            if(grado.getNombre().equals(nombre)) return grado;
        }
        return null;
    }

    /*public void setGrados(ArrayList<Grado> grados) {
        this.grados = grados;
    }*/
    public void addGrado(Grado grado){
        this.grados.add(grado);
    }
}
