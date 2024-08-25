package Clases;

import java.util.TreeSet;

public class Empresa {

    private TreeSet<Producto> productos = new TreeSet<>();

    public Empresa() {
        this.productos = new TreeSet<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public Producto buscarProductoCodigo(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}
