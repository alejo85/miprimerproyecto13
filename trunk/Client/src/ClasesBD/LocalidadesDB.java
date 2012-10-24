package ClasesBD;


import ClasesLogicas.Localidad;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;


public class LocalidadesDB {
    public LocalidadesDB() {
        super();
    }

    /**
     * @param idRegion
     * @return
     * @throws SQLException
     */
    public  static Vector<Localidad> obtenerLocalidades(int idRegion) throws SQLException {
        Conexion conexion = new Conexion();
        Vector<Localidad> localidades = new Vector <Localidad>();
        conexion.conectar();
        String consultasql;
        
        consultasql="select * from LOCALIDADES where ID_REGION = " +idRegion;
        
        ResultSet resultado = conexion.consultar(consultasql);

        while (resultado.next()) 
        {
            int id = resultado.getInt("ID");
            int idPais = resultado.getInt("ID_PAIS");
            String nombre = resultado.getString("NOMBRE");
            Localidad p = new Localidad(id,idPais, idRegion,nombre);
            localidades.add(p);
        }
        conexion.cerrarConexion();
        return localidades;
    }
}
