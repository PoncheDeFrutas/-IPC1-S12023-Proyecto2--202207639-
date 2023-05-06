package Handlers;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JPEGImageHandlerRotator extends ImageHandler {

    protected String save_file;
    protected String new_name;
    protected String new_path;

    public JPEGImageHandlerRotator(String filename, String filepath) {
        super(filename, filepath);

        // Nombre de archivo sin extensión
        int inidiceInicial = super.getFileName().lastIndexOf("-") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");
        this.new_name = filename.substring(inidiceInicial, indiceFinal);

        // Directorio temporal de salida
        this.save_file = "C:\\Users\\Josue\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto2\\src\\Handlers\\Temporal\\";
    }

    @Override
    public void readFile() throws Exception {
        File archivo = new File(this.handledFilePath);
        BufferedImage imagen = ImageIO.read(archivo);

        // Girar imagen 180 grados horizontalmente
        BufferedImage hRotation = rotateImage180Horizontally(imagen);
        new_path = save_file + "Hrotation-" + new_name + ".jpeg";
        ImageIO.write(hRotation, "JPEG", new File(new_path));

        // Girar imagen 180 grados verticalmente
        BufferedImage vRotation = rotateImage180Vertically(imagen);
        new_path = save_file + "Vrotation-" + new_name + ".jpeg";
        ImageIO.write(vRotation, "JPEG", new File(new_path));
    }

    private BufferedImage rotateImage180Horizontally(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = result.createGraphics();
        g.rotate(Math.PI, width / 2, height / 2);
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return result;
    }

    private BufferedImage rotateImage180Vertically(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = result.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance(1, -1);
        at.translate(0, -height);
        g.drawImage(image, at, null);
        g.dispose();
        return result;
    }

    @Override
    public void generateFiles() throws Exception {
        // No se requiere generar archivos adicionales
    }
}