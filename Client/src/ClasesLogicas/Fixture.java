package ClasesLogicas;

import ClasesBD.FixtureDB;

import java.sql.SQLException;

import java.util.Vector;


public class Fixture{

	private int idFixture;
	private Ronda[] rondas;
        

    public Fixture(int idFixture, Ronda[] rondas) {
        super();
        this.idFixture = idFixture;
        this.rondas = rondas;
    }

    public Fixture() {
        super();
    }

    public void setIdFixture(int idFixture) {
        this.idFixture = idFixture;
    }

    public int getIdFixture() {
        return idFixture;
    }

    public void setRondas(Ronda[] rondas) {
        
 
        
        
        
        
        
        
        
        
        this.rondas = rondas;
    }

        

    public Ronda[] getRondas() {
        return rondas;
    }

    /**
     * @param participantes
     */
    public void generarRondas(Participante[] participantes){
       
        }

    /**
     * @param participantes
     */
    public void cargarParticipantes(Participante[][] locales, Participante[][] visitantes){
       
            int nroRonda = locales.length;
            int nroEncuentro = locales[0].length;
            int i, j;
            Encuentro[] encuentros;
                           
            for (i=0;i<nroRonda;i++){
                
                encuentros = this.rondas[i].getGanadores().getEncuentros();
                for(j=0;j<nroEncuentro;j++){

                    encuentros[j].setParticipanteA(locales[i][j]);
                    encuentros[j].setParticipanteB(visitantes[i][j]);
                                      
                }
            }
       
       
       
        }
    
    

   
}
