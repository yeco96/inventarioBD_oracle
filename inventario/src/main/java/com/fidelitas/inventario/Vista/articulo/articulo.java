/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Vista.articulo;

import com.fidelitas.inventario.Controlador.ArticuloDao;
import com.fidelitas.inventario.Modelo.Articulo;
import com.fidelitas.inventario.Utilidades.Render;
import com.fidelitas.inventario.Vista.menu;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josue
 */
public class articulo extends javax.swing.JFrame {

    /**
     * Creates new form articulo
     */
    static ArrayList<String> datos = new ArrayList<String>();
    static boolean actualizar;

    public articulo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        codigo.setVisible(false);
        codigo.setEditable(false);
        codigo_lb.setVisible(false);
        actualizar = false;
        this.cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_DescripcionArt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cantMinArtic = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jB_AgregarArt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableArticul = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jB_VolverM = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        mensajeError = new javax.swing.JLabel();
        codigo_lb = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Articulo");

        txt_DescripcionArt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_DescripcionArt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_DescripcionArt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descripcion:");

        txt_cantMinArtic.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_cantMinArtic.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cantMinArtic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad Minima:");

        jB_AgregarArt.setBackground(new java.awt.Color(11, 51, 63));
        jB_AgregarArt.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jB_AgregarArt.setForeground(new java.awt.Color(255, 255, 255));
        jB_AgregarArt.setText("Agregar");
        jB_AgregarArt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jB_AgregarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AgregarArtActionPerformed(evt);
            }
        });

        jTableArticul.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableArticul.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableArticul.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "DESCRIPCION", "CANTIDAD MINIMA", "FECHA DE CREACION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableArticul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableArticulMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableArticul);

        jPanel2.setBackground(new java.awt.Color(11, 51, 63));

        jPanel3.setBackground(new java.awt.Color(240, 191, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(920, 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jB_VolverM.setBackground(new java.awt.Color(199, 80, 80));
        jB_VolverM.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jB_VolverM.setForeground(new java.awt.Color(255, 255, 255));
        jB_VolverM.setText("Volver");
        jB_VolverM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jB_VolverM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_VolverMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_VolverM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jB_VolverM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(11, 51, 63));

        jPanel5.setBackground(new java.awt.Color(240, 191, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(920, 2));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mensajeError.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mensajeError.setForeground(new java.awt.Color(255, 255, 255));
        mensajeError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensajeError.setText(" ");

        codigo_lb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        codigo_lb.setText("Código");

        codigo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(mensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jB_AgregarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(4, 4, 4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(codigo_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(codigo)
                                    .addComponent(txt_DescripcionArt, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                    .addComponent(txt_cantMinArtic, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))))
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigo_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_DescripcionArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cantMinArtic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jB_AgregarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_AgregarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_AgregarArtActionPerformed

        if (actualizar) {
            Articulo articulo = new Articulo();
            articulo.setCodigoArticulo(Integer.valueOf(codigo.getText()));
            articulo.setDescripcion(txt_DescripcionArt.getText());
            articulo.setCantidadMinima(new BigDecimal(txt_cantMinArtic.getText()));

            ArticuloDao articuloDao = new ArticuloDao();
            String[] callback = new String[1];
            if (articuloDao.actualizar(articulo, callback)) {
                JOptionPane.showMessageDialog(null, callback[0]);
            } else {
                JOptionPane.showMessageDialog(null, callback[0], "Error", JOptionPane.ERROR_MESSAGE);
            }
            cargarDatos();

            codigo.setVisible(false);
            codigo.setEditable(false);
            codigo_lb.setVisible(false);
            actualizar = false;
            codigo.setText("");
            txt_DescripcionArt.setText("");
            txt_cantMinArtic.setText("");
            jB_AgregarArt.setText("INSERTAR");

            return;
        }
        Articulo articulo = new Articulo();
        articulo.setDescripcion(txt_DescripcionArt.getText());
        articulo.setCantidadMinima(new BigDecimal(txt_cantMinArtic.getText()));

        ArticuloDao articuloDao = new ArticuloDao();
        String[] callback = new String[1];
        if (articuloDao.insertar(articulo, callback)) {
            JOptionPane.showMessageDialog(null, callback[0]);
        } else {
            JOptionPane.showMessageDialog(null, callback[0], "Error", JOptionPane.ERROR_MESSAGE);
        }
        cargarDatos();
        actualizar = false;
    }//GEN-LAST:event_jB_AgregarArtActionPerformed

    private void jTableArticulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableArticulMouseClicked
        try {
            int colum = jTableArticul.getColumnModel().getColumnIndexAtX(evt.getX());
            int row = evt.getY() / jTableArticul.getRowHeight();

            if (row < jTableArticul.getRowCount() && row >= 0 && colum < jTableArticul.getColumnCount() && colum >= 0) {

                Object value = jTableArticul.getValueAt(row, colum);
                if (value instanceof JButton) {
                    ((JButton) value).doClick();
                    JButton boton = (JButton) value;

                    if (boton.getName().equals("m")) {

                        codigo.setVisible(true);
                        codigo.setEditable(false);
                        codigo_lb.setVisible(true);
                        codigo.setText(jTableArticul.getValueAt(jTableArticul.getSelectedRow(), 0).toString());
                        txt_DescripcionArt.setText(jTableArticul.getValueAt(jTableArticul.getSelectedRow(), 1).toString());
                        txt_cantMinArtic.setText(jTableArticul.getValueAt(jTableArticul.getSelectedRow(), 2).toString());

                        jB_AgregarArt.setText("ACTUALIZAR");
                        actualizar = true;
                    }

                    if (boton.getName().equals("e")) {
                        String[] menu = {"Si", "No"};
                        int opcion = JOptionPane.showOptionDialog(
                                null, "¿Desea eliminar el registro?", "catálogo de articulo", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, menu, null
                        );
                        switch (opcion) {
                            case 0:

                                Articulo articulo = new Articulo();
                                articulo.setCodigoArticulo(Integer.valueOf(jTableArticul.getValueAt(jTableArticul.getSelectedRow(), 0).toString()));

                                ArticuloDao articuloDao = new ArticuloDao();
                                String[] callback = new String[1];
                                //String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0))
                                if (articuloDao.eliminar(articulo, callback)) {
                                    JOptionPane.showMessageDialog(null, callback[0]);
                                } else {
                                    JOptionPane.showMessageDialog(null, callback[0], "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                cargarDatos();
                                break;
                            case 1:

                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion invalida !", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    }
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTableArticulMouseClicked

    public void cargarDatos() {
        ArticuloDao articuloDao = new ArticuloDao();
        String[] callback = new String[1];
        List<Articulo> articulox = articuloDao.leer(null, callback);

        if (articulox == null) {
            return;
        }

        datos.removeAll(datos);
        this.setLocationRelativeTo(null);

        jTableArticul.setDefaultRenderer(Object.class, new Render());
        JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        Color color1 = new Color(199, 80, 80);
        Color color2 = new Color(17, 128, 170);
        btn1.setBackground(color2);
        btn1.setForeground(Color.white);
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
        btn2.setBackground(color1);
        btn2.setForeground(Color.white);
        String[] columnNames = {"Codigo", "Descripcion", "Cantidad Minima", "Fecha", "", ""};

        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableModel.setColumnIdentifiers(columnNames);

        Object[] datosObejto = new Object[6];
        articulox.forEach((t) -> {
            datosObejto[0] = t.getCodigoArticulo();
            datosObejto[1] = t.getDescripcion();
            datosObejto[2] = t.getCantidadMinima();
            datosObejto[3] = t.getFechaCreacion();
            datosObejto[4] = btn1;
            datosObejto[5] = btn2;
            tableModel.addRow(datosObejto);
        });

        jTableArticul.setModel(tableModel);

        jTableArticul.setRowHeight(30);

    }

    private void jB_VolverMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_VolverMActionPerformed
        menu ocb2 = new menu();
        ocb2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jB_VolverMActionPerformed

    private void codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoKeyTyped

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel codigo_lb;
    private javax.swing.JButton jB_AgregarArt;
    private javax.swing.JButton jB_VolverM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableArticul;
    private javax.swing.JLabel mensajeError;
    private javax.swing.JTextField txt_DescripcionArt;
    private javax.swing.JTextField txt_cantMinArtic;
    // End of variables declaration//GEN-END:variables

}
