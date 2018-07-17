package com.gusmendez.examplesjava.model;

import java.util.ArrayList;
import java.util.List;

public class Grado {

    private String nombre;
    private List<Estudiante> estudiantes;

    public Grado(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void addEstudiante(Estudiante estudiante){
        this.estudiantes.add(estudiante);
    }


}
