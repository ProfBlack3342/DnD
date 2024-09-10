/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import exception.NoDataFoundException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.UsuarioVO;
import utilidades.Utils;

/**
 *
 * @author dudup
 */
public class GUILogin extends javax.swing.JFrame implements ItemListener{

    /**
     * Creates new form GUILoginI
     */
    public GUILogin() {
        initComponents();
        inicializarTelas();
        setLocationRelativeTo(null);
    }
    
    /**
     * 
     */
    private void inicializarTelas()
    {
        carregarImagens();
        preencherComboBoxAno();
        
        jcbAnoAniversarioCadastro.addItemListener(this);
        jcbMesAniversarioCadastro.addItemListener(this);
        jcbDiaAniversarioCadastro.addItemListener(this);
        
        limparLogin();
        limparCadastro();
    }
    
    /**
     * 
     */
    private void carregarImagens()
    {
        try
        {
            String caminhoImagemLogin = "/img/logon.png";
            String caminhoImagemCadastro = "/img/cadastro.png";
            BufferedImage imagem = ImageIO.read(getClass().getResourceAsStream(caminhoImagemLogin));
            if(imagem != null)
            {
                jlblImagemLogin.setIcon(new ImageIcon(imagem));
                jlblImagemLogin.setText(null);
            } 
            else
            {
                jlblImagemLogin.setText("Erro em Carregar Imagem");
                JOptionPane.showMessageDialog(null, "Erro em GUILogin.carregarImagens: Caminho de imagem de login inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
            imagem = ImageIO.read(getClass().getResourceAsStream(caminhoImagemCadastro));
            if(imagem != null)
            {
                jlblImagemCadastroE.setIcon(new ImageIcon(imagem));
                jlblImagemCadastroD.setIcon(new ImageIcon(imagem));
                jlblImagemCadastroE.setText(null);
                jlblImagemCadastroD.setText(null);
            } 
            else
            {
                jlblImagemCadastroE.setText("Erro\nCarregando\nImagem");
                jlblImagemCadastroD.setText("Erro\nCarregando\nImagem");
                JOptionPane.showMessageDialog(null, "Erro em GUILogin.carregarImagens: Caminho de imagem de cadastro inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(IOException ioE)
        {
            JOptionPane.showMessageDialog(null, "Erro em GUILogin.carregarImagens: " + ioE.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * 
     */
    private void preencherComboBoxAno() {
        int menorAno = Utils.getMenorAnoValido();
        int maiorAno = Utils.getMaiorAnoValido();
        
        
    }
    
    /**
     * 
     */
    private void limparLogin()
    {
        jtfUsuarioLogin.setText(null);
        jpfSenhaLogin.setText(null);
    }
    
    /**
     * 
     */
    private void limparCadastro()
    {
        jtfNomeCadastro.setText(null);
        
        jtfEmailCadastro.setText(null);
        
        jpfSenhaCadastro1.setText(null);
        jpfSenhaCadastro2.setText(null);
        
        resetarAniversario();
        
        jTextPaneDescricaoCadastro.setText(null);
    }
    
    /**
     * 
     */
    private void resetarAniversario() {
        jcbDiaAniversarioCadastro.removeAllItems();
        jcbDiaAniversarioCadastro.setSelectedIndex(-1);
        
        jcbMesAniversarioCadastro.removeAllItems();
        jcbMesAniversarioCadastro.setSelectedIndex(-1);
        
        jcbAnoAniversarioCadastro.setSelectedIndex(-1);
    }
    
    /**
     * 
     * @param ano 
     */
    private void preencherComboBoxMes(int ano) {
        int menorMes = Utils.getMenorMesValido();
        int maiorMes = Utils.getMaiorMesValido(ano);
        
        
    }
    
    /**
     * 
     * @param mes
     * @param ano 
     */
    private void preencherComboBoxDia(int mes, int ano) {
        int menorDia = Utils.getMenorDiaValido();
        int maiorDia = Utils.getMaiorDiaValido(mes, ano);
        
        
    }
    
    /**
     * 
     */
    private void tentarLogin() {
        boolean temErro = false;
        StringBuilder textoErro = new StringBuilder("Erro:\n");
        
        String usuario = jtfUsuarioLogin.getText();
        if(usuario.isEmpty())
        {
            temErro = true;
            jtfUsuarioLogin.setText(null);
            textoErro.append("O campo Usuário não foi preenchido!\n");
        }
        else if(!Verificar.verificarTextoComNumeros(usuario))
        {
            temErro = true;
            jtfUsuarioLogin.setText(null);
            textoErro.append("O campo Usuário contém dados inválidos!\n");
        }
        
        char[] senha = jpfSenhaLogin.getPassword();
        if(senha.length == 0)
        {
            temErro = true;
            jpfSenhaLogin.setText(null);
            textoErro.append("O campo Senha não foi preenchido!\n");
        }
        
        if(temErro)
        {
            JOptionPane.showMessageDialog(null, textoErro.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try {
                UsuarioVO uVO = servicos.FactoryServicos.getServicosUsuario().login("TextField Nome", "PasswordField Senha");
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                abrirGUIPrincipal(uVO);

            }
            catch (NoDataFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Exceção no Login: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void tentarCadastro()
    {
        boolean temErro = false;
        StringBuilder textoErro = new StringBuilder("Erro:\n");
        
        // Testar erros e criar msg de erro
        
        if(temErro)
        {
            JOptionPane.showMessageDialog(null, textoErro.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                UsuarioVO uVO = new UsuarioVO();
        
                String[] nomesColunas = UsuarioVO.getNomesColunas();
                uVO.putValorDadoUsuario(nomesColunas[1], 1);
                uVO.putValorDadoUsuario(nomesColunas[2], 2);
                uVO.putValorDadoUsuario(nomesColunas[3], "TextField Nome");
                uVO.putValorDadoUsuario(nomesColunas[4], "PasswordField Senha");
                uVO.putValorDadoUsuario(nomesColunas[5], "TextField E-mail");
                uVO.putValorDadoUsuario(nomesColunas[6], "ComboBoxes Data Aniversario");
                uVO.putValorDadoUsuario(nomesColunas[7], "TextArea Descricao");
                uVO.putValorDadoUsuario(nomesColunas[8], 6);
                uVO.putValorDadoUsuario(nomesColunas[9], 0);
        
                servicos.FactoryServicos.getServicosUsuario().cadastrar(uVO);
                
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso! Fazendo login...", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                abrirGUIPrincipal(uVO);
            }
            catch(NullPointerException | SQLException blE)
            {
                JOptionPane.showMessageDialog(null, "Erro: " + blE.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void abrirGUIPrincipal(UsuarioVO usuario)
    {
        limparLogin();
        limparCadastro();
        
        GUIPrincipal guiP = new GUIPrincipal(usuario);
        guiP.setVisible(true);
        
        setVisible(false);
        dispose();
    }
    
    /**
     * 
     */
    private void sair()
    {
        limparLogin();
        limparCadastro();
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelLogin = new javax.swing.JPanel();
        jPanelInternoLogin = new javax.swing.JPanel();
        jPanelImagemLogin = new javax.swing.JPanel();
        jPanelDadosLogin = new javax.swing.JPanel();
        jlblNomeUsuarioLogin = new javax.swing.JLabel();
        jtfNomeUsuarioLogin = new javax.swing.JTextField();
        jlblSenhaLogin = new javax.swing.JLabel();
        jpfSenhaLogin = new javax.swing.JPasswordField();
        jPanelAcoesLogin = new javax.swing.JPanel();
        jbtnTentarLogin = new javax.swing.JButton();
        jbtnLimparCamposLogin = new javax.swing.JButton();
        jbtnSairLogin = new javax.swing.JButton();
        jPanelCadastro = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(2560, 1440));
        setMinimumSize(new java.awt.Dimension(1280, 720));

        jPanelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanelInternoLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelImagemLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelImagemLoginLayout = new javax.swing.GroupLayout(jPanelImagemLogin);
        jPanelImagemLogin.setLayout(jPanelImagemLoginLayout);
        jPanelImagemLoginLayout.setHorizontalGroup(
            jPanelImagemLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelImagemLoginLayout.setVerticalGroup(
            jPanelImagemLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        jPanelDadosLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblNomeUsuarioLogin.setText("Usuário:");

        jlblSenhaLogin.setText("Senha:");

        jpfSenhaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfSenhaLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDadosLoginLayout = new javax.swing.GroupLayout(jPanelDadosLogin);
        jPanelDadosLogin.setLayout(jPanelDadosLoginLayout);
        jPanelDadosLoginLayout.setHorizontalGroup(
            jPanelDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblNomeUsuarioLogin)
                    .addComponent(jlblSenhaLogin))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpfSenhaLogin)
                    .addComponent(jtfNomeUsuarioLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelDadosLoginLayout.setVerticalGroup(
            jPanelDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLoginLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanelDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNomeUsuarioLogin)
                    .addComponent(jtfNomeUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblSenhaLogin)
                    .addComponent(jpfSenhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAcoesLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));

        jbtnTentarLogin.setText("Login");
        jbtnTentarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTentarLoginActionPerformed(evt);
            }
        });
        jbtnTentarLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnTentarLoginKeyPressed(evt);
            }
        });

        jbtnLimparCamposLogin.setText("Limpar");
        jbtnLimparCamposLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimparCamposLoginActionPerformed(evt);
            }
        });
        jbtnLimparCamposLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnLimparCamposLoginKeyPressed(evt);
            }
        });

        jbtnSairLogin.setText("Sair");
        jbtnSairLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSairLoginActionPerformed(evt);
            }
        });
        jbtnSairLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnSairLoginKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAcoesLoginLayout = new javax.swing.GroupLayout(jPanelAcoesLogin);
        jPanelAcoesLogin.setLayout(jPanelAcoesLoginLayout);
        jPanelAcoesLoginLayout.setHorizontalGroup(
            jPanelAcoesLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAcoesLoginLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jbtnTentarLogin)
                .addGap(29, 29, 29)
                .addComponent(jbtnLimparCamposLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jbtnSairLogin)
                .addGap(18, 18, 18))
        );
        jPanelAcoesLoginLayout.setVerticalGroup(
            jPanelAcoesLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAcoesLoginLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelAcoesLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnTentarLogin)
                    .addComponent(jbtnLimparCamposLogin)
                    .addComponent(jbtnSairLogin))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelInternoLoginLayout = new javax.swing.GroupLayout(jPanelInternoLogin);
        jPanelInternoLogin.setLayout(jPanelInternoLoginLayout);
        jPanelInternoLoginLayout.setHorizontalGroup(
            jPanelInternoLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInternoLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInternoLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDadosLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelImagemLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAcoesLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelInternoLoginLayout.setVerticalGroup(
            jPanelInternoLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInternoLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelImagemLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDadosLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelAcoesLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jPanelInternoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInternoLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Login", jPanelLogin);

        jPanelCadastro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Cadastro", jPanelCadastro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpfSenhaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfSenhaLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpfSenhaLoginActionPerformed

    private void jbtnTentarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTentarLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnTentarLoginActionPerformed

    private void jbtnTentarLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnTentarLoginKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnTentarLoginKeyPressed

    private void jbtnLimparCamposLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimparCamposLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnLimparCamposLoginActionPerformed

    private void jbtnLimparCamposLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnLimparCamposLoginKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnLimparCamposLoginKeyPressed

    private void jbtnSairLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSairLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnSairLoginActionPerformed

    private void jbtnSairLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnSairLoginKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnSairLoginKeyPressed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUILogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAcoesLogin;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelDadosLogin;
    private javax.swing.JPanel jPanelImagemLogin;
    private javax.swing.JPanel jPanelInternoLogin;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JButton jbtnLimparCamposLogin;
    private javax.swing.JButton jbtnSairLogin;
    private javax.swing.JButton jbtnTentarLogin;
    private javax.swing.JLabel jlblNomeUsuarioLogin;
    private javax.swing.JLabel jlblSenhaLogin;
    private javax.swing.JPasswordField jpfSenhaLogin;
    private javax.swing.JTextField jtfNomeUsuarioLogin;
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
