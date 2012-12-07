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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
  
    private JPanel panelAlta=new JPanel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private ModeloTabla modelo = new ModeloTabla(new String[] { "Lugar De Realizacion" }, 0);
    private ModeloTabla modelo2 = new ModeloTabla(new String[] { "Lugar De Realizacion","Disponibilidad" }, 0);
    private AreaTextoNombre nombreDeLaCompetenciaJTextArea = new AreaTextoNombre(60);
    private DefaultListModel listModel = new DefaultListModel();
    private JLabel jLabelNombreDeLaCompetencia = new JLabel();
    private JLabel jLabelDeporte = new JLabel();
    private JComboBox deporteJComboBox = new JComboBox();
    private JLabel jLabelLugarDeRealizaciˇn = new JLabel();
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
    private JComboBox formaDePuntuaciˇnJComboBox = new JComboBox();
    private JLabel jLabelFormaDePuntuaciˇn = new JLabel();
    private JPanel jPanelFormaDePuntuaciˇnSet = new JPanel();
    private JPanel formaDePuntuaciˇnPuntuaciˇnJPanel = new JPanel();
    private JLabel jLabelCantidadMaximaDeSets = new JLabel();
    private AreaTextoNumerico cantidadMaximaDeSetsJTextArea = new AreaTextoNumerico(2);
    private AreaTextoNumerico tantosPorPartidosGanadosJTextArea = new AreaTextoNumerico(2);
    private JLabel jLabelTantosPorPartidosGanados = new JLabel();
    private JButton quitarJButton = new JButton();
    private AreaTextoNumerico disponibilidadJTextArea = new AreaTextoNumerico(4);
    private JLabel jLabelDisponibilidad = new JLabel();
    private JTable tablaLugarDisponibilidadJTable = new JTable();
    private JButton agregarJButton = new JButton();
    private int tama˝o = 10;
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

    private JTable listaLugaresJTable = new JTable();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JDialog ventanaAnterior=null;
    private Color background = deporteJComboBox.getBackground();
    private Color foreground = deporteJComboBox.getForeground();
    private boolean empate;
    private XYLayout xYLayout2 = new XYLayout();
    private XYLayout xYLayout4 = new XYLayout();
    private JButton aceptarJButton = new JButton();
    private JButton cancelarJButton = new JButton();
    private JScrollPane jScrollPane3 = null;
    private XYLayout xYLayout3 = new XYLayout();


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
        CerrarVentana();

        this.setSize(new Dimension(984, 712));
        this.getContentPane().setLayout(xYLayout2);
        panelAlta.setSize(new Dimension(871, 1255));
        panelAlta.setLayout(xYLayout4);

        nombreDeLaCompetenciaJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreDeLaCompetenciaJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        nombreDeLaCompetenciaJTextArea.setNextFocusableComponent(deporteJComboBox);
        jLabelNombreDeLaCompetencia.setText("Nombre De La Competencia");
        jLabelNombreDeLaCompetencia.setFont(new Font("Tahoma", 0, 13));
        jLabelDeporte.setText("Deporte");
        jLabelDeporte.setFont(new Font("Tahoma", 0, 13));
        deporteJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        deporteJComboBox.setMinimumSize(new Dimension(2, 18));
        deporteJComboBox.setPreferredSize(new Dimension(2, 18));
        deporteJComboBox.setSize(new Dimension(250, 30));
        deporteJComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deporteJComboBox_actionPerformed(e);
            }
        });
        jLabelLugarDeRealizaciˇn.setText("Lugar De Realizaciˇn");
        jLabelLugarDeRealizaciˇn.setFont(new Font("Tahoma", 0, 13));
        jLabelModalidad.setText("Modalidad");
        jLabelModalidad.setFont(new Font("Tahoma", 0, 13));
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
        formaDePuntuaciˇnJComboBox.addItem("Seleccione Una Forma de Puntuaciˇn");
        formaDePuntuaciˇnJComboBox.addItem("Resultado Final");
        formaDePuntuaciˇnJComboBox.addItem("Puntuaciˇn");
        formaDePuntuaciˇnJComboBox.addItem("Sets");
        jLabelReglamento.setText("Reglamento");
        jLabelReglamento.setFont(new Font("Tahoma", 0, 13));
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
        formaDePuntuaciˇnJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        formaDePuntuaciˇnJComboBox.setMinimumSize(new Dimension(2, 18));
        formaDePuntuaciˇnJComboBox.setPreferredSize(new Dimension(2, 18));
        formaDePuntuaciˇnJComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formaDePuntuaciˇnJComboBox_actionPerformed(e);
            }
        });
        jLabelFormaDePuntuaciˇn.setText("Forma de Puntuacion");
        jLabelFormaDePuntuaciˇn.setFont(new Font("Tahoma", 0, 13));
        jPanelFormaDePuntuaciˇnSet.setLayout(null);
        formaDePuntuaciˇnPuntuaciˇnJPanel.setLayout(null);
        jPanelFormaDePuntuaciˇnSet.setBorder(BorderFactory.createTitledBorder("Sets"));
        formaDePuntuaciˇnPuntuaciˇnJPanel.setBorder(BorderFactory.createTitledBorder("Puntuacion"));
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
        formaDePuntuaciˇnPuntuaciˇnJPanel.add(tantosPorPartidosGanadosJTextArea, null);
        formaDePuntuaciˇnPuntuaciˇnJPanel.add(jLabelTantosPorPartidosGanados, null);
        jPanelFormaDePuntuaciˇnSet.add(cantidadMaximaDeSetsJTextArea, null);
        jPanelFormaDePuntuaciˇnSet.add(jLabelCantidadMaximaDeSets, null);
        quitarJButton.setText("Quitar");
        quitarJButton.setFont(new Font("Tahoma", 0, 13));
        quitarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    quitarJButton_actionPerformed(e);
                }
            });
        disponibilidadJTextArea.setFont(new Font("Tahoma", 0, 13));
        disponibilidadJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        disponibilidadJTextArea.setNextFocusableComponent(this);
        jLabelDisponibilidad.setText("Disponibilidad");
        jLabelDisponibilidad.setFont(new Font("Tahoma", 0, 13));
        tablaLugarDisponibilidadJTable.setModel(modelo2);
        agregarJButton.setText("Agregar");
        agregarJButton.setFont(new Font("Tahoma", 0, 13));
        agregarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    agregarJButton_actionPerformed(e);
                }
            });
        editorReglamentoJPanel.setBounds(new Rectangle(30, 385, 710, 275));

        editorReglamentoJPanel.setLayout(null);
        listaLugaresJTable.setModel(modelo);
        reglamentoJPanel.setLayout(xYLayout1);
        jButton1.setText("jButton1");

        //   panel.setPreferredSize(new Dimension(350, 270));

        listaLugaresJTable.addAncestorListener(new AncestorListener() {
                public void ancestorAdded(AncestorEvent e) {
                    listaLugaresJTable_ancestorAdded(e);
                }

                public void ancestorRemoved(AncestorEvent e) {
                }

                public void ancestorMoved(AncestorEvent e) {
                }
            });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        jScrollPane3=new JScrollPane(panelAlta);
        jScrollPane3.getViewport().setLayout(xYLayout3);
        listarDeportes();
        box.setelementos();

        puntosPorPartidoEmpatadoJTextArea.setVisible(false);
        jLabelPuntosPorPartidoEmpatado.setVisible(false);


        modalidadLigaJPanel.setVisible(false);

        jPanelFormaDePuntuaciˇnSet.setVisible(false);
        formaDePuntuaciˇnPuntuaciˇnJPanel.setVisible(false);

        reglamentoJPanel.add(box.getJPanel(), null);
        panel = box.getJScrollPane();
        panel.setSize(350, 270);
        reglamentoJPanel.setPreferredSize(new Dimension(350,270));
        jScrollPane2.getViewport().add(tablaLugarDisponibilidadJTable, null);
        panelAlta.add(jScrollPane2, new XYConstraints(485, 165, 270, 135));
        jScrollPane1.getViewport().add(listaLugaresJTable, null);
        panelAlta.add(jScrollPane1, new XYConstraints(50, 165, 245, 140));
        reglamentoJPanel.add(panel, new XYConstraints(5, 45, 530, 140));
        panelAlta.add(reglamentoJPanel, new XYConstraints(65, 945, 540, 220));
        panelAlta.add(agregarJButton, new XYConstraints(315, 225, 110, 30));
        panelAlta.add(jLabelDisponibilidad, new XYConstraints(315, 150, 110, 25));
        panelAlta.add(disponibilidadJTextArea, new XYConstraints(315, 180, 110, 30));
        panelAlta.add(jPanelFormaDePuntuaciˇnSet, new XYConstraints(70, 700, 475, 75));
        panelAlta.add(jLabelFormaDePuntuaciˇn, new XYConstraints(60, 650, 135, 25));
        panelAlta.add(formaDePuntuaciˇnJComboBox, new XYConstraints(220, 650, 260, 30));
        panelAlta.add(modalidadLigaJPanel, new XYConstraints(60, 390, 495, 245));
        panelAlta.add(jLabelReglamento, new XYConstraints(40, 885, 135, 25));
        panelAlta.add(modalidadJComboBox, new XYConstraints(220, 345, 375, 30));
        panelAlta.add(jLabelModalidad, new XYConstraints(40, 345, 135, 25));
        panelAlta.add(jLabelLugarDeRealizaciˇn, new XYConstraints(305, 115, 135, 25));
        panelAlta.add(deporteJComboBox, new XYConstraints(235, 70, 250, 30));
        panelAlta.add(jLabelDeporte, new XYConstraints(50, 70, 135, 25));
        panelAlta.add(jLabelNombreDeLaCompetencia, new XYConstraints(50, 25, 175, 25));
        panelAlta.add(nombreDeLaCompetenciaJTextArea, new XYConstraints(235, 30, 375, 30));
        panelAlta.add(quitarJButton, new XYConstraints(315, 265, 110, 30));
        panelAlta.add(formaDePuntuaciˇnPuntuaciˇnJPanel, new XYConstraints(70, 790, 475, 75));
        panelAlta.setVisible(true);

        //this.getContentPane().add(panelAlta, new XYConstraints(45, 145, 755, 1165));
        this.getContentPane().add(cancelarJButton, new XYConstraints(535, 635, 85, 25));
        this.getContentPane().add(aceptarJButton, new XYConstraints(215, 640, 80, 25));
        this.getContentPane().add(jScrollPane3, new XYConstraints(30, 15, 855, 570));


    }
    //Metodos

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

         private void formaDePuntuaciˇnJComboBox_actionPerformed(ActionEvent e) {
             formaDePuntuaciˇnJComboBox.setBackground(background);
             formaDePuntuaciˇnJComboBox.setForeground(foreground);
             if (formaDePuntuaciˇnJComboBox.getSelectedItem().equals("Sets"))

             {

                 jPanelFormaDePuntuaciˇnSet.setVisible(true);
                 formaDePuntuaciˇnPuntuaciˇnJPanel.setVisible(false);
             } else if (formaDePuntuaciˇnJComboBox.getSelectedItem().equals("Puntuaciˇn")) {
                 jPanelFormaDePuntuaciˇnSet.setVisible(false);
                 formaDePuntuaciˇnPuntuaciˇnJPanel.setVisible(true);
             } else if (formaDePuntuaciˇnJComboBox.getSelectedItem().equals("Resultado Final")) {
                 jPanelFormaDePuntuaciˇnSet.setVisible(false);
                 formaDePuntuaciˇnPuntuaciˇnJPanel.setVisible(false);
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
                 lugares = LugaresDeRealizacionGestores.lugaresDeRealizaciˇnAsociadosAlDeporte(ussuarioActual.getCorreoElectronico(),codigo );
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
             if(this.formaDePuntuaciˇnJComboBox.getSelectedIndex()<1){
                 errores=errores + "\n        Debe Seleccionar Una Forma de Puntuacion ";
                 formaDePuntuaciˇnJComboBox.setBackground(Color.red);
                 formaDePuntuaciˇnJComboBox.setForeground(Color.white);
             }
             else{
                     if (formaDePuntuaciˇnJComboBox.getSelectedItem().equals("Puntuaciˇn")){
                             if(tantosPorPartidosGanadosJTextArea.getText().equals("")){
                                 this.tantosPorPartidosGanadosJTextArea.error();
                                 errores=errores +"\n        Tantos por partidos ganados no puede ser Vacio";
                             }
                     }
                     if (formaDePuntuaciˇnJComboBox.getSelectedItem().equals("Sets")){
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
             //System.out.println("Errore lenght vale:" +errores.length());
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

                
                 if (formaDePuntuaciˇnJComboBox.getSelectedItem().equals("Sets"))

                 {
                     cantidadDeSets = Integer.parseInt(cantidadMaximaDeSetsJTextArea.getText());
                     tantosPorPartidoAusenciaContrincante=-1;
                 }
                 if (formaDePuntuaciˇnJComboBox.getSelectedItem().equals("Puntuaciˇn")) {
                     tantosPorPartidoAusenciaContrincante = Integer.parseInt(tantosPorPartidosGanadosJTextArea.getText());
                     cantidadDeSets=-1;
                 }
                 if(empate)
                 {
                         puntosPorPartidoEmpatado=Integer.parseInt(puntosPorPartidoEmpatadoJTextArea.getText());
                     }
                
                 else
                     puntosPorPartidoEmpatado=-1;
               //  System.out.println(formaDePuntuaciˇnJComboBox.getSelectedItem().toString());
                 resultado =  CompetenciaGestor.altaCompetencia(ussuarioActual, nombreDeLaCompetenciaJTextArea.getText(), "Liga", formaDePuntuaciˇnJComboBox.getSelectedItem().toString(), "Creada", editor.getText(), this.deporte.get(deporte), lugaresSeleccionados, empate, Integer.parseInt(puntosPorPartidoGanadosJTextArea.getText()),puntosPorPartidoEmpatado,Integer.parseInt(puntosPorPartidoAsistidoJTextArea.getText()),  cantidadDeSets,  tantosPorPartidoAusenciaContrincante);
                 if(resultado){
                         setVisible(false);
                          // cuando se cierra, se pierde los cambios realizados
                         new BuscarCompetenciaDeportiva(ussuarioActual).setVisible(true);
                         dispose();
                     }
             }
         }

         private void listaLugaresJTable_ancestorAdded(AncestorEvent e) {
             listaLugaresJTable();
         }
         private void listaLugaresJTable() {
             listaLugaresJTable.setBackground(Color.white);
             listaLugaresJTable.setForeground(Color.black);
         }
         private void CerrarVentana(){
         addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
             BuscarCompetenciaDeportiva ven = new BuscarCompetenciaDeportiva(ussuarioActual);
             ven.setVisible(true);
             dispose();
            
         }
         });
         }

         private void cancelarJButton_actionPerformed(ActionEvent e) {
             BuscarCompetenciaDeportiva ven = new BuscarCompetenciaDeportiva(ussuarioActual);
             ven.setVisible(true);
             this.dispose();
         }

}
