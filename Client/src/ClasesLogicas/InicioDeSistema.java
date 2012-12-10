package ClasesLogicas;


import ClasesBD.Conexion;



import ClasesInterfaz.AltaCompetenciaDeportiva;
import ClasesInterfaz.Principal;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class InicioDeSistema {
   
    public InicioDeSistema() {
        super();
    }

    public static  void main(String[] args) {


        try {
            Conexion.conectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "<html><center><h4>Error al tratar de conectarse con la bd</h4><h5>Verifique su conexión a la red y vuelva a internarlo</h5></center></html>", "Error de conexión",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/bd-error.png"));
             System.exit(0);
        }
        Principal ventana = new Principal();
        
       // Conexion.cerrarConexion();

        /*Alta ven1 = new Alta();
        AltaLugarDeRealizacion ven2 = new AltaLugarDeRealizacion();
        AltaParticipante ven3 = new AltaParticipante();
        BuscarCompetenciaDeportiva ven4 = new BuscarCompetenciaDeportiva();
        BuscarLugareDeRealizacion ven5 = new BuscarLugareDeRealizacion();
        BuscarTodasLasCompetenciaDeportiva ven6 = new BuscarTodasLasCompetenciaDeportiva();
        ModificarLaCompetencia ven7 = new ModificarLaCompetencia();
        GestionarResultados ven8 = new GestionarResultados();
        IniciarSesion ven9 = new IniciarSesion();
        ListarParticipantes ven10 = new ListarParticipantes();
        ModificarFixture ven11 = new ModificarFixture();
        ModificarLugarDeRealizacion ven12 = new ModificarLugarDeRealizacion();
        ModificarParticipante ven13 = new ModificarParticipante();
        ModificarUsuario ven14 = new ModificarUsuario();
        RegistrarUsuario ven15 = new RegistrarUsuario();
        TablaDePosiciones ven16 = new TablaDePosiciones();
        VerCompetencia ven17 = new VerCompetencia();






     /* ven1.setVisible(true);
        ven2.setVisible(true);
        ven3.setVisible(true);
        ven4.setVisible(true);
        ven5.setVisible(true);
        ven6.setVisible(true);
        ven7.setVisible(true);
        ven8.setVisible(true);
        ven9.setVisible(true);
        ven10.setVisible(true);
        ven11.setVisible(true);
        ven12.setVisible(true);
        ven13.setVisible(true);
        ven14.setVisible(true);
        ven15.setVisible(true);
        ven16.setVisible(true);
        ven17.setVisible(true);
*/
    }
}
