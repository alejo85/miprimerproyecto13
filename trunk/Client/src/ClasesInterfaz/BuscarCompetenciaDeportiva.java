package ClasesInterfaz;


import ClasesGestores.CompetenciaGestor;

import ClasesGestores.DeporteGestor;

import ClasesLogicas.Competencia;
import ClasesLogicas.Deporte;
import ClasesLogicas.ModeloTabla;
import ClasesLogicas.Usuario;

import InterfazGrafica.CampoTexto.AreaTextoNombre;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class BuscarCompetenciaDeportiva extends JDialog {
    private ModeloTabla modelo = new ModeloTabla(new String[] { "Nombre", "Deporte","Modalidad" ,"Estado" }, 0);
    private JButton aceptarJButton = new JButton();
    private JButton cancelarJButton = new JButton();
    private JPanel resultadoJPanel = new JPanel();
    private JButton nuevaCompetenciaJButton = new JButton();
    private JButton verCompetenciaJButton = new JButton();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JTable tablaResultadoJTable = new JTable();
    private JLabel jLabelModalidad = new JLabel();
    private JComboBox modalidadJComboBox = new JComboBox();
    private JPanel busqueadaJPanel = new JPanel();
    private JComboBox DeporteJComboBox = new JComboBox();
    private JLabel jLabelDeporte = new JLabel();
    private AreaTextoNombre nombreCompetenciaJTextArea = new AreaTextoNombre(60);
    private JLabel jLabelNombreDeLaCompetencia = new JLabel();
    private JLabel jLabelResultadosObtenidos = new JLabel();
    private JComboBox estadoJComboBox = new JComboBox();
    private JLabel jLabelEstado = new JLabel();
    private JButton buscarJButton = new JButton();
    private Usuario usuarioActual= null;
    private Vector <Competencia> competenciasEncontradas;
    private Competencia competenciaSelecionad=null;
    private  Vector <Deporte> deporte;
    private Color background = modalidadJComboBox.getBackground();
    private Color foreground = modalidadJComboBox.getForeground();

    public BuscarCompetenciaDeportiva(Usuario usuariologueado) {
        
        this(null, "", false,usuariologueado);
        
        
    }

    public BuscarCompetenciaDeportiva(Frame parent, String title, boolean modal,Usuario usuariologueado) {
        super(parent, title, modal);
        try {
            this.usuarioActual=usuariologueado;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        
        // DIMENSION DE LA VENTANA
        this.setSize(new Dimension(820, 670));
        this.getContentPane().setLayout( null );
       
        //TITULO VENTANA
        this.setTitle("Buscar Competencia");
        
        //BOTON ACEPTAR
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(300, 690, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 15));
        
        //BOTON CANCELAR
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(595, 690, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 15));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonCancelar_actionPerformed(e);
                }
            });
        
        // JPANEL BUSQUEDA POR
        busqueadaJPanel.setBounds(new Rectangle(15, 15, 775, 200));
        busqueadaJPanel.setLayout(null);
        Color borde= new Color(100,100,100);
        busqueadaJPanel.setBorder(BorderFactory.createLineBorder(borde,2));
        
        // ELEMENTOS DEL JPANEL BUSCAR POR
        
        // 1 . NOMBRE DE LA COMPETENCIA
        jLabelNombreDeLaCompetencia.setText("Nombre De La Competencia");
        jLabelNombreDeLaCompetencia.setBounds(new Rectangle(15, 20, 205, 25));
        jLabelNombreDeLaCompetencia.setFont(new Font("Tahoma", 0, 15));
        nombreCompetenciaJTextArea.setBounds(new Rectangle(210, 20, 375, 30));
        nombreCompetenciaJTextArea.setFont(new Font("Tahoma", 0, 15));
        nombreCompetenciaJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nombreCompetenciaJTextArea.setBorder(BorderFactory.createLineBorder(borde,1));
        nombreCompetenciaJTextArea.setBackground(null);
        
        // 2. DEPORTES
        jLabelDeporte.setText("Deporte");
        jLabelDeporte.setBounds(new Rectangle(15, 70, 135, 25));
        jLabelDeporte.setFont(new Font("Tahoma", 0, 15));
        DeporteJComboBox.setBounds(new Rectangle(75, 70, 175, 30));
        DeporteJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        DeporteJComboBox.setMinimumSize(new Dimension(2, 18));
        DeporteJComboBox.setPreferredSize(new Dimension(2, 18));
        DeporteJComboBox.setFont(new Font("Tahoma", 0, 15));
        DeporteJComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    DeporteJComboBox_actionPerformed(e);
                }
            });
        listarDeportes();
        // 3. MODALIDAD
        jLabelModalidad.setText("Modalidad");
        jLabelModalidad.setBounds(new Rectangle(257, 70, 135, 25));
        jLabelModalidad.setFont(new Font("Tahoma", 0, 15));
        modalidadJComboBox.setBounds(new Rectangle(330, 70, 205, 30));
        modalidadJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        modalidadJComboBox.setMinimumSize(new Dimension(2, 18));
        modalidadJComboBox.setPreferredSize(new Dimension(2, 18));
        modalidadJComboBox.addItem("Seleccione Una Modalidad");
        modalidadJComboBox.addItem("Liga");
        modalidadJComboBox.addItem("Eliminación simple");
        modalidadJComboBox.addItem("Eliminación doble");
        modalidadJComboBox.setFont(new Font("Tahoma", 0, 15));
        
        // 4. ESTADO
        modalidadJComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    modalidadJComboBox_actionPerformed(e);
                }
            });
        jLabelEstado.setText("Estado");
        jLabelEstado.setBounds(new Rectangle(540, 70, 135, 25));
        jLabelEstado.setFont(new Font("Tahoma", 0, 15));
        estadoJComboBox.setBounds(new Rectangle(590, 70, 175, 30));
        estadoJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        estadoJComboBox.setMinimumSize(new Dimension(2, 18));
        estadoJComboBox.setPreferredSize(new Dimension(2, 18));
        estadoJComboBox.addItem("Seleccione Un Estado");
        estadoJComboBox.addItem("Creada");
        estadoJComboBox.addItem("Planificada");
        estadoJComboBox.addItem("En disputa");
        estadoJComboBox.addItem("Finalizada");
        estadoJComboBox.setFont(new Font("Tahoma", 0, 15));
        
        // 5. BOTON BUSCAR
        estadoJComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    estadoJComboBox_actionPerformed(e);
                }
            });
        buscarJButton.setText("Buscar");
        buscarJButton.setBounds(new Rectangle(270, 140, 170, 40));
        buscarJButton.setFont(new Font("Tahoma", 0, 15));
        buscarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buscarJButton_actionPerformed(e);
                }
            });
        // TERMINA JPANEL BUSCAR POR
        
        // JPANEL RESULTADOS
        resultadoJPanel.setBounds(new Rectangle(15, 245, 775, 375));
        resultadoJPanel.setLayout(null);

        //resultadoJPanel.setBorder(BorderFactory.createTitledBorder("Resultados obtenidos"));
        resultadoJPanel.setBorder(BorderFactory.createLineBorder(borde,2));
        
        jLabelResultadosObtenidos.setText("Resultados obtenidos");
        jLabelResultadosObtenidos.setBounds(new Rectangle(15, 15, 205, 25));
        jLabelResultadosObtenidos.setFont(new Font("Tahoma", 0, 15));
        
        jScrollPane2.setBounds(new Rectangle(20, 50, 720, 230));

        
        // BOTON NUEVA COMPETENCIA

        nuevaCompetenciaJButton.setText("Nueva Competencia");
        nuevaCompetenciaJButton.setBounds(new Rectangle(445, 310, 170, 40));
        nuevaCompetenciaJButton.setFont(new Font("Tahoma", 0, 15));
        nuevaCompetenciaJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar2_actionPerformed(e);
                }
            });
        
        //BOTON VER COMPETENCIA
        verCompetenciaJButton.setText("Ver Competencia");
        verCompetenciaJButton.setBounds(new Rectangle(150, 310, 170, 40));
        verCompetenciaJButton.setFont(new Font("Tahoma", 0, 15));
        tablaResultadoJTable.setModel(modelo);
        verCompetenciaJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonAceptar1_actionPerformed(e);
                }
            });

        
        //jScrollBar2.setBounds(new Rectangle(890, 30, 15, 230)); ¿ por que dos scrollbar ?
        



        resultadoJPanel.add(verCompetenciaJButton, null);
        resultadoJPanel.add(nuevaCompetenciaJButton, null);
        jScrollPane2.getViewport().add(tablaResultadoJTable, null);
        resultadoJPanel.add(jScrollPane2, null);
        resultadoJPanel.add(nuevaCompetenciaJButton, null);
        resultadoJPanel.add(verCompetenciaJButton, null);
        resultadoJPanel.add(jLabelResultadosObtenidos, null);
        busqueadaJPanel.add(modalidadJComboBox, null);
        busqueadaJPanel.add(jLabelModalidad, null);
        busqueadaJPanel.add(DeporteJComboBox, null);
        busqueadaJPanel.add(jLabelDeporte, null);
        busqueadaJPanel.add(nombreCompetenciaJTextArea, null);
        busqueadaJPanel.add(jLabelNombreDeLaCompetencia, null);
        busqueadaJPanel.add(estadoJComboBox, null);
        busqueadaJPanel.add(jLabelEstado, null);
        busqueadaJPanel.add(buscarJButton, null);
        this.getContentPane().add(busqueadaJPanel, null);
        this.getContentPane().add(resultadoJPanel, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(aceptarJButton, null);
       
    }
    // CARGAR DEPORTES
    private void listarDeportes() {
        DeporteJComboBox.addItem("Seleccione un Deporte");
        deporte = DeporteGestor.instanciarDeportes();
        for(int i=0; i<deporte.size();i++){
        DeporteJComboBox.addItem(deporte.get(i).getNombre());
        }
    }

    private void jButtonCancelar_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    private void jButtonAceptar1_actionPerformed(ActionEvent e) {
        if(tablaResultadoJTable.getSelectedRow()>0){
        competenciaSelecionad = CompetenciaGestor.buscarCompetencia(competenciasEncontradas.get(tablaResultadoJTable.getSelectedRow()).getIdCompetencia());
        System.out.println(this.competenciaSelecionad.getNombreCompetencia());
        VerCompetencia ven = new VerCompetencia(usuarioActual, competenciaSelecionad);
        ven.setVisible(true);}
    }

    private void jButtonAceptar2_actionPerformed(ActionEvent e) {
        AltaCompetenciaDeportiva ven = new AltaCompetenciaDeportiva(usuarioActual);
        ven.setVisible(true);
    }

    private void buscarJButton_actionPerformed(ActionEvent e) {
        int error=0, idDeporte=-1;
        if(this.nombreCompetenciaJTextArea.getText().equals(""))error++;
        if(this.DeporteJComboBox.getSelectedItem().equals("Seleccione un Deporte"))error++;
        if(modalidadJComboBox.getSelectedItem().equals("Seleccione Una Modalidad"))error++;
        if(this.estadoJComboBox.getSelectedItem().equals("Seleccione Un Estado"))error++;
        if(error==4){
                nombreCompetenciaJTextArea.error();
                DeporteJComboBox.setBackground(Color.red);
                DeporteJComboBox.setForeground(Color.white);
                modalidadJComboBox.setForeground(Color.white);
                modalidadJComboBox.setBackground(Color.red);
                estadoJComboBox.setBackground(Color.red);
                estadoJComboBox.setForeground(Color.white);
            }
        if(DeporteJComboBox.getSelectedIndex()>0){
        idDeporte=deporte.get(DeporteJComboBox.getSelectedIndex()-1).getIdDeporte();}
        competenciasEncontradas = CompetenciaGestor.buscarCompetencias(this.nombreCompetenciaJTextArea.getText(),idDeporte , modalidadJComboBox.getSelectedItem().toString(), this.estadoJComboBox.getSelectedItem().toString(), this.usuarioActual.getCorreoElectronico());
        
        cargarResultados();
        
    }

    private void DeporteJComboBox_actionPerformed(ActionEvent e) {
        DeporteJComboBox.setBackground(background);
        DeporteJComboBox.setForeground(foreground);
    }

    private void modalidadJComboBox_actionPerformed(ActionEvent e) {
        modalidadJComboBox.setBackground(background);
        modalidadJComboBox.setForeground(foreground);
    }

    private void estadoJComboBox_actionPerformed(ActionEvent e) {
        estadoJComboBox.setBackground(background);
        estadoJComboBox.setForeground(foreground);
    }
    private void cargarResultados(){
        
        modelo = new ModeloTabla(new String[] { "Nombre", "Deporte","Modalidad" ,"Estado" }, 0);
        tablaResultadoJTable.setModel(modelo);
        System.out.println("tamaño resultado: "+competenciasEncontradas.size());
        for(int i =0; i<competenciasEncontradas.size();i++)
        {
            Vector <String> datos = new Vector <String>();
            datos.add(competenciasEncontradas.get(i).getNombreCompetencia());
            datos.add(competenciasEncontradas.get(i).getDeporte().getNombre());
            datos.add(competenciasEncontradas.get(i).getModalidad());
            datos.add(competenciasEncontradas.get(i).getEstado());
            modelo.addRow(datos);
           
                
        }
    }
}
