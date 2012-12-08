package ClasesInterfaz;


import ClasesBD.RecidenciaDB;

import ClasesGestores.UsuarioGestor;

import ClasesLogicas.Localidad;
import ClasesLogicas.Pais;
import ClasesLogicas.Regiones;

import InterfazGrafica.CampoTexto.AreaTextoApellido;
import InterfazGrafica.CampoTexto.AreaTextoCorreo;
import InterfazGrafica.CampoTexto.AreaTextoDocumento;
import InterfazGrafica.CampoTexto.AreaTextoNombre;
import InterfazGrafica.CampoTexto.AreaTextoPassword;

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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.SQLException;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RegistrarUsuario extends JDialog{
    private AreaTextoCorreo correoElectr�nicoJTextArea = new AreaTextoCorreo(40);
    private JLabel jLabelCorreoElectr�nico = new JLabel();
    private JLabel jLabelContrase�a = new JLabel();
    private AreaTextoPassword contrase�aJPasswordField = new AreaTextoPassword(10);
    private AreaTextoPassword repetirContrase�aJPasswordField = new AreaTextoPassword(10);
    private JLabel jLabelRepetirContrase�a = new JLabel();
    private AreaTextoApellido apellidoJTextArea = new AreaTextoApellido(50);
    private JLabel jLabelApellido = new JLabel();
    private AreaTextoNombre nombreJTextArea = new AreaTextoNombre(50);
    private JLabel jLabelNombre = new JLabel();
    private JLabel jLabelTipoDeDocumento = new JLabel();
    private JComboBox tipoDeDocumentoJComboBox = new JComboBox();
    private AreaTextoDocumento numeroDocumentoJTextArea = new AreaTextoDocumento(8);
    private JLabel jLabelNDocumento = new JLabel();
    private JLabel jLabelLocalidad = new JLabel();
    private JLabel jLabelProvincia = new JLabel();
    private JLabel jLabelPa�s = new JLabel();
    private JCheckBox aceptoT�rminosCondicionesUsoJCheckBox = new JCheckBox();
    private JButton aceptarJButton = new JButton();
    private JButton cancelarJButton = new JButton();
    private JComboBox paisJComboBox = new JComboBox();
    private JComboBox provinciaJComboBox = new JComboBox();
    private JComboBox localidadJComboBox = new JComboBox();
    private Vector <Pais> pais;
    private Vector <Regiones> region;
    private Vector <Localidad> localidades;
    private Color background = tipoDeDocumentoJComboBox.getBackground();
    private Color foreground = tipoDeDocumentoJComboBox.getForeground();
   
   
   


    public RegistrarUsuario() {
        this(null, "", false);
    }

    public RegistrarUsuario(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        setResizable(false);
        CerrarVentana();
        this.setSize(new Dimension(540, 600));
        this.setLocationRelativeTo(null);
        
        this.getContentPane().setLayout( null );
        this.setTitle("Registrar Usuario");
        correoElectr�nicoJTextArea.setBounds(new Rectangle(130, 20, 375, 30));
        correoElectr�nicoJTextArea.setFont(new Font("Tahoma", 0, 13));
        correoElectr�nicoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        correoElectr�nicoJTextArea.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        //LIMITAR LONGITUD DE CAMPOS
        //correoElectr�nicoJTextArea.setDocument(new LimitadorCaracteres(correoElectr�nicoJTextArea,40));
        // TODO TRANSFORMAR TODO A MAYUSCULA EN INGRESO DE CORREO
        jLabelCorreoElectr�nico.setText("Correo electr�nico");
        jLabelCorreoElectr�nico.setBounds(new Rectangle(15, 20, 135, 25));
        jLabelCorreoElectr�nico.setFont(new Font("Tahoma", 0, 13));
        jLabelContrase�a.setText("Contrase�a");
        jLabelContrase�a.setBounds(new Rectangle(15, 65, 135, 25));
        jLabelContrase�a.setFont(new Font("Tahoma", 0, 13));
        contrase�aJPasswordField.setBounds(new Rectangle(130, 65, 375, 30));
        contrase�aJPasswordField.setMinimumSize(new Dimension(5, 22));
        contrase�aJPasswordField.setFont(new Font("Tahoma", 0, 13));
        contrase�aJPasswordField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        contrase�aJPasswordField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        
        repetirContrase�aJPasswordField.setBounds(new Rectangle(130, 110, 375, 30));
        repetirContrase�aJPasswordField.setMinimumSize(new Dimension(5, 22));
        repetirContrase�aJPasswordField.setFont(new Font("Tahoma", 0, 13));
        repetirContrase�aJPasswordField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        repetirContrase�aJPasswordField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        
        jLabelRepetirContrase�a.setText("Repetir Contrase�a");
        jLabelRepetirContrase�a.setBounds(new Rectangle(15, 110, 135, 25));
        jLabelRepetirContrase�a.setFont(new Font("Tahoma", 0, 13));
        apellidoJTextArea.setBounds(new Rectangle(130, 155, 375, 30));
        apellidoJTextArea.setFont(new Font("Tahoma", 0, 13));
        apellidoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        apellidoJTextArea.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        
        jLabelApellido.setText("Apellido");
        jLabelApellido.setBounds(new Rectangle(15, 155, 135, 25));
        jLabelApellido.setFont(new Font("Tahoma", 0, 13));
        nombreJTextArea.setBounds(new Rectangle(130, 195, 375, 30));
        nombreJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nombreJTextArea.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        
        jLabelNombre.setText("Nombre");
        jLabelNombre.setBounds(new Rectangle(15, 195, 135, 25));
        jLabelNombre.setFont(new Font("Tahoma", 0, 13));
        jLabelTipoDeDocumento.setText("Tipo De Documento");
        jLabelTipoDeDocumento.setBounds(new Rectangle(15, 247, 135, 25));
        jLabelTipoDeDocumento.setFont(new Font("Tahoma", 0, 13));
        tipoDeDocumentoJComboBox.setBounds(new Rectangle(140, 245, 80, 30));
        tipoDeDocumentoJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        tipoDeDocumentoJComboBox.setMinimumSize(new Dimension(2, 18));
        tipoDeDocumentoJComboBox.setPreferredSize(new Dimension(2, 18));
        tipoDeDocumentoJComboBox.setSize(new Dimension(80, 30));
        tipoDeDocumentoJComboBox.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    tipoDeDocumentoJComboBox_focusGained(e);
                }
            });
        tipoDeDocumentoJComboBox.addItem("Tipo");
        tipoDeDocumentoJComboBox.addItem("DNI");
        tipoDeDocumentoJComboBox.addItem("LE");
        tipoDeDocumentoJComboBox.addItem("LC");
        tipoDeDocumentoJComboBox.addItem("PAS");
        numeroDocumentoJTextArea.setBounds(new Rectangle(360, 245, 145, 30));
        numeroDocumentoJTextArea.setFont(new Font("Tahoma", 0, 13));
        numeroDocumentoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        numeroDocumentoJTextArea.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        
        jLabelNDocumento.setText("N� De Documento");
        jLabelNDocumento.setBounds(new Rectangle(245, 245, 135, 25));
        jLabelNDocumento.setFont(new Font("Tahoma", 0, 13));
        jLabelLocalidad.setText("Localidad");
        jLabelLocalidad.setBounds(new Rectangle(15, 370, 135, 25));
        jLabelLocalidad.setFont(new Font("Tahoma", 0, 13));
        jLabelProvincia.setText("Provincia");
        jLabelProvincia.setBounds(new Rectangle(15, 330, 135, 25));
        jLabelProvincia.setFont(new Font("Tahoma", 0, 13));
        jLabelPa�s.setText("Pa�s");
        jLabelPa�s.setBounds(new Rectangle(15, 290, 135, 25));
        jLabelPa�s.setFont(new Font("Tahoma", 0, 13));
        aceptoT�rminosCondicionesUsoJCheckBox.setText("Acepto T�rminos y Condiciones de Uso");
        aceptoT�rminosCondicionesUsoJCheckBox.setBounds(new Rectangle(150, 445, 255, 30));
        aceptoT�rminosCondicionesUsoJCheckBox.setFont(new Font("Tahoma", 0, 13));
        aceptoT�rminosCondicionesUsoJCheckBox.setPreferredSize(new Dimension(240, 30));
        aceptoT�rminosCondicionesUsoJCheckBox.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    aceptoT�rminosCondicionesUsoJCheckBox_stateChanged(e);
                }
            });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(130, 500, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.setEnabled(false);

        aceptarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(300, 500, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        paisJComboBox.setBounds(new Rectangle(130, 290, 375, 30));
        paisJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        paisJComboBox.setMinimumSize(new Dimension(2, 18));
        paisJComboBox.setPreferredSize(new Dimension(2, 18));
        paisJComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    paisJComboBox_actionPerformed(e);
                }
            });

        paisJComboBox.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    paisJComboBox_focusGained(e);
                }
            });
        provinciaJComboBox.setBounds(new Rectangle(130, 330, 375, 30));
        provinciaJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        provinciaJComboBox.setMinimumSize(new Dimension(2, 18));
        provinciaJComboBox.setPreferredSize(new Dimension(2, 18));
        provinciaJComboBox.setSize(new Dimension(375, 30));
        provinciaJComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    provinciaJComboBox_actionPerformed(e);
                }
            });
        provinciaJComboBox.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    provinciaJComboBox_focusGained(e);
                }
            });
        localidadJComboBox.setBounds(new Rectangle(130, 370, 375, 30));
        localidadJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        localidadJComboBox.setMinimumSize(new Dimension(2, 18));
        localidadJComboBox.setPreferredSize(new Dimension(2, 18));
        localidadJComboBox.setSize(new Dimension(375, 30));

        localidadJComboBox.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    localidadJComboBox_focusGained(e);
                }
            });
        pais = RecidenciaDB.obtenerPaises();
        this.paisJComboBox.addItem("Seleccionar Pais");
        for(int i = 0; i< pais.size(); i++)
        {
            this.paisJComboBox.addItem(pais.elementAt(i).getNombre());
        }

        this.localidadJComboBox.addItem("Seleccionar Localidad");
        provinciaJComboBox.addItem("Seleccionar Provincia");
        this.getContentPane().add(localidadJComboBox, null);
        this.getContentPane().add(provinciaJComboBox, null);
        this.getContentPane().add(paisJComboBox, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(aceptoT�rminosCondicionesUsoJCheckBox, null);
        this.getContentPane().add(jLabelPa�s, null);
        this.getContentPane().add(jLabelProvincia, null);
        this.getContentPane().add(jLabelLocalidad, null);
        this.getContentPane().add(jLabelNDocumento, null);
        this.getContentPane().add(numeroDocumentoJTextArea, null);
        this.getContentPane().add(tipoDeDocumentoJComboBox, null);
        this.getContentPane().add(jLabelTipoDeDocumento, null);
        this.getContentPane().add(jLabelNombre, null);
        this.getContentPane().add(nombreJTextArea, null);
        this.getContentPane().add(apellidoJTextArea, null);
        this.getContentPane().add(jLabelApellido, null);
        this.getContentPane().add(jLabelRepetirContrase�a, null);
        this.getContentPane().add(repetirContrase�aJPasswordField, null);
        this.getContentPane().add(contrase�aJPasswordField, null);
        this.getContentPane().add(jLabelContrase�a, null);
        this.getContentPane().add(jLabelCorreoElectr�nico, null);
        this.getContentPane().add(correoElectr�nicoJTextArea, null);
       
    }




    private void cancelarJButton_actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose(); // cuando se cierra, se pierde los cambios realizados
        new Principal();
    }

    private void paisJComboBox_actionPerformed(ActionEvent e) {
       if(paisJComboBox.getSelectedIndex()>0)
       {
        cargarRegiones();
       }
       
       
    }
    private void CerrarVentana(){
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose(); // cuando se cierra, se pierde los cambios realizados
        new Principal();
    }
    });
    }
