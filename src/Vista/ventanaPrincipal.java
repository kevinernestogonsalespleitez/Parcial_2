package Vista;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ventanaPrincipal extends javax.swing.JFrame {

    public ventanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        //panelPrincipal.setBackground(new Color(0,0,0,0));
        btnSalir.setBackground(new Color(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        Panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JTPPass = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        btnIngresarx = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnOlvideContraseña = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnAcercade = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_delete_sign_25px.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 30, 30));

        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(320, 450));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCorreo.setBorder(null);
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 210, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_lock_2_filled_25px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_user_filled_25px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/campos.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 240, 30));

        JTPPass.setBorder(null);
        jPanel1.add(JTPPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 210, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/campos.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 240, 30));

        btnIngresarx.setBackground(new java.awt.Color(51, 51, 51));
        btnIngresarx.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnIngresarx.setForeground(new java.awt.Color(204, 204, 204));
        btnIngresarx.setText("Ingresar");
        btnIngresarx.setBorder(null);
        btnIngresarx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarxActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresarx, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 240, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("INICIA SESION");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, 40));

        btnOlvideContraseña.setFont(new java.awt.Font("Dialog", 3, 10)); // NOI18N
        btnOlvideContraseña.setForeground(new java.awt.Color(204, 204, 204));
        btnOlvideContraseña.setText("Olvidaste la contraseña?");
        btnOlvideContraseña.setBorder(null);
        btnOlvideContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOlvideContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(btnOlvideContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_user_male_circle_70px.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 70, 70));

        btnAcercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_attention_25px.png"))); // NOI18N
        btnAcercade.setBorder(null);
        btnAcercade.setBorderPainted(false);
        btnAcercade.setContentAreaFilled(false);
        btnAcercade.setDefaultCapable(false);
        btnAcercade.setFocusPainted(false);
        btnAcercade.setFocusable(false);
        btnAcercade.setRequestFocusEnabled(false);
        btnAcercade.setVerifyInputWhenFocusTarget(false);
        btnAcercade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAcercadeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAcercadeMouseExited(evt);
            }
        });
        btnAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercadeActionPerformed(evt);
            }
        });
        jPanel1.add(btnAcercade, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        Panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 450));

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 450));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondow.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnOlvideContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOlvideContraseñaActionPerformed

    }//GEN-LAST:event_btnOlvideContraseñaActionPerformed

    private void btnAcercadeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcercadeMouseEntered
        //actualizarBotonAcercade();
    }//GEN-LAST:event_btnAcercadeMouseEntered

    private void btnAcercadeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcercadeMouseExited
        //actualizarBotonAcercade();
    }//GEN-LAST:event_btnAcercadeMouseExited

    private void btnAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercadeActionPerformed
        //acercade();
    }//GEN-LAST:event_btnAcercadeActionPerformed

    private void btnIngresarxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarxActionPerformed

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if(validarCorreo(txtCorreo.getText())){
            this.JTPPass.requestFocus();
        }else{
            //lblUser.setText("!");
            txtCorreo.requestFocus();
        }
    }//GEN-LAST:event_txtCorreoFocusLost
    public boolean validarCorreo(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\\\\\+]+(\\.[\\w\\\\]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(correo);

        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPasswordField JTPPass;
    public javax.swing.JPanel Panel;
    public javax.swing.JButton btnAcercade;
    public javax.swing.JButton btnIngresarx;
    public javax.swing.JButton btnOlvideContraseña;
    public javax.swing.JButton btnSalir;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblFondo;
    public javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
