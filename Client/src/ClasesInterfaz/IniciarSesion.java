package ClasesInterfaz;


import ClasesLogicas.Usuario;

import InterfazGrafica.CampoTexto.AreaTextoCorreo;

import InterfazGrafica.CampoTexto.AreaTextoPassword;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;


public class IniciarSesion extends JDialog {
    private AreaTextoCorreo correoElectronicoJTextArea = new AreaTextoCorreo(40);
    private JLabel jLabelCorreoElectrónico = new JLabel();
    private JLabel jLabelContraseña = new JLabel();
    private JPanel panelRegistrarseJPanel = new JPanel();
    private JButton regiistrarseJButton = new JButton();
    private JButton aceptarJButton = new JButton();
    private JButton cancelarJButton = new JButton();
    private JLabel jLabelLogo = new JLabel();
    private JLabel jLabelIngresoAlSistema = new JLabel();
    private AreaTextoPassword contraeñaJPasswordField = new AreaTextoPassword(10);
    private Usuario usuarioActual = null;

    public IniciarSesion() {
        this(null, "", false);
    }

    public IniciarSesion(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(950, 565));
        this.getContentPane().setLayout( null );
        this.setTitle("Iniciar Sesión");
        correoElectronicoJTextArea.setBounds(new Rectangle(505, 140, 375, 30));
        correoElectronicoJTextArea.setFont(new Font("Tahoma", 0, 13));
        correoElectronicoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelCorreoElectrónico.setText("Correo Electronico");
        jLabelCorreoElectrónico.setBounds(new Rectangle(320, 140, 175, 25));
        jLabelCorreoElectrónico.setFont(new Font("Tahoma", 0, 13));
        jLabelContraseña.setText("Contraseña");
        jLabelContraseña.setBounds(new Rectangle(320, 218, 175, 25));
        jLabelContraseña.setFont(new Font("Tahoma", 0, 13));
        panelRegistrarseJPanel.setBounds(new Rectangle(490, 285, 360, 105));
        panelRegistrarseJPanel.setLayout(null);
        panelRegistrarseJPanel.setBorder(BorderFactory.createTitledBorder("Si no esta regitrado, Registrese!"));
        panelRegistrarseJPanel.setFont(new Font("Dialog", 0, 50));
        regiistrarseJButton.setText("Registrarse");
        ImageIcon imagenCandado = new ImageIcon("Imagenes//bola8.png");
        regiistrarseJButton.setBounds(new Rectangle(105, 35, 110, 30));
        regiistrarseJButton.setFont(new Font("Tahoma", 0, 13));
        regiistrarseJButton.setAlignmentX((float) 10.0);
        regiistrarseJButton.setAlignmentY((float) 10.0);
        regiistrarseJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    regiistrarseJButton_actionPerformed(e);
                }
            });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(230, 425, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(535, 425, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        jLabelLogo.setBounds(new Rectangle(95, 135, 195, 160));

        jLabelLogo.setIcon(imagenCandado);
        jLabelIngresoAlSistema.setText("Ingreso Al Sistema");
        jLabelIngresoAlSistema.setBounds(new Rectangle(145, 35, 375, 70));
        jLabelIngresoAlSistema.setFont(new Font("Tahoma", 0, 42));
        contraeñaJPasswordField.setBounds(new Rectangle(505, 215, 375, 30));
        contraeñaJPasswordField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.getContentPane().add(contraeñaJPasswordField, null);
        this.getContentPane().add(jLabelLogo, null);
        this.getContentPane().add(jLabelIngresoAlSistema, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(aceptarJButton, null);
        panelRegistrarseJPanel.add(regiistrarseJButton, null);
        this.getContentPane().add(panelRegistrarseJPanel, null);
        this.getContentPane().add(jLabelContraseña, null);
        this.getContentPane().add(jLabelCorreoElectrónico, null);
        this.getContentPane().add(correoElectronicoJTextArea, null);


    }





    private void regiistrarseJButton_actionPerformed(ActionEvent e) {
        RegistrarUsuario nuevo= new RegistrarUsuario();
        nuevo.setVisible(true);
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }



    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    private void aceptarJButton_actionPerformed(ActionEvent e) {
        this.usuarioActual= new Usuario("corrientes@masfm.com","Olivera","Alejandro");
        
    }
}
