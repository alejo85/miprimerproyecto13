

package ClasesInterfaz;


import ClasesLogicas.Usuario;

import InterfazGrafica.CampoTexto.AreaTextoApellido;
import InterfazGrafica.CampoTexto.AreaTextoCorreo;
import InterfazGrafica.CampoTexto.AreaTextoDocumento;
import InterfazGrafica.CampoTexto.AreaTextoNombre;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;


public class ModificarUsuario extends JDialog {
    private AreaTextoCorreo correoElectrónicoJTextArea = new AreaTextoCorreo(40);
    private JLabel jLabelCorreoElectrónico = new JLabel();
    private AreaTextoApellido apellidoJTextArea = new AreaTextoApellido(50);
    private JLabel jLabelApellido = new JLabel();
    private AreaTextoNombre nombreJTextArea = new AreaTextoNombre(50);
    private JLabel jLabelNombre = new JLabel();
    private JLabel jLabelTipoDeDocumento = new JLabel();
    private JComboBox tipoDeDocumentoJComboBox = new JComboBox();
    private AreaTextoDocumento numeroDocumentoJTextArea = new AreaTextoDocumento(9);
    private JLabel jLabelNDocumento = new JLabel();
    private JLabel jLabelLocalidad = new JLabel();
    private JLabel jLabelProvincia = new JLabel();
    private JLabel jLabelPaís = new JLabel();
    private JButton aceptarJButton = new JButton();
    private JButton cancelarJButton = new JButton();
    private JComboBox paisJComboBox = new JComboBox();
    private JComboBox provinciaJComboBox = new JComboBox();
    private JComboBox localidadJComboBox = new JComboBox();
    private Usuario usuarioActual=null;

    public ModificarUsuario(Usuario usuario ) {
        
        this(null, "", false,usuario);
    }

    public ModificarUsuario(Frame parent, String title, boolean modal,Usuario usuario) {
        super(parent, title, modal);
        try {
            this.usuarioActual=usuario;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(769, 512));
        this.getContentPane().setLayout( null );
        this.setTitle("Modificar Usuario");
        correoElectrónicoJTextArea.setBounds(new Rectangle(255, 45, 375, 30));
        correoElectrónicoJTextArea.setFont(new Font("Tahoma", 0, 13));
        correoElectrónicoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelCorreoElectrónico.setText("Correo electrónico");
        jLabelCorreoElectrónico.setBounds(new Rectangle(120, 45, 135, 25));
        jLabelCorreoElectrónico.setFont(new Font("Tahoma", 0, 13));
        apellidoJTextArea.setBounds(new Rectangle(255, 90, 375, 30));
        apellidoJTextArea.setFont(new Font("Tahoma", 0, 13));
        apellidoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelApellido.setText("Apellido");
        jLabelApellido.setBounds(new Rectangle(120, 90, 135, 25));
        jLabelApellido.setFont(new Font("Tahoma", 0, 13));
        nombreJTextArea.setBounds(new Rectangle(255, 130, 375, 30));
        nombreJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelNombre.setText("Nombre");
        jLabelNombre.setBounds(new Rectangle(120, 130, 135, 25));
        jLabelNombre.setFont(new Font("Tahoma", 0, 13));
        jLabelTipoDeDocumento.setText("Tipo De Documento");
        jLabelTipoDeDocumento.setBounds(new Rectangle(120, 175, 135, 25));
        jLabelTipoDeDocumento.setFont(new Font("Tahoma", 0, 13));
        tipoDeDocumentoJComboBox.setBounds(new Rectangle(255, 180, 80, 30));
        tipoDeDocumentoJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        tipoDeDocumentoJComboBox.setMinimumSize(new Dimension(2, 18));
        tipoDeDocumentoJComboBox.setPreferredSize(new Dimension(2, 18));
        tipoDeDocumentoJComboBox.setSize(new Dimension(80, 30));
        numeroDocumentoJTextArea.setBounds(new Rectangle(485, 180, 145, 30));
        numeroDocumentoJTextArea.setFont(new Font("Tahoma", 0, 13));
        numeroDocumentoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelNDocumento.setText("Nº De Documento");
        jLabelNDocumento.setBounds(new Rectangle(350, 180, 135, 25));
        jLabelNDocumento.setFont(new Font("Tahoma", 0, 13));
        jLabelLocalidad.setText("Localidad");
        jLabelLocalidad.setBounds(new Rectangle(120, 305, 135, 25));
        jLabelLocalidad.setFont(new Font("Tahoma", 0, 13));
        jLabelProvincia.setText("Provincia");
        jLabelProvincia.setBounds(new Rectangle(120, 265, 135, 25));
        jLabelProvincia.setFont(new Font("Tahoma", 0, 13));
        jLabelPaís.setText("País");
        jLabelPaís.setBounds(new Rectangle(120, 225, 135, 25));
        jLabelPaís.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(240, 390, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(435, 390, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        paisJComboBox.setBounds(new Rectangle(255, 225, 375, 30));
        paisJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        paisJComboBox.setMinimumSize(new Dimension(2, 18));
        paisJComboBox.setPreferredSize(new Dimension(2, 18));
        provinciaJComboBox.setBounds(new Rectangle(255, 265, 375, 30));
        provinciaJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        provinciaJComboBox.setMinimumSize(new Dimension(2, 18));
        provinciaJComboBox.setPreferredSize(new Dimension(2, 18));
        provinciaJComboBox.setSize(new Dimension(375, 30));
        localidadJComboBox.setBounds(new Rectangle(255, 305, 375, 30));
        localidadJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        localidadJComboBox.setMinimumSize(new Dimension(2, 18));
        localidadJComboBox.setPreferredSize(new Dimension(2, 18));
        localidadJComboBox.setSize(new Dimension(375, 30));
        this.getContentPane().add(localidadJComboBox, null);
        this.getContentPane().add(provinciaJComboBox, null);
        this.getContentPane().add(paisJComboBox, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(jLabelPaís, null);
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
        this.getContentPane().add(jLabelCorreoElectrónico, null);
        this.getContentPane().add(correoElectrónicoJTextArea, null);
    }




        private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        }
        }
