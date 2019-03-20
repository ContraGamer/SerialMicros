/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialpc;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Contr
 */
public final class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    private String conn;
    private SerialPort puerto;
    private String concantenar = "";

    public String getConn() {
        return conn;
    }

    public void setConn(String conn) {
        this.conn = conn;
    }

    public Vista() {

        initComponents();
        puertos();
    }
    ConexionServicios conexion = new ConexionServicios();

    public void puertos() {
        //
        textAreaInput.setEditable(false);//Evita que se escriva en el TextArea de recibido.
        //textAreaInput.setMaximumSize(dmnsn);
        textAreaInput.setLineWrap(true);
        this.botonConexion.setEnabled(true);
        this.botonDesconexion.setEnabled(false);
        this.enviarBoton.setEnabled(false);
        this.actualizarBoton.setEnabled(true);

        //SerialPort comPort = SerialPort.getCommPorts()[0];
        jComboBox1.removeAllItems();
        if (SerialPort.getCommPorts().length > 0) {
            for (SerialPort comPort : SerialPort.getCommPorts()) {
                jComboBox1.addItem(comPort.getSystemPortName());
            }
            jComboBox1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    setConn(jComboBox1.getSelectedItem().toString());
                    for (SerialPort comPort : SerialPort.getCommPorts()) {
                        if (comPort.getSystemPortName().equalsIgnoreCase(conn)) {
                            puerto = comPort;
                        }
                    }
                }
            });

        } else {
            jComboBox1.addItem("No hay puertos disponibles");
        }

    }

    public void led(boolean estadoConexion) {
        if (estadoConexion) {
            this.ledConexion.setBackground(Color.GREEN);
            this.botonConexion.setEnabled(false);
            this.actualizarBoton.setEnabled(false);
            this.botonDesconexion.setEnabled(true);
            this.enviarBoton.setEnabled(true);
        } else {
            this.ledConexion.setBackground(Color.RED);
            this.botonConexion.setEnabled(true);
            this.actualizarBoton.setEnabled(true);
            this.botonDesconexion.setEnabled(false);
            this.enviarBoton.setEnabled(false);
        }
    }

    public void pintarAreaTexto() {
        conexion.timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //String parts[];
                    concantenar = concantenar.concat(conexion.recibirDatos());
                    //parts = concantenar.split(":");
                    //System.out.println(parts[1]);
                    textAreaInput.setText(concantenar);
                } catch (IOException ex) {
                    Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        conexion.timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaInput = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textEnvio = new javax.swing.JTextField();
        ledConexion = new javax.swing.JTextField();
        enviarBoton = new javax.swing.JButton();
        botonConexion = new javax.swing.JButton();
        botonDesconexion = new javax.swing.JButton();
        actualizarBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jComboBox1ComponentResized(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Puerto: ");

        jToggleButton2.setText("Cerrar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        textAreaInput.setColumns(20);
        textAreaInput.setRows(5);
        jScrollPane1.setViewportView(textAreaInput);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Texto", jPanel2);

        jScrollPane2.setViewportView(jEditorPane1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Grafica", jPanel3);

        jLabel3.setText("Velocidad recibir datos: ");

        jLabel4.setText("Recibir datos constantemente:");

        jLabel5.setText("ms");

        jButton1.setText("Actualizar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(487, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Configuraciones", jPanel1);

        jLabel2.setText("Enviar");

        textEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEnvioActionPerformed(evt);
            }
        });

        ledConexion.setEditable(false);
        ledConexion.setBackground(new java.awt.Color(204, 0, 0));
        ledConexion.setCaretColor(new java.awt.Color(255, 0, 0));
        ledConexion.setSelectedTextColor(new java.awt.Color(255, 0, 0));
        ledConexion.setSelectionColor(new java.awt.Color(204, 0, 0));
        ledConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ledConexionActionPerformed(evt);
            }
        });

        enviarBoton.setText("Enviar");
        enviarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarBotonActionPerformed(evt);
            }
        });

        botonConexion.setText("Conectar");
        botonConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConexionActionPerformed(evt);
            }
        });

        botonDesconexion.setText("Desconectar");
        botonDesconexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDesconexionActionPerformed(evt);
            }
        });

        actualizarBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/serialpc/actualizar-pagina-opcion.png"))); // NOI18N
        actualizarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonConexion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualizarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonDesconexion))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ledConexion)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enviarBoton)
                                    .addComponent(jToggleButton2))
                                .addGap(0, 7, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actualizarBoton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(botonConexion))
                    .addComponent(botonDesconexion, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(ledConexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(enviarBoton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEnvio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed

        conexion.cerrarPuerto();
        led(conexion.estadoConexion());
        System.exit(0);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jComboBox1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jComboBox1ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ComponentResized

    private void enviarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarBotonActionPerformed
        try {
            conexion.enviarDatos(textEnvio.getText());
            textEnvio.setText("");
        } catch (IOException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_enviarBotonActionPerformed

    private void textEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEnvioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEnvioActionPerformed

    private void botonConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConexionActionPerformed
        try {
            conexion.obtenerPuertoSeleccionado(this.puerto);
            //conexion.timer.start();
            pintarAreaTexto();
        } catch (IOException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        led(conexion.estadoConexion());
    }//GEN-LAST:event_botonConexionActionPerformed

    private void ledConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ledConexionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ledConexionActionPerformed

    private void botonDesconexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDesconexionActionPerformed

        conexion.cerrarPuerto();
        led(conexion.estadoConexion());
    }//GEN-LAST:event_botonDesconexionActionPerformed

    private void actualizarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBotonActionPerformed
        jComboBox1.removeAllItems();
        if (SerialPort.getCommPorts().length > 0) {
            for (SerialPort comPort : SerialPort.getCommPorts()) {
                jComboBox1.addItem(comPort.getSystemPortName());
            }
            jComboBox1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    setConn(jComboBox1.getSelectedItem().toString());
                    for (SerialPort comPort : SerialPort.getCommPorts()) {
                        if (comPort.getSystemPortName().equalsIgnoreCase(conn)) {
                            puerto = comPort;
                        }
                    }
                }
            });

        } else {
            jComboBox1.addItem("No hay puertos disponibles");
        }
    }//GEN-LAST:event_actualizarBotonActionPerformed

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
            java.util.logging.Logger.getLogger(Vista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarBoton;
    private javax.swing.JButton botonConexion;
    private javax.swing.JButton botonDesconexion;
    private javax.swing.JButton enviarBoton;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField ledConexion;
    private javax.swing.JTextArea textAreaInput;
    private javax.swing.JTextField textEnvio;
    // End of variables declaration//GEN-END:variables
}
