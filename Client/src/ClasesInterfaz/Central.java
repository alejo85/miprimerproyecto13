package ClasesInterfaz;


import ClasesLogicas.Usuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    private JMenuItem altaLugarDeRealizacion = new JMenuItem();
    private JMenuItem registrarse = new JMenuItem();
    private JMenu menuHelp = new JMenu();
    private JMenuItem menuHelpAbout = new JMenuItem();
    //private JLabel jLabelBienvenidos = new JLabel();
    private JLabel logoJLabel = new JLabel();
    private JLabel jLabelSistemaDeGestiónDeCompetenciasDeportivas = new JLabel();
    private JLabel usuarioJTextArea = new JLabel();
    //private JLabel jLabelUsuario = new JLabel();
    private JPanel gestiónUsuarioJPanel = new JPanel();
    private JButton modificarUsuarioJButton = new JButton();
    private JButton iniciarSesiónJButton = new JButton();
    private JButton registrarseJButton = new JButton();
    private JPanel lugarDeRealizaciónJPanel = new JPanel();
    private JButton altaLugarDeRealizacionJButton = new JButton();
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
        setResizable(false);
        this.setJMenuBar( menuBar );
        this.getContentPane().setLayout(null);
        this.setSize(new Dimension(820, 570));
        this.setLocationRelativeTo(null);
        this.setTitle( "Sistema De Gestión De Competencias" );
        // PESTAÑA GESTION MENU SUPERIOR
        menuFile.setText( "Gestión" );
        iniciarSecion.setText("Iniciar Sesión");
        registrarse.setText("Registrarse");
        modificar.setText("Modificar");
        menuFileExit.setText( "Salir" );
        // PESTAÑA COMPETENCIA
        competencia.setText("Competencia");
        buscarCompetencia.setText("Buscar Competencias");
        buscarTodasLasCompetencias.setText("Buscar Todas las Competencias");

        // PESTAÑA LUGAR DE REALIZACION
        lugar.setText("Lugar de Realización");
        altaLugarDeRealizacion.setText("Nuevo Lugar de Realización");
        // PESTAÑA AYUDA
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
        ImageIcon imagenCandado = new ImageIcon("src/Imagenes/Logo_mejorado.png");
     
        
        logoJLabel.setBounds(new Rectangle(469, 67, 103, 103));
        logoJLabel.setIcon(imagenCandado);
        
        usuarioJTextArea.setBounds(new Rectangle(45, 85, 300, 40));
        usuarioJTextArea.setBackground(gestiónUsuarioJPanel.getBackground());//ver color
        usuarioJTextArea.setFont(new Font("Tahoma", 0, 16));
        usuarioJTextArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 1, 1));
        usuarioJTextArea.setForeground(Color.blue);
        
        if(usuarioActual==null){
        usuarioJTextArea.setText("Usted no esta autenticado");
        buscarCompetencia.setEnabled(false);
        modificar.setEnabled(false);
        modificarUsuarioJButton.setEnabled(false);
        lugar.setEnabled(false);
        altaLugarDeRealizacionJButton.setEnabled(false);
        }
        else{
            usuarioJTextArea.setText("Bienvenido "+usuarioActual.getNombre()+" "+usuarioActual.getApellido());
            registrarse.setEnabled(false);
            registrarseJButton.setEnabled(false);
            
        }

     
        
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
        iniciarSecion.setText("Cerrar Sesión");
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
        altaLugarDeRealizacionJButton.setBounds(new Rectangle(10, 90, 230, 55));
        altaLugarDeRealizacionJButton.setFont(new Font("Tahoma", 0, 13));
        altaLugarDeRealizacionJButton.setText("Nuevo Lugar De Realización");
        altaLugarDeRealizacionJButton.addActionListener(new ActionListener() {
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
        buscarCompetenciaJButton.setText("Buscar Competencias");
       // buscarCompetenciaJButton.setActionCommand("");
        buscarCompetenciaJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar9_actionPerformed(e);
                }
            });
        if(usuarioActual == null){buscarCompetenciaJButton.setEnabled(false);}
        else{buscarCompetenciaJButton.setEnabled(true);}
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
        altaLugarDeRealizacion.addActionListener(new ActionListener() { public void actionPerformed( ActionEvent ae ) { buscarLugarDeRealizacion_ActionPerformed( ae ); } });
        
        // MENU SUPERIOR - AGREGANDO BOTONES
        menuFile.add(iniciarSecion);
        menuFile.add(registrarse);
        menuFile.add(modificar);
        menuFile.add( menuFileExit );
        competencia.add(buscarCompetencia);
        competencia.add(buscarTodasLasCompetencias);
        lugar.add(altaLugarDeRealizacion);
        menuBar.add( menuFile );
        menuBar.add(competencia);
        menuBar.add(lugar);
        menuHelp.add( menuHelpAbout );
        menuBar.add( menuHelp );
        
        // BOTONES DENTRO DE JPANELS
        this.getContentPane().add(usuarioJTextArea, null);
        
        
        // TITULO SISTEMA DE GESTION
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setText("Sistema de Gestión de Competencias Deportivas");
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setBounds(new Rectangle(5, 5, 795, 80));
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setFont(new Font("Tahoma", 0, 22));
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelSistemaDeGestiónDeCompetenciasDeportivas.setHorizontalTextPosition(SwingConstants.CENTER);
        this.getContentPane().add(jLabelSistemaDeGestiónDeCompetenciasDeportivas, null);
        this.getContentPane().add(logoJLabel, null);
        this.getContentPane().add(salirJButton, null);
        this.getContentPane().add(buscarTodasLasCompetenciasJButton, null);
        this.getContentPane().add(buscarCompetenciaJButton, null);
        this.getContentPane().add(competenciaJPanel, null);
        lugarDeRealizaciónJPanel.add(altaLugarDeRealizacionJButton, null);
        this.getContentPane().add(lugarDeRealizaciónJPanel, null);
        gestiónUsuarioJPanel.add(modificarUsuarioJButton, null);
        gestiónUsuarioJPanel.add(iniciarSesiónJButton, null);
        gestiónUsuarioJPanel.add(registrarseJButton, null);
        this.getContentPane().add(gestiónUsuarioJPanel, null);
        
     
        

    }

    void helpAbout_ActionPerformed(ActionEvent e) {
    	Icon icono  =  new ImageIcon("src/Imagenes/qr_caratula.png");
        JOptionPane.showMessageDialog(this, new Central_AboutBoxPanel1(), "Acerca de", JOptionPane.PLAIN_MESSAGE, icono);
    }
    void buscarCompetencia_ActionPerformed (ActionEvent e){
        dispose();   
    	BuscarCompetenciaDeportiva nuevo= new BuscarCompetenciaDeportiva(usuarioActual);
        nuevo.setVisible(true);
           
           }
    // ACCION BOTON BUSCAR TODAS LAS COMPETENCIAS DEPORTIVAS
    void buscarTodasLasCompetencias_ActionPerformed (ActionEvent e){
               JOptionPane.showMessageDialog(null, "<html><h4>Funcionalidad no disponible por el momento</h4></html>", "Buscar todas las competencias",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/en_construccion.png"));
           }
    // ACCION BOTON BUSCAR LUGAR DE REALIZACION
    void buscarLugarDeRealizacion_ActionPerformed (ActionEvent e){
    	AltaLugarDeRealizacion ven = new AltaLugarDeRealizacion(usuarioActual);
        ven.setVisible(true);
        this.dispose();
           }
   // ACCION BOTON SALIR
    private void jButtonAceptar2_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    // ACCION BOTON MODIFICAR
    private void jButtonAceptar5_actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "<html><h4>Funcionalidad no disponible por el momento</h4></html>", "Modificar usuario",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/en_construccion.png"));
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
            JOptionPane.showMessageDialog(null, "<html><h4>Se ha cerrado tu sesión exitosamente</h4></html>", "Cerrar sesión",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/no-logueado.png"));
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
    	AltaLugarDeRealizacion ven = new AltaLugarDeRealizacion(usuarioActual);
        ven.setVisible(true);
        this.dispose();
    }

    private void jButtonAceptar9_actionPerformed(ActionEvent e) {
        BuscarCompetenciaDeportiva ven = new BuscarCompetenciaDeportiva(usuarioActual);
        ven.setVisible(true);
        this.dispose();
    }
    
    private void jButtonAceptar10_actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "<html><h4>Funcionalidad no disponible por el momento</h4></html>", "Buscar todas las competencias",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/en_construccion.png"));
    }
    
    private void actualizarUsuarioActual(Usuario usuario){
        usuarioActual=usuario;
        
    }
}
