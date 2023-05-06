package Handlers;

import java.io.*;

public class JPEGImageCopy extends ImageHandler {
    protected byte[] filebytes;
    protected String copyname;

    public JPEGImageCopy(String filename, String filepath) {
        super(filename, filepath);
        int indiceInicial = super.getFileName().lastIndexOf("-") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");
        this.copyname = "copy-" + filename.substring(indiceInicial, indiceFinal);
    }

    @Override
    public void readFile() throws Exception {
        FileInputStream input = new FileInputStream(this.handledFilePath);
        filebytes = new byte[input.available()];
        input.read(filebytes);
        input.close();
        System.out.println("Imagen leida: " + this.handledFileName);
    }

    @Override
    public void generateFiles() throws Exception {
        String temporal = "C:\\Users\\Josue\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto2\\src\\Handlers\\Temporal\\";
        FileOutputStream output = new FileOutputStream(temporal + copyname + ".jpg");
        output.write(filebytes);
        output.close();
    }
}