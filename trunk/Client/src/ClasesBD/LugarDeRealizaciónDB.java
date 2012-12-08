package ClasesBD;


import ClasesLogicas.Deporte;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;


public class LugarDeRealizaciónDB {
    public LugarDeRealizaciónDB() {
        super();
    }
    public static ResultSet buscarLugarDeRealización(String correoElectronico, int idDeporteSeleccionado ){
                           ResultSet resultado=null;
                           String consultasql;
                           consultasql="select L.* from LUGAR_DE_REALIZACION as L, CREA as C, ASOCIADO as A where C.Creador='"+correoElectronico+"' and C.id_Lugar_de_Realizacion=A.id_Lugar_de_Realizacion and A.id_Deporte='"+idDeporteSeleccionado+"' and C.id_Lugar_de_Realizacion=L.id_Lugar_de_Realizacion;";
                           try {
                               resultado = Conexion.consulta.executeQuery(consultasql);
                           } catch (SQLException e) {
								System.out.println(e.getMessage());
                           }
                           return resultado;
                           }
    public static void altaLugarDeRealización(String codigo, String nombre,String descripcion, Vector <Deporte> dSeleccionados, String creado, String dia, String hora){
        ResultSet resultado=null;
        int idLugarDeRealizacion=0;
        String consultasql;
        consultasql="INSERT INTO LUGAR_DE_REALIZACION(Codigo,Nombre, Descripcion) VALUES" +"('"+codigo+"','"+nombre+ "','" +descripcion +"')RETURNING id_lugar_de_realizacion;";

        try {
            resultado = Conexion.consulta.executeQuery(consultasql);
            resultado.next();
            idLugarDeRealizacion= resultado.getInt("id_lugar_de_realizacion");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // CREANDO LA CONSULTA
        consultasql="INSERT INTO CREA(Creador,id_Lugar_de_Realizacion, Fecha, Hora) VALUES" +"('"+creado+"','"+idLugarDeRealizacion+ "','"+dia+ "','" +hora +"');";
        // CONSULTA EN BD
        try {
            resultado = Conexion.consulta.executeQuery(consultasql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        for(int i=0; i < dSeleccionados.size();i++){
            // CREANDO LA CONSULTA
            consultasql="INSERT INTO ASOCIADO(id_Lugar_de_Realizacion, id_Deporte ) VALUES" +"('"+idLugarDeRealizacion+ "','"+dSeleccionados.get(i).getIdDeporte()+"');";
            try {
                // CONSULTA EN BD
               resultado = Conexion.consulta.executeQuery(consultasql);
            } catch (SQLException e) {
            }
        }                      
         }
    public static ResultSet buscarCompetencia(int competencia){
                           ResultSet resultado=null;
                           String consultasql;
                           consultasql="SELECT *\n" + 
                           "  FROM lugar_de_realizacion as L, juega as J where L.id_lugar_de_realizacion=J.id_lugar_de_realizacion and J.id_competencia='"+competencia+"';";
                           try {
                            resultado = Conexion.consulta.executeQuery(consultasql);
                           } catch (SQLException e) {
                           }
                       return resultado;
                       }
}
