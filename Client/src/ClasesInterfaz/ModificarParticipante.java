package ClasesInterfaz;

import ClasesLogicas.Participante;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class ModificarParticipante extends JDialog {
    private JTextArea nombreParticipanteJTextArea = new JTextArea();
    private JLabel jLabelNombreParticipante = new JLabel();
    private JTextArea correoElectrónicoJTextArea = new JTextArea();
    private JLabel jLabelCorreoElectrónico = new JLabel();
    private JButton examinarJButton = new JButton();
    private JTextArea imagenJTextArea = new JTextArea();
    private JLabel jLabelImagen = new JLabel();
    private JButton cancelarJButton = new JButton();
    private JButton aceptarJButton = new JButton();
    private Participante participanteActual=null;
    private Participante participanteNuevo=null;

    public ModificarParticipante(Participante participante) {
        this(null, "", false,participante);
    }

    public ModificarParticipante(Frame parent, String title, boolean modal,Participante participante) {
        super(parent, title, modal);
        try {
            participanteActual=participante;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
            public ModificarParticipante() {
                this(null, "", false);
            }

            public ModificarParticipante(Frame parent, String title, boolean modal ) {
                super(parent, title, modal);
                try {
     
                    jbInit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    private void jbInit() throws Exception {
        this.setSize(new Dimension(899, 335));
        this.getContentPane().setLayout( null );
        this.setTitle("Modificar  Participante");
        nombreParticipanteJTextArea.setBounds(new Rectangle(245, 50, 375, 30));
        nombreParticipanteJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreParticipanteJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelNombreParticipante.setText("Nombre");
        jLabelNombreParticipante.setBounds(new Rectangle(60, 45, 175, 25));
        jLabelNombreParticipante.setFont(new Font("Tahoma", 0, 13));
        correoElectrónicoJTextArea.setBounds(new Rectangle(245, 95, 375, 30));
        correoElectrónicoJTextArea.setFont(new Font("Tahoma", 0, 13));
        correoElectrónicoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelCorreoElectrónico.setText("Correo Electronico");
        jLabelCorreoElectrónico.setBounds(new Rectangle(60, 90, 175, 25));
        jLabelCorreoElectrónico.setFont(new Font("Tahoma", 0, 13));
        examinarJButton.setText("Examinar");
        examinarJButton.setBounds(new Rectangle(650, 145, 175, 30));
        examinarJButton.setFont(new Font("Tahoma", 0, 13));
        examinarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    examinarJButton_actionPerformed(e);
                }
            });
        imagenJTextArea.setBounds(new Rectangle(245, 145, 375, 30));
        imagenJTextArea.setFont(new Font("Tahoma", 0, 13));
        imagenJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelImagen.setText("Imagen (Opcional)");
        jLabelImagen.setBounds(new Rectangle(60, 140, 175, 25));
        jLabelImagen.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(510, 240, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(320, 240, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(jLabelImagen, null);
        this.getContentPane().add(imagenJTextArea, null);
        this.getContentPane().add(examinarJButton, null);
        this.getContentPane().add(jLabelCorreoElectrónico, null);
        this.getContentPane().add(correoElectrónicoJTextArea, null);
        this.getContentPane().add(jLabelNombreParticipante, null);
        this.getContentPane().add(nombreParticipanteJTextArea, null);
        }



        

        private void examinarJButton_actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        int resp = fc.showOpenDialog(this);

        if(resp == JFileChooser.APPROVE_OPTION){
            File archivo = fc.getSelectedFile();
            imagenJTextArea.setText(archivo.getAbsolutePath());
        }
        }

        private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        }
        }
