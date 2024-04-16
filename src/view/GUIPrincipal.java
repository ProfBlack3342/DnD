/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import modelo.UsuarioVO;

/**
 *
 * @author 181700271
 */
public class GUIPrincipal extends javax.swing.JFrame implements InternalFrameListener{

    private UsuarioVO usuarioVOLogado;
    private boolean flagGUILogin = false;
    /**
     * Creates new form GUIPrincipal
     */
    public GUIPrincipal() {
        initComponents();
        login();
    }
    
    private void login()
    {
        if(!flagGUILogin)
        {
            GUILogin gl = new GUILogin();
            jdpPrincipal.add(gl);
            gl.setVisible(true);
            flagGUILogin = true;
            gl.addInternalFrameListener(this);
        }
    }
    
    private void criarListaPersonagens()
    {
        
    }
    
    private void criarPersonagemNovo()
    {
        
    }
    
    private void abrirPersonagem()
    {
        
    }
    
    private void criarListaMesas()
    {
        
    }
    
    private void criarMesaNova()
    {
        
    }
    
    private void abrirMesa()
    {
        
    }
    
    private void habilitarAdmin()
    {
        
    }
    
    private void perfil()
    {
        
    }

    public UsuarioVO getUsuarioVOLogado() {
        return usuarioVOLogado;
    }
    public void setUsuarioVOLogado(UsuarioVO usuarioVOLogado) {
        this.usuarioVOLogado = usuarioVOLogado;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpPrincipal = new javax.swing.JDesktopPane();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuPersonagens = new javax.swing.JMenu();
        jMenuMesas = new javax.swing.JMenu();
        jMenuAdmin = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        jdpPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jdpPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jdpPrincipalLayout = new javax.swing.GroupLayout(jdpPrincipal);
        jdpPrincipal.setLayout(jdpPrincipalLayout);
        jdpPrincipalLayout.setHorizontalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
        );
        jdpPrincipalLayout.setVerticalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        jMenuPersonagens.setText("Personagens");
        jMenuBar.add(jMenuPersonagens);

        jMenuMesas.setText("Mesas");
        jMenuBar.add(jMenuMesas);

        jMenuAdmin.setText("Administração");
        jMenuBar.add(jMenuAdmin);

        jMenu1.setText("Perfil");
        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdpPrincipal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdpPrincipal)
                .addContainerGap())
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuAdmin;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuMesas;
    private javax.swing.JMenu jMenuPersonagens;
    private javax.swing.JDesktopPane jdpPrincipal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void internalFrameOpened(InternalFrameEvent ife) {
        
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent ife) {
        if(ife.getInternalFrame() instanceof GUILogin)
            usuarioVOLogado = ((GUILogin) ife.getInternalFrame()).getUsuarioVOLogado();
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent ife) {
        if(ife.getInternalFrame() instanceof GUILogin) {
                flagGUILogin = false;
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
