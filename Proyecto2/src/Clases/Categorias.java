package Clases;

import Listas.ListaCircularDobleEnlazadaImagenes;
import java.util.List;

public class Categorias {

    private ListaCircularDobleEnlazadaImagenes listaCircularDoble;
    private String nombreCategoria;

    public Categorias(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.listaCircularDoble = new ListaCircularDobleEnlazadaImagenes();
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public void add(Object e) {
        listaCircularDoble.add(e);
    }

    public Object peek() {
        return listaCircularDoble.peek();
    }

    public Object find(Object e) {
        return listaCircularDoble.find(e);
    }

    public Object getNext() {
        return listaCircularDoble.getNext();
    }

    public int getSize() {
        return listaCircularDoble.getSize();
    }

    public Object get(int i) {
        return listaCircularDoble.get(i);
    }

    public Object pop() {
        return listaCircularDoble.pop();
    }

    public void delete(Object e) {
        listaCircularDoble.delete(e);
    }

    public List<Imagen> getList() {
        return listaCircularDoble.getList();
    }
}
