package ClasesInterfaz;


import ClasesLogicas.Competencia;
import ClasesLogicas.Encuentro;
import ClasesLogicas.ModeloTabla;
import ClasesLogicas.Ronda;
import ClasesLogicas.Subronda;
import ClasesLogicas.Usuario;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ModificarFixture extends JDialog {
    private ModeloTabla modeloDeTablaDeFecha = new ModeloTabla(new String[] { "Fecha/Ronda Nº", "Tipo de Ronda" , "Equipo A", "Equipo B", "Resultado" }, 0);
    private ModeloTabla modeloDeFecha = new ModeloTabla(new String[] { "Fecha/Ronda Nº" }, 0);
    private JPanel fechaJPanel = new JPanel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JScrollPane fechasJScrollPane = new JScrollPane();
    private JButton cancelarJButton = new JButton();
    private JLabel jLabelFechas = new JLabel();
    private JButton gestionarResultadoJButton = new JButton();
    private JButton anterioprJButton = new JButton();
    private JButton siguienteJButton = new JButton();
    private JTable tablaDeFechaJTable = new JTable();
    private Competencia competenciaSeleccionada=null;
    private Usuario usuarioAcatual=null;
    private VerCompetencia ventanaAnterior=null;
    private int nroRonda=0;
    private JTable fechaJTable = new JTable();


    /**
     * @param fixture
     * @param usuario
     */
    public ModificarFixture(Competencia unaCompetencia,Usuario usuario) {
        this(null, "", false, unaCompetencia, usuario);
    }

    public ModificarFixture(Frame parent, String title, boolean modal, Competencia unaCompetencia,Usuario usuario) {
        super(parent, title, modal);
        try {

            usuarioAcatual=usuario;
            competenciaSeleccionada=unaCompetencia;
            
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ModificarFixture() {
        this(null, "", false );
    }

    public ModificarFixture(Frame parent, String title, boolean modal  ) {
        super(parent, title, modal);
        try {
       
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void jbInit() throws Exception {
        CerrarVentana();
        tablaDeFechaJTable.setModel(modeloDeTablaDeFecha);
        fechaJTable.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    fechaJTable_focusGained(e);
                }
            });
        fechaJTable.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    fechaJTable_mouseClicked(e);
                }
            });
        fechaJTable.setModel(modeloDeFecha);
        this.setSize(new Dimension(1108, 544));
        this.getContentPane().setLayout( null );
        this.setTitle("Mostrar Fixture");
        fechaJPanel.setBounds(new Rectangle(35, 30, 870, 365));
        fechaJPanel.setLayout(null);
        fechaJPanel.setBorder(BorderFactory.createTitledBorder("Fecha/Ronda Nº "));
        jScrollPane1.setBounds(new Rectangle(20, 25, 820, 270));
        fechasJScrollPane.setBounds(new Rectangle(930, 55, 140, 270));
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(680, 440, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));

        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        jLabelFechas.setText("Fechas");
        jLabelFechas.setBounds(new Rectangle(930, 20, 175, 25));
        jLabelFechas.setFont(new Font("Tahoma", 0, 13));
        gestionarResultadoJButton.setText("Gestionar Resultados");
        gestionarResultadoJButton.setBounds(new Rectangle(50, 315, 170, 30));
        gestionarResultadoJButton.setFont(new Font("Tahoma", 0, 13));
        gestionarResultadoJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gestionarResultadoJButton_actionPerformed(e);
                }
            });
        gestionarResultadoJButton.setEnabled(false);
        cargarRondas(0);
        cargarFixture(competenciaSeleccionada.getFixture().getRondas());
        anterioprJButton.setText("Anterior");
        anterioprJButton.setBounds(new Rectangle(480, 320, 110, 30));
        anterioprJButton.setFont(new Font("Tahoma", 0, 13));
        anterioprJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    anterioprJButton_actionPerformed(e);
                }
            });
        siguienteJButton.setText("Siguiente");
        siguienteJButton.setBounds(new Rectangle(665, 320, 110, 30));
        siguienteJButton.setFont(new Font("Tahoma", 0, 13));
        siguienteJButton.setSize(new Dimension(110, 30));

        siguienteJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    siguienteJButton_actionPerformed(e);
                }
            });
        tablaDeFechaJTable.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    tablaDeFechaJTable_mouseClicked(e);
                }
            });
     
        jScrollPane1.getViewport().add(tablaDeFechaJTable, null);
        fechaJPanel.add(jScrollPane1, null);
        fechaJPanel.add(gestionarResultadoJButton, null);
        fechaJPanel.add(anterioprJButton, null);
        fechaJPanel.add(siguienteJButton, null);
        this.getContentPane().add(jLabelFechas, null);
        this.getContentPane().add(cancelarJButton, null);
        fechasJScrollPane.getViewport().add(fechaJTable, null);
        this.getContentPane().add(fechasJScrollPane, null);
        this.getContentPane().add(fechaJPanel, null);
    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        ventanaAnterior.setCompetencia(competenciaSeleccionada);
        ventanaAnterior.setVisible(true);
       
    }
    private Encuentro getEncuentro(int nroRonda, int encuentro){
           
            Ronda[] rondas=competenciaSeleccionada.getFixture().getRondas();
   
                        Subronda sub = rondas[nroRonda].getGanadores();
                       
           
                            return rondas[nroRonda].getGanadores().getEncuentros()[encuentro];
     
               
        }
    private void gestionarResultadoJButton_actionPerformed(ActionEvent e) {
        if(tablaDeFechaJTable.getSelectedRow()>-1)
        {
           
            if((getEncuentro(nroRonda, tablaDeFechaJTable.getSelectedRow())).getParticipanteA().getIdParticipante()!=1)
            {
                    if((getEncuentro(nroRonda, tablaDeFechaJTable.getSelectedRow())).getParticipanteB().getIdParticipante()!=1)
                    {
                    GestionarResultados ven = new GestionarResultados( competenciaSeleccionada, usuarioAcatual,getEncuentro(nroRonda, tablaDeFechaJTable.getSelectedRow()));
                    this.setVisible(false);
                    dispose();
                    ven.setVisible(true);
                    }
             
            }
         
        }
    }



    private void cargarRondas(int nroRonda){
           
            Ronda[] rondas=competenciaSeleccionada.getFixture().getRondas();
                modeloDeTablaDeFecha= new ModeloTabla(new String[] { "Fecha/Ronda Nº", "Tipo de Ronda" , "Equipo A", "Equipo B", "Resultado" }, 0);
   
                        Subronda sub = rondas[nroRonda].getGanadores();
                        Encuentro[] encuentrosDeSubRonda=sub.getEncuentros();
                       // System.out.println("Valor de I: "+i+" id de subrondas: "+sub.getIdSubronda()+"numero de ronda"+rondas[i].getNumeroDeRonda());
                     for(int j=0;j<encuentrosDeSubRonda.length;j++)
                       {
                         int aux=nroRonda+1;
                            Vector <String> datos = new Vector <String>();
                            datos.add(""+rondas[nroRonda].getNumeroDeRonda());
                                datos.add("Liga");
                            datos.add(rondas[nroRonda].getGanadores().getEncuentros()[j].getParticipanteA().getNombre());
                            datos.add(rondas[nroRonda].getGanadores().getEncuentros()[j].getParticipanteB().getNombre());
                                datos.add("");
                           
           
                            modeloDeTablaDeFecha.addRow(datos);
                            }
             
            tablaDeFechaJTable.setModel(modeloDeTablaDeFecha);
               
        }

    public void cargarFixture(Ronda [] rondas){
        modeloDeFecha =  new ModeloTabla(new String[] { "Fecha/Ronda Nº"}, 0);
        for(int i=0; i<rondas.length;i++ ){

                    Vector <String> datos = new Vector <String>();
                        datos.add(""+rondas[i].getNumeroDeRonda());
                    modeloDeFecha.addRow(datos);
               
            }
        fechaJTable.setModel(modeloDeFecha);
       
    }
    private void anterioprJButton_actionPerformed(ActionEvent e) {

        if(nroRonda>0){
                nroRonda--;
                cargarRondas(nroRonda);
            }
    }

    private void siguienteJButton_actionPerformed(ActionEvent e) {

        if(nroRonda>=0&& nroRonda < competenciaSeleccionada.getFixture().getRondas().length-1){
                nroRonda++;
                cargarRondas(nroRonda);

            }
    }
    private void CerrarVentana(){
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose();
        new VerCompetencia(usuarioAcatual, competenciaSeleccionada);
       
    }
    });
    }

    private void fechaJTable_focusGained(FocusEvent e) {

                cargarRondas(fechaJTable.getSelectedRow());

    }

    private void fechaJTable_mouseClicked(MouseEvent e) {
        nroRonda=fechaJTable.getSelectedRow();
        cargarRondas(fechaJTable.getSelectedRow());
    }

    private void tablaDeFechaJTable_mouseClicked(MouseEvent e) {
        int rondaAnterior=nroRonda-1;
        Ronda[] rondas=competenciaSeleccionada.getFixture().getRondas();
       
        if(rondaAnterior>-1){
                Subronda sub = rondas[rondaAnterior].getGanadores();
                if(sub.getEstado())
                {
                        if((getEncuentro(nroRonda, tablaDeFechaJTable.getSelectedRow())).getParticipanteA().getIdParticipante()!=1)
                        {
                            if((getEncuentro(nroRonda, tablaDeFechaJTable.getSelectedRow())).getParticipanteB().getIdParticipante()!=1)
                                gestionarResultadoJButton.setEnabled(true);
                            else
                                gestionarResultadoJButton.setEnabled(false);
                         
                        }
                }
                   
                else
                gestionarResultadoJButton.setEnabled(false);
            }
        else{
                gestionarResultadoJButton.setEnabled(true);
            }
     
           
           
         
    }
    public void setCompetencia(Competencia unaCompetencia) {

        competenciaSeleccionada=unaCompetencia;
        //TODO Actualizar datos
    }

 
}
