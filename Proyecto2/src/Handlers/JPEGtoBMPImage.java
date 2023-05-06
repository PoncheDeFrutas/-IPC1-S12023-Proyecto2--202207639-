package Handlers;

import java.io.*;

/**
 * @author Josue
 */
public class JPEGtoBMPImage extends  ImageHandler{
    /**
     * Array of bytes that will allocate all header and data for original file
	*
     */
    protected byte[] filebytes;
    /**
     * File name that will be given to the copy of the original file
	*
     */
    protected String copyname;

    /**
     * Builds and returns a BmpHandlerCopy object which handles the file
     * represented by the given name
     *
     * @param filename Name of the original file being handled by this object
     * @param filepath
	*
     */
    public JPEGtoBMPImage(String filename, String filepath) {
     super(filename, filepath);
        int indiceInicial = super.getFileName().lastIndexOf("-") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");        
        this.copyname = "copy-" + filename.substring(indiceInicial, indiceFinal);
    }

    /**
     * Reads handled file header and data in bytes
	*
     */
    @Override
    public void readFile() throws Exception {
        FileInputStream input = new FileInputStream(this.handledFilePath);
        filebytes = new byte[input.available()];
        input.read(filebytes);
        input.close();
        System.out.println("Imagen leida: " + this.handledFileName);
    }

    /**
     * Generates a copy file from the original file. The name of the generated
     * file will be build by the same name preceeded of "copy-"
	*
     */
    @Override
    public void generateFiles() throws Exception {
        // Esta variable se puede modificar
        String temporal = "C:\\Users\\Josue\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto2\\src\\Handlers\\Temporal\\";
        
        FileOutputStream output = new FileOutputStream(temporal + copyname + ".bmp");
        output.write(filebytes);
        output.close(); 
    }
}
