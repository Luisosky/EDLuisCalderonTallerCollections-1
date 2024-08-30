package Clases;
import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda {

    public  Nodo raiz;

    public ArbolBinarioBusqueda(Nodo raiz) {
        this.raiz = raiz;
    }

    public void enOrden(Nodo nodo, List<Integer> lista) {
        if (nodo == null) {
            return;
        }

        enOrden(nodo.izquierdo, lista);
        lista.add(nodo.valor);
        enOrden(nodo.derecho, lista);
    }

    public List<Integer> obtenerElementosEnOrden() {
        List<Integer> lista = new ArrayList<>();
        enOrden(raiz, lista);
        return lista;
    }

    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }

        return nodo;
    }

}
