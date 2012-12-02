package ClasesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion
{
    static Connection conexion;
    static Statement consulta;

    public Conexion(){}
    public static void conectar() throws SQLException 
    {


        conexion = DriverManager.getConnection("jdbc:postgresql://192.168.229.128:5432/TP?user=postgres&password=Publica123");
        consulta = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

    }

    /**
     * @param sqlConsulta
     * @return
     * @throws SQLException
     */
   /* public ResultSet consultar(String sqlConsulta) throws SQLException 
    {
    
        Statement consulta;
        ResultSet resultado;
        /*La conexion Puede devolver una excepción
                
        consulta = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
       
       
       //ESTO ES LO QUE HAY Q HACER EN CADA LLAMADA
       // resultado = consulta.executeQuery(sqlConsulta);

        return resultado;

    }
    */
    public void consultar() throws SQLException 
    {
    
        
        /*La conexion Puede devolver una excepción
                */
        consulta = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
       
       
       //ESTO ES LO QUE HAY Q HACER EN CADA LLAMADA
       // resultado = consulta.executeQuery(sqlConsulta);

        

    }
    
    
    public static void cerrarConexion()
    {
        /*La conexion Puede devolver una excepción
                */

            try {
                if(conexion != null ) 
                {
                    conexion.close();
                }
            } catch (SQLException e) {
                // TODO
            }
        }
   

}