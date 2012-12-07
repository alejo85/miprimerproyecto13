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


        conexion = DriverManager.getConnection("jdbc:postgresql://10.160.150.17:5432/TP2?user=postgres&password=Publica123");
        consulta = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

    }

    /**
     * @param sqlConsulta
     * @return
     * @throws SQLException
     */
    public static ResultSet consultar(String sqlConsulta) throws SQLException 
    {
    
        Statement consulta;
        ResultSet resultado;
        /*La conexion Puede devolver una excepci�n*/
                
        consulta = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
       
       
       //ESTO ES LO QUE HAY Q HACER EN CADA LLAMADA
       resultado = consulta.executeQuery(sqlConsulta);

        return resultado;

    }
    
    public static Statement consultar() throws SQLException 
    {
    
        
        /*La conexion Puede devolver una excepci�n
                */
        consulta = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
       
       
       //ESTO ES LO QUE HAY Q HACER EN CADA LLAMADA
       // resultado = consulta.executeQuery(sqlConsulta);

        return consulta;

    }
    
    
    public static void cerrarConexion()
    {
        /*La conexion Puede devolver una excepci�n
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