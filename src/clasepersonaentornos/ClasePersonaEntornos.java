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
        
        String nombre = "", apellidos = "", fechaNacimiento="";
        Persona persona = null;
        int numeroPersonasConFecha, numeroPersonasSinFecha;
        boolean fechaEsCorrecta = false;
        
        numeroPersonasConFecha = sc.nextInt();
        numeroPersonasSinFecha = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<numeroPersonasConFecha; i++){
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try {
                persona = new Persona(nombre, apellidos, fechaNacimiento);
                System.out.println("Procesado: " + persona.getNombre() + " " + persona.getApellidos() + ", nacido el " + 
                        persona.getFechaNacimiento().substring(0, 2) + " del " + 
                        persona.getFechaNacimiento().substring(3, 5) + " de "
                + persona.getFechaNacimiento().substring(6, fechaNacimiento.length()));
            } catch (IllegalArgumentException e){
                System.out.println("ERROR. Procesando siguiente persona");
                
            }
        }
        
        for (int i = 0; i < numeroPersonasSinFecha; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            try {
                persona = new Persona(nombre, apellidos);
                System.out.println("Procesado: " + persona.getNombre() + " " + persona.getApellidos() + ", nacido el " + persona.getFechaNacimiento());
            } catch (IllegalArgumentException ex1) {
                System.out.println("ERROR. Procesando siguiente persona");
            }
        }
        
        
         while (!fechaEsCorrecta) {
            try {
                fechaNacimiento = sc.nextLine();
                persona.setFechaNacimiento(fechaNacimiento);
                fechaEsCorrecta = true;
                System.out.println("Procesado: " + persona.getNombre() + " " + persona.getApellidos() + ", nacido el " + persona.getFechaNacimiento().substring(0, 2)
                        + " del " + persona.getFechaNacimiento().substring(3, 5) + " de " + persona.getFechaNacimiento().substring(6, persona.getFechaNacimiento().length()));
            } catch (IllegalArgumentException ex1) {
                System.out.println("Fecha Incorrecta");
            }
        }
        
    }
    
}
