/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import exception.NoDataFoundException;
import modelo.ImagemUsuarioVO;
import modelo.UsuarioVO;
import servicos.ServicosFactory;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class GUIPrincipal extends javax.swing.JFrame implements InternalFrameListener{

    private UsuarioVO usuarioVOLogado;
    
    private boolean flagGUIPersonagens = false;
    private boolean flagGUIFichas = false;
    private boolean flagGUIAdminUsuarios = false;
    private boolean flagGUIAdminPersonagens = false;
    
    private GUIPrincipal() {
        JOptionPane.showMessageDialog(null, "Erro: Faça login antes de utilizar o programa!", "Erro", JOptionPane.ERROR_MESSAGE);
        GUILogin guiL = new GUILogin();
        guiL.setVisible(true);
        
        setVisible(false);
        dispose();
    }
    /**
     * Creates new form GUIPrincipal
     * @param usuarioVOLogado
     */
    public GUIPrincipal(UsuarioVO usuarioVOLogado) {
        initComponents();
        this.usuarioVOLogado = usuarioVOLogado;
        preencherPerfil();
    }
    
    private void preencherPerfil() {
        if(usuarioVOLogado.getIdTipo() == 1)
        {
            jMenuAdmin.setEnabled(true);
            jMenuItemAdminUsuarios.setEnabled(true);
            jMenuItemPersonagens.setEnabled(true);
        }
        else
        {
            jMenuItemAdminUsuarios.setEnabled(false);
            jMenuItemPersonagens.setEnabled(false);
            jMenuAdmin.setEnabled(false);
        }
        
        try
        {
            ImagemUsuarioVO imagemPersonagem = ServicosFactory.getImagemServicos().pesquisarImagemUsuario(usuarioVOLogado.getIdImagem());
            String caminhoImagem = imagemPersonagem.getCaminhoImagem();
            BufferedImage imagemUsuario = ImageIO.read(getClass().getResourceAsStream(caminhoImagem));
            
            jLabelImagem.setIcon(new ImageIcon(imagemUsuario));
            jLabelImagem.setText(null);
            jLabelNomeUsuario.setText(usuarioVOLogado.getNomeUsuario());
            jlblQuantP.setText(usuarioVOLogado.getQuantPersonagensCriados() + "/" + usuarioVOLogado.getQuantPersonagensTotal() + " Personagens Criados");
            jtaDescricaoUsuario.setText(usuarioVOLogado.getDescricaoUsuario());
        }
        catch (SQLException | NoDataFoundException | IOException | IllegalArgumentException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro em GUIPrincipal.preencherPerfil: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limparPerfil() {
        usuarioVOLogado = null;
        jLabelImagem.setIcon(null);
        jLabelNomeUsuario.setText(null);
    }
    
    private void abrirGUIPersonagens() { 
        if(!flagGUIPersonagens) {
            GUIPersonagens guiP = new GUIPersonagens(usuarioVOLogado.getId());
            jdpPrincipal.add(guiP);
            guiP.setVisible(true);
            guiP.addInternalFrameListener(this);
            flagGUIPersonagens = true;
        }
    }
    private void abrirGUIFichas() {
        if(!flagGUIFichas) {
            GUIFichas guiF = new GUIFichas(usuarioVOLogado.getId());
            jdpPrincipal.add(guiF);
            guiF.setVisible(true);
            guiF.addInternalFrameListener(this);
            flagGUIFichas = true;
        }
    }
    
    private void abrirGUIAdminUsuarios() {
        if(!flagGUIAdminUsuarios) {
            GUIAdminUsuarios guiAU = new GUIAdminUsuarios();
            jdpPrincipal.add(guiAU);
            guiAU.setVisible(true);
            guiAU.addInternalFrameListener(this);
            flagGUIAdminUsuarios = true;
        }
    }
    
    private void abrirGUIAdminPersonagens() {
        if(!flagGUIAdminPersonagens) {
            GUIAdminPersonagens guiAP = new GUIAdminPersonagens();
            jdpPrincipal.add(guiAP);
            guiAP.setVisible(true);
            guiAP.addInternalFrameListener(this);
            flagGUIAdminPersonagens = true;
        }
    }
    
    private void logoff() {
        limparPerfil();
        
        GUILogin guiL = new GUILogin();
        guiL.setVisible(true);
        
        setVisible(false);
        dispose();
    }
    
    private void encerrar() {
        limparPerfil();
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

        jPanelPerfil = new javax.swing.JPanel();
        jLabelImagem = new javax.swing.JLabel();
        jLabelNomeUsuario = new javax.swing.JLabel();
        jlblQuantP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricaoUsuario = new javax.swing.JTextArea();
        jpnlAcoes = new javax.swing.JPanel();
        jbtnCriarPersonagem = new javax.swing.JButton();
        jbtnCriarFicha = new javax.swing.JButton();
        jbtnInformacoesDnD = new javax.swing.JButton();
        jbtnEditarDadosPessoais = new javax.swing.JButton();
        jdpPrincipal = new javax.swing.JDesktopPane();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuPersonagens = new javax.swing.JMenu();
        jMenuItemPersonagens = new javax.swing.JMenuItem();
        jMenuItemFichas = new javax.swing.JMenuItem();
        jMenuAdmin = new javax.swing.JMenu();
        jMenuItemAdminUsuarios = new javax.swing.JMenuItem();
        jMenuItemAdminPersonagens = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuItemLogoff = new javax.swing.JMenuItem();
        jMenuItemEncerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        jPanelPerfil.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelImagem.setText("Imagem Usuário");

        jLabelNomeUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNomeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeUsuario.setText("Nome do Usuário");

        jlblQuantP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblQuantP.setText("QuantPCriados/QuantPTotal");

        jtaDescricaoUsuario.setEditable(false);
        jtaDescricaoUsuario.setColumns(20);
        jtaDescricaoUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtaDescricaoUsuario.setRows(5);
        jtaDescricaoUsuario.setText("Descrição do Usuário");
        jScrollPane1.setViewportView(jtaDescricaoUsuario);

        jpnlAcoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações Rápidas"));

        jbtnCriarPersonagem.setText("Criar Personagem");

        jbtnCriarFicha.setText("Criar Ficha");

        jbtnInformacoesDnD.setText("Informações sobre DnD");

        jbtnEditarDadosPessoais.setText("Editar Dados Pessoais");

        javax.swing.GroupLayout jpnlAcoesLayout = new javax.swing.GroupLayout(jpnlAcoes);
        jpnlAcoes.setLayout(jpnlAcoesLayout);
        jpnlAcoesLayout.setHorizontalGroup(
            jpnlAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlAcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnCriarPersonagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnCriarFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnlAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnInformacoesDnD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnEditarDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnlAcoesLayout.setVerticalGroup(
            jpnlAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlAcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCriarPersonagem)
                    .addComponent(jbtnInformacoesDnD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCriarFicha)
                    .addComponent(jbtnEditarDadosPessoais))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelPerfilLayout = new javax.swing.GroupLayout(jPanelPerfil);
        jPanelPerfil.setLayout(jPanelPerfilLayout);
        jPanelPerfilLayout.setHorizontalGroup(
            jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlblQuantP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnlAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPerfilLayout.setVerticalGroup(
            jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jpnlAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabelNomeUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblQuantP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jdpPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jdpPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jdpPrincipalLayout = new javax.swing.GroupLayout(jdpPrincipal);
        jdpPrincipal.setLayout(jdpPrincipalLayout);
        jdpPrincipalLayout.setHorizontalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jdpPrincipalLayout.setVerticalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );

        jMenuPersonagens.setText("Personagens");

        jMenuItemPersonagens.setText("Criar/Editar Personagem");
        jMenuItemPersonagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPersonagensActionPerformed(evt);
            }
        });
        jMenuItemPersonagens.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuItemPersonagensKeyPressed(evt);
            }
        });
        jMenuPersonagens.add(jMenuItemPersonagens);

        jMenuItemFichas.setText("Criar/Editar Fichas");
        jMenuItemFichas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFichasActionPerformed(evt);
            }
        });
        jMenuItemFichas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuItemFichasKeyPressed(evt);
            }
        });
        jMenuPersonagens.add(jMenuItemFichas);

        jMenuBar.add(jMenuPersonagens);

        jMenuAdmin.setText("Administração");
        jMenuAdmin.setEnabled(false);

        jMenuItemAdminUsuarios.setText("Administrar Usuários");
        jMenuItemAdminUsuarios.setEnabled(false);
        jMenuItemAdminUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdminUsuariosActionPerformed(evt);
            }
        });
        jMenuItemAdminUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuItemAdminUsuariosKeyPressed(evt);
            }
        });
        jMenuAdmin.add(jMenuItemAdminUsuarios);

        jMenuItemAdminPersonagens.setText("Administrar Personagens");
        jMenuItemAdminPersonagens.setEnabled(false);
        jMenuItemAdminPersonagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdminPersonagensActionPerformed(evt);
            }
        });
        jMenuItemAdminPersonagens.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuItemAdminPersonagensKeyPressed(evt);
            }
        });
        jMenuAdmin.add(jMenuItemAdminPersonagens);

        jMenuBar.add(jMenuAdmin);

        jMenuSair.setText("Sair");

        jMenuItemLogoff.setText("Fazer Logoff");
        jMenuItemLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoffActionPerformed(evt);
            }
        });
        jMenuItemLogoff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuItemLogoffKeyPressed(evt);
            }
        });
        jMenuSair.add(jMenuItemLogoff);

        jMenuItemEncerrar.setText("Encerrar o Programa");
        jMenuItemEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEncerrarActionPerformed(evt);
            }
        });
        jMenuItemEncerrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuItemEncerrarKeyPressed(evt);
            }
        });
        jMenuSair.add(jMenuItemEncerrar);

        jMenuBar.add(jMenuSair);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdpPrincipal)
                    .addComponent(jPanelPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jdpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoffActionPerformed
        logoff();
    }//GEN-LAST:event_jMenuItemLogoffActionPerformed

    private void jMenuItemLogoffKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItemLogoffKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            logoff();
        }
    }//GEN-LAST:event_jMenuItemLogoffKeyPressed

    private void jMenuItemEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEncerrarActionPerformed
        encerrar();
    }//GEN-LAST:event_jMenuItemEncerrarActionPerformed

    private void jMenuItemEncerrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItemEncerrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            encerrar();
        }
    }//GEN-LAST:event_jMenuItemEncerrarKeyPressed

    private void jMenuItemPersonagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPersonagensActionPerformed
        abrirGUIPersonagens();
    }//GEN-LAST:event_jMenuItemPersonagensActionPerformed

    private void jMenuItemPersonagensKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItemPersonagensKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            abrirGUIPersonagens();
        }
    }//GEN-LAST:event_jMenuItemPersonagensKeyPressed

    private void jMenuItemFichasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFichasActionPerformed
        abrirGUIFichas();
    }//GEN-LAST:event_jMenuItemFichasActionPerformed

    private void jMenuItemFichasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItemFichasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            abrirGUIFichas();
        }
    }//GEN-LAST:event_jMenuItemFichasKeyPressed

    private void jMenuItemAdminUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdminUsuariosActionPerformed
        abrirGUIAdminPersonagens();
    }//GEN-LAST:event_jMenuItemAdminUsuariosActionPerformed

    private void jMenuItemAdminUsuariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItemAdminUsuariosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            abrirGUIAdminPersonagens();
        }
    }//GEN-LAST:event_jMenuItemAdminUsuariosKeyPressed

    private void jMenuItemAdminPersonagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdminPersonagensActionPerformed
        abrirGUIAdminUsuarios();
    }//GEN-LAST:event_jMenuItemAdminPersonagensActionPerformed

    private void jMenuItemAdminPersonagensKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItemAdminPersonagensKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            abrirGUIAdminUsuarios();
        }
    }//GEN-LAST:event_jMenuItemAdminPersonagensKeyPressed

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
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JLabel jLabelNomeUsuario;
    private javax.swing.JMenu jMenuAdmin;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemAdminPersonagens;
    private javax.swing.JMenuItem jMenuItemAdminUsuarios;
    private javax.swing.JMenuItem jMenuItemEncerrar;
    private javax.swing.JMenuItem jMenuItemFichas;
    private javax.swing.JMenuItem jMenuItemLogoff;
    private javax.swing.JMenuItem jMenuItemPersonagens;
    private javax.swing.JMenu jMenuPersonagens;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JPanel jPanelPerfil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCriarFicha;
    private javax.swing.JButton jbtnCriarPersonagem;
    private javax.swing.JButton jbtnEditarDadosPessoais;
    private javax.swing.JButton jbtnInformacoesDnD;
    private javax.swing.JDesktopPane jdpPrincipal;
    private javax.swing.JLabel jlblQuantP;
    private javax.swing.JPanel jpnlAcoes;
    private javax.swing.JTextArea jtaDescricaoUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void internalFrameOpened(InternalFrameEvent ife) {
        
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent ife) {

    }

    @Override
    public void internalFrameClosed(InternalFrameEvent ife) {
        JInternalFrame iFrame = ife.getInternalFrame();
        if(iFrame instanceof GUIPersonagens) {
            flagGUIPersonagens = false;
        }
        else if(iFrame instanceof GUIFichas) {
            flagGUIFichas = false;
        }
        else if(iFrame instanceof GUIAdminUsuarios) {
            flagGUIAdminUsuarios = false;
        }
        else if(iFrame instanceof GUIAdminPersonagens) {
            flagGUIAdminPersonagens = false;
        }
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent ife) {
        
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent ife) {
        
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent ife) {
        
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent ife) {
        
    }
}
