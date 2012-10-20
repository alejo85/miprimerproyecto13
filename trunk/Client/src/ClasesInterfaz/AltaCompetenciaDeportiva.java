package ClasesInterfaz;


import ClasesLogicas.Usuario;

import java.awt.BorderLayout;
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class AltaCompetenciaDeportiva extends JDialog {

   
  
  //  JPanel htmlPanel = new JPanel();
    private JTextArea nombreDeLaCompetenciaJTextArea = new JTextArea();
    private JLabel jLabelNombreDeLaCompetencia = new JLabel();
    private JLabel jLabelDeporte = new JLabel();
    private JComboBox deporteJComboBox = new JComboBox();
    private JLabel jLabelLugarDeRealizaci�n = new JLabel();
    private JLabel jLabelModalidad = new JLabel();
    private JComboBox modalidadJComboBox = new JComboBox();
    private JLabel jLabelReglamento = new JLabel();
    private JList lugarDeRealizaci�nJList = new JList();
    private JScrollBar jScrollBar1 = new JScrollBar();
    private JPanel modalidadLigaJPanel = new JPanel();
    private Usuario ussuarioActual=null;
    private BorderLayout borderLayout1 = new BorderLayout();
    private JLabel jLabelPuntosPorPartidoGanados = new JLabel();
    private JTextArea puntosPorPartidoGanadosJTextArea = new JTextArea();
    private JPanel jPanelEmpate = new JPanel();
    private JRadioButton empateSiJRadioButton = new JRadioButton();
    private JRadioButton empateNoJRadioButton = new JRadioButton();
    private JTextArea puntosPorPartidoEmpatadoJTextArea = new JTextArea();
    private JLabel jLabelPuntosPorPartidoEmpatado = new JLabel();
    private JTextArea puntosPorPartidoAsistidoJTextArea = new JTextArea();
    private JLabel jLabelPuntosPorPartidosAsistido = new JLabel();
    private JComboBox formaDePuntuaci�nJComboBox = new JComboBox();
    private JLabel jLabelFormaDePuntuaci�n = new JLabel();
    private JPanel jPanelFormaDePuntuaci�nSet = new JPanel();
    private JPanel formaDePuntuaci�nPuntuaci�nJPanel = new JPanel();
    private JLabel jLabelCantidadMaximaDeSets = new JLabel();
    private JTextArea cantidadMaximaDeSetsJTextArea = new JTextArea();
    private JTextArea tantosPorPartidosGanadosJTextArea = new JTextArea();
    private JLabel jLabelTantosPorPartidosGanados = new JLabel();
    private JButton aceptarJButton = new JButton();
    private JButton cancelarJButton = new JButton();
    private JButton quitarJButton = new JButton();
    private JTextArea disponibilidadJTextArea = new JTextArea();
    private JLabel jLabelDisponibilidad = new JLabel();
    private JTable tablaLugarDisponibilidadJTable = new JTable();
    private JButton agregarJButton = new JButton();
    private JScrollBar jScrollBar2 = new JScrollBar();
    private int tama�o=10;
    private String fuenteLetra;
    private JPanel editorReglamentoJPanel = new JPanel();

    public AltaCompetenciaDeportiva(Usuario usuarioLogueado) {

        this(null, "", false,usuarioLogueado);
    }

    public AltaCompetenciaDeportiva(Frame parent, String title, boolean modal,Usuario usuarioLogueado) {
        super(parent, title, modal);
        try {
            this.ussuarioActual=usuarioLogueado;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(1487, 765));
        this.getContentPane().setLayout( null );
        this.setTitle("Alta Competencia Deportiva");
        
        nombreDeLaCompetenciaJTextArea.setBounds(new Rectangle(235, 30, 375, 30));
        nombreDeLaCompetenciaJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreDeLaCompetenciaJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        nombreDeLaCompetenciaJTextArea.setNextFocusableComponent(deporteJComboBox);
        jLabelNombreDeLaCompetencia.setText("Nombre De La Competencia");
        jLabelNombreDeLaCompetencia.setBounds(new Rectangle(50, 25, 175, 25));
        jLabelNombreDeLaCompetencia.setFont(new Font("Tahoma", 0, 13));
        jLabelDeporte.setText("Deporte");
        jLabelDeporte.setBounds(new Rectangle(50, 70, 135, 25));
        jLabelDeporte.setFont(new Font("Tahoma", 0, 13));
        deporteJComboBox.setBounds(new Rectangle(235, 70, 240, 30));
        deporteJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        deporteJComboBox.setMinimumSize(new Dimension(2, 18));
        deporteJComboBox.setPreferredSize(new Dimension(2, 18));
        deporteJComboBox.setSize(new Dimension(250, 30));
        jLabelLugarDeRealizaci�n.setText("Lugar De Realizaci�n");
        jLabelLugarDeRealizaci�n.setBounds(new Rectangle(50, 115, 135, 25));
        jLabelLugarDeRealizaci�n.setFont(new Font("Tahoma", 0, 13));
        jLabelModalidad.setText("Modalidad");
        jLabelModalidad.setBounds(new Rectangle(45, 295, 135, 25));
        jLabelModalidad.setFont(new Font("Tahoma", 0, 13));
        modalidadJComboBox.setBounds(new Rectangle(225, 295, 375, 30));
        modalidadJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        modalidadJComboBox.setMinimumSize(new Dimension(2, 18));
        modalidadJComboBox.setPreferredSize(new Dimension(2, 18));
        modalidadJComboBox.setSize(new Dimension(375, 30));
       

        modalidadJComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    modalidadJComboBox_actionPerformed(e);
                }
            });
        modalidadJComboBox.addItem("Sistema de Eliminatoria Simple");
        modalidadJComboBox.addItem("Sistema de Eliminatoria Doble");
        modalidadJComboBox.addItem("Sistema de Liga");
        formaDePuntuaci�nJComboBox.addItem("Resultado Final");
        formaDePuntuaci�nJComboBox.addItem("Puntuaci�n");
        formaDePuntuaci�nJComboBox.addItem("Sets");
        jLabelReglamento.setText("Reglamento");
        jLabelReglamento.setBounds(new Rectangle(45, 340, 135, 25));
        jLabelReglamento.setFont(new Font("Tahoma", 0, 13));
        lugarDeRealizaci�nJList.setBounds(new Rectangle(235, 115, 240, 160));
        jScrollBar1.setBounds(new Rectangle(460, 115, 15, 160));
        modalidadLigaJPanel.setBounds(new Rectangle(950, 20, 495, 245));
        modalidadLigaJPanel.setBorder(BorderFactory.createTitledBorder("Modalidad Liga"));
        modalidadLigaJPanel.setLayout(null);
        jLabelPuntosPorPartidoGanados.setText("Puntos Por Partido Ganados");
        jLabelPuntosPorPartidoGanados.setBounds(new Rectangle(20, 25, 175, 25));
        jLabelPuntosPorPartidoGanados.setFont(new Font("Tahoma", 0, 13));
        puntosPorPartidoGanadosJTextArea.setBounds(new Rectangle(230, 25, 240, 30));
        puntosPorPartidoGanadosJTextArea.setFont(new Font("Tahoma", 0, 13));
        puntosPorPartidoGanadosJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        puntosPorPartidoGanadosJTextArea.setNextFocusableComponent(empateSiJRadioButton);
        jPanelEmpate.setBounds(new Rectangle(25, 60, 455, 95));
        jPanelEmpate.setLayout(null);
        jPanelEmpate.setBorder(BorderFactory.createTitledBorder("Empate"));
        empateSiJRadioButton.setText("Si");
        empateSiJRadioButton.setBounds(new Rectangle(25, 20, 85, 20));
        empateSiJRadioButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    empateSiJRadioButton_actionPerformed(e);
                }
            });
        empateNoJRadioButton.setText("No");
        empateNoJRadioButton.setBounds(new Rectangle(135, 20, 90, 20));
        empateNoJRadioButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    empateNoJRadioButton_actionPerformed(e);
                }
            });
        puntosPorPartidoEmpatadoJTextArea.setBounds(new Rectangle(205, 50, 240, 30));
        puntosPorPartidoEmpatadoJTextArea.setFont(new Font("Tahoma", 0, 13));
        puntosPorPartidoEmpatadoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelPuntosPorPartidoEmpatado.setText("Puntos Por Partido Empatados");
        jLabelPuntosPorPartidoEmpatado.setBounds(new Rectangle(20, 55, 175, 25));
        jLabelPuntosPorPartidoEmpatado.setFont(new Font("Tahoma", 0, 13));
        puntosPorPartidoAsistidoJTextArea.setBounds(new Rectangle(265, 165, 160, 30));
        puntosPorPartidoAsistidoJTextArea.setFont(new Font("Tahoma", 0, 13));
        puntosPorPartidoAsistidoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelPuntosPorPartidosAsistido.setText("Puntos Por Partido Asistido");
        jLabelPuntosPorPartidosAsistido.setBounds(new Rectangle(40, 165, 230, 25));
        jLabelPuntosPorPartidosAsistido.setFont(new Font("Tahoma", 0, 13));
        formaDePuntuaci�nJComboBox.setBounds(new Rectangle(1155, 295, 260, 30));
        formaDePuntuaci�nJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        formaDePuntuaci�nJComboBox.setMinimumSize(new Dimension(2, 18));
        formaDePuntuaci�nJComboBox.setPreferredSize(new Dimension(2, 18));
        formaDePuntuaci�nJComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    formaDePuntuaci�nJComboBox_actionPerformed(e);
                }
            });
        jLabelFormaDePuntuaci�n.setText("Forma de Puntuacion");
        jLabelFormaDePuntuaci�n.setBounds(new Rectangle(995, 295, 135, 25));
        jLabelFormaDePuntuaci�n.setFont(new Font("Tahoma", 0, 13));
        jPanelFormaDePuntuaci�nSet.setBounds(new Rectangle(950, 365, 475, 75));
        jPanelFormaDePuntuaci�nSet.setLayout(null);
        formaDePuntuaci�nPuntuaci�nJPanel.setBounds(new Rectangle(950, 440, 475, 75));
        formaDePuntuaci�nPuntuaci�nJPanel.setLayout(null);
        jPanelFormaDePuntuaci�nSet.setBorder(BorderFactory.createTitledBorder("Sets"));
        formaDePuntuaci�nPuntuaci�nJPanel.setBorder(BorderFactory.createTitledBorder("Puntuacion"));
        jLabelCantidadMaximaDeSets.setText("Cantidad Maxima De Sets");
        jLabelCantidadMaximaDeSets.setBounds(new Rectangle(20, 25, 165, 25));
        jLabelCantidadMaximaDeSets.setFont(new Font("Tahoma", 0, 13));
        cantidadMaximaDeSetsJTextArea.setBounds(new Rectangle(210, 20, 160, 30));
        cantidadMaximaDeSetsJTextArea.setFont(new Font("Tahoma", 0, 13));
        cantidadMaximaDeSetsJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tantosPorPartidosGanadosJTextArea.setBounds(new Rectangle(210, 25, 160, 25));
        tantosPorPartidosGanadosJTextArea.setFont(new Font("Tahoma", 0, 13));
        tantosPorPartidosGanadosJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelTantosPorPartidosGanados.setText("Tantos Por Partido Ganados");
        jLabelTantosPorPartidosGanados.setBounds(new Rectangle(20, 25, 160, 25));
        jLabelTantosPorPartidosGanados.setFont(new Font("Tahoma", 0, 13));
        jPanelEmpate.add(empateSiJRadioButton, null);
        jPanelEmpate.add(empateNoJRadioButton, null);
        jPanelEmpate.add(puntosPorPartidoEmpatadoJTextArea, null);
        jPanelEmpate.add(jLabelPuntosPorPartidoEmpatado, null);
        modalidadLigaJPanel.add(jPanelEmpate, null);
        modalidadLigaJPanel.add(puntosPorPartidoGanadosJTextArea, null);
        modalidadLigaJPanel.add(jLabelPuntosPorPartidoGanados, null);
        modalidadLigaJPanel.add(jLabelPuntosPorPartidosAsistido, null);
        modalidadLigaJPanel.add(puntosPorPartidoAsistidoJTextArea, null);
        modalidadLigaJPanel.setVisible(false);
        formaDePuntuaci�nPuntuaci�nJPanel.add(tantosPorPartidosGanadosJTextArea, null);
        formaDePuntuaci�nPuntuaci�nJPanel.add(jLabelTantosPorPartidosGanados, null);
        jPanelFormaDePuntuaci�nSet.add(cantidadMaximaDeSetsJTextArea, null);
        jPanelFormaDePuntuaci�nSet.add(jLabelCantidadMaximaDeSets, null);
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(490, 670, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(680, 670, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));

        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        quitarJButton.setText("Quitar");
        quitarJButton.setBounds(new Rectangle(500, 225, 110, 30));
        quitarJButton.setFont(new Font("Tahoma", 0, 13));
        disponibilidadJTextArea.setBounds(new Rectangle(500, 140, 110, 30));
        disponibilidadJTextArea.setFont(new Font("Tahoma", 0, 13));
        disponibilidadJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        disponibilidadJTextArea.setNextFocusableComponent(this);
        jLabelDisponibilidad.setText("Disponibilidad");
        jLabelDisponibilidad.setBounds(new Rectangle(500, 110, 110, 25));
        jLabelDisponibilidad.setFont(new Font("Tahoma", 0, 13));
        tablaLugarDisponibilidadJTable.setBounds(new Rectangle(635, 115, 265, 165));
        agregarJButton.setText("Agregar");
        agregarJButton.setBounds(new Rectangle(500, 185, 110, 30));
        agregarJButton.setFont(new Font("Tahoma", 0, 13));
        jScrollBar2.setBounds(new Rectangle(885, 115, 15, 165));
        editorReglamentoJPanel.setBounds(new Rectangle(50, 360, 710, 275));

        editorReglamentoJPanel.setLayout(null);


        puntosPorPartidoEmpatadoJTextArea.setVisible(false);
        jLabelPuntosPorPartidoEmpatado.setVisible(false);

        modalidadLigaJPanel.setVisible(false);
        jPanelFormaDePuntuaci�nSet.setVisible(false);
        formaDePuntuaci�nPuntuaci�nJPanel.setVisible(false);



      //  htmlPanel.add("<html><body><h1>hello world</h1></body></html>", null);

    


     //   editorReglamentoJPanel.add(htmlPanel, null);
      
        this.getContentPane().add(editorReglamentoJPanel, null);
        this.getContentPane().add(agregarJButton, null);
        this.getContentPane().add(jLabelDisponibilidad, null);
        this.getContentPane().add(disponibilidadJTextArea, null);
        this.getContentPane().add(aceptarJButton);
        this.getContentPane().add(cancelarJButton);
        this.getContentPane().add(jPanelFormaDePuntuaci�nSet, null);
        this.getContentPane().add(jLabelFormaDePuntuaci�n, null);
        this.getContentPane().add(formaDePuntuaci�nJComboBox, null);
        this.getContentPane().add(modalidadLigaJPanel, null);


        //this.getContentPane().add(panel, null);
        this.getContentPane().add(jScrollBar1, null);
        this.getContentPane().add(lugarDeRealizaci�nJList, null);
        this.getContentPane().add(jLabelReglamento, null);
        this.getContentPane().add(modalidadJComboBox, null);
        this.getContentPane().add(jLabelModalidad, null);
        this.getContentPane().add(jLabelLugarDeRealizaci�n, null);
        this.getContentPane().add(deporteJComboBox, null);
        this.getContentPane().add(jLabelDeporte, null);
        this.getContentPane().add(jLabelNombreDeLaCompetencia, null);
        this.getContentPane().add(nombreDeLaCompetenciaJTextArea, null);
        this.getContentPane().add(quitarJButton, null);
        this.getContentPane().add(jScrollBar2, null);
        this.getContentPane().add(tablaLugarDisponibilidadJTable, null);
        this.getContentPane().add(formaDePuntuaci�nPuntuaci�nJPanel, null);


    }
    private void empateSiJRadioButton_actionPerformed(ActionEvent e) {
        empateNoJRadioButton.setSelected(false);
        puntosPorPartidoEmpatadoJTextArea.setVisible(true);
        jLabelPuntosPorPartidoEmpatado.setVisible(true);
        
    }

    private void empateNoJRadioButton_actionPerformed(ActionEvent e) {
        empateSiJRadioButton.setSelected(false);    
        puntosPorPartidoEmpatadoJTextArea.setVisible(false);
        jLabelPuntosPorPartidoEmpatado.setVisible(false);
    }

    private void modalidadJComboBox_actionPerformed(ActionEvent e) {
        if(modalidadJComboBox.getSelectedItem().equals("Sistema de Liga")){
            modalidadLigaJPanel.setVisible(true);
            }
        else
        modalidadLigaJPanel.setVisible(false);
    }

    private void formaDePuntuaci�nJComboBox_actionPerformed(ActionEvent e) {
        if(formaDePuntuaci�nJComboBox.getSelectedItem().equals("Sets"))

        {

        jPanelFormaDePuntuaci�nSet.setVisible(true);
            formaDePuntuaci�nPuntuaci�nJPanel.setVisible(false);
        }
        else
            if(formaDePuntuaci�nJComboBox.getSelectedItem().equals("Puntuaci�n"))
        {
            jPanelFormaDePuntuaci�nSet.setVisible(false);
                            formaDePuntuaci�nPuntuaci�nJPanel.setVisible(true);
        }
            else
        if(formaDePuntuaci�nJComboBox.getSelectedItem().equals("Resultado Final"))
        {
                jPanelFormaDePuntuaci�nSet.setVisible(false);
                                formaDePuntuaci�nPuntuaci�nJPanel.setVisible(false);
            }

        
        
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    private void aceptarJButton_actionPerformed(ActionEvent e) {

        
    }
}
