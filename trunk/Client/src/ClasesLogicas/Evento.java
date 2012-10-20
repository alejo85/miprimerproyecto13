package ClasesLogicas;

public class Evento {
    private int idTabla;
    private Encuentro enfrentamintoA;
    private Encuentro enfrentamintoB;
    private Encuentro proximoEnfrentaminto;
    public Evento() {
        super();
    }

    public Evento(int idTabla, Encuentro enfrentamintoA, Encuentro enfrentamintoB, Encuentro proximoEnfrentaminto) {
        super();
        this.idTabla = idTabla;
        this.enfrentamintoA = enfrentamintoA;
        this.enfrentamintoB = enfrentamintoB;
        this.proximoEnfrentaminto = proximoEnfrentaminto;
    }

/*
    public void setIdTabla(int idTabla) {
        this.idTabla = idTabla;
    }

    public int getIdTabla() {
        return idTabla;
    }

    public void setEnfrentamintoA(Encuentro enfrentamintoA) {
        this.enfrentamintoA = enfrentamintoA;
    }

    public Encuentro getEnfrentamintoA() {
        return enfrentamintoA;
    }

    public void setEnfrentamintoB(Encuentro enfrentamintoB) {
        this.enfrentamintoB = enfrentamintoB;
    }

    public Encuentro getEnfrentamintoB() {
        return enfrentamintoB;
    }

    public void setProximoEnfrentaminto(Encuentro proximoEnfrentaminto) {
        this.proximoEnfrentaminto = proximoEnfrentaminto;
    }

    public Encuentro getProximoEnfrentaminto() {
        return proximoEnfrentaminto;
    }
*/
}
