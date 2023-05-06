package Listas;

import Clases.Categorias;
import Clases.Imagen;
import Clases.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Josue
 */
public class ListaUsuarios {

    private List<Usuario> usuarios;

    public ListaUsuarios() {
        usuarios = new ArrayList<>();
    }

    public List<Usuario> listaUsuarios(){
        return usuarios;
    }
    
    public int buscarUsuario(String dato) {
        int n = -1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equals(dato)) {
                n = i;
                break;
            }
        }
        return n;
    }

    //Función para agregar un nuevo objeto tipo departamentos al almacenamiento.
    public boolean insertarUsuario(Usuario dato) {
        if (buscarUsuario(dato.getNombre()) == -1) {
            usuarios.add(dato);
            return true;
        } else {
            return false;
        }
    }

    //Función para eliminar Objeto de la lista.
    public boolean eliminarUsuario(String dato) {
        if (buscarUsuario(dato) != -1) {
            usuarios.remove(buscarUsuario(dato));
            return true;
        } else {
            return false;
        }
    }

    //Función para obtener un Objeto en especifico
    public Usuario obtenerUsuario(String dato) {
        if (buscarUsuario(dato) != -1) {
            return usuarios.get(buscarUsuario(dato));
        } else {
            return null;
        }
    }

    //Función para obtener categorias
    public List<Categorias> categoriasUsuario(String dato) {
        if (buscarUsuario(dato) != -1) {
            return usuarios.get(buscarUsuario(dato)).getCategorias();
        } else {
            return null;
        }
    }

    //Función para buscar igualdad de categorias
    public int buscarCategorias(String dato, String categoria) {
        int n = -1;
        List<Categorias> categoriasAuxiliar = categoriasUsuario(dato);
        for (int i = 0; i < categoriasAuxiliar.size(); i++) {
            if (categoriasAuxiliar.get(i).getNombreCategoria().equals(categoria)) {
                n = i;
                break;
            }
        }
        return n;
    }

    //Función para agregar categorias
    public boolean agregarCategorias(String dato, Categorias categoria) {
        if (buscarCategorias(dato, categoria.getNombreCategoria()) == -1) {
            List<Categorias> categoriasAuxiliar = categoriasUsuario(dato);
            categoriasAuxiliar.add(categoria);
            return true;
        } else {
            return false;
        }
    }

    //Funcion para eliminar una categoria
    public boolean eliminarCategorias(String dato, String categoria) {
        if (buscarCategorias(dato, categoria) != -1) {
            List<Categorias> categoriasAuxiliar = categoriasUsuario(dato);
            System.out.println(categoriasAuxiliar);
            categoriasAuxiliar.remove(buscarCategorias(dato, categoria));
            return true;
        } else {
            return false;
        }
    }

    public Categorias obtenerCategoria(String usuario, String nombreCategoria) {
        List<Categorias> categoriasUsuario = categoriasUsuario(usuario);
        for (Categorias categoria : categoriasUsuario) {
            if (categoria.getNombreCategoria().equals(nombreCategoria)) {
                return categoria;
            }
        }
        return null;
    }

    //Función para obtener imagenes
    public List<Imagen> imagenesCategoria(String dato, String categoria) {
        Categorias categoriaAux =   obtenerCategoria(dato, categoria);
        return categoriaAux.getList();
    }
}
