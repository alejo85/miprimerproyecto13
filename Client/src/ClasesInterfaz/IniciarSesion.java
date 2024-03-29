package ClasesInterfaz;

import ClasesGestores.UsuarioGestor;

import ClasesLogicas.Usuario;

import InterfazGrafica.CampoTexto.AreaTextoCorreo;

import InterfazGrafica.CampoTexto.AreaTextoPassword;

import ClasesInterfaz.Central;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;


public class IniciarSesion extends JDialog {
    private JTextField correoElectronicoJTextArea = new JTextField();
    private JLabel jLabelCorreoElectr�nico = new JLabel();
    private JLabel jLabelContrase�a = new JLabel();
    private JLabel jLabelAclaracionErrores = new JLabel();
    private JPanel panelRegistrarseJPanel = new JPanel();
    private JButton regiistrarseJButton = new JButton();
    private JButton aceptarJButton = new JButton();
    private JButton cancelarJButton = new JButton();
    private JLabel jLabelLogo = new JLabel();
    private JLabel jLabelIngresoAlSistema = new JLabel();
    private AreaTextoPassword contrae�aJPasswordField = new AreaTextoPassword(10);
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
        setResizable(false);
        // CAMBIAR COLOR DE FONDO
       // getContentPane().setBackground(new java.awt.Color(58,58,58));
        CerrarVentana();
        // TAMA�O VENTANA
        this.setSize(new Dimension(530, 455));
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout( null );
        this.setTitle("Iniciar Sesi�n");
        
        // TITULO FUNCIONALIDAD
        jLabelIngresoAlSistema.setText("Ingreso Al Sistema");
        jLabelIngresoAlSistema.setBounds(new Rectangle(145, 5, 375, 70));
        jLabelIngresoAlSistema.setFont(new Font("Tahoma", 0, 22));

        //CORREO ELECTRONICO TEXTO Y CAMPO
        jLabelCorreoElectr�nico.setText("Correo Electr�nico");
        jLabelCorreoElectr�nico.setBounds(new Rectangle(10, 100, 175, 25));
        jLabelCorreoElectr�nico.setFont(new Font("Tahoma", 0, 15));
        correoElectronicoJTextArea.setBounds(new Rectangle(135, 100, 365, 30));
        correoElectronicoJTextArea.setFont(new Font("Tahoma", 0, 15));
        correoElectronicoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        correoElectronicoJTextArea.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        correoElectronicoJTextArea.setDocument(new LimitadorCaracteres(correoElectronicoJTextArea,40));
        correoElectronicoJTextArea.addFocusListener(new FocusAdapter() { public void focusGained(FocusEvent evt) { reescribir(evt); } });
        correoElectronicoJTextArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK), "none");
        
        // TRANSFORMA EN MAYUSCULA
         correoElectronicoJTextArea.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                if(e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z'){
                     e.setKeyChar((char)(((int)e.getKeyChar()) - 32));
                }
                }
            }
        );

         
        // CONTRASE�A TEXTO Y CAMPO
        jLabelContrase�a.setText("Contrase�a");
        jLabelContrase�a.setBounds(new Rectangle(10, 158, 175, 25));
        jLabelContrase�a.setFont(new Font("Tahoma", 0, 15));
        contrae�aJPasswordField.setBounds(new Rectangle(135, 155, 365, 30));
        contrae�aJPasswordField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        contrae�aJPasswordField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
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

        this.getContentPane().add(contrae�aJPasswordField, null);
        this.getContentPane().add(jLabelLogo, null);
        this.getContentPane().add(jLabelIngresoAlSistema, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(aceptarJButton, null);
        panelRegistrarseJPanel.add(regiistrarseJButton, null);
        this.getContentPane().add(panelRegistrarseJPanel, null);
        this.getContentPane().add(jLabelContrase�a, null);
        this.getContentPane().add(jLabelCorreoElectr�nico, null);
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
        dispose();
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
    // VALIDA CORREO
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
    public void reescribir(FocusEvent evt) {
     correoElectronicoJTextArea.setForeground(Color.black);
     correoElectronicoJTextArea.setBackground(Color.white);
    }
    private void aceptarJButton_actionPerformed(ActionEvent e) {
           String errores="";
            // VALIDA CORREO ELECTRONICO
            if(!isEmail(correoElectronicoJTextArea.getText())){
                    errores=errores+"<li>Correo electr�nico invalido</li>";
                }
            // VALIDA CONTRASE�A VACIA
            if((contrae�aJPasswordField.getPass()).equals("")){
                        errores=errores+"<li>Contrase�a vacia</li>";
             }
            // VALIDA LONGITUD MINIMA CONTRASE�A
            else if((contrae�aJPasswordField.getPass()).length()<6){
                 errores=errores+"<li>Longitud m�nima para contrase�a es de 6 car�cteres</li>";
            }
            
            if(errores.length()==0){
                  //BUSCA USUARIO
                   usuarioActual = UsuarioGestor.loguearseUsuario(this.correoElectronicoJTextArea.getText(), this.contrae�aJPasswordField.getPass());
                   
                   //SI NO EXISTE USUARIO
                   if(usuarioActual==null){
                       Toolkit.getDefaultToolkit().beep();
                       JOptionPane pane = new JOptionPane("<html><h4>El correo electronico o la<br /> contrase�a son incorrectos</h4></html>" , JOptionPane.ERROR_MESSAGE);  
                       pane.setIcon(new ImageIcon("src/Imagenes/error.png"));
                       JDialog dialog = pane.createDialog("Error al Autencicar");
                       
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
                       
                       this.correoElectronicoJTextArea.setBackground(Color.red);
                       this.contrae�aJPasswordField.error();
                   }
                   // SI EL USUARIO EXISTE Y LA CONTRASE�A CORRESPONDE AL MISMO
                   else{
                       dispose();
                       JOptionPane.showMessageDialog(null, "<html><h4>Has sido autenticado con �xito</h4></html>", "Ingreso al sistema",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/logueado.png"));
                       new Principal(this.getUsuarioActual());
                   }
            }
            else{
                Toolkit.getDefaultToolkit().beep();
                JOptionPane pane = new JOptionPane("<html><h3>Tienes los siguientes errores:</h3><ul>"+errores+"</ul></html>", JOptionPane.ERROR_MESSAGE);  
                pane.setIcon(new ImageIcon("src/Imagenes/error.png"));
                JDialog dialog = pane.createDialog("Error al Autencicar");
                
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
                
                this.correoElectronicoJTextArea.setBackground(Color.red);
                this.contrae�aJPasswordField.error();
            }
        }

        
}
