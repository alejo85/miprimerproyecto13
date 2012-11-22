package ClasesInterfaz;


import ClasesGestores.CompetenciaGestor;
import ClasesGestores.DeporteGestor;
import ClasesGestores.LugaresDeRealizacionGestores;

import ClasesLogicas.Competencia;
import ClasesLogicas.Deporte;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.ModeloTabla;
import ClasesLogicas.Usuario;

import InterfazGrafica.CampoTexto.AreaTextoNombre;
import InterfazGrafica.CampoTexto.AreaTextoNumerico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;


public class AltaCompetenciaDeportiva extends JDialog {
    
    private ModeloTabla modelo = new ModeloTabla(new String[] { "Lugar De Realizacion" }, 0);
    private ModeloTabla modelo2 = new ModeloTabla(new String[] { "Lugar De Realizacion","Disponibilidad" }, 0);
    private AreaTextoNombre nombreDeLaCompetenciaJTextArea = new AreaTextoNombre(60);
    private DefaultListModel listModel = new DefaultListModel();
    private JLabel jLabelNombreDeLaCompetencia = new JLabel();
    private JLabel jLabelDeporte = new JLabel();
    private JComboBox deporteJComboBox = new JComboBox();
    private JLabel jLabelLugarDeRealización = new JLabel();
    private JLabel jLabelModalidad = new JLabel();
    private JComboBox modalidadJComboBox = new JComboBox();
    private JLabel jLabelReglamento = new JLabel();
    private JPanel modalidadLigaJPanel = new JPanel();
    private Usuario ussuarioActual = null;
    private BorderLayout borderLayout1 = new BorderLayout();
    private JLabel jLabelPuntosPorPartidoGanados = new JLabel();
    private AreaTextoNumerico puntosPorPartidoGanadosJTextArea = new AreaTextoNumerico(2);
    private JPanel jPanelEmpate = new JPanel();
    private JRadioButton empateSiJRadioButton = new JRadioButton();
    private JRadioButton empateNoJRadioButton = new JRadioButton();
    private AreaTextoNumerico puntosPorPartidoEmpatadoJTextArea = new AreaTextoNumerico(2);
    private JLabel jLabelPuntosPorPartidoEmpatado = new JLabel();
    private AreaTextoNumerico puntosPorPartidoAsistidoJTextArea = new AreaTextoNumerico(2);
    private JLabel jLabelPuntosPorPartidosAsistido = new JLabel();
    private JComboBox formaDePuntuaciónJComboBox = new JComboBox();
    private JLabel jLabelFormaDePuntuación = new JLabel();
    private JPanel jPanelFormaDePuntuaciónSet = new JPanel();
    private JPanel formaDePuntuaciónPuntuaciónJPanel = new JPanel();
    private JLabel jLabelCantidadMaximaDeSets = new JLabel();
    private AreaTextoNumerico cantidadMaximaDeSetsJTextArea = new AreaTextoNumerico(2);
    private AreaTextoNumerico tantosPorPartidosGanadosJTextArea = new AreaTextoNumerico(2);
    private JLabel jLabelTantosPorPartidosGanados = new JLabel();
    private JButton aceptarJButton = new JButton();
    private JButton cancelarJButton = new JButton();
    private JButton quitarJButton = new JButton();
    private AreaTextoNumerico disponibilidadJTextArea = new AreaTextoNumerico(4);
    private JLabel jLabelDisponibilidad = new JLabel();
    private JTable tablaLugarDisponibilidadJTable = new JTable();
    private JButton agregarJButton = new JButton();
    private int tamaño = 10;
    private String fuenteLetra;
    private JPanel editorReglamentoJPanel = new JPanel();
    private  Vector <Deporte> deporte;
    private  Vector <Competencia> competenciaEncontradas;
    private  Vector<LugarDeRealizacion> lugares;
    private  Vector<LugarDeRealizacion> lugaresSeleccionados=new Vector<LugarDeRealizacion> ();
    private RichTextBox box = new RichTextBox();
    private JPanel reglamentoJPanel = new JPanel();
    private JButton jButton1 = new JButton();
    private JScrollPane panel;
    private XYLayout xYLayout1 = new XYLayout();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTable listaLugaresJTable = new JTable();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JDialog ventanaAnterior=null;
    private Color background = deporteJComboBox.getBackground();
    private Color foreground = deporteJComboBox.getForeground();
    private boolean empate;

