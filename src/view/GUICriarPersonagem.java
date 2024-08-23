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
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.BackgroundVO;
import modelo.ClasseVO;
import modelo.ImagemClasseVO;
import modelo.ImagemRacaVO;
import modelo.ImagemSubClasseVO;
import modelo.PersonagemVO;
import modelo.RacaVO;
import modelo.SubClasseVO;
import modelo.SubRacaVO;
import modelo.UsuarioVO;
import servicos.ServicosFactory;

/**
 *
 * @author 181700271
 */
public class GUICriarPersonagem extends javax.swing.JInternalFrame implements ItemListener
{
    UsuarioVO usuarioLogado;
    
    BackgroundVO[] backgrounds;
    ClasseVO[] classes;
    RacaVO[] racas;
    
    SubClasseVO[] subclasses;
    SubRacaVO[] subRacas;
    
    /**
     * Creates new form GUICriarPersonagem
     * @param usuarioLogado
     */
    public GUICriarPersonagem(UsuarioVO usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        inicializar() ;
    }
    
    private void limparComboBoxes()
    {
        jcbBackgrounds.removeAllItems();
        jcbBackgrounds.setSelectedIndex(-1);
        
        jcbClasses.removeAllItems();
        jcbClasses.setSelectedIndex(-1);
        
        jcbSubclasses.removeAllItems();
        jcbSubclasses.setSelectedIndex(-1);
        
        jcbRacas.removeAllItems();
        jcbRacas.setSelectedIndex(-1);
        
        jcbSubracas.removeAllItems();
        jcbSubracas.setSelectedIndex(-1);
    }
    
    private void limparTexto()
    {
        jTextAreaBackground.setText(null);
        jTextAreaClasse.setText(null);
        jTextAreaRacas.setText(null);
        jTextAreaSubRacas.setText(null);
        jTextAreaSubclasse.setText(null);
    }
    
    private void inicializar() 
    {
        limparComboBoxes();
        limparTexto();
        
        carregarClasses();
        carregarRacas();
        carregarBackgrounds();
        
        jcbBackgrounds.addItemListener(this);
        jcbClasses.addItemListener(this);
        jcbSubclasses.addItemListener(this);
        jcbRacas.addItemListener(this);
        jcbSubracas.addItemListener(this);
    }
    
    private void carregarBackgrounds()
    {
        try
        {
            backgrounds = ServicosFactory.getBackgroundServicos().listarBackgrounds();
            for(BackgroundVO background : backgrounds) {
                jcbBackgrounds.addItem(background.getNome());
            }
        }
        catch(NoDataFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro em GUICriarPersonagem.carregarBackgrounds(): " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            backgrounds = new BackgroundVO[0];
        }
        finally
        {
            jcbBackgrounds.setSelectedIndex(-1);
        }
    }
    
    private void carregarClasses()
    {
        try
        {
            classes = ServicosFactory.getClasseServicos().listarClasses();
            
            for(ClasseVO classe : classes) {
                jcbClasses.addItem(classe.getNome());
            }
        }
        catch(NoDataFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro em GUICriarPersonagem.carregarClasses(): " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            classes = new ClasseVO[0];
        }
        finally
        {
            jcbClasses.setSelectedIndex(-1);
        }
    }
    
    private void carregarRacas()
    {
        try
        {
            racas = ServicosFactory.getRacaServicos().listarRacas();
            
            for(RacaVO raca : racas) {
                jcbRacas.addItem(raca.getNome());
            }
        }
        catch(NoDataFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro em GUICriarPersonagem.carregarRacas(): " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            racas = new RacaVO[0];
        }
        finally
        {
            jcbRacas.setSelectedIndex(-1);
        }
    }
    
    private void carregarSubclasses(int idClasse)
    {
        try
        {
            subclasses = ServicosFactory.getSubClasseServicos().listarSubClassesDeClasse(idClasse);

            for(SubClasseVO subClasse : subclasses) {
                jcbSubclasses.addItem(subClasse.getNome());
            }
        }
        catch(NoDataFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro em GUICriarPersonagem.carregarSubclasses(): " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            subclasses = new SubClasseVO[0];
        }
        finally
        {
            jcbSubclasses.setSelectedIndex(-1);
        }
    }
    
