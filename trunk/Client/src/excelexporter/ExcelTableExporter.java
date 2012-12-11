package excelexporter;

import java.io.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.JTableHeader;

import jxl.write.*;
import jxl.*;

public class ExcelTableExporter {

    private File file;
    private List<JTable> tables;
    private List<String> nombreTabs;

    public ExcelTableExporter(List<JTable> tables, File file, List<String> nombreTabs) throws Exception {
        this.file = file;
        this.tables = tables;
        this.nombreTabs = nombreTabs;
        if(nombreTabs.size()!=tables.size()){
            throw new Exception("Cantidad de tablas debe coincidir con el nombre de tabs");
        }
    }

    public boolean export() {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));

            WritableWorkbook w = Workbook.createWorkbook(out);
            for (int index=0;index<tables.size();index++) {
                JTable table=tables.get(index);
                WritableSheet s = w.createSheet(nombreTabs.get(index), 0);
                JTableHeader head = table.getTableHeader();
                
                    for (int i = 0; i < table.getColumnCount(); i++) {
                        for (int j = 0; j < table.getRowCount(); j++) {
                            Object objeto = table.getTableHeader().getColumnModel().getColumn(0).getHeaderValue().toString();  
                            s.addCell(new Label(i, j, String.valueOf(objeto)));
                        }
                    }
                    
                for (int i = 0; i < table.getColumnCount(); i++) {
                    for (int j = 0; j < table.getRowCount(); j++) {
                        Object objeto = table.getValueAt(j, i);
                        s.addCell(new Label(i, j+1, String.valueOf(objeto)));
                    }
                }
            }
            w.write();
            w.close();
            out.close();



            return true;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (WriteException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
