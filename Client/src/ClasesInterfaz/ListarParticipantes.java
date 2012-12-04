package ClasesInterfaz;


import ClasesGestores.ParticipanteGestor;

import ClasesLogicas.Competencia;
import ClasesLogicas.ModeloTabla;
import ClasesLogicas.Participante;
import ClasesLogicas.Usuario;

import InterfazGrafica.CampoTexto.AreaTextoNombre;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ListarParticipantes extends JDialog {
    private ModeloTabla modelo = new ModeloTabla(new String[] { "Nombre", "Correo" }, 0);
    private AreaTextoNombre nombreCompetenciaJTextArea = new AreaTextoNombre(60);
    private JLabel jLabelNombreCompetencia = new JLabel();
    private JPanel participantesJPanel = new JPanel();
    private JButton cancelarJButton = new JButton();
    private JButton altaParticipanteJButton = new JButton();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTable tablaParticipantesJTable = new JTable();
    private JButton modificarParticipanteJButton = new JButton();
    private JButton eliminarPrticipanteJButton = new JButton();
    private Competencia competenciaSeleccionada=null;
    private Usuario usuarioAcatual=null;
    private VerCompetencia ventanaAnterior;
    private AltaParticipante ven=null;

    public ListarParticipantes(Usuario usuario, Competencia competencia, VerCompetencia ventana) {

        this(null, "", false, usuario, competencia, ventana);
    }

    public ListarParticipantes(Frame parent, String title, boolean modal,Usuario usuario, Competencia competencia,VerCompetencia ventana) {
        super(parent, title, modal);
        try {
            this.usuarioAcatual=usuario;
            this.competenciaSeleccionada=competencia;
            this.ventanaAnterior=ventana;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void jbInit() throws Exception {
        CerrarVentana();
        tablaParticipantesJTable.setModel(modelo);
        cargarParticipantes();
        this.setSize(new Dimension(808, 627));
        this.getContentPane().setLayout( null );
        this.setTitle("Listado de Participantes");
        nombreCompetenciaJTextArea.setBounds(new Rectangle(235, 30, 375, 30));
        nombreCompetenciaJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreCompetenciaJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nombreCompetenciaJTextArea.setEnabled(false);
        jLabelNombreCompetencia.setText("Nombre De La Competencia");
        jLabelNombreCompetencia.setBounds(new Rectangle(45, 25, 175, 25));
        jLabelNombreCompetencia.setFont(new Font("Tahoma", 0, 13));
        participantesJPanel.setBounds(new Rectangle(45, 90, 490, 410));
        participantesJPanel.setLayout(null);
        participantesJPanel.setBorder(BorderFactory.createTitledBorder("Participantes"));
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(440, 535, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.setActionCommand("Cancelar");
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        altaParticipanteJButton.setText("Alta Participante");
        altaParticipanteJButton.setBounds(new Rectangle(600, 205, 165, 30));
        altaParticipanteJButton.setFont(new Font("Tahoma", 0, 13));
        altaParticipanteJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    altaParticipanteJButton_actionPerformed(e);
                }
            });
        jScrollPane1.setBounds(new Rectangle(35, 25, 425, 345));
        modificarParticipanteJButton.setText("Modificar Participante");
        modificarParticipanteJButton.setBounds(new Rectangle(600, 250, 165, 30));
        modificarParticipanteJButton.setFont(new Font("Tahoma", 0, 13));
        modificarParticipanteJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    modificarParticipanteJButton_actionPerformed(e);
                }
            });
        eliminarPrticipanteJButton.setText("Eliminar Participante");
        eliminarPrticipanteJButton.setBounds(new Rectangle(600, 300, 165, 30));
        eliminarPrticipanteJButton.setFont(new Font("Tahoma", 0, 13));
        eliminarPrticipanteJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    eliminarPrticipanteJButton_actionPerformed(e);
                }
            });
        this.getContentPane().add(eliminarPrticipanteJButton, null);
        this.getContentPane().add(modificarParticipanteJButton, null);
        this.getContentPane().add(altaParticipanteJButton, null);
        this.getContentPane().add(cancelarJButton, null);
        jScrollPane1.getViewport().add(tablaParticipantesJTable, null);
        participantesJPanel.add(jScrollPane1, null);
        this.getContentPane().add(participantesJPanel, null);
        this.getContentPane().add(jLabelNombreCompetencia, null);
        this.getContentPane().add(nombreCompetenciaJTextArea, null);
       
    }





    private void altaParticipanteJButton_actionPerformed(ActionEvent e) {
        ven = new AltaParticipante(competenciaSeleccionada, this);
        ven.setVisible(true);
        super.setVisible(false);
    }
    /*public void setVisible(boolean b){
            
            actualizar();
            super.setVisible(b);
        }*/
    private void cancelarJButton_actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose(); // cuando se cierra, se pierde los cambios realizados
        ventanaAnterior.setCompetencia(competenciaSeleccionada);
        ventanaAnterior.setVisible(true);
    }

    private void modificarParticipanteJButton_actionPerformed(ActionEvent e) {
        /*ModificarParticipante ven = new ModificarParticipante();
        ven.setVisible(true);*/
        JOptionPane.showOptionDialog(null, "Por el momento esta funcionalidad no esta disponible"  , "Funcionalidad no disponible", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
    }

    private void eliminarPrticipanteJButton_actionPerformed(ActionEvent e) {
        /*int respuesta = JOptionPane.showOptionDialog(this, "¿Está seguro de que desea eliminar el Participante: Nombre Participante?.", "Eliminar Participante.", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null , new Object[]{"Si", "No"}, "Si");
        if (respuesta == 0){
        
            JOptionPane.showOptionDialog(null, "Se ha eliminado el participante nombre del participante de la competecnia Nombre Competencia "  , "Participante Eliminado.", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
        }  */
        JOptionPane.showOptionDialog(null, "Por el momento esta funcionalidad no esta disponible"  , "Funcionalidad no disponible", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
    }
    private void cargarParticipantes(){
            
            for(int i=0; i<competenciaSeleccionada.getParticipantes().length;i++ ){
                    Vector <String> datos = new Vector <String>();
                    datos.add(competenciaSeleccionada.getParticipantes()[i].getNombre());
                    datos.add(competenciaSeleccionada.getParticipantes()[i].getCorreo());
                    modelo.addRow(datos);
                }
            nombreCompetenciaJTextArea.setText(competenciaSeleccionada.getNombreCompetencia());
            tablaParticipantesJTable.setModel(modelo);
        }
    public void setCompetencia(Competencia competencia)
    {
        competenciaSeleccionada=competencia;
            actualizar();
        }
    private void actualizar(){
     
            modelo = new ModeloTabla(new String[] { "Nombre", "Correo" }, 0);
            for(int i=0; i<competenciaSeleccionada.getParticipantes().length;i++ ){
                    Vector <String> datos = new Vector <String>();
                    datos.add(competenciaSeleccionada.getParticipantes()[i].getNombre());
                    datos.add(competenciaSeleccionada.getParticipantes()[i].getCorreo());
                    modelo.addRow(datos);
                }
            nombreCompetenciaJTextArea.setText(competenciaSeleccionada.getNombreCompetencia());
            tablaParticipantesJTable.setModel(modelo);
           
        }
    private void CerrarVentana(){
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose(); // cuando se cierra, se pierde los cambios realizados
        ventanaAnterior.setCompetencia(competenciaSeleccionada);
        ventanaAnterior.setVisible(true);
        
    }
    });
    }
}
