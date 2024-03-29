package ClasesInterfaz;

import ClasesGestores.CompetenciaGestor;
import ClasesGestores.ParticipanteGestor;

import ClasesLogicas.Competencia;
import ClasesLogicas.Participante;

import ClasesLogicas.Usuario;

import InterfazGrafica.CampoTexto.AreaTextoAlfabetico;

import InterfazGrafica.CampoTexto.AreaTextoCorreo;
import InterfazGrafica.CampoTexto.AreaTextoNombre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class AltaParticipante extends JDialog {
    private JTextField nombreParticipanteJTextArea = new JTextField();
    private JLabel jLabelNombreParticipante = new JLabel();
    private JTextField correoElectr�nicoJTextArea = new JTextField();
    private JLabel jLabelCorreoElectr�nico = new JLabel();
    private JButton examinarJButton = new JButton();
    private JTextArea imagenJTextArea = new JTextArea();
    private JLabel jLabelImagen = new JLabel();
    private JButton cancelarJButton = new JButton();
    private JButton aceptarJButton = new JButton();
    private Usuario usuarioActual=null;
    private Participante participanteNuevo=null;
    private Competencia competenciaSeleccionada=null;

    public AltaParticipante(Usuario usuario,Competencia competencia) {
        this(null, "", false, usuario,competencia);
    }

    public AltaParticipante(Frame parent, String title, boolean modal,Usuario usuario, Competencia competencia) {
        super(parent, title, modal);
        try {
            usuarioActual=usuario;
            competenciaSeleccionada=competencia;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        CerrarVentana();
        setResizable(false);
        this.setSize(new Dimension(500, 257));
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout( null );
        this.setTitle("Alta Participante");
        nombreParticipanteJTextArea.setBounds(new Rectangle(140, 15, 305, 30));
        nombreParticipanteJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreParticipanteJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nombreParticipanteJTextArea.setDocument(new LimitadorCaracteres(nombreParticipanteJTextArea,50));
        nombreParticipanteJTextArea.addFocusListener(new FocusAdapter() { 
            public void focusGained(FocusEvent evt) {     
                nombreParticipanteJTextArea.setForeground(Color.black);
                 nombreParticipanteJTextArea.setBackground(Color.white);
     } });
        jLabelNombreParticipante.setText("Nombre");
        jLabelNombreParticipante.setBounds(new Rectangle(10, 15, 175, 25));
        jLabelNombreParticipante.setFont(new Font("Tahoma", 0, 13));
        correoElectr�nicoJTextArea.setBounds(new Rectangle(140, 60, 305, 30));
        correoElectr�nicoJTextArea.setFont(new Font("Tahoma", 0, 13));
        correoElectr�nicoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        correoElectr�nicoJTextArea.setDocument(new LimitadorCaracteres(correoElectr�nicoJTextArea,40));
        correoElectr�nicoJTextArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK), "none");
        correoElectr�nicoJTextArea.addFocusListener(new FocusAdapter() { 
            public void focusGained(FocusEvent evt) { 
                correoElectr�nicoJTextArea.setForeground(Color.black);
                correoElectr�nicoJTextArea.setBackground(Color.white);
                    } });
        // TRANSFORMA EN MAYUSCULA
         correoElectr�nicoJTextArea.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                if(e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z'){
                     e.setKeyChar((char)(((int)e.getKeyChar()) - 32));
                }
            }
        });
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
        ListarParticipantes ven;
        ven = new ListarParticipantes(usuarioActual, competenciaSeleccionada);
        ven.setVisible(true);
        dispose();
    }

    private void aceptarJButton_actionPerformed(ActionEvent e) {
        String errores ="";
        // VALIDA CORREO ELECTRONICO
        if(correoElectr�nicoJTextArea.getText().equals("")){
            errores="<li>Debes ingresar un correo</li>";
            this.correoElectr�nicoJTextArea.setBackground(Color.red);
        }
        else if(!isEmail(correoElectr�nicoJTextArea.getText())){
            errores=errores+"<li>Correo electr�nico invalido</li>";
            this.correoElectr�nicoJTextArea.setBackground(Color.red);
        }
        if(nombreParticipanteJTextArea.getText().equals("")){
            errores=errores+"<li>Debes ingresar un nombre</li>";
            this.nombreParticipanteJTextArea.setBackground(Color.red);
        }
        else if(nombreParticipanteJTextArea.getText().length()<6){
            errores=errores+"<li>La longitud minima para el nombre es de 6</li>";
            this.nombreParticipanteJTextArea.setBackground(Color.red);
        }
        if(!CompetenciaGestor.validadNombreParticipante(nombreParticipanteJTextArea.getText(),competenciaSeleccionada.getIdCompetencia())){
            errores+="<li>El nombre del participante ya esta registrado</li>";
            this.correoElectr�nicoJTextArea.setBackground(Color.red);
        }
        if(errores.length()>0){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane pane = new JOptionPane("<html><h3>Tienes los siguientes errores:</h3><ul>"+errores+"</ul></html>", JOptionPane.ERROR_MESSAGE); 
                pane.setIcon(new ImageIcon("src/Imagenes/error.png"));
                JDialog dialog = pane.createDialog("Errores en los campos");
                int anchoPantalla = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(); // ancho de la pantalla
                int posicion= this.getLocationOnScreen().x;
                int anchoVentana= this.getHeight();
                
             if ((anchoPantalla-(posicion+anchoVentana) > posicion))
            {
                    dialog.setLocation(getLocationOnScreen().x + getWidth()+23 , getLocationOnScreen().y);
            }
            else
            {
                dialog.setLocation(getLocationOnScreen().x - pane.getWidth()-23, getLocationOnScreen().y);
            }
                dialog.setVisible(true);
        }
        else{
            Participante unParticipante =  ParticipanteGestor.agregarParticipante(nombreParticipanteJTextArea.getText(), correoElectr�nicoJTextArea.getText(), competenciaSeleccionada);
            // SE AGREGA EL PARTICIPANTE AL OBJETO COMPETENCIA LUEGO DE HABERLO INSERTADO EN LA BD
            competenciaSeleccionada.agregarParticipante(unParticipante);
            
            dispose();
            ListarParticipantes ven;
            ven = new ListarParticipantes(usuarioActual, competenciaSeleccionada);
            JOptionPane.showMessageDialog(null, "<html><h4>El participante ha sido de alta con �xito</h4></html>", "Alta de participante",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/exito.png"));
            ven.setVisible(true);
           
        }
    }
  
    private void CerrarVentana(){
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        ListarParticipantes ven;
        ven = new ListarParticipantes(usuarioActual, competenciaSeleccionada);
        ven.setVisible(true);
        dispose();
    }
    });
    }
    public boolean isEmail(String correo) {
           Pattern pat = null;
           Matcher mat = null;
           pat = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
           //otra expresion regular /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3,4})+$/
           //^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$ 
           mat = pat.matcher(correo);
           if (mat.find()) {
               return true;
           }else{
               return false;
           }
       }
}