    public AltaCompetenciaDeportiva(Usuario usuarioLogueado) {

           this(null, "", false, usuarioLogueado);
       }

       public AltaCompetenciaDeportiva() {

           this(null, "", false);
       }

       public AltaCompetenciaDeportiva(Frame parent, String title, boolean modal, Usuario usuarioLogueado) {
           super(parent, title, modal);
           try {
               this.ussuarioActual = usuarioLogueado;
               jbInit();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }

       public AltaCompetenciaDeportiva(Frame parent, String title, boolean modal) {
           super(parent, title, modal);
           try {

               jbInit();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }


    private void jbInit() throws Exception {
        
        this.setSize(new Dimension(1487, 765));
        this.getContentPane().setLayout(null);
        this.setTitle("Alta Competencia Deportiva");
        nombreDeLaCompetenciaJTextArea.setBounds(new Rectangle(235, 30, 375, 30));
        nombreDeLaCompetenciaJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreDeLaCompetenciaJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        nombreDeLaCompetenciaJTextArea.setNextFocusableComponent(deporteJComboBox);
        jLabelNombreDeLaCompetencia.setText("Nombre De La Competencia");
        jLabelNombreDeLaCompetencia.setBounds(new Rectangle(50, 25, 175, 25));
        jLabelNombreDeLaCompetencia.setFont(new Font("Tahoma", 0, 13));
        jLabelDeporte.setText("Deporte");
        jLabelDeporte.setBounds(new Rectangle(50, 70, 135, 25));
        jLabelDeporte.setFont(new Font("Tahoma", 0, 13));
        deporteJComboBox.setBounds(new Rectangle(235, 70, 240, 30));
        deporteJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        deporteJComboBox.setMinimumSize(new Dimension(2, 18));
        deporteJComboBox.setPreferredSize(new Dimension(2, 18));
        deporteJComboBox.setSize(new Dimension(250, 30));
        deporteJComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deporteJComboBox_actionPerformed(e);
            }
        });
        jLabelLugarDeRealización.setText("Lugar De Realización");
        jLabelLugarDeRealización.setBounds(new Rectangle(50, 115, 135, 25));
        jLabelLugarDeRealización.setFont(new Font("Tahoma", 0, 13));
        jLabelModalidad.setText("Modalidad");
        jLabelModalidad.setBounds(new Rectangle(45, 295, 135, 25));
        jLabelModalidad.setFont(new Font("Tahoma", 0, 13));
        modalidadJComboBox.setBounds(new Rectangle(225, 295, 375, 30));
        modalidadJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        modalidadJComboBox.setMinimumSize(new Dimension(2, 18));
        modalidadJComboBox.setPreferredSize(new Dimension(2, 18));
        modalidadJComboBox.setSize(new Dimension(375, 30));


        modalidadJComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modalidadJComboBox_actionPerformed(e);
            }
        });
        modalidadJComboBox.addItem("Seleccione Una Modalidad");
        modalidadJComboBox.addItem("Sistema de Eliminatoria Simple");
        modalidadJComboBox.addItem("Sistema de Eliminatoria Doble");
        modalidadJComboBox.addItem("Sistema de Liga");
        formaDePuntuaciónJComboBox.addItem("Seleccione Una Forma de Puntuación");
        formaDePuntuaciónJComboBox.addItem("Resultado Final");
        formaDePuntuaciónJComboBox.addItem("Puntuación");
        formaDePuntuaciónJComboBox.addItem("Sets");
        jLabelReglamento.setText("Reglamento");
        jLabelReglamento.setBounds(new Rectangle(45, 340, 135, 25));
        jLabelReglamento.setFont(new Font("Tahoma", 0, 13));
        modalidadLigaJPanel.setBounds(new Rectangle(950, 20, 495, 245));
        modalidadLigaJPanel.setBorder(BorderFactory.createTitledBorder("Modalidad Liga"));
        modalidadLigaJPanel.setLayout(null);
        jLabelPuntosPorPartidoGanados.setText("Puntos Por Partido Ganados");
        jLabelPuntosPorPartidoGanados.setBounds(new Rectangle(20, 25, 175, 25));
        jLabelPuntosPorPartidoGanados.setFont(new Font("Tahoma", 0, 13));
        puntosPorPartidoGanadosJTextArea.setBounds(new Rectangle(230, 25, 240, 30));
        puntosPorPartidoGanadosJTextArea.setFont(new Font("Tahoma", 0, 13));
        puntosPorPartidoGanadosJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        puntosPorPartidoGanadosJTextArea.setNextFocusableComponent(empateSiJRadioButton);
        jPanelEmpate.setBounds(new Rectangle(25, 60, 455, 95));
        jPanelEmpate.setLayout(null);
        jPanelEmpate.setBorder(BorderFactory.createTitledBorder("Empate"));
        empateSiJRadioButton.setText("Si");
        empateSiJRadioButton.setBounds(new Rectangle(25, 20, 85, 20));
        empateSiJRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                empateSiJRadioButton_actionPerformed(e);
            }
        });
        empateNoJRadioButton.setText("No");
        empateNoJRadioButton.setBounds(new Rectangle(135, 20, 90, 20));
        empateNoJRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                empateNoJRadioButton_actionPerformed(e);
            }
        });
        puntosPorPartidoEmpatadoJTextArea.setBounds(new Rectangle(205, 50, 240, 30));
        puntosPorPartidoEmpatadoJTextArea.setFont(new Font("Tahoma", 0, 13));
        puntosPorPartidoEmpatadoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelPuntosPorPartidoEmpatado.setText("Puntos Por Partido Empatados");
        jLabelPuntosPorPartidoEmpatado.setBounds(new Rectangle(20, 55, 175, 25));
        jLabelPuntosPorPartidoEmpatado.setFont(new Font("Tahoma", 0, 13));
        puntosPorPartidoAsistidoJTextArea.setBounds(new Rectangle(265, 165, 160, 30));
        puntosPorPartidoAsistidoJTextArea.setFont(new Font("Tahoma", 0, 13));
        puntosPorPartidoAsistidoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelPuntosPorPartidosAsistido.setText("Puntos Por Partido Asistido");
        jLabelPuntosPorPartidosAsistido.setBounds(new Rectangle(40, 165, 230, 25));
        jLabelPuntosPorPartidosAsistido.setFont(new Font("Tahoma", 0, 13));
        formaDePuntuaciónJComboBox.setBounds(new Rectangle(1155, 295, 260, 30));
        formaDePuntuaciónJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        formaDePuntuaciónJComboBox.setMinimumSize(new Dimension(2, 18));
        formaDePuntuaciónJComboBox.setPreferredSize(new Dimension(2, 18));
        formaDePuntuaciónJComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formaDePuntuaciónJComboBox_actionPerformed(e);
            }
        });
        jLabelFormaDePuntuación.setText("Forma de Puntuacion");
        jLabelFormaDePuntuación.setBounds(new Rectangle(995, 295, 135, 25));
        jLabelFormaDePuntuación.setFont(new Font("Tahoma", 0, 13));
        jPanelFormaDePuntuaciónSet.setBounds(new Rectangle(950, 365, 475, 75));
        jPanelFormaDePuntuaciónSet.setLayout(null);
        formaDePuntuaciónPuntuaciónJPanel.setBounds(new Rectangle(950, 440, 475, 75));
        formaDePuntuaciónPuntuaciónJPanel.setLayout(null);
        jPanelFormaDePuntuaciónSet.setBorder(BorderFactory.createTitledBorder("Sets"));
        formaDePuntuaciónPuntuaciónJPanel.setBorder(BorderFactory.createTitledBorder("Puntuacion"));
        jLabelCantidadMaximaDeSets.setText("Cantidad Maxima De Sets");
        jLabelCantidadMaximaDeSets.setBounds(new Rectangle(20, 25, 165, 25));
        jLabelCantidadMaximaDeSets.setFont(new Font("Tahoma", 0, 13));
        cantidadMaximaDeSetsJTextArea.setBounds(new Rectangle(210, 20, 160, 30));
        cantidadMaximaDeSetsJTextArea.setFont(new Font("Tahoma", 0, 13));
        cantidadMaximaDeSetsJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tantosPorPartidosGanadosJTextArea.setBounds(new Rectangle(210, 25, 160, 25));
        tantosPorPartidosGanadosJTextArea.setFont(new Font("Tahoma", 0, 13));
        tantosPorPartidosGanadosJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelTantosPorPartidosGanados.setText("Tantos Por Partido Ganados");
        jLabelTantosPorPartidosGanados.setBounds(new Rectangle(20, 25, 160, 25));
        jLabelTantosPorPartidosGanados.setFont(new Font("Tahoma", 0, 13));
        jPanelEmpate.add(empateSiJRadioButton, null);
        jPanelEmpate.add(empateNoJRadioButton, null);
        jPanelEmpate.add(puntosPorPartidoEmpatadoJTextArea, null);
        jPanelEmpate.add(jLabelPuntosPorPartidoEmpatado, null);
        modalidadLigaJPanel.add(jPanelEmpate, null);
        modalidadLigaJPanel.add(puntosPorPartidoGanadosJTextArea, null);
        modalidadLigaJPanel.add(jLabelPuntosPorPartidoGanados, null);
        modalidadLigaJPanel.add(jLabelPuntosPorPartidosAsistido, null);
        modalidadLigaJPanel.add(puntosPorPartidoAsistidoJTextArea, null);


        formaDePuntuaciónPuntuaciónJPanel.add(tantosPorPartidosGanadosJTextArea, null);
        formaDePuntuaciónPuntuaciónJPanel.add(jLabelTantosPorPartidosGanados, null);
        jPanelFormaDePuntuaciónSet.add(cantidadMaximaDeSetsJTextArea, null);
        jPanelFormaDePuntuaciónSet.add(jLabelCantidadMaximaDeSets, null);
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(490, 670, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(680, 670, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));

   
        quitarJButton.setText("Quitar");
        quitarJButton.setBounds(new Rectangle(500, 225, 110, 30));
        quitarJButton.setFont(new Font("Tahoma", 0, 13));
        quitarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    quitarJButton_actionPerformed(e);
                }
            });
        disponibilidadJTextArea.setBounds(new Rectangle(500, 140, 110, 30));
        disponibilidadJTextArea.setFont(new Font("Tahoma", 0, 13));
        disponibilidadJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        disponibilidadJTextArea.setNextFocusableComponent(this);
        jLabelDisponibilidad.setText("Disponibilidad");
        jLabelDisponibilidad.setBounds(new Rectangle(500, 110, 110, 25));
        jLabelDisponibilidad.setFont(new Font("Tahoma", 0, 13));
        tablaLugarDisponibilidadJTable.setModel(modelo2);
        agregarJButton.setText("Agregar");
        agregarJButton.setBounds(new Rectangle(500, 185, 110, 30));
        agregarJButton.setFont(new Font("Tahoma", 0, 13));
        agregarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    agregarJButton_actionPerformed(e);
                }
            });
        editorReglamentoJPanel.setBounds(new Rectangle(30, 385, 710, 275));

        editorReglamentoJPanel.setLayout(null);
        listaLugaresJTable.setModel(modelo);
        reglamentoJPanel.setBounds(new Rectangle(65, 415, 540, 220));
        reglamentoJPanel.setLayout(xYLayout1);
        jButton1.setText("jButton1");

     //   panel.setPreferredSize(new Dimension(350, 270));

        jScrollPane1.setBounds(new Rectangle(235, 125, 245, 140));
        listaLugaresJTable.addAncestorListener(new AncestorListener() {
                public void ancestorAdded(AncestorEvent e) {
                    listaLugaresJTable_ancestorAdded(e);
                }

                public void ancestorRemoved(AncestorEvent e) {
                }

                public void ancestorMoved(AncestorEvent e) {
                }
            });
        jScrollPane2.setBounds(new Rectangle(670, 125, 270, 135));
        listarDeportes();
        box.setelementos();

        puntosPorPartidoEmpatadoJTextArea.setVisible(false);
        jLabelPuntosPorPartidoEmpatado.setVisible(false);


        modalidadLigaJPanel.setVisible(false);

        jPanelFormaDePuntuaciónSet.setVisible(false);
        formaDePuntuaciónPuntuaciónJPanel.setVisible(false);

        reglamentoJPanel.add(box.getJPanel(), null);
        panel = box.getJScrollPane();
        panel.setSize(350, 270);
        reglamentoJPanel.setPreferredSize(new Dimension(350,270));
        reglamentoJPanel.add(panel, new XYConstraints(5, 45, 530, 140));
        jScrollPane1.getViewport().add(listaLugaresJTable, null);
        jScrollPane2.getViewport().add(tablaLugarDisponibilidadJTable, null);
        this.getContentPane().add(jScrollPane2, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(reglamentoJPanel, null);
        this.getContentPane().add(agregarJButton, null);
        this.getContentPane().add(jLabelDisponibilidad, null);
        this.getContentPane().add(disponibilidadJTextArea, null);
        this.getContentPane().add(aceptarJButton);
        this.getContentPane().add(cancelarJButton);
        this.getContentPane().add(jPanelFormaDePuntuaciónSet, null);
        this.getContentPane().add(jLabelFormaDePuntuación, null);
        this.getContentPane().add(formaDePuntuaciónJComboBox, null);
        this.getContentPane().add(modalidadLigaJPanel, null);
        this.getContentPane().add(jLabelReglamento, null);
        this.getContentPane().add(modalidadJComboBox, null);
        this.getContentPane().add(jLabelModalidad, null);
        this.getContentPane().add(jLabelLugarDeRealización, null);
        this.getContentPane().add(deporteJComboBox, null);
        this.getContentPane().add(jLabelDeporte, null);
        this.getContentPane().add(jLabelNombreDeLaCompetencia, null);
        this.getContentPane().add(nombreDeLaCompetenciaJTextArea, null);
        this.getContentPane().add(quitarJButton, null);
        this.getContentPane().add(formaDePuntuaciónPuntuaciónJPanel, null);


    }
    //Metodos

    /**
     * @param
     * @return
     */
    private void listarDeportes() {
        deporte = buscarDeportes(); //todo ver que devuelve buscarDeportes en clasesBD
        deporteJComboBox.addItem("Seleccionar Deporte");
        for(int i=0; i<deporte.size();i++){
        deporteJComboBox.addItem(deporte.get(i).getNombre());
        }
    }

    private  Vector <Deporte> buscarDeportes() {

        return DeporteGestor.instanciarDeportes();
    }
    //aca empiezan los action performers

    private void empateSiJRadioButton_actionPerformed(ActionEvent e) {
        empate=true;
        empateNoJRadioButton.setSelected(false);
        puntosPorPartidoEmpatadoJTextArea.setVisible(true);
        jLabelPuntosPorPartidoEmpatado.setVisible(true);

    }

    private void empateNoJRadioButton_actionPerformed(ActionEvent e) {
        empate=false;
        empateSiJRadioButton.setSelected(false);
        puntosPorPartidoEmpatadoJTextArea.setVisible(false);
        jLabelPuntosPorPartidoEmpatado.setVisible(false);
    }

    private void modalidadJComboBox_actionPerformed(ActionEvent e) {
        modalidadJComboBox.setBackground(background);
        modalidadJComboBox.setForeground(foreground);
        if (modalidadJComboBox.getSelectedItem().equals("Sistema de Liga")) {
            modalidadLigaJPanel.setVisible(true);
        } else
            modalidadLigaJPanel.setVisible(false);
    }

    private void formaDePuntuaciónJComboBox_actionPerformed(ActionEvent e) {
        formaDePuntuaciónJComboBox.setBackground(background);
        formaDePuntuaciónJComboBox.setForeground(foreground);
        if (formaDePuntuaciónJComboBox.getSelectedItem().equals("Sets"))

        {

            jPanelFormaDePuntuaciónSet.setVisible(true);
            formaDePuntuaciónPuntuaciónJPanel.setVisible(false);
        } else if (formaDePuntuaciónJComboBox.getSelectedItem().equals("Puntuación")) {
            jPanelFormaDePuntuaciónSet.setVisible(false);
            formaDePuntuaciónPuntuaciónJPanel.setVisible(true);
        } else if (formaDePuntuaciónJComboBox.getSelectedItem().equals("Resultado Final")) {
            jPanelFormaDePuntuaciónSet.setVisible(false);
            formaDePuntuaciónPuntuaciónJPanel.setVisible(false);
        }


    }

   
    private void deporteJComboBox_actionPerformed(ActionEvent e) {
        deporteJComboBox.setBackground(background);
        deporteJComboBox.setForeground(foreground);
        listaLugaresJTable();
        if(deporteJComboBox.getSelectedIndex()>0)
        {
         cargarLugaresDeRealizacion();
        }
        
    }
    private void cargarLugaresDeRealizacion() {
        int deporte = this.deporteJComboBox.getSelectedIndex();
        deporte--;
        int codigo = this.deporte.get(deporte).getIdDeporte();
        
        try {
            lugares = LugaresDeRealizacionGestores.lugaresDeRealizaciónAsociadosAlDeporte(ussuarioActual.getCorreoElectronico(),codigo );
            cargarLugares();
            removerSelecionados();
        } 
        catch (SQLException f) {
            System.out.println(f.getMessage());
        }
        
    }
    
    private void cargarLugares(){
        
        modelo = new ModeloTabla(new String[] { "Lugar De Realizacion" }, 0);
        listaLugaresJTable.setModel(modelo);
        for(int i =0; i<lugares.size();i++)
        {
            Vector <String> datos = new Vector <String>();
            datos.add(lugares.get(i).getNombre());
            modelo.addRow(datos);
           
                
        }
        
        }
    private void cargarLugaresSeleccionados(){
        
        modelo2 = new ModeloTabla(new String[] { "Lugar De Realizacion","Disponibilidad" }, 0);
            tablaLugarDisponibilidadJTable.setModel(modelo2);
        for(int i =0; i<lugaresSeleccionados.size();i++)
        {
            Vector <String> datos = new Vector <String>();
            datos.add(lugaresSeleccionados.get(i).getNombre());
            datos.add(lugaresSeleccionados.get(i).getDisponibilidadString());
            modelo2.addRow(datos);
           
                
        }
        
        }
    private void removerSelecionados(){
        
        modelo2 = new ModeloTabla(new String[] { "Lugar De Realizacion","Disponibilidad" }, 0);
            tablaLugarDisponibilidadJTable.setModel(modelo2);
            lugaresSeleccionados.removeAllElements();
        
        }
    private void agregarJButton_actionPerformed(ActionEvent e) {
        int row =listaLugaresJTable.getSelectedRow();
        
        if(row>-1&&!disponibilidadJTextArea.getText().equals("")){
                LugarDeRealizacion unLugar = lugares.get(row);
                
                unLugar.setDisponibilidad(Integer.parseInt(disponibilidadJTextArea.getText()));
                lugaresSeleccionados.add(unLugar);
                lugares.remove(row);
                cargarLugares();
                disponibilidadJTextArea.setText("");
                cargarLugaresSeleccionados();
            }
    }

    private void quitarJButton_actionPerformed(ActionEvent e) {
        int row =tablaLugarDisponibilidadJTable.getSelectedRow();
        
        
        if(row>-1){
                LugarDeRealizacion unLugar = lugaresSeleccionados.get(row);
                unLugar.setDisponibilidad(0);
                lugares.add(unLugar);
                lugaresSeleccionados.remove(row);
                cargarLugares();
                
                cargarLugaresSeleccionados();
            }
    }

    
    private Boolean datosValidosRegistro(){
        String errores="";
        String errores2="";

     
      
          if(nombreDeLaCompetenciaJTextArea.getText().equals("")){
              this.nombreDeLaCompetenciaJTextArea.error();
              errores=errores +"\n        Nombre de la Competencia Vacio";
          }
        if(this.deporteJComboBox.getSelectedIndex()<1){
            errores=errores + "\n        Debe Seleccionar Un Deporte ";
            deporteJComboBox.setBackground(Color.red);
            deporteJComboBox.setForeground(Color.white);
        }
        if(this.lugaresSeleccionados.size()<1){
            errores=errores + "\n        Debe Seleccionar Un Lugar de Relaizacion ";
            listaLugaresJTable.setBackground(Color.red);
            listaLugaresJTable.setForeground(Color.white);
        }
        if(this.modalidadJComboBox.getSelectedIndex()<1){
            errores=errores + "\n        Debe Seleccionar Una Modalidad ";
            modalidadJComboBox.setBackground(Color.red);
            modalidadJComboBox.setForeground(Color.white);
        }
        else{
            if(this.modalidadJComboBox.getSelectedItem().equals("Sistema de Liga")){
                    if(puntosPorPartidoGanadosJTextArea.getText().equals("")){
                        this.puntosPorPartidoGanadosJTextArea.error();
                        errores=errores +"\n        Puntos por partido ganados no puede ser Vacio";
                    }
                if(empate){
                    if(puntosPorPartidoEmpatadoJTextArea.getText().equals("")){
                        this.puntosPorPartidoEmpatadoJTextArea.error();
                        errores=errores +"\n        Puntos por partido empatados no puede ser Vacio";
                    }
                }
                if(puntosPorPartidoAsistidoJTextArea.getText().equals("")){
                    this.puntosPorPartidoAsistidoJTextArea.error();
                    errores=errores +"\n        Puntos por partido asistido no puede ser Vacio";
                }
            
            }
            else{
                    JOptionPane.showOptionDialog(null, "Modalidad no Disponible:" , "Errores al Seleccionar Disponivilidad", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
                
                }
        }
        if(this.formaDePuntuaciónJComboBox.getSelectedIndex()<1){
            errores=errores + "\n        Debe Seleccionar Una Forma de Puntuacion ";
            formaDePuntuaciónJComboBox.setBackground(Color.red);
            formaDePuntuaciónJComboBox.setForeground(Color.white);
        }
        else{
                if (formaDePuntuaciónJComboBox.getSelectedItem().equals("Puntuación")){
                        if(tantosPorPartidosGanadosJTextArea.getText().equals("")){
                            this.tantosPorPartidosGanadosJTextArea.error();
                            errores=errores +"\n        Tantos por partidos ganados no puede ser Vacio";
                        }
                }
                if (formaDePuntuaciónJComboBox.getSelectedItem().equals("Sets")){
                    if(cantidadMaximaDeSetsJTextArea.getText().equals("")){
                        this.cantidadMaximaDeSetsJTextArea.error();
                        errores=errores +"\n        La Cantidad de Set no puede ser Vacio";
                    }
                }
            
            
            
            
            }
        try {
            if(CompetenciaGestor.validarNombreDeCompetencia(nombreDeLaCompetenciaJTextArea.getText(), ussuarioActual.getCorreoElectronico())){
                errores= errores +"\n        Nombre de la Competencia Ya usado";
                this.nombreDeLaCompetenciaJTextArea.error();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Errore lenght vale:" +errores.length());
        if(errores.length()>0){
            JOptionPane.showOptionDialog(null, "Tienes los siguientes errores:"+errores2+errores  , "Errores en campos", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
            return false;
        }
        else{
            return true;
        }

    }
    private void aceptarJButton_actionPerformed(ActionEvent e) {
        boolean resultado;
        if(datosValidosRegistro())
        {
            int deporte = this.deporteJComboBox.getSelectedIndex();
            int cantidadDeSets =-1, tantosPorPartidoAusenciaContrincante=-1,puntosPorPartidoEmpatado=-1;
            deporte--;
            JEditorPane editor = box.textPane();

            
            if (formaDePuntuaciónJComboBox.getSelectedItem().equals("Sets"))

            {
                cantidadDeSets = Integer.parseInt(cantidadMaximaDeSetsJTextArea.getText());
                tantosPorPartidoAusenciaContrincante=-1;
            } 
            if (formaDePuntuaciónJComboBox.getSelectedItem().equals("Puntuación")) {
                tantosPorPartidoAusenciaContrincante = Integer.parseInt(tantosPorPartidosGanadosJTextArea.getText());
                cantidadDeSets=-1;
            }
            if(empate)
            {
                    puntosPorPartidoEmpatado=Integer.parseInt(puntosPorPartidoEmpatadoJTextArea.getText());
                }
            
            else
                puntosPorPartidoEmpatado=-1;
            System.out.println(formaDePuntuaciónJComboBox.getSelectedItem().toString());
            resultado =  CompetenciaGestor.altaCompetencia(ussuarioActual, nombreDeLaCompetenciaJTextArea.getText(), "Liga", formaDePuntuaciónJComboBox.getSelectedItem().toString(), "Creada", editor.getText(), this.deporte.get(deporte), lugaresSeleccionados, empate, Integer.parseInt(puntosPorPartidoGanadosJTextArea.getText()),puntosPorPartidoEmpatado,Integer.parseInt(puntosPorPartidoAsistidoJTextArea.getText()),  cantidadDeSets,  tantosPorPartidoAusenciaContrincante);
            
        }
    }

    private void listaLugaresJTable_ancestorAdded(AncestorEvent e) {
        listaLugaresJTable();
    }
    private void listaLugaresJTable() {
        listaLugaresJTable.setBackground(Color.white);
        listaLugaresJTable.setForeground(Color.black);
    }
}
