/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import exception.NoDataFoundException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioVO;
import servicos.ServicosFactory;
import utilidades.Converter;

/**
 *
 * @author 181700271
 */
public class GUIAdminUsuarios extends javax.swing.JInternalFrame implements ItemListener
{

    DefaultTableModel dtm = new DefaultTableModel(
                new Object[][]{},
            new Object[]{"ID", "ID Imagem", "ID Tipo", "Nome", "Senha", "E-mail", "Data de Aniversário", "Descrição", "Data de Registro", "Ativo"}
    );
    
    UsuarioVO[] usuarios;
    
    /**
     * Creates new form GUIAdminUsuarios
     */
    public GUIAdminUsuarios() {
        initComponents();
        inicializar();
    }
    
    private void inicializar() {
        jcbAnoAniversario.addItemListener(this);
        jcbMesAniversario.addItemListener(this);
        jcbDiaAniversario.addItemListener(this);
        limparTabela();
        atualizarTabela();
    }
    
    private void montarComboBoxAno() {
        jcbAnoAniversario.removeAllItems();
        
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        
        for(int i = 0; i <= 120; i++) {
            jcbAnoAniversario.addItem(Integer.toString((anoAtual - 120 + i)));
        }
        
        jcbAnoAniversario.setSelectedIndex(-1);
    }
    private void montarComboBoxMes(int ano) {
        jcbMesAniversario.removeAllItems();
        
        int mesLimite;
        
        if(ano == Calendar.getInstance().get(Calendar.YEAR))
            mesLimite = Calendar.getInstance().get(Calendar.MONTH) + 1;
        else
            mesLimite = 12;
        
        for(int i = 1; i <= mesLimite; i++){
            jcbMesAniversario.addItem(Integer.toString(i));
        }
        
        jcbMesAniversario.setSelectedIndex(-1);
    }
    private void montarComboBoxDia(int mes, int ano) {
        jcbDiaAniversario.removeAllItems();
        
        int diasNoMes;
        
        if(mes <= 7)
        {
            if(mes % 2 == 0)
            {
                if(mes != 2)
                    diasNoMes = 30;
                else
                {
                    boolean bisexto;
                    if(ano % 4 == 0)
                        bisexto = (ano % 100) != 0;
                    else 
                        bisexto = (ano % 400) == 0;
                    
                    if(bisexto)
                        diasNoMes = 29;
                    else
                        diasNoMes = 28;
                }
            }
            else
                diasNoMes = 31;
        }
        else
        {
            if(mes % 2 == 0)
                diasNoMes = 31;
            else
                diasNoMes = 30;
        }
        
        Calendar data = Calendar.getInstance();
        if( (ano == data.get(Calendar.YEAR) ) && (mes == data.get(Calendar.MONTH) + 1) )
            diasNoMes = diasNoMes - (diasNoMes - data.get(Calendar.DAY_OF_MONTH));     //Ajustando para o usuário não selecionar uma data no futuro
        
        for(int i = 1; i <= diasNoMes; i++) {
            jcbDiaAniversario.addItem(Integer.toString(i));
        }
        
        jcbDiaAniversario.setSelectedIndex(-1);
    }
    
    private void limparCampos() {
        jtfIdUsuario.setText(null);
        jtfIdImagem.setText(null);
        jtfIdTipo.setText(null);
        jtfNome.setText(null);
        jtfSenha.setText(null);
        jtfEmail.setText(null);
        jtaDescricao.setText(null);
        jrbAtivo.setSelected(false);
        jcbDiaAniversario.removeAllItems();
        jcbDiaAniversario.setSelectedIndex(-1);
        jcbMesAniversario.removeAllItems();
        jcbMesAniversario.setSelectedIndex(-1);
        jcbAnoAniversario.removeAllItems();
        jcbAnoAniversario.setSelectedIndex(-1);
    }
    
    private void limparTabela() {
        dtm.setNumRows(0);
    }
    
