package ClasesLogicas;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class ModeloTabla extends DefaultTableModel
{
    public ModeloTabla() {
    }
    public ModeloTabla( String[] titulo , int posicion)
    {
        super(titulo,posicion);
    }
    
   public boolean isCellEditable (int row, int column)
   {
       // Aquí devolvemos true o false según queramos que una celda
       // identificada por fila,columna (row,column), sea o no editable
       return false;
   }
   
  
   
   public ModeloTabla getModel(){
       return this;
   }
    /* Setea las caracteristicas por default de la tabla */
     public static void crearTablaVaciaPorDefault(final JTable unaTabla, final String[] referenciasColumnas){    
        DefaultTableModel unModeloTabla;
        TableColumnModel unModeloColumna;
        int cantidadColumnas;
        try{
            /* Creo el modelo de tabla generico */
            unModeloTabla = new ModeloTabla();
            /* Asigno el modelo de la tabla a la tabla */
            unaTabla.setModel(unModeloTabla);
            /* Obtengo el modelo de columnas de la tabla */
            unModeloColumna = unaTabla.getColumnModel();
            /* Indico que las columnas de la tabla no se pueden reordenar */
            unaTabla.getTableHeader().setReorderingAllowed(false);
            /* Asigno las referencias de columnas al modelo de tabla */
            unModeloTabla.setColumnIdentifiers(referenciasColumnas);
            /* Obtengo la cantidad de columnas que tiene el modelo de tabla */
            cantidadColumnas = referenciasColumnas.length;
            
            for (int i =0; i< cantidadColumnas; i++){
                /* Seteo que no se pueda redimensionar una columna */
                //unModeloColumna.getColumn(i).setResizable(false);
                /* Seteo el minimo de ancho para la columna */
                //unModeloColumna.getColumn(i).setMinWidth(referenciasColumnas[i].length()*10);
                /* Seteo el ancho preferente para la columna */
                //unModeloColumna.getColumn(i).setPreferredWidth(referenciasColumnas[i].length()*10);
                /* Seteo el maximo de ancho para la columna */
                //unModeloColumna.getColumn(i).setMaxWidth(referenciasColumnas[i].length()*10);
            }
        }catch (Exception e){
             // TODO
        }
     }
     /* Agrega datos del result set al modelo de tabla ya creado */
    private static void agregarDatosAlModelo(final ResultSet unResultSet, final DefaultTableModel unModeloTabla ){
        int cantidadColumnas;
        Object[] unaFila;
        
        try {
            while(unResultSet.next()){
            /* Mientras haya registros en el resultset */
            /* Asigno la cantidad de columnas del resultset */
            cantidadColumnas = unModeloTabla.getColumnCount();
            /* Creo una fila de tantos objetos como columnas haya */
            unaFila = new Object[cantidadColumnas];
            /* Cargo cada objeto en la columna de la fila correspondiente */
            for (int i=0; i < cantidadColumnas; i++){
                unaFila[i] = unResultSet.getObject(i+1);
            }
            /* Agrego la fila completa al modelo de tabla */
            unModeloTabla.addRow(unaFila);
        }
        } catch (SQLException e) {
            // TODO
        }
    }
    /* Agrega las columnas que correspondan al resultset */
    private static void agregarReferenciasDeColumnasAlModelo(final ResultSet unResultSet, final DefaultTableModel unModeloTabla ){
        ResultSetMetaData metaDatosUnResultSet;
        int numeroColumnas;
        Object[] etiquetasColumnas;
        
        try {
            /* Asigno los metadatos del result set */
            metaDatosUnResultSet = unResultSet.getMetaData();
            /* Obtengo el numero de columnas de los meta datos */
            numeroColumnas = metaDatosUnResultSet.getColumnCount();
            /* Creo tantas etiquetas como columnas tenga el resultset */
            etiquetasColumnas = new Object[numeroColumnas];
            for (int i = 0; i < numeroColumnas; i++){
                etiquetasColumnas[i] = metaDatosUnResultSet.getColumnLabel(i+1);
            }
            
            unModeloTabla.setColumnIdentifiers(etiquetasColumnas);
            
        } catch (SQLException e) {
            // TODO
        }
    }
    /* Agrega los datos del resultset en el modelo de tabla */
    private static void crearTablaResultSetPorDefault(final JTable unaTabla, final ResultSet unResultSet){
        DefaultTableModel unModeloTabla;
        TableColumnModel unModeloColumna;
        int cantidadColumnas;
       /* Crear las referencias de las columnas */
       /* Creo el ModeloTabla */
        unModeloTabla = new ModeloTabla();
        /* Agrego las referencias de las columnas al modelo */
        agregarReferenciasDeColumnasAlModelo(unResultSet, unModeloTabla);
        agregarDatosAlModelo(unResultSet, unModeloTabla);
        /* Obtengo el modelo de columnas de la tabla */
        unModeloColumna = unaTabla.getColumnModel();
        /* Asigno la cantidad de columnas del resultset */
        cantidadColumnas = unModeloTabla.getColumnCount();
        
        for (int i =0; i< cantidadColumnas; i++){
            /* Seteo que no se pueda redimensionar una columna */
            //unModeloColumna.getColumn(i).setResizable(false);
            /* Seteo el minimo de ancho para la columna */
            //unModeloColumna.getColumn(i).setMinWidth(referenciasColumnas[i].length()*10);
            /* Seteo el ancho preferente para la columna */
            //unModeloColumna.getColumn(i).setPreferredWidth(referenciasColumnas[i].length()*10);
            /* Seteo el maximo de ancho para la columna */
            //unModeloColumna.getColumn(i).setMaxWidth(referenciasColumnas[i].length()*10);
        }
    }
}