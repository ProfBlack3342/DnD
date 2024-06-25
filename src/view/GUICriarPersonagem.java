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
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JComboBox;
import modelo.BackgroundVO;
import modelo.ClasseVO;
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
        jcbBackgrounds.addItemListener(this);
        jcbClasses.addItemListener(this);
        jcbSubclasses.addItemListener(this);
        jcbRacas.addItemListener(this);
        jcbSubracas.addItemListener(this);
        
        limparComboBoxes();
        limparTexto();
        carregarBackgrounds();
        carregarClasses();
        carregarRacas();
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
            
        }
    }
    
    private void carregarSubclasses()
    {
        int indiceComboboxClasse = jcbClasses.getSelectedIndex();
        
        if(indiceComboboxClasse != -1)
        {
            try
            {
                subclasses = ServicosFactory.getSubClasseServicos().listarSubClassesDeClasse(classes[indiceComboboxClasse].getId());
            }
            catch(NoDataFoundException | SQLException e)
            {
                
            }
        }
        else
        {
            //Nenhuma selecionada
        }
        
    }
    
    private void carregarSubracas()
    {
        int indiceComboboxRaca = jcbRacas.getSelectedIndex();
        
        if(indiceComboboxRaca != -1)
        {
            try
            {
                subRacas = ServicosFactory.getSubRacaServicos().listarSubRacasDeRaca(racas[indiceComboboxRaca].getId());
            }
            catch(NoDataFoundException | SQLException e)
            {
                
            }
        }
        else
        {
            //Nenhuma selecionada
        }
        
    }
    
    private void tentarCriarPersonagem()
    {
        int idBackground = backgrounds[jcbBackgrounds.getSelectedIndex()].getId();
        int idClasse = classes[jcbClasses.getSelectedIndex()].getId();
        int idRaca = racas[jcbRacas.getSelectedIndex()].getId();
        int idSubclasse = subclasses[jcbSubclasses.getSelectedIndex()].getId();
        int idSubraca = subRacas[jcbRacas.getSelectedIndex()].getId();
        
        PersonagemVO pVO = new PersonagemVO(
                0,
                new Date(System.currentTimeMillis()),
                usuarioLogado.getId(),
                1,
                idClasse,
                idSubclasse,
                idRaca,
                idSubraca,
                idBackground,
                TITLE_PROPERTY,
                IS_ICON_PROPERTY
        );
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
        jPanelSelecaoSubclasse = new javax.swing.JPanel();
        jcbSubclasses = new javax.swing.JComboBox<>();
        jScrollPaneSubclasse = new javax.swing.JScrollPane();
        jTextAreaSubclasse = new javax.swing.JTextArea();
        jPanelRaca = new javax.swing.JPanel();
        jPanelSelecaoRaca = new javax.swing.JPanel();
        jcbRacas = new javax.swing.JComboBox<>();
        jScrollPaneRaca = new javax.swing.JScrollPane();
        jTextAreaRacas = new javax.swing.JTextArea();
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

        jPanelSelecaoClasse.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Classe"));

        jcbClasses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Classe" }));

        jTextAreaClasse.setEditable(false);
        jTextAreaClasse.setColumns(20);
        jTextAreaClasse.setRows(5);
        jScrollPaneClasse.setViewportView(jTextAreaClasse);

        javax.swing.GroupLayout jPanelSelecaoClasseLayout = new javax.swing.GroupLayout(jPanelSelecaoClasse);
        jPanelSelecaoClasse.setLayout(jPanelSelecaoClasseLayout);
        jPanelSelecaoClasseLayout.setHorizontalGroup(
            jPanelSelecaoClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoClasseLayout.createSequentialGroup()
                .addComponent(jcbClasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPaneClasse, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
        );
        jPanelSelecaoClasseLayout.setVerticalGroup(
            jPanelSelecaoClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoClasseLayout.createSequentialGroup()
                .addComponent(jcbClasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneClasse, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
        );

        jPanelSelecaoSubclasse.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "SubClasse"));

        jcbSubclasses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextAreaSubclasse.setEditable(false);
        jTextAreaSubclasse.setColumns(20);
        jTextAreaSubclasse.setRows(5);
        jScrollPaneSubclasse.setViewportView(jTextAreaSubclasse);

        javax.swing.GroupLayout jPanelSelecaoSubclasseLayout = new javax.swing.GroupLayout(jPanelSelecaoSubclasse);
        jPanelSelecaoSubclasse.setLayout(jPanelSelecaoSubclasseLayout);
        jPanelSelecaoSubclasseLayout.setHorizontalGroup(
            jPanelSelecaoSubclasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoSubclasseLayout.createSequentialGroup()
                .addComponent(jcbSubclasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPaneSubclasse)
        );
        jPanelSelecaoSubclasseLayout.setVerticalGroup(
            jPanelSelecaoSubclasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoSubclasseLayout.createSequentialGroup()
                .addComponent(jcbSubclasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSubclasse, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
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

        jPanelSelecaoRaca.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Raça"));

        jcbRacas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Raça" }));

        jTextAreaRacas.setEditable(false);
        jTextAreaRacas.setColumns(20);
        jTextAreaRacas.setRows(5);
        jScrollPaneRaca.setViewportView(jTextAreaRacas);

        javax.swing.GroupLayout jPanelSelecaoRacaLayout = new javax.swing.GroupLayout(jPanelSelecaoRaca);
        jPanelSelecaoRaca.setLayout(jPanelSelecaoRacaLayout);
        jPanelSelecaoRacaLayout.setHorizontalGroup(
            jPanelSelecaoRacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoRacaLayout.createSequentialGroup()
                .addComponent(jcbRacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPaneRaca, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
        );
        jPanelSelecaoRacaLayout.setVerticalGroup(
            jPanelSelecaoRacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelecaoRacaLayout.createSequentialGroup()
                .addComponent(jcbRacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneRaca, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
        );

        jPanelSelecaoSubraca.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "SubRaça"));

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

        jPanelSelecaoBackground.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Background"));

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

        jPanelPreenchimentoBackstory.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Backstory"));

        javax.swing.GroupLayout jPanelPreenchimentoBackstoryLayout = new javax.swing.GroupLayout(jPanelPreenchimentoBackstory);
        jPanelPreenchimentoBackstory.setLayout(jPanelPreenchimentoBackstoryLayout);
        jPanelPreenchimentoBackstoryLayout.setHorizontalGroup(
            jPanelPreenchimentoBackstoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
        );
        jPanelPreenchimentoBackstoryLayout.setVerticalGroup(
            jPanelPreenchimentoBackstoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
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

        jTabbedPane1.addTab("Backstory", jPanelBackstory);

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
            .addComponent(jTabbedPane1)
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnSairActionPerformed

    private void jbtnSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnSairKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }
    }//GEN-LAST:event_jbtnSairKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
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
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent ie) {
        JComboBox jc = (JComboBox) ie.getSource();
        
        if(ie.getStateChange() == ItemEvent.SELECTED)
        {
            if(jc == jcbClasses)
            {
                jTextAreaClasse.setText(classes[jcbClasses.getSelectedIndex()].getDescricao());
                carregarSubclasses();
            }
            else if(jc == jcbRacas)
            {
                jTextAreaRacas.setText(racas[jcbRacas.getSelectedIndex()].getDescricao());
                carregarSubracas();
            }
            else if(jc == jcbBackgrounds)
            {
                jTextAreaBackground.setText(backgrounds[jcbBackgrounds.getSelectedIndex()].getDescricao());
            }
            else if(jc == jcbSubclasses)
            {
                jTextAreaSubclasse.setText(subclasses[jcbSubclasses.getSelectedIndex()].getDescricao());
            }
            else if(jc == jcbSubracas)
            {
                jTextAreaSubRacas.setText(subRacas[jcbSubracas.getSelectedIndex()].getDescricao());
            }
        }
    }
}
