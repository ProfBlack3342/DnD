/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

import exception.NoUserFoundException;
import exception.ForbiddenArgumentTypeException;
import modelo.ImagemVO;
import objetosFront.Login;
import modelo.UsuarioVO;
import servicos.ServicosFactory;
import utilidades.Converter;

/**
 *
 * @author 181700271
 */
public class GUILogin extends javax.swing.JInternalFrame {
    
    private UsuarioVO usuarioVOLogado;
    
    /**
     * Creates new form GUILogin
     */
    public GUILogin() {
        initComponents();
        usuarioVOLogado = null;
    }
    
    public GUILogin(String usuario) {
        initComponents();
        jtfUsuarioLogin.setText(usuario);
        usuarioVOLogado = null;
    }
    
    private void limparTexto()
    {
        jtfUsuarioLogin.setText(null);
        jpfSenhaLogin.setText(null);
        jtfUsuarioCadastro.setText(null);
        jpfSenhaCadastro.setText(null);
        jtfDescricaoCadastro.setText(null);
    }
    
    private void login()
    {
        Login lVO = new Login();
        lVO.setUsuario(jtfUsuarioLogin.getText());
        lVO.setSenha(new String(jpfSenhaLogin.getPassword()));
        limparTexto();
        
        try
        {
            UsuarioVO uVO = ServicosFactory.getUsuarioServicos().loginUsuario(lVO);
            
            if(uVO == null)
                JOptionPane.showMessageDialog(null, "Usuário e/ou Senha inválidos!");
            else
            {
                uVO.setSenha("Senha");
                usuarioVOLogado = uVO;
                dispose();
            }
        }
        catch(SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
        }
        catch(NoUserFoundException nufe) {
            JOptionPane.showMessageDialog(null, nufe.getMessage(), "Aviso: ", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void cadastrar()
    {
        UsuarioVO uVO = new UsuarioVO();
        ImagemVO iVO = new ImagemVO("", "", "");
        
        iVO.setId(1); //Pegar dados
        uVO.setImagem(iVO);
        uVO.setIdTipo(2);
        uVO.setNome(jtfUsuarioCadastro.getText());
        uVO.setSenha(new String(jpfSenhaCadastro.getPassword()));
        uVO.setDescricao(jtfDescricaoCadastro.getText());
        uVO.setQuantPersonagensMaxima(6);
        uVO.setQuantPersonagensExistentes(0);
        String[] data = Converter.converterStringParaDiaMesAno(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        uVO.setDiaCriacao(data[0]);
        uVO.setMesCriacao(data[1]);
        uVO.setAnoCriacao(data[2]);
        uVO.setAtivo(true);
        limparTexto();
        
        try
        {
            ServicosFactory.getUsuarioServicos().cadastrarUsuario(uVO);
            uVO.setSenha("Senha");
            usuarioVOLogado = uVO;
            dispose();
        }
        catch(SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
        }
        catch(ForbiddenArgumentTypeException wate) {
            JOptionPane.showMessageDialog(null, wate.getMessage(), "Erro: ", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void sair()
    {
        limparTexto();
        dispose();
    }

    public UsuarioVO getUsuarioVOLogado() {
        return usuarioVOLogado;
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
        jPanelLogin = new javax.swing.JPanel();
        jPanelDadosLogin = new javax.swing.JPanel();
        jlblUsuarioLogin = new javax.swing.JLabel();
        jtfUsuarioLogin = new javax.swing.JTextField();
        jlblSenhaLogin = new javax.swing.JLabel();
        jpfSenhaLogin = new javax.swing.JPasswordField();
        jPanelBotoesLogin = new javax.swing.JPanel();
        jbtnLogin = new javax.swing.JButton();
        jbtnSairLogin = new javax.swing.JButton();
        jPanelCadastro = new javax.swing.JPanel();
        jPanelDadosCadastro = new javax.swing.JPanel();
        jlblUsuarioCadastro = new javax.swing.JLabel();
        jtfUsuarioCadastro = new javax.swing.JTextField();
        jlblSenhaCadastro = new javax.swing.JLabel();
        jpfSenhaCadastro = new javax.swing.JPasswordField();
        jlblDescricaoCadastro = new javax.swing.JLabel();
        jtfDescricaoCadastro = new javax.swing.JTextField();
        jPanelBotoesCadastro = new javax.swing.JPanel();
        jbtnCadastrar = new javax.swing.JButton();
        jbtnSairCadastro = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setTitle("Login");
        setToolTipText("Login");

        jPanelDadosLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));
        jPanelDadosLogin.setToolTipText("");
        jPanelDadosLogin.setName(""); // NOI18N

        jlblUsuarioLogin.setText("Usuário:");

        jlblSenhaLogin.setText("Senha:");

        javax.swing.GroupLayout jPanelDadosLoginLayout = new javax.swing.GroupLayout(jPanelDadosLogin);
        jPanelDadosLogin.setLayout(jPanelDadosLoginLayout);
        jPanelDadosLoginLayout.setHorizontalGroup(
            jPanelDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblUsuarioLogin)
                    .addComponent(jlblSenhaLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfUsuarioLogin)
                    .addComponent(jpfSenhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanelDadosLoginLayout.setVerticalGroup(
            jPanelDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblUsuarioLogin)
                    .addComponent(jtfUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblSenhaLogin)
                    .addComponent(jpfSenhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBotoesLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));

        jbtnLogin.setText("Login");
        jbtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLoginActionPerformed(evt);
            }
        });
        jbtnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnLoginKeyPressed(evt);
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

        javax.swing.GroupLayout jPanelBotoesLoginLayout = new javax.swing.GroupLayout(jPanelBotoesLogin);
        jPanelBotoesLogin.setLayout(jPanelBotoesLoginLayout);
        jPanelBotoesLoginLayout.setHorizontalGroup(
            jPanelBotoesLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLoginLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jbtnLogin)
                .addGap(39, 39, 39)
                .addComponent(jbtnSairLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotoesLoginLayout.setVerticalGroup(
            jPanelBotoesLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotoesLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnLogin)
                    .addComponent(jbtnSairLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelBotoesLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDadosLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDadosLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jPanelBotoesLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Login", jPanelLogin);

        jPanelDadosCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jlblUsuarioCadastro.setText("Usuário:");

        jlblSenhaCadastro.setText("Senha:");

        jlblDescricaoCadastro.setText("Descrição (Opcional):");

        javax.swing.GroupLayout jPanelDadosCadastroLayout = new javax.swing.GroupLayout(jPanelDadosCadastro);
        jPanelDadosCadastro.setLayout(jPanelDadosCadastroLayout);
        jPanelDadosCadastroLayout.setHorizontalGroup(
            jPanelDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosCadastroLayout.createSequentialGroup()
                                .addGroup(jPanelDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblUsuarioCadastro)
                                    .addComponent(jlblSenhaCadastro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfUsuarioCadastro)
                                    .addComponent(jpfSenhaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jlblDescricaoCadastro))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtfDescricaoCadastro))
                .addContainerGap())
        );
        jPanelDadosCadastroLayout.setVerticalGroup(
            jPanelDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblUsuarioCadastro)
                    .addComponent(jtfUsuarioCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblSenhaCadastro)
                    .addComponent(jpfSenhaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlblDescricaoCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDescricaoCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelBotoesCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));

