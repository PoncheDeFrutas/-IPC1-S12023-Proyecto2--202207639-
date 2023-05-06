package Clases;

import Handlers.ImageHandler;
import Handlers.JPEGHandler;
import Handlers.JPEGtoBMPImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

public class ImageProcessor extends SwingWorker<Void, Imagen> {

    private List<Imagen> images;
    private JProgressBar progressBar;
    private JTextPane textPane;
    private List<String> proceso;
    private int progressCounter = 0;

    public ImageProcessor(List<Imagen> images, JProgressBar progressBar, List<String> proceso, JTextPane textPane) {
        this.images = images;
        this.progressBar = progressBar;
        this.proceso = proceso;
        this.textPane = textPane;
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (Imagen imagenes : images) {
            String text = "\n----------------------------------------";
            text = "Analizando la imagen: " + imagenes.getNombre();
            // Obtener la ruta de la imagen desde la instancia de Imagen
            String ruta = imagenes.getRuta();
            // Cargar la imagen desde el archivo en la ruta especificada
            try {
                BufferedImage image = ImageIO.read(new File(ruta));
                // Incrementa el progreso en un porcentaje igual al número total de imágenes dividido por el tamaño de la lista de procesos
                int progressStep = 100 / (images.size() * proceso.size());
                for (int i = 0; i < proceso.size(); i++) {
                    String ejecutanto = proceso.get(i);
                    if (ejecutanto.equals("BMP")) {
                        text += "\nREALIZANDO COPIA BMP Y PASANDO A JPEG"; 
                        ImageHandler imagen = new JPEGtoBMPImage(imagenes.getNombre(), imagenes.getRuta());
                        progressCounter += progressStep;
                        try {
                            JPEGHandler.runHandler(imagen);
                            text += "\nTERMINADO\n"; 
                        } catch (Exception e) {
                            System.err.println("Error HandlerBMPCopy: " + e.getMessage());
                        }
                    }
                    if (ejecutanto.equals("BN")) {
                        text += "\nREALIZANDO COPIA EN BLANCO Y NEGRO"; 
                        ImageHandler imagen = new Handlers.JPEGImageHandlerBN(imagenes.getNombre(), imagenes.getRuta());
                        progressCounter += progressStep;
                        try {
                            JPEGHandler.runHandler(imagen);
                            text += "\nTERMINADO\n"; 
                        } catch (Exception e) {
                            System.out.println("Error HandlerColor:" + e.getMessage());
                        }
                    }
                    if (ejecutanto.equals("COPIA")) {
                        text += "\nREALIZANDO COPIA JPEG"; 
                        ImageHandler imagen = new Handlers.JPEGImageCopy(imagenes.getNombre(), imagenes.getRuta());
                        progressCounter += progressStep;
                        try {
                            JPEGHandler.runHandler(imagen);
                            text += "\nTERMINADO\n"; 
                        } catch (Exception e) {
                            System.out.println("Error HandlerColor:" + e.getMessage());
                        }
                    }
                    if (ejecutanto.equals("RGBS")) {
                        text += "\nREALIZANDO COPIA EN SISTEMA RGB Y SEPIA"; 
                        ImageHandler imagen = new Handlers.JPEGImageHandlerColors(imagenes.getNombre(), imagenes.getRuta());
                        progressCounter += progressStep;
                        try {
                            JPEGHandler.runHandler(imagen);
                            text += "\nTERMINADO\n"; 
                        } catch (Exception e) {
                            System.out.println("Error HandlerColor:" + e.getMessage());
                        }
                    }
                    if (ejecutanto.equals("ROTAR")) {
                        text += "\nREALIZANDO COPIA ROTADAS"; 
                        ImageHandler imagen = new Handlers.JPEGImageHandlerRotator(imagenes.getNombre(), imagenes.getRuta());
                        progressCounter += progressStep;

                        try {
                            JPEGHandler.runHandler(imagen);
                            text += "\nTERMINADO\n"; 
                        } catch (Exception e) {
                            System.out.println("Error HandlerColor:" + e.getMessage());
                        }
                    }
                    // Aquí colocas el código para procesar la imagen
                    setProgress(progressCounter);
                    textPane.setText(textPane.getText() + text + "\n");
                    // Publica el progreso de la tarea
                    publish(imagenes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void process(List<Imagen> chunks) {
        // Actualiza la barra de carga con el progreso actual
        progressBar.setValue(progressCounter);
    }

    @Override
    protected void done() {
        // Aquí colocas el código que se ejecuta al terminar la tarea
    }
}
