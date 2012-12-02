package ClasesBD;


import java.sql.ResultSet;
import java.sql.SQLException;


public class DeportesDB {
    public DeportesDB() {
        super();
    }
    public static ResultSet buscarDeporte(){
        
       // Conexion conexion = new Conexion();
        ResultSet resultado=null;
        String consultaSQL;

        /*try {
            conexion.conectar();
        } catch (SQLException e) {
        }*/
        consultaSQL = "select * from deporte order by nombre";
        
        try {
           resultado = Conexion.consulta.executeQuery(consultaSQL);
        } catch (SQLException e) {
        }
       // conexion.cerrarConexion();
        
        return resultado;
                       
                       }
    public static ResultSet buscarDeporte(int idDeporte){
        
        //Conexion conexion = new Conexion();
        ResultSet resultado=null;
        String consultaSQL;

        /*try {
            conexion.conectar();
        } catch (SQLException e) {
        }*/
        consultaSQL = "select * from deporte where id_Deporte='"+idDeporte+"';";
        
        try {
            resultado = Conexion.consulta.executeQuery(consultaSQL);
        } catch (SQLException e) {
        }
        //conexion.cerrarConexion();
        
        return resultado;
                       
                       }
}
