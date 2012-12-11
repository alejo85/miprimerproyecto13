/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TableFrame.java
 *
 * Created on Jun 27, 2009, 4:04:27 PM
 */
package excelexporter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author necronet
 */
public class TableFrame extends javax.swing.JFrame {

    /** Creates new form TableFrame */
    public TableFrame() {
        initComponents();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGeneral = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInfo = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Java", "5", "8", "9"},
                {"Java", "2", "8", "6"},
                {"Swign", "2", "4", "11"},
                {"Microsystem", "2", "3", null}
            },
            new String [] {
                "Titulo", "Otro Titulo", "Mas Titulos", "Ultimo Titulo"
            }
        ));
        jScrollPane1.setViewportView(tablaGeneral);

        jTabbedPane1.addTab("Hoja1", jScrollPane1);

        tablaInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"John Doe", "40"},
                {"Jose Mendoza", "11"},
                {"Jimmy Wale", "45"},
                {"Juan Perez", "25"}
            },
            new String [] {
                "Nombre", "Edad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaInfo);

        jTabbedPane1.addTab("Hoja2", jScrollPane2);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excelexporter/icon/export.png"))); // NOI18N
        jButton1.setText("Exportar");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            List<JTable> tables = new ArrayList<JTable>();
            List<String> sheetsName = new ArrayList<String>();
            tables.add(tablaGeneral);
            tables.add(tablaInfo);
            sheetsName.add("General");
            sheetsName.add("Info");
            ExcelTableExporter excelExporter = new ExcelTableExporter(tables, new File("exportar.xls"), sheetsName);
            if (excelExporter.export()) {
                JOptionPane.showMessageDialog(null, "Exportado con exito!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TableFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tablaGeneral;
    private javax.swing.JTable tablaInfo;
    // End of variables declaration//GEN-END:variables
}