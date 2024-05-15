
package com.mycompany.CarCenterAplication.presentation;

import com.mycompany.CarCenterAplication.controller.CarController;
import com.mycompany.CarCenterAplication.domine.Car;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {
    private final CarController carController;
    private static final String[] COLUMNS = {"ID", "MARCA", "MODELO", "AÑO", "COLOR", "TRANSMISION"};
    private static final String SELECCIONE = "--SELECCIONE--";
    
    

    public Main() {
        initComponents();
        txtCarId.setEditable(false);
        carController = new CarController();
        listCars();
        addListener();
    }
    
    private void listCars() {
        cbxCars.removeAllItems();
        Car carcbx = new Car();
        carcbx.setMarca(SELECCIONE);
        carcbx.setModelo("");
        cbxCars.addItem(carcbx);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }
        tblCars.setModel(defaultTableModel);
        try {
            List<Car> cars = carController.obtenerCarros();
            if (cars.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(cars.size());
            int row = 0;
            for (Car car : cars) {
                defaultTableModel.setValueAt(car.getId(), row, 0);
                defaultTableModel.setValueAt(car.getMarca(), row, 1);
                defaultTableModel.setValueAt(car.getModelo(), row, 2);
                defaultTableModel.setValueAt(car.getAnho(), row, 3);
                defaultTableModel.setValueAt(car.getColor(), row, 4);
                defaultTableModel.setValueAt(car.getTransmision(), row, 5);
                row++;
                
                cbxCars.addItem(car);
            }
        } catch (SQLException ex) {
        }
        
    }
    
    
    public void addListener() {
        cbxCars.addItemListener(event -> {
            Car selectedCar = (Car) event.getItem();
            if (selectedCar.getMarca().equals(SELECCIONE)) {
                txtCarId.setText("");
                txtBrandEdit.setText("");
                txtModelEdit.setText("");
                txtYearEdit.setText("");
                txtColorEdit.setText("");
                txtTransmisionEdit.setText("");
            } else {
                txtCarId.setText(String.valueOf(selectedCar.getId()));
                txtBrandEdit.setText(selectedCar.getMarca());
                txtModelEdit.setText(selectedCar.getModelo());
                txtYearEdit.setText(selectedCar.getAnho());
                txtColorEdit.setText(selectedCar.getColor());
                txtTransmisionEdit.setText(selectedCar.getTransmision());
            }
            
        });
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JPanels = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPCar = new javax.swing.JPanel();
        lblBrand = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        lblTransmision = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtTransmision = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCars = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxCars = new javax.swing.JComboBox<>();
        lblCarID = new javax.swing.JLabel();
        lblBrandEdit = new javax.swing.JLabel();
        lblModelEdit = new javax.swing.JLabel();
        lblYearEdit = new javax.swing.JLabel();
        lblColorEdit = new javax.swing.JLabel();
        lblTransmisionEdit = new javax.swing.JLabel();
        txtCarId = new javax.swing.JTextField();
        txtBrandEdit = new javax.swing.JTextField();
        txtModelEdit = new javax.swing.JTextField();
        txtYearEdit = new javax.swing.JTextField();
        txtColorEdit = new javax.swing.JTextField();
        txtTransmisionEdit = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("GESTION DE CARROS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jPCar.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite los siguientes campos"));

        lblBrand.setText("MARCA");

        lblModel.setText("MODELO");

        lblYear.setText("AÑO");

        lblColor.setText("COLOR");

        lblTransmision.setText("TRANSMISION");

        txtBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrandActionPerformed(evt);
            }
        });

        txtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorActionPerformed(evt);
            }
        });

        btnSave.setText("GUARDAR");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCarLayout = new javax.swing.GroupLayout(jPCar);
        jPCar.setLayout(jPCarLayout);
        jPCarLayout.setHorizontalGroup(
            jPCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPCarLayout.createSequentialGroup()
                        .addGroup(jPCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblModel)
                            .addComponent(lblYear)
                            .addComponent(lblBrand)
                            .addComponent(lblColor))
                        .addGap(18, 18, 18)
                        .addGroup(jPCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtYear, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtColor)))
                    .addGroup(jPCarLayout.createSequentialGroup()
                        .addComponent(lblTransmision)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPCarLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnSave))
                            .addComponent(txtTransmision))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPCarLayout.setVerticalGroup(
            jPCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCarLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrand)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCarLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblModel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblYear)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColor)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTransmision)
                    .addComponent(txtTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addContainerGap())
        );

        tblCars.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCars.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tblCars);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jPCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        JPanels.addTab("Crear Carro", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifique los siguentes campos"));

        jLabel2.setText("CARROS");

        cbxCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCarsActionPerformed(evt);
            }
        });

        lblCarID.setText("ID");

        lblBrandEdit.setText("MARCA");

        lblModelEdit.setText("MODELO");

        lblYearEdit.setText("AÑO");

        lblColorEdit.setText("COLOR");

        lblTransmisionEdit.setText("TRANSMISION");

        txtCarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarIdActionPerformed(evt);
            }
        });

        txtBrandEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrandEditActionPerformed(evt);
            }
        });

        txtModelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModelEditActionPerformed(evt);
            }
        });

        txtColorEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorEditActionPerformed(evt);
            }
        });

        btnEdit.setText("ACTUALIZAR");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("ELIMINAR");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxCars, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblTransmisionEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTransmisionEdit))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBrandEdit)
                                    .addComponent(lblModelEdit)
                                    .addComponent(lblYearEdit)
                                    .addComponent(lblColorEdit)
                                    .addComponent(lblCarID, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCarId)
                                    .addComponent(txtColorEdit)
                                    .addComponent(txtYearEdit)
                                    .addComponent(txtModelEdit)
                                    .addComponent(txtBrandEdit))))))
                .addContainerGap(490, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbxCars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCarID)
                            .addComponent(txtCarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBrandEdit)
                            .addComponent(txtBrandEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblModelEdit)
                            .addComponent(txtModelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblYearEdit)
                            .addComponent(txtYearEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblColorEdit))
                    .addComponent(txtColorEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTransmisionEdit)
                    .addComponent(txtTransmisionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        JPanels.addTab("Actualizar Carro", jPanel2);

        getContentPane().add(JPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 790, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBrandActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed


        //CREAR BOTON DE GUARDAR Y CREAR UNA VENTANANS DE ADVERTENCIA DICIENDO QUE CAMPO ESTA SIN DIGITAR//--------------------------------------

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (txtBrand.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el campo vacio");
            txtBrand.requestFocus();
            return;
        }

        if (txtModel.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el campo vacion");
            txtModel.requestFocus();
            return;
        }

        if (txtYear.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el campo vacio");
            txtYear.requestFocus();
            return;
        }

        if (txtColor.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el campo vacio");
            txtColor.requestFocus();
            return;
        }

        if (txtTransmision.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el campo vacio");
            txtTransmision.requestFocus();
            return;
        }
        try {

            // SETEAMOS CADA UNO DE LOS CAMPOS DE LA INTERFAZ//--------------------------------------------------------------------------------
            Car car = new Car();
            car.setMarca(txtBrand.getText().trim());
            car.setModelo(txtModel.getText().trim());
            car.setAnho(txtYear.getText().trim());
            car.setColor(txtColor.getText().trim());
            car.setTransmision(txtTransmision.getText().trim());
            

            //LLAMAMOS AL METODO CREAR DEL CONTROLADOR//
            carController.crearCarro(car);

            //DESPUES AL MOMENTO DE DAR EN GUARDAR, LIMPIAMOS LAS CAJAS DE TEXTO//--------------------------------------------------------------
            txtBrand.setText("");
            txtModel.setText("");
            txtYear.setText("");
            txtColor.setText("");
            txtTransmision.setText("");
            
            //LLAMAMOS AL METODO DE LISTAR CARROS//-----------------------------------------------
            listCars();
            
            //MENSAJE DE CREACION DE CARRO CON EXITO//--------------------------------------------
            JOptionPane.showMessageDialog(null, "Carro creado con exito");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
            //NO SE PUDO CREAR EL CARRO//----------------------------------------
            JOptionPane.showMessageDialog(null, "No se pudo crear el carro");
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbxCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCarsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCarsActionPerformed

    private void txtCarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarIdActionPerformed

    private void txtBrandEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrandEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBrandEditActionPerformed

    private void txtModelEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModelEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelEditActionPerformed

    private void txtColorEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorEditActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        

        //CREAMOS EL CODIGO DEL BOTON ACTUALIZAR//-----------------------------------------------
        if (txtCarId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un carro de la lista");
            txtCarId.requestFocus();
            return;
        }
        
        if (txtBrandEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el campo vacio");
            txtBrandEdit.requestFocus();
            return;
        }

        if (txtModelEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el campo vacion");
            txtModelEdit.requestFocus();
            return;
        }

        if (txtYearEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el campo vacio");
            txtYearEdit.requestFocus();
            return;
        }

        if (txtColorEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el campo vacio");
            txtColorEdit.requestFocus();
            return;
        }

        if (txtTransmisionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el campo vacio");
            txtTransmisionEdit.requestFocus();
            return;
        }

        // SETEAMOS CADA UNO DE LOS CAMPOS DE LA INTERFAZ DE ACTUALIZAR//--------------------------------------------------------------------------------
        Car car = new Car();
        car.setMarca(txtBrandEdit.getText().trim());
        car.setModelo(txtModelEdit.getText().trim());
        car.setAnho(txtYearEdit.getText().trim());
        car.setColor(txtColorEdit.getText().trim());
        car.setTransmision(txtTransmisionEdit.getText().trim());

        //MENSAJE AL USUARION EN UNA PEQUEÑA INTERFAZ PARA PREGUNTARLE SI QUIERE ACTUALIZAR EL CARRO//--------------------------------------
        int opt = JOptionPane.showConfirmDialog(null, "Desea actualizar el carro", "Confirmar salida", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (opt == 0) {

            try {

                //LLAMAMOS AL METODO ACTUALIZARCARRO DEL CONTROLADOR, RECIBE EL ID QUE ESTA EN LA INTEFAZ Y TAMBIEN RECIBE LA ACTUALIZACION DEL CARRO//---------
                carController.actualizarCarro(Integer.parseInt(txtCarId.getText()), car);

                //DESPUES AL MOMENTO DE DAR EN GUARDAR, LIMPIAMOS LAS CAJAS DE TEXTO DE ACTUALIZAR//
                txtBrandEdit.setText("");
                txtModelEdit.setText("");
                txtYearEdit.setText("");
                txtColorEdit.setText("");
                txtTransmisionEdit.setText("");
               
                //LLAMAMOS AL METODO LISTCARS//
                listCars();

                //MENSAJE DE CREACION DE CARRO CON EXITO//--------------------------------------------
                JOptionPane.showMessageDialog(null, "Se ha actualizado el carro con exito");

            } catch (SQLException ex) {
                ex.printStackTrace();

                //NO SE PUDO CREAR EL CARRO//----------------------------------------
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el carro");
            }
        }
    
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        //CREAMOS EL CODIGO DEL BOTON ELIMINAR//-----------------------------------------------
        if (txtCarId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un carro de la lista");
            txtCarId.requestFocus();
            return;
        }

        //MENSAJE AL USUARION EN UNA PEQUEÑA INTERFAZ PARA PREGUNTARLE SI QUIERE ACTUALIZAR EL CARRO//--------------------------------------
        int opt = JOptionPane.showConfirmDialog(null, "Desea Eliminar el carro?", "Confirmar salida",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (opt == 0) {

            try {

                //LLAMAMOS AL METODO ELIMINARCARRO DEL CONTROLADOR, RECIBE EL ID QUE ESTA EN LA INTEFAZ//---------
                carController.eliminarCarro(Integer.parseInt(txtCarId.getText()));

                //DESPUES AL MOMENTO DE DAR EN GUARDAR, LIMPIAMOS LAS CAJAS DE TEXTO DE ACTUALIZAR//
                txtBrandEdit.setText("");
                txtModelEdit.setText("");
                txtYearEdit.setText("");
                txtColorEdit.setText("");
                txtTransmisionEdit.setText("");

                listCars();

                //MENSAJE DE ELIMINACION DE CARRO CON EXITO//--------------------------------------------
                JOptionPane.showMessageDialog(null, "Se eliminado el carro con exito");

            } catch (SQLException ex) {
                ex.printStackTrace();

                //NO SE PUDO CREAR EL CARRO//----------------------------------------
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el carro");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JPanels;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Car> cbxCars;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPCar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblBrandEdit;
    private javax.swing.JLabel lblCarID;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblColorEdit;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblModelEdit;
    private javax.swing.JLabel lblTransmision;
    private javax.swing.JLabel lblTransmisionEdit;
    private javax.swing.JLabel lblYear;
    private javax.swing.JLabel lblYearEdit;
    private javax.swing.JTable tblCars;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtBrandEdit;
    private javax.swing.JTextField txtCarId;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtColorEdit;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtModelEdit;
    private javax.swing.JTextField txtTransmision;
    private javax.swing.JTextField txtTransmisionEdit;
    private javax.swing.JTextField txtYear;
    private javax.swing.JTextField txtYearEdit;
    // End of variables declaration//GEN-END:variables
}
