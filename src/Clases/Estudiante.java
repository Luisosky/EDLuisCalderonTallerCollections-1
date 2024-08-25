package Clases;

public class Estudiante extends Persona{

    private int matricula;


    public Estudiante(String nombre, String genero, int edad, int matricula) {
        super(nombre, genero, edad);
        this.matricula = matricula;
    }



    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
