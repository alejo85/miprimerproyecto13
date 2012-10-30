package ClasesInterfaz;


import ClasesLogicas.Usuario;

import InterfazGrafica.CampoTexto.AreaTextoAlfabetico;
import InterfazGrafica.CampoTexto.AreaTextoNombre;
import InterfazGrafica.CampoTexto.AreaTextoNumerico;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class AltaCompetenciaDeportiva extends JDialog {


    private AreaTextoNombre nombreDeLaCompetenciaJTextArea = new AreaTextoNombre(60);
    private JLabel jLabelNombreDeLaCompetencia = new JLabel();
    private JLabel jLabelDeporte = new JLabel();
    private JComboBox deporteJComboBox = new JComboBox();
    private JLabel jLabelLugarDeRealización = new JLabel();
    private JLabel jLabelModalidad = new JLabel();
    private JComboBox modalidadJComboBox = new JComboBox();
    private JLabel jLabelReglamento = new JLabel();
    private JList lugarDeRealizaciónJList = new JList();
    private JScrollBar jScrollBar1 = new JScrollBar();
    private JPanel modalidadLigaJPanel = new JPanel();
    private Usuario ussuarioActual=null;
    private BorderLayout borderLayout1 = new BorderLayout();
    private JLabel jLabelPuntosPorPartidoGanados = new JLabel();
    private AreaTextoNumerico puntosPorPartidoGanadosJTextArea = new AreaTextoNumerico(2);
    private JPanel jPanelEmpate = new JPanel();
    private JRadioButton empateSiJRadioButton = new JRadioButton();
    private JRadioButton empateNoJRadioButton = new JRadioButton();
    private AreaTextoNumerico puntosPorPartidoEmpatadoJTextArea = new AreaTextoNumerico(2);
    private JLabel jLabelPuntosPorPartidoEmpatado = new JLabel();
    private AreaTextoNumerico puntosPorPartidoAsistidoJTextArea = new AreaTextoNumerico(2);
    private JLabel jLabelPuntosPorPartidosAsistido = new JLabel();
    private JComboBox formaDePuntuaciónJComboBox = new JComboBox();
    private JLabel jLabelFormaDePuntuación = new JLabel();
    private JPanel jPanelFormaDePuntuaciónSet = new JPanel();
    private JPanel formaDePuntuaciónPuntuaciónJPanel = new JPanel();
    private JLabel jLabelCantidadMaximaDeSets = new JLabel();
    private AreaTextoNumerico cantidadMaximaDeSetsJTextArea = new AreaTextoNumerico(2);
    private AreaTextoNumerico tantosPorPartidosGanadosJTextArea = new AreaTextoNumerico(2);
    private JLabel jLabelTantosPorPartidosGanados = new JLabel();
    private JButton aceptarJButton = new JButton();
    private JButton cancelarJButton = new JButton();
    private JButton quitarJButton = new JButton();
    private AreaTextoNumerico disponibilidadJTextArea = new AreaTextoNumerico(4);
    private JLabel jLabelDisponibilidad = new JLabel();
    private JTable tablaLugarDisponibilidadJTable = new JTable();
    private JButton agregarJButton = new JButton();
    private JScrollBar jScrollBar2 = new JScrollBar();
    private int tamaño=10;
    private String fuenteLetra;
    private JPanel editorReglamentoJPanel = new JPanel();
    private JComboBox fuenteJComboBox = new JComboBox();
    private JComboBox fuenteTamañoJComboBox = new JComboBox();
    private JButton alinaciónIzquierdaJButton = new JButton();
    private JButton aliniaciónCentradaJButton = new JButton();
    private JButton aliniaciónDerechaJButton = new JButton();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JEditorPane textoReglamentoJTextArea = new JEditorPane();
    private JButton cursivaJButton = new JButton();
    private JButton negritaJButton = new JButton();
    private JButton subrayadoJButton = new JButton();

    public AltaCompetenciaDeportiva(Usuario usuarioLogueado) {

        this(null, "", false,usuarioLogueado);
    }
    public AltaCompetenciaDeportiva() {

        this(null, "", false);
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
    public AltaCompetenciaDeportiva(Frame parent, String title, boolean modal ) {
        super(parent, title, modal);
        try {
         
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
        jLabelLugarDeRealización.setText("Lugar De Realización");
        jLabelLugarDeRealización.setBounds(new Rectangle(50, 115, 135, 25));
        jLabelLugarDeRealización.setFont(new Font("Tahoma", 0, 13));
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
        formaDePuntuaciónJComboBox.addItem("Resultado Final");
        formaDePuntuaciónJComboBox.addItem("Puntuación");
        formaDePuntuaciónJComboBox.addItem("Sets");
        jLabelReglamento.setText("Reglamento");
        jLabelReglamento.setBounds(new Rectangle(45, 340, 135, 25));
        jLabelReglamento.setFont(new Font("Tahoma", 0, 13));
        lugarDeRealizaciónJList.setBounds(new Rectangle(235, 115, 240, 160));
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
        formaDePuntuaciónJComboBox.setBounds(new Rectangle(1155, 295, 260, 30));
        formaDePuntuaciónJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        formaDePuntuaciónJComboBox.setMinimumSize(new Dimension(2, 18));
        formaDePuntuaciónJComboBox.setPreferredSize(new Dimension(2, 18));
        formaDePuntuaciónJComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    formaDePuntuaciónJComboBox_actionPerformed(e);
                }
            });
        jLabelFormaDePuntuación.setText("Forma de Puntuacion");
        jLabelFormaDePuntuación.setBounds(new Rectangle(995, 295, 135, 25));
        jLabelFormaDePuntuación.setFont(new Font("Tahoma", 0, 13));
        jPanelFormaDePuntuaciónSet.setBounds(new Rectangle(950, 365, 475, 75));
        jPanelFormaDePuntuaciónSet.setLayout(null);
        formaDePuntuaciónPuntuaciónJPanel.setBounds(new Rectangle(950, 440, 475, 75));
        formaDePuntuaciónPuntuaciónJPanel.setLayout(null);
        jPanelFormaDePuntuaciónSet.setBorder(BorderFactory.createTitledBorder("Sets"));
        formaDePuntuaciónPuntuaciónJPanel.setBorder(BorderFactory.createTitledBorder("Puntuacion"));
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
        
        
        formaDePuntuaciónPuntuaciónJPanel.add(tantosPorPartidosGanadosJTextArea, null);
        formaDePuntuaciónPuntuaciónJPanel.add(jLabelTantosPorPartidosGanados, null);
        jPanelFormaDePuntuaciónSet.add(cantidadMaximaDeSetsJTextArea, null);
        jPanelFormaDePuntuaciónSet.add(jLabelCantidadMaximaDeSets, null);
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(490, 670, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
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
        fuenteJComboBox.setBounds(new Rectangle(40, 10, 135, 30));
        fuenteJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        fuenteJComboBox.setMinimumSize(new Dimension(2, 18));
        fuenteJComboBox.setPreferredSize(new Dimension(2, 18));

  
        fuenteJComboBox.addItem("Helvetica");
        fuenteJComboBox.addItem("TimesRoman");
        fuenteJComboBox.addItem("Courier");
        fuenteTamañoJComboBox.addItem(10);
        fuenteTamañoJComboBox.addItem(11);
        fuenteTamañoJComboBox.addItem(12);
        fuenteTamañoJComboBox.addItem(13);
        fuenteTamañoJComboBox.addItem(14);
        fuenteTamañoJComboBox.addItem(15);
        fuenteTamañoJComboBox.addItem(16);
        fuenteTamañoJComboBox.addItem(17);
        fuenteTamañoJComboBox.addItem(18);
        fuenteTamañoJComboBox.addItem(19);
        fuenteTamañoJComboBox.addItem(20);
        fuenteTamañoJComboBox.addItem(21);
        fuenteTamañoJComboBox.addItem(22);
        fuenteTamañoJComboBox.addItem(23);
        fuenteTamañoJComboBox.addItem(24);
        fuenteTamañoJComboBox.addItem(25);
        fuenteTamañoJComboBox.addItem(26);
        fuenteTamañoJComboBox.addItem(27);
        fuenteTamañoJComboBox.addItem(28);
        fuenteTamañoJComboBox.addItem(29);
        fuenteTamañoJComboBox.addItem(30);

        textoReglamentoJTextArea.setContentType("text/rtf");
        cursivaJButton.setBounds(new Rectangle(365, 10, 35, 30));
        cursivaJButton.setFont(new Font("Tahoma", 0, 13));
        cursivaJButton.setIcon(new ImageIcon("Imagenes\\cursiva.png"));
 
        negritaJButton.setBounds(new Rectangle(405, 10, 35, 30));
        negritaJButton.setFont(new Font("Tahoma", 0, 13));
        negritaJButton.setIcon(new ImageIcon("Imagenes\\negrita.png"));
      
        subrayadoJButton.setBounds(new Rectangle(445, 10, 35, 30));
        subrayadoJButton.setFont(new Font("Tahoma", 0, 13));
        subrayadoJButton.setIcon(new ImageIcon("Imagenes\\subrayado.png"));

        fuenteLetra = fuenteJComboBox.getSelectedItem().toString();
        tamaño = Integer.parseInt(fuenteTamañoJComboBox.getSelectedItem().toString());
        fuenteTamañoJComboBox.setBounds(new Rectangle(190, 10, 45, 30));
        fuenteTamañoJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        fuenteTamañoJComboBox.setMinimumSize(new Dimension(2, 18));
        fuenteTamañoJComboBox.setPreferredSize(new Dimension(2, 18));

    
        alinaciónIzquierdaJButton.setBounds(new Rectangle(245, 10, 35, 30));
        alinaciónIzquierdaJButton.setFont(new Font("Tahoma", 0, 13));
        alinaciónIzquierdaJButton.setIcon(new ImageIcon("Imagenes\\text_align_left.png"));
    
        aliniaciónCentradaJButton.setBounds(new Rectangle(285, 10, 35, 30));
        aliniaciónCentradaJButton.setFont(new Font("Tahoma", 0, 13));
        aliniaciónCentradaJButton.setIcon(new ImageIcon("Imagenes\\text_align_center.png"));
     
        aliniaciónDerechaJButton.setBounds(new Rectangle(325, 10, 35, 30));
        aliniaciónDerechaJButton.setFont(new Font("Tahoma", 0, 13));
        aliniaciónDerechaJButton.setIcon(new ImageIcon("Imagenes\\text_align_right.png"));
        
        puntosPorPartidoEmpatadoJTextArea.setVisible(false);
        jLabelPuntosPorPartidoEmpatado.setVisible(false);
        
        jScrollPane1.setBounds(new Rectangle(30, 60, 655, 195));
        jScrollPane1.getViewport().add(textoReglamentoJTextArea, null);
        editorReglamentoJPanel.add(subrayadoJButton, null);
        editorReglamentoJPanel.add(negritaJButton, null);
        editorReglamentoJPanel.add(cursivaJButton, null);
        editorReglamentoJPanel.add(jScrollPane1, null);
        editorReglamentoJPanel.add(aliniaciónDerechaJButton, null);
        editorReglamentoJPanel.add(aliniaciónCentradaJButton, null);
        editorReglamentoJPanel.add(fuenteTamañoJComboBox, null);
        editorReglamentoJPanel.add(fuenteJComboBox, null);
        editorReglamentoJPanel.add(alinaciónIzquierdaJButton, null);
        
        modalidadLigaJPanel.setVisible(false);
      
        jPanelFormaDePuntuaciónSet.setVisible(false);
        formaDePuntuaciónPuntuaciónJPanel.setVisible(false);
        this.getContentPane().add(editorReglamentoJPanel, null);
        this.getContentPane().add(agregarJButton, null);
        this.getContentPane().add(jLabelDisponibilidad, null);
        this.getContentPane().add(disponibilidadJTextArea, null);
        this.getContentPane().add(aceptarJButton);
        this.getContentPane().add(cancelarJButton);
        this.getContentPane().add(jPanelFormaDePuntuaciónSet, null);
        this.getContentPane().add(jLabelFormaDePuntuación, null);
        this.getContentPane().add(formaDePuntuaciónJComboBox, null);
        this.getContentPane().add(modalidadLigaJPanel, null);
        this.getContentPane().add(jScrollBar1, null);
        this.getContentPane().add(lugarDeRealizaciónJList, null);
        this.getContentPane().add(jLabelReglamento, null);
        this.getContentPane().add(modalidadJComboBox, null);
        this.getContentPane().add(jLabelModalidad, null);
        this.getContentPane().add(jLabelLugarDeRealización, null);
        this.getContentPane().add(deporteJComboBox, null);
        this.getContentPane().add(jLabelDeporte, null);
        this.getContentPane().add(jLabelNombreDeLaCompetencia, null);
        this.getContentPane().add(nombreDeLaCompetenciaJTextArea, null);
        this.getContentPane().add(quitarJButton, null);
        this.getContentPane().add(jScrollBar2, null);
        this.getContentPane().add(tablaLugarDisponibilidadJTable, null);
        this.getContentPane().add(formaDePuntuaciónPuntuaciónJPanel, null);


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

    private void formaDePuntuaciónJComboBox_actionPerformed(ActionEvent e) {
        if(formaDePuntuaciónJComboBox.getSelectedItem().equals("Sets"))

        {

        jPanelFormaDePuntuaciónSet.setVisible(true);
            formaDePuntuaciónPuntuaciónJPanel.setVisible(false);
        }
        else
            if(formaDePuntuaciónJComboBox.getSelectedItem().equals("Puntuación"))
        {
            jPanelFormaDePuntuaciónSet.setVisible(false);
                            formaDePuntuaciónPuntuaciónJPanel.setVisible(true);
        }
            else
        if(formaDePuntuaciónJComboBox.getSelectedItem().equals("Resultado Final"))
        {
                jPanelFormaDePuntuaciónSet.setVisible(false);
                                formaDePuntuaciónPuntuaciónJPanel.setVisible(false);
            }

        
        
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
