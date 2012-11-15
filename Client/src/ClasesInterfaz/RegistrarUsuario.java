package ClasesInterfaz;


import ClasesBD.LocalidadesDB;

import ClasesBD.RegionesBD;

import ClasesLogicas.Localidad;
import ClasesLogicas.Pais;
import ClasesLogicas.Regiones;

import InterfazGrafica.CampoTexto.AreaTextoApellido;

import ClasesBD.RecidenciaDB;

import ClasesGestores.UsuarioGestor;

import InterfazGrafica.CampoTexto.AreaTextoCorreo;

import InterfazGrafica.CampoTexto.AreaTextoDocumento;
import InterfazGrafica.CampoTexto.AreaTextoPassword;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.sql.SQLException;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class RegistrarUsuario extends JDialog {
    private AreaTextoCorreo correoElectr�nicoJTextArea = new AreaTextoCorreo(40);
    private JLabel jLabelCorreoElectr�nico = new JLabel();
    private JLabel jLabelContrase�a = new JLabel();
    private AreaTextoPassword contrase�aJPasswordField = new AreaTextoPassword(10);
    private AreaTextoPassword repetirContrase�aJPasswordField = new AreaTextoPassword(10);
    private JLabel jLabelRepetirContrase�a = new JLabel();
    private AreaTextoApellido apellidoJTextArea = new AreaTextoApellido(20);
    private JLabel jLabelApellido = new JLabel();
    private JTextArea nombreJTextArea = new JTextArea();
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
        this.setSize(new Dimension(975, 689));
        this.getContentPane().setLayout( null );
        this.setTitle("Registrar Usuario");
        correoElectr�nicoJTextArea.setBounds(new Rectangle(350, 40, 375, 30));
        correoElectr�nicoJTextArea.setFont(new Font("Tahoma", 0, 13));
        correoElectr�nicoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelCorreoElectr�nico.setText("Correo electr�nico");
        jLabelCorreoElectr�nico.setBounds(new Rectangle(215, 40, 135, 25));
        jLabelCorreoElectr�nico.setFont(new Font("Tahoma", 0, 13));
        jLabelContrase�a.setText("Contrase�a");
        jLabelContrase�a.setBounds(new Rectangle(215, 85, 135, 25));
        jLabelContrase�a.setFont(new Font("Tahoma", 0, 13));
        contrase�aJPasswordField.setBounds(new Rectangle(350, 85, 375, 30));
        contrase�aJPasswordField.setMinimumSize(new Dimension(5, 22));
        contrase�aJPasswordField.setFont(new Font("Tahoma", 0, 13));
        contrase�aJPasswordField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        repetirContrase�aJPasswordField.setBounds(new Rectangle(350, 130, 375, 30));
        repetirContrase�aJPasswordField.setMinimumSize(new Dimension(5, 22));
        repetirContrase�aJPasswordField.setFont(new Font("Tahoma", 0, 13));
        repetirContrase�aJPasswordField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelRepetirContrase�a.setText("Repetir Contrase�a");
        jLabelRepetirContrase�a.setBounds(new Rectangle(215, 130, 135, 25));
        jLabelRepetirContrase�a.setFont(new Font("Tahoma", 0, 13));
        apellidoJTextArea.setBounds(new Rectangle(350, 175, 375, 30));
        apellidoJTextArea.setFont(new Font("Tahoma", 0, 13));
        apellidoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelApellido.setText("Apellido");
        jLabelApellido.setBounds(new Rectangle(215, 175, 135, 25));
        jLabelApellido.setFont(new Font("Tahoma", 0, 13));
        nombreJTextArea.setBounds(new Rectangle(350, 215, 375, 30));
        nombreJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelNombre.setText("Nombre");
        jLabelNombre.setBounds(new Rectangle(215, 215, 135, 25));
        jLabelNombre.setFont(new Font("Tahoma", 0, 13));
        jLabelTipoDeDocumento.setText("Tipo De Documento");
        jLabelTipoDeDocumento.setBounds(new Rectangle(215, 260, 135, 25));
        jLabelTipoDeDocumento.setFont(new Font("Tahoma", 0, 13));
        tipoDeDocumentoJComboBox.setBounds(new Rectangle(350, 265, 80, 30));
        tipoDeDocumentoJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        tipoDeDocumentoJComboBox.setMinimumSize(new Dimension(2, 18));
        tipoDeDocumentoJComboBox.setPreferredSize(new Dimension(2, 18));
        tipoDeDocumentoJComboBox.setSize(new Dimension(80, 30));
        tipoDeDocumentoJComboBox.addItem("Tipo");
        tipoDeDocumentoJComboBox.addItem("DNI");
        tipoDeDocumentoJComboBox.addItem("LE");
        tipoDeDocumentoJComboBox.addItem("LC");
        tipoDeDocumentoJComboBox.addItem("PAS");
        numeroDocumentoJTextArea.setBounds(new Rectangle(580, 265, 145, 30));
        numeroDocumentoJTextArea.setFont(new Font("Tahoma", 0, 13));
        numeroDocumentoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelNDocumento.setText("N� De Documento");
        jLabelNDocumento.setBounds(new Rectangle(445, 265, 135, 25));
        jLabelNDocumento.setFont(new Font("Tahoma", 0, 13));
        jLabelLocalidad.setText("Localidad");
        jLabelLocalidad.setBounds(new Rectangle(215, 390, 135, 25));
        jLabelLocalidad.setFont(new Font("Tahoma", 0, 13));
        jLabelProvincia.setText("Provincia");
        jLabelProvincia.setBounds(new Rectangle(215, 350, 135, 25));
        jLabelProvincia.setFont(new Font("Tahoma", 0, 13));
        jLabelPa�s.setText("Pa�s");
        jLabelPa�s.setBounds(new Rectangle(215, 310, 135, 25));
        jLabelPa�s.setFont(new Font("Tahoma", 0, 13));
        aceptoT�rminosCondicionesUsoJCheckBox.setText("Acepto T�rminos y Condiciones de Uso");
        aceptoT�rminosCondicionesUsoJCheckBox.setBounds(new Rectangle(335, 445, 255, 30));
        aceptoT�rminosCondicionesUsoJCheckBox.setFont(new Font("Tahoma", 0, 13));
        aceptoT�rminosCondicionesUsoJCheckBox.setPreferredSize(new Dimension(240, 30));
        aceptoT�rminosCondicionesUsoJCheckBox.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    aceptoT�rminosCondicionesUsoJCheckBox_stateChanged(e);
                }
            });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(330, 520, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.setEnabled(false);

        aceptarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(525, 520, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        paisJComboBox.setBounds(new Rectangle(350, 310, 375, 30));
        paisJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        paisJComboBox.setMinimumSize(new Dimension(2, 18));
        paisJComboBox.setPreferredSize(new Dimension(2, 18));
        paisJComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    paisJComboBox_actionPerformed(e);
                }
            });

        provinciaJComboBox.setBounds(new Rectangle(350, 350, 375, 30));
        provinciaJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        provinciaJComboBox.setMinimumSize(new Dimension(2, 18));
        provinciaJComboBox.setPreferredSize(new Dimension(2, 18));
        provinciaJComboBox.setSize(new Dimension(375, 30));
        provinciaJComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    provinciaJComboBox_actionPerformed(e);
                }
            });
        localidadJComboBox.setBounds(new Rectangle(350, 390, 375, 30));
        localidadJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        localidadJComboBox.setMinimumSize(new Dimension(2, 18));
        localidadJComboBox.setPreferredSize(new Dimension(2, 18));
        localidadJComboBox.setSize(new Dimension(375, 30));
    
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
        this.setVisible(false);
    }

    private void paisJComboBox_actionPerformed(ActionEvent e) {
       if(paisJComboBox.getSelectedIndex()>0)
       {
        cargarRegiones();
       }
       
       
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
            } catch (SQLException f) {
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




    private void aceptoT�rminosCondicionesUsoJCheckBox_stateChanged(ChangeEvent e) {
        
        
        if (aceptoT�rminosCondicionesUsoJCheckBox.isSelected()==true) {
                   aceptarJButton.setEnabled(true);
               } 
        else {
                   aceptarJButton.setEnabled(false);   
               }
    }
    
    private void aceptarJButton_actionPerformed(ActionEvent e) {
            if(!this.contrase�aJPasswordField.getPassword().equals(this.repetirContrase�aJPasswordField.getPassword())){
                 this.contrase�aJPasswordField.error(); 
                 this.repetirContrase�aJPasswordField.error(); 
             }
            if(this.tipoDeDocumentoJComboBox.getSelectedItem().equals("Tipo")){
                JOptionPane.showOptionDialog(null, "Debes seleccionar un tipo de documento, �Acordarse de generar un metodo para rellenar el campo con rojo para este error!"  , "Campos no seleccionados", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
            }
            System.out.println(nombreJTextArea.getText());
            System.out.println(apellidoJTextArea.getText());
            System.out.println(correoElectr�nicoJTextArea.getText());
            System.out.println(contrase�aJPasswordField.getPassword());
            System.out.println(repetirContrase�aJPasswordField.getPassword());
            System.out.println(tipoDeDocumentoJComboBox.getSelectedItem());
            System.out.println(numeroDocumentoJTextArea.getText());
            System.out.println(localidadJComboBox.getSelectedItem());
            int idLocalidad = this.localidadJComboBox.getSelectedIndex();
            idLocalidad--;
           
            UsuarioGestor.crearUsuario(correoElectr�nicoJTextArea.getText(),apellidoJTextArea.getText(),nombreJTextArea.getText(),tipoDeDocumentoJComboBox.getSelectedItem(),numeroDocumentoJTextArea.getText(),this.localidades.get(idLocalidad),this.contrase�aJPasswordField.getPassword());
        }
    
}