package ClasesGestores;


import ClasesBD.LugarDeRealizaciónDB;

import ClasesLogicas.Deporte;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.ParticipanteAnterior;
import ClasesLogicas.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    public LugarDeRealizacion altaLugaresDeRealizacion(String codigo, String Nombre, String descripcion, int disponibilidad,
                              Deporte[] deportesAsociados){
        return new LugarDeRealizacion( codigo,  Nombre,  descripcion,  disponibilidad, deportesAsociados);}

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
    public static Vector<LugarDeRealizacion> lugaresDeRealizaciónAsociadosAlDeporte(String correoElectronico, int codigoDeporte) throws SQLException {
            Vector<LugarDeRealizacion> resultado = new Vector<LugarDeRealizacion>();
        
                
            
            String nombre;
            int id;
            ResultSet resultadoSQL;
            resultadoSQL = LugarDeRealizaciónDB.buscarLugarDeRealización(correoElectronico, codigoDeporte);
           
      
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
    public static LugarDeRealizacion unLugar(LugarDeRealizacion [] lugares){
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
            LugarDeRealizaciónDB.altaLugarDeRealización( codigo,  nombre, descripcion, dSeleccionados,  creado.getCorreoElectronico(),  dias,  horas);
            
        }
    public static LugarDeRealizacion[] lugaresDeLaCompetencia(int idCompetencia){
            LugarDeRealizacion retorno=null;
                Vector <LugarDeRealizacion> datos=new Vector <LugarDeRealizacion>();
                LugarDeRealizacion [] lugares=null;
            ResultSet resultado;

            try {
                resultado = LugarDeRealizaciónDB.buscarCompetencia(idCompetencia);
                ParticipanteAnterior aux = null;

               
                    while(resultado.next()){
                        int id = resultado.getInt("id_lugar_de_realizacion");
                        String nombre = resultado.getString("nombre");
                        int disponibilidad = resultado.getInt("disponibilidad");
                       
                        
                      retorno = new LugarDeRealizacion();
                        retorno.setNombre(nombre);
                        retorno.setIdLugar(id);
                        retorno.setDisponibilidad(disponibilidad);
                        datos.add(retorno);
                        
                    }
                    lugares= new LugarDeRealizacion[datos.size()];
                    for(int j=0;j<datos.size();j++){
                            lugares[j]=datos.get(j);
                        }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
            
            return lugares; 
        
        
        
        }


}
