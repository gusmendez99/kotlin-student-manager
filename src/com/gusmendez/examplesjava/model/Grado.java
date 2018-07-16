package com.gusmendez.examplesjava.model;

import java.util.ArrayList;

public class Grado {

    private String nombre;
    private ArrayList<Estudiante> estudiantes;

    public Grado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    /*public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }*/
}
