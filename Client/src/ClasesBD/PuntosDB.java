package ClasesBD;

import ClasesLogicas.Puntos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PuntosDB {
    public PuntosDB() {
        super();
    }
    public void crearPunto(Puntos puntos){}
    
    public static ResultSet buscarPuntos(int idResultado) throws SQLException {
        Statement consulta = Conexion.consultar();
            String consultasql;
            consultasql="SELECT * FROM punto where id_resultado='"+idResultado+"';";
            ResultSet resultado = consulta.executeQuery(consultasql); 
            return resultado;
       
    }
   
}
