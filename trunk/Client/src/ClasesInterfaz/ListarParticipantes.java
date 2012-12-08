package ClasesInterfaz;


import ClasesLogicas.Competencia;
import ClasesLogicas.ModeloTabla;
import ClasesLogicas.Usuario;

import InterfazGrafica.CampoTexto.AreaTextoNombre;

import java.awt.Color;
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
    private JLabel nombreCompetenciaJTextArea = new JLabel();
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

    public ListarParticipantes(Usuario usuario, Competencia competencia) {

        this(null, "", false, usuario, competencia);
    }

    public ListarParticipantes(Frame parent, String title, boolean modal,Usuario usuario, Competencia competencia) {
        super(parent, title, modal);
        try {
            this.usuarioAcatual=usuario;
            this.competenciaSeleccionada=competencia;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void jbInit() throws Exception {
        setResizable(false);
        CerrarVentana();
        tablaParticipantesJTable.setModel(modelo);
        cargarParticipantes();
        this.setSize(new Dimension(808, 627));
        this.getContentPane().setLayout( null );
        this.setTitle("Listado de Participantes");
        nombreCompetenciaJTextArea.setBounds(new Rectangle(225, 22, 375, 30));
        nombreCompetenciaJTextArea.setFont(new Font("Tahoma", 0, 15));
        nombreCompetenciaJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        
        // CARGAR NOMBRE DE LA COMPETENCIA
        nombreCompetenciaJTextArea.setText(competenciaSeleccionada.getNombreCompetencia());
        nombreCompetenciaJTextArea.setForeground(Color.blue);
        
        jLabelNombreCompetencia.setText("Nombre De La Competencia:");
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
        AltaParticipante ven = new AltaParticipante(competenciaSeleccionada);
        ven.setVisible(true);
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        VerCompetencia ven =new VerCompetencia(usuarioAcatual, competenciaSeleccionada);
        dispose();
        ven.setVisible(true);
    }

    private void modificarParticipanteJButton_actionPerformed(ActionEvent e) {
        ModificarParticipante ven = new ModificarParticipante();
        ven.setVisible(true);
    }

    private void eliminarPrticipanteJButton_actionPerformed(ActionEvent e) {
        int respuesta = JOptionPane.showOptionDialog(this, "¿Está seguro de que desea eliminar el Participante: Nombre Participante?.", "Eliminar Participante.", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null , new Object[]{"Si", "No"}, "Si");
        if (respuesta == 0){
        
            JOptionPane.showOptionDialog(null, "Se ha eliminado el participante nombre del participante de la competecnia Nombre Competencia "  , "Participante Eliminado.", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
        }  
    }
    private void cargarParticipantes(){
            for(int i=0; i<competenciaSeleccionada.getParticipantes().length;i++ ){
                    Vector <String> datos = new Vector <String>();
                    datos.add(competenciaSeleccionada.getParticipantes()[i].getNombre());
                    datos.add(competenciaSeleccionada.getParticipantes()[i].getNombre());
                    modelo.addRow(datos);
                }
        }
    private void CerrarVentana(){
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        VerCompetencia ven =new VerCompetencia(usuarioAcatual, competenciaSeleccionada);
        dispose();
        ven.setVisible(true);
    }
    });
    }
}
