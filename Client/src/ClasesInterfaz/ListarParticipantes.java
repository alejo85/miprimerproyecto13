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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


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
        
        if(competenciaSeleccionada.getParticipantes()!=null)
            cargarParticipantes();
        
        this.setSize(new Dimension(770, 610));
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout( null );
        this.setTitle("Listado de Participantes");
        nombreCompetenciaJTextArea.setBounds(new Rectangle(245, 22, 375, 30));
        nombreCompetenciaJTextArea.setFont(new Font("Tahoma", 0, 15));
        nombreCompetenciaJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        
        // CARGAR NOMBRE DE LA COMPETENCIA
        nombreCompetenciaJTextArea.setText(competenciaSeleccionada.getNombreCompetencia());
        nombreCompetenciaJTextArea.setForeground(Color.blue);
        
        jLabelNombreCompetencia.setText("Nombre De La Competencia:");
        jLabelNombreCompetencia.setBounds(new Rectangle(45, 25, 255, 25));
        jLabelNombreCompetencia.setFont(new Font("Tahoma", 0, 15));
        participantesJPanel.setBounds(new Rectangle(45, 90, 490, 410));
        participantesJPanel.setLayout(null);
        participantesJPanel.setBorder(BorderFactory.createTitledBorder("Participantes"));
    
        jScrollPane1.setBounds(new Rectangle(35, 25, 425, 345));
        
        //BOTON ALTA
        altaParticipanteJButton.setText("Alta Participante");
        altaParticipanteJButton.setBounds(new Rectangle(570, 205, 165, 40));
        altaParticipanteJButton.setFont(new Font("Tahoma", 0, 13));
        altaParticipanteJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    altaParticipanteJButton_actionPerformed(e);
                }
            });
        
        
        //BOTON MODIFICAR
        modificarParticipanteJButton.setText("Modificar Participante");
        modificarParticipanteJButton.setBounds(new Rectangle(570, 255, 165, 40));
        modificarParticipanteJButton.setFont(new Font("Tahoma", 0, 13));
        modificarParticipanteJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    modificarParticipanteJButton_actionPerformed(e);
                }
            });
        
        // BOTON ELIMINAR
        eliminarPrticipanteJButton.setText("Eliminar Participante");
        eliminarPrticipanteJButton.setBounds(new Rectangle(570, 305, 165, 40));
        eliminarPrticipanteJButton.setFont(new Font("Tahoma", 0, 13));
        eliminarPrticipanteJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    eliminarPrticipanteJButton_actionPerformed(e);
                }
            });
        
        //BOTON CANCELAR
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(570, 520, 165, 40));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setActionCommand("Cancelar");
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
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
        AltaParticipante ven = new AltaParticipante(usuarioAcatual, competenciaSeleccionada);
        ven.setVisible(true);
        dispose();
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        VerCompetencia ven =new VerCompetencia(usuarioAcatual, competenciaSeleccionada);
        dispose();
        ven.setVisible(true);
    }

    private void modificarParticipanteJButton_actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Funcionalidad no disponible por el momento", "Modificar participante",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/en_construccion.png"));
    }

    private void eliminarPrticipanteJButton_actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Funcionalidad no disponible por el momento", "Eliminar participante",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/en_construccion.png"));
    }
    private void cargarParticipantes(){
           
            for(int i=0; i<competenciaSeleccionada.getParticipantes().length;i++ ){
                    Vector <String> datos = new Vector <String>();
                    datos.add(competenciaSeleccionada.getParticipantes()[i].getNombre());
                    datos.add(competenciaSeleccionada.getParticipantes()[i].getCorreo());
                    modelo.addRow(datos);
                }
            // ORDENA SEGUN COLUMNA SELECCIONADA
            TableRowSorter<DefaultTableModel> elQueOrdena1 = new TableRowSorter<DefaultTableModel>(modelo);
            tablaParticipantesJTable.setRowSorter(elQueOrdena1);
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
