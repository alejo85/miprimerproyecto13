package ClasesLogicas;

import java.util.Stack;

public class Encuentro {
    private Integer idEncuentro;
    private Participante participanteA;
    private Participante participanteB;
    private Participante ganador;
    private Participante perdedor;
    private Boolean empate;
    private Stack <Resultados> resultado;
    private LugarDeRealizacion locación;


    public Encuentro() {
        super();
    }

    public Encuentro(Integer idEncuentro,Participante participanteA, Participante participanteB,
                     Participante ganador, Participante perdedor, Boolean empate, Stack<Resultados> resultado,
                     LugarDeRealizacion locación) {
        super();
        this.idEncuentro = idEncuentro;
        this.participanteA = participanteA;
        this.participanteB = participanteB;
        this.ganador = ganador;
        this.perdedor = perdedor;
        this.empate = empate;
        this.resultado = resultado;
        this.locación = locación;
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
        this.resultado.add(resultado);
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
        this.resultado=new Stack <Resultados>();
            this.resultado.add(resultado);
        }
}
