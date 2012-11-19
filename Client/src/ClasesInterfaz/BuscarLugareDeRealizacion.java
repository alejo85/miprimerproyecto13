package ClasesInterfaz;

import ClasesLogicas.LugarDeRealizacion;

import ClasesLogicas.Usuario;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class BuscarLugareDeRealizacion extends JDialog {
    private JPanel busquedadaJPanel = new JPanel();
    private JPanel resultadoJPanel = new JPanel();
    private JTextArea codigoLugarDeRealizaci�nJTextArea = new JTextArea();
    private JLabel jLabelCorreoElectr�nico = new JLabel();
    private JTextArea nombreLugarDeRealizaci�nJTextArea = new JTextArea();
    private JLabel jLabelCorreoElectr�nico1 = new JLabel();
    private JComboBox deporteJComboBox = new JComboBox();
    private JLabel jLabelCorreoElectr�nico2 = new JLabel();
    private JButton buscarJButton = new JButton();
    private JScrollPane jScrollPaneResultado = new JScrollPane();
    private JTable tablaResultadosJTable = new JTable();
    private JScrollBar jScrollBar1 = new JScrollBar();
    private JButton nuevoLugarDeRealizaci�nJButton = new JButton();
    private JButton modificarLugarDeRealizaci�nJButton = new JButton();
    private JButton eliminarLugarDeRealizaci�nJButton = new JButton();
    private JButton cancelarJButton = new JButton();
    private JButton aceptarJButton = new JButton();
    private Vector <LugarDeRealizacion> lugar=null;
    private Usuario usuarioActual=null;
    public BuscarLugareDeRealizacion(Usuario usuario) {
        this(null, "", false);
        usuarioActual=usuario;
    }

    public BuscarLugareDeRealizacion(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(1201, 807));
        this.getContentPane().setLayout( null );
        this.setTitle("Buscar Lugares De Realizaci�n");
        busquedadaJPanel.setBounds(new Rectangle(190, 50, 690, 195));
        busquedadaJPanel.setLayout(null);
        busquedadaJPanel.setBorder(BorderFactory.createTitledBorder("Buscar por"));
        resultadoJPanel.setBounds(new Rectangle(75, 335, 910, 345));
        resultadoJPanel.setLayout(null);
        resultadoJPanel.setBorder(BorderFactory.createTitledBorder("Resultados"));
        codigoLugarDeRealizaci�nJTextArea.setBounds(new Rectangle(175, 25, 250, 30));
        codigoLugarDeRealizaci�nJTextArea.setFont(new Font("Tahoma", 0, 13));
        codigoLugarDeRealizaci�nJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelCorreoElectr�nico.setText("Codigo:");
        jLabelCorreoElectr�nico.setBounds(new Rectangle(35, 25, 135, 25));
        jLabelCorreoElectr�nico.setFont(new Font("Tahoma", 0, 13));
        nombreLugarDeRealizaci�nJTextArea.setBounds(new Rectangle(175, 65, 250, 30));
        nombreLugarDeRealizaci�nJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreLugarDeRealizaci�nJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelCorreoElectr�nico1.setText("Nombre Del Lugar:");
        jLabelCorreoElectr�nico1.setBounds(new Rectangle(35, 65, 135, 25));
        jLabelCorreoElectr�nico1.setFont(new Font("Tahoma", 0, 13));
        deporteJComboBox.setBounds(new Rectangle(175, 105, 250, 30));
        deporteJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        deporteJComboBox.setMinimumSize(new Dimension(2, 18));
        deporteJComboBox.setPreferredSize(new Dimension(2, 18));
        deporteJComboBox.setSize(new Dimension(250, 30));
        jLabelCorreoElectr�nico2.setText("Deporte:");
        jLabelCorreoElectr�nico2.setBounds(new Rectangle(40, 105, 135, 25));
        jLabelCorreoElectr�nico2.setFont(new Font("Tahoma", 0, 13));
        buscarJButton.setText("Buscar");
        buscarJButton.setBounds(new Rectangle(500, 65, 110, 30));
        buscarJButton.setFont(new Font("Tahoma", 0, 13));
        buscarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buscarJButton_actionPerformed(e);
                }
            });
        jScrollPaneResultado.setBounds(new Rectangle(20, 25, 860, 230));
        jScrollBar1.setBounds(new Rectangle(870, 25, 15, 230));
        nuevoLugarDeRealizaci�nJButton.setText("Nuevo Lugar De Realizaci�n");
        nuevoLugarDeRealizaci�nJButton.setBounds(new Rectangle(65, 280, 240, 30));
        nuevoLugarDeRealizaci�nJButton.setFont(new Font("Tahoma", 0, 13));
        nuevoLugarDeRealizaci�nJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    nuevoLugarDeRealizaci�nJButton_actionPerformed(e);
                }
            });
        modificarLugarDeRealizaci�nJButton.setText("Modificar Lugar De Realizaci�n");
        modificarLugarDeRealizaci�nJButton.setBounds(new Rectangle(345, 280, 220, 30));
        modificarLugarDeRealizaci�nJButton.setFont(new Font("Tahoma", 0, 13));
        modificarLugarDeRealizaci�nJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    modificarLugarDeRealizaci�nJButton_actionPerformed(e);
                }
            });
        eliminarLugarDeRealizaci�nJButton.setText("Eliminar  Lugar De Realizaci�n");
        eliminarLugarDeRealizaci�nJButton.setBounds(new Rectangle(600, 280, 220, 30));
        eliminarLugarDeRealizaci�nJButton.setFont(new Font("Tahoma", 0, 13));
        eliminarLugarDeRealizaci�nJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    eliminarLugarDeRealizaci�nJButton_actionPerformed(e);
                }
            });
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(735, 705, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(545, 705, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        jScrollPaneResultado.getViewport().add(tablaResultadosJTable, null);
        resultadoJPanel.add(jScrollBar1, null);
        resultadoJPanel.add(jScrollPaneResultado, null);
        resultadoJPanel.add(nuevoLugarDeRealizaci�nJButton, null);
        resultadoJPanel.add(modificarLugarDeRealizaci�nJButton, null);
        resultadoJPanel.add(eliminarLugarDeRealizaci�nJButton, null);
        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(resultadoJPanel, null);
        this.getContentPane().add(busquedadaJPanel, null);
        busquedadaJPanel.add(jLabelCorreoElectr�nico1, null);
        busquedadaJPanel.add(nombreLugarDeRealizaci�nJTextArea, null);
        busquedadaJPanel.add(jLabelCorreoElectr�nico, null);
        busquedadaJPanel.add(codigoLugarDeRealizaci�nJTextArea, null);
        busquedadaJPanel.add(deporteJComboBox, null);
        busquedadaJPanel.add(jLabelCorreoElectr�nico2, null);
        busquedadaJPanel.add(buscarJButton, null);
    }

  



    private void nuevoLugarDeRealizaci�nJButton_actionPerformed(ActionEvent e) {
        AltaLugarDeRealizacion ven = new AltaLugarDeRealizacion(usuarioActual);
        ven.setVisible(true);
    }

    private void modificarLugarDeRealizaci�nJButton_actionPerformed(ActionEvent e) {
        JOptionPane.showOptionDialog(null, "Por el momento esta funcionalidad no esta disponible"  , "Funcionalidad no disponible", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
    }

    private void eliminarLugarDeRealizaci�nJButton_actionPerformed(ActionEvent e) {
        JOptionPane.showOptionDialog(null, "Por el momento esta funcionalidad no esta disponible"  , "Funcionalidad no disponible", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    private void buscarJButton_actionPerformed(ActionEvent e) {
        JOptionPane.showOptionDialog(null, "Por el momento esta funcionalidad no esta disponible"  , "Funcionalidad no disponible", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
    }
}
