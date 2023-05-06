package Logica;

import Clases.Categorias;
import Clases.Imagen;
import Clases.Usuario;
import Listas.ListaUsuarios;
import java.util.List;

/**
 * @author Josue
 */
public class LogicaUsuarios {

    private static ListaUsuarios listaUsuarios = new ListaUsuarios();

    //Función para agregar un nuevo objeto tipo departamentos al almacenamiento.
    public static boolean insertarUsuario(Usuario dato) {
        return listaUsuarios.insertarUsuario(dato);
    }

    //Función para eliminar Objeto de la lista.
    public static boolean eliminarUsuario(String dato) {
        return listaUsuarios.eliminarUsuario(dato);
    }

    //Función para obtener un Objeto en especifico
    public static Usuario obtenerUsuario(String dato) {
        return listaUsuarios.obtenerUsuario(dato);
    }

    //Función para obtener categorias
    public static List<Categorias> categoriasUsuario(String dato) {
        return listaUsuarios.categoriasUsuario(dato);
    }

    //Función para agregar categorias
    public static boolean agregarCategorias(String dato, Categorias categoria) {
        return listaUsuarios.agregarCategorias(dato, categoria);
    }

    //Funcion para eliminar una categoria
    public static boolean eliminarCategorias(String dato, String categoria) {
        return listaUsuarios.eliminarCategorias(dato, categoria);
    }

    public static Categorias obtenerCategoria(String usuario, String nombreCategoria) {
        return listaUsuarios.obtenerCategoria(usuario, nombreCategoria);
    }

    //Función para obtener imagenes
    public static List<Imagen> imagenesCategoria(String dato, String categoria) {
        return listaUsuarios.imagenesCategoria(dato, categoria);
    }
    
    public static List<Usuario> listaUsuarios(){
        return listaUsuarios.listaUsuarios();
    }
}
