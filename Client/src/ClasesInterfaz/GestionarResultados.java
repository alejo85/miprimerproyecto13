package ClasesInterfaz;


import ClasesGestores.CompetenciaGestor;
import ClasesGestores.EncuentroGestor;

import ClasesGestores.FixtureGestor;
import ClasesGestores.RondaGestor;

import ClasesLogicas.Competencia;
import ClasesLogicas.Encuentro;
import ClasesLogicas.ModeloTabla;
import ClasesLogicas.Participante;
import ClasesLogicas.Usuario;

import InterfazGrafica.CampoTexto.AreaTextoNumerico;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class GestionarResultados extends JDialog {
    private ModeloTabla modeloDeTablaDeSets = new ModeloTabla(new String[] { "Nº", "Equipo A", "Equipo B", }, 0);
    private JButton cancelarJButton = new JButton();
    private JButton aceptarJButton = new JButton();
    private JPanel setsJPanel = new JPanel();
    private JLabel equipoAJLabel= new JLabel();
    private JLabel equipoBJLabel= new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTable tablaDeSetsJTable = new JTable();
    private JButton modificarSetJButton = new JButton();
    private JPanel puntuacionJPanel = new JPanel();
    private JLabel jLabelPuntosEquipoB = new JLabel();
    private JLabel jLabelPuntosEquipoA = new JLabel();
    private AreaTextoNumerico puntosEquipoAJTextArea = new AreaTextoNumerico(2);
    private AreaTextoNumerico puntosEquipoBJTextArea = new AreaTextoNumerico(2);
    private JPanel resultadoFinalJPanel = new JPanel();
    private JRadioButton ganadorEquipoAJRadioButton = new JRadioButton();
    private JRadioButton ganadorEquipoBJRadioButton = new JRadioButton();
    private JRadioButton empateJRadioButton = new JRadioButton();
    private JPanel equipoPresenteJPanel = new JPanel();
    private JRadioButton presenteEquipoBJRadioButton = new JRadioButton();
    private JRadioButton presenteEquipoAmbosJRadioButton = new JRadioButton();
    private JRadioButton presenteEquipoAJRadioButton = new JRadioButton();
    private Competencia competenciaActual=null;
    private Encuentro encuentroSeleccionado=null;
    private int nroRonda=0;
    private Usuario usuarioAcatual = null;
    private Vector <String> sets=null;
    private JPanel asistenciaSetsJPanel = new JPanel();
    private JRadioButton equipoASetJRadioButton = new JRadioButton();
    private JRadioButton equipoBSetJRadioButton = new JRadioButton();
    private JRadioButton equipoAmbosSetJRadioButton = new JRadioButton();
    private JPanel resultadoFinalAsistenciaJPanel = new JPanel();
    private FlowLayout flowLayout1 = new FlowLayout();
    private JRadioButton resultaoFinalAsistenciaAJRadioButton = new JRadioButton();
    private JRadioButton resultaoFinalAsistenciaBJRadioButton = new JRadioButton();
    private JRadioButton resultaoFinalAsistenciaAmbosJRadioButton = new JRadioButton();
    private FlowLayout flowLayout2 = new FlowLayout();
    private FlowLayout flowLayout3 = new FlowLayout();
    private FlowLayout flowLayout4 = new FlowLayout();


    public GestionarResultados(Competencia competenciaSeleccionada, Usuario usuario , Encuentro encuentro, int ronda) {
 
            this(null, "", false,  competenciaSeleccionada,  usuario, encuentro, ronda);

       
    }

    public GestionarResultados(Frame parent, String title, boolean modal,Competencia competenciaSeleccionada, Usuario usuario, Encuentro encuentro, int ronda) {
        super(parent, title, modal);
   
            competenciaActual=competenciaSeleccionada;
            encuentroSeleccionado=encuentro;
            usuarioAcatual=usuario;
            nroRonda=ronda;
         

            if(competenciaActual.getFormaDePuntuacion().equals("Resultado Final"))


            try {
             
               
                if(competenciaActual.getLiga().getEmpate())
                {
                        jbInitResultadoFinalEmpateSi();
                    }
                else
                {
                    jbInitResultadoFinalEmpateNo();
                    }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        if(competenciaActual.getFormaDePuntuacion().equals("Puntuación"))
            try {
           jbInitPuntuacion();
            } catch (Exception e) {
            }

        if(competenciaActual.getFormaDePuntuacion().equals("Sets"))
            try {
              jbInitSet();
             
            } catch (Exception e) {
            }


    }
    private void jbInit() throws Exception {
        CerrarVentana();
        this.setSize(new Dimension(578, 578));
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout( null );
        this.setTitle("Gestionar Resultados");
        this.setResizable(false);
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(340, 460, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarJButton_actionPerformed(e);
            }
        });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(110, 460, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 aceptarJButton_actionPerformed(e);
             }
         });
        setsJPanel.setBounds(new Rectangle(110, 155, 340, 265));
        asistenciaSetsJPanel.setBorder(BorderFactory.createTitledBorder("Asistencia"));
        setsJPanel.setLayout(null);
        setsJPanel.setBorder(BorderFactory.createTitledBorder("Sets"));
        jScrollPane1.setBounds(new Rectangle(15, 25, 170, 220));
        modificarSetJButton.setText("Modificar");
        modificarSetJButton.setBounds(new Rectangle(215, 80, 110, 30));
        modificarSetJButton.setFont(new Font("Tahoma", 0, 13));
        modificarSetJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarSetJButton_actionPerformed(e);
            }
        });

        tablaDeSetsJTable.setModel(modeloDeTablaDeSets);
        asistenciaSetsJPanel.setBounds(new Rectangle(110, 65, 335, 60));
        equipoASetJRadioButton.setText(encuentroSeleccionado.getParticipanteA().getNombre());
        equipoASetJRadioButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 equipoASetJRadioButton_actionPerformed(e);
             }
         });
        setsJPanel.setVisible(false);
        equipoBSetJRadioButton.setText(encuentroSeleccionado.getParticipanteB().getNombre());
        equipoBSetJRadioButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 equipoBSetJRadioButton_actionPerformed(e);
             }
         });
        equipoAmbosSetJRadioButton.setText("Ambos");
        equipoAmbosSetJRadioButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 equipoAmbosSetJRadioButton_actionPerformed(e);
             }
         });
        jScrollPane1.getViewport().add(tablaDeSetsJTable, null);
        setsJPanel.add(jScrollPane1, null);
        setsJPanel.add(modificarSetJButton, null);
        asistenciaSetsJPanel.add(equipoASetJRadioButton, null);
        asistenciaSetsJPanel.add(equipoBSetJRadioButton, null);
        asistenciaSetsJPanel.add(equipoAmbosSetJRadioButton, null);
        this.getContentPane().add(asistenciaSetsJPanel, null);
        this.getContentPane().add(setsJPanel, null);
        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(cancelarJButton, null);
        cargarDatos();
        
       

    }
       
     



   
    private void jbInitSet() throws Exception {
   
        CerrarVentana();
        this.setSize(new Dimension(578, 578));
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout( null );
        this.setTitle("Gestionar Resultados");
        this.setResizable(false);
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(340, 460, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarJButton_actionPerformed(e);
            }
        });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(110, 460, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 aceptarJButton_actionPerformed(e);
             }
         });
        setsJPanel.setBounds(new Rectangle(110, 155, 340, 265));
        asistenciaSetsJPanel.setBorder(BorderFactory.createTitledBorder("Asistencia"));
        setsJPanel.setLayout(null);
        setsJPanel.setBorder(BorderFactory.createTitledBorder("Sets"));
        jScrollPane1.setBounds(new Rectangle(15, 25, 170, 220));
        modificarSetJButton.setText("Modificar");
        modificarSetJButton.setBounds(new Rectangle(215, 80, 110, 30));
        modificarSetJButton.setFont(new Font("Tahoma", 0, 13));
        modificarSetJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarSetJButton_actionPerformed(e);
            }
        });

        tablaDeSetsJTable.setModel(modeloDeTablaDeSets);
        asistenciaSetsJPanel.setBounds(new Rectangle(110, 65, 335, 60));
        equipoASetJRadioButton.setText(encuentroSeleccionado.getParticipanteA().getNombre());
        equipoASetJRadioButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 equipoASetJRadioButton_actionPerformed(e);
             }
         });
        setsJPanel.setVisible(false);
        equipoBSetJRadioButton.setText(encuentroSeleccionado.getParticipanteB().getNombre());
        equipoBSetJRadioButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 equipoBSetJRadioButton_actionPerformed(e);
             }
         });
        equipoAmbosSetJRadioButton.setText("Ambos");
        equipoAmbosSetJRadioButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 equipoAmbosSetJRadioButton_actionPerformed(e);
             }
         });
        jScrollPane1.getViewport().add(tablaDeSetsJTable, null);
        setsJPanel.add(jScrollPane1, null);
        setsJPanel.add(modificarSetJButton, null);
        asistenciaSetsJPanel.add(equipoASetJRadioButton, null);
        asistenciaSetsJPanel.add(equipoBSetJRadioButton, null);
        asistenciaSetsJPanel.add(equipoAmbosSetJRadioButton, null);
        this.getContentPane().add(asistenciaSetsJPanel, null);
        this.getContentPane().add(setsJPanel, null);
        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(cancelarJButton, null);
        cargarDatos();
    }
    private void jbInitPuntuacion() throws Exception {
           CerrarVentana();
           this.setSize(new Dimension(543, 486));
           this.setLocationRelativeTo(null);
               this.getContentPane().setLayout( null );
               this.setTitle("Gestionar Resultados");
               cancelarJButton.setText("Cancelar");
               cancelarJButton.setBounds(new Rectangle(335, 385, 110, 30));
               cancelarJButton.setFont(new Font("Tahoma", 0, 13));
               cancelarJButton.setSize(new Dimension(110, 30));
               cancelarJButton.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                           cancelarJButton_actionPerformed(e);
                       }
                   });
               aceptarJButton.setText("Aceptar");
               aceptarJButton.setBounds(new Rectangle(80, 385, 110, 30));
               aceptarJButton.setFont(new Font("Tahoma", 0, 13));
           aceptarJButton.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                       aceptarJButton_actionPerformed(e);
                   }
               });
           puntuacionJPanel.setBounds(new Rectangle(80, 95, 370, 260));
               puntuacionJPanel.setLayout(null);
               puntuacionJPanel.setBorder(BorderFactory.createTitledBorder("Puntuación"));

               equipoAJLabel.setBounds(new Rectangle(85, 50, 135, 25));
               equipoAJLabel.setFont(new Font("Tahoma", 0, 13));
           
               equipoBJLabel.setBounds(new Rectangle(310, 50, 135, 25));
               equipoBJLabel.setFont(new Font("Tahoma", 0, 13));
               jLabelPuntosEquipoB.setText("Puntos "+encuentroSeleccionado.getParticipanteA().getNombre());
               jLabelPuntosEquipoB.setBounds(new Rectangle(210, 170, 135, 25));
               jLabelPuntosEquipoB.setFont(new Font("Tahoma", 0, 13));
               jLabelPuntosEquipoA.setText("Puntos "+encuentroSeleccionado.getParticipanteB().getNombre());
               jLabelPuntosEquipoA.setBounds(new Rectangle(15, 170, 135, 25));
               jLabelPuntosEquipoA.setFont(new Font("Tahoma", 0, 13));
               puntosEquipoAJTextArea.setBounds(new Rectangle(10, 200, 130, 30));
               puntosEquipoAJTextArea.setFont(new Font("Tahoma", 0, 13));
               puntosEquipoAJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
               puntosEquipoBJTextArea.setBounds(new Rectangle(190, 200, 130, 30));
               puntosEquipoBJTextArea.setFont(new Font("Tahoma", 0, 13));
               puntosEquipoBJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
           equipoPresenteJPanel.setBounds(new Rectangle(20, 45, 330, 90));
               equipoPresenteJPanel.setLayout(flowLayout4);
               equipoPresenteJPanel.setBorder(BorderFactory.createTitledBorder("Equipo Presente"));
               presenteEquipoBJRadioButton.setText("Equipo "+encuentroSeleccionado.getParticipanteB().getNombre());
           presenteEquipoBJRadioButton.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                           presenteEquipoBJRadioButton_actionPerformed(e);
                       }
                   });
               presenteEquipoAmbosJRadioButton.setText("Ambos");
           presenteEquipoAmbosJRadioButton.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                           presenteEquipoAmbosJRadioButton_actionPerformed(e);
                       }
                   });
               presenteEquipoAJRadioButton.setText("Equipo "+encuentroSeleccionado.getParticipanteA().getNombre());
           presenteEquipoAJRadioButton.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                           presenteEquipoAJRadioButton_actionPerformed(e);
                       }
                   });
           jLabelPuntosEquipoA.setVisible(false);
               jLabelPuntosEquipoB.setVisible(false);
               puntosEquipoAJTextArea.setVisible(false);
               puntosEquipoBJTextArea.setVisible(false);
           this.getContentPane().add(equipoBJLabel, null);
           this.getContentPane().add(equipoAJLabel, null);
           this.getContentPane().add(puntuacionJPanel, null);
           this.getContentPane().add(aceptarJButton, null);
           this.getContentPane().add(cancelarJButton, null);
           equipoPresenteJPanel.add(presenteEquipoAJRadioButton, null);
           equipoPresenteJPanel.add(presenteEquipoBJRadioButton, null);
           equipoPresenteJPanel.add(presenteEquipoAmbosJRadioButton, null);
           puntuacionJPanel.add(equipoPresenteJPanel, null);
           puntuacionJPanel.add(jLabelPuntosEquipoA, null);
           puntuacionJPanel.add(jLabelPuntosEquipoB, null);
           puntuacionJPanel.add(puntosEquipoAJTextArea, null);
           puntuacionJPanel.add(puntosEquipoBJTextArea, null);
           
           cargarDatos();
       }

    private void jbInitResultadoFinalEmpateSi() throws Exception {
        CerrarVentana();
        this.setSize(new Dimension(596, 379));
        this.setLocationRelativeTo(null);
            this.getContentPane().setLayout( null );
            this.setTitle("Gestionar Resultados");
        this.setResizable(false);
            cancelarJButton.setText("Cancelar");
            cancelarJButton.setBounds(new Rectangle(320, 260, 110, 30));
            cancelarJButton.setFont(new Font("Tahoma", 0, 13));
            cancelarJButton.setSize(new Dimension(110, 30));
            cancelarJButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cancelarJButton_actionPerformed(e);
                    }
                });
            aceptarJButton.setText("Aceptar");
            aceptarJButton.setBounds(new Rectangle(130, 260, 110, 30));
            aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });

            equipoAJLabel.setBounds(new Rectangle(50, 25, 135, 25));
            equipoAJLabel.setFont(new Font("Tahoma", 0, 13));

            equipoBJLabel.setBounds(new Rectangle(390, 25, 135, 25));
            equipoBJLabel.setFont(new Font("Tahoma", 0, 13));
        resultadoFinalJPanel.setBounds(new Rectangle(50, 145, 475, 90));
            resultadoFinalJPanel.setLayout(flowLayout3);
            resultadoFinalJPanel.setBorder(BorderFactory.createTitledBorder("Resultado Final"));
            empateJRadioButton.setText("Empate");

        empateJRadioButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        empateJRadioButton_actionPerformed(e);
                    }
                });
        resultadoFinalJPanel.setVisible(false);
        resultadoFinalAsistenciaJPanel.setBounds(new Rectangle(50, 30, 475, 90));
        resultadoFinalAsistenciaJPanel.setLayout(flowLayout1);
        resultadoFinalAsistenciaJPanel.setBorder(BorderFactory.createTitledBorder("Asistencia De Participantes"));
        resultaoFinalAsistenciaAJRadioButton.setText("Presente: "+encuentroSeleccionado.getParticipanteA().getNombre());
        resultaoFinalAsistenciaAJRadioButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 resultaoFinalAsistenciaAJRadioButton_actionPerformed(e);
             }
         });
        resultaoFinalAsistenciaBJRadioButton.setText("Presente: "+encuentroSeleccionado.getParticipanteB().getNombre());
        resultaoFinalAsistenciaBJRadioButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 resultaoFinalAsistenciaBJRadioButton_actionPerformed(e);
             }
         });
        resultaoFinalAsistenciaAmbosJRadioButton.setText("Presente: Ambos");
        resultaoFinalAsistenciaAmbosJRadioButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 resultaoFinalAsistenciaAmbosJRadioButton_actionPerformed(e);
             }
         });
        ganadorEquipoAJRadioButton.setText("Ganador "+encuentroSeleccionado.getParticipanteA().getNombre());
        ganadorEquipoAJRadioButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ganadorEquipoAJRadioButton_actionPerformed(e);
                    }
                });
            ganadorEquipoBJRadioButton.setText("Ganador "+encuentroSeleccionado.getParticipanteB().getNombre());
        ganadorEquipoBJRadioButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ganadorEquipoBJRadioButton_actionPerformed(e);
                    }
                });
        resultadoFinalJPanel.add(ganadorEquipoAJRadioButton, null);
        resultadoFinalJPanel.add(empateJRadioButton, null);
        resultadoFinalJPanel.add(ganadorEquipoBJRadioButton, null);
        resultadoFinalAsistenciaJPanel.add(resultaoFinalAsistenciaAJRadioButton, null);
        resultadoFinalAsistenciaJPanel.add(resultaoFinalAsistenciaBJRadioButton, null);
        resultadoFinalAsistenciaJPanel.add(resultaoFinalAsistenciaAmbosJRadioButton, null);
        this.getContentPane().add(resultadoFinalAsistenciaJPanel, null);
        this.getContentPane().add(resultadoFinalJPanel, null);
        this.getContentPane().add(equipoBJLabel, null);
        this.getContentPane().add(equipoAJLabel, null);


        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(cancelarJButton, null);
        cargarDatos();
        
    }
    private void jbInitResultadoFinalEmpateNo() throws Exception {
        CerrarVentana();
        this.setSize(new Dimension(596, 348));
        this.getContentPane().setLayout( null );
        this.setTitle("Gestionar Resultados");
        
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(320, 255, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarJButton_actionPerformed(e);
            }
        });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(130, 255, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        
        aceptarJButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         aceptarJButton_actionPerformed(e);
        }
        });
        equipoAJLabel.setBounds(new Rectangle(50, 25, 135, 25));
        equipoAJLabel.setFont(new Font("Tahoma", 0, 13));

        equipoBJLabel.setBounds(new Rectangle(390, 25, 135, 25));
        equipoBJLabel.setFont(new Font("Tahoma", 0, 13));
        resultadoFinalJPanel.setBounds(new Rectangle(50, 140, 475, 90));
        resultadoFinalJPanel.setLayout(flowLayout2);
        resultadoFinalAsistenciaJPanel.setBounds(new Rectangle(50, 30, 475, 90));
        resultadoFinalAsistenciaJPanel.setLayout(flowLayout1);
        resultadoFinalAsistenciaJPanel.setBorder(BorderFactory.createTitledBorder("Asistencia De Participantes"));
        resultaoFinalAsistenciaAJRadioButton.setText("Presente: "+encuentroSeleccionado.getParticipanteA().getNombre());
        resultaoFinalAsistenciaAJRadioButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    resultaoFinalAsistenciaAJRadioButton_actionPerformed(e);
                }
            });
        resultaoFinalAsistenciaBJRadioButton.setText("Presente: "+encuentroSeleccionado.getParticipanteB().getNombre());
        resultaoFinalAsistenciaBJRadioButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    resultaoFinalAsistenciaBJRadioButton_actionPerformed(e);
                }
            });
        resultaoFinalAsistenciaAmbosJRadioButton.setText("Presente: Ambos");
        resultaoFinalAsistenciaAmbosJRadioButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    resultaoFinalAsistenciaAmbosJRadioButton_actionPerformed(e);
                }
            });
        resultadoFinalJPanel.setBorder(BorderFactory.createTitledBorder("Resultado Final"));
        resultadoFinalJPanel.setVisible(false);
        ganadorEquipoAJRadioButton.setText("Ganador "+encuentroSeleccionado.getParticipanteA().getNombre());
        ganadorEquipoAJRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ganadorEquipoAJRadioButton_actionPerformed(e);
            }
        });
        ganadorEquipoBJRadioButton.setText("Ganador "+encuentroSeleccionado.getParticipanteB().getNombre());
        ganadorEquipoBJRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ganadorEquipoBJRadioButton_actionPerformed(e);
            }
        });
        resultadoFinalJPanel.add(ganadorEquipoAJRadioButton, null);
        resultadoFinalJPanel.add(ganadorEquipoBJRadioButton, null);
        resultadoFinalAsistenciaJPanel.add(resultaoFinalAsistenciaAJRadioButton, null);
        resultadoFinalAsistenciaJPanel.add(resultaoFinalAsistenciaBJRadioButton, null);
        resultadoFinalAsistenciaJPanel.add(resultaoFinalAsistenciaAmbosJRadioButton, null);
        this.getContentPane().add(resultadoFinalAsistenciaJPanel, null);
        this.getContentPane().add(resultadoFinalJPanel, null);
        this.getContentPane().add(equipoBJLabel, null);
        this.getContentPane().add(equipoAJLabel, null);


        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(cancelarJButton, null);
        cargarDatos();


    }
 
    private void presenteEquipoAJRadioButton_actionPerformed(ActionEvent e) {
        presenteEquipoBJRadioButton.setSelected(false);
        presenteEquipoAmbosJRadioButton.setSelected(false);
        jLabelPuntosEquipoA.setVisible(false);
        jLabelPuntosEquipoB.setVisible(false);
        puntosEquipoAJTextArea.setVisible(false);
        puntosEquipoBJTextArea.setVisible(false);
    }

    private void presenteEquipoBJRadioButton_actionPerformed(ActionEvent e) {
        presenteEquipoAJRadioButton.setSelected(false);
        presenteEquipoAmbosJRadioButton.setSelected(false);
        jLabelPuntosEquipoA.setVisible(false);
        jLabelPuntosEquipoB.setVisible(false);
        puntosEquipoAJTextArea.setVisible(false);
        puntosEquipoBJTextArea.setVisible(false);
    }

    private void presenteEquipoAmbosJRadioButton_actionPerformed(ActionEvent e) {
        presenteEquipoAJRadioButton.setSelected(false);
        presenteEquipoBJRadioButton.setSelected(false);
        jLabelPuntosEquipoA.setVisible(true);
        jLabelPuntosEquipoB.setVisible(true);
        puntosEquipoAJTextArea.setVisible(true);
        puntosEquipoBJTextArea.setVisible(true);
    }

    private void ganadorEquipoAJRadioButton_actionPerformed(ActionEvent e) {
        ganadorEquipoBJRadioButton.setSelected(false);
        empateJRadioButton.setSelected(false);
    }

    private void empateJRadioButton_actionPerformed(ActionEvent e) {
        ganadorEquipoAJRadioButton.setSelected(false);
        ganadorEquipoBJRadioButton.setSelected(false);
       
    }

    private void ganadorEquipoBJRadioButton_actionPerformed(ActionEvent e) {
        ganadorEquipoAJRadioButton.setSelected(false);
        empateJRadioButton.setSelected(false);
    }

    private void modificarSetJButton_actionPerformed(ActionEvent e) {
        if(tablaDeSetsJTable.getSelectedRow()>-1){
            Vector <String> datos = new Vector <String>();
        ModificarSet ve = new ModificarSet(tablaDeSetsJTable.getSelectedRow()+1,encuentroSeleccionado.getParticipanteA().getNombre(),encuentroSeleccionado.getParticipanteB().getNombre() , datos, this,competenciaActual.getLiga().getEmpate());
        this.setVisible(false);
        ve.setVisible(true);
        }
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
       setVisible(false);
        dispose();
        new  ModificarFixture(competenciaActual, usuarioAcatual, nroRonda).setVisible(true);
        
       
    }
    private void cargarDatos(){
            equipoAJLabel.setText(encuentroSeleccionado.getParticipanteA().getNombre());
            equipoBJLabel.setText(encuentroSeleccionado.getParticipanteB().getNombre());
       
        }
    public void setDatos(int numeroSet,  Vector <String> datos){
            modeloDeTablaDeSets.setValueAt(datos.get(1), numeroSet-1, 1);
            modeloDeTablaDeSets.setValueAt(datos.get(2), numeroSet-1, 2);
       
        }
    private void cargarSets(){
            modeloDeTablaDeSets = new ModeloTabla(new String[] { "Nº", encuentroSeleccionado.getParticipanteA().getNombre(), encuentroSeleccionado.getParticipanteB().getNombre(), }, 0);
            for(int i=0;i<competenciaActual.getSet().getCantidadSet();i++)
            {
                    Vector <String> datos = new Vector <String>();
                int aux=i+1;
                datos.add(""+aux);
                    datos.add(" ");
                    datos.add(" ");
                System.out.println(datos);
                modeloDeTablaDeSets.addRow(datos);
                }
            tablaDeSetsJTable.setModel(modeloDeTablaDeSets);
        }
    private void aceptarJButton_actionPerformed(ActionEvent e) {
        //TODO VerificarDatos Resultado
        
        
        

        if(verificarDatos()){
                CompetenciaGestor.actualizarResultados(competenciaActual, encuentroSeleccionado);
                
                
                setVisible(false);
               
                competenciaActual.getFixture().getRondas()[nroRonda].getGanadores().setEstado(RondaGestor.actualizarRonda(nroRonda, competenciaActual));
                int rondaAux =nroRonda+1;
                if(rondaAux==competenciaActual.getFixture().getRondas().length)
                {
                    if(competenciaActual.getFixture().getRondas()[nroRonda].getGanadores().getEstado())
                    {
                        CompetenciaGestor.actualizarEstado(competenciaActual, "Finalizada");
                        }
                    else
                    {
                            CompetenciaGestor.actualizarEstado(competenciaActual, "En disputa");
                        }
                        
                }
                else
                {
                    CompetenciaGestor.actualizarEstado(competenciaActual, "En disputa");
                }
                    

                FixtureGestor.actualizarSubRonda(competenciaActual.getFixture().getRondas()[nroRonda].getGanadores().getIdSubronda(), competenciaActual.getFixture().getRondas()[nroRonda].getGanadores().getEstado());

                new  ModificarFixture(competenciaActual, usuarioAcatual, nroRonda).setVisible(true);
            dispose();
        }

        
        
        

 
       
    }
    private void CerrarVentana(){
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose();
       new  ModificarFixture(competenciaActual, usuarioAcatual, nroRonda);
        
       
    }
    });
    }

    private void equipoASetJRadioButton_actionPerformed(ActionEvent e) {
        equipoBSetJRadioButton.setSelected(false);
        equipoAmbosSetJRadioButton.setSelected(false);
        setsJPanel.setVisible(false);
    }

    private void equipoBSetJRadioButton_actionPerformed(ActionEvent e) {
        equipoASetJRadioButton.setSelected(false);
        equipoAmbosSetJRadioButton.setSelected(false);
        setsJPanel.setVisible(false);
    }

    private void equipoAmbosSetJRadioButton_actionPerformed(ActionEvent e) {
        equipoASetJRadioButton.setSelected(false);
        equipoBSetJRadioButton.setSelected(false);
        setsJPanel.setVisible(true);
        cargarSets();
    }

    private void resultaoFinalAsistenciaAJRadioButton_actionPerformed(ActionEvent e) {
        resultaoFinalAsistenciaBJRadioButton.setSelected(false);
        resultaoFinalAsistenciaAmbosJRadioButton.setSelected(false);
        resultadoFinalJPanel.setVisible(false);
    }

    private void resultaoFinalAsistenciaBJRadioButton_actionPerformed(ActionEvent e) {
        resultaoFinalAsistenciaAJRadioButton.setSelected(false);
        resultaoFinalAsistenciaAmbosJRadioButton.setSelected(false);
        resultadoFinalJPanel.setVisible(false);
    }

    private void resultaoFinalAsistenciaAmbosJRadioButton_actionPerformed(ActionEvent e) {
        resultaoFinalAsistenciaBJRadioButton.setSelected(false);
        resultaoFinalAsistenciaAJRadioButton.setSelected(false);
        resultadoFinalJPanel.setVisible(true);
    }
    private boolean verificarDatos(){
        
            if(competenciaActual.getFormaDePuntuacion().equals("Resultado Final"))
            {
                    if(resultaoFinalAsistenciaAmbosJRadioButton.isSelected())
                    {
                            if(empateJRadioButton.isSelected())
                            {
                                EncuentroGestor.ganadorEmpate(encuentroSeleccionado, "Resultado Final");
                                    return true;
                                }
                            else{
                                    if(ganadorEquipoAJRadioButton.isSelected())
                                    {
                                            EncuentroGestor.ganador(encuentroSeleccionado, encuentroSeleccionado.getParticipanteA(),encuentroSeleccionado.getParticipanteB(),"Resultado Final");
                                            return true;
                                        }
                                    else
                                    {
                                    if(ganadorEquipoBJRadioButton.isSelected())
                                    {
                                            EncuentroGestor.ganador(encuentroSeleccionado, encuentroSeleccionado.getParticipanteB(),encuentroSeleccionado.getParticipanteA(), "Resultado Final");
                                            return true;
                                        }
                                    else {
                                    return false;
                                        //TODO mesaje error no selelos datos
                                    }
                                    }
                                }
                        }
                    else{
                            if(resultaoFinalAsistenciaAJRadioButton.isSelected())
                            {
                                    EncuentroGestor.ganador(encuentroSeleccionado, encuentroSeleccionado.getParticipanteA(),encuentroSeleccionado.getParticipanteB(),"Resultado Final");
                                    return true;
                                }
                        else
                            {
                            if(resultaoFinalAsistenciaBJRadioButton.isSelected())
                            {
                                    EncuentroGestor.ganador(encuentroSeleccionado, encuentroSeleccionado.getParticipanteB(),encuentroSeleccionado.getParticipanteA(), "Resultado Final");
                                    return true;
                                }
                                else
                                {
                                        return false;
                                        //TODO mesaje error no selelos datos
                                }
                                }
                        }
                    
                   
                }
            if(competenciaActual.getFormaDePuntuacion().equals("Puntuación"))
            {
                    if(presenteEquipoAmbosJRadioButton.isSelected())
                    {
                        EncuentroGestor.ganador(encuentroSeleccionado, encuentroSeleccionado.getParticipanteA(), encuentroSeleccionado.getParticipanteB(), Integer.parseInt(puntosEquipoAJTextArea.getText()), Integer.parseInt(puntosEquipoBJTextArea.getText()), "Puntuación");
                            return true;
                        }
                    else{
                            if(presenteEquipoAJRadioButton.isSelected())
                            {
                                    EncuentroGestor.unGanador(encuentroSeleccionado, encuentroSeleccionado.getParticipanteA(),encuentroSeleccionado.getParticipanteB(), -1 ,"Puntuación");
                                    return true;
                                }
                            else{
                            if(presenteEquipoBJRadioButton.isSelected())
                            {
                                    EncuentroGestor.unGanador(encuentroSeleccionado, encuentroSeleccionado.getParticipanteB(), encuentroSeleccionado.getParticipanteA(), 1 ,"Puntuación");
                                    return true;
                                }
                                else
                                {
                                    return false;
                                    //TODO mesaje error no selelos datos
                                }
                        }
                    }
                }
            if(competenciaActual.getFormaDePuntuacion().equals("Sets"))
            {
                    if(equipoAmbosSetJRadioButton.isSelected())
                    {
                        EncuentroGestor.guardarResultado(encuentroSeleccionado, competenciaActual.getSet().getCantidadSet(), tablaDeSetsJTable, 0,"Sets" );
                            return true;
                        }
                    else{
                            if(equipoASetJRadioButton.isSelected())
                            {
                                    EncuentroGestor.presente(encuentroSeleccionado,encuentroSeleccionado.getParticipanteA(), encuentroSeleccionado.getParticipanteB(), -1, "Sets");
                                    return true;
            
                                }
                            else{
                            if(equipoBSetJRadioButton.isSelected())
                            {
                                    EncuentroGestor.presente(encuentroSeleccionado,encuentroSeleccionado.getParticipanteB(), encuentroSeleccionado.getParticipanteA(), 1, "Sets");
                                    return true;
                                }
                                else
                                {
                                    return false;
                                    //TODO mesaje error no selelos datos
                                }
                            }
                        }
                   
                }
        
        return false;
        }
}
