package ClasesGestores;


import ClasesBD.DeportesDB;
import ClasesBD.LugarDeRealizaci�nDB;

import ClasesLogicas.Deporte;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.LugarDeRealizaci�n;
import ClasesLogicas.Usuario;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;


public class LugaresDeRealizacionGestores {
    public LugaresDeRealizacionGestores() {
        super();
    }

    /**
     * @param codigo
     * @param Nombre
     * @param descripcion
     * @param disponibilidad
     * @param deportesAsociados
     * @return
     */
    public LugarDeRealizaci�n altaLugaresDeRealizacion(String codigo, String Nombre, String descripcion, int disponibilidad,
                              Deporte[] deportesAsociados){
        return new LugarDeRealizaci�n( codigo,  Nombre,  descripcion,  disponibilidad, deportesAsociados);}

    /**
     * @param codigo
     */
    public void bajaLugarDeRealizacion(String codigo){}

    /**
     * @param codigo
     */
    public void disminuirDisponibilidad(String codigo){}

    /**
     * @param codigo
     */
    public void asociarDeporte(String codigo){}

    /**
     * @param codigo
     */
    public void eliminarDeporte(String codigo){}

    /**
     * @param codigoDeporte
     * @return
     */
    public static Vector<LugarDeRealizacion> lugaresDeRealizaci�nAsociadosAlDeporte(String correoElectronico, int codigoDeporte) throws SQLException {
            Vector<LugarDeRealizacion> resultado = new Vector<LugarDeRealizacion>();
        
                
            
            String nombre,Codigo;
            int id, id_Lugar_de_Realizacion;
            ResultSet resultadoSQL;
            resultadoSQL = LugarDeRealizaci�nDB.buscarLugarDeRealizaci�n(correoElectronico, codigoDeporte);
           
      
            LugarDeRealizacion unLugar;



        
                while (resultadoSQL.next()){
                    id = resultadoSQL.getInt("id_Lugar_de_Realizacion");
                    nombre = resultadoSQL.getString("Nombre");
                    unLugar = new LugarDeRealizacion();
                    unLugar.setIdLugar(id);
                    unLugar.setNombre(nombre);
                    resultado.add(unLugar);

            
                }
            
       
        
        
        
                 
        
        
        return resultado;
        }
    public static LugarDeRealizaci�n unLugar(LugarDeRealizaci�n [] lugares){
            int i;
        do{
               i = (int)(Math.random()*(lugares.length));
            
            }
        while(lugares[i].getDisponibilidad()>0);
            lugares[i].menosDisponibilidad();
  
        
        return lugares[i];
        }

    /**
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param dSeleccionados
     * @param creado
     * @throws SQLException
     */
    public static void altaLugar(String codigo, String nombre, String descripcion,Vector <Deporte> dSeleccionados, Usuario creado)throws SQLException{
            java.util.Date fecha = new Date();
            int dia = fecha.getDate();
            int mes = fecha.getMonth() + 1;
            int anio = fecha.getYear() + 1900;
            int hora = fecha.getHours();
            int min = fecha.getMinutes();
            String horas;
            
            if (min < 10)
            {
                horas= ""+hora+":"+"0" + min;
                
            }
            String dias = ""+dia+"/"+mes+"/"+anio;
            horas = ""+hora+":"+ min;
            LugarDeRealizaci�nDB.altaLugarDeRealizaci�n( codigo,  nombre, descripcion, dSeleccionados,  creado.getCorreoElectronico(),  dias,  horas);
            
        }

}
