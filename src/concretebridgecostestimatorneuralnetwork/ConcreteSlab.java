/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concretebridgecostestimatorneuralnetwork;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.DataSet;
import org.neuroph.core.learning.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TrainingSetImport;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author Nuwan Prabhath
 */
public class ConcreteSlab extends javax.swing.JFrame {

    /**
     * Creates new form ConcreteSlab
     */
    public ConcreteSlab() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setTitle("Concrete Slab Prediction");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Concrete Slab Prediction");

        jLabel2.setText("Slab Length (m):");

        jLabel3.setText("Slab Width (m):");

        jLabel4.setText("Slab Thickness (mm):");

        jButton1.setText("Calculate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Result: ");

        jLabel6.setText("NA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jButton1))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1)
                                .addComponent(jTextField2)
                                .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))))
                .addContainerGap(138, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");       
        jTextField3.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        double length = 0;
        double width = 0;
        double thickness = 0;
       

        double minLength = 19.7;
        double maxLength = 72.55;
        
        double minWidth = 6.37;
        double maxWidth = 8.25;
        
        double minThickness = 200;
        double maxThickness = 300;
        
                
        //Cost limits
        double minCost = 3282736.53;
        double maxCost = 16076240.52;

        // declaring number of input neurons
        int inputCount = 3;

        // declaring number of output neurons
        int outputCount = 1;

        String trainingSetFileName = "concreteSlab.txt";

        try {

            length = Double.parseDouble(jTextField1.getText());
            width = Double.parseDouble(jTextField2.getText());
            thickness = Double.parseDouble(jTextField3.getText());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rootPane, "Please enter valid input");
        }
        length = Normalizer.normalizeInput(minLength, maxLength, length);
        width = Normalizer.normalizeInput(maxWidth, minWidth, width);
        thickness = Normalizer.normalizeInput(maxThickness, minThickness, thickness);

        ArrayList<Double> data = new ArrayList<Double>();
        data.add(length);
        data.add(width);
        data.add(thickness);

        DataSetRow test = new DataSetRow(data);

        //Create Training Set
        DataSet trainingSet = null;
        try {
            trainingSet = TrainingSetImport.importFromFile(trainingSetFileName, inputCount, outputCount, "\t");

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error reading file");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Bad number format");
        }

        //Create Multilayer Perceptron
        System.out.println("Creating neural network");
        MultiLayerPerceptron neuralNet = new MultiLayerPerceptron(TransferFunctionType.TANH, 3, 5, 1);

        //Set Learning Parameters 
        MomentumBackpropagation learningRule = (MomentumBackpropagation) neuralNet.getLearningRule();

        learningRule.learn(trainingSet, 0.01, 1000);  // maximum error and maximum number of iterations
        learningRule.setLearningRate(0.2);              // learning rate
        learningRule.setMomentum(0.7);                  // momentum

        //Learn the training set
        System.out.println("Training neural network...");
        neuralNet.learn(trainingSet);
        System.out.println("Finish!");

        // Test the perceptron 
        System.out.println("Testing the trained neural network");

        double valueEstimation = Normalizer.deNormalize(neuralNet, test,minCost,maxCost);

        System.out.println("Last Result " + valueEstimation);
        
        
        DecimalFormat nf = new DecimalFormat("#.##");
        String output = " Rs: " + nf.format(valueEstimation);
        jLabel6.setText(output);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(ConcreteSlab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConcreteSlab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConcreteSlab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConcreteSlab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConcreteSlab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
