package Clases;

public class Producto implements Comparable<Producto>{

    private String nombre;
    private String codigo;
    private double valor;

    public Producto(String nombre, String codigo, double valor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Codigo: " + codigo + ", Valor: " + valor;
    }

    @Override
    public int compareTo(Producto o) {
        return this.codigo.compareTo(o.getCodigo());
    }
}
