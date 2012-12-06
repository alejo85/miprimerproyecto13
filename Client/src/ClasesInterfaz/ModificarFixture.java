package ClasesInterfaz;


import ClasesLogicas.Competencia;
import ClasesLogicas.Fixture;
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ModificarFixture extends JDialog {
    private JPanel fechaJPanel = new JPanel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JScrollPane fechasJScrollPane = new JScrollPane();
    private JScrollBar jScrollBar2 = new JScrollBar();
    private JScrollBar jScrollBar3 = new JScrollBar();
    private JButton cancelarJButton = new JButton();
    private JLabel jLabelFechas = new JLabel();
    private JButton gestionarResultadoJButton = new JButton();
    private JButton anterioprJButton = new JButton();
    private JButton siguienteJButton = new JButton();
    private JTable tablaDeFechaJTable = new JTable();
    private JList listaDeFechasJList = new JList();
    private Fixture fixtureSeleccionada=null;
    private Usuario usuarioActual=null;
    private Competencia competenciaSeleccionada=null;

    /**
     * @param fixture
     * @param usuario
     */

    public ModificarFixture(Competencia unaCompetencia,Usuario usuario) {
        this(null, "", false, unaCompetencia, usuario);

    }


    public ModificarFixture(Frame parent, String title, boolean modal, Competencia unaCompetencia,Usuario usuario ) {

        super(parent, title, modal);
        try {


            usuarioActual=usuario;
            competenciaSeleccionada=unaCompetencia;
           

           

            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ModificarFixture() {
        this(null, "", false );
    }

    public ModificarFixture(Frame parent, String title, boolean modal  ) {
        super(parent, title, modal);
        try {
       
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void jbInit() throws Exception {
        this.setSize(new Dimension(1108, 544));
        this.getContentPane().setLayout( null );
        this.setTitle("Mostrar Fixture");
        fechaJPanel.setBounds(new Rectangle(35, 30, 870, 365));
        fechaJPanel.setLayout(null);
        fechaJPanel.setBorder(BorderFactory.createTitledBorder("Fecha/Ronda Nº "));
        jScrollPane1.setBounds(new Rectangle(20, 25, 820, 270));
        fechasJScrollPane.setBounds(new Rectangle(930, 55, 140, 270));
        jScrollBar2.setBounds(new Rectangle(1070, 55, 15, 270));
        jScrollBar3.setBounds(new Rectangle(840, 25, 15, 270));
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(680, 440, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));

        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        jLabelFechas.setText("Fechas");
        jLabelFechas.setBounds(new Rectangle(930, 20, 175, 25));
        jLabelFechas.setFont(new Font("Tahoma", 0, 13));
        gestionarResultadoJButton.setText("Gestionar Resultados");
        gestionarResultadoJButton.setBounds(new Rectangle(50, 315, 170, 30));
        gestionarResultadoJButton.setFont(new Font("Tahoma", 0, 13));
        gestionarResultadoJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gestionarResultadoJButton_actionPerformed(e);
                }
            });
        anterioprJButton.setText("Anterior");
        anterioprJButton.setBounds(new Rectangle(480, 320, 110, 30));
        anterioprJButton.setFont(new Font("Tahoma", 0, 13));
        siguienteJButton.setText("Siguiente");
        siguienteJButton.setBounds(new Rectangle(665, 320, 110, 30));
        siguienteJButton.setFont(new Font("Tahoma", 0, 13));
        siguienteJButton.setSize(new Dimension(110, 30));

        jScrollPane1.getViewport().add(tablaDeFechaJTable, null);
        fechaJPanel.add(jScrollPane1, null);
        fechaJPanel.add(jScrollBar3, null);
        fechaJPanel.add(gestionarResultadoJButton, null);
        fechaJPanel.add(anterioprJButton, null);
        fechaJPanel.add(siguienteJButton, null);
        this.getContentPane().add(jLabelFechas, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(jScrollBar2, null);
        fechasJScrollPane.getViewport().add(listaDeFechasJList, null);
        this.getContentPane().add(fechasJScrollPane, null);
        this.getContentPane().add(fechaJPanel, null);
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    private void gestionarResultadoJButton_actionPerformed(ActionEvent e) {
        GestionarResultados ven = new GestionarResultados();
        ven.setVisible(true);
    }
}
