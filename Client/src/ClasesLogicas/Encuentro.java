package ClasesLogicas;

import java.util.Stack;

public class Encuentro {
    private Integer idEncuentro;
    private Integer Ronda;
    private Participante participanteA;
    private Participante participanteB;
    private Participante ganador;
    private Participante perdedor;
    private Boolean empate;
    private Stack <Resultados> resultado;
    private LugarDeRealización locación;


    public Encuentro() {
        super();
   
    }
/*
    public void setIdEncuentro(Integer idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public Integer getIdEncuentro() {
        return idEncuentro;
    }

    public void setRonda(Integer Ronda) {
        this.Ronda = Ronda;
    }

    public Integer getRonda() {
        return Ronda;
    }

    public void setParticipanteA(Participante participanteA) {
        this.participanteA = participanteA;
    }

    public Participante getParticipanteA() {
        return participanteA;
    }

    public void setParticipanteb(Participante participanteb) {
        this.participanteb = participanteb;
    }

    public Participante getParticipanteb() {
        return participanteb;
    }

    public void setGanador(Participante ganador) {
        this.ganador = ganador;
    }

    public Participante getGanador() {
        return ganador;
    }

    public void setEmpate(Boolean empate) {
        this.empate = empate;
    }

    public Boolean getEmpate() {
        return empate;
    }

    public void setResultado(Resultados resultado) {
        this.resultado = resultado;
    }

    public Resultados getResultado() {
        return resultado;
    }

    public ResultadosAnteriores getResultadosAnteriores(){
        return resultadosAnteriores;
    }

    public void setLocación(LugarDeRealización locación) {
        this.locación = locación;
    }

    public LugarDeRealización getLocación() {
        return locación;
    }
*/

    public Encuentro(Integer idEncuentro, Integer Ronda, Participante participanteA, Participante participanteb,
                     Participante ganador, Boolean empate, Stack<Resultados> resultado, LugarDeRealización locación) {
        super();
        this.idEncuentro = idEncuentro;
        this.Ronda = Ronda;
        this.participanteA = participanteA;
        this.participanteB = participanteb;
        this.ganador = ganador;
        this.empate = empate;
        this.resultado = resultado;
        this.locación = locación;
    }
}
