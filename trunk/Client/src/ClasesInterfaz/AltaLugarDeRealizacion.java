package ClasesInterfaz;

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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class AltaLugarDeRealizacion extends JDialog {
    private JTextArea codigoJTextArea = new JTextArea();
    private JLabel jLabelCodigo = new JLabel();
    private JTextArea nombreLugarDeRealizaciónJTextArea = new JTextArea();
    private JLabel jLabelNombreLugarDeRealización = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea descripciónJTextArea = new JTextArea();
    private JScrollBar jScrollBar1 = new JScrollBar();
    private JLabel jLabelDescripción = new JLabel();
    private JList listaDeportesJList = new JList();
    private JList listaDeportesSeleccionadosJList = new JList();
    private JButton cancelarJButton = new JButton();
    private JButton aceptarJButton = new JButton();
    private JButton quitarJButton = new JButton();
    private JButton agregarJButton = new JButton();
    private JScrollBar jScrollBar2 = new JScrollBar();
    private JScrollBar jScrollBar3 = new JScrollBar();
    private JLabel jLabelDeportesSeleccionados = new JLabel();
    private JLabel jLabelDeportes = new JLabel();

    public AltaLugarDeRealizacion() {
        this(null, "", false);
    }

    public AltaLugarDeRealizacion(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(1243, 471));
        this.getContentPane().setLayout( null );
        this.setTitle("Alta Lugar De Realización");
        codigoJTextArea.setBounds(new Rectangle(235, 30, 375, 30));
        codigoJTextArea.setFont(new Font("Tahoma", 0, 13));
        codigoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelCodigo.setText("Codigo");
        jLabelCodigo.setBounds(new Rectangle(50, 25, 175, 25));
        jLabelCodigo.setFont(new Font("Tahoma", 0, 13));
        nombreLugarDeRealizaciónJTextArea.setBounds(new Rectangle(235, 75, 375, 30));
        nombreLugarDeRealizaciónJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreLugarDeRealizaciónJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelNombreLugarDeRealización.setText("Nombre");
        jLabelNombreLugarDeRealización.setBounds(new Rectangle(45, 70, 175, 25));
        jLabelNombreLugarDeRealización.setFont(new Font("Tahoma", 0, 13));
        jScrollPane1.setBounds(new Rectangle(250, 145, 350, 150));
        jScrollBar1.setBounds(new Rectangle(600, 145, 15, 150));
        jLabelDescripción.setText("Descripción");
        jLabelDescripción.setBounds(new Rectangle(50, 140, 175, 25));
        jLabelDescripción.setFont(new Font("Tahoma", 0, 13));
        listaDeportesJList.setBounds(new Rectangle(705, 50, 150, 265));
        listaDeportesSeleccionadosJList.setBounds(new Rectangle(1035, 50, 150, 265));
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(685, 365, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(495, 365, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        quitarJButton.setText("Quitar");
        quitarJButton.setBounds(new Rectangle(895, 190, 110, 30));
        quitarJButton.setFont(new Font("Tahoma", 0, 13));
        quitarJButton.setSize(new Dimension(110, 30));
        agregarJButton.setText("Agregar");
        agregarJButton.setBounds(new Rectangle(895, 120, 110, 30));
        agregarJButton.setFont(new Font("Tahoma", 0, 13));
        jScrollBar2.setBounds(new Rectangle(840, 50, 15, 265));
        jScrollBar3.setBounds(new Rectangle(1170, 50, 15, 265));
        jLabelDeportesSeleccionados.setText("Deportes Seleccionados");
        jLabelDeportesSeleccionados.setBounds(new Rectangle(1035, 10, 175, 25));
        jLabelDeportesSeleccionados.setFont(new Font("Tahoma", 0, 13));
        jLabelDeportes.setText("Deportes");
        jLabelDeportes.setBounds(new Rectangle(700, 10, 175, 25));
        jLabelDeportes.setFont(new Font("Tahoma", 0, 13));
        jScrollPane1.getViewport().add(descripciónJTextArea, null);
        this.getContentPane().add(jLabelDeportes, null);
        this.getContentPane().add(jLabelDeportesSeleccionados, null);
        this.getContentPane().add(jScrollBar3, null);
        this.getContentPane().add(jScrollBar2, null);
        this.getContentPane().add(agregarJButton, null);
        this.getContentPane().add(quitarJButton, null);
        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(listaDeportesSeleccionadosJList, null);
        this.getContentPane().add(listaDeportesJList, null);
        this.getContentPane().add(jLabelDescripción, null);
        this.getContentPane().add(jScrollBar1, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jLabelNombreLugarDeRealización, null);
        this.getContentPane().add(nombreLugarDeRealizaciónJTextArea, null);
        this.getContentPane().add(jLabelCodigo, null);
        this.getContentPane().add(codigoJTextArea, null);
    }

  

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
