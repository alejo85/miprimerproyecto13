package ClasesBD;


import ClasesLogicas.Encuentro;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EncuentroDB {
    public EncuentroDB() {
        super();
    }

    /**
     * @param encuentro
     * @return
     */
    public Boolean registrarEncuentro(Encuentro encuentro){
                       return true;}

    /**j
     * @param encuentro
     */
    public void actualizarEncuentro(Encuentro encuentro){
        }
    public static int guardarEncuentro(Encuentro encuentro, int idSubRonda) throws SQLException {
        
            System.out.println("llego a la base id_encuentro");
            int idEncuentro=0;
            Conexion conexion = new Conexion();
            ResultSet resultado=null;
            conexion.conectar();
            String consultasql;
            
            consultasql="INSERT INTO encuentro(id_lugar_de_realizacion, id_Subronda )VALUES ('"+encuentro.getLocación().getIdLugar()+"', '"+idSubRonda+"' )RETURNING id_encuentro;";
            resultado=conexion.consultar(consultasql);
            resultado.next();
            System.out.println("despues del next id_encuentro");
            idEncuentro = resultado.getInt("id_encuentro");
            return idEncuentro;
        
        }
}
