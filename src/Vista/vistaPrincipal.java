/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author alber
 */
public class vistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form vistaPrincipal
     */
    public vistaPrincipal() {
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

        jLabelExpresion = new javax.swing.JLabel();
        jTextFieldExpresion = new javax.swing.JTextField();
        jLabelResultado = new javax.swing.JLabel();
        jTextFieldResultado = new javax.swing.JTextField();
        jButtonEvaluar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabelExpresion.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelExpresion.setText("Expresión:");

        jTextFieldExpresion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabelResultado.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelResultado.setText("Resultado:");

        jTextFieldResultado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jButtonEvaluar.setBackground(new java.awt.Color(0, 153, 204));
        jButtonEvaluar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButtonEvaluar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEvaluar.setText("Evaluar");

        jButtonLimpiar.setBackground(new java.awt.Color(0, 153, 204));
        jButtonLimpiar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButtonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLimpiar.setText("Limpiar");

        jButtonSalir.setBackground(new java.awt.Color(255, 51, 51));
        jButtonSalir.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelResultado)
                    .addComponent(jLabelExpresion)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEvaluar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButtonLimpiar)
                        .addGap(60, 60, 60)
                        .addComponent(jButtonSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldExpresion, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelExpresion)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldExpresion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultado)
                    .addComponent(jTextFieldResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonEvaluar, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(jButtonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonEvaluar;
    public javax.swing.JButton jButtonLimpiar;
    public javax.swing.JButton jButtonSalir;
    public javax.swing.JLabel jLabelExpresion;
    public javax.swing.JLabel jLabelResultado;
    public javax.swing.JTextField jTextFieldExpresion;
    public javax.swing.JTextField jTextFieldResultado;
    // End of variables declaration//GEN-END:variables
}
