package ClasesInterfaz;


import ClasesGestores.CompetenciaGestor;

import ClasesGestores.DeporteGestor;

import ClasesLogicas.Competencia;
import ClasesLogicas.Deporte;
import ClasesLogicas.Usuario;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

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
    private  Vector <Deporte> deporte;
    

    public BuscarCompetenciaDeportiva(Usuario usuariologueado) {
        
        this(null, "", false,usuariologueado);
        
        
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
       
        //TITULO VENTANA
        this.setTitle("Buscar Competencia");
        
        //BOTON ACEPTAR
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(300, 690, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 15));
        
        //BOTON CANCELAR
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(595, 690, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 15));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonCancelar_actionPerformed(e);
                }
            });
        
        // JPANEL BUSQUEDA POR
        busqueadaJPanel.setBounds(new Rectangle(15, 15, 750, 200));
        busqueadaJPanel.setLayout(null);
        Color borde= new Color(40,40,40);
        busqueadaJPanel.setBorder(BorderFactory.createLineBorder(borde,2));
        
        // ELEMENTOS DEL JPANEL BUSCAR POR
        
        // 1 . NOMBRE DE LA COMPETENCIA
        jLabelNombreDeLaCompetencia.setText("Nombre De La Competencia");
        jLabelNombreDeLaCompetencia.setBounds(new Rectangle(15, 20, 205, 25));
        jLabelNombreDeLaCompetencia.setFont(new Font("Tahoma", 0, 15));
        nombreCompetenciaJTextArea.setBounds(new Rectangle(210, 20, 375, 30));
        nombreCompetenciaJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreCompetenciaJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        
        // 2. DEPORTES
        jLabelDeporte.setText("Deporte");
        jLabelDeporte.setBounds(new Rectangle(15, 70, 135, 25));
        jLabelDeporte.setFont(new Font("Tahoma", 0, 15));
        DeporteJComboBox.setBounds(new Rectangle(75, 70, 175, 30));
        DeporteJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        DeporteJComboBox.setMinimumSize(new Dimension(2, 18));
        DeporteJComboBox.setPreferredSize(new Dimension(2, 18));
        DeporteJComboBox.setFont(new Font("Tahoma", 0, 15));
        listarDeportes();
        // 3. MODALIDAD
        jLabelModalidad.setText("Modalidad");
        jLabelModalidad.setBounds(new Rectangle(257, 70, 135, 25));
        jLabelModalidad.setFont(new Font("Tahoma", 0, 15));
        modalidadJComboBox.setBounds(new Rectangle(330, 70, 145, 30));
        modalidadJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        modalidadJComboBox.setMinimumSize(new Dimension(2, 18));
        modalidadJComboBox.setPreferredSize(new Dimension(2, 18));
        modalidadJComboBox.addItem("Liga");
        modalidadJComboBox.addItem("Eliminación simple");
        modalidadJComboBox.addItem("Eliminación doble");
        modalidadJComboBox.setFont(new Font("Tahoma", 0, 15));
        
        // 4. ESTADO
        jLabelEstado.setText("Estado");
        jLabelEstado.setBounds(new Rectangle(480, 70, 135, 25));
        jLabelEstado.setFont(new Font("Tahoma", 0, 15));
        estadoJComboBox.setBounds(new Rectangle(530, 70, 145, 30));
        estadoJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        estadoJComboBox.setMinimumSize(new Dimension(2, 18));
        estadoJComboBox.setPreferredSize(new Dimension(2, 18));
        estadoJComboBox.addItem("Creada");
        estadoJComboBox.addItem("Planificada");
        estadoJComboBox.addItem("En disputa");
        estadoJComboBox.addItem("Finalizada");
        estadoJComboBox.setFont(new Font("Tahoma", 0, 15));
        
        // 5. BOTON BUSCAR
        buscarJButton.setText("Buscar");
        buscarJButton.setBounds(new Rectangle(250, 130, 110, 40));
        buscarJButton.setFont(new Font("Tahoma", 0, 15));
        buscarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buscarJButton_actionPerformed(e);
                }
            });
        // TERMINA JPANEL BUSCAR POR
        
        // JPANEL RESULTADOS
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
    // CARGAR DEPORTES
    private void listarDeportes() {
        deporte = DeporteGestor.instanciarDeportes();
        for(int i=0; i<deporte.size();i++){
        DeporteJComboBox.addItem(deporte.get(i).getNombre());
        }
    }

    private void jButtonCancelar_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    private void jButtonAceptar1_actionPerformed(ActionEvent e) {
        competenciaSelecionad = CompetenciaGestor.buscarCompetencia(tablaResultadoJTable.getSelectedRow());
        VerCompetencia ven = new VerCompetencia(usuarioActual, competenciaSelecionad);
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
