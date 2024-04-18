package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Amigo implements Serializable {
    private String nombre;
   private String apellidos;
    private String fechanacimiento;

    public Amigo(String nombre, String apellidos, String fechanacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechanacimiento = fechanacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechanacimiento='" + fechanacimiento + '\'' +
                "}" +"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amigo amigo = (Amigo) o;
        return Objects.equals(nombre, amigo.nombre) && Objects.equals(apellidos, amigo.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos);
    }
}
