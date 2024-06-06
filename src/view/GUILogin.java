/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import exception.NoDataFoundException;
import modelo.UsuarioVO;
import objetosFront.DadosLogin;
import servicos.ServicosFactory;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class GUILogin extends javax.swing.JFrame {

    /**
     * Creates new form GUILoginI
     */
    public GUILogin() {
        initComponents();
    }
    
    private void limpar()
    {
        jtfUsuario.setText(null);
        jpfSenha.setText(null);
    }
    
    private void tentarLogin()
    {
        try
        {
            DadosLogin dadosLogin = new DadosLogin(jtfUsuario.getText(), new String(jpfSenha.getPassword()));
            limpar();
            
            UsuarioVO usuario = ServicosFactory.getUsuarioServicos().loginUsuario(dadosLogin);
            if(usuario == null)
                JOptionPane.showMessageDialog(null, "Erro: Usuário ou senha não correspondem a nenhuma registrada", "Erro", JOptionPane.ERROR_MESSAGE);
            else
            {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                abrirGUIPrincipal(usuario);
            }
        }
        catch(NoDataFoundException | SQLException | NullPointerException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abrirGUIPrincipal(UsuarioVO usuario)
    {
        limpar();
        
        GUIPrincipal guiP = new GUIPrincipal(usuario);
        guiP.setVisible(true);
        
        setVisible(false);
        dispose();
    }
    
    private void sair()
    {
        limpar();
        System.exit(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jpLogin = new javax.swing.JPanel();
        jpnlTitulo = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jpnlDados = new javax.swing.JPanel();
        jlblUsuario = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jpfSenha = new javax.swing.JPasswordField();
        jlplSenha = new javax.swing.JLabel();
        jpnlAcoes = new javax.swing.JPanel();
        jbntLogin = new javax.swing.JButton();
        jbtnSair = new javax.swing.JButton();
        jpCadastro = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnlTitulo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jpnlTituloLayout = new javax.swing.GroupLayout(jpnlTitulo);
        jpnlTitulo.setLayout(jpnlTituloLayout);
        jpnlTituloLayout.setHorizontalGroup(
            jpnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnlTituloLayout.setVerticalGroup(
            jpnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
        );

        jpnlDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblUsuario.setText("Usuário:");

        jlplSenha.setText("Senha:");

        javax.swing.GroupLayout jpnlDadosLayout = new javax.swing.GroupLayout(jpnlDados);
        jpnlDados.setLayout(jpnlDadosLayout);
        jpnlDadosLayout.setHorizontalGroup(
            jpnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlplSenha)
                    .addComponent(jlblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfUsuario)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlDadosLayout.setVerticalGroup(
            jpnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlplSenha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnlAcoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbntLogin.setText("Fazer Login");
        jbntLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbntLoginActionPerformed(evt);
            }
        });
        jbntLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbntLoginKeyPressed(evt);
            }
        });

        jbtnSair.setText("Sair");
        jbtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSairActionPerformed(evt);
            }
        });
        jbtnSair.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnSairKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jpnlAcoesLayout = new javax.swing.GroupLayout(jpnlAcoes);
        jpnlAcoes.setLayout(jpnlAcoesLayout);
        jpnlAcoesLayout.setHorizontalGroup(
            jpnlAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlAcoesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jbntLogin)
                .addGap(34, 34, 34)
                .addComponent(jbtnSair)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jpnlAcoesLayout.setVerticalGroup(
            jpnlAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlAcoesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jpnlAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbntLogin)
                    .addComponent(jbtnSair))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jpnlDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginLayout.createSequentialGroup()
                .addGap(0, 115, Short.MAX_VALUE)
                .addComponent(jpnlAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnlDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnlAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Login", jpLogin);

        javax.swing.GroupLayout jpCadastroLayout = new javax.swing.GroupLayout(jpCadastro);
        jpCadastro.setLayout(jpCadastroLayout);
        jpCadastroLayout.setHorizontalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        jpCadastroLayout.setVerticalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Cadastro", jpCadastro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbntLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbntLoginActionPerformed
        tentarLogin();
    }//GEN-LAST:event_jbntLoginActionPerformed

    private void jbntLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbntLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tentarLogin();
        }
    }//GEN-LAST:event_jbntLoginKeyPressed

    private void jbtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSairActionPerformed
        sair();
    }//GEN-LAST:event_jbtnSairActionPerformed

    private void jbtnSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnSairKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            sair();
        }
    }//GEN-LAST:event_jbtnSairKeyPressed

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
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUILogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JButton jbntLogin;
    private javax.swing.JButton jbtnSair;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlblUsuario;
    private javax.swing.JLabel jlplSenha;
    private javax.swing.JPanel jpCadastro;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JPanel jpnlAcoes;
    private javax.swing.JPanel jpnlDados;
    private javax.swing.JPanel jpnlTitulo;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
