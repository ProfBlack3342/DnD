/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import exception.NoDataFoundException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Year;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.text.BadLocationException;
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
        carregarImagens();
    }
    
    private void carregarImagens()
    {
        try
        {
            String caminhoImagemLogin = "/img/logon.png";
            String caminhoImagemCadastro = "/img/cadastro.png";
            BufferedImage imagem;
            
            imagem = ImageIO.read(getClass().getResourceAsStream(caminhoImagemLogin));
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
    
    private void limpar()
    {
        jtfUsuarioLogin.setText(null);
        jpfSenhaLogin.setText(null);
    }
    
    private void montarComboBoxAnoAniversario()
    {
        int anoAtual = Year.now().getValue();
        String[] valoresAno = new String[120];
        
        for(int i = 0; i < 121; i++) {
            valoresAno[i] = Integer.toString((anoAtual - 120 + i));
        }
        
        jcbDiaAniversarioCadastro = new JComboBox<>(valoresAno);
        montarComboBoxMesAniversario();
    }
    
    private void montarComboBoxMesAniversario()
    {
        String[] valoresMes = new String[]{
            "01",
            "02",
            "03",
            "04",
            "05",
            "06",
            "07",
            "08",
            "09",
            "10",
            "11",
            "12",
        };

        jcbMesAniversarioCadastro = new JComboBox<>(valoresMes);
        montarComboBoxDiaAniversario();
    }
    
    private void montarComboBoxDiaAniversario()
    {
        String[] valoresDia;
        
        
        
        jcbAnoAniversarioCadastro = new JComboBox<>(valoresDia);
    }
    
    private void tentarLogin()
    {
        try
        {
            DadosLogin dadosLogin = new DadosLogin(jtfUsuarioLogin.getText(), new String(jpfSenhaLogin.getPassword()));
            limpar();
            
            UsuarioVO uVO = ServicosFactory.getUsuarioServicos().loginUsuario(dadosLogin);
            if(uVO == null)
                JOptionPane.showMessageDialog(null, "Erro: Usuário ou senha não correspondem a nenhum registrado", "Erro", JOptionPane.ERROR_MESSAGE);
            else
            {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                abrirGUIPrincipal(uVO);
            }
        }
        catch(NoDataFoundException | SQLException | NullPointerException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void tentarCadastro()
    {
        try
        {
            String nome = jtfNomeCadastro.getText();
            if(nome != null)
            {
                char[] senha1c = jpfSenhaCadastro1.getPassword();
                char[] senha2c = jpfSenhaCadastro2.getPassword();
                
                if(senha1c != null && senha2c != null && senha1c.length >= 1 && senha2c.length >= 1)
                {
                    String senha1 = new String(senha1c);
                    String senha2 = new String(senha2c);
                    
                    if(senha1.equals(senha2))
                    {
                        String email = jtfEmailCadastro.getText();
                        if(email != null)
                        {
                            Object diaAniversarioObj = jcbDiaAniversarioCadastro.getSelectedItem();
                            Object mesAniversarioObj = jcbMesAniversarioCadastro.getSelectedItem();
                            Object anoAniversarioObj = jcbAnoAniversarioCadastro.getSelectedItem();
                            if(diaAniversarioObj != null && mesAniversarioObj != null && anoAniversarioObj != null)
                            {
                                String diaAniversario = String.valueOf(diaAniversarioObj);
                                String mesAniversario = String.valueOf(mesAniversarioObj);
                                String anoAniversario = String.valueOf(anoAniversarioObj);

                                String descricao = jTextPaneDescricaoCadastro.getDocument().getText(0, jTextPaneDescricaoCadastro.getDocument().getLength());

                                if(descricao == null)
                                    descricao = "";
                                
                                UsuarioVO uVO =  new UsuarioVO(
                                        0,
                                        new Date(System.currentTimeMillis()),
                                        1,
                                        3,
                                        nome,
                                        senha1,
                                        email,
                                        Integer.parseInt(diaAniversario),
                                        Integer.parseInt(mesAniversario),
                                        Integer.parseInt(anoAniversario),
                                        descricao
                                );
                                
                                ServicosFactory.getUsuarioServicos().cadastrarUsuario(uVO);
                                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso! Realizando login...", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                                abrirGUIPrincipal(uVO);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Escolha uma data completa de aniversário...", "Erro", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Digite um e-mail...", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        jpfSenhaCadastro1.setText(null);
                        jpfSenhaCadastro2.setText(null);
                        JOptionPane.showMessageDialog(null, "As senhas não são iguais, tente novamente...", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Digite uma senha, em ambos os campos...", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Digite um nome...", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(BadLocationException | SQLException blE)
        {
            JOptionPane.showMessageDialog(null, blE.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
        jpnlImagemLogin = new javax.swing.JPanel();
        jlblImagemLogin = new javax.swing.JLabel();
        jpnlDadosLogin = new javax.swing.JPanel();
        jlblUsuarioLogin = new javax.swing.JLabel();
        jtfUsuarioLogin = new javax.swing.JTextField();
        jpfSenhaLogin = new javax.swing.JPasswordField();
        jlplSenhaLogin = new javax.swing.JLabel();
        jpnlAcoesLogin = new javax.swing.JPanel();
        jbntLogin = new javax.swing.JButton();
        jbtnSairLogin = new javax.swing.JButton();
        jpCadastro = new javax.swing.JPanel();
        jpnlImagemCadastroE = new javax.swing.JPanel();
        jlblImagemCadastroE = new javax.swing.JLabel();
        jpnlTituloCadastro = new javax.swing.JPanel();
        jlblTituloCadastro = new javax.swing.JLabel();
        jpnlImagemCadastroD = new javax.swing.JPanel();
        jlblImagemCadastroD = new javax.swing.JLabel();
        jpnlDadosCadastro = new javax.swing.JPanel();
        jlblNomeCadastro = new javax.swing.JLabel();
        jlblEmailCadastro = new javax.swing.JLabel();
        jtfNomeCadastro = new javax.swing.JTextField();
        jtfEmailCadastro = new javax.swing.JTextField();
        jlblSenhaCadastro1 = new javax.swing.JLabel();
        jpfSenhaCadastro1 = new javax.swing.JPasswordField();
        jpnlDataAniversarioCadastro = new javax.swing.JPanel();
        jlblAniversarioCadastro = new javax.swing.JLabel();
        jlblDiaAniversarioCadastro = new javax.swing.JLabel();
        jcbDiaAniversarioCadastro = new javax.swing.JComboBox<>();
        jlblMesAniversarioCadastro = new javax.swing.JLabel();
        jcbMesAniversarioCadastro = new javax.swing.JComboBox<>();
        jlblAnoAniversarioCadastro = new javax.swing.JLabel();
        jcbAnoAniversarioCadastro = new javax.swing.JComboBox<>();
        jlblbSenhaCadastro2 = new javax.swing.JLabel();
        jpfSenhaCadastro2 = new javax.swing.JPasswordField();
        jlblDescricaoCadastro = new javax.swing.JLabel();
        jScrollPaneDescricaoCadastro = new javax.swing.JScrollPane();
        jTextPaneDescricaoCadastro = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnlImagemLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jpnlImagemLoginLayout = new javax.swing.GroupLayout(jpnlImagemLogin);
        jpnlImagemLogin.setLayout(jpnlImagemLoginLayout);
        jpnlImagemLoginLayout.setHorizontalGroup(
            jpnlImagemLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblImagemLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );
        jpnlImagemLoginLayout.setVerticalGroup(
            jpnlImagemLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblImagemLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
        );

        jpnlDadosLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblUsuarioLogin.setText("Usuário:");

        jlplSenhaLogin.setText("Senha:");

        javax.swing.GroupLayout jpnlDadosLoginLayout = new javax.swing.GroupLayout(jpnlDadosLogin);
        jpnlDadosLogin.setLayout(jpnlDadosLoginLayout);
        jpnlDadosLoginLayout.setHorizontalGroup(
            jpnlDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDadosLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlplSenhaLogin)
                    .addComponent(jlblUsuarioLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfUsuarioLogin)
                    .addComponent(jpfSenhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlDadosLoginLayout.setVerticalGroup(
            jpnlDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDadosLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblUsuarioLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDadosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpfSenhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlplSenhaLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnlAcoesLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jpnlAcoesLoginLayout = new javax.swing.GroupLayout(jpnlAcoesLogin);
        jpnlAcoesLogin.setLayout(jpnlAcoesLoginLayout);
        jpnlAcoesLoginLayout.setHorizontalGroup(
            jpnlAcoesLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlAcoesLoginLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jbntLogin)
                .addGap(34, 34, 34)
                .addComponent(jbtnSairLogin)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jpnlAcoesLoginLayout.setVerticalGroup(
            jpnlAcoesLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlAcoesLoginLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jpnlAcoesLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbntLogin)
                    .addComponent(jbtnSairLogin))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpnlDadosLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginLayout.createSequentialGroup()
                                .addComponent(jpnlImagemLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))
                    .addComponent(jpnlAcoesLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlImagemLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnlDadosLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnlAcoesLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Login", jpLogin);

        jpnlImagemCadastroE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jpnlImagemCadastroELayout = new javax.swing.GroupLayout(jpnlImagemCadastroE);
        jpnlImagemCadastroE.setLayout(jpnlImagemCadastroELayout);
        jpnlImagemCadastroELayout.setHorizontalGroup(
            jpnlImagemCadastroELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblImagemCadastroE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpnlImagemCadastroELayout.setVerticalGroup(
            jpnlImagemCadastroELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblImagemCadastroE, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpnlTituloCadastro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlblTituloCadastro.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jlblTituloCadastro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTituloCadastro.setText("Informe seus dados para cadastro");

        javax.swing.GroupLayout jpnlTituloCadastroLayout = new javax.swing.GroupLayout(jpnlTituloCadastro);
        jpnlTituloCadastro.setLayout(jpnlTituloCadastroLayout);
        jpnlTituloCadastroLayout.setHorizontalGroup(
            jpnlTituloCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlTituloCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTituloCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlTituloCadastroLayout.setVerticalGroup(
            jpnlTituloCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblTituloCadastro)
        );

        jpnlImagemCadastroD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jpnlImagemCadastroDLayout = new javax.swing.GroupLayout(jpnlImagemCadastroD);
        jpnlImagemCadastroD.setLayout(jpnlImagemCadastroDLayout);
        jpnlImagemCadastroDLayout.setHorizontalGroup(
            jpnlImagemCadastroDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblImagemCadastroD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
        jpnlImagemCadastroDLayout.setVerticalGroup(
            jpnlImagemCadastroDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblImagemCadastroD, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jpnlDadosCadastro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblNomeCadastro.setText("Nome:");

        jlblEmailCadastro.setText("E-mail:");

        jlblSenhaCadastro1.setText("Senha:");

        jlblAniversarioCadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblAniversarioCadastro.setText("Data de Aniversário:");

        jlblDiaAniversarioCadastro.setText("Dia:");

        jcbDiaAniversarioCadastro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01" }));
        jcbDiaAniversarioCadastro.setEnabled(false);

        jlblMesAniversarioCadastro.setText("Mês:");

        jcbMesAniversarioCadastro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01" }));
        jcbMesAniversarioCadastro.setEnabled(false);

        jlblAnoAniversarioCadastro.setText("Ano:");

        jcbAnoAniversarioCadastro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1900" }));

        javax.swing.GroupLayout jpnlDataAniversarioCadastroLayout = new javax.swing.GroupLayout(jpnlDataAniversarioCadastro);
        jpnlDataAniversarioCadastro.setLayout(jpnlDataAniversarioCadastroLayout);
        jpnlDataAniversarioCadastroLayout.setHorizontalGroup(
            jpnlDataAniversarioCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlDataAniversarioCadastroLayout.createSequentialGroup()
                .addComponent(jlblAniversarioCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblDiaAniversarioCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDiaAniversarioCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblMesAniversarioCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMesAniversarioCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblAnoAniversarioCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbAnoAniversarioCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlDataAniversarioCadastroLayout.setVerticalGroup(
            jpnlDataAniversarioCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDataAniversarioCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jlblAniversarioCadastro)
                .addGroup(jpnlDataAniversarioCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblDiaAniversarioCadastro)
                    .addComponent(jcbDiaAniversarioCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblMesAniversarioCadastro)
                    .addComponent(jcbMesAniversarioCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblAnoAniversarioCadastro)
                    .addComponent(jcbAnoAniversarioCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jlblbSenhaCadastro2.setText("Confirme a sua Senha:");

        jlblDescricaoCadastro.setText("Descrição (Opcional):");

        jScrollPaneDescricaoCadastro.setViewportView(jTextPaneDescricaoCadastro);

        javax.swing.GroupLayout jpnlDadosCadastroLayout = new javax.swing.GroupLayout(jpnlDadosCadastro);
        jpnlDadosCadastro.setLayout(jpnlDadosCadastroLayout);
        jpnlDadosCadastroLayout.setHorizontalGroup(
            jpnlDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDadosCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnlDataAniversarioCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnlDadosCadastroLayout.createSequentialGroup()
                        .addComponent(jlblSenhaCadastro1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpfSenhaCadastro1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlblbSenhaCadastro2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpfSenhaCadastro2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlDadosCadastroLayout.createSequentialGroup()
                        .addComponent(jlblDescricaoCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneDescricaoCadastro))
                    .addGroup(jpnlDadosCadastroLayout.createSequentialGroup()
                        .addComponent(jlblNomeCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNomeCadastro))
                    .addGroup(jpnlDadosCadastroLayout.createSequentialGroup()
                        .addComponent(jlblEmailCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfEmailCadastro)))
                .addContainerGap())
        );
        jpnlDadosCadastroLayout.setVerticalGroup(
            jpnlDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDadosCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNomeCadastro)
                    .addComponent(jtfNomeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnlDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblEmailCadastro)
                    .addComponent(jtfEmailCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnlDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblSenhaCadastro1)
                    .addComponent(jpfSenhaCadastro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblbSenhaCadastro2)
                    .addComponent(jpfSenhaCadastro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jpnlDataAniversarioCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnlDadosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDadosCadastroLayout.createSequentialGroup()
                        .addComponent(jlblDescricaoCadastro)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPaneDescricaoCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpCadastroLayout = new javax.swing.GroupLayout(jpCadastro);
        jpCadastro.setLayout(jpCadastroLayout);
        jpCadastroLayout.setHorizontalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpnlDadosCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addComponent(jpnlImagemCadastroE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnlTituloCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnlImagemCadastroD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpCadastroLayout.setVerticalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroLayout.createSequentialGroup()
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpnlImagemCadastroD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnlImagemCadastroE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jpnlTituloCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jpnlDadosCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void jbtnSairLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSairLoginActionPerformed
        sair();
    }//GEN-LAST:event_jbtnSairLoginActionPerformed

    private void jbtnSairLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnSairLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            sair();
        }
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUILogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPaneDescricaoCadastro;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextPane jTextPaneDescricaoCadastro;
    private javax.swing.JButton jbntLogin;
    private javax.swing.JButton jbtnSairLogin;
    private javax.swing.JComboBox<String> jcbAnoAniversarioCadastro;
    private javax.swing.JComboBox<String> jcbDiaAniversarioCadastro;
    private javax.swing.JComboBox<String> jcbMesAniversarioCadastro;
    private javax.swing.JLabel jlblAniversarioCadastro;
    private javax.swing.JLabel jlblAnoAniversarioCadastro;
    private javax.swing.JLabel jlblDescricaoCadastro;
    private javax.swing.JLabel jlblDiaAniversarioCadastro;
    private javax.swing.JLabel jlblEmailCadastro;
    private javax.swing.JLabel jlblImagemCadastroD;
    private javax.swing.JLabel jlblImagemCadastroE;
    private javax.swing.JLabel jlblImagemLogin;
    private javax.swing.JLabel jlblMesAniversarioCadastro;
    private javax.swing.JLabel jlblNomeCadastro;
    private javax.swing.JLabel jlblSenhaCadastro1;
    private javax.swing.JLabel jlblTituloCadastro;
    private javax.swing.JLabel jlblUsuarioLogin;
    private javax.swing.JLabel jlblbSenhaCadastro2;
    private javax.swing.JLabel jlplSenhaLogin;
    private javax.swing.JPanel jpCadastro;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JPasswordField jpfSenhaCadastro1;
    private javax.swing.JPasswordField jpfSenhaCadastro2;
    private javax.swing.JPasswordField jpfSenhaLogin;
    private javax.swing.JPanel jpnlAcoesLogin;
    private javax.swing.JPanel jpnlDadosCadastro;
    private javax.swing.JPanel jpnlDadosLogin;
    private javax.swing.JPanel jpnlDataAniversarioCadastro;
    private javax.swing.JPanel jpnlImagemCadastroD;
    private javax.swing.JPanel jpnlImagemCadastroE;
    private javax.swing.JPanel jpnlImagemLogin;
    private javax.swing.JPanel jpnlTituloCadastro;
    private javax.swing.JTextField jtfEmailCadastro;
    private javax.swing.JTextField jtfNomeCadastro;
    private javax.swing.JTextField jtfUsuarioLogin;
    // End of variables declaration//GEN-END:variables
}
