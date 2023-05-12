/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepersonaentornos;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Ángel
 */
public class Persona {

    private String nombre, apellidos;

    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {

        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento);
        }
    }

    public Persona(String nombre, String apellidos) throws IllegalArgumentException {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = null;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento(char separador) {
        String fecha = null;

        if (separador != '-' && separador != '/') {
            throw new IllegalArgumentException();
        } else {
            if (this.fechaNacimiento != null) {
                fecha = String.format("%02d%c%02d%c%04d", this.fechaNacimiento.getDayOfMonth(), separador,
                        this.fechaNacimiento.getMonthValue(), separador, this.fechaNacimiento.getYear());
            }
        }
        return fecha;
    }

    public String getFechaNacimiento() {
        return getFechaNacimiento('-');
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }

    public int getEdadEnFecha(String cadenaFecha) {
        int edad;

        if (this.fechaNacimiento == null) {
            return -1;
        }
        LocalDate nuevaFecha = generarFecha(cadenaFecha);

        try {
            edad = nuevaFecha.getYear() - this.fechaNacimiento.getYear();
            if (this.fechaNacimiento.getMonthValue() > nuevaFecha.getMonthValue()
                    || (this.fechaNacimiento.getMonthValue() == nuevaFecha.getMonthValue()
                    && this.fechaNacimiento.getDayOfMonth() > nuevaFecha.getDayOfMonth())) {
                edad--;
            }
            return edad;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    public int getEdad() {
        int edad;

        if (this.fechaNacimiento == null || (LocalDate.now().isBefore(fechaNacimiento))) {
            return -1;
        }

        try {
            Period periodo = Period.between(fechaNacimiento, LocalDate.now());
            edad = periodo.getYears();
            return edad;
        } catch (IllegalArgumentException e) {
            return -1;
        }

    }

    private LocalDate generarFecha(String fechaDeNacimiento) {
        LocalDate fecha;
        int dia = 0;
        int mes = 0;
        int anyo = 0;

        if (!fechaDeNacimiento.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}")
                && !fechaDeNacimiento.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")) {
            throw new IllegalArgumentException();
        } else {
            try {
                dia = Integer.parseInt(fechaDeNacimiento.substring(0, 2));
                mes = Integer.parseInt(fechaDeNacimiento.substring(3, 5));
                anyo = Integer.parseInt(fechaDeNacimiento.substring(6, fechaDeNacimiento.length()));
                fecha = LocalDate.of(anyo, mes, dia);
            } catch (DateTimeException e) {
                throw new IllegalArgumentException();
            }
        }
        return fecha;
    }

}
