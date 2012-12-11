package ClasesInterfaz;


import ClasesGestores.CompetenciaGestor;

import ClasesLogicas.Competencia;
import ClasesLogicas.Encuentro;
import ClasesLogicas.Fixture;
import ClasesLogicas.ModeloTabla;
import ClasesLogicas.Ronda;
import ClasesLogicas.Subronda;
import ClasesLogicas.Usuario;

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

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class VerCompetencia extends JDialog {
    private ModeloTabla modelo = new ModeloTabla(new String[] { "Nombre" }, 0);
    private ModeloTabla modelo2 = new ModeloTabla(new String[] { "Fecha/Ronda Nº", "Equipo A", "Equipo B" }, 0);
    
    private JLabel jLabelDeporte = new JLabel();
    private JLabel jLabelnombreDeLaCompetencia = new JLabel();
    
    // DATOS DE LA COMPETENCIA A MOSTRAR
    private JLabel nombreDeLaCompetenciaJLabel = new JLabel();
    private JLabel modalidadJLabel = new JLabel();
    private JLabel deporteJLabel = new JLabel();
    private JLabel estadoJLabel = new JLabel();
    
    private JLabel jLabelModalidad = new JLabel();
    private JLabel jLabelEstado = new JLabel();
    
    private JLabel jLabelParticipante = new JLabel();
    private JTable tablaProximosEncuentosJTable = new JTable();
    private JLabel jLabelProximosEncuentros = new JLabel();
    private JButton modificarCompetenciaJButton = new JButton();
    private JButton eliminarCompetenciaJButton = new JButton();
    private JButton gestionarParticipantesJButton = new JButton();
    private JButton mostrarFixtureJButton = new JButton();
    private JButton generarFixtureJButton = new JButton();
    private JButton mostrarTablaDePosicionesJButton = new JButton();
    private JScrollPane jScrollPaneParticipante = new JScrollPane();
    private JScrollPane jScrollPaneProximoEncuentro = new JScrollPane();
    private JButton cancelarJButton = new JButton();
    private Usuario usuarioActual=null;
    private Competencia competencia;
    private JTable jTable1 = new JTable();
    private JDialog ventanaAnterior;
    /**
     * @param usuario
     * @param competencia
     */
    public VerCompetencia( Usuario usuario, Competencia competencia ) {

        this(null, "", false, usuario, competencia );
    }

    public VerCompetencia(Frame parent, String title, boolean modal,Usuario usuario, Competencia competencia  ) {
        super(parent, title, modal);
        try {

            this.usuarioActual=usuario;
            this.competencia=competencia;
            
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        
        // PARA QUE NO SE PUEDA REDIMENSIONAR
        setResizable(false);
        
        // CAPTURA EVENTO DE CERRAR VENTANA PARA ABRIR LA ANTERIOR
        CerrarVentana();
        
        // TAMAÑO VENTANA
        this.setSize(new Dimension(940, 567));
        this.setLocationRelativeTo(null);
        
        // TITULO VENTANA 
        this.setTitle("Ver Competencia");
        
        this.getContentPane().setLayout( null );
        
        cargarDatos();
        nombreDeLaCompetenciaJLabel.setBounds(new Rectangle(235, 30, 375, 30));
        nombreDeLaCompetenciaJLabel.setFont(new Font("Tahoma", 0, 15));
        nombreDeLaCompetenciaJLabel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    
    // LETRA AZUL EN DATOS DE LA COMPETENCIA
        nombreDeLaCompetenciaJLabel.setForeground(Color.blue);
        modalidadJLabel.setForeground(Color.blue);
       deporteJLabel.setForeground(Color.blue);
       estadoJLabel.setForeground(Color.blue);
       
        jLabelnombreDeLaCompetencia.setText("Nombre De La Competencia:");
        jLabelnombreDeLaCompetencia.setBounds(new Rectangle(45, 33, 175, 25));
        jLabelnombreDeLaCompetencia.setFont(new Font("Tahoma", 0, 13));
        
        
        jLabelDeporte.setText("Deporte:");
        jLabelDeporte.setBounds(new Rectangle(45, 113, 135, 25));
        jLabelDeporte.setFont(new Font("Tahoma", 0, 13));
        
        
        deporteJLabel.setBounds(new Rectangle(235, 110, 375, 30));
        deporteJLabel.setFont(new Font("Tahoma", 0, 15));
        deporteJLabel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        
        
        
        modalidadJLabel.setBounds(new Rectangle(235, 70, 375, 30));
        modalidadJLabel.setFont(new Font("Tahoma", 0, 15));
        modalidadJLabel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
   
        jLabelModalidad.setText("Modalidad:");
        jLabelModalidad.setBounds(new Rectangle(45, 73, 135, 25));
        jLabelModalidad.setFont(new Font("Tahoma", 0, 13));
        
        
        jLabelEstado.setText("Estado:");
        jLabelEstado.setBounds(new Rectangle(45, 153, 135, 25));
        jLabelEstado.setFont(new Font("Tahoma", 0, 13));
        
        
        estadoJLabel.setBounds(new Rectangle(235, 150, 375, 30));
        estadoJLabel.setFont(new Font("Tahoma", 0, 15));
        estadoJLabel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
   
        jLabelParticipante.setText("Participantes");
        jLabelParticipante.setBounds(new Rectangle(45, 230, 135, 25));
        jLabelParticipante.setFont(new Font("Tahoma", 0, 13));
        
        
        jLabelProximosEncuentros.setText("Proximos Encuentros");
        jLabelProximosEncuentros.setBounds(new Rectangle(45, 355, 135, 25));
        jLabelProximosEncuentros.setFont(new Font("Tahoma", 0, 13));
        
        
        modificarCompetenciaJButton.setText("Modificar Competencia");
        modificarCompetenciaJButton.setBounds(new Rectangle(710, 15, 175, 40));
        modificarCompetenciaJButton.setFont(new Font("Tahoma", 0, 13));
        modificarCompetenciaJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    modificarCompetenciaJButton_actionPerformed(e);
                }
            });
        eliminarCompetenciaJButton.setText("Eliminar Competencia");
        eliminarCompetenciaJButton.setBounds(new Rectangle(710, 65, 175, 40));
        eliminarCompetenciaJButton.setFont(new Font("Tahoma", 0, 13));
        eliminarCompetenciaJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    eliminarCompetenciaJButton_actionPerformed(e);
                }
            });
        gestionarParticipantesJButton.setText("Gestionar Participantes");
        gestionarParticipantesJButton.setBounds(new Rectangle(710, 180, 175, 40));
        gestionarParticipantesJButton.setFont(new Font("Tahoma", 0, 13));
        gestionarParticipantesJButton.setActionCommand("Gestionar Participantes");
        gestionarParticipantesJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gestionarParticipantesJButton_actionPerformed(e);
                }
            });
        mostrarFixtureJButton.setText("Mostrar Fixture");
        mostrarFixtureJButton.setBounds(new Rectangle(710, 350, 175, 40));
        mostrarFixtureJButton.setFont(new Font("Tahoma", 0, 13));
        mostrarFixtureJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mostrarFixtureJButton_actionPerformed(e);
                }
            });
        generarFixtureJButton.setText("Generar Fixture");
        generarFixtureJButton.setBounds(new Rectangle(710, 295, 175, 40));
        generarFixtureJButton.setFont(new Font("Tahoma", 0, 13));
        generarFixtureJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    generarFixtureJButton_actionPerformed(e);
                }
            });
        mostrarTablaDePosicionesJButton.setText("Mostrar Tabla");
        mostrarTablaDePosicionesJButton.setBounds(new Rectangle(710, 400, 175, 40));
        mostrarTablaDePosicionesJButton.setFont(new Font("Tahoma", 0, 13));
        mostrarTablaDePosicionesJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mostrarTablaDePosicionesJButton_actionPerformed(e);
                }
            });
        jScrollPaneParticipante.setBounds(new Rectangle(235, 200, 375, 125));
        jScrollPaneProximoEncuentro.setBounds(new Rectangle(235, 340, 375, 120));
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(710, 495, 175, 40));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        tablaProximosEncuentosJTable.setModel(modelo2);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(mostrarTablaDePosicionesJButton, null);
        this.getContentPane().add(generarFixtureJButton, null);
        this.getContentPane().add(mostrarFixtureJButton, null);
        this.getContentPane().add(gestionarParticipantesJButton, null);
        this.getContentPane().add(eliminarCompetenciaJButton, null);
        this.getContentPane().add(modificarCompetenciaJButton, null);
        this.getContentPane().add(jLabelProximosEncuentros, null);
        this.getContentPane().add(jLabelParticipante, null);
        this.getContentPane().add(estadoJLabel, null);
        this.getContentPane().add(jLabelEstado, null);
        this.getContentPane().add(jLabelModalidad, null);
        this.getContentPane().add(modalidadJLabel, null);
        this.getContentPane().add(deporteJLabel, null);
        this.getContentPane().add(jLabelnombreDeLaCompetencia, null);
        this.getContentPane().add(jLabelDeporte, null);
        this.getContentPane().add(nombreDeLaCompetenciaJLabel, null);
        jScrollPaneParticipante.getViewport().add(jTable1, null);
        this.getContentPane().add(jScrollPaneParticipante, null);
        jScrollPaneProximoEncuentro.getViewport().add(tablaProximosEncuentosJTable, null);
        this.getContentPane().add(jScrollPaneProximoEncuentro, null);
        
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        BuscarCompetenciaDeportiva ven = new BuscarCompetenciaDeportiva(usuarioActual);
        ven.setVisible(true);
        dispose();
        
    }

    private void modificarCompetenciaJButton_actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "<html><h4>Funcionalidad no disponible por el momento</h4><html>", "Modificar competencia",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/en_construccion.png"));
    }

    private void eliminarCompetenciaJButton_actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "<html><h4>Funcionalidad no disponible por el momento</h4></html>", "Eliminar competencia",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/en_construccion.png"));
    }

    private void gestionarParticipantesJButton_actionPerformed(ActionEvent e) {
        ListarParticipantes ven;
        ven = new ListarParticipantes(usuarioActual, competencia);
        dispose();
        ven.setVisible(true);
    }


    private void generarFixtureJButton_actionPerformed(ActionEvent e) {
        int cant_disponibilidad=0;
        for(int i=0;i<competencia.getLugares().length;i++){
            cant_disponibilidad=cant_disponibilidad+competencia.getLugares()[i].getDisponibilidad();        
            }
        if(cant_disponibilidad>=competencia.getParticipantes().length){
                if(competencia.getEstado().equals("Creada") || competencia.getEstado().equals("Planificada")){
                    int respuesta = JOptionPane.showOptionDialog(this, "<html><h4>¿Está seguro de que desea generar el fixture de la competencia "+competencia.getNombreCompetencia()+"?</h4></html>", "Generar Fixture.", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, new ImageIcon("src/Imagenes/pregunta.png") , new Object[]{"Si", "No"}, "Si");
                    // SI ES MODALIDAD SIMPLE O DOBLE NO SE GENERA FIXTURE
                    if(competencia.getModalidad().equals("Simple") || competencia.getModalidad().equals("Doble")){
                       JOptionPane.showMessageDialog(null, "<html><h4>Funcionalidad no disponible por el momento para esta modalidad</h4><html>", "Generar fixture",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/en_construccion.png"));
                    }
                    // SI ES LIGA SE GENERA
                    else{
                            // SI PRESIONO QUE SI QUIERE GENERAR
                            if (respuesta == 0){
                                // SI TIENE AL MENOS DOS PARTICIPANTES
                                if(competencia.getParticipantes().length>=2){
                                    // SI EXISTIA FIXTURE
                                    if(competencia.getFixture()!=null && competencia.getFixture().getIdFixture()!=0){
                                        CompetenciaGestor.eliminarFixtureDeCompetencia(competencia);
                                        CompetenciaGestor.generarFixture(competencia);
                                        JOptionPane.showMessageDialog(null, "<html><h4>El fixture de "+competencia.getNombreCompetencia()+" se genero exitosamente</h4></html>", "Generar fixture",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/exito.png"));
                                        cargarDatos();
                                    }
                                    //SI NO EXISTIA FIXTURE
                                    else{
                                            CompetenciaGestor.generarFixture(competencia);
                                            competencia.setEstado("Planificada");
                                            JOptionPane.showMessageDialog(null, "<html><h4>El fixture de "+competencia.getNombreCompetencia()+" se genero exitosamente</h4></html>", "Generar fixture",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/exito.png"));
                                            cargarDatos();
                                        
                                        }
                                
                                }
                                //SI NO TIENE AL MENOS DOS PARTICIPANTES
                                else{
                                    JOptionPane.showMessageDialog(null, "<html><h4>Debes dar de alta participantes para generar el fixture</h4></html>", "Generar fixture",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/info.png"));
                                }
                                }
                        }
                }
                //SINO ESTA EN ESTADO PLANIFICADA O CREADA
                else{
                    JOptionPane.showMessageDialog(null, "<html><h4>No puede generar el fixture de una competencia que se encuentra en "+competencia.getEstado()+"</h4></html>", "Generar fixture",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/error.png"));
                }        
        }
        else{
            JOptionPane.showMessageDialog(null, "<html><h4>No cuentas con la disponibilidad minima en lugares de realización</h4></html>", "Generar fixture",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/error.png"));
        }
            }

    private void mostrarFixtureJButton_actionPerformed(ActionEvent e) {
        
        if((competencia.getFixture()!=null)&&(competencia.getFixture().getIdFixture())!=0){
        
            ModificarFixture ven = new ModificarFixture(this.competencia, this.usuarioActual,Integer.parseInt(tablaProximosEncuentosJTable.getValueAt(0,0).toString())-1);
            dispose();
            ven.setVisible(true);
        }
        
        else{
        
            Toolkit.getDefaultToolkit().beep();
            JOptionPane pane = new JOptionPane("<html><h4>Primero debe generar el Fixture de la competencia</h4></html>", JOptionPane.ERROR_MESSAGE); 
            pane.setIcon(new ImageIcon("src/Imagenes/error.png"));
            JDialog dialog = pane.createDialog("Ver fixture");
            int altoPantalla = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(); // ancho de la pantalla
            int posicion= this.getLocationOnScreen().y;
            int altoVentana= this.getHeight();
            
            if ((altoPantalla-(posicion+altoVentana) < posicion))
            {
                   dialog.setLocation(getLocationOnScreen().x + this.getWidth()*1/2-pane.getWidth()*1/2 , getLocationOnScreen().y - pane.getHeight()+40);
            }
            else
            {
                   dialog.setLocation(getLocationOnScreen().x + this.getWidth()*1/2-pane.getWidth()*1/2 , getLocationOnScreen().y + this.getHeight()/2 +pane.getHeight());
            }
            
            dialog.setVisible(true);
        
        
        }
        
    }

    private void mostrarTablaDePosicionesJButton_actionPerformed(ActionEvent e) {
      
        if(competencia.getFixture()!=null){
            TablaDePosiciones ven = new TablaDePosiciones(usuarioActual, competencia, competencia.getTablaDePosiciones());
            dispose();
            ven.setVisible(true);
            }
        else{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane pane = new JOptionPane("<html><h4>Primero debe generar el Fixture de la competencia</h4></html>", JOptionPane.ERROR_MESSAGE); 
            pane.setIcon(new ImageIcon("src/Imagenes/error.png"));
            JDialog dialog = pane.createDialog("Ver tabla posiciones");
            int altoPantalla = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(); // ancho de la pantalla
            int posicion= this.getLocationOnScreen().y;
            int altoVentana= this.getHeight();
            
            if ((altoPantalla-(posicion+altoVentana) < posicion))
            {
                   dialog.setLocation(getLocationOnScreen().x + this.getWidth()*1/2-pane.getWidth()*1/2 , getLocationOnScreen().y - pane.getHeight()+40);
            }
            else
            {
                   dialog.setLocation(getLocationOnScreen().x + this.getWidth()*1/2-pane.getWidth()*1/2 , getLocationOnScreen().y + this.getHeight()/2 +pane.getHeight());
            }
            
            dialog.setVisible(true);
            
        }
    }
    private void cargarDatos(){
        nombreDeLaCompetenciaJLabel.setText(competencia.getNombreCompetencia());
        deporteJLabel.setText(competencia.getDeporte().getNombre());
        modalidadJLabel.setText(competencia.getModalidad());
        estadoJLabel.setText(competencia.getEstado());
        modelo = new ModeloTabla(new String[] { "Nombre" }, 0);
        for(int i=0; i<competencia.getParticipantes().length;i++ ){
                Vector <String> datos = new Vector <String>();
                datos.add(competencia.getParticipantes()[i].getNombre());
                modelo.addRow(datos);
            }
        // ORDENAR SEGUN COLUMNA SELECCIONADA
           jTable1.setModel(modelo);
            TableRowSorter<DefaultTableModel> elQueOrdena1 = new TableRowSorter<DefaultTableModel>(modelo);
            jTable1.setRowSorter(elQueOrdena1);
            
            modelo2 =  new ModeloTabla(new String[] { "Fecha/Ronda Nº", "Equipo A", "Equipo B" }, 0);
            if(competencia.getFixture()!=null && competencia.getFixture().getIdFixture() != 0)
            {
                cargarFixture(competencia.getFixture().getRondas());
                }
            tablaProximosEncuentosJTable.setModel(modelo2);
            // ORDENAR SEGUN COLUMNA SELECCIONADA
            TableRowSorter<DefaultTableModel> elQueOrdena = new TableRowSorter<DefaultTableModel>(modelo2);
            tablaProximosEncuentosJTable.setRowSorter(elQueOrdena);

        }

    /**
     * @param rondas
     */
     public void cargarFixture(Ronda [] rondas){
         
        for(int i=0; i<rondas.length;i++ )
        {
            Subronda sub = rondas[i].getGanadores();
            Encuentro[] encuentrosDeSubRonda=sub.getEncuentros();
 
            for(int j=0;j<encuentrosDeSubRonda.length;j++)
            {
                int aux=i+1;
                Vector <String> datos = new Vector <String>();
                datos.add(""+aux);
                datos.add(rondas[i].getGanadores().getEncuentros()[j].getParticipanteA().getNombre());
                datos.add(rondas[i].getGanadores().getEncuentros()[j].getParticipanteB().getNombre());
                modelo2.addRow(datos);
            }
        }
         
        
     }

    private void CerrarVentana(){
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        new BuscarCompetenciaDeportiva(usuarioActual);
        setVisible(false);
        dispose();
    }
    });
    }
    
}
