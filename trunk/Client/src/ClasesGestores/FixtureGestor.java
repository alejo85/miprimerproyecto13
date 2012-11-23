package ClasesGestores;


import ClasesLogicas.Fixture;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.Participante;
import ClasesLogicas.Ronda;

public class FixtureGestor {
    public FixtureGestor() {
        super();
    }

    /**
     * @param lugares
     * @param participantes
     * @return
     */
 //todo borrar main de prueba
 /*  
     public static  void main(String[] args) {
    
        int i;
        LugarDeRealizacion[] lugares = new LugarDeRealizacion[3];
        Deporte deporte[] = new Deporte[10];
        Participante participantes[]=new Participante[6];  
        Fixture fixture;
          
        for (i=0;i<3;i++){
            lugares[i]=new LugarDeRealizacion("", "hola","lala", 99, deporte);
        }
        
        for(i=0;i<6;i++){
            participantes[i]=new Participante(i+"");
        }
        
        fixture = generarFixture(lugares, participantes, 6);    
        System.out.println("");
     }
  */
    public static Fixture generarFixture(LugarDeRealizacion[] lugares,                   
        Participante[] participantes, int cantidadDeParticipantes){
        
        Fixture fixture = new Fixture();
        Ronda rondas[] = new Ronda[cantidadDeParticipantes-1];

        
        for (int i=0; i<cantidadDeParticipantes-1;i++){            
            rondas[i] = RondaGestor.crearRonda(lugares,cantidadDeParticipantes/2);
        }
        
        fixture.setRondas(rondas);
        cargarParticipantes(participantes, fixture);
            System.out.println("antes de retonar fixture");
        return fixture;
        }
   
   
    public void actualizar(){}
    
    public static void cargarParticipantes (Participante[] participantes, Fixture fixture){
        
        
        int e = participantes.length-1;
        int f = participantes.length / 2;
        int i,j,aux=0;
        int ultimo;
        Participante locales[][] = new Participante[e][f];
        Participante visitantes[][] = new Participante[e][f];
        
        
        for (i=0;i<e;i++){
            
            for(j=0;j<f;j++,aux++){
                
                if (aux == e)
                    aux=0;
                locales[i][j] = participantes[aux]; 
            }
        }
        aux--;
        ultimo = participantes.length-1;
        for(i=0;i<e;i++){
            //aux--;   
            visitantes[i][0] = participantes[ultimo];
            for(j=1;j<f;aux--,j++){
                if(aux==-1)
                    aux=e-1;
                visitantes[i][j] = participantes[aux];
            }
        }
        fixture.cargarParticipantes(locales, visitantes);
        
    }
    
}
