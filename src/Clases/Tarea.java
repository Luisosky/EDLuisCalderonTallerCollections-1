package Clases;

public class Tarea implements Comparable<Tarea>{
    private String materia;
    private int importancia;

    public Tarea(String materia, int importancia) {
        this.materia = materia;
        this.importancia = importancia;
    }

    public int getImportancia() {
        return importancia;
    }

    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public int compareTo(Tarea o) {
        return Integer.compare(this.getImportancia(), o.getImportancia());
    }

    public String toString(){
        return materia+" "+importancia;
    }
}