    private void carregarSubracas(int idRaca)
    {
        try
        {
            subRacas = ServicosFactory.getSubRacaServicos().listarSubRacasDeRaca(idRaca);

            for(SubRacaVO subRaca : subRacas) {
                jcbSubracas.addItem(subRaca.getNome());
            }
        }
        catch(NoDataFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro em GUICriarPersonagem.carregarSubracas(): " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            subRacas = new SubRacaVO[0];
        }
        finally
        {
            jcbSubracas.setSelectedIndex(-1);
        }
    }
    
    private void tentarCriarPersonagem()
    {
        Date data = new Date(System.currentTimeMillis());
        
        int idBackground = backgrounds[jcbBackgrounds.getSelectedIndex()].getId();
        int idClasse = classes[jcbClasses.getSelectedIndex()].getId();
        int idRaca = racas[jcbRacas.getSelectedIndex()].getId();
        int idSubclasse = subclasses[jcbSubclasses.getSelectedIndex()].getId();
        int idSubraca = subRacas[jcbRacas.getSelectedIndex()].getId();
        
        
        PersonagemVO pVO = new PersonagemVO();
        
        pVO.setIdUsuario(usuarioLogado.getId());
        pVO.setIdImagem(1);
        pVO.setIdClasse(idClasse);
        pVO.setIdSubclasse(idSubclasse);
        pVO.setIdRaca(idRaca);
        pVO.setIdSubraca(idSubraca);
        pVO.setIdBackground(idBackground);
        
        pVO.setValorSTRBase(ALLBITS);
        pVO.setValorDEXBase(idClasse);
        pVO.setValorCONBase(idSubclasse);
        pVO.setValorINTBase(ALLBITS);
        pVO.setValorWISBase(ALLBITS);
        pVO.setValorCHABase(idSubclasse);
        pVO.setNome(TITLE_PROPERTY);
        pVO.setAlinhamento(title);
        pVO.setIdade(idRaca);
        pVO.setAltura(ABORT);
        pVO.setPeso(ERROR);
        pVO.setOlhos(title);
        pVO.setPele(title);
        pVO.setCabelo(title);
        pVO.setAparencia(title);
        pVO.setHistoria(title);
        pVO.setPersonalidade(title);
        pVO.setIdeais(title);
        pVO.setLigacoes(title);
        pVO.setDefeitos(title);
        pVO.setAliados(title);
        pVO.setOutrasInformacoes(title);
        pVO.setQuantCobre(ABORT);
        pVO.setQuantPrata(idSubraca);
        pVO.setQuantElectrum(FRAMEBITS);
        pVO.setQuantOuro(ABORT);
        pVO.setQuantPlatina(PROPERTIES);
        
        pVO.setDataCriacao(data);
        pVO.setAtivo(true);
        
        try
        {
            ServicosFactory.getPersonagemServicos().cadastrarPersonagem(pVO);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelClasse = new javax.swing.JPanel();
        jPanelSelecaoClasse = new javax.swing.JPanel();
        jcbClasses = new javax.swing.JComboBox<>();
        jScrollPaneClasse = new javax.swing.JScrollPane();
        jTextAreaClasse = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jlblImagemClasse = new javax.swing.JLabel();
        jPanelSelecaoSubclasse = new javax.swing.JPanel();
        jcbSubclasses = new javax.swing.JComboBox<>();
        jScrollPaneSubclasse = new javax.swing.JScrollPane();
        jTextAreaSubclasse = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jlblImagemSubClasse = new javax.swing.JLabel();
        jPanelRaca = new javax.swing.JPanel();
        jPanelSelecaoRaca = new javax.swing.JPanel();
        jcbRacas = new javax.swing.JComboBox<>();
        jScrollPaneRaca = new javax.swing.JScrollPane();
        jTextAreaRacas = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jlblImagemRaça = new javax.swing.JLabel();
        jPanelSelecaoSubraca = new javax.swing.JPanel();
        jcbSubracas = new javax.swing.JComboBox<>();
        jScrollPaneSubraca = new javax.swing.JScrollPane();
        jTextAreaSubRacas = new javax.swing.JTextArea();
        jPanelBackground = new javax.swing.JPanel();
        jPanelSelecaoBackground = new javax.swing.JPanel();
        jcbBackgrounds = new javax.swing.JComboBox<>();
        jScrollPaneBackground = new javax.swing.JScrollPane();
        jTextAreaBackground = new javax.swing.JTextArea();
        jPanelBackstory = new javax.swing.JPanel();
        jPanelPreenchimentoBackstory = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jbtnCriarPersonagem = new javax.swing.JButton();
        jbtnSair = new javax.swing.JButton();
        jbtnCriarClasse = new javax.swing.JButton();
        jbtnCriarRaca = new javax.swing.JButton();
        jbtnCriarBackground = new javax.swing.JButton();

        jPanelSelecaoClasse.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Escolha uma Classe"));

        jcbClasses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Classe" }));

        jTextAreaClasse.setEditable(false);
        jTextAreaClasse.setColumns(20);
        jTextAreaClasse.setRows(5);
        jScrollPaneClasse.setViewportView(jTextAreaClasse);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlblImagemClasse.setText("imagem classe");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblImagemClasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblImagemClasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelSelecaoClasseLayout = new javax.swing.GroupLayout(jPanelSelecaoClasse);
        jPanelSelecaoClasse.setLayout(jPanelSelecaoClasseLayout);
        jPanelSelecaoClasseLayout.setHorizontalGroup(
            jPanelSelecaoClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoClasseLayout.createSequentialGroup()
                .addComponent(jcbClasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(634, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSelecaoClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelSelecaoClasseLayout.setVerticalGroup(
            jPanelSelecaoClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoClasseLayout.createSequentialGroup()
                .addComponent(jcbClasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSelecaoClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneClasse, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addGroup(jPanelSelecaoClasseLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanelSelecaoSubclasse.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Escolha uma SubClasse"));

        jcbSubclasses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subclasse" }));

        jTextAreaSubclasse.setEditable(false);
        jTextAreaSubclasse.setColumns(20);
        jTextAreaSubclasse.setRows(5);
        jScrollPaneSubclasse.setViewportView(jTextAreaSubclasse);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlblImagemSubClasse.setText("imagem subclasse");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblImagemSubClasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblImagemSubClasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelSelecaoSubclasseLayout = new javax.swing.GroupLayout(jPanelSelecaoSubclasse);
        jPanelSelecaoSubclasse.setLayout(jPanelSelecaoSubclasseLayout);
        jPanelSelecaoSubclasseLayout.setHorizontalGroup(
            jPanelSelecaoSubclasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoSubclasseLayout.createSequentialGroup()
                .addComponent(jcbSubclasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 623, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSelecaoSubclasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSubclasse, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelSelecaoSubclasseLayout.setVerticalGroup(
            jPanelSelecaoSubclasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoSubclasseLayout.createSequentialGroup()
                .addComponent(jcbSubclasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSelecaoSubclasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneSubclasse, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addGroup(jPanelSelecaoSubclasseLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanelClasseLayout = new javax.swing.GroupLayout(jPanelClasse);
        jPanelClasse.setLayout(jPanelClasseLayout);
        jPanelClasseLayout.setHorizontalGroup(
            jPanelClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSelecaoClasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSelecaoSubclasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelClasseLayout.setVerticalGroup(
            jPanelClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSelecaoClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSelecaoSubclasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Classe", jPanelClasse);

        jPanelSelecaoRaca.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Escolha uma Raça"));

        jcbRacas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Raça" }));

        jTextAreaRacas.setEditable(false);
        jTextAreaRacas.setColumns(20);
        jTextAreaRacas.setRows(5);
        jScrollPaneRaca.setViewportView(jTextAreaRacas);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlblImagemRaça.setText("imagem raça");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblImagemRaça, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblImagemRaça, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelSelecaoRacaLayout = new javax.swing.GroupLayout(jPanelSelecaoRaca);
        jPanelSelecaoRaca.setLayout(jPanelSelecaoRacaLayout);
        jPanelSelecaoRacaLayout.setHorizontalGroup(
            jPanelSelecaoRacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoRacaLayout.createSequentialGroup()
                .addComponent(jcbRacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 634, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSelecaoRacaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelSelecaoRacaLayout.setVerticalGroup(
            jPanelSelecaoRacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoRacaLayout.createSequentialGroup()
                .addComponent(jcbRacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSelecaoRacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneRaca, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addGroup(jPanelSelecaoRacaLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanelSelecaoSubraca.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Escolha uma SubRaça"));

        jcbSubracas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subraça" }));

        jTextAreaSubRacas.setEditable(false);
        jTextAreaSubRacas.setColumns(20);
        jTextAreaSubRacas.setRows(5);
        jScrollPaneSubraca.setViewportView(jTextAreaSubRacas);

        javax.swing.GroupLayout jPanelSelecaoSubracaLayout = new javax.swing.GroupLayout(jPanelSelecaoSubraca);
        jPanelSelecaoSubraca.setLayout(jPanelSelecaoSubracaLayout);
        jPanelSelecaoSubracaLayout.setHorizontalGroup(
            jPanelSelecaoSubracaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoSubracaLayout.createSequentialGroup()
                .addComponent(jcbSubracas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPaneSubraca)
        );
        jPanelSelecaoSubracaLayout.setVerticalGroup(
            jPanelSelecaoSubracaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoSubracaLayout.createSequentialGroup()
                .addComponent(jcbSubracas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSubraca, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelRacaLayout = new javax.swing.GroupLayout(jPanelRaca);
        jPanelRaca.setLayout(jPanelRacaLayout);
        jPanelRacaLayout.setHorizontalGroup(
            jPanelRacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRacaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSelecaoRaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSelecaoSubraca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelRacaLayout.setVerticalGroup(
            jPanelRacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRacaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSelecaoRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSelecaoSubraca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Raça", jPanelRaca);

        jPanelSelecaoBackground.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Escolha um Background"));

        jcbBackgrounds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Background" }));

        jTextAreaBackground.setEditable(false);
        jTextAreaBackground.setColumns(20);
        jTextAreaBackground.setRows(5);
        jScrollPaneBackground.setViewportView(jTextAreaBackground);

        javax.swing.GroupLayout jPanelSelecaoBackgroundLayout = new javax.swing.GroupLayout(jPanelSelecaoBackground);
        jPanelSelecaoBackground.setLayout(jPanelSelecaoBackgroundLayout);
        jPanelSelecaoBackgroundLayout.setHorizontalGroup(
            jPanelSelecaoBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoBackgroundLayout.createSequentialGroup()
                .addComponent(jcbBackgrounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPaneBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
        );
        jPanelSelecaoBackgroundLayout.setVerticalGroup(
            jPanelSelecaoBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoBackgroundLayout.createSequentialGroup()
                .addComponent(jcbBackgrounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelBackgroundLayout = new javax.swing.GroupLayout(jPanelBackground);
        jPanelBackground.setLayout(jPanelBackgroundLayout);
        jPanelBackgroundLayout.setHorizontalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSelecaoBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelBackgroundLayout.setVerticalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSelecaoBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Background", jPanelBackground);

        jPanelPreenchimentoBackstory.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelPreenchimentoBackstoryLayout = new javax.swing.GroupLayout(jPanelPreenchimentoBackstory);
        jPanelPreenchimentoBackstory.setLayout(jPanelPreenchimentoBackstoryLayout);
        jPanelPreenchimentoBackstoryLayout.setHorizontalGroup(
            jPanelPreenchimentoBackstoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );
        jPanelPreenchimentoBackstoryLayout.setVerticalGroup(
            jPanelPreenchimentoBackstoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelBackstoryLayout = new javax.swing.GroupLayout(jPanelBackstory);
        jPanelBackstory.setLayout(jPanelBackstoryLayout);
        jPanelBackstoryLayout.setHorizontalGroup(
            jPanelBackstoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackstoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPreenchimentoBackstory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelBackstoryLayout.setVerticalGroup(
            jPanelBackstoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackstoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPreenchimentoBackstory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Descrição", jPanelBackstory);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));

        jbtnCriarPersonagem.setText("Criar Personagem");
        jbtnCriarPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCriarPersonagemActionPerformed(evt);
            }
        });
        jbtnCriarPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnCriarPersonagemKeyPressed(evt);
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

        jbtnCriarClasse.setText("Criar Classe/Subclasse");
        jbtnCriarClasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCriarClasseActionPerformed(evt);
            }
        });
        jbtnCriarClasse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnCriarClasseKeyPressed(evt);
            }
        });

        jbtnCriarRaca.setText("Criar Raça/Subraça");
        jbtnCriarRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCriarRacaActionPerformed(evt);
            }
        });
        jbtnCriarRaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnCriarRacaKeyPressed(evt);
            }
        });

        jbtnCriarBackground.setText("Criar Background");
        jbtnCriarBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCriarBackgroundActionPerformed(evt);
            }
        });
        jbtnCriarBackground.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnCriarBackgroundKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnCriarPersonagem)
                .addGap(33, 33, 33)
                .addComponent(jbtnCriarClasse)
                .addGap(36, 36, 36)
                .addComponent(jbtnCriarRaca)
                .addGap(30, 30, 30)
                .addComponent(jbtnCriarBackground)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnSair)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCriarPersonagem)
                    .addComponent(jbtnSair)
                    .addComponent(jbtnCriarClasse)
                    .addComponent(jbtnCriarRaca)
                    .addComponent(jbtnCriarBackground))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCriarPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCriarPersonagemActionPerformed
        tentarCriarPersonagem();
        limparComboBoxes();
        limparTexto();
        
    }//GEN-LAST:event_jbtnCriarPersonagemActionPerformed

    private void jbtnCriarPersonagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnCriarPersonagemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tentarCriarPersonagem();
        }
    }//GEN-LAST:event_jbtnCriarPersonagemKeyPressed

    private void jbtnCriarClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCriarClasseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCriarClasseActionPerformed

    private void jbtnCriarClasseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnCriarClasseKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }
    }//GEN-LAST:event_jbtnCriarClasseKeyPressed

    private void jbtnCriarRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCriarRacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCriarRacaActionPerformed

    private void jbtnCriarRacaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnCriarRacaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }
    }//GEN-LAST:event_jbtnCriarRacaKeyPressed

    private void jbtnCriarBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCriarBackgroundActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCriarBackgroundActionPerformed

    private void jbtnCriarBackgroundKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnCriarBackgroundKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }
    }//GEN-LAST:event_jbtnCriarBackgroundKeyPressed

    private void jbtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSairActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnSairActionPerformed

    private void jbtnSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnSairKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dispose();
        }
    }//GEN-LAST:event_jbtnSairKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelBackstory;
    private javax.swing.JPanel jPanelClasse;
    private javax.swing.JPanel jPanelPreenchimentoBackstory;
    private javax.swing.JPanel jPanelRaca;
    private javax.swing.JPanel jPanelSelecaoBackground;
    private javax.swing.JPanel jPanelSelecaoClasse;
    private javax.swing.JPanel jPanelSelecaoRaca;
    private javax.swing.JPanel jPanelSelecaoSubclasse;
    private javax.swing.JPanel jPanelSelecaoSubraca;
    private javax.swing.JScrollPane jScrollPaneBackground;
    private javax.swing.JScrollPane jScrollPaneClasse;
    private javax.swing.JScrollPane jScrollPaneRaca;
    private javax.swing.JScrollPane jScrollPaneSubclasse;
    private javax.swing.JScrollPane jScrollPaneSubraca;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaBackground;
    private javax.swing.JTextArea jTextAreaClasse;
    private javax.swing.JTextArea jTextAreaRacas;
    private javax.swing.JTextArea jTextAreaSubRacas;
    private javax.swing.JTextArea jTextAreaSubclasse;
    private javax.swing.JButton jbtnCriarBackground;
    private javax.swing.JButton jbtnCriarClasse;
    private javax.swing.JButton jbtnCriarPersonagem;
    private javax.swing.JButton jbtnCriarRaca;
    private javax.swing.JButton jbtnSair;
    private javax.swing.JComboBox<String> jcbBackgrounds;
    private javax.swing.JComboBox<String> jcbClasses;
    private javax.swing.JComboBox<String> jcbRacas;
    private javax.swing.JComboBox<String> jcbSubclasses;
    private javax.swing.JComboBox<String> jcbSubracas;
    private javax.swing.JLabel jlblImagemClasse;
    private javax.swing.JLabel jlblImagemRaça;
    private javax.swing.JLabel jlblImagemSubClasse;
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if(ie.getStateChange() == ItemEvent.SELECTED)
        {
            JComboBox jcb = (JComboBox) ie.getSource();
            int indice = jcb.getSelectedIndex();
            
            if(indice != -1)
            {
                if(jcb == jcbClasses)
                {
                    jlblImagemClasse.setIcon(null);
                    jTextAreaClasse.setText(null);
                    
                    try
                    {
                        ImagemClasseVO imagemClasse = ServicosFactory.getImagemServicos().pesquisarImagemClasse(classes[indice].getIdImagem());
                        String caminhoImagem = imagemClasse.getCaminhoImagem();
                        BufferedImage imagemClasseBuff = ImageIO.read(getClass().getResourceAsStream(caminhoImagem));
                        
                        if(imagemClasseBuff != null)
                            jlblImagemClasse.setIcon(new ImageIcon(imagemClasseBuff));
                        else
                            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem da classe, usando default.", "Erro", JOptionPane.ERROR_MESSAGE);
                        
                    }
                    catch(SQLException | NoDataFoundException | IOException | IllegalArgumentException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Erro em carregar imagem da classe, usando default.\nDetalhes do erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    finally
                    {
                        jlblImagemClasse.setText(null);
                        jTextAreaClasse.setText(classes[indice].getDescricao());
                        carregarSubclasses(classes[indice].getId());
                    }
                }
                else if(jcb == jcbRacas)
                {
                    jlblImagemRaça.setIcon(null);
                    jTextAreaRacas.setText(null);
                    
                    try
                    {
                        ImagemRacaVO imagemRaca = ServicosFactory.getImagemServicos().pesquisarImagemRaca(racas[indice].getIdImagem());
                        String caminhoImagem = imagemRaca.getCaminhoImagem();
                        BufferedImage imagemRacaBuff = ImageIO.read(getClass().getResourceAsStream(caminhoImagem));
                        
                        if(imagemRacaBuff != null)
                        {
                            jlblImagemRaça.setIcon(new ImageIcon(imagemRacaBuff));
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem da classe, usando default.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                    catch(SQLException | NoDataFoundException | IOException | IllegalArgumentException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Erro em carregar imagem da classe, usando default.\nDetalhes do erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    finally
                    {
                        jlblImagemRaça.setText(null);
                        jTextAreaRacas.setText(racas[indice].getDescricao());
                        carregarSubracas(racas[indice].getId());
                    }
                }
                else if(jcb == jcbBackgrounds)
                {
                    jTextAreaBackground.setText(null);
                    jTextAreaBackground.setText(backgrounds[indice].getDescricao());
                }
                else if(jcb == jcbSubclasses)
                {
                    jlblImagemRaça.setIcon(null);
                    jTextAreaSubclasse.setText(null);
                    
                    try
                    {
                        ImagemSubClasseVO imagemSubClasse = ServicosFactory.getImagemServicos().pesquisarImagemSubClasse(subclasses[indice].getIdImagem());
                        String caminhoImagem = imagemSubClasse.getCaminhoImagem();
                        BufferedImage imagemSubClasseBuff = ImageIO.read(getClass().getResourceAsStream(caminhoImagem));
                        
                        if(imagemSubClasseBuff != null)
                        {
                            jlblImagemSubClasse.setIcon(new ImageIcon(imagemSubClasseBuff));
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem da subclasse, usando default.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                    catch(SQLException | NoDataFoundException | IOException | IllegalArgumentException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Erro em carregar imagem da subclasse, usando default.\nDetalhes do erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    finally
                    {
                        jlblImagemSubClasse.setText(null);
                        jTextAreaSubclasse.setText(subclasses[indice].getDescricao());
                    }
                }
                else if(jcb == jcbSubracas)
                {
                    jTextAreaSubRacas.setText(null);
                    jTextAreaSubRacas.setText(subRacas[indice].getDescricao());
                }
            }
        }
    }
}
