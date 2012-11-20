package ClasesInterfaz;


import ClasesLogicas.Usuario;

import java.awt.Color;
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
    private Usuario usuarioActual;
    private JMenuItem menuFileExit = new JMenuItem();
    private JMenuItem iniciarSecion = new JMenuItem();
    private JMenuItem modificar = new JMenuItem();
    private JMenuItem buscarCompetencia = new JMenuItem();
    private JMenuItem buscarTodasLasCompetencias = new JMenuItem();
    private JMenuItem buscarLugarDeRealizacion = new JMenuItem();
    private JMenuItem registrarse = new JMenuItem();
    private JMenu menuHelp = new JMenu();
    private JMenuItem menuHelpAbout = new JMenuItem();
    //private JLabel jLabelBienvenidos = new JLabel();
    private JLabel logoJLabel = new JLabel();
    private JLabel jLabelSistemaDeGestiónDeCompetenciasDeportivas = new JLabel();
    private JTextArea usuarioJTextArea = new JTextArea();
    private JLabel jLabelUsuario = new JLabel();
    private JPanel gestiónUsuarioJPanel = new JPanel();
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
        this.usuarioActual=null;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // EN CASO DE HABER INICIADO SESION SE ACTUALIZA EL USUARIO ACTUAL
    public Central(Usuario usuario) {
        this.actualizarUsuarioActual(usuario);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setJMenuBar( menuBar );
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(820, 570));
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
       /* jLabelBienvenidos.setText("Bienvienido");
        jLabelBienvenidos.setBounds(new Rectangle(35, 5, 250, 70));
        jLabelBienvenidos.setFont(new Font("Tahoma", 0, 32));*/
        logoJLabel.setBounds(new Rectangle(130, 95, 195, 160));
        logoJLabel.setIcon(imagenCandado);
        
        
        // TITULO SISTEMA DE GESTION
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setText("Sistema de Gestión de Competencias Deportivas");
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setBounds(new Rectangle(5, 5, 550, 80));
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setFont(new Font("Tahoma", 0, 22));
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setHorizontalTextPosition(SwingConstants.CENTER);
        
        Color colorAplicacion=new Color(238, 238, 238);
        usuarioJTextArea.setBounds(new Rectangle(45, 85, 300, 40));
        usuarioJTextArea.setBackground(colorAplicacion);
        usuarioJTextArea.setFont(new Font("Tahoma", 0, 16));
        usuarioJTextArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 1, 1));
        usuarioJTextArea.setForeground(Color.blue);
        
        if(usuarioActual==null){
        usuarioJTextArea.setText("Usted no esta autenticado");
        }
        else{
            usuarioJTextArea.setText("Bienvenido "+usuarioActual.getNombre()+" "+usuarioActual.getApellido());
        }

        /*
        jLabelUsuario.setText("Usuario:");
         jLabelUsuario.setBounds(new Rectangle(5, 50, 550, 80));
        jLabelUsuario.setFont(new Font("Tahoma", 0, 13));
        jLabelUsuario.setText("Usuario:");*/
        
        // CONTENEDOR BOTONES GESTION DE USUARIO
        gestiónUsuarioJPanel.setBounds(new Rectangle(5, 170, 250, 240));
        gestiónUsuarioJPanel.setLayout(null);
        gestiónUsuarioJPanel.setBorder(BorderFactory.createTitledBorder("Gestión de usuario"));
        gestiónUsuarioJPanel.setFont(new Font("Dialog", 0, 50));
        // SI ESTA LOGUEADO EL BOTON CUMPLE LA FUNCION DE CERRAR SESION
        if(usuarioActual!=null){
        iniciarSesiónJButton.setBounds(new Rectangle(10, 30, 230, 55));
        iniciarSesiónJButton.setFont(new Font("Tahoma", 0, 13));
        iniciarSesiónJButton.setText("Cerrar Sesión");
        iniciarSesiónJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar6_actionPerformed(e);
                }
            });
        }
        // SI NO ESTA LOGUEADO EL BOTON CUMPLE LA FUNCION DE ABRIR INTERFAZ INICIAR SESION
        else{
            iniciarSesiónJButton.setBounds(new Rectangle(10, 30, 230, 55));
            iniciarSesiónJButton.setFont(new Font("Tahoma", 0, 13));
            iniciarSesiónJButton.setText("Iniciar Sesión");
            iniciarSesiónJButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButtonAceptar6_actionPerformed(e);
                    }
                });
        }
        
        // BOTON REGISTRAR
        registrarseJButton.setText("Registrarse");
        registrarseJButton.setBounds(new Rectangle(10, 100, 230, 55));
        registrarseJButton.setFont(new Font("Tahoma", 0, 13));
        registrarseJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar7_actionPerformed(e);
                }
            });
        
        // BOTON MODIFICAR*/
        modificarUsuarioJButton.setText("Modificar");
        modificarUsuarioJButton.setBounds(new Rectangle(10, 170, 230, 55));
        modificarUsuarioJButton.setFont(new Font("Tahoma", 0, 13));
        modificarUsuarioJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar5_actionPerformed(e);
                }
            });
        
        lugarDeRealizaciónJPanel.setBounds(new Rectangle(280, 170, 250, 240));
        lugarDeRealizaciónJPanel.setLayout(null);
        lugarDeRealizaciónJPanel.setBorder(BorderFactory.createTitledBorder("Lugar de Realización"));
        lugarDeRealizaciónJPanel.setFont(new Font("Dialog", 0, 50));
        listarLugarDeRealizaciónJButton.setBounds(new Rectangle(10, 70, 230, 55));
        listarLugarDeRealizaciónJButton.setFont(new Font("Tahoma", 0, 13));
        listarLugarDeRealizaciónJButton.setText("Listar Lugar De Realización");
        listarLugarDeRealizaciónJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar8_actionPerformed(e);
                }
            });
        competenciaJPanel.setBounds(new Rectangle(550, 170, 250, 240));
        competenciaJPanel.setLayout(null);
        competenciaJPanel.setBorder(BorderFactory.createTitledBorder("Competencia"));
        competenciaJPanel.setFont(new Font("Dialog", 0, 50));
        buscarCompetenciaJButton.setBounds(new Rectangle(560, 230, 230, 55));
        buscarCompetenciaJButton.setFont(new Font("Tahoma", 0, 13));
        buscarCompetenciaJButton.setText("Buscar Competencia");
        buscarCompetenciaJButton.setActionCommand("");
        buscarCompetenciaJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar9_actionPerformed(e);
                }
            });
        buscarTodasLasCompetenciasJButton.setBounds(new Rectangle(560, 300, 230, 55));
        buscarTodasLasCompetenciasJButton.setFont(new Font("Tahoma", 0, 13));
        buscarTodasLasCompetenciasJButton.setText("Buscar Todas Las Competencias");
        buscarTodasLasCompetenciasJButton.setActionCommand("");
        buscarTodasLasCompetenciasJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar10_actionPerformed(e);
                }
            });
        
        //BOTON PARA SALIR DEL SISTEMA
        salirJButton.setText("Salir del sistema");
        salirJButton.setBounds(new Rectangle(560, 445, 230, 55));
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
        
        // MENU SUPERIOR - AGREGANDO BOTONES
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
        
        // BOTONES DENTRO DE JPANELS
        this.getContentPane().add(salirJButton, null);
        this.getContentPane().add(buscarTodasLasCompetenciasJButton, null);
        this.getContentPane().add(buscarCompetenciaJButton, null);
        this.getContentPane().add(competenciaJPanel, null);
        lugarDeRealizaciónJPanel.add(listarLugarDeRealizaciónJButton, null);
        this.getContentPane().add(lugarDeRealizaciónJPanel, null);
        gestiónUsuarioJPanel.add(modificarUsuarioJButton, null);
        gestiónUsuarioJPanel.add(iniciarSesiónJButton, null);
        gestiónUsuarioJPanel.add(registrarseJButton, null);
        this.getContentPane().add(gestiónUsuarioJPanel, null);
        this.getContentPane().add(jLabelUsuario, null);
        this.getContentPane().add(usuarioJTextArea, null);
        this.getContentPane().add(jLabelSistemaDeGestiónDeCompetenciasDeportivas, null);
        this.getContentPane().add(logoJLabel, null);
        //this.getContentPane().add(jLabelBienvenidos, null);
        

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
           BuscarLugareDeRealizacion nuevo= new BuscarLugareDeRealizacion(usuarioActual);
           nuevo.setVisible(true);
           }
    void iniciarSecion_ActionPerformed (ActionEvent e){
           /*IniciarSesion nuevo= new IniciarSesion();
           nuevo.setVisible(true);*/
    }

    private void jButtonAceptar2_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void jButtonAceptar5_actionPerformed(ActionEvent e) {
        JOptionPane.showOptionDialog(null, "Funcionalidad No disponible"  , "Funcionalidad No disponible", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
        /*ModificarUsuario ven = new ModificarUsuario(usuarioActual);
        ven.setVisible(true);*/
    }
// BOTON INICIAR SESION
    private void jButtonAceptar6_actionPerformed(ActionEvent e) {
        if(usuarioActual==null){
            IniciarSesion ven = new IniciarSesion();
            ven.setVisible(true);
            this.dispose();
        }
        else{
            this.dispose();
            new Principal();
        }
    }

    private void jButtonAceptar7_actionPerformed(ActionEvent e) {
        RegistrarUsuario ven =  new RegistrarUsuario();
        setVisible(false);
        dispose();
        ven.setVisible(true);
        
    }

    private void jButtonAceptar8_actionPerformed(ActionEvent e) {
        BuscarLugareDeRealizacion ven = new BuscarLugareDeRealizacion(usuarioActual);
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

