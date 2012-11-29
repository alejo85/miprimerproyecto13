package ClasesInterfaz;


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


public class BuscarTodasLasCompetenciaDeportiva extends JDialog {
    private JButton aceptarJButton = new JButton();
    private JButton cancelarJButton = new JButton();
    private JPanel resultadoJPanel = new JPanel();
    private JScrollBar jScrollBar1 = new JScrollBar();
    private JButton mostrarTablaJButton = new JButton();
    private JButton mostrarFixtureJButton = new JButton();
    private JScrollPane jScrollPaneResultado = new JScrollPane();
    private JTable tablaResultadoJTable = new JTable();
    private JLabel jLabelCorreoElectrónico3 = new JLabel();
    private JComboBox modalidadJComboBox = new JComboBox();
    private JPanel BuscarJPanel = new JPanel();
    private JComboBox deporteJComboBox = new JComboBox();
    private JLabel jLabelCorreoElectrónico1 = new JLabel();
    private JTextArea nombreDeLaCompetenciaJTextArea = new JTextArea();
    private JLabel jLabelCorreoElectrónico = new JLabel();
    private JComboBox estadoJComboBox = new JComboBox();
    private JLabel jLabelCorreoElectrónico2 = new JLabel();
    private JButton buscarJButton = new JButton();
    private JTextArea UsuarioCreadorDeLaCompetenciaJTextArea = new JTextArea();
    private JLabel jLabelCorreoElectrónico4 = new JLabel();
    private Usuario usuarioActual= null;
    private Competencia competenciaSelecionad=null;

    public BuscarTodasLasCompetenciaDeportiva(Usuario usuariologueado) {
        this(null, "", false, usuariologueado);
    }

