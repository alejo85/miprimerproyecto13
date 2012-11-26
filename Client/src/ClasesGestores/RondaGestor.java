package ClasesGestores;


import ClasesBD.FixtureDB;

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
    
   //TODO se borro public Ronda [] generarRonda(Competencia unaCompetencia)
        
        

    public static Ronda crearRonda(LugarDeRealizacion[] lugares,int cantidadDeEncuentros, int idFixture, int numeroRonda){
        
        
        Ronda laRonda = new Ronda();
        laRonda.setNumeroDeRonda(numeroRonda);
        laRonda.setGanadores(RondaGestor.generarSubRondaLiga(lugares,cantidadDeEncuentros));
        //TODO Guardarla en la base
        try {
            laRonda.setIdRonda(FixtureDB.guardarRonda(laRonda,idFixture));
        } catch (SQLException e) {
        }
        return laRonda;     
    }

    
    public void actualizarRonda(){}
    
    public static Ronda[] getRondas(int idFixture){
            Ronda laRonda[] = null;
            Ronda unaRonda = new Ronda();
        ResultSet busqueda;

        try {
            busqueda = FixtureDB.buscarRonda(idFixture);
            while (busqueda.next()){
                unaRonda.setIdRonda(busqueda.getInt("id_ronda"));
                unaRonda.setNumeroDeRonda(busqueda.getInt("numeroronda"));
                unaRonda.setGanadores(getSubRondas(unaRonda.getIdRonda()));


            
            }
        } catch (SQLException e) {
        }
        return laRonda;
        }
    public static Subronda getSubRondas(int idSubRonda){
            
            Subronda unaRonda = new Subronda();
            Vector<Subronda> subRonda=new Vector<Subronda>();
        ResultSet busqueda;

        try {
            busqueda = FixtureDB.buscarSubRonda(idSubRonda);
            while (busqueda.next()){
                unaRonda.setIdSubronda(busqueda.getInt("id_ronda"));
         //       unaRonda.busqueda.getInt("numeroronda"));
   
            
            }
            
        } catch (SQLException e) {
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
        
        Subronda subronda = new Subronda();
        try {
            subronda.setIdSubronda(FixtureDB.guardarSubronda());
        } catch (SQLException e) {
        }
        LugarDeRealizacion[] lugaresAux = lugares;
      
        int random;
        int repeticiones = cantidadDeEncuentros;
        Encuentro encuentros[] = new Encuentro[cantidadDeEncuentros];
                
        //todo corregir el diagrama de secuencias!!! 17.1
            
        while (repeticiones>0){
            
            random = 0 + (int)(Math.random()*lugaresAux.length);
            System.out.println("random: "+random);
            if (lugaresAux[random].getDisponibilidad()>0){
            
                for(int i=0; i < cantidadDeEncuentros; i++){
                    
                   encuentros[i] = EncuentroGestor.crearEncuentro(lugaresAux[random],subronda.getIdSubronda() ); 
                }
                
                repeticiones--;
        
            }
        }
        
        subronda.setEncuentros(encuentros);
       
        return subronda; 
        
        
        
    }
}
