package ClasesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion
{
    Connection conexion;
    
    public Conexion(){}
    public void conectar() throws SQLException 
    {

        this.conexion = DriverManager.getConnection("jdbc:postgresql://10.0.0.4/TP?user=postgres&password=Publica123");

    }

    /**
     * @param sqlConsulta
     * @return
     * @throws SQLException
     */
    public ResultSet consultar(String sqlConsulta) throws SQLException 
    {
    
        Statement consulta;
        ResultSet resultado;
        /*La conexion Puede devolver una excepción
                */
        consulta = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        resultado = consulta.executeQuery(sqlConsulta);

        return resultado;

    }
    public void cerrarConexion()
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