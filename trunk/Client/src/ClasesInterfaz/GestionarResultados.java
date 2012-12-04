package ClasesInterfaz;


import ClasesGestores.EncuentroGestor;

import ClasesLogicas.Competencia;
import ClasesLogicas.Encuentro;
import ClasesLogicas.ModeloTabla;
import ClasesLogicas.Usuario;

import java.awt.Dimension;
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
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTable tablaDeSetsJTable = new JTable();
    private JButton modificarSetJButton = new JButton();
    private JPanel puntuacionJPanel = new JPanel();
    private JLabel equipoAJLabel = new JLabel();
    private JLabel equipoBJLabel = new JLabel();
    private JLabel jLabelPuntosEquipoB = new JLabel();
    private JLabel jLabelPuntosEquipoA = new JLabel();
    private JTextArea puntosEquipoAJTextArea = new JTextArea();
    private JTextArea puntosEquipoBJTextArea = new JTextArea();
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
    private ModificarFixture ventanaAnterior=null;
    private Usuario usuarioAcatual = null;
    private Vector <String> sets=null;
    
    

    public GestionarResultados(Competencia competenciaSeleccionada, Usuario usuario,  ModificarFixture ventana, Encuentro encuentro) {
  
            this(null, "", false,  competenciaSeleccionada,  usuario,   ventana,  encuentro);
       
    }

    public GestionarResultados(Frame parent, String title, boolean modal,Competencia competenciaSeleccionada, Usuario usuario,  ModificarFixture ventana, Encuentro encuentro) {
        super(parent, title, modal);
    
            competenciaActual=competenciaSeleccionada;
            encuentroSeleccionado=encuentro;
            usuarioAcatual=usuario;
            ventanaAnterior=ventana;

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
                for(int i=0;i<competenciaActual.getCantidadDeSets();i++)
                {
                        Vector <String> datos = new Vector <String>();
                    int aux=i+1;
                    datos.add(""+aux);
                        datos.add("");
                        datos.add("");
                    }
            } catch (Exception e) {
            }


    }
    private void jbInit() throws Exception {
           CerrarVentana();
           this.setSize(new Dimension(543, 486));
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
               jLabelPuntosEquipoB.setText("Puntos Equipo B");
               jLabelPuntosEquipoB.setBounds(new Rectangle(210, 170, 135, 25));
               jLabelPuntosEquipoB.setFont(new Font("Tahoma", 0, 13));
               jLabelPuntosEquipoA.setText("Puntos Equipo A");
               jLabelPuntosEquipoA.setBounds(new Rectangle(15, 170, 135, 25));
               jLabelPuntosEquipoA.setFont(new Font("Tahoma", 0, 13));
               puntosEquipoAJTextArea.setBounds(new Rectangle(10, 200, 130, 30));
               puntosEquipoAJTextArea.setFont(new Font("Tahoma", 0, 13));
               puntosEquipoAJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
               puntosEquipoBJTextArea.setBounds(new Rectangle(190, 200, 130, 30));
               puntosEquipoBJTextArea.setFont(new Font("Tahoma", 0, 13));
               puntosEquipoBJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
           equipoPresenteJPanel.setBounds(new Rectangle(20, 45, 330, 90));
               equipoPresenteJPanel.setLayout(null);
               equipoPresenteJPanel.setBorder(BorderFactory.createTitledBorder("Equipo Presente"));
               presenteEquipoBJRadioButton.setText("Equipo B");
               presenteEquipoBJRadioButton.setBounds(new Rectangle(115, 35, 80, 20));
               presenteEquipoBJRadioButton.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                           presenteEquipoBJRadioButton_actionPerformed(e);
                       }
                   });
               presenteEquipoAmbosJRadioButton.setText("Ambos");
               presenteEquipoAmbosJRadioButton.setBounds(new Rectangle(220, 35, 90, 20));
               presenteEquipoAmbosJRadioButton.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                           presenteEquipoAmbosJRadioButton_actionPerformed(e);
                       }
                   });
               presenteEquipoAJRadioButton.setText("Equipo A");
               presenteEquipoAJRadioButton.setBounds(new Rectangle(5, 35, 95, 20));
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



   
    private void jbInitSet() throws Exception {
        CerrarVentana();
    this.setSize(new Dimension(578, 578));
    this.getContentPane().setLayout( null );
    this.setTitle("Gestionar Resultados");
    cancelarJButton.setText("Cancelar");
    cancelarJButton.setBounds(new Rectangle(310, 390, 110, 30));
    cancelarJButton.setFont(new Font("Tahoma", 0, 13));
    cancelarJButton.setSize(new Dimension(110, 30));
    cancelarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarJButton_actionPerformed(e);
            }
        });
    aceptarJButton.setText("Aceptar");
    aceptarJButton.setBounds(new Rectangle(120, 390, 110, 30));
    aceptarJButton.setFont(new Font("Tahoma", 0, 13));
    setsJPanel.setBounds(new Rectangle(118, 85, 340, 265));
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

    equipoAJLabel.setBounds(new Rectangle(120, 30, 135, 25));
    equipoAJLabel.setFont(new Font("Tahoma", 0, 13));
    tablaDeSetsJTable.setModel(modeloDeTablaDeSets);
    equipoBJLabel.setBounds(new Rectangle(285, 30, 135, 25));
    equipoBJLabel.setFont(new Font("Tahoma", 0, 13));
    jScrollPane1.getViewport().add(tablaDeSetsJTable, null);
    setsJPanel.add(jScrollPane1, null);
    setsJPanel.add(modificarSetJButton, null);
    this.getContentPane().add(equipoBJLabel, null);
    this.getContentPane().add(equipoAJLabel, null);
    this.getContentPane().add(setsJPanel, null);
    this.getContentPane().add(aceptarJButton, null);
    this.getContentPane().add(cancelarJButton, null);
        cargarDatos();
    }
    private void jbInitPuntuacion() throws Exception {
        CerrarVentana();
    this.setSize(new Dimension(543, 486));
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
    puntuacionJPanel.setBounds(new Rectangle(80, 95, 370, 260));
            puntuacionJPanel.setLayout(null);
            puntuacionJPanel.setBorder(BorderFactory.createTitledBorder("Puntuación"));

            equipoAJLabel.setBounds(new Rectangle(85, 50, 135, 25));
            equipoAJLabel.setFont(new Font("Tahoma", 0, 13));
 
            equipoBJLabel.setBounds(new Rectangle(310, 50, 135, 25));
            equipoBJLabel.setFont(new Font("Tahoma", 0, 13));
            jLabelPuntosEquipoB.setText("Puntos Equipo B");
            jLabelPuntosEquipoB.setBounds(new Rectangle(210, 170, 135, 25));
            jLabelPuntosEquipoB.setFont(new Font("Tahoma", 0, 13));
            jLabelPuntosEquipoA.setText("Puntos Equipo A");
            jLabelPuntosEquipoA.setBounds(new Rectangle(15, 170, 135, 25));
            jLabelPuntosEquipoA.setFont(new Font("Tahoma", 0, 13));
            puntosEquipoAJTextArea.setBounds(new Rectangle(10, 200, 130, 30));
            puntosEquipoAJTextArea.setFont(new Font("Tahoma", 0, 13));
            puntosEquipoAJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
            puntosEquipoBJTextArea.setBounds(new Rectangle(190, 200, 130, 30));
            puntosEquipoBJTextArea.setFont(new Font("Tahoma", 0, 13));
            puntosEquipoBJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    equipoPresenteJPanel.setBounds(new Rectangle(20, 45, 330, 90));
            equipoPresenteJPanel.setLayout(null);
            equipoPresenteJPanel.setBorder(BorderFactory.createTitledBorder("Equipo Presente"));
            presenteEquipoBJRadioButton.setText("Equipo B");
            presenteEquipoBJRadioButton.setBounds(new Rectangle(115, 35, 80, 20));
            presenteEquipoBJRadioButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        presenteEquipoBJRadioButton_actionPerformed(e);
                    }
                });
            presenteEquipoAmbosJRadioButton.setText("Ambos");
            presenteEquipoAmbosJRadioButton.setBounds(new Rectangle(220, 35, 90, 20));
            presenteEquipoAmbosJRadioButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        presenteEquipoAmbosJRadioButton_actionPerformed(e);
                    }
                });
            presenteEquipoAJRadioButton.setText("Equipo A");
            presenteEquipoAJRadioButton.setBounds(new Rectangle(5, 35, 95, 20));
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
    this.setSize(new Dimension(596, 280));
            this.getContentPane().setLayout( null );
            this.setTitle("Gestionar Resultados");
            cancelarJButton.setText("Cancelar");
            cancelarJButton.setBounds(new Rectangle(320, 185, 110, 30));
            cancelarJButton.setFont(new Font("Tahoma", 0, 13));
            cancelarJButton.setSize(new Dimension(110, 30));
            cancelarJButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cancelarJButton_actionPerformed(e);
                    }
                });
            aceptarJButton.setText("Aceptar");
            aceptarJButton.setBounds(new Rectangle(130, 185, 110, 30));
            aceptarJButton.setFont(new Font("Tahoma", 0, 13));
    

            equipoAJLabel.setBounds(new Rectangle(50, 25, 135, 25));
            equipoAJLabel.setFont(new Font("Tahoma", 0, 13));

            equipoBJLabel.setBounds(new Rectangle(390, 25, 135, 25));
            equipoBJLabel.setFont(new Font("Tahoma", 0, 13));
    resultadoFinalJPanel.setBounds(new Rectangle(50, 70, 475, 90));
            resultadoFinalJPanel.setLayout(null);
            resultadoFinalJPanel.setBorder(BorderFactory.createTitledBorder("Resultado Final"));
            empateJRadioButton.setText("Empate");
            empateJRadioButton.setBounds(new Rectangle(175, 30, 90, 20));
        
            empateJRadioButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        empateJRadioButton_actionPerformed(e);
                    }
                });
            ganadorEquipoAJRadioButton.setText("Ganador Equipo A");
            ganadorEquipoAJRadioButton.setBounds(new Rectangle(30, 30, 130, 20));
            ganadorEquipoAJRadioButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ganadorEquipoAJRadioButton_actionPerformed(e);
                    }
                });
            ganadorEquipoBJRadioButton.setText("Ganador Equipo B");
            ganadorEquipoBJRadioButton.setBounds(new Rectangle(290, 30, 135, 20));
            ganadorEquipoBJRadioButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ganadorEquipoBJRadioButton_actionPerformed(e);
                    }
                });
    resultadoFinalJPanel.add(ganadorEquipoAJRadioButton, null);
    resultadoFinalJPanel.add(empateJRadioButton, null);
    resultadoFinalJPanel.add(ganadorEquipoBJRadioButton, null);
    this.getContentPane().add(resultadoFinalJPanel, null);
    this.getContentPane().add(equipoBJLabel, null);
    this.getContentPane().add(equipoAJLabel, null);
    this.getContentPane().add(aceptarJButton, null);
    this.getContentPane().add(cancelarJButton, null);

        
       
        cargarDatos();

    }
    private void jbInitResultadoFinalEmpateNo() throws Exception {
                   CerrarVentana();
           this.setSize(new Dimension(596, 280));
               this.getContentPane().setLayout( null );
               this.setTitle("Gestionar Resultados");
               cancelarJButton.setText("Cancelar");
               cancelarJButton.setBounds(new Rectangle(320, 185, 110, 30));
               cancelarJButton.setFont(new Font("Tahoma", 0, 13));
               cancelarJButton.setSize(new Dimension(110, 30));
               cancelarJButton.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                           cancelarJButton_actionPerformed(e);
                       }
                   });
               aceptarJButton.setText("Aceptar");
               aceptarJButton.setBounds(new Rectangle(130, 185, 110, 30));
               aceptarJButton.setFont(new Font("Tahoma", 0, 13));
           

               equipoAJLabel.setBounds(new Rectangle(50, 25, 135, 25));
               equipoAJLabel.setFont(new Font("Tahoma", 0, 13));

               equipoBJLabel.setBounds(new Rectangle(390, 25, 135, 25));
               equipoBJLabel.setFont(new Font("Tahoma", 0, 13));
           resultadoFinalJPanel.setBounds(new Rectangle(50, 70, 475, 90));
               resultadoFinalJPanel.setLayout(null);
               resultadoFinalJPanel.setBorder(BorderFactory.createTitledBorder("Resultado Final"));

        ganadorEquipoAJRadioButton.setText("Ganador Equipo A");
               ganadorEquipoAJRadioButton.setBounds(new Rectangle(30, 30, 130, 20));
               ganadorEquipoAJRadioButton.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                           ganadorEquipoAJRadioButton_actionPerformed(e);
                       }
                   });
               ganadorEquipoBJRadioButton.setText("Ganador Equipo B");
               ganadorEquipoBJRadioButton.setBounds(new Rectangle(290, 30, 135, 20));
               ganadorEquipoBJRadioButton.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                           ganadorEquipoBJRadioButton_actionPerformed(e);
                       }
                   });
           resultadoFinalJPanel.add(ganadorEquipoAJRadioButton, null);
        resultadoFinalJPanel.add(ganadorEquipoBJRadioButton, null);
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
        ModificarSet ve = new ModificarSet();
        ve.setVisible(true);
        }
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
       setVisible(false);
       ventanaAnterior.setCompetencia(competenciaActual);
       ventanaAnterior.setVisible(true);
        
    }
    private void cargarDatos(){
            equipoAJLabel.setText(encuentroSeleccionado.getParticipanteA().getNombre());
            equipoBJLabel.setText(encuentroSeleccionado.getParticipanteB().getNombre());
        
        }
    private void cargarSets(){
            equipoAJLabel.setText(encuentroSeleccionado.getParticipanteA().getNombre());
            equipoBJLabel.setText(encuentroSeleccionado.getParticipanteB().getNombre());
        
        }
    private void aceptarJButton_actionPerformed(ActionEvent e) {
        //TODO VerificarDatos Resultado
        if(competenciaActual.getFormaDePuntuacion().equals("Resultado Final"))
        {
                if(empateJRadioButton.isSelected())
                {
                    EncuentroGestor.ganadorEmpate(encuentroSeleccionado);
                    }
                else{
                        if(ganadorEquipoAJRadioButton.isSelected())
                        {
                                EncuentroGestor.ganador(encuentroSeleccionado, encuentroSeleccionado.getParticipanteA());
                            }
                        if(ganadorEquipoBJRadioButton.isSelected())
                        {
                                EncuentroGestor.ganador(encuentroSeleccionado, encuentroSeleccionado.getParticipanteB());
                            }
                    }
                
            }
        if(competenciaActual.getFormaDePuntuacion().equals("Puntuación"))
        {
                if(presenteEquipoAmbosJRadioButton.isSelected())
                {
                    EncuentroGestor.ganador(encuentroSeleccionado, encuentroSeleccionado.getParticipanteA(), encuentroSeleccionado.getParticipanteB(), Integer.parseInt(puntosEquipoAJTextArea.getText()), Integer.parseInt(puntosEquipoBJTextArea.getText()));
                    }
                else{
                        if(presenteEquipoAJRadioButton.isSelected())
                        {
                                EncuentroGestor.ganador(encuentroSeleccionado, encuentroSeleccionado.getParticipanteA());
                            }
                        if(presenteEquipoBJRadioButton.isSelected())
                        {
                                EncuentroGestor.ganador(encuentroSeleccionado, encuentroSeleccionado.getParticipanteB());
                            }
                    }
                
            }
       //TODO SETEAR LA COMPETENCIA CON EL RESULTADO
       setVisible(false);
       ventanaAnterior.setCompetencia(competenciaActual);
       ventanaAnterior.setVisible(true);
    }
    private void CerrarVentana(){
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        setVisible(false);
        ventanaAnterior.setCompetencia(competenciaActual);
        ventanaAnterior.setVisible(true);
        
    }
    });
    }
}
