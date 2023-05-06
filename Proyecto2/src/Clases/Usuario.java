package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Josue
 */
public class Usuario {
    
    private String nombre;
    private List<Categorias> categorias;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.categorias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Categorias> getCategorias() {
        return categorias;
    }    
}
