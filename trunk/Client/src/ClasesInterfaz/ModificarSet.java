package ClasesInterfaz;


import InterfazGrafica.CampoTexto.AreaTextoNumerico;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;


public class ModificarSet extends JDialog {


    private AreaTextoNumerico puntosEquipoAJTextArea = new AreaTextoNumerico(2);
    private JLabel jLabelPuntosEquipoA = new JLabel();
    private AreaTextoNumerico puntosEquiposBJTextArea = new AreaTextoNumerico(2);
    private JLabel jLabelPuntosEquipoB = new JLabel();
    private JButton cancelarJButton = new JButton();
    private JButton aceptarJButton = new JButton();

   
    private int numeroSet;
    private String equipoA;
    private String equipoB;
    private Vector <String> datos;

    public ModificarSet(int numeroSet, String equipoA, String equipoB, Vector <String> datos ) {
        this(null, "", false, numeroSet,  equipoA,  equipoB,  datos);

    }


    public ModificarSet(Frame parent, String title, boolean modal,int numeroSet, String equipoA, String equipoB, Vector <String> datos) {

    

        super(parent, title, modal);

        this.numeroSet=numeroSet;
 
        this.equipoA=equipoA;
        this.equipoB=equipoB;
        this.datos=datos;

        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(448, 202));
        this.getContentPane().setLayout( null );
        this.setTitle("Puntuación del Set Nº: XX");
        puntosEquipoAJTextArea.setBounds(new Rectangle(35, 55, 130, 30));
        puntosEquipoAJTextArea.setFont(new Font("Tahoma", 0, 13));
        puntosEquipoAJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelPuntosEquipoA.setText("Puntos Equipo A");
        jLabelPuntosEquipoA.setBounds(new Rectangle(40, 25, 135, 25));
        jLabelPuntosEquipoA.setFont(new Font("Tahoma", 0, 13));
        puntosEquiposBJTextArea.setBounds(new Rectangle(200, 55, 130, 30));
        puntosEquiposBJTextArea.setFont(new Font("Tahoma", 0, 13));
        puntosEquiposBJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelPuntosEquipoB.setText("Puntos Equipo B");
        jLabelPuntosEquipoB.setBounds(new Rectangle(205, 25, 135, 25));
        jLabelPuntosEquipoB.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(310, 125, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(120, 125, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(jLabelPuntosEquipoB, null);
        this.getContentPane().add(puntosEquiposBJTextArea, null);
        this.getContentPane().add(jLabelPuntosEquipoA, null);
        this.getContentPane().add(puntosEquipoAJTextArea, null);
    }

 
    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }


    private void aceptarJButton_actionPerformed(ActionEvent e) {
        if(puntosEquipoAJTextArea.esCorrecto()&&puntosEquiposBJTextArea.esCorrecto())
        {
            datos.add(""+numeroSet);
                datos.add(puntosEquipoAJTextArea.getText());
                datos.add(puntosEquiposBJTextArea.getText());
                
                this.setVisible(false);
                
            }
    }

}
