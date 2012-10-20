package ClasesInterfaz;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;


public class TablaDePosiciones extends JDialog {
    private JButton exportarJButton = new JButton();
    private JButton imprimirJButton = new JButton();
    private JScrollPane jScrollPaneTablaDePosiciones = new JScrollPane();
    private JTable tablaDePosicionesJTable = new JTable();
    private JButton cancelarJButton = new JButton();
    private ClasesLogicas.TablaDePosiciones tablaSeleccionada=null;


    /**
     * @param tabla
     */
    public TablaDePosiciones(ClasesLogicas.TablaDePosiciones tabla) {
        this(null, "", false,tabla);
    }
    public TablaDePosiciones() {
        this(null, "", false);
    }
    public TablaDePosiciones(Frame parent, String title, boolean modal,ClasesLogicas.TablaDePosiciones tabla) {
        super(parent, title, modal);
        try {
            tablaSeleccionada=tabla;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public TablaDePosiciones(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
         
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void jbInit() throws Exception {
        this.setSize(new Dimension(1002, 615));
        this.getContentPane().setLayout( null );
        this.setTitle("Tabla De Posiciones");
        exportarJButton.setText("Exportar");
        exportarJButton.setBounds(new Rectangle(245, 520, 110, 30));
        exportarJButton.setFont(new Font("Tahoma", 0, 13));
        imprimirJButton.setText("Imprimir");
        imprimirJButton.setBounds(new Rectangle(445, 520, 110, 30));
        imprimirJButton.setFont(new Font("Tahoma", 0, 13));
        jScrollPaneTablaDePosiciones.setBounds(new Rectangle(15, 40, 935, 445));
        tablaDePosicionesJTable.setAutoCreateRowSorter(true);
        tablaDePosicionesJTable.setColumnModel(new DefaultTableColumnModel());
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(635, 520, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        jScrollPaneTablaDePosiciones.getViewport().add(tablaDePosicionesJTable, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(jScrollPaneTablaDePosiciones, null);
        this.getContentPane().add(imprimirJButton, null);
        this.getContentPane().add(exportarJButton, null);
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
