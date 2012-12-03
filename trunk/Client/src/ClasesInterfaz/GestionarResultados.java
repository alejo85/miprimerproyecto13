package ClasesInterfaz;

import ClasesLogicas.Competencia;

import ClasesLogicas.Encuentro;

import ClasesLogicas.Usuario;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class GestionarResultados extends JDialog {
    private JButton cancelarJButton = new JButton();
    private JButton aceptarJButton = new JButton();
    private JPanel setsJPanel = new JPanel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTable tablaDeSetsJTable = new JTable();
    private JScrollBar jScrollBar1 = new JScrollBar();
    private JButton modificarSetJButton = new JButton();
    private JPanel jPanel3 = new JPanel();
    private JLabel equipoAJLabel = new JLabel();
    private JLabel equipoBJLabel = new JLabel();
    private JLabel jLabelPuntosEquipoB = new JLabel();
    private JLabel jLabelPuntosEquipoA = new JLabel();
    private JTextArea puntosEquipoAJTextArea = new JTextArea();
    private JTextArea puntosEquipoBJTextArea = new JTextArea();
    private JPanel resultadoFinalJPanel = new JPanel();
    private JRadioButton empateJRadioButton = new JRadioButton();
    private JRadioButton ganadorEquipoAJRadioButton = new JRadioButton();
    private JRadioButton ganadorEquipoBJRadioButton = new JRadioButton();
    private JPanel jPanel5 = new JPanel();
    private JRadioButton presenteEquipoBJRadioButton = new JRadioButton();
    private JRadioButton presenteEquipoAmbosJRadioButton = new JRadioButton();
    private JRadioButton presenteEquipoAJRadioButton = new JRadioButton();
    private Competencia competenciaActual=null;
    private Usuario usuarioActual=null;
    private Encuentro encuentroSeleccionado=null;
    private ModificarFixture ventanaAnterior=null;
    
    

    public GestionarResultados(Competencia competencia, Usuario usuario, ModificarFixture ventana) {
        this(null, "", false, competencia, usuario,ventana);
    }

    public GestionarResultados(Frame parent, String title, boolean modal,Competencia competencia,Usuario usuario,ModificarFixture ventana) {
        super(parent, title, modal);
        try {
            competenciaActual=competencia;
            usuarioActual=usuario;
            ventanaAnterior=ventana;
            if(competenciaActual.getModalidad().equals("Resultado Final"))
            {
                    jbInitFinal();
                }
            if(competenciaActual.getModalidad().equals("Puntuación"))
            {
                    jbInitPuntuacion();
                }
            if(competenciaActual.getModalidad().equals("Sets"))
            {
                    jbInitset();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  


    private void jbInitFinal() throws Exception {
        this.setSize(new Dimension(546, 294));
        this.getContentPane().setLayout( null );
        this.setTitle("Gestionar Resultados");
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(310, 195, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(120, 195, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        equipoAJLabel.setText("Equipo A");
        equipoAJLabel.setBounds(new Rectangle(100, 25, 135, 25));
        equipoAJLabel.setFont(new Font("Tahoma", 0, 13));
        equipoBJLabel.setText("Equipo B");
        equipoBJLabel.setBounds(new Rectangle(295, 25, 135, 25));
        equipoBJLabel.setFont(new Font("Tahoma", 0, 13));
        resultadoFinalJPanel.setBounds(new Rectangle(40, 75, 475, 90));
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


    }
    private void jbInitPuntuacion() throws Exception {
        this.setSize(new Dimension(463, 436));
        this.getContentPane().setLayout( null );
        this.setTitle("Gestionar Resultados");
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(270, 350, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(80, 350, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        jPanel3.setBounds(new Rectangle(50, 65, 370, 260));
        jPanel3.setLayout(null);
        jPanel3.setBorder(BorderFactory.createTitledBorder("Puntuación"));
        equipoAJLabel.setText("Equipo A");
        equipoAJLabel.setBounds(new Rectangle(70, 25, 135, 25));
        equipoAJLabel.setFont(new Font("Tahoma", 0, 13));
        equipoBJLabel.setText("Equipo B");
        equipoBJLabel.setBounds(new Rectangle(265, 25, 135, 25));
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
        jPanel5.setBounds(new Rectangle(20, 45, 330, 90));
        jPanel5.setLayout(null);
        jPanel5.setBorder(BorderFactory.createTitledBorder("Equipo Presente"));
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
        this.getContentPane().add(jPanel3, null);
        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(cancelarJButton, null);
        jPanel5.add(presenteEquipoAJRadioButton, null);
        jPanel5.add(presenteEquipoBJRadioButton, null);
        jPanel5.add(presenteEquipoAmbosJRadioButton, null);
        jPanel3.add(jPanel5, null);
        jPanel3.add(jLabelPuntosEquipoA, null);
        jPanel3.add(jLabelPuntosEquipoB, null);
        jPanel3.add(puntosEquipoAJTextArea, null);
        jPanel3.add(puntosEquipoBJTextArea, null);


    }
    private void jbInitset() throws Exception {
        this.setSize(new Dimension(473, 472));
        this.getContentPane().setLayout( null );
        this.setTitle("Gestionar Resultados");
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(275, 360, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(85, 360, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        setsJPanel.setBounds(new Rectangle(75, 70, 340, 265));
        setsJPanel.setLayout(null);
        setsJPanel.setBorder(BorderFactory.createTitledBorder("Sets"));
        jScrollPane1.setBounds(new Rectangle(15, 25, 170, 220));
        jScrollBar1.setBounds(new Rectangle(180, 25, 15, 220));
        modificarSetJButton.setText("Modificar");
        modificarSetJButton.setBounds(new Rectangle(215, 80, 110, 30));
        modificarSetJButton.setFont(new Font("Tahoma", 0, 13));
        modificarSetJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    modificarSetJButton_actionPerformed(e);
                }
            });
        equipoAJLabel.setText("Equipo A");
        equipoAJLabel.setBounds(new Rectangle(75, 20, 135, 25));
        equipoAJLabel.setFont(new Font("Tahoma", 0, 13));
        equipoBJLabel.setText("Equipo B");
        equipoBJLabel.setBounds(new Rectangle(270, 20, 135, 25));
        equipoBJLabel.setFont(new Font("Tahoma", 0, 13));
        jScrollPane1.getViewport().add(tablaDeSetsJTable, null);
        setsJPanel.add(jScrollBar1, null);
        setsJPanel.add(jScrollPane1, null);
        setsJPanel.add(modificarSetJButton, null);
        this.getContentPane().add(equipoBJLabel, null);
        this.getContentPane().add(equipoAJLabel, null);
        this.getContentPane().add(setsJPanel, null);
        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(cancelarJButton, null);


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
        ModificarSet ve = new ModificarSet();
        ve.setVisible(true);
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
