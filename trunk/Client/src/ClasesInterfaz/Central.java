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
    private JLabel jLabelSistemaDeGesti�nDeCompetenciasDeportivas = new JLabel();
    private JTextArea usuarioJTextArea = new JTextArea();
    private JLabel jLabelUsuario = new JLabel();
    private JPanel gesti�nUsuarioJPanel = new JPanel();
    private JButton modificarUsuarioJButton = new JButton();
    private JButton iniciarSesi�nJButton = new JButton();
    private JButton registrarseJButton = new JButton();
    private JPanel lugarDeRealizaci�nJPanel = new JPanel();
    private JButton listarLugarDeRealizaci�nJButton = new JButton();
    private JPanel competenciaJPanel = new JPanel();
    private JButton buscarCompetenciaJButton = new JButton();
    private JButton buscarTodasLasCompetenciasJButton = new JButton();
    private JButton salirJButton = new JButton();

    public Central() {
    
        /// muestra los look and feel instalados
        
       /* UIManager.LookAndFeelInfo plaf[] = UIManager.getInstalledLookAndFeels();
         
        for (int i=0; i < plaf.length; i++){
         
              System.out.println("Nombre: " + plaf[i].getName());
         
              System.out.println("Nombre de la clase: "+ plaf[i].getClassName());
         
        }
        
        */
        //// seteamos look and feel
     /*  
        try {
                
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //aca pasamos de parametro una funcion
                                                                                    //que toma el look and feel del sistema, para pasar uno
                                                                                    //especifico se pasa asi ("nombredellookandfeel")
              
    
              
                }
                catch (UnsupportedLookAndFeelException e) {
                   // handle exception
                }
                catch (ClassNotFoundException e) {
                   // handle exception
                }
                catch (InstantiationException e) {
                   // handle exception
                }
                catch (IllegalAccessException e) {
                   // handle exception
                }
        */
       // this.usuarioActual=null;
     /*  usuarioActual=new Usuario();
       usuarioActual.setApellido("Olivera");
       usuarioActual.setNombre("Alejandro");
       usuarioActual.setCorreoElectronico("alejo@masfm.com");*/
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
        this.setTitle( "Sistema De Gesti�n De Competencias" );
        // PESTA�A GESTION MENU SUPERIOR
        menuFile.setText( "Gesti�n" );
        iniciarSecion.setText("Iniciar Sesi�n");
        registrarse.setText("Registrarse");
        modificar.setText("Modificar");
        menuFileExit.setText( "Salir" );
        // PESTA�A COMPETENCIA
        competencia.setText("Competencia");
        buscarCompetencia.setText("Buscar Competencias");
        buscarTodasLasCompetencias.setText("Buscar Todas las Competencias");
        usuarioJTextArea.setEditable(false);
        // PESTA�A LUGAR DE REALIZACION
        lugar.setText("Lugar de Realizaci�n");
        buscarLugarDeRealizacion.setText("Buscar Lugar de Realizaci�n");
        // PESTA�A AYUDA
        menuHelp.setText( "Ayuda" );
        menuHelpAbout.setText( "Acerca de..." );
        
        //ACCION BOTONES
        // ACCION BOTON INICIAR SESION
        iniciarSecion.addActionListener(new ActionListener(){public void actionPerformed( ActionEvent ae ) { jButtonAceptar6_actionPerformed( ae ); } });
        // ACCION BOTONES MODIFICAR
        modificar.addActionListener(new ActionListener(){public void actionPerformed( ActionEvent ae ) { jButtonAceptar5_actionPerformed( ae ); } });
        // ACCION BOTON REGISTRAR
        registrarse.addActionListener(new ActionListener(){public void actionPerformed( ActionEvent ae ) { jButtonAceptar7_actionPerformed( ae ); } });
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { jButtonAceptar2_actionPerformed( ae ); } } );
        
        menuHelpAbout.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { helpAbout_ActionPerformed( ae ); } } );
        ImageIcon imagenCandado = new ImageIcon("Imagenes//bola8.png");
       /* jLabelBienvenidos.setText("Bienvienido");
        jLabelBienvenidos.setBounds(new Rectangle(35, 5, 250, 70));
        jLabelBienvenidos.setFont(new Font("Tahoma", 0, 32));*/
        logoJLabel.setBounds(new Rectangle(130, 95, 195, 160));
        logoJLabel.setIcon(imagenCandado);
        
        
        // TITULO SISTEMA DE GESTION
        jLabelSistemaDeGesti�nDeCompetenciasDeportivas.setText("Sistema de Gesti�n de Competencias Deportivas");
        jLabelSistemaDeGesti�nDeCompetenciasDeportivas.setBounds(new Rectangle(5, 5, 550, 80));
        jLabelSistemaDeGesti�nDeCompetenciasDeportivas.setFont(new Font("Tahoma", 0, 22));
        jLabelSistemaDeGesti�nDeCompetenciasDeportivas.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelSistemaDeGesti�nDeCompetenciasDeportivas.setHorizontalTextPosition(SwingConstants.CENTER);
        
        usuarioJTextArea.setBounds(new Rectangle(45, 85, 300, 40));
        usuarioJTextArea.setBackground(null);
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
        gesti�nUsuarioJPanel.setBounds(new Rectangle(5, 170, 250, 240));
        gesti�nUsuarioJPanel.setLayout(null);
        gesti�nUsuarioJPanel.setBorder(BorderFactory.createTitledBorder("Gesti�n de usuario"));
        gesti�nUsuarioJPanel.setFont(new Font("Dialog", 0, 50));
        // SI ESTA LOGUEADO EL BOTON CUMPLE LA FUNCION DE CERRAR SESION
        if(usuarioActual!=null){
        iniciarSesi�nJButton.setBounds(new Rectangle(10, 30, 230, 55));
        iniciarSesi�nJButton.setFont(new Font("Tahoma", 0, 13));
        iniciarSesi�nJButton.setText("Cerrar Sesi�n");
        iniciarSesi�nJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar6_actionPerformed(e);
                }
            });
        }
        // SI NO ESTA LOGUEADO EL BOTON CUMPLE LA FUNCION DE ABRIR INTERFAZ INICIAR SESION
        else{
            iniciarSesi�nJButton.setBounds(new Rectangle(10, 30, 230, 55));
            iniciarSesi�nJButton.setFont(new Font("Tahoma", 0, 13));
            iniciarSesi�nJButton.setText("Iniciar Sesi�n");
            iniciarSesi�nJButton.addActionListener(new ActionListener() {
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
        
        lugarDeRealizaci�nJPanel.setBounds(new Rectangle(280, 170, 250, 240));
        lugarDeRealizaci�nJPanel.setLayout(null);
        lugarDeRealizaci�nJPanel.setBorder(BorderFactory.createTitledBorder("Lugar de Realizaci�n"));
        lugarDeRealizaci�nJPanel.setFont(new Font("Dialog", 0, 50));
        listarLugarDeRealizaci�nJButton.setBounds(new Rectangle(10, 90, 230, 55));
        listarLugarDeRealizaci�nJButton.setFont(new Font("Tahoma", 0, 13));
        listarLugarDeRealizaci�nJButton.setText("Listar Lugar De Realizaci�n");
        listarLugarDeRealizaci�nJButton.addActionListener(new ActionListener() {
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
        lugarDeRealizaci�nJPanel.add(listarLugarDeRealizaci�nJButton, null);
        this.getContentPane().add(lugarDeRealizaci�nJPanel, null);
        gesti�nUsuarioJPanel.add(modificarUsuarioJButton, null);
        gesti�nUsuarioJPanel.add(iniciarSesi�nJButton, null);
        gesti�nUsuarioJPanel.add(registrarseJButton, null);
        this.getContentPane().add(gesti�nUsuarioJPanel, null);
        this.getContentPane().add(jLabelUsuario, null);
        this.getContentPane().add(usuarioJTextArea, null);
        this.getContentPane().add(jLabelSistemaDeGesti�nDeCompetenciasDeportivas, null);
        this.getContentPane().add(logoJLabel, null);
        //this.getContentPane().add(jLabelBienvenidos, null);
        

    }

    void helpAbout_ActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, new Central_AboutBoxPanel1(), "Acerca de", JOptionPane.PLAIN_MESSAGE);
    }
    void buscarCompetencia_ActionPerformed (ActionEvent e){
           BuscarCompetenciaDeportiva nuevo= new BuscarCompetenciaDeportiva(this, usuarioActual);
           nuevo.setVisible(true);
           }
    // ACCION BOTON BUSCAR TODAS LAS COMPETENCIAS DEPORTIVAS
    void buscarTodasLasCompetencias_ActionPerformed (ActionEvent e){
           BuscarTodasLasCompetenciaDeportiva nuevo= new BuscarTodasLasCompetenciaDeportiva(usuarioActual);
           nuevo.setVisible(true);
           }
    // ACCION BOTON BUSCAR LUGAR DE REALIZACION
    void buscarLugarDeRealizacion_ActionPerformed (ActionEvent e){
           BuscarLugareDeRealizacion nuevo= new BuscarLugareDeRealizacion(usuarioActual);
           nuevo.setVisible(true);
           }
   // ACCION BOTON SALIR
    private void jButtonAceptar2_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    // ACCION BOTON MODIFICAR
    private void jButtonAceptar5_actionPerformed(ActionEvent e) {
        JOptionPane.showOptionDialog(null, "Funcionalidad No disponible"  , "Funcionalidad No disponible", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
        /*ModificarUsuario ven = new ModificarUsuario(usuarioActual);
        ven.setVisible(true);*/
    }
// ACCION BOTON INICIAR SESION O CERRAR SESION DEPENDIENDO DEL OBJETO USUARIO
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
        this.setVisible(false);
        BuscarCompetenciaDeportiva ven = new BuscarCompetenciaDeportiva(this, usuarioActual);
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

