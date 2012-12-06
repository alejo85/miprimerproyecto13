package ClasesInterfaz;

import ClasesGestores.UsuarioGestor;

import ClasesLogicas.Usuario;

import InterfazGrafica.CampoTexto.AreaTextoCorreo;

import InterfazGrafica.CampoTexto.AreaTextoPassword;

import ClasesInterfaz.Central;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;


public class IniciarSesion extends JDialog {
    private AreaTextoCorreo correoElectronicoJTextArea = new AreaTextoCorreo(40);
    private JLabel jLabelCorreoElectrónico = new JLabel();
    private JLabel jLabelContraseña = new JLabel();
    private JLabel jLabelAclaracionErrores = new JLabel();
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
        // CAMBIAR COLOR DE FONDO
       // getContentPane().setBackground(new java.awt.Color(58,58,58));
        CerrarVentana();
        // TAMAÑO VENTANA
        this.setSize(new Dimension(530, 455));
        this.getContentPane().setLayout( null );
        this.setTitle("Iniciar Sesión");
        
        // TITULO FUNCIONALIDAD
        jLabelIngresoAlSistema.setText("Ingreso Al Sistema");
        jLabelIngresoAlSistema.setBounds(new Rectangle(145, 5, 375, 70));
        jLabelIngresoAlSistema.setFont(new Font("Tahoma", 0, 22));

        //CORREO ELECTRONICO TEXTO Y CAMPO
        jLabelCorreoElectrónico.setText("Correo Electrónico");
        jLabelCorreoElectrónico.setBounds(new Rectangle(10, 100, 175, 25));
        jLabelCorreoElectrónico.setFont(new Font("Tahoma", 0, 15));
        correoElectronicoJTextArea.setBounds(new Rectangle(135, 100, 365, 30));
        correoElectronicoJTextArea.setFont(new Font("Tahoma", 0, 15));
        correoElectronicoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        
        // CONTRASEÑA TEXTO Y CAMPO
        jLabelContraseña.setText("Contraseña");
        jLabelContraseña.setBounds(new Rectangle(10, 158, 175, 25));
        jLabelContraseña.setFont(new Font("Tahoma", 0, 15));
        contraeñaJPasswordField.setBounds(new Rectangle(135, 155, 365, 30));
        contraeñaJPasswordField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        
        // RECUADRO TEXTO Y BOTON
        panelRegistrarseJPanel.setBounds(new Rectangle(100, 260, 360, 105));
        panelRegistrarseJPanel.setLayout(null);
        panelRegistrarseJPanel.setBorder(BorderFactory.createTitledBorder("Si no esta regitrado, Registrese!"));
        panelRegistrarseJPanel.setFont(new Font("Dialog", 0, 50));
        regiistrarseJButton.setText("Registrarse");
        ImageIcon imagenCandado = new ImageIcon("Imagenes//bola8.png");
        regiistrarseJButton.setBounds(new Rectangle(115, 35, 110, 30));
        regiistrarseJButton.setFont(new Font("Tahoma", 0, 15));
        regiistrarseJButton.setAlignmentX((float) 10.0);
        regiistrarseJButton.setAlignmentY((float) 10.0);
        regiistrarseJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    regiistrarseJButton_actionPerformed(e);
                }
            });
        // BOTON ACEPTAR
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(130, 380, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        // BOTON CANCELAR
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(300, 380, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        
        //ACLARACION COMO SE MUESTRAN LOS ERRORES
        jLabelAclaracionErrores.setText("(*) Los campos con fondo rojo contienen errores");
        jLabelAclaracionErrores.setBounds(new Rectangle(110, 180, 375, 70));
        jLabelAclaracionErrores.setFont(new Font("Tahoma", 0, 15));
        jLabelAclaracionErrores.setForeground(Color.red);
        
        jLabelLogo.setBounds(new Rectangle(95, 135, 195, 160));

        jLabelLogo.setIcon(imagenCandado);

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
        this.getContentPane().add(jLabelAclaracionErrores, null);
    }

    private void regiistrarseJButton_actionPerformed(ActionEvent e) {
        RegistrarUsuario ven =  new RegistrarUsuario();
        ven.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose(); // cuando se cierra, se pierde los cambios realizados
        new Principal();
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
 
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    private void aceptarJButton_actionPerformed(ActionEvent e) {
        
       usuarioActual = UsuarioGestor.loguearseUsuario(this.correoElectronicoJTextArea.getTexto(), this.contraeñaJPasswordField.getPass());
       if(usuarioActual==null){
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showOptionDialog(null, "El correo electronico o la contraseña son incorrectos "  , "Error al Autencicar", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
           this.correoElectronicoJTextArea.error();
           this.contraeñaJPasswordField.error();
       }
       else{
           JOptionPane.showMessageDialog(null, "Has sido autenticado con éxito", "Ingreso al sistema",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("classes/Imagenes/check.png"));
           this.setVisible(false);
           System.out.println(this.getUsuarioActual().getApellido());
        
           new Principal(this.getUsuarioActual());
       }
       }
        
}
