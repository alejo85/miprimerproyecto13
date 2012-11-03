package ClasesBD;


import ClasesLogicas.Regiones;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;


public class RegionesBD {
    public RegionesBD() {
        super();
    }

    /**
     * @param idPais
     * @return
     * @throws SQLException
     */
    public static Vector<Regiones> obtenerRegiones(int idPais) throws SQLException {
        Conexion conexion = new Conexion();
        Vector<Regiones> regiones = new Vector <Regiones>();
        conexion.conectar();
        String consultasql;
        
        consultasql="select * from REGIONES where ID_PAIS = " +idPais;
        
        ResultSet resultado = conexion.consultar(consultasql);

        while (resultado.next()) 
        {
            int id = resultado.getInt("ID");

            String nombre = resultado.getString("NOMBRE");
            Regiones p = new Regiones(id, idPais,nombre);
            regiones.add(p);
        }
        
        conexion.cerrarConexion();
        return regiones;
    }
}
