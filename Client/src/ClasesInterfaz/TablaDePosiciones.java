package ClasesInterfaz;



import ClasesLogicas.Competencia;
import ClasesLogicas.Encuentro;
import ClasesLogicas.ModeloTabla;
import excelexporter.ExcelTableExporter;
import ClasesLogicas.Posicion;


import ClasesLogicas.Ronda;
import ClasesLogicas.Subronda;
import ClasesLogicas.Usuario;

import excelexporter.ExcelTableExporter;

import java.awt.Component;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import java.awt.print.PrinterException;

import java.io.File;

import java.text.MessageFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import javax.print.attribute.standard.OrientationRequested;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


public class TablaDePosiciones extends JDialog {
    private JButton exportarJButton = new JButton();
    private JButton imprimirJButton = new JButton();
    private JScrollPane jScrollPaneTablaDePosiciones = new JScrollPane();
    private JTable tablaDePosicionesJTable = new JTable();
    private JButton cancelarJButton = new JButton();
    private Vector<Posicion> tablaSeleccionada=null;
    private Usuario usuarioActual=null;
    private Competencia competenciaSeleccionada=null;
    private ModeloTabla tablaDePosicionesModeloTabla = null;
    private Competencia competenciaActual;



  

    public TablaDePosiciones(Usuario usuario, Competencia competencia,Vector<Posicion>tabla) {
        this(null, "", false,  usuario,  competencia, tabla);
    }

    public TablaDePosiciones(Frame parent, String title, boolean modal,Usuario usuario, Competencia competencia,Vector<Posicion> tabla) {

        super(parent, title, modal);
        try {
            usuarioActual=usuario;
            competenciaActual=competencia;
            tablaSeleccionada=tabla;
            competenciaSeleccionada=competencia;
            usuarioActual=usuario;
            
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
          }
    }
  
