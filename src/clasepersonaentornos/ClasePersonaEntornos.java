/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clasepersonaentornos;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class ClasePersonaEntornos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        String nombre = "", apellidos = "", fechaNacimiento = "", fecha = "";

        int personas, edad;

        personas = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < personas; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try {
                Persona persona1 = new Persona(nombre, apellidos, fechaNacimiento);
                edad = persona1.getEdad();
                if (edad == -1) {
                    System.out.println(persona1.getNombre() + " " + persona1.getApellidos() + " aun no ha nacido a dia de hoy");
                } else {
                    System.out.println(persona1.getNombre() + " " + persona1.getApellidos() + " tiene " + edad + " anyos a dia de hoy");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente persona");
            }

        }

    }

}