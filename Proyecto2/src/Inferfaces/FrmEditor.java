/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Inferfaces;

import Handlers.ImageHandler;
import Handlers.JPEGHandler;
import Handlers.JPEGtoBMPImage;
import java.io.File;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Josue
 */
public class FrmEditor extends javax.swing.JFrame {

    private File fichero;

    /**
     * Creates new form FrmEditor
     */
    public FrmEditor() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRuta = new javax.swing.JLabel();
        cbBMP = new javax.swing.JCheckBox();
        cbCopiaJPEG = new javax.swing.JCheckBox();
        cbRGBS = new javax.swing.JCheckBox();
        cbRotar = new javax.swing.JCheckBox();
        cbBlancoNegro = new javax.swing.JCheckBox();
        btnEjecutar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRuta.setText("Ruta");

        cbBMP.setText("JPEG a BMP y viceversa");

        cbCopiaJPEG.setText("copia JPEG");

        cbRGBS.setText("RGB y Sepia");

        cbRotar.setText("Modificar la Imagen");

        cbBlancoNegro.setText("Blanco y Negro");

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        jButton1.setText("Seleccionar Imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbBlancoNegro)
                    .addComponent(cbRotar)
                    .addComponent(cbRGBS)
                    .addComponent(cbCopiaJPEG)
                    .addComponent(cbBMP)
                    .addComponent(lblRuta)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEjecutar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addGap(35, 35, 35)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRuta)
                        .addGap(18, 18, 18)
                        .addComponent(cbBMP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCopiaJPEG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRGBS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRotar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBlancoNegro)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEjecutar)
                            .addComponent(btnSalir))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        FrmPrincipal ventanaPrincipal = new FrmPrincipal();
        ventanaPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser escojerImagen = new JFileChooser();
            int eleccion = escojerImagen.showOpenDialog(this);
            if (eleccion == JFileChooser.APPROVE_OPTION) {
                fichero = escojerImagen.getSelectedFile();
                ImageIcon imagen = new ImageIcon(fichero.getPath());
                Icon icono = new ImageIcon(imagen.getImage().
                        getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));

                lblImagen.setIcon(icono);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        // TODO add your handling code here:
        if (cbBMP.isSelected()) {
            ImageHandler imagen = new JPEGtoBMPImage(fichero.getName(), fichero.getPath());
            try {
                JPEGHandler.runHandler(imagen);
            } catch (Exception e) {
                System.err.println("Error HandlerBMPCopy: " + e.getMessage());
            }
        }
        if (cbBlancoNegro.isSelected()) {
            ImageHandler imagen = new Handlers.JPEGImageHandlerBN(fichero.getName(), fichero.getPath());
            try {
                JPEGHandler.runHandler(imagen);
            } catch (Exception e) {
                System.out.println("Error HandlerColor:" + e.getMessage());
            }
        }
        if (cbCopiaJPEG.isSelected()) {
            ImageHandler imagen = new Handlers.JPEGImageCopy(fichero.getName(), fichero.getPath());
            try {
                JPEGHandler.runHandler(imagen);
            } catch (Exception e) {
                System.out.println("Error HandlerColor:" + e.getMessage());
            }
        }
        if (cbRGBS.isSelected()) {
            ImageHandler imagen = new Handlers.JPEGImageHandlerColors(fichero.getName(), fichero.getPath());
            try {
                JPEGHandler.runHandler(imagen);
            } catch (Exception e) {
                System.out.println("Error HandlerColor:" + e.getMessage());
            }
        }
        if (cbRotar.isSelected()) {
            ImageHandler imagen = new Handlers.JPEGImageHandlerRotator(fichero.getName(), fichero.getPath());
            try {
                JPEGHandler.runHandler(imagen);
            } catch (Exception e) {
                System.out.println("Error HandlerColor:" + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox cbBMP;
    private javax.swing.JCheckBox cbBlancoNegro;
    private javax.swing.JCheckBox cbCopiaJPEG;
    private javax.swing.JCheckBox cbRGBS;
    private javax.swing.JCheckBox cbRotar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblRuta;
    // End of variables declaration//GEN-END:variables
}