    private void atualizarTabela() {
        try
        {
            usuarios = ServicosFactory.getUsuarioServicos().listarUsuarios();
            
            for(int i = 0; i < usuarios.length; i++)
            {
                
                String ativo;
                if(usuarios[i].isAtivo())
                    ativo = "Sim";
                else
                    ativo = "Não";
                
                String[] diaMesAnoNiver = Converter.converterSQLDateParaDiaMesAno(usuarios[i].getDataAniversarioUsuario());
                String[] diaMesAnoCriacao = Converter.converterSQLDateParaDiaMesAno(usuarios[i].getDataCriacao());
                
                dtm.addRow(new String[]{
                    String.valueOf(usuarios[i].getId()),
                    String.valueOf(usuarios[i].getIdImagem()),
                    String.valueOf(usuarios[i].getIdTipo()),
                    usuarios[i].getNomeUsuario(),
                    usuarios[i].getHashSenhaUsuario(),
                    usuarios[i].getEmailUsuario(),
                    diaMesAnoNiver[0] + "/" + diaMesAnoNiver[1] + "/" + diaMesAnoNiver[2],
                    usuarios[i].getDescricaoUsuario(),
                    diaMesAnoCriacao[0] + "/" + diaMesAnoCriacao[1] + "/" + diaMesAnoCriacao[2],
                    ativo
                });
            }
            
            jTableUsuarios.setModel(dtm);
        }
        catch (NoDataFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro em GUIAdminUsuarios.preencherTabela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void preencherCamposDados() {
        int linha = jTableUsuarios.getSelectedRow();
        if(linha != -1)
        {
            jtfIdUsuario.setText(String.valueOf(jTableUsuarios.getModel().getValueAt(linha, 0)));
            jtfIdImagem.setText(String.valueOf(jTableUsuarios.getModel().getValueAt(linha, 1)));
            jtfIdTipo.setText(String.valueOf(jTableUsuarios.getModel().getValueAt(linha, 2)));
            if(String.valueOf(jTableUsuarios.getModel().getValueAt(linha, 9)).toLowerCase().equals("sim"))
                jrbAtivo.setSelected(true);
            else
                jrbAtivo.setSelected(false);
            jtfNome.setText(String.valueOf(jTableUsuarios.getModel().getValueAt(linha, 3)));
            jtfSenha.setText(null);
            jtfEmail.setText(String.valueOf(jTableUsuarios.getModel().getValueAt(linha, 5)));
            
            String diaMesAnoNiver = String.valueOf(jTableUsuarios.getModel().getValueAt(linha, 6));
            int anoNiver = Integer.parseInt(diaMesAnoNiver.substring(6));
            int mesNiver = Integer.parseInt(diaMesAnoNiver.substring(3, 5));
            int diaNiver = Integer.parseInt(diaMesAnoNiver.substring(0, 2));
            
            montarComboBoxAno();
            jcbAnoAniversario.setSelectedItem(Integer.toString(anoNiver));
            montarComboBoxMes(anoNiver);
            jcbMesAniversario.setSelectedItem(Integer.toString(mesNiver));
            montarComboBoxDia(mesNiver, anoNiver);
            jcbDiaAniversario.setSelectedItem(Integer.toString(diaNiver));
            
            jtaDescricao.setText(String.valueOf(jTableUsuarios.getModel().getValueAt(linha, 7)));
        }
    }
    
    private void filtrarTabela() {
        String valorFiltro = jtfValorFiltro.getText();
        if(valorFiltro != null)
        {
            for (UsuarioVO usuario : usuarios)
            {
                String ativo;
                if(usuario.isAtivo())
                    ativo = "Sim";
                else
                    ativo = "Não";
                
                String[] diaMesAnoNiver = Converter.converterSQLDateParaDiaMesAno(usuario.getDataAniversarioUsuario());
                String[] diaMesAnoCriacao = Converter.converterSQLDateParaDiaMesAno(usuario.getDataCriacao());
                
                switch (jcbCampoFiltro.getSelectedIndex())
                {
                    case 0:
                        if (Integer.toString(usuario.getId()).equals(valorFiltro))
                        {
                            
                            dtm.addRow(new String[]{
                                String.valueOf(usuario.getId()),
                                String.valueOf(usuario.getIdImagem()),
                                String.valueOf(usuario.getIdTipo()),
                                usuario.getNomeUsuario(),
                                usuario.getHashSenhaUsuario(),
                                usuario.getEmailUsuario(),
                                diaMesAnoNiver[0] + "/" + diaMesAnoNiver[1] + "/" + diaMesAnoNiver[2],
                                usuario.getDescricaoUsuario(),
                                diaMesAnoCriacao[0] + "/" + diaMesAnoCriacao[1] + "/" + diaMesAnoCriacao[2],
                                ativo}
                            );
                        }
                        break;
                    case 1:
                        if (Integer.toString(usuario.getIdTipo()).equals(valorFiltro))
                        {
                            
                            dtm.addRow(new String[]{
                                String.valueOf(usuario.getId()),
                                String.valueOf(usuario.getIdImagem()),
                                String.valueOf(usuario.getIdTipo()),
                                usuario.getNomeUsuario(),
                                usuario.getHashSenhaUsuario(),
                                usuario.getEmailUsuario(),
                                diaMesAnoNiver[0] + "/" + diaMesAnoNiver[1] + "/" + diaMesAnoNiver[2],
                                usuario.getDescricaoUsuario(),
                                diaMesAnoCriacao[0] + "/" + diaMesAnoCriacao[1] + "/" + diaMesAnoCriacao[2],
                                ativo}
                            );
                        }
                        break;
                    case 2:
                        if (usuario.getNomeUsuario().equals(valorFiltro))
                        {
                            
                            dtm.addRow(new String[]{
                                String.valueOf(usuario.getId()),
                                String.valueOf(usuario.getIdImagem()),
                                String.valueOf(usuario.getIdTipo()),
                                usuario.getNomeUsuario(),
                                usuario.getHashSenhaUsuario(),
                                usuario.getEmailUsuario(),
                                diaMesAnoNiver[0] + "/" + diaMesAnoNiver[1] + "/" + diaMesAnoNiver[2],
                                usuario.getDescricaoUsuario(),
                                diaMesAnoCriacao[0] + "/" + diaMesAnoCriacao[1] + "/" + diaMesAnoCriacao[2],
                                ativo}
                            );
                        }
                        break;
                    case 3:
                        if (usuario.getEmailUsuario().equals(valorFiltro))
                        {
                            
                            dtm.addRow(new String[]{
                                String.valueOf(usuario.getId()),
                                String.valueOf(usuario.getIdImagem()),
                                String.valueOf(usuario.getIdTipo()),
                                usuario.getNomeUsuario(),
                                usuario.getHashSenhaUsuario(),
                                usuario.getEmailUsuario(),
                                diaMesAnoNiver[0] + "/" + diaMesAnoNiver[1] + "/" + diaMesAnoNiver[2],
                                usuario.getDescricaoUsuario(),
                                diaMesAnoCriacao[0] + "/" + diaMesAnoCriacao[1] + "/" + diaMesAnoCriacao[2],
                                ativo}
                            );
                        }
                        break;
                    default:
                        break;
                }
            }
            
            jTableUsuarios.setModel(dtm);
        }
        else
        {
            for (UsuarioVO usuario : usuarios)
            {
                String ativo;
                if(usuario.isAtivo())
                    ativo = "Sim";
                else
                    ativo = "Não";
                
                String[] diaMesAnoNiver = Converter.converterSQLDateParaDiaMesAno(usuario.getDataAniversarioUsuario());
                String[] diaMesAnoCriacao = Converter.converterSQLDateParaDiaMesAno(usuario.getDataCriacao());

                dtm.addRow(new String[]{
                    String.valueOf(usuario.getId()),
                    String.valueOf(usuario.getIdImagem()),
                    String.valueOf(usuario.getIdTipo()),
                    usuario.getNomeUsuario(),
                    usuario.getHashSenhaUsuario(),
                    usuario.getEmailUsuario(),
                    diaMesAnoNiver[0] + "/" + diaMesAnoNiver[1] + "/" + diaMesAnoNiver[2],
                    usuario.getDescricaoUsuario(),
                    diaMesAnoCriacao[0] + "/" + diaMesAnoCriacao[1] + "/" + diaMesAnoCriacao[2],
                    ativo}
                );
            }
        }
    }
    
    private boolean alterarUsuario() {
        boolean alterar = false;
        switch(JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja alterar esse usuário?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE))
        {
            case JOptionPane.YES_OPTION:
                alterar = true;
                break;
            case JOptionPane.NO_OPTION:
                alterar = false;
                break;
        }
        if(alterar)
        {
            boolean senha = false;
            if(!jtfSenha.getText().isEmpty())
            {
                UsuarioVO uVO = new UsuarioVO();
                uVO.setId(Integer.parseInt(jtfIdUsuario.getText()));
                uVO.setIdImagem(Integer.parseInt(jtfIdImagem.getText()));
                uVO.setIdTipo(Integer.parseInt(jtfIdTipo.getText()));
                uVO.setAtivo(jrbAtivo.isSelected());
                uVO.setNomeUsuario(jtfNome.getText());
                uVO.setHashSenhaUsuario(Converter.converterTextoParaHash(jtfSenha.getText()));
                uVO.setEmailUsuario(jtfEmail.getText());
                uVO.setDiaAniversarioUsuario(uVO.getDiaAniversarioUsuario());
                uVO.setDataAniversarioUsuario(Converter.converterDiaMesAnoParaSQLDate(
                        String.valueOf(jcbDiaAniversario.getSelectedItem()),
                        String.valueOf(jcbMesAniversario.getSelectedItem()),
                        String.valueOf(jcbAnoAniversario.getSelectedItem())
                ));

                uVO.setDescricaoUsuario(jtaDescricao.getText());

                try
                {
                    ServicosFactory.getUsuarioServicos().alterarUsuario(uVO);
                    return true;
                }
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null, "Erro em GUIAdminUsuarios.alterarUsuario: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                finally
                {
                    jbtnAlterar.setEnabled(false);
                    jbtnDeletar.setEnabled(false);
                    limparCampos();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Erro em GUIAdminUsuarios.alterarUsuario: Digite uma senha nova!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else
        {
            jbtnAlterar.setEnabled(false);
            jbtnDeletar.setEnabled(false);
            limparCampos();
            
            return false;
        }
    }
    
    private boolean deletarUsuario() {
        boolean deletar = false;
        switch(JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar esse usuário?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE))
        {
            case JOptionPane.YES_OPTION:
                deletar = true;
                break;
            case JOptionPane.NO_OPTION:
                deletar = false;
                break;
        }
        if(deletar)
        {
            try
            {
                UsuarioVO uVO = new UsuarioVO();
                uVO.setId(Integer.parseInt(jtfIdUsuario.getText()));
                ServicosFactory.getUsuarioServicos().excluirUsuario(uVO);
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro em GUIAdminUsuarios.alterarUsuario: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            finally
            {
                jbtnAlterar.setEnabled(false);
                jbtnDeletar.setEnabled(false);
                limparCampos();
            }
        }
        else
        {
            jbtnAlterar.setEnabled(false);
            jbtnDeletar.setEnabled(false);
            limparCampos();
            
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlFiltro = new javax.swing.JPanel();
        jlblFiltro = new javax.swing.JLabel();
        jtfValorFiltro = new javax.swing.JTextField();
        jlblFiltrar = new javax.swing.JLabel();
        jcbCampoFiltro = new javax.swing.JComboBox<>();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jPanelAcoes = new javax.swing.JPanel();
        jbtnAtualizar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jbtnAlterar = new javax.swing.JButton();
        jbtnDeletar = new javax.swing.JButton();
        jPanelDados = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfIdUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfIdImagem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfIdTipo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbDiaAniversario = new javax.swing.JComboBox<>();
        jcbMesAniversario = new javax.swing.JComboBox<>();
        jcbAnoAniversario = new javax.swing.JComboBox<>();
        jtfSenha = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jrbAtivo = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricao = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Administração de Usuários");

        jpnlFiltro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlblFiltro.setText("Valor para Filtrar:");

        jtfValorFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfValorFiltroKeyReleased(evt);
            }
        });

        jlblFiltrar.setText("Campo para Filtrar:");

        jcbCampoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "ID Tipo", "Nome", "E-mail" }));

