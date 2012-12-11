package ClasesGestores;


import ClasesBD.FixtureDB;

import ClasesLogicas.Competencia;
import ClasesLogicas.Encuentro;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.Ronda;
import ClasesLogicas.Subronda;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;


public class RondaGestor {
  
    public RondaGestor() {
        super();
    }
    
   
        
        

    public static Ronda crearRonda(LugarDeRealizacion[] lugares,int cantidadDeEncuentros, int idFixture, int numeroRonda){
        
     
        Ronda laRonda = new Ronda();
        laRonda.setNumeroDeRonda(numeroRonda);
        laRonda.setGanadores(RondaGestor.generarSubRondaLiga(lugares,cantidadDeEncuentros));
      
        try {
            laRonda.setIdRonda(FixtureDB.guardarRonda(laRonda,idFixture));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return laRonda;     
    }

    
    public static boolean actualizarRonda(int ronda, Competencia laCompetencia){
        Encuentro losEncuentros[]=laCompetencia.getFixture().getRondas()[ronda].getGanadores().getEncuentros();
        int size=losEncuentros.length;
        int aux=0;
        for(int i =0;i<losEncuentros.length ;i++)
        {
            if(losEncuentros[i].getGanador()!=null )
            {
                aux++;
            }
            else{
                if(losEncuentros[i].getEmpate())
                      aux++;
                }
            if(losEncuentros[i].getParticipanteA().getIdParticipante()==1)
            {
                    aux++;
            }
            else
            {
                if(losEncuentros[i].getParticipanteB().getIdParticipante()==1)
                {
                    aux++;
                }
            }
          
        }
        if(aux==size)
        {
            
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static Ronda[] getRondas(int idFixture){
            Ronda laRonda[] = null;
            
            int h=0;
            Vector <Ronda> datos=new Vector <Ronda>();
        ResultSet busqueda;

        try {
            busqueda = FixtureDB.buscarRonda(idFixture);
            while (busqueda.next()){
                Ronda unaRonda = new Ronda();
                unaRonda.setIdRonda(busqueda.getInt("id_ronda"));
                unaRonda.setNumeroDeRonda(busqueda.getInt("numeroronda"));
                unaRonda.setGanadores(getSubRondas(busqueda.getInt("id_subronda_ganadores")));
               

                datos.add(unaRonda);
             
                h++;
            } 
        laRonda= new Ronda[datos.size()];
        for(int j=0;j<datos.size();j++){
                
                laRonda[j]=datos.get(j);
                //laRonda[j].setNumeroDeRonda(j+1);
               
            }
    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return laRonda;
        }
    
    public static  Vector <Ronda> getRondasVector(int idFixture){

            Ronda unaRonda = new Ronda();
            int h=0;
            Vector <Ronda> datos=new Vector <Ronda>();
        ResultSet busqueda;

        try {
            busqueda = FixtureDB.buscarRonda(idFixture);
            while (busqueda.next()){
                unaRonda.setIdRonda(busqueda.getInt("id_ronda"));
                unaRonda.setNumeroDeRonda(busqueda.getInt("numeroronda"));
                unaRonda.setGanadores(getSubRondas(busqueda.getInt("id_subronda_ganadores")));
                

                datos.add(unaRonda);
               
                h++;
                
            } 
       
 
         
    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
        }
    public static Subronda getSubRondas(int idSubRonda) throws SQLException {
            
            
        
        ResultSet busqueda;

            Subronda unaRonda=null;
            busqueda = FixtureDB.buscarSubRonda(idSubRonda);
            while (busqueda.next()){
                unaRonda = new Subronda();
                unaRonda.setIdSubronda(idSubRonda);
                unaRonda.setEstado(busqueda.getBoolean("estado"));
                Encuentro[] encuentrosDeSubRonda =EncuentroGestor.encuentrosDeSubRonda(idSubRonda );
               
            unaRonda.setEncuentros(encuentrosDeSubRonda);
   
            
            }
            
       
            
        return unaRonda;
        }
    public void estadoRonda(){}


  
    /**
     * @param rondaAA = ronda A Actualizar
     */
    public void actualizarEstado(Ronda[] rondaAA){
       
        int i;
        int tamanio= rondaAA.length;
            
        for (i=0;i<tamanio;i++){
            
        ///    rondaAA[i];
        }
        
          
    }
    
    public static Subronda generarSubRondaLiga(LugarDeRealizacion[] lugares,int cantidadDeEncuentros){
        
        
        int random;
        int repeticiones = cantidadDeEncuentros;
        Subronda subronda = new Subronda();
        Encuentro encuentros[] = new Encuentro[cantidadDeEncuentros];
        LugarDeRealizacion[] lugaresAux = lugares;
       
       try {
            subronda.setIdSubronda(FixtureDB.guardarSubronda());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
  
      
            
            random = 0 + (int)(Math.random()*lugaresAux.length);
            
            if (lugaresAux[random].getDisponibilidad()>0){
            
                for(int i=0; i < cantidadDeEncuentros; i++){
                    
                   encuentros[i] = EncuentroGestor.crearEncuentro(lugaresAux[random],subronda.getIdSubronda() ); 
                   lugaresAux[random].menosDisponibilidad();
                }
              
                repeticiones--;        
            }
   
        
        subronda.setEncuentros(encuentros);
       
        return subronda; 
        
        
        
    }
    public static void eliminarRonda(int idFixture){

        try {
            FixtureDB.eliminarRonda(idFixture);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void eliminarSubRonda(int idSubRonda){

        try {
            FixtureDB.eliminarRonda(idSubRonda);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
