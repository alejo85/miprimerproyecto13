package ClasesLogicas;

import java.util.Stack;

public class Encuentro {
    private Integer idEncuentro;
    private Participante participanteA;
    private Participante participanteB;
    private Participante ganador;
    private Participante perdedor;
    private Boolean empate=false;

    private int asistencia; //-1 ==> Asistio A: 0==> los dos; 1 ==> asistio B
    private String horaResultado;
    private String fechaResultado;

    private Stack <Resultados> resultado;
    private LugarDeRealizacion locación;
    


    public Encuentro() {
        super();
    }



    public Encuentro(Participante participanteA, Participante participanteB, Participante ganador,
                     Participante perdedor, Boolean empate, Stack<Resultados> resultado, LugarDeRealizacion locación) {
        super();
        this.participanteA = participanteA;
        this.participanteB = participanteB;
        this.ganador = ganador;
        this.perdedor = perdedor;
        this.empate = empate;
        this.resultado = resultado;
        this.locación = locación;
    }

    public Encuentro(LugarDeRealizacion locación) {
        super();
        this.locación = locación;
    }

    public Encuentro(Integer idEncuentro, Participante participanteA, Participante participanteB, Participante ganador,
                     Participante perdedor, Boolean empate, int asistencia, String horaResultado,
                     String fechaResultado, Stack<Resultados> resultado, LugarDeRealizacion locación) {
        super();
        this.idEncuentro = idEncuentro;
        this.participanteA = participanteA;
        this.participanteB = participanteB;
        this.ganador = ganador;
        this.perdedor = perdedor;
        this.empate = empate;
        this.asistencia = asistencia;
        this.horaResultado = horaResultado;
        this.fechaResultado = fechaResultado;
        this.resultado = resultado;
        this.locación = locación;
    }


    public void setIdEncuentro(Integer idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public Integer getIdEncuentro() {
        return idEncuentro;
    }

    
   public void setParticipanteA(Participante participanteA) {
        this.participanteA = participanteA;
    }

    public Participante getParticipanteA() {
        return participanteA;
    }

    public void setParticipanteB(Participante participanteB) {
        this.participanteB = participanteB;
    }

    public Participante getParticipanteB() {
        return participanteB;
    }

    public void setGanador(Participante ganador) {
        this.ganador = ganador;
    }
    public void setGanador() {

            int puntosA=0;
            int puntosB=0;
            for(int i=0; i<this.resultado.pop().getPuntuacion().length;i++)
            {
                    puntosA+=this.resultado.pop().getPuntuacion()[i].getPuntoA();
                    puntosB+=this.resultado.pop().getPuntuacion()[i].getPuntoB();
                }
            if(puntosA==puntosB)
            {
                this.empate=true;
                }
            else
                if(puntosA>puntosB)
                {
                    this.ganador=this.participanteA;
                    this.perdedor=this.participanteB;
                    }
                else
                    this.ganador=this.participanteB;
                    this.perdedor=this.participanteA;
                

    }




    public Participante getGanador() {
        return ganador;
    }

    public void setPerdedor(Participante perdedor) {
        this.perdedor = perdedor;
    }

    public Participante getPerdedor() {
        return perdedor;
    }

    public void setEmpate(Boolean empate) {
        this.empate = empate;
    }

    public Boolean getEmpate() {
        return empate;
    }

    public void setResultado(Stack<Resultados> resultado) {
        this.resultado = resultado;
    }
    public void setResultado(Resultados resultado) {
        this.resultado.push(resultado);
    }
    public Stack<Resultados> getResultado() {
        
        return resultado;
    }

    public void setLocación(LugarDeRealizacion locación) {
        this.locación = locación;
    }

    public LugarDeRealizacion getLocación() {
        return locación;
    }

    /**
     * @param resultado
     */
    public void asignaResultado(Resultados resultado){
        this.resultado= new Stack <Resultados>();
            this.resultado.add(resultado);
            
        }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setHoraResultado(String horaResultado) {
        this.horaResultado = horaResultado;
    }

    public String getHoraResultado() {
        return horaResultado;
    }

    public void setFechaResultado(String fechaResultado) {
        this.fechaResultado = fechaResultado;
    }

    public String getFechaResultado() {
        return fechaResultado;
    }
}
