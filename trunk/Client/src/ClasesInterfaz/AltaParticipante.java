package ClasesInterfaz;

import ClasesGestores.CompetenciaGestor;
import ClasesGestores.ParticipanteGestor;

import ClasesLogicas.Competencia;
import ClasesLogicas.Participante;

import InterfazGrafica.CampoTexto.AreaTextoAlfabetico;

import InterfazGrafica.CampoTexto.AreaTextoCorreo;
import InterfazGrafica.CampoTexto.AreaTextoNombre;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class AltaParticipante extends JDialog {
    private AreaTextoNombre nombreParticipanteJTextArea = new AreaTextoNombre(50);
    private JLabel jLabelNombreParticipante = new JLabel();
    private AreaTextoCorreo correoElectr�nicoJTextArea = new AreaTextoCorreo(40);
    private JLabel jLabelCorreoElectr�nico = new JLabel();
    private JButton examinarJButton = new JButton();
    private JTextArea imagenJTextArea = new JTextArea();
    private JLabel jLabelImagen = new JLabel();
    private JButton cancelarJButton = new JButton();
    private JButton aceptarJButton = new JButton();
    private Participante participanteNuevo=null;
    private Competencia competenciaSeleccionada=null;

    public AltaParticipante(Competencia competencia) {
        this(null, "", false, competencia);
    }

    public AltaParticipante(Frame parent, String title, boolean modal, Competencia competencia) {
        super(parent, title, modal);
        try {
            competenciaSeleccionada=competencia;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        setResizable(false);
        this.setSize(new Dimension(500, 257));
        this.getContentPane().setLayout( null );
        this.setTitle("Alta Participante");
        nombreParticipanteJTextArea.setBounds(new Rectangle(140, 15, 305, 30));
        nombreParticipanteJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreParticipanteJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelNombreParticipante.setText("Nombre");
        jLabelNombreParticipante.setBounds(new Rectangle(10, 15, 175, 25));
        jLabelNombreParticipante.setFont(new Font("Tahoma", 0, 13));
        correoElectr�nicoJTextArea.setBounds(new Rectangle(140, 60, 305, 30));
        correoElectr�nicoJTextArea.setFont(new Font("Tahoma", 0, 13));
        correoElectr�nicoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelCorreoElectr�nico.setText("Correo Electronico");
        jLabelCorreoElectr�nico.setBounds(new Rectangle(10, 60, 175, 25));
        jLabelCorreoElectr�nico.setFont(new Font("Tahoma", 0, 13));
        examinarJButton.setText("...");
        examinarJButton.setBounds(new Rectangle(450, 113, 35, 25));
        examinarJButton.setFont(new Font("Tahoma", 0, 15));
        examinarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    examinarJButton_actionPerformed(e);
                }
            });
        imagenJTextArea.setBounds(new Rectangle(140, 110, 305, 30));
        imagenJTextArea.setFont(new Font("Tahoma", 0, 13));
        imagenJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelImagen.setText("Imagen (Opcional)");
        jLabelImagen.setBounds(new Rectangle(10, 110, 175, 25));
        jLabelImagen.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(300, 175, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(90, 175, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(jLabelImagen, null);
        this.getContentPane().add(imagenJTextArea, null);
        this.getContentPane().add(examinarJButton, null);
        this.getContentPane().add(jLabelCorreoElectr�nico, null);
        this.getContentPane().add(correoElectr�nicoJTextArea, null);
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
        /*ListarParticipantes ven;
        ven = new ListarParticipantes(usuarioActual, competencia);
        ven.setVisible(true);
        this.setVisible(false);
*/
    }

    private void aceptarJButton_actionPerformed(ActionEvent e) {
        String errores ="";
        if(!correoElectr�nicoJTextArea.getText().equals("")){
            if(!nombreParticipanteJTextArea.getText().equals("")){
               if(CompetenciaGestor.validadNombreParticipante(nombreParticipanteJTextArea.getText(),competenciaSeleccionada.getIdCompetencia())){
                 if(imagenJTextArea.getText().equals("")){
                        Participante unParticipante =  ParticipanteGestor.agregarParticipante(nombreParticipanteJTextArea.getText(), correoElectr�nicoJTextArea.getText(), competenciaSeleccionada);
                    }
                    
                      else
                      {
                              //Participante unParticipante =  ParticipanteGestor.agregarParticipante(nombreParticipanteJTextArea.getText(), correoElectr�nicoJTextArea.getText(), imagenJTextArea.getText());
                          }
                  }
                else{
                        errores+="\n\tEl nombre del participante ya esta registrado";
                    
                    
                    }
                
                
                }
            else{
                    nombreParticipanteJTextArea.error();
                    errores+="\n\tEl nombre del participante no puede ser  nulo";
                
                }
            
            }
        else
        {
                correoElectr�nicoJTextArea.error();
                errores+="\n\tEl correo electronico del participante no puede ser  nulo";
            }
        if(!errores.equals(""))
                Toolkit.getDefaultToolkit().beep();
                JOptionPane pane = new JOptionPane("Tienes los siguientes errores:"+errores , JOptionPane.ERROR_MESSAGE);  
                JDialog dialog = pane.createDialog("Errores en los campos");
                int anchoPantalla = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(); // ancho de la pantalla
                int posicion= this.getLocationOnScreen().x;
                int anchoVentana= this.getHeight();
                
                if ((anchoPantalla-(posicion+anchoVentana) > posicion))
                {
                        dialog.setLocation(getLocationOnScreen().x + getHeight()+200 , getLocationOnScreen().y);
                }
                else
                {
                        dialog.setLocation(getLocationOnScreen().x - 400, getLocationOnScreen().y);
                }
                dialog.setVisible(true);
            System.out.println(errores);
    }
}
