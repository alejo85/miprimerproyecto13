package ClasesBD;


import ClasesLogicas.Deporte;
import ClasesLogicas.LugarDeRealizacion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;


public class LugarDeRealizaciónDB {
    public LugarDeRealizaciónDB() {
        super();
    }
    public boolean buscarLugarDeRealización(String codigo, String nombreLugarDerealización,Deporte deporteSeleccionado ){
                       return true;}
    public static ResultSet altaLugarDeRealización(String codigo, String nombre,String descripcion, Vector <Deporte> dSeleccionados, String creado, String dia, String hora) throws SQLException {
    
                               Conexion conexion = new Conexion();
                               ResultSet resultado=null;
                               int idLugarDeRealizacion;
                               conexion.conectar();
                               String consultasql;
                               consultasql="INSERT INTO LUGAR_DE_REALIZACION(Codigo,Nombre, Descripcion) VALUES" +
                                   "('"+codigo+"','"+nombre+ "','" +descripcion +"');";
                               
                               
                               
                               try {
                                   resultado = conexion.consultar(consultasql);
                               } catch (SQLException f) {
                                   System.out.println(f.getMessage());
                               }
                               conexion.cerrarConexion();
                               idLugarDeRealizacion= idLugar();
                               System.out.println(idLugarDeRealizacion);
                               conexion.cerrarConexion();
                               conexion = new Conexion();

                               consultasql="INSERT INTO CREA(Creador,id_Lugar_de_Realizacion, Fecha, Hora) VALUES" +
                                   "('"+creado+"','"+idLugarDeRealizacion+ "','"+dia+ "','" +hora +"');";
                               System.out.println(consultasql);
                               try {
                                   resultado = conexion.consultar(consultasql);
                               } catch (SQLException f) {
                                   System.out.println(f.getMessage());
                               }
                               conexion.cerrarConexion();
                               conexion = new Conexion();
                               for(int i=0; i < dSeleccionados.size();i++){
                                   consultasql="INSERT INTO ASOCIADO(id_Lugar_de_Realizacion, id_Deporte ) VALUES" +
                                       "('"+idLugarDeRealizacion+ "','"+dSeleccionados.get(i).getIdDeporte()+"');";
                                       try {
                                           resultado = conexion.consultar(consultasql);
                                       } catch (SQLException f) {
                                           System.out.println(f.getMessage());
                                       }
                                       System.out.println(consultasql);
                                       conexion.cerrarConexion();
                                       conexion = new Conexion();
                                   }
                               conexion.cerrarConexion();
                               return resultado;
                           
                           }
    private static int idLugar(){
        int idLugarDeRealizacion=0;
        ResultSet resultado=null;
        String consultasql;
        Conexion conexion = new Conexion();
        consultasql="select nextval('lugar_de_realizacion_id_lugar_de_realizacion_seq');";
            System.out.println(consultasql);
            try {
                resultado = conexion.consultar(consultasql);
            } 
            catch (SQLException f) {
                System.out.println(f.getMessage());
            }
        try {
            while (resultado.next()){
                idLugarDeRealizacion =resultado.getInt(1)-1;

            
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idLugarDeRealizacion;
        }
    public boolean existeLugarDeRealización(String nombreLugarDerealización){
                       return true;}
    public boolean modificarLugarDeRealización(LugarDeRealizacion lugar){
                       return true;}
    public boolean eliminarLugarDeRealización(LugarDeRealizacion lugar){
                       return true;}
    public static ResultSet buscarLugarDeRealización(String correoElectronico,int idDeporteSeleccionado ){
                           ResultSet resultado=null;
                       
                       
                       return resultado;
                       
                       }

}
