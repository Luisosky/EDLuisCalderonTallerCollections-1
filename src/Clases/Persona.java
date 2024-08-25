package Clases;

public class Persona implements Comparable<Persona>{

    private String nombre;
    private String genero;
    private int edad;

    public Persona(String nombre, String genero, int edad) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Persona o) {
        return Integer.compare(this.getEdad(), o.getEdad());
    }

    public String toString(){
        return nombre + " " + genero + " " + edad;
    }


}
