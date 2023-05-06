package Listas;

import Clases.Imagen;
import Handlers.EstructuraDeDatos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Josue
 */
public class ListaCircularDobleEnlazadaImagenes extends EstructuraDeDatos {

    private NodoImagen primero;
    private NodoImagen ultimo;

    private class NodoImagen {

        Imagen imagen;
        NodoImagen siguiente;
        NodoImagen anterior;

        NodoImagen(Imagen imagen) {
            this.imagen = imagen;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    public ListaCircularDobleEnlazadaImagenes() {
        super();
        this.nombre = "Lista Circular Doble Enlazada de Imágenes";
        this.primero = null;
        this.ultimo = null;
    }

    private HashSet<String> rutas = new HashSet<>();

    /**
     *
     * @param e
     */
    @Override
    public void add(Object e) {
        Imagen imagen = (Imagen) e;
        String ruta = imagen.getRuta();
        if (rutas.contains(ruta)) {
            // La imagen ya existe en la lista, no se agrega
            return;
        }
        NodoImagen nodo = new NodoImagen(imagen);
        if (primero == null) {
            primero = nodo;
            ultimo = nodo;
            nodo.siguiente = primero;
            nodo.anterior = ultimo;
        } else {
            nodo.siguiente = primero;
            nodo.anterior = ultimo;
            ultimo.siguiente = nodo;
            primero.anterior = nodo;
            ultimo = nodo;
        }
        rutas.add(ruta);
        index++;
    }

    @Override
    public Object peek() {
        if (primero != null) {
            return primero.imagen;
        }
        return null;
    }

    @Override
    public Object find(Object e) {
        Imagen imagen = (Imagen) e;
        NodoImagen nodo = primero;
        do {
            if (nodo.imagen.equals(imagen)) {
                return nodo.imagen;
            }
            nodo = nodo.siguiente;
        } while (nodo != primero);
        return null;
    }

    @Override
    public Object getNext() {
        if (index == 0) {
            return null;
        }
        NodoImagen nodo = primero;
        if (index == 1) {
            return nodo.imagen;
        }
        primero = nodo.siguiente;
        ultimo = nodo;
        return nodo.imagen;
    }

    @Override
    public int getSize() {
        return index;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i >= index) {
            return null;
        }
        NodoImagen nodo = primero;
        for (int j = 0; j < i; j++) {
            nodo = nodo.siguiente;
        }
        return nodo.imagen;
    }

    @Override
    public Object pop() {
        if (index == 0) {
            return null;
        }
        NodoImagen nodo = primero;
        if (index == 1) {
            primero = null;
            ultimo = null;
            index--;
            return nodo.imagen;
        }
        primero = nodo.siguiente;
        ultimo.siguiente = primero;
        primero.anterior = ultimo;
        index--;
        return nodo.imagen;
    }

    @Override
    public void delete(Object e) {
        Imagen imagen = (Imagen) e;
        if (primero == null) {
            return;
        }
        if (primero.imagen.equals(imagen)) {
            pop();
            return;
        }
        NodoImagen nodo = primero.siguiente;
        while (nodo != primero) {
            if (nodo.imagen.equals(imagen)) {
                nodo.anterior.siguiente = nodo.siguiente;
                nodo.siguiente.anterior = nodo.anterior;
                nodo.siguiente = null;
                nodo.anterior = null;
                index--;
                return;
            }
            nodo = nodo.siguiente;
        }
    }

    public List<Imagen> getList() {
        List<Imagen> lista = new ArrayList<>();
        NodoImagen nodo = primero;
        try {
            do {
                lista.add(nodo.imagen);
                nodo = nodo.siguiente;
            } while (nodo != primero);
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
