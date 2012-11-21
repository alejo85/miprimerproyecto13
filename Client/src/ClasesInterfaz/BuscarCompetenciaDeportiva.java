package ClasesInterfaz;


import ClasesGestores.CompetenciaGestor;

import ClasesLogicas.Competencia;
import ClasesLogicas.Usuario;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class BuscarCompetenciaDeportiva extends JDialog {
    private JButton aceptarJButton = new JButton();
    private JButton cancelarJButton = new JButton();
    private JPanel resultadoJPanel = new JPanel();
    private JScrollBar jScrollBar1 = new JScrollBar();
    private JButton nuevaCompetenciaJButton = new JButton();
    private JButton verCompetenciaJButton = new JButton();
    private JScrollBar jScrollBar2 = new JScrollBar();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JTable tablaResultadoJTable = new JTable();
    private JLabel jLabelModalidad = new JLabel();
    private JComboBox modalidadJComboBox = new JComboBox();
    private JPanel busqueadaJPanel = new JPanel();
    private JComboBox DeporteJComboBox = new JComboBox();
    private JLabel jLabelDeporte = new JLabel();
    private JTextArea nombreCompetenciaJTextArea = new JTextArea();
    private JLabel jLabelNombreDeLaCompetencia = new JLabel();
    private JComboBox estadoJComboBox = new JComboBox();
    private JLabel jLabelEstado = new JLabel();
    private JButton buscarJButton = new JButton();
    private Usuario usuarioActual= null;
    private Competencia competenciaSelecionad=null;
    private Frame parent;
    

    public BuscarCompetenciaDeportiva(Frame parent, Usuario usuariologueado) {
        
        this(parent, "", false,usuariologueado);
        
        
    }

    public BuscarCompetenciaDeportiva(Frame parent, String title, boolean modal,Usuario usuariologueado) {
        super(parent, title, modal);
        try {
            this.usuarioActual=usuariologueado;
            
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(1065, 796));
        this.getContentPane().setLayout( null );
        this.setTitle("Buscar Competencia");
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(300, 690, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(595, 690, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonCancelar_actionPerformed(e);
                }
            });
        resultadoJPanel.setBounds(new Rectangle(65, 300, 910, 345));
        resultadoJPanel.setLayout(null);
        resultadoJPanel.setBorder(BorderFactory.createTitledBorder("Resultados"));
        jScrollBar1.setBounds(new Rectangle(870, 25, 15, 230));
        nuevaCompetenciaJButton.setText("Nueva Competencia");
        nuevaCompetenciaJButton.setBounds(new Rectangle(465, 290, 220, 30));
        nuevaCompetenciaJButton.setFont(new Font("Tahoma", 0, 13));
        nuevaCompetenciaJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar2_actionPerformed(e);
                }
            });
        verCompetenciaJButton.setText("Ver Competencia");
        verCompetenciaJButton.setBounds(new Rectangle(185, 290, 240, 30));
        verCompetenciaJButton.setFont(new Font("Tahoma", 0, 13));
        verCompetenciaJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar1_actionPerformed(e);
                }
            });
        jScrollBar2.setBounds(new Rectangle(870, 30, 15, 230));
        jScrollPane2.setBounds(new Rectangle(20, 30, 860, 230));
        jLabelModalidad.setText("Modalidad");
        jLabelModalidad.setBounds(new Rectangle(60, 115, 135, 25));
        jLabelModalidad.setFont(new Font("Tahoma", 0, 13));
        modalidadJComboBox.setBounds(new Rectangle(240, 115, 375, 30));
        modalidadJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        modalidadJComboBox.setMinimumSize(new Dimension(2, 18));
        modalidadJComboBox.setPreferredSize(new Dimension(2, 18));
        modalidadJComboBox.setSize(new Dimension(375, 30));
        busqueadaJPanel.setBounds(new Rectangle(75, 15, 900, 260));
        busqueadaJPanel.setLayout(null);
        busqueadaJPanel.setBorder(BorderFactory.createTitledBorder("Buscar por"));
        DeporteJComboBox.setBounds(new Rectangle(240, 70, 375, 30));
        DeporteJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        DeporteJComboBox.setMinimumSize(new Dimension(2, 18));
        DeporteJComboBox.setPreferredSize(new Dimension(2, 18));
        jLabelDeporte.setText("Deporte");
        jLabelDeporte.setBounds(new Rectangle(60, 70, 135, 25));
        jLabelDeporte.setFont(new Font("Tahoma", 0, 13));
        nombreCompetenciaJTextArea.setBounds(new Rectangle(240, 20, 375, 30));
        nombreCompetenciaJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreCompetenciaJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelNombreDeLaCompetencia.setText("Nombre De La Competencia");
        jLabelNombreDeLaCompetencia.setBounds(new Rectangle(60, 15, 175, 25));
        jLabelNombreDeLaCompetencia.setFont(new Font("Tahoma", 0, 13));
        estadoJComboBox.setBounds(new Rectangle(240, 160, 250, 30));
        estadoJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        estadoJComboBox.setMinimumSize(new Dimension(2, 18));
        estadoJComboBox.setPreferredSize(new Dimension(2, 18));
        estadoJComboBox.setSize(new Dimension(375, 30));
        jLabelEstado.setText("Estado");
        jLabelEstado.setBounds(new Rectangle(60, 160, 135, 25));
        jLabelEstado.setFont(new Font("Tahoma", 0, 13));
        buscarJButton.setText("Buscar");
        buscarJButton.setBounds(new Rectangle(715, 70, 110, 30));
        buscarJButton.setFont(new Font("Tahoma", 0, 13));
        buscarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buscarJButton_actionPerformed(e);
                }
            });
        resultadoJPanel.add(jScrollBar1, null);
        resultadoJPanel.add(verCompetenciaJButton, null);
        resultadoJPanel.add(nuevaCompetenciaJButton, null);
        resultadoJPanel.add(jScrollBar2, null);
        jScrollPane2.getViewport().add(tablaResultadoJTable, null);
        resultadoJPanel.add(jScrollPane2, null);
        resultadoJPanel.add(nuevaCompetenciaJButton, null);
        resultadoJPanel.add(verCompetenciaJButton, null);
        busqueadaJPanel.add(modalidadJComboBox, null);
        busqueadaJPanel.add(jLabelModalidad, null);
        busqueadaJPanel.add(DeporteJComboBox, null);
        busqueadaJPanel.add(jLabelDeporte, null);
        busqueadaJPanel.add(nombreCompetenciaJTextArea, null);
        busqueadaJPanel.add(jLabelNombreDeLaCompetencia, null);
        busqueadaJPanel.add(estadoJComboBox, null);
        busqueadaJPanel.add(jLabelEstado, null);
        busqueadaJPanel.add(buscarJButton, null);
        this.getContentPane().add(busqueadaJPanel, null);
        this.getContentPane().add(resultadoJPanel, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(aceptarJButton, null);
       
    }

    private void jButtonCancelar_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        this.getParent().setVisible(true);
    }

    private void jButtonAceptar1_actionPerformed(ActionEvent e) {
        competenciaSelecionad = CompetenciaGestor.buscarCompetencia(tablaResultadoJTable.getSelectedRow());
        VerCompetencia ven = new VerCompetencia( usuarioActual, competenciaSelecionad);
        ven.setVisible(true);
    }

    private void jButtonAceptar2_actionPerformed(ActionEvent e) {
        AltaCompetenciaDeportiva ven = new AltaCompetenciaDeportiva(usuarioActual);
        
        ven.setVisible(true);
    }

    private void buscarJButton_actionPerformed(ActionEvent e) {
        String  resultado[][] = CompetenciaGestor.buscarCompetencias(this.nombreCompetenciaJTextArea.getText(), this.DeporteJComboBox.getSelectedItem().toString(), modalidadJComboBox.getSelectedItem().toString(), this.estadoJComboBox.getSelectedItem().toString());
        //todo cargar en la interfaz codigo de robert
        
    }
}