    private void jbInit() throws Exception {
        CerrarVentana();
        setResizable(false);
        this.setSize(new Dimension(1002, 615));
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout( null );
        this.setTitle("Tabla De Posiciones");
        exportarJButton.setText("Exportar");
        exportarJButton.setBounds(new Rectangle(245, 520, 110, 30));
        exportarJButton.setFont(new Font("Tahoma", 0, 13));
        exportarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    exportarJButton_actionPerformed(e);
                }
            });
        imprimirJButton.setText("Imprimir");
        imprimirJButton.setBounds(new Rectangle(445, 520, 110, 30));
        imprimirJButton.setFont(new Font("Tahoma", 0, 13));
        imprimirJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    imprimirJButton_actionPerformed(e);
                }
            });
        jScrollPaneTablaDePosiciones.setBounds(new Rectangle(15, 40, 935, 445));
        tablaDePosicionesJTable.setAutoCreateRowSorter(true);
        tablaDePosicionesJTable.setColumnModel(new DefaultTableColumnModel());
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(635, 520, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cargarFixture();
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
        VerCompetencia ven =new VerCompetencia(usuarioActual, competenciaActual);
        dispose();
        ven.setVisible(true);
    }
    
    private void CerrarVentana(){
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        VerCompetencia ven =new VerCompetencia(usuarioActual, competenciaActual);
        dispose();
        ven.setVisible(true);
    }
    });
    }
    public void cargarFixture(){
        if(competenciaSeleccionada.getFormaDePuntuacion().equals("Resultado Final"))
        {
            if(competenciaSeleccionada.getLiga().getEmpate())
            {
                tablaDePosicionesModeloTabla= new ModeloTabla(new String[] { "Pocision", "Equipo", "Puntos", "Partidos Ganados", "PG", "PE", "PP", }, 0);
                for(int i=0;i<tablaSeleccionada.size();i++)
                {
                    Vector <String> datos = new Vector <String>();
                    datos.add(""+tablaSeleccionada.get(i).getPosicion());
                    datos.add(tablaSeleccionada.get(i).getParticipante().getNombre());
                    datos.add(""+tablaSeleccionada.get(i).getPuntos());
                    datos.add(""+tablaSeleccionada.get(i).getPartidosGanados());
                    datos.add(""+tablaSeleccionada.get(i).getPartidosEmpatados());
                    datos.add(""+tablaSeleccionada.get(i).getPartidosPerdidos());
                      
                     
                          
                    tablaDePosicionesModeloTabla.addRow(datos);
                }
            }
            else
            {
                tablaDePosicionesModeloTabla= new ModeloTabla(new String[] { "Pocision", "Equipo", "Puntos", "PG", "PP" }, 0);
                for(int i=0;i<tablaSeleccionada.size();i++)
                {
                    Vector <String> datos = new Vector <String>();
                    datos.add(""+tablaSeleccionada.get(i).getPosicion());
                    datos.add(tablaSeleccionada.get(i).getParticipante().getNombre());
                    datos.add(""+tablaSeleccionada.get(i).getPuntos());
                    datos.add(""+tablaSeleccionada.get(i).getPartidosGanados());
                    datos.add(""+tablaSeleccionada.get(i).getPartidosPerdidos());
                      
                     
                          
                    tablaDePosicionesModeloTabla.addRow(datos);
                }
            
            }    
        
        
        }
        else
        {
            if(competenciaSeleccionada.getLiga().getEmpate())
            {
                tablaDePosicionesModeloTabla= new ModeloTabla(new String[] { "Pocision", "Equipo", "Puntos", "PG", "PE", "PP", "Goles a Favor", "Goles Encontra", "Diferencia"}, 0);
            
                for(int i=0;i<tablaSeleccionada.size();i++)
                {
                    Vector <String> datos = new Vector <String>();
                    datos.add(""+tablaSeleccionada.get(i).getPosicion());
                    datos.add(tablaSeleccionada.get(i).getParticipante().getNombre());
                    datos.add(""+tablaSeleccionada.get(i).getPuntos());
                    datos.add(""+tablaSeleccionada.get(i).getPartidosGanados());
                    datos.add(""+tablaSeleccionada.get(i).getPartidosEmpatados());
                    datos.add(""+tablaSeleccionada.get(i).getPartidosPerdidos());
                    datos.add(""+tablaSeleccionada.get(i).getTantosAFavor());
                    datos.add(""+tablaSeleccionada.get(i).getTantosEncontra());
                    datos.add(""+tablaSeleccionada.get(i).getDiferencia());
                      
                     
                          
                    tablaDePosicionesModeloTabla.addRow(datos);
                }
            }
            else
            {
                tablaDePosicionesModeloTabla= new ModeloTabla(new String[] { "Pocision", "Equipo", "Puntos", "PG", "PP", "Goles a Favor", "Goles Encontra", "Diferencia"}, 0);
                for(int i=0;i<tablaSeleccionada.size();i++)
                {
                    Vector <String> datos = new Vector <String>();
                    datos.add(""+tablaSeleccionada.get(i).getPosicion());
                    datos.add(tablaSeleccionada.get(i).getParticipante().getNombre());
                    datos.add(""+tablaSeleccionada.get(i).getPuntos());
                    datos.add(""+tablaSeleccionada.get(i).getPartidosGanados());
                    datos.add(""+tablaSeleccionada.get(i).getPartidosPerdidos());
                    datos.add(""+tablaSeleccionada.get(i).getTantosAFavor());
                    datos.add(""+tablaSeleccionada.get(i).getTantosEncontra());
                    datos.add(""+tablaSeleccionada.get(i).getDiferencia());
                      
                     
                          
                    tablaDePosicionesModeloTabla.addRow(datos);
                }
            
            }   
        }
        tablaDePosicionesJTable.setModel(tablaDePosicionesModeloTabla);
        //ajustartabla();
    }
    private void imprimirJButton_actionPerformed(ActionEvent e) {
        try {
                  
                   String strDate = MessageFormat.format("{0,date,short} {0,time,short}", new Date());
                   MessageFormat headerFormat = new MessageFormat("Tabla de Posiociones de:"+competenciaSeleccionada.getNombreCompetencia()+"    Impreso: "+strDate);
                   MessageFormat footerFormat = new MessageFormat("- {0} -");
                   PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
                           aset.add(OrientationRequested.LANDSCAPE);
                   tablaDePosicionesJTable.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat, true, aset, true);
               } catch (PrinterException f) {
               }
    }
    private void ajustartabla(){
            tablaDePosicionesJTable.setAutoResizeMode ( JTable.AUTO_RESIZE_OFF ) ;

            for ( int i = 2 ; i < tablaDePosicionesJTable.getColumnCount () ; i++ ) {
              DefaultTableColumnModel colModel = ( DefaultTableColumnModel ) tablaDePosicionesJTable.getColumnModel () ;
              TableColumn col = colModel.getColumn ( i ) ;
              int width = 0 ;

              TableCellRenderer renderer = col.getHeaderRenderer () ;
              for ( int r = 0 ; r < tablaDePosicionesJTable.getRowCount () ; r++ ) {
                renderer = tablaDePosicionesJTable.getCellRenderer ( r, i ) ;
                Component comp = renderer.getTableCellRendererComponent ( tablaDePosicionesJTable, tablaDePosicionesJTable.getValueAt ( r, i ) ,
                    false, false, r, i ) ;
                width = Math.max ( width, comp.getPreferredSize () .width ) ;
              }
              col.setPreferredWidth ( width + 2 ) ;
            }
        
        }

    private void exportarJButton_actionPerformed(ActionEvent e) {
        
        //ExcelTableExporter excelExporter = new ExcelTableExporter(tablaDePosicionesJTable, new File("exportar.xls"), sheetsName);
        List<JTable> tables = new ArrayList<JTable>();
        List<String> sheetsName = new ArrayList<String>();
        tables.add(tablaDePosicionesJTable);

        sheetsName.add("Tabla de Posiciones");

        ExcelTableExporter excelExporter=null;
        try {
            excelExporter = new ExcelTableExporter(tables, new File("exportar.xls"), sheetsName);
        } catch (Exception f) {
        }
        if (excelExporter.export()) {
            JOptionPane.showMessageDialog(null, "Exportado con exito!");
        }
    }
}
