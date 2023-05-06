package Handlers;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * @author Josue
 */
public class BMPtoJPEGImage extends ImageHandler {

    /**
     * File name that will be given to the copy of the original file
     */
    protected String copyname;

    /**
     * Builds and returns a BMPtoJPEGImage object which handles the file
     * represented by the given name
     *
     * @param filename Name of the original file being handled by this object
     * @param filepath Path of the directory where the file is located
     */
    public BMPtoJPEGImage(String filename, String filepath) {
        super(filename, filepath);
        int indiceInicial = super.getFileName().lastIndexOf("-") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");
        this.copyname = "copy-" + filename.substring(indiceInicial, indiceFinal) + ".jpg";
    }

    /**
     * Reads handled file header and data in bytes
     */
    @Override
    public void readFile() throws Exception {
        // Read the BMP file into a BufferedImage object
        BufferedImage image = ImageIO.read(new File(this.handledFilePath));
        if (image == null) {
            throw new Exception("Could not read BMP file");
        }
        System.out.println("Imagen leida: " + this.handledFileName);
    }

    /**
     * Generates a copy file from the original file in JPEG format. The name of
     * the generated file will be build by the same name preceeded of "copy-"
     */
    @Override
    public void generateFiles() throws Exception {
        // Load the BMP image into a BufferedImage object
        BufferedImage image = ImageIO.read(new File(this.handledFilePath));
        if (image == null) {
            throw new Exception("Could not read BMP file");
        }

        // Write the BufferedImage to a JPEG file
        File outputfile = new File("Temporal/" + this.copyname);
        ImageIO.write(image, "jpg", outputfile);
    }
}