    public BuscarTodasLasCompetenciaDeportiva(Frame parent, String title, boolean modal,Usuario usuariologueado) {
        super(parent, title, modal);
        try {
            usuarioActual=usuariologueado;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(1065, 796));
        this.getContentPane().setLayout( null );
        this.setTitle("Buscar Todas Las Competencia");
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(300, 690, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(595, 690, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        resultadoJPanel.setBounds(new Rectangle(65, 300, 910, 345));
        resultadoJPanel.setLayout(null);
        resultadoJPanel.setBorder(BorderFactory.createTitledBorder("Resultados"));
        jScrollBar1.setBounds(new Rectangle(870, 25, 15, 230));
        mostrarTablaJButton.setText("Mostrar Tabla");
        mostrarTablaJButton.setBounds(new Rectangle(465, 290, 220, 30));
        mostrarTablaJButton.setFont(new Font("Tahoma", 0, 13));
        mostrarTablaJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mostrarTablaJButton_actionPerformed(e);
                }
            });
        mostrarFixtureJButton.setText("Mostrar Fixture");
        mostrarFixtureJButton.setBounds(new Rectangle(185, 290, 240, 30));
        mostrarFixtureJButton.setFont(new Font("Tahoma", 0, 13));
        mostrarFixtureJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mostrarFixtureJButton_actionPerformed(e);
                }
            });
        jScrollPaneResultado.setBounds(new Rectangle(20, 30, 860, 230));
        jLabelCorreoElectrónico3.setText("Modalidad");
        jLabelCorreoElectrónico3.setBounds(new Rectangle(60, 115, 135, 25));
        jLabelCorreoElectrónico3.setFont(new Font("Tahoma", 0, 13));
        modalidadJComboBox.setBounds(new Rectangle(310, 115, 250, 30));
        modalidadJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        modalidadJComboBox.setMinimumSize(new Dimension(2, 18));
        modalidadJComboBox.setPreferredSize(new Dimension(2, 18));
        modalidadJComboBox.setSize(new Dimension(375, 30));
        BuscarJPanel.setBounds(new Rectangle(65, 15, 900, 260));
        BuscarJPanel.setLayout(null);
        BuscarJPanel.setBorder(BorderFactory.createTitledBorder("Buscar por"));
        deporteJComboBox.setBounds(new Rectangle(310, 70, 370, 30));
        deporteJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        deporteJComboBox.setMinimumSize(new Dimension(2, 18));
        deporteJComboBox.setPreferredSize(new Dimension(2, 18));
        deporteJComboBox.setSize(new Dimension(375, 30));
        jLabelCorreoElectrónico1.setText("Deporte");
        jLabelCorreoElectrónico1.setBounds(new Rectangle(60, 70, 135, 25));
        jLabelCorreoElectrónico1.setFont(new Font("Tahoma", 0, 13));
        nombreDeLaCompetenciaJTextArea.setBounds(new Rectangle(310, 20, 375, 30));
        nombreDeLaCompetenciaJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreDeLaCompetenciaJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelCorreoElectrónico.setText("Nombre De La Competencia");
        jLabelCorreoElectrónico.setBounds(new Rectangle(60, 20, 175, 25));
        jLabelCorreoElectrónico.setFont(new Font("Tahoma", 0, 13));
        estadoJComboBox.setBounds(new Rectangle(310, 160, 250, 30));
        estadoJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        estadoJComboBox.setMinimumSize(new Dimension(2, 18));
        estadoJComboBox.setPreferredSize(new Dimension(2, 18));
        estadoJComboBox.setSize(new Dimension(375, 30));
        jLabelCorreoElectrónico2.setText("Estado");
        jLabelCorreoElectrónico2.setBounds(new Rectangle(60, 160, 135, 25));
        jLabelCorreoElectrónico2.setFont(new Font("Tahoma", 0, 13));
        buscarJButton.setText("Buscar");
        buscarJButton.setBounds(new Rectangle(780, 120, 110, 30));
        buscarJButton.setFont(new Font("Tahoma", 0, 13));
        UsuarioCreadorDeLaCompetenciaJTextArea.setBounds(new Rectangle(310, 200, 370, 30));
        UsuarioCreadorDeLaCompetenciaJTextArea.setFont(new Font("Tahoma", 0, 13));
        UsuarioCreadorDeLaCompetenciaJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelCorreoElectrónico4.setText("Usuario Creador de La Competencia");
        jLabelCorreoElectrónico4.setBounds(new Rectangle(60, 200, 265, 25));
        jLabelCorreoElectrónico4.setFont(new Font("Tahoma", 0, 13));
        resultadoJPanel.add(jScrollBar1, null);
        resultadoJPanel.add(mostrarFixtureJButton, null);
        resultadoJPanel.add(mostrarTablaJButton, null);
        jScrollPaneResultado.getViewport().add(tablaResultadoJTable, null);
        resultadoJPanel.add(jScrollPaneResultado, null);
        resultadoJPanel.add(mostrarTablaJButton, null);
        resultadoJPanel.add(mostrarFixtureJButton, null);
        BuscarJPanel.add(modalidadJComboBox, null);
        BuscarJPanel.add(jLabelCorreoElectrónico3, null);
        BuscarJPanel.add(deporteJComboBox, null);
        BuscarJPanel.add(jLabelCorreoElectrónico1, null);
        BuscarJPanel.add(nombreDeLaCompetenciaJTextArea, null);
        BuscarJPanel.add(jLabelCorreoElectrónico, null);
        BuscarJPanel.add(estadoJComboBox, null);
        BuscarJPanel.add(jLabelCorreoElectrónico2, null);
        BuscarJPanel.add(jLabelCorreoElectrónico4, null);
        BuscarJPanel.add(UsuarioCreadorDeLaCompetenciaJTextArea, null);
        BuscarJPanel.add(buscarJButton, null);
        this.getContentPane().add(BuscarJPanel, null);
        this.getContentPane().add(resultadoJPanel, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(aceptarJButton, null);
       
    }

    private void mostrarFixtureJButton_actionPerformed(ActionEvent e) {
        ModificarFixture ven = new ModificarFixture();
        ven.setVisible(true);
    }

    private void mostrarTablaJButton_actionPerformed(ActionEvent e) {
        /*VerCompetencia ven = new VerCompetencia(usuarioActual, competenciaSelecionad, this);
        ven.setVisible(true);*/
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
