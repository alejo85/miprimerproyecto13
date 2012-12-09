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
import javax.swing.ImageIcon;
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
    private JLabel jLabelCodigo = new JLabel();
    private JTextField codigoJTextField = new JTextField();
    private DefaultListModel listModel = new DefaultListModel();
    private DefaultListModel listModel2 = new DefaultListModel();
    private JTextField nombreLugarDeRealizacionJTextField = new JTextField();
    private JLabel jLabelNombreLugarDeRealización = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea descripcionJTextArea = new JTextArea();
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
        
        // PARA QUE LA VENTANA NO SE PEUDA REDIMENSIONAR
        setResizable(false);
        // CAPTURA EVENTO DE "X" PARA ABRIR VENTANA ANTERIOR
    	CerrarVentana();
        
        // TITULO VENTANA
        this.setTitle("Alta Lugar De Realización");
        
        
        this.setSize(new Dimension(1005, 440));
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout( null );
        
        jLabelCodigo.setText("Codigo");
        jLabelCodigo.setBounds(new Rectangle(20, 25, 175, 25));
        jLabelCodigo.setFont(new Font("Tahoma", 0, 13));
        
        codigoJTextField.setBounds(new Rectangle(110, 25, 230, 30));
        codigoJTextField.setFont(new Font("Tahoma", 0, 13));
        codigoJTextField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        codigoJTextField.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    codigoJTextArea_focusGained(e);
                }
            });
        codigoJTextField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        //LIMITAR ENTRADA CODIGO A 6 CARACTERES
        codigoJTextField.setDocument(new LimitadorCaracteres(codigoJTextField,6));
        
        
        jLabelNombreLugarDeRealización.setText("Nombre");
        jLabelNombreLugarDeRealización.setBounds(new Rectangle(20, 70, 120, 25));
        jLabelNombreLugarDeRealización.setFont(new Font("Tahoma", 0, 13));
        
        
        nombreLugarDeRealizacionJTextField.setBounds(new Rectangle(110, 75, 230, 30));
        nombreLugarDeRealizacionJTextField.setFont(new Font("Tahoma", 0, 13));
        nombreLugarDeRealizacionJTextField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nombreLugarDeRealizacionJTextField.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    nombreLugarDeRealizaciónJTextArea_focusGained(e);
                }
            });
        nombreLugarDeRealizacionJTextField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        //LIMITAR ENTRADA NOMBRE A 60 CARACTERES
        nombreLugarDeRealizacionJTextField.setDocument(new LimitadorCaracteres(nombreLugarDeRealizacionJTextField,60));
        
        
        jLabelDescripción.setText("Descripción");
        jLabelDescripción.setBounds(new Rectangle(20, 120, 115, 25));
        jLabelDescripción.setFont(new Font("Tahoma", 0, 13));

        
        jScrollPane1.setBounds(new Rectangle(110, 120, 230, 250));
        // LIMITAR ENTRADA DESCRIPCION A 1000 CARACTERES
        nombreLugarDeRealizacionJTextField.setDocument(new LimitadorCaracteres(nombreLugarDeRealizacionJTextField,60));
        
        // BOTON AGREGAR
        agregarJButton.setText("Agregar");
        agregarJButton.setBounds(new Rectangle(660, 130, 110, 30));
        agregarJButton.setFont(new Font("Tahoma", 0, 13));
        agregarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    agregarJButton_actionPerformed(e);
                }
            });
        
        //BOTON QUITAR
        quitarJButton.setText("Quitar");
        quitarJButton.setBounds(new Rectangle(660, 200, 110, 30));
        quitarJButton.setFont(new Font("Tahoma", 0, 13));
        quitarJButton.setSize(new Dimension(110, 30));
        quitarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    quitarJButton_actionPerformed(e);
                }
            });
        
        //BOTON ACEPTAR
        aceptarJButton.setText("Aceptar");
        aceptarJButton.setBounds(new Rectangle(635, 365, 110, 30));
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
        aceptarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptarJButton_actionPerformed(e);
                }
            });
        
        //BOTON CANCELAR
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setBounds(new Rectangle(835, 365, 110, 30));
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.setSize(new Dimension(110, 30));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        
        // CARGAR DEPORTES
        buscarDeportes();
        
        jLabelDeportes.setText("Deportes");
        jLabelDeportes.setBounds(new Rectangle(515, 15, 175, 25));
        jLabelDeportes.setFont(new Font("Tahoma", 0, 13));
        
        
        jLabelDeportesSeleccionados.setText("Deportes Seleccionados");
        jLabelDeportesSeleccionados.setBounds(new Rectangle(810, 15, 175, 25));
        jLabelDeportesSeleccionados.setFont(new Font("Tahoma", 0, 13));
        
        listaDeportesJList.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    listaDeportesJList_focusGained(e);
                }
            });
        
        jScrollPane2.setBounds(new Rectangle(450, 45, 195, 275));
        jScrollPane3.setBounds(new Rectangle(785, 45, 195, 275));
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
        jScrollPane1.getViewport().add(descripcionJTextArea, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jLabelNombreLugarDeRealización, null);
        this.getContentPane().add(nombreLugarDeRealizacionJTextField, null);
        this.getContentPane().add(jLabelCodigo, null);
        this.getContentPane().add(codigoJTextField, null);
    }

    // METODO CAPTURAR VENTANA
    private void CerrarVentana(){
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose(); // cuando se cierra, se pierde los cambios realizados
        new Principal(usuarioActual);
    }
    });
    }
    
    
    //BUSCAR DEPORTES
    private void buscarDeportes(){
        dDisponibles = DeporteGestor.instanciarDeportes();
            cargarDeportes();
        }



