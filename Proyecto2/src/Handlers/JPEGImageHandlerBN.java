package Handlers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Josue
 */
public class JPEGImageHandlerBN extends ImageHandler{

    protected String save_file;
    protected String new_name;
    protected String new_path;
    
    protected BufferedImage imagenBN;
    
    
    public JPEGImageHandlerBN(String filename, String filepath) {
        super(filename, filepath);
        
        int inidiceInicial = super.getFileName().lastIndexOf("-") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");

        this.new_name = filename.substring(inidiceInicial, indiceFinal);

        this.save_file = "C:\\Users\\Josue\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto2\\src\\Handlers\\Temporal\\";
    }

    @Override
    public void readFile() throws Exception {
        File archivo = new File(this.handledFilePath);
        imagenBN = ImageIO.read(archivo);
    }

    @Override
    public void generateFiles() throws Exception {
        gris(imagenBN);
    }
    
    public void gris(BufferedImage imagen) {
        for (int i = 0; i < imagen.getWidth(); i++) {
            for (int j = 0; j < imagen.getHeight(); j++) {
                int rgb = imagen.getRGB(i, j);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);
                
                int nivelgris = (r + g + b) / 3;
                int gris = (nivelgris << 16) + (nivelgris << 8) + nivelgris;
                imagen.setRGB(i, j, gris);
            }
        }
        try {
            new_path = save_file + "EscalaGris-" + new_name + ".jpeg";
            ImageIO.write(imagen, "JPEG", new File(new_path));
        } catch (IOException e) {
        }
    }
}
