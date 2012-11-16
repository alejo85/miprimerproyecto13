package ClasesInterfaz;

import ClasesGestores.UsuarioGestor;

import ClasesLogicas.Usuario;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class Central extends JFrame {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenu competencia = new JMenu();
    private JMenu lugar = new JMenu();
    private Usuario usuarioActual=null;
    private JMenuItem menuFileExit = new JMenuItem();
    private JMenuItem iniciarSecion = new JMenuItem();
    private JMenuItem modificar = new JMenuItem();
    private JMenuItem buscarCompetencia = new JMenuItem();
    private JMenuItem buscarTodasLasCompetencias = new JMenuItem();
    private JMenuItem buscarLugarDeRealizacion = new JMenuItem();
    private JMenuItem registrarse = new JMenuItem();
    private JMenu menuHelp = new JMenu();
    private JMenuItem menuHelpAbout = new JMenuItem();
    private JLabel jLabelBienvenidos = new JLabel();
    private JLabel logoJLabel = new JLabel();
    private JLabel jLabelSistemaDeGestiónDeCompetenciasDeportivas = new JLabel();
    private JTextArea usuarioJTextArea = new JTextArea();
    private JLabel jLabelUsuario = new JLabel();
    private JButton modificarUsuarioJButton = new JButton();
    private JButton iniciarSesiónJButton = new JButton();
    private JButton registrarseJButton = new JButton();
    private JPanel lugarDeRealizaciónJPanel = new JPanel();
    private JButton listarLugarDeRealizaciónJButton = new JButton();
    private JPanel competenciaJPanel = new JPanel();
    private JButton buscarCompetenciaJButton = new JButton();
    private JButton buscarTodasLasCompetenciasJButton = new JButton();
    private JButton salirJButton = new JButton();

    public Central() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setJMenuBar( menuBar );
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(1019, 698));
        this.setTitle( "Sistema De Gestión De Competencias" );
        menuFile.setText( "Archivo" );
        menuFileExit.setText( "Salir" );
        iniciarSecion.setText("Iniciar Sesión");
        modificar.setText("Modificar");
        buscarCompetencia.setText("Buscar Competencias");
        buscarTodasLasCompetencias.setText("Buscar Todas las Competencias");
        competencia.setText("Competencia");
        usuarioJTextArea.setEditable(false);
        modificar.addActionListener(new ActionListener(){public void actionPerformed( ActionEvent ae ) { modificar_ActionPerformed( ae ); } });
        lugar.setText("Lugar de Realización");
        registrarse.setText("Registrarse");
        registrarse.addActionListener(new ActionListener(){public void actionPerformed( ActionEvent ae ) { registrarse_ActionPerformed( ae ); } });
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        menuHelp.setText( "Ayuda" );
        buscarLugarDeRealizacion.setText("Buscar Lugar de Realización");
        menuHelpAbout.setText( "Acerca de..." );
        menuHelpAbout.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { helpAbout_ActionPerformed( ae ); } } );
        ImageIcon imagenCandado = new ImageIcon("Imagenes//bola8.png");
        jLabelBienvenidos.setText("Bienvienidos");
        jLabelBienvenidos.setBounds(new Rectangle(95, 10, 250, 70));
        jLabelBienvenidos.setFont(new Font("Tahoma", 0, 42));
        logoJLabel.setBounds(new Rectangle(130, 95, 195, 160));
        logoJLabel.setIcon(imagenCandado);
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setText("<html>Sistema de Gestión de Competencias Deportivas</html>");
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setBounds(new Rectangle(485, 155, 450, 120));
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setFont(new Font("Tahoma", 0, 38));
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabelUsuario.setText("Usuario:");
        usuarioJTextArea.setBounds(new Rectangle(490, 5, 270, 35));
        usuarioJTextArea.setFont(new Font("Tahoma", 0, 16));
        usuarioJTextArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 1, 1));
        
        if(usuarioActual==null){
        usuarioJTextArea.setText("No autenticado");
        }
        else{
            usuarioJTextArea.setText(usuarioActual.getCorreoElectronico());
        }

        jLabelUsuario.setBounds(new Rectangle(435, 10, 75, 25));
        jLabelUsuario.setFont(new Font("Tahoma", 0, 13));
        jLabelUsuario.setText("Usuario:");
        modificarUsuarioJButton.setText("Modificar");
        modificarUsuarioJButton.setBounds(new Rectangle(820, 10, 135, 30));
        modificarUsuarioJButton.setFont(new Font("Tahoma", 0, 13));
        modificarUsuarioJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar5_actionPerformed(e);
                }
            });
        iniciarSesiónJButton.setBounds(new Rectangle(820, 55, 135, 30));
        iniciarSesiónJButton.setFont(new Font("Tahoma", 0, 13));
        iniciarSesiónJButton.setText("Iniciar Sesión");
        iniciarSesiónJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar6_actionPerformed(e);
                }
            });
        registrarseJButton.setText("Registrarse");
        registrarseJButton.setBounds(new Rectangle(820, 95, 135, 30));
        registrarseJButton.setFont(new Font("Tahoma", 0, 13));
        registrarseJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar7_actionPerformed(e);
                }
            });
        lugarDeRealizaciónJPanel.setBounds(new Rectangle(50, 305, 385, 255));
        lugarDeRealizaciónJPanel.setLayout(null);
        lugarDeRealizaciónJPanel.setBorder(BorderFactory.createTitledBorder("Lugar de Realización"));
        lugarDeRealizaciónJPanel.setFont(new Font("Dialog", 0, 50));
        listarLugarDeRealizaciónJButton.setBounds(new Rectangle(30, 85, 330, 95));
        listarLugarDeRealizaciónJButton.setFont(new Font("Tahoma", 0, 13));
        listarLugarDeRealizaciónJButton.setText("Listar Lugar De Realización");
        listarLugarDeRealizaciónJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar8_actionPerformed(e);
                }
            });
        competenciaJPanel.setBounds(new Rectangle(505, 295, 420, 265));
        competenciaJPanel.setLayout(null);
        competenciaJPanel.setBorder(BorderFactory.createTitledBorder("Competencia"));
        competenciaJPanel.setFont(new Font("Dialog", 0, 50));
        buscarCompetenciaJButton.setBounds(new Rectangle(555, 315, 330, 95));
        buscarCompetenciaJButton.setFont(new Font("Tahoma", 0, 13));
        buscarCompetenciaJButton.setText("Buscar Competencia");
        buscarCompetenciaJButton.setActionCommand("");
        buscarCompetenciaJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar9_actionPerformed(e);
                }
            });
        buscarTodasLasCompetenciasJButton.setBounds(new Rectangle(555, 440, 330, 95));
        buscarTodasLasCompetenciasJButton.setFont(new Font("Tahoma", 0, 13));
        buscarTodasLasCompetenciasJButton.setText("Buscar Todas Las Competencias");
        buscarTodasLasCompetenciasJButton.setActionCommand("");
        buscarTodasLasCompetenciasJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar10_actionPerformed(e);
                }
            });
        salirJButton.setText("Salir");
        salirJButton.setBounds(new Rectangle(755, 590, 110, 30));
        salirJButton.setFont(new Font("Tahoma", 0, 13));
        salirJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar2_actionPerformed(e);
                }
            });
        iniciarSecion.addActionListener(new ActionListener() { public void actionPerformed( ActionEvent ae ) { iniciarSecion_ActionPerformed( ae ); } });
        buscarCompetencia.addActionListener(new ActionListener() { public void actionPerformed( ActionEvent ae ) { buscarCompetencia_ActionPerformed( ae ); } });
        buscarTodasLasCompetencias.addActionListener(new ActionListener() { public void actionPerformed( ActionEvent ae ) { buscarTodasLasCompetencias_ActionPerformed( ae ); } });
        buscarLugarDeRealizacion.addActionListener(new ActionListener() { public void actionPerformed( ActionEvent ae ) { buscarLugarDeRealizacion_ActionPerformed( ae ); } });
        menuFile.add(iniciarSecion);
        menuFile.add(registrarse);
        menuFile.add(modificar);
        menuFile.add( menuFileExit );
        competencia.add(buscarCompetencia);
        competencia.add(buscarTodasLasCompetencias);
        lugar.add(buscarLugarDeRealizacion);
        menuBar.add( menuFile );
        menuBar.add(competencia);
        menuBar.add(lugar);

                



        menuHelp.add( menuHelpAbout );
        menuBar.add( menuHelp );
        this.getContentPane().add(salirJButton, null);
        this.getContentPane().add(buscarTodasLasCompetenciasJButton, null);
        this.getContentPane().add(buscarCompetenciaJButton, null);
        this.getContentPane().add(competenciaJPanel, null);
        lugarDeRealizaciónJPanel.add(listarLugarDeRealizaciónJButton, null);
        this.getContentPane().add(lugarDeRealizaciónJPanel, null);
        this.getContentPane().add(registrarseJButton, null);
        this.getContentPane().add(iniciarSesiónJButton, null);
        this.getContentPane().add(modificarUsuarioJButton, null);
        this.getContentPane().add(jLabelUsuario, null);
        this.getContentPane().add(usuarioJTextArea, null);
        this.getContentPane().add(jLabelSistemaDeGestiónDeCompetenciasDeportivas, null);
        this.getContentPane().add(logoJLabel, null);
        this.getContentPane().add(jLabelBienvenidos, null);
        

    }

    void fileExit_ActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    void helpAbout_ActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, new Central_AboutBoxPanel1(), "Acerca de", JOptionPane.PLAIN_MESSAGE);
    }
     void registrarse_ActionPerformed (ActionEvent e){
            RegistrarUsuario nuevo= new RegistrarUsuario();
            nuevo.setVisible(true);
            }
    void modificar_ActionPerformed (ActionEvent e){
           ModificarUsuario nuevo= new ModificarUsuario(usuarioActual);
           nuevo.setVisible(true);
           }
    void buscarCompetencia_ActionPerformed (ActionEvent e){
           BuscarCompetenciaDeportiva nuevo= new BuscarCompetenciaDeportiva(usuarioActual);
           nuevo.setVisible(true);
           }
    void buscarTodasLasCompetencias_ActionPerformed (ActionEvent e){
           BuscarTodasLasCompetenciaDeportiva nuevo= new BuscarTodasLasCompetenciaDeportiva(usuarioActual);
           nuevo.setVisible(true);
           }
    
    
    void buscarLugarDeRealizacion_ActionPerformed (ActionEvent e){
           BuscarLugareDeRealizacion nuevo= new BuscarLugareDeRealizacion();
           nuevo.setVisible(true);
           }
    void iniciarSecion_ActionPerformed (ActionEvent e){
           IniciarSesion nuevo= new IniciarSesion();
           nuevo.setVisible(true);
    }

    private void jButtonAceptar2_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void jButtonAceptar5_actionPerformed(ActionEvent e) {
        JOptionPane.showOptionDialog(null, "Funcionalidad No disponible"  , "Funcionalidad No disponible", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
        /*ModificarUsuario ven = new ModificarUsuario(usuarioActual);
        ven.setVisible(true);*/
    }

    private void jButtonAceptar6_actionPerformed(ActionEvent e) {
        IniciarSesion ven = new IniciarSesion();
        this.setVisible(false);
        ven.setVisible(true);
    }

    private void jButtonAceptar7_actionPerformed(ActionEvent e) {
        RegistrarUsuario ven =  new RegistrarUsuario();
        ven.setVisible(true);
        
    }

    private void jButtonAceptar8_actionPerformed(ActionEvent e) {
        BuscarLugareDeRealizacion ven = new BuscarLugareDeRealizacion();
        ven.setVisible(true);
    }

    private void jButtonAceptar9_actionPerformed(ActionEvent e) {
        BuscarCompetenciaDeportiva ven = new BuscarCompetenciaDeportiva(usuarioActual);
        ven.setVisible(true);
    }

    private void jButtonAceptar10_actionPerformed(ActionEvent e) {
        BuscarTodasLasCompetenciaDeportiva ven = new BuscarTodasLasCompetenciaDeportiva(usuarioActual);
        ven.setVisible(true);
    }
    
    private void actualizarUsuarioActual(Usuario usuario){
        usuarioActual=usuario;
    }
}

