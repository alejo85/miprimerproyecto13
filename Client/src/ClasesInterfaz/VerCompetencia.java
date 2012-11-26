package ClasesInterfaz;


import ClasesGestores.CompetenciaGestor;

import ClasesLogicas.Competencia;
import ClasesLogicas.ModeloTabla;
import ClasesLogicas.Usuario;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class VerCompetencia extends JDialog {
    private ModeloTabla modelo = new ModeloTabla(new String[] { "Nombre" }, 0);
    private JTextArea nombreDeLaCompetenciaJTextArea = new JTextArea();
    private JLabel jLabelDeporte = new JLabel();
    private JLabel jLabelnombreDeLaCompetencia = new JLabel();
    private JTextArea deporteJTextArea = new JTextArea();
    private JTextArea modalidadJTextArea = new JTextArea();
    private JLabel jLabelModalidad = new JLabel();
    private JLabel jLabelEstado = new JLabel();
    private JTextArea estadoJTextArea = new JTextArea();
    private JLabel jLabelParticipante = new JLabel();
    private JTable tablaProximosEncuentosJTable = new JTable();
    private JLabel jLabelProximosEncuentros = new JLabel();
    private JButton modificarCompetenciaJButton = new JButton();
    private JButton eliminarCompetenciaJButton = new JButton();
    private JButton gestionarParticipantesJButton = new JButton();
    private JButton mostrarFixtureJButton = new JButton();
    private JButton generarFixtureJButton = new JButton();
    private JButton mostrarTablaDePosicionesJButton = new JButton();
    private JScrollPane jScrollPaneParticipante = new JScrollPane();
    private JScrollPane jScrollPaneProximoEncuentro = new JScrollPane();
    private JButton cancelarJButton = new JButton();
    private Usuario usuarioActual=null;
    private Competencia competencia;
    private JTable jTable1 = new JTable();

    /**
     * @param usuario
     * @param competencia
     */
    public VerCompetencia( Usuario usuario, Competencia competencia) {

        this(null, "", false, usuario, competencia);
    }

    public VerCompetencia(Frame parent, String title, boolean modal,Usuario usuario, Competencia competencia) {
        super(parent, title, modal);
        try {
            this.usuarioActual=usuario;
            this.competencia=competencia;
            
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(991, 567));
        this.getContentPane().setLayout( null );
        this.setTitle("Ver Competencia");
        cargarDatos();
        nombreDeLaCompetenciaJTextArea.setBounds(new Rectangle(235, 30, 375, 30));
        nombreDeLaCompetenciaJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreDeLaCompetenciaJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nombreDeLaCompetenciaJTextArea.setNextFocusableComponent(this);
        jLabelDeporte.setText("Deporte");
        jLabelDeporte.setBounds(new Rectangle(45, 110, 135, 25));
        jLabelDeporte.setFont(new Font("Tahoma", 0, 13));
        jLabelnombreDeLaCompetencia.setText("Nombre De La Competencia");
        jLabelnombreDeLaCompetencia.setBounds(new Rectangle(45, 25, 175, 25));
        jLabelnombreDeLaCompetencia.setFont(new Font("Tahoma", 0, 13));
        deporteJTextArea.setBounds(new Rectangle(235, 110, 375, 30));
        deporteJTextArea.setFont(new Font("Tahoma", 0, 13));
        deporteJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deporteJTextArea.setNextFocusableComponent(this);
        modalidadJTextArea.setBounds(new Rectangle(235, 70, 375, 30));
        modalidadJTextArea.setFont(new Font("Tahoma", 0, 13));
        modalidadJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        modalidadJTextArea.setNextFocusableComponent(this);
        jLabelModalidad.setText("Modalidad");
        jLabelModalidad.setBounds(new Rectangle(45, 70, 135, 25));
        jLabelModalidad.setFont(new Font("Tahoma", 0, 13));
        jLabelEstado.setText("Estado");
        jLabelEstado.setBounds(new Rectangle(45, 150, 135, 25));
        jLabelEstado.setFont(new Font("Tahoma", 0, 13));
        estadoJTextArea.setBounds(new Rectangle(235, 150, 375, 30));
        estadoJTextArea.setFont(new Font("Tahoma", 0, 13));
        estadoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        estadoJTextArea.setNextFocusableComponent(this);
        jLabelParticipante.setText("Participantes");
        jLabelParticipante.setBounds(new Rectangle(45, 230, 135, 25));
        jLabelParticipante.setFont(new Font("Tahoma", 0, 13));
        jLabelProximosEncuentros.setText("Proximos Encuentros");
        jLabelProximosEncuentros.setBounds(new Rectangle(45, 355, 135, 25));
        jLabelProximosEncuentros.setFont(new Font("Tahoma", 0, 13));
        modificarCompetenciaJButton.setText("Modificar Competencia");
        modificarCompetenciaJButton.setBounds(new Rectangle(710, 15, 175, 30));
        modificarCompetenciaJButton.setFont(new Font("Tahoma", 0, 13));
        modificarCompetenciaJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    modificarCompetenciaJButton_actionPerformed(e);
                }
            });
        eliminarCompetenciaJButton.setText("Emiminar Competencia");
        eliminarCompetenciaJButton.setBounds(new Rectangle(710, 50, 175, 30));
        eliminarCompetenciaJButton.setFont(new Font("Tahoma", 0, 13));
        eliminarCompetenciaJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    eliminarCompetenciaJButton_actionPerformed(e);
                }
            });
        gestionarParticipantesJButton.setText("Gestionar Participantes");
        gestionarParticipantesJButton.setBounds(new Rectangle(710, 200, 175, 30));
        gestionarParticipantesJButton.setFont(new Font("Tahoma", 0, 13));
        gestionarParticipantesJButton.setActionCommand("Gestionar Participantes");
        gestionarParticipantesJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gestionarParticipantesJButton_actionPerformed(e);
                }
            });
        mostrarFixtureJButton.setText("Mostrar Fixture");
        mostrarFixtureJButton.setBounds(new Rectangle(710, 370, 175, 30));
        mostrarFixtureJButton.setFont(new Font("Tahoma", 0, 13));
        mostrarFixtureJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mostrarFixtureJButton_actionPerformed(e);
                }
            });
        generarFixtureJButton.setText("Generar Fixture");
        generarFixtureJButton.setBounds(new Rectangle(710, 335, 175, 30));
        generarFixtureJButton.setFont(new Font("Tahoma", 0, 13));
        generarFixtureJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    generarFixtureJButton_actionPerformed(e);
                }
            });
        mostrarTablaDePosicionesJButton.setText("Mostrar Tabla");
        mostrarTablaDePosicionesJButton.setBounds(new Rectangle(710, 400, 175, 30));
        mostrarTablaDePosicionesJButton.setFont(new Font("Tahoma", 0, 13));
        mostrarTablaDePosicionesJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mostrarTablaDePosicionesJButton_actionPerformed(e);
                }
            });
        jScrollPaneParticipante.setBounds(new Rectangle(235, 200, 375, 125));
        jScrollPaneProximoEncuentro.setBounds(new Rectangle(235, 340, 375, 120));
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(650, 475, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(mostrarTablaDePosicionesJButton, null);
        this.getContentPane().add(generarFixtureJButton, null);
        this.getContentPane().add(mostrarFixtureJButton, null);
        this.getContentPane().add(gestionarParticipantesJButton, null);
        this.getContentPane().add(eliminarCompetenciaJButton, null);
        this.getContentPane().add(modificarCompetenciaJButton, null);
        this.getContentPane().add(jLabelProximosEncuentros, null);
        this.getContentPane().add(jLabelParticipante, null);
        this.getContentPane().add(estadoJTextArea, null);
        this.getContentPane().add(jLabelEstado, null);
        this.getContentPane().add(jLabelModalidad, null);
        this.getContentPane().add(modalidadJTextArea, null);
        this.getContentPane().add(deporteJTextArea, null);
        this.getContentPane().add(jLabelnombreDeLaCompetencia, null);
        this.getContentPane().add(jLabelDeporte, null);
        this.getContentPane().add(nombreDeLaCompetenciaJTextArea, null);
        jScrollPaneParticipante.getViewport().add(jTable1, null);
        this.getContentPane().add(jScrollPaneParticipante, null);
        jScrollPaneProximoEncuentro.getViewport().add(tablaProximosEncuentosJTable, null);
        this.getContentPane().add(jScrollPaneProximoEncuentro, null);
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    private void modificarCompetenciaJButton_actionPerformed(ActionEvent e) {
        ModificarLaCompetencia ven = new ModificarLaCompetencia(usuarioActual, competencia);
        ven.setVisible(true);
    }

    private void eliminarCompetenciaJButton_actionPerformed(ActionEvent e) {
        int respuesta = JOptionPane.showOptionDialog(this, "¿Está seguro de que desea eliminar la competencia Nombre Competencia?.", "Eliminar la Competencia.", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null , new Object[]{"Si", "No"}, "Si");
        if (respuesta == 0){
            ImageIcon imagenCandado = new ImageIcon("Imagenes//candado.gif");
            JOptionPane.showOptionDialog(null, "Se ha eliminado la  competencia Nombre Competencia "  , "Competencia Eliminada.", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, imagenCandado, new Object[]{"Aceptar"},"Aceptar");
        } 
    }

    private void gestionarParticipantesJButton_actionPerformed(ActionEvent e) {
        ListarParticipantes ven;
        ven = new ListarParticipantes(usuarioActual, competencia);
        ven.setVisible(true);
    }

    private void generarFixtureJButton_actionPerformed(ActionEvent e) {
        int respuesta = JOptionPane.showOptionDialog(this, "¿Está seguro de que desea generar el fixture de la competencia Nombre Competencia?.", "Generar Fixture.", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null , new Object[]{"Si", "No"}, "Si");
        if (respuesta == 0){
            CompetenciaGestor.generarFixture(competencia);
            JOptionPane.showOptionDialog(null, "Se ha generar el fixture de la  competencia Nombre Competencia "  , "Generar Fixture.", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
        } 
    }

    private void mostrarFixtureJButton_actionPerformed(ActionEvent e) {
        ModificarFixture ven = new ModificarFixture();
        ven.setVisible(true);
    }

    private void mostrarTablaDePosicionesJButton_actionPerformed(ActionEvent e) {
        TablaDePosiciones ven = new TablaDePosiciones();
        ven.setVisible(true);
    }
    private void cargarDatos(){
        nombreDeLaCompetenciaJTextArea.setText(competencia.getNombreCompetencia());
        deporteJTextArea.setText(competencia.getDeporte().getNombre());
        modalidadJTextArea.setText(competencia.getModalidad());
        estadoJTextArea.setText(competencia.getEstado());
        modelo = new ModeloTabla(new String[] { "Nombre" }, 0);
        for(int i=0; i<competencia.getParticipantes().length;i++ ){
                Vector <String> datos = new Vector <String>();
                datos.add(competencia.getParticipantes()[i].getNombre());
                modelo.addRow(datos);
            }
           jTable1.setModel(modelo);
            if(competencia.getFixture() != null)
            {
                //TODO CArgar fixture tabla en la pantalla
                }
        }
       
}