        jbtnCadastrar.setText("Cadastrar");
        jbtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCadastrarActionPerformed(evt);
            }
        });
        jbtnCadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnCadastrarKeyPressed(evt);
            }
        });

        jbtnSairCadastro.setText("Sair");
        jbtnSairCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSairCadastroActionPerformed(evt);
            }
        });
        jbtnSairCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnSairCadastroKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotoesCadastroLayout = new javax.swing.GroupLayout(jPanelBotoesCadastro);
        jPanelBotoesCadastro.setLayout(jPanelBotoesCadastroLayout);
        jPanelBotoesCadastroLayout.setHorizontalGroup(
            jPanelBotoesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesCadastroLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jbtnCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jbtnSairCadastro)
                .addGap(46, 46, 46))
        );
        jPanelBotoesCadastroLayout.setVerticalGroup(
            jPanelBotoesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesCadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBotoesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCadastrar)
                    .addComponent(jbtnSairCadastro))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelBotoesCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDadosCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDadosCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotoesCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Cadastro", jPanelCadastro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLoginActionPerformed
        login();
    }//GEN-LAST:event_jbtnLoginActionPerformed

    private void jbtnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnLoginKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            login();
    }//GEN-LAST:event_jbtnLoginKeyPressed

    private void jbtnSairLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSairLoginActionPerformed
        sair();
    }//GEN-LAST:event_jbtnSairLoginActionPerformed

    private void jbtnSairLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnSairLoginKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            sair();
    }//GEN-LAST:event_jbtnSairLoginKeyPressed

    private void jbtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_jbtnCadastrarActionPerformed

    private void jbtnCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnCadastrarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            cadastrar();
    }//GEN-LAST:event_jbtnCadastrarKeyPressed

    private void jbtnSairCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSairCadastroActionPerformed
        sair();
    }//GEN-LAST:event_jbtnSairCadastroActionPerformed

    private void jbtnSairCadastroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnSairCadastroKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            sair();
    }//GEN-LAST:event_jbtnSairCadastroKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelBotoesCadastro;
    private javax.swing.JPanel jPanelBotoesLogin;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelDadosCadastro;
    private javax.swing.JPanel jPanelDadosLogin;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JButton jbtnCadastrar;
    private javax.swing.JButton jbtnLogin;
    private javax.swing.JButton jbtnSairCadastro;
    private javax.swing.JButton jbtnSairLogin;
    private javax.swing.JLabel jlblDescricaoCadastro;
    private javax.swing.JLabel jlblSenhaCadastro;
    private javax.swing.JLabel jlblSenhaLogin;
    private javax.swing.JLabel jlblUsuarioCadastro;
    private javax.swing.JLabel jlblUsuarioLogin;
    private javax.swing.JPasswordField jpfSenhaCadastro;
    private javax.swing.JPasswordField jpfSenhaLogin;
    private javax.swing.JTextField jtfDescricaoCadastro;
    private javax.swing.JTextField jtfUsuarioCadastro;
    private javax.swing.JTextField jtfUsuarioLogin;
    // End of variables declaration//GEN-END:variables
}
