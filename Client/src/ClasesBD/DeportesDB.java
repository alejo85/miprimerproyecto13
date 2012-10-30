package ClasesBD;


import ClasesLogicas.Deporte;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DeportesDB {
    public DeportesDB() {
        super();
    }
    public static ResultSet buscarDeporte(){
        
        Conexion conexion = new Conexion();
        ResultSet resultado=null;
        String consultaSQL;

        try {
            conexion.conectar();
        } catch (SQLException e) {
        }
        consultaSQL = "select * from deporte";
        
        try {
            resultado = conexion.consultar(consultaSQL);
        } catch (SQLException e) {
        }
        conexion.cerrarConexion();
        
        return resultado;
                       
                       }
}
