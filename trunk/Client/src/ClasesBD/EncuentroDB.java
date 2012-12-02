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
        
   
            int idEncuentro=0;
            //Conexion conexion = new Conexion();
            ResultSet resultado=null;
            //conexion.conectar();
            String consultasql;
            
            consultasql="INSERT INTO encuentro(id_lugar_de_realizacion, id_Subronda )VALUES ('"+encuentro.getLocación().getIdLugar()+"', '"+idSubRonda+"' )RETURNING id_encuentro;";
           // System.out.println(consultasql);
            resultado = Conexion.consulta.executeQuery(consultasql);
            resultado.next();
            
            idEncuentro = resultado.getInt("id_encuentro");
            //System.out.println("despues id_encuentro: "+idEncuentro);
            return idEncuentro;
        
        }
    public static ResultSet buscarEncuentros(int idSubRonda) throws SQLException {
            //System.out.println("llego a la base id_encuentro");

            //Conexion conexion = new Conexion();
            ResultSet resultado=null;
            //conexion.conectar();
            String consultasql;
            
            consultasql="SELECT *  FROM encuentro where id_subronda='"+idSubRonda+"';";
           System.out.println(consultasql);
            resultado = Conexion.consulta.executeQuery(consultasql);
            return resultado;
        
        }
    public static  void eliminarEncuentros(int idEncuentro) throws SQLException {
            //System.out.println("llego a la base id_encuentro");

            //Conexion conexion = new Conexion();
            ResultSet resultado=null;
            //conexion.conectar();
            String consultasql;
            
            consultasql="DELETE FROM encuentro WHERE id_encuentro='"+idEncuentro+"';";
           // System.out.println(consultasql);
            resultado = Conexion.consulta.executeQuery(consultasql);

        
        }
}