private void cargarRegiones()
{
   
        int idPais = this.paisJComboBox.getSelectedIndex();
        idPais--;
        int codigo = this.pais.get(idPais).getCodigo();
        try {
            region = RecidenciaDB.obtenerRegiones(codigo);
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }
        provinciaJComboBox.removeAllItems();
        provinciaJComboBox.addItem("Seleccionar Provincia");
        for(int i = 0; i< region.size(); i++)
        {
            this.provinciaJComboBox.addItem(region.elementAt(i).getNombre());
        }
    }

    private void provinciaJComboBox_actionPerformed(ActionEvent e) {
        if(provinciaJComboBox.getSelectedIndex()>0)
        {
         cargarLocalidades();
        }
       
    }
    private void cargarLocalidades(){

            int idRegion = this.provinciaJComboBox.getSelectedIndex();
            idRegion--;
            int codigo = this.region.get(idRegion).getCodigo();
           
            try {
                localidades = RecidenciaDB.obtenerLocalidades(codigo);
            } catch (SQLException f) {//todo
            System.out.println(f.getMessage());
            }
            localidadJComboBox.removeAllItems();
            localidadJComboBox.addItem("Seleccionar Localidad");
            if (localidades.size() == 0)
            {
                    this.localidadJComboBox.addItem(this.region.get(idRegion).getNombre());
                }
            else{
            for(int i = 0; i< localidades.size(); i++)
            {
                this.localidadJComboBox.addItem(localidades.elementAt(i).getNombre());
            }}
        }

    private Boolean datosValidosRegistro(){
        String errores="";
        
        // EXISTE USUARIO
        try {
            if(UsuarioGestor.existeUsuario(correoElectr�nicoJTextArea.getText())){
                errores= "\n\tEl correo ya se encuentra en uso ";
                this.correoElectr�nicoJTextArea.error();
            }
        } catch (SQLException e) {//todo
            System.out.println(e.getMessage());
        }
        // CORREO ELECTRONICO VACIO
        if(correoElectr�nicoJTextArea.getText().equals("")){
              this.correoElectr�nicoJTextArea.error();
              errores= errores +"\n\tCorreo electr�nico vacio ";
          }
        
        // CONTRASE�AS VACIAS
        if(this.contrase�aJPasswordField.getPass().equals("") || this.repetirContrase�aJPasswordField.getPass().equals("")){
              errores= errores +"\n\tLas contrase�as no deben ser vacias ";
              this.contrase�aJPasswordField.error();
              this.repetirContrase�aJPasswordField.error();
        }
        
        // CONTRASE�AS CON TAMA�O MENOR QUE SEIS
        else{
            if(this.contrase�aJPasswordField.getPass().length()<6){
                        this.contrase�aJPasswordField.error();
                        this.repetirContrase�aJPasswordField.error();
                        errores="\n\tLa longitud m�nima para las contrase�as es de 6 car�cteres ";
                    }
              }
        
        // CONTRASE�AS IGUALES
          if(!this.contrase�aJPasswordField.getPass().equals(this.repetirContrase�aJPasswordField.getPass())){
              errores= errores +"\n\tLas contrase�as no coinciden ";
                   this.contrase�aJPasswordField.error();
                   this.repetirContrase�aJPasswordField.error();
          }
          
          // APELLIDO VACIO
        if(apellidoJTextArea.getText().equals("")){
            this.apellidoJTextArea.error();
            errores=errores +"\n\tApellido no puede ser vacio ";
        }
        
        // NOMBRE VACIO
        if(nombreJTextArea.getText().equals("")){
            this.nombreJTextArea.error();
            errores=errores +"\n\tNombre no puede ser vacio ";
        }
        
       // NO SE SELECCIONO TIPO DE DOCUMENTO
        if(this.tipoDeDocumentoJComboBox.getSelectedItem().equals("Tipo")){
            errores=errores + "\n\tDebe seleccionar un tipo de documento ";
            tipoDeDocumentoJComboBox.setBackground(Color.red);
            tipoDeDocumentoJComboBox.setForeground(Color.white);
        }
        
        // N� DOCUMENTO VALIDO
        if(!numeroDocumentoJTextArea.esCorrecto()){
            numeroDocumentoJTextArea.error();
            errores=errores + "\n\tN�mero de documento inv�lido ";
        }
        
        // NO SE SELECCIONO PAIS
        if(this.paisJComboBox.getSelectedIndex()<1){
            errores=errores + "\n\tDebe Seleccionar Un Pais ";
            paisJComboBox.setBackground(Color.red);
            paisJComboBox.setForeground(Color.white);
        }
        
        // NO SE SELECCIONO PROVINCIA
        if(this.provinciaJComboBox.getSelectedIndex()<1){
            errores=errores + "\n\tDebe Seleccionar Una Provincia ";
            provinciaJComboBox.setBackground(Color.red);
            provinciaJComboBox.setForeground(Color.white);
        }
        
        // NO SE SELECCIONO LOCALIDAD
        if(this.localidadJComboBox.getSelectedIndex()<1){
            errores=errores + "\n\tDebe Seleccionar Una Localidad ";
            localidadJComboBox.setBackground(Color.red);
            localidadJComboBox.setForeground(Color.white);
        }



        if(errores.length()>0){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane pane = new JOptionPane("Tienes los siguientes errores:"+errores , JOptionPane.ERROR_MESSAGE);  
            JDialog dialog = pane.createDialog("Errores en campos");
            int anchoPantalla = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(); // ancho de la pantalla
            int posicion= this.getLocationOnScreen().x;
            int anchoVentana= this.getHeight();
            
            if ((anchoPantalla-(posicion+anchoVentana) > posicion))
            {
                    dialog.setLocation(getLocationOnScreen().x + getHeight() , getLocationOnScreen().y);
            }
            else
            {
                    dialog.setLocation(getLocationOnScreen().x - 450, getLocationOnScreen().y);
            }
            dialog.setVisible(true);
            return false;
        }
        else{
            return true;
        }

    }
   
    private void aceptoT�rminosCondicionesUsoJCheckBox_stateChanged(ChangeEvent e) {
       if (aceptoT�rminosCondicionesUsoJCheckBox.isSelected()==true) {
                   aceptarJButton.setEnabled(true);
               }
        else {
                   aceptarJButton.setEnabled(false);  
               }
    }
   
    private void aceptarJButton_actionPerformed(ActionEvent e) {
        Boolean datosValidos= false;
        datosValidos= datosValidosRegistro();
        if(datosValidos){
            int idLocalidad = this.localidadJComboBox.getSelectedIndex();
         idLocalidad--;
         int doc = Integer.parseInt(numeroDocumentoJTextArea.getTexto());
         UsuarioGestor.crearUsuario(correoElectr�nicoJTextArea.getText(),apellidoJTextArea.getText(),nombreJTextArea.getText(),(String)tipoDeDocumentoJComboBox.getSelectedItem(),doc,this.localidades.get(idLocalidad),this.contrase�aJPasswordField.getPass());
            JOptionPane.showMessageDialog(null, "Has sido registrado con �xito", "Registro de usuario",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/correcto2.png"));
         //FIJARSE SI ESTA BIEN QUE CSE CIERRE ASI
         dispose();
        new Principal();
        }
    }


    private void tipoDeDocumentoJComboBox_focusGained(FocusEvent e) {
        tipoDeDocumentoJComboBox.setBackground(background);
        tipoDeDocumentoJComboBox.setForeground(Color.black);
    }

    private void paisJComboBox_focusGained(FocusEvent e) {
        paisJComboBox.setBackground(background);
        paisJComboBox.setForeground(Color.black);
    }

    private void provinciaJComboBox_focusGained(FocusEvent e) {
        provinciaJComboBox.setBackground(background);
        provinciaJComboBox.setForeground(Color.black);
    }

    private void localidadJComboBox_focusGained(FocusEvent e) {
        localidadJComboBox.setBackground(background);
        localidadJComboBox.setForeground(Color.black);
    }
}