        javax.swing.GroupLayout jpnlFiltroLayout = new javax.swing.GroupLayout(jpnlFiltro);
        jpnlFiltro.setLayout(jpnlFiltroLayout);
        jpnlFiltroLayout.setHorizontalGroup(
            jpnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFiltroLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jlblFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfValorFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(jlblFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbCampoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jpnlFiltroLayout.setVerticalGroup(
            jpnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblFiltro)
                    .addComponent(jtfValorFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCampoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblFiltrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPaneTabela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID Imagem", "ID Tipo", "Nome", "Senha", "E-mail", "Data de Aniversário", "Descrição", "Data de Registro", "Ativo"
            }
        ));
        jTableUsuarios.setToolTipText("");
        jTableUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuariosMouseClicked(evt);
            }
        });
        jScrollPaneTabela.setViewportView(jTableUsuarios);

        jPanelAcoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbtnAtualizar.setText("Atualizar");
        jbtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAtualizarActionPerformed(evt);
            }
        });
        jbtnAtualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnAtualizarKeyPressed(evt);
            }
        });

        jbtnLimpar.setText("Limpar");
        jbtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimparActionPerformed(evt);
            }
        });
        jbtnLimpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnLimparKeyPressed(evt);
            }
        });

        jbtnAlterar.setText("Alterar");
        jbtnAlterar.setEnabled(false);
        jbtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAlterarActionPerformed(evt);
            }
        });
        jbtnAlterar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnAlterarKeyPressed(evt);
            }
        });

        jbtnDeletar.setText("Deletar");
        jbtnDeletar.setEnabled(false);
        jbtnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeletarActionPerformed(evt);
            }
        });
        jbtnDeletar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnDeletarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAcoesLayout = new javax.swing.GroupLayout(jPanelAcoes);
        jPanelAcoes.setLayout(jPanelAcoesLayout);
        jPanelAcoesLayout.setHorizontalGroup(
            jPanelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAcoesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanelAcoesLayout.setVerticalGroup(
            jPanelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAcoesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("ID:");

        jtfIdUsuario.setEnabled(false);

        jLabel3.setText("ID Imagem:");

        jLabel4.setText("ID Tipo:");

        jLabel5.setText("Nome:");

        jLabel6.setText("Data de Aniversário:");

        jLabel7.setText("E-Mail:");

        jLabel8.setText("Senha:");

        jcbDiaAniversario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", " " }));

        jcbMesAniversario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês" }));

        jcbAnoAniversario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano" }));

        jrbAtivo.setText("Ativo");

        jLabel9.setText("Descrição:");

        jtaDescricao.setColumns(20);
        jtaDescricao.setRows(5);
        jScrollPane1.setViewportView(jtaDescricao);

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfIdTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfIdImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jtfIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jrbAtivo)
                                .addComponent(jLabel3))
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbDiaAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbMesAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbAnoAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfIdUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfIdImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfIdTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbDiaAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMesAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbAnoAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbAtivo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnlFiltro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfValorFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorFiltroKeyReleased
        limparTabela();
        filtrarTabela();
    }//GEN-LAST:event_jtfValorFiltroKeyReleased

    private void jbtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAtualizarActionPerformed
        limparTabela();
        atualizarTabela();
    }//GEN-LAST:event_jbtnAtualizarActionPerformed

    private void jbtnAtualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnAtualizarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            limparTabela();
            atualizarTabela();
        }
    }//GEN-LAST:event_jbtnAtualizarKeyPressed

    private void jbtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimparActionPerformed
        limparTabela();
    }//GEN-LAST:event_jbtnLimparActionPerformed

    private void jbtnLimparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnLimparKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            limparTabela();
        }
    }//GEN-LAST:event_jbtnLimparKeyPressed

    private void jbtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAlterarActionPerformed
        if(alterarUsuario())
        {
            limparTabela();
            atualizarTabela();
        }
    }//GEN-LAST:event_jbtnAlterarActionPerformed

    private void jbtnAlterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnAlterarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(alterarUsuario())
            {
                limparTabela();
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_jbtnAlterarKeyPressed

    private void jbtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeletarActionPerformed
        if(deletarUsuario())
        {
            limparTabela();
            atualizarTabela();
        }
    }//GEN-LAST:event_jbtnDeletarActionPerformed

    private void jbtnDeletarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnDeletarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(deletarUsuario())
            {
                limparTabela();
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_jbtnDeletarKeyPressed

    private void jTableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuariosMouseClicked
        preencherCamposDados();
        jbtnAlterar.setEnabled(true);
        jbtnDeletar.setEnabled(true);
    }//GEN-LAST:event_jTableUsuariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelAcoes;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JButton jbtnAlterar;
    private javax.swing.JButton jbtnAtualizar;
    private javax.swing.JButton jbtnDeletar;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JComboBox<String> jcbAnoAniversario;
    private javax.swing.JComboBox<String> jcbCampoFiltro;
    private javax.swing.JComboBox<String> jcbDiaAniversario;
    private javax.swing.JComboBox<String> jcbMesAniversario;
    private javax.swing.JLabel jlblFiltrar;
    private javax.swing.JLabel jlblFiltro;
    private javax.swing.JPanel jpnlFiltro;
    private javax.swing.JRadioButton jrbAtivo;
    private javax.swing.JTextArea jtaDescricao;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfIdImagem;
    private javax.swing.JTextField jtfIdTipo;
    private javax.swing.JTextField jtfIdUsuario;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfSenha;
    private javax.swing.JTextField jtfValorFiltro;
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent ie) {
        JComboBox jc = (JComboBox) ie.getSource();
        
        if(ie.getStateChange() == ItemEvent.SELECTED)
        {
            Object anoSelecionado = jcbAnoAniversario.getSelectedItem();
            Object mesSelecionado = jcbMesAniversario.getSelectedItem();
            
            if(jc == jcbAnoAniversario && anoSelecionado != null) {
                jcbMesAniversario.removeAllItems();
                montarComboBoxMes(Integer.parseInt(String.valueOf(anoSelecionado)));
                jcbDiaAniversario.removeAllItems();
                jcbDiaAniversario.setSelectedIndex(-1);
            }
            else if(jc == jcbMesAniversario && anoSelecionado != null && mesSelecionado != null) {
                jcbDiaAniversario.removeAllItems();
                    montarComboBoxDia(
                            Integer.parseInt(String.valueOf(mesSelecionado)),
                            Integer.parseInt(String.valueOf(anoSelecionado))
                    );
            }
        }
    }
}