//BOTON AGREGAR
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


// BOTON QUITAR
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

// BOTON ACEPTAR
    private void aceptarJButton_actionPerformed(ActionEvent e) {
        
        if(datosValidosRegistro()){

            try {
                LugaresDeRealizacionGestores.altaLugar(this.codigoJTextField.getText(), this.nombreLugarDeRealizacionJTextField.getText(), this.descripcionJTextArea.getText(), dSeleccionados, usuarioActual );
            } catch (SQLException f) {
            	Toolkit.getDefaultToolkit().beep(); //TODO ver si va aca el sonido
                System.out.println(f.getMessage());
            }
            dispose();
            JOptionPane.showMessageDialog(null, "<html><h4>El lugar de realización ha sido creado con éxito</h4></html>", "Alta lugar de realización",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/exito.png"));
            new Principal(usuarioActual);
        }
        
        
    }
    // BOTON CANCELAR
    private void cancelarJButton_actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose(); // cuando se cierra, se pierde los cambios realizados
        new Principal(usuarioActual);
    }
    private void cargarDeportes(){

        for(int i =0; i<dDisponibles.size();i++)
        {
            listModel.addElement(dDisponibles.get(i).getNombre());
                
            }
        
        }

// VALIDACION DE DATOS    
    private Boolean datosValidosRegistro(){
        String errores="";
       
        if(this.codigoJTextField.getText().equals("")){
            this.codigoJTextField.setForeground(Color.white);
            this.codigoJTextField.setBackground(Color.red);

            errores="<li>El codigo no puede ser vacio</li>";
        }
        if(this.nombreLugarDeRealizacionJTextField.getText().equals("")){
            this.nombreLugarDeRealizacionJTextField.setForeground(Color.white);
            this.nombreLugarDeRealizacionJTextField.setBackground(Color.red);
            errores=errores +"<li>El nombre del Lugar de realizacion no puede ser vacio</li>";
        }
        if(this.dSeleccionados.size()<1){
            errores= errores +"<li>Se debe seleccionar al menos un deporte</li>";
            listaDeportesSeleccionadosJList.setBackground(Color.red);
            listaDeportesSeleccionadosJList.setForeground(Color.white);
        }
      
       
        if(errores.length()>0){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane pane = new JOptionPane("<html><h3>Tienes los siguientes errores:</h3><ul>"+errores+"</ul></html>", JOptionPane.ERROR_MESSAGE);  
            pane.setIcon(new ImageIcon("src/Imagenes/error.png"));
            JDialog dialog = pane.createDialog("Error al Autencicar");
            int anchoPantalla = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(); // ancho de la pantalla
            int posicion= this.getLocationOnScreen().x;
            int anchoVentana= this.getHeight();
            
            if ((anchoPantalla-(posicion+anchoVentana) > posicion))
            {
                    dialog.setLocation(getLocationOnScreen().x + getHeight()+90 , getLocationOnScreen().y);
            }
            else
            {
                    dialog.setLocation(getLocationOnScreen().x - 450, getLocationOnScreen().y);
            }
            dialog.setVisible(true);
            return false;
        }
        else{
            return true;
        }

    }

    private void codigoJTextArea_focusGained(FocusEvent e) {
        this.codigoJTextField.setForeground(Color.BLACK);
        this.codigoJTextField.setBackground(Color.white);
    }

    private void nombreLugarDeRealizaciónJTextArea_focusGained(FocusEvent e) {
        this.nombreLugarDeRealizacionJTextField.setForeground(Color.BLACK);
        this.nombreLugarDeRealizacionJTextField.setBackground(Color.white);
    }

    private void listaDeportesJList_focusGained(FocusEvent e) {
        listaDeportesSeleccionadosJList.setBackground(Color.white);
        listaDeportesSeleccionadosJList.setForeground(Color.black);
    }
}
