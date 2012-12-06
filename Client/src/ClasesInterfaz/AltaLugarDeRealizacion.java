package ClasesInterfaz;


import ClasesGestores.DeporteGestor;
import ClasesGestores.LugaresDeRealizacionGestores;

import ClasesLogicas.Deporte;
import ClasesLogicas.Usuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.SQLException;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class AltaLugarDeRealizacion extends JDialog {
    private JTextField codigoJTextArea = new JTextField();
    private JLabel jLabelCodigo = new JLabel();
    private DefaultListModel listModel = new DefaultListModel();
    private DefaultListModel listModel2 = new DefaultListModel();
    private JTextArea nombreLugarDeRealizaciónJTextArea = new JTextArea();
    private JLabel jLabelNombreLugarDeRealización = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea descripciónJTextArea = new JTextArea();
    private JLabel jLabelDescripción = new JLabel();
    private JList listaDeportesJList = new JList(listModel);
    private JList listaDeportesSeleccionadosJList = new JList(listModel2);
    private JButton cancelarJButton = new JButton();
    private JButton aceptarJButton = new JButton();
    private JButton quitarJButton = new JButton();
    private JButton agregarJButton = new JButton();
    private JLabel jLabelDeportesSeleccionados = new JLabel();
    private JLabel jLabelDeportes = new JLabel();
    private Usuario usuarioActual=null;
    private  Vector <Deporte> dDisponibles;
    private  Vector <Deporte> dSeleccionados=new Vector <Deporte>();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JScrollPane jScrollPane3 = new JScrollPane();
    private JPanel jPanel1 = new JPanel();


    public AltaLugarDeRealizacion(Usuario usuario) {
        this(null, "", false);
        usuarioActual=usuario;
    }

    public AltaLugarDeRealizacion(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
    	CerrarVentana();
        this.setSize(new Dimension(1243, 471));
        this.getContentPane().setLayout( null );
        this.setTitle("Alta Lugar De Realización");
        codigoJTextArea.setBounds(new Rectangle(235, 30, 210, 30));
        codigoJTextArea.setFont(new Font("Tahoma", 0, 13));
        codigoJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
  
        codigoJTextArea.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    codigoJTextArea_focusGained(e);
                }
            });
        jLabelCodigo.setText("Codigo");
        jLabelCodigo.setBounds(new Rectangle(50, 25, 175, 25));
        jLabelCodigo.setFont(new Font("Tahoma", 0, 13));
        nombreLugarDeRealizaciónJTextArea.setBounds(new Rectangle(235, 75, 210, 30));
        nombreLugarDeRealizaciónJTextArea.setFont(new Font("Tahoma", 0, 13));
        nombreLugarDeRealizaciónJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
 
        nombreLugarDeRealizaciónJTextArea.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    nombreLugarDeRealizaciónJTextArea_focusGained(e);
                }
            });
        jLabelNombreLugarDeRealización.setText("Nombre");
        jLabelNombreLugarDeRealización.setBounds(new Rectangle(45, 70, 120, 25));
        jLabelNombreLugarDeRealización.setFont(new Font("Tahoma", 0, 13));
        jScrollPane1.setBounds(new Rectangle(250, 145, 265, 150));
        jLabelDescripción.setText("Descripción");
        jLabelDescripción.setBounds(new Rectangle(50, 140, 115, 25));
        jLabelDescripción.setFont(new Font("Tahoma", 0, 13));
        listaDeportesJList.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    listaDeportesJList_focusGained(e);
                }
            });
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(685, 365, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        buscarDeportes();
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(495, 365, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        quitarJButton.setText("Quitar");
        quitarJButton.setBounds(new Rectangle(770, 190, 110, 30));
        quitarJButton.setFont(new Font("Tahoma", 0, 13));
        quitarJButton.setSize(new Dimension(110, 30));
        quitarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    quitarJButton_actionPerformed(e);
                }
            });
        agregarJButton.setText("Agregar");
        agregarJButton.setBounds(new Rectangle(770, 120, 110, 30));
        agregarJButton.setFont(new Font("Tahoma", 0, 13));
        agregarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    agregarJButton_actionPerformed(e);
                }
            });
        jLabelDeportesSeleccionados.setText("Deportes Seleccionados");
        jLabelDeportesSeleccionados.setBounds(new Rectangle(895, 10, 175, 25));
        jLabelDeportesSeleccionados.setFont(new Font("Tahoma", 0, 13));
        jLabelDeportes.setText("Deportes");
        jLabelDeportes.setBounds(new Rectangle(560, 15, 175, 25));
        jLabelDeportes.setFont(new Font("Tahoma", 0, 13));
        jScrollPane2.setBounds(new Rectangle(555, 45, 195, 275));
        jScrollPane3.setBounds(new Rectangle(895, 45, 195, 275));
        jScrollPane2.getViewport().add(listaDeportesJList, null);
        jScrollPane3.getViewport().add(listaDeportesSeleccionadosJList, null);
        this.getContentPane().add(jScrollPane3, null);
        this.getContentPane().add(jScrollPane2, null);
        this.getContentPane().add(jLabelDeportes, null);
        this.getContentPane().add(jLabelDeportesSeleccionados, null);
        this.getContentPane().add(agregarJButton, null);
        this.getContentPane().add(quitarJButton, null);
        this.getContentPane().add(aceptarJButton, null);
        this.getContentPane().add(cancelarJButton, null);
        this.getContentPane().add(jLabelDescripción, null);
        jScrollPane1.getViewport().add(descripciónJTextArea, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jLabelNombreLugarDeRealización, null);
        this.getContentPane().add(nombreLugarDeRealizaciónJTextArea, null);
        this.getContentPane().add(jLabelCodigo, null);
        this.getContentPane().add(codigoJTextArea, null);
    }

    private void CerrarVentana(){
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose(); // cuando se cierra, se pierde los cambios realizados
        new Principal(usuarioActual);
    }
    });
    }
    
    private void buscarDeportes(){
        dDisponibles = DeporteGestor.instanciarDeportes();
            cargarDeportes();
        }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.dispose();
        new Principal(usuarioActual);
    }
    private void cargarDeportes(){

        for(int i =0; i<dDisponibles.size();i++)
        {
            listModel.addElement(dDisponibles.get(i).getNombre());
                
            }
        
        }

    private void agregarJButton_actionPerformed(ActionEvent e) {
        int indices []=listaDeportesJList.getSelectedIndices();
            for(int i =0; i<indices.length;i++)
            {
                
                    listModel.removeAllElements();
                listModel2.removeAllElements();
                dSeleccionados.add(dDisponibles.get(indices[i]));
                    
                   
                }
        removerDeportes(indices);
        cargarDeportes();
        cargarDeportesSeleccionados();
    }

    private void quitarJButton_actionPerformed(ActionEvent e) {
        
        int indices []=listaDeportesSeleccionadosJList.getSelectedIndices();
            for(int i =0; i<indices.length;i++)
            {
                listModel.removeAllElements();
                listModel2.removeAllElements();
                dDisponibles.add(dSeleccionados.get(indices[i]));
                        
                    
                }
        removerSeleccionados(indices);
        cargarDeportes();
        cargarDeportesSeleccionados();
        
        
    }
    private void removerSeleccionados(int indices [])
    {
            for(int i =indices.length-1; i>-1;i--)
                dSeleccionados.remove(indices[i]);
    }
    private void removerDeportes(int indices []){
            for(int i =indices.length-1; i>-1;i--)
                dDisponibles.remove(indices[i]);
        }
    private void cargarDeportesSeleccionados(){

        if(dSeleccionados.size()>0){  for(int i =0; i<dSeleccionados.size();i++)
            {
                listModel2.addElement(dSeleccionados.get(i).getNombre());
                 
             }
        
        }}

    private void aceptarJButton_actionPerformed(ActionEvent e) {
        
        if(datosValidosRegistro()){

            try {
                LugaresDeRealizacionGestores.altaLugar(this.codigoJTextArea.getText(), this.nombreLugarDeRealizaciónJTextArea.getText(), this.descripciónJTextArea.getText(), dSeleccionados, usuarioActual );
            } catch (SQLException f) {
            	Toolkit.getDefaultToolkit().beep(); //TODO ver si va aca el sonido
                System.out.println(f.getMessage());
            }
        }
        
        
    }
    
    private Boolean datosValidosRegistro(){
        String errores="";
       
        if(this.codigoJTextArea.getText().equals("")){
            this.codigoJTextArea.setForeground(Color.white);
            this.codigoJTextArea.setBackground(Color.red);

            errores="\n\tEl codigo no puede ser vacio ";
        }
        if(this.nombreLugarDeRealizaciónJTextArea.getText().equals("")){
            this.nombreLugarDeRealizaciónJTextArea.setForeground(Color.white);
            this.nombreLugarDeRealizaciónJTextArea.setBackground(Color.red);
            errores=errores +"\n\tEl nombre del Lugar de realizacion no puede ser vacio ";
        }
        if(this.dSeleccionados.size()<1){
            errores= errores +"\n\tSe debe seleccionar al menos un deporte";
            listaDeportesSeleccionadosJList.setBackground(Color.red);
            listaDeportesSeleccionadosJList.setForeground(Color.white);
        }
      
       
        if(errores.length()>0){
            JOptionPane.showOptionDialog(null, "Tienes los siguientes errores: \n"+errores  , "Errores en campos", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
            return false;
        }
        else{
            return true;
        }

    }

  



    private void codigoJTextArea_focusGained(FocusEvent e) {
        this.codigoJTextArea.setForeground(Color.BLACK);
        this.codigoJTextArea.setBackground(Color.white);
    }

    private void nombreLugarDeRealizaciónJTextArea_focusGained(FocusEvent e) {
        this.nombreLugarDeRealizaciónJTextArea.setForeground(Color.BLACK);
        this.nombreLugarDeRealizaciónJTextArea.setBackground(Color.white);
    }

    private void listaDeportesJList_focusGained(FocusEvent e) {
        listaDeportesSeleccionadosJList.setBackground(Color.white);
        listaDeportesSeleccionadosJList.setForeground(Color.black);
    }
}
