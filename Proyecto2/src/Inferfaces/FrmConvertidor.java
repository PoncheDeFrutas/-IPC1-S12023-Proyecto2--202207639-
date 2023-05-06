package Inferfaces;

import Clases.Categorias;
import Clases.ImageProcessor;
import Clases.Imagen;
import Clases.Usuario;
import Logica.LogicaUsuarios;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Josue
 */
public class FrmConvertidor extends javax.swing.JFrame {

    public static String Usuario = "";
    public static List<Imagen> imagenes = new ArrayList<>();
    public static Set<Imagen> set = new HashSet<>();

    /**
     * Creates new form Convertidor
     */
    public FrmConvertidor() {
        initComponents();
        this.setLocationRelativeTo(null);
        imagenes = new ArrayList<>();
        set = new HashSet<>();
        llenarcbUsuarios();
        llenarcbCategorias();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbUsuarios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbCategorias = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        LCola = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        cbBMP = new javax.swing.JCheckBox();
        cbCopiaJPEG = new javax.swing.JCheckBox();
        cbRGBS = new javax.swing.JCheckBox();
        cbRotar = new javax.swing.JCheckBox();
        cbBlancoNegro = new javax.swing.JCheckBox();
        btnEjecucion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario");

        cbUsuarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbUsuariosItemStateChanged(evt);
            }
        });

        jLabel2.setText("Categoria");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(LCola);

        jLabel3.setText("Cola de Procesamiento");

        cbBMP.setText("JPEG a BMP y viceversa");

        cbCopiaJPEG.setText("copia JPEG");

        cbRGBS.setText("RGB y Sepia");

        cbRotar.setText("Modificar la Imagen");

        cbBlancoNegro.setText("Blanco y Negro");

        btnEjecucion.setText("Ejecutar en Paralelo");
        btnEjecucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecucionActionPerformed(evt);
            }
        });

        jLabel4.setText("Cantidad Procesada");

        jScrollPane2.setViewportView(textPane);

        jLabel5.setText("Consola de Ejecución");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jProgressBar1.setForeground(new java.awt.Color(102, 204, 255));
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(221, 221, 221)
                                    .addComponent(btnSalir))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbBlancoNegro)
                                    .addComponent(cbRotar)
                                    .addComponent(cbRGBS)
                                    .addComponent(cbCopiaJPEG)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbBMP)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEjecucion)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEjecucion))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbBMP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCopiaJPEG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRGBS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRotar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBlancoNegro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(btnSalir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        set.addAll(LogicaUsuarios.imagenesCategoria(cbUsuarios.getSelectedItem().toString(), cbCategorias.getSelectedItem().toString()));
        llenarLista();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEjecucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecucionActionPerformed
        // TODO add your handling code here:
        imagenes.addAll(set);
        List<String> caso = new ArrayList<>();
        if (cbBMP.isSelected()) {
            try {
                caso.add("BMP");
            } catch (Exception e) {
                System.out.println("Error HandlerColor:" + e.getMessage());
            }
        }
        if (cbBlancoNegro.isSelected()) {
            try {
                caso.add("BN");
            } catch (Exception e) {
                System.out.println("Error HandlerColor:" + e.getMessage());
            }
        }
        if (cbCopiaJPEG.isSelected()) {
            try {
                caso.add("COPIA");
            } catch (Exception e) {
                System.out.println("Error HandlerColor:" + e.getMessage());
            }
        }
        if (cbRGBS.isSelected()) {
            try {
                caso.add("RGBS");
            } catch (Exception e) {
                System.out.println("Error HandlerColor:" + e.getMessage());
            }
        }
        if (cbRotar.isSelected()) {
            try {
                caso.add("ROTAR");
            } catch (Exception e) {
                System.out.println("Error HandlerColor:" + e.getMessage());
            }
        }
        if (caso.isEmpty() && imagenes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione algun caso");
        } else {
            ImageProcessor imageProcessor = new ImageProcessor(imagenes, jProgressBar1, caso, textPane);
            // Ejecutar la tarea
            imageProcessor.execute();
        }
    }//GEN-LAST:event_btnEjecucionActionPerformed

    private void cbUsuariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbUsuariosItemStateChanged
        // TODO add your handling code here:
        llenarcbCategorias();
    }//GEN-LAST:event_cbUsuariosItemStateChanged

    public void llenarLista() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Imagen imagen : set) {
            listModel.addElement(imagen.getNombre());
        }

        // Crea un JList y asigna el modelo
        LCola.setModel(listModel);
    }

    public void llenarcbUsuarios() {
        List<Usuario> listaUsuarios = LogicaUsuarios.listaUsuarios();
        cbUsuarios.removeAllItems();
        try {
            if (!listaUsuarios.isEmpty()) {
                for (int i = 0; i < listaUsuarios.size(); i++) {
                    boolean repetido = false;
                    for (int j = 0; j < cbUsuarios.getItemCount(); j++) {
                        if (listaUsuarios.get(i).equals(cbUsuarios.getItemAt(j))) {
                            repetido = true;
                            break;
                        }
                    }
                    if (!repetido) {
                        cbUsuarios.addItem(listaUsuarios.get(i).getNombre());
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public void llenarcbCategorias() {
        List<Categorias> listaCategorias = LogicaUsuarios.categoriasUsuario(cbUsuarios.getSelectedItem().toString());
        cbCategorias.removeAllItems();
        try {
            if (!listaCategorias.isEmpty()) {
                for (int i = 0; i < listaCategorias.size(); i++) {
                    boolean repetido = false;
                    for (int j = 0; j < cbCategorias.getItemCount(); j++) {
                        if (listaCategorias.get(i).getNombreCategoria().equals(cbCategorias.getItemAt(j))) {
                            repetido = true;
                            break;
                        }
                    }
                    if (!repetido) {
                        cbCategorias.addItem(listaCategorias.get(i).getNombreCategoria());
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public void addOutputToTextPane(String text) {
        textPane.setText(textPane.getText() + text + "\n");
    }

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
            java.util.logging.Logger.getLogger(FrmConvertidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConvertidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConvertidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConvertidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmConvertidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> LCola;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEjecucion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox cbBMP;
    private javax.swing.JCheckBox cbBlancoNegro;
    private javax.swing.JComboBox<String> cbCategorias;
    private javax.swing.JCheckBox cbCopiaJPEG;
    private javax.swing.JCheckBox cbRGBS;
    private javax.swing.JCheckBox cbRotar;
    private javax.swing.JComboBox<String> cbUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane textPane;
    // End of variables declaration//GEN-END:variables
}
