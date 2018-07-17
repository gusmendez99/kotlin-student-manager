package com.gusmendez.examplesjava.model;

import java.util.ArrayList;
import java.util.List;

public class Nivel {

    private String nombre;
    private List<Grado> grados;

    public Nivel(String nombre){
        this.nombre = nombre;
        this.grados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Grado> getGrados() {
        return grados;
    }

    public Grado getGrado(int position) {
        return this.grados.get(position);
    }

    /*public void setGrados(ArrayList<Grado> grados) {
        this.grados = grados;
    }*/
    public void addGrado(Grado grado){
        this.grados.add(grado);
    }
}
