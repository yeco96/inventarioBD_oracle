/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Vista.Venta;

import com.fidelitas.inventario.Controlador.ArticuloDao;
import com.fidelitas.inventario.Controlador.ProveedorDao;
import com.fidelitas.inventario.Controlador.TransaccionesDao;
import com.fidelitas.inventario.Modelo.Articulo;
import com.fidelitas.inventario.Modelo.Proveedor;
import com.fidelitas.inventario.Modelo.Venta;
import com.fidelitas.inventario.Modelo.VentaDetalle;
import com.fidelitas.inventario.Utilidades.Render;
import com.fidelitas.inventario.Vista.menu;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josue
 */
public class VentaView extends javax.swing.JFrame {

    /**
     * Creates new form Venta
     */
    public VentaView() {
        initComponents();
        this.setLocationRelativeTo(null);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
        String dateString = format.format(new Date());
        txtFecha.setText(dateString);
        txtTotal.setEditable(false);
        txtTotal.setText("0");
        txtidCliente.setText("");
        txtnombreCliente.setText("");
        tabla();
    }

    public void calcular() {
        txtTotal.setText("0");
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Object o = jTable1.getValueAt(i, 4);

            total = total.add(new BigDecimal(o.toString()));
        }
        txtTotal.setText(total.toString());
    }

    public void limpiar() {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        calcular();
        txtidCliente.setText("");
        txtnombreCliente.setText("");
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
        jPanel2 = new javax.swing.JPanel();
        agregar = new javax.swing.JButton();
        txtidCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtnombreCliente = new javax.swing.JTextField();
        txtarticulo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jBAgregar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(943, 445));

        agregar.setFont(new java.awt.Font("Franklin Gothic Book", 3, 18)); // NOI18N
        agregar.setText("AGREGAR");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        txtidCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidClienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Identificacion Cliente:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Fecha");

        jPanel5.setBackground(new java.awt.Color(11, 51, 63));

        jPanel6.setBackground(new java.awt.Color(240, 191, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(920, 2));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Venta");

        txtFecha.setEditable(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Total:");

        jPanel3.setBackground(new java.awt.Color(11, 51, 63));

        jPanel4.setBackground(new java.awt.Color(240, 191, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(920, 2));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jButton5.setBackground(new java.awt.Color(199, 80, 80));
        jButton5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Volver");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Valor C/U", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Nombre Cliente:");

        txtnombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreClienteActionPerformed(evt);
            }
        });

        txtarticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtarticuloActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Articulo");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Cantidad");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jBAgregar1.setFont(new java.awt.Font("Franklin Gothic Book", 3, 18)); // NOI18N
        jBAgregar1.setText("FACTURAR");
        jBAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregar1ActionPerformed(evt);
            }
        });

        jButton1.setText("LIMPIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtidCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(txtarticulo))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtnombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtCantidad)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(158, 158, 158))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBAgregar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(346, Short.MAX_VALUE))))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtidCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtnombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        menu ocb2 = new menu();
        ocb2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        txtFecha.setEditable(false);
        java.util.Date fecha = new Date();
        txtFecha.setText(fecha.toString());
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtidClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidClienteActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed

        if (txtarticulo.getText() == null || txtarticulo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un codigo de articulo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtCantidad.getText() == null || txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad valida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArticuloDao a = new ArticuloDao();
        String[] callback = new String[1];
        List<Articulo> articulos = a.leer(Integer.valueOf(txtarticulo.getText()), callback);

        if (articulos == null || articulos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El articulo no existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cargarArticulo(articulos.get(0), Integer.valueOf(txtCantidad.getText()));

        txtarticulo.setText(null);
        txtCantidad.setText(null);


    }//GEN-LAST:event_agregarActionPerformed

    public void tabla() {
        jTable1.setDefaultRenderer(Object.class, new Render());

        String[] columnNames = {"Codigo", "Descripcion", "Cantidad", "Precio", "Total", ""};

        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableModel.setColumnIdentifiers(columnNames);
        jTable1.setModel(tableModel);
        jTable1.setRowHeight(30);
    }

    public void cargarArticulo(Articulo a, Integer cantidad) {

        if (a.getExistencia().getEXISTENCIA().compareTo(new BigDecimal(cantidad)) < 0) {
            JOptionPane.showMessageDialog(null, "No hay existencia", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean aviso = false;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Object codigo = jTable1.getValueAt(i, 0);

            if (codigo == a.getCodigoArticulo()) {
                aviso = true;
                break;
            }
        }

        if (aviso) {
            JOptionPane.showMessageDialog(null, "La el articulo esta en el detalle", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Color color1 = new Color(199, 80, 80);
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
        btn2.setBackground(color1);
        btn2.setForeground(Color.white);

        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        Object[] datosObejto = new Object[7];

        datosObejto[0] = a.getCodigoArticulo();
        datosObejto[1] = a.getDescripcion();
        datosObejto[2] = cantidad;
        datosObejto[3] = a.getPrecio().getPrecio();
        datosObejto[4] = a.getPrecio().getPrecio().multiply(new BigDecimal(cantidad));
        datosObejto[5] = btn2;
        tableModel.addRow(datosObejto);

        jTable1.setModel(tableModel);
        calcular();
    }

    private void txtnombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreClienteActionPerformed

    private void txtarticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtarticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtarticuloActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void jBAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregar1ActionPerformed

        try {

            if (new BigDecimal(txtTotal.getText()).compareTo(BigDecimal.ZERO) == 0) {
                JOptionPane.showMessageDialog(null, "EL monto de la factura no debe ser 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            TransaccionesDao dao = new TransaccionesDao();
            String[] callback = new String[1];

            Venta venta = new Venta();
            Integer id = txtidCliente.getText().equals("") ? 0 : Integer.valueOf(txtidCliente.getText());
            venta.setIdentificacionCliente(id);
            venta.setNombreCliente(txtnombreCliente.getText());
            venta.setMontoVenta(new BigDecimal(txtTotal.getText()));
            venta.setDetalle(new ArrayList<>());
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                Object precio = jTable1.getValueAt(i, 3);
                Object cantidad = jTable1.getValueAt(i, 2);
                Object codigo = jTable1.getValueAt(i, 0);

                VentaDetalle detalle = new VentaDetalle();
                detalle.setPrecio(new BigDecimal(precio.toString()));
                detalle.setCodigoArticulo(Integer.valueOf(codigo.toString()));
                detalle.setCantidad(new BigDecimal(cantidad.toString()));
                venta.getDetalle().add(detalle);
            }

            if (!dao.insertarVenta(venta, callback)) {
                JOptionPane.showMessageDialog(null, callback, "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Correcto");
                limpiar();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBAgregar1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            int colum = jTable1.getColumnModel().getColumnIndexAtX(evt.getX());
            int row = evt.getY() / jTable1.getRowHeight();

            if (row < jTable1.getRowCount() && row >= 0 && colum < jTable1.getColumnCount() && colum >= 0) {

                Object value = jTable1.getValueAt(row, colum);
                if (value instanceof JButton) {
                    ((JButton) value).doClick();
                    JButton boton = (JButton) value;

                    if (boton.getName().equals("e")) {
                        String[] menu = {"Si", "No"};
                        int opcion = JOptionPane.showOptionDialog(
                                null, "¿Desea eliminar el registro?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, menu, null
                        );
                        switch (opcion) {
                            case 0:

                                //(Integer.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
                                //jTable1.remove(row);
                                ((DefaultTableModel) jTable1.getModel()).removeRow(row);
                                calcular();
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
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton jBAgregar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtarticulo;
    private javax.swing.JTextField txtidCliente;
    private javax.swing.JTextField txtnombreCliente;
    // End of variables declaration//GEN-END:variables
}
