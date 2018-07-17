package com.gusmendez.examplesjava;

import com.gusmendez.examplesjava.model.Estudiante;
import com.gusmendez.examplesjava.model.Grado;
import com.gusmendez.examplesjava.model.Nivel;
import com.gusmendez.examplesjava.util.ReadUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String getMenu() {
        return "Menu:\n" +
                "\t1. Agregar nivel\n" +
                "\t2. Agregar grado\n" +
                "\t3. Agregar estudiante\n" +
                "\t4. Ver grados en un nivel\n" +
                "\t5. Ver asignaciones en un grado\n" +
                "\t6. Salir\n";
    }

    private static int searchNivel(List<Nivel> niveles, String nombreNivel) {
        int pos = -1;
        for(int x=0; x < niveles.size(); x++){
            if(niveles.get(x).getNombre().equals(nombreNivel)){
                return x;
            }
        }
        return pos;
    }

    public static void main(String[] args) {

        List<Nivel> niveles = new ArrayList<>();

        int option = 0;
        do {
            System.out.println(getMenu());
            System.out.print("Ingrese una opcion: ");
            option = ReadUtil.readInt();

            //Variables declaradas afuera, porque se usan en casi todos los casos del switch
            String nombreNivel, nombreGrado;
            switch(option){
                case 1:
                    System.out.print("Ingrese el nombre del nivel: ");
                    nombreNivel = ReadUtil.readString();
                    if(!nombreNivel.isEmpty()){
                        niveles.add(new Nivel(nombreNivel));
                        System.out.println("NIVEL CREADO EXITOSAMENTE!");
                    } else {
                        System.out.print("No puedes agregar un nivel sin nombre, intenta de nuevo...");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del nivel: ");
                    nombreNivel = ReadUtil.readString();
                    if(!nombreNivel.isEmpty()){
                        int position = searchNivel(niveles, nombreNivel);
                        if(position >= 0){
                            System.out.print("Ingrese el nombre del grado: ");
                            nombreGrado = ReadUtil.readString();
                            if(!nombreGrado.isEmpty()){
                                niveles.get(position).addGrado(new Grado(nombreGrado));
                                System.out.println("GRADO CREADO EXITOSAMENTE!");
                            } else {
                                System.out.print("No puedes agregar un grado sin nombre, intenta de nuevo...");
                            }
                        } else {
                            System.out.println("No existe nivel con ese nombre, intente de nuevo...");
                        }
                    } else {
                        System.out.print("Nombre de nivel vacio, intenta de nuevo...");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del nivel: ");
                    nombreNivel = ReadUtil.readString();
                    if(!nombreNivel.isEmpty()){
                        int positionNivel = searchNivel(niveles, nombreNivel);
                        if(positionNivel >= 0){
                            System.out.print("Ingrese el nombre del grado: ");
                            nombreGrado = ReadUtil.readString();
                            if(!nombreGrado.isEmpty()){
                                int positionGrado = niveles.get(positionNivel).searchGrado(nombreGrado);
                                if(positionGrado >= 0){
                                    System.out.print("Ingrese el nombre del estudiante: ");
                                    String nombreEstudiante = ReadUtil.readString();
                                    System.out.print("Ingrese el codigo del estudiante: ");
                                    String codigoEstudiante = ReadUtil.readString();

                                    if(!nombreEstudiante.isEmpty() && !codigoEstudiante.isEmpty()){
                                        niveles.get(positionNivel).getGrado(positionGrado)
                                                .addEstudiante(new Estudiante(nombreEstudiante, codigoEstudiante));
                                        System.out.println("ESTUDIANTE CREADO EXITOSAMENTE!");
                                    } else {
                                        System.out.print("Datos del estudiante vacio, intenta de nuevo...");
                                    }
                                } else {
                                    System.out.println("No existe grado con ese nombre, intente de nuevo...");
                                }
                            } else {
                                System.out.print("Nombre de grado vacio, intenta de nuevo...");
                            }
                        } else {
                            System.out.println("No existe nivel con ese nombre, intente de nuevo...");
                        }
                    } else {
                        System.out.print("Nombre de nivel vacio, intenta de nuevo...");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del nivel: ");
                    nombreNivel = ReadUtil.readString();
                    if(!nombreNivel.isEmpty()){
                        int positionNivel = searchNivel(niveles, nombreNivel);
                        if(positionNivel >= 0){
                            System.out.println("******GRADOS DE: " + nombreNivel + "******");
                            for(Grado g: niveles.get(positionNivel).getGrados()){
                                System.out.println("\tGrado: " + g.getNombre());
                            }
                        } else {
                            System.out.println("No existe nivel con ese nombre, intente de nuevo...");
                        }
                    } else {
                        System.out.print("Nombre de nivel vacio, intenta de nuevo...");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del nivel: ");
                    nombreNivel = ReadUtil.readString();
                    if(!nombreNivel.isEmpty()){
                        int positionNivel = searchNivel(niveles, nombreNivel);
                        if(positionNivel >= 0){
                            System.out.print("Ingrese el nombre del grado: ");
                            nombreGrado = ReadUtil.readString();
                            if(!nombreGrado.isEmpty()){
                                int positionGrado = niveles.get(positionNivel).searchGrado(nombreGrado);
                                if(positionGrado >= 0){
                                    System.out.println("**ESTUDIANTES DE GRADO:" + nombreGrado + ", NIVEL: " + nombreNivel + "**");
                                    for(Estudiante e: niveles.get(positionNivel).getGrado(positionGrado).getEstudiantes()){
                                        System.out.println("\tNombre: " + e.getNombre() +
                                                ", Codigo: " + e.getCodigo());
                                    }
                                } else {
                                    System.out.println("No existe grado con ese nombre, intente de nuevo...");
                                }
                            } else {
                                System.out.print("Nombre de grado vacio, intenta de nuevo...");
                            }
                        } else {
                            System.out.println("No existe nivel con ese nombre, intente de nuevo...");
                        }
                    } else {
                        System.out.print("Nombre de nivel vacio, intenta de nuevo...");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo....");
                    break;
            }
        } while (option != 6);

    }
}
