package ClasesInterfaz;

import ClasesLogicas.LugarDeRealizacion;

import ClasesLogicas.Usuario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class BuscarLugareDeRealizacion extends JDialog {
    
	private Border border;
	
	//creamos el panel de busqueda y sus componentes
	
	private JLabel jLabelCodigo= new JLabel();
	private JTextField codigoLugarDeRealizaciónJTextArea = new JTextField (20);
	private JLabel jLabelNombre= new JLabel();
	private JTextField nombreLugarDeRealizaciónJTextArea = new JTextField (20);
	private JLabel jLabelDeporte = new JLabel();
	private JComboBox deporteJComboBox = new JComboBox();
	private JButton buscarJButton = new JButton();
	
	//creamos el panel de resultado y sus componentes
    
    private JTable tablaResultadosJTable = new JTable();
    private JScrollPane jScrollPaneResultado = new JScrollPane();
    //private JScrollBar jScrollBar1 = new JScrollBar();
    private JButton nuevoLugarDeRealizaciónJButton = new JButton();
    private JButton modificarLugarDeRealizaciónJButton = new JButton();
    private JButton eliminarLugarDeRealizaciónJButton = new JButton();
    
    //creamos el panel de control aceptar/cancelar
    
    private JButton aceptarJButton = new JButton(); 
    private JButton cancelarJButton = new JButton();
    
    //otros
   
    private Vector <LugarDeRealizacion> lugar=null;
    private Usuario usuarioActual=null;
    /**
     * @wbp.parser.constructor
     */
    public BuscarLugareDeRealizacion(Usuario usuario) {
    	
        this(null, "", false);
        usuarioActual=usuario;
    }

    public BuscarLugareDeRealizacion(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
    	
    	//EMPIEZO DE CERO
    	
    	// seteamos el layout
    	setLayout (new BorderLayout());
    	setTitle("Buscar Lugares De Realización");
    		
    	// Éste será el tipo de borde que utilizamos en todos los paneles
    	border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    			
    	// creamos el panel norte
    	JPanel pNorth = _crearPNorte();
    	add (pNorth, BorderLayout.NORTH);

    	// creamos el panel central
    	JPanel pCenter = _crearPCenter();
    	add (pCenter, BorderLayout.CENTER);

    	// creamos el panel sur
    	JPanel pSouth = _crearPSur();
    	add (pSouth, BorderLayout.SOUTH);
    			
    	this.pack();
    	setResizable(true);
    	setVisible(true);
    }
    
    private JPanel _crearPNorte(){
    	
    	JPanel busquedaJPanel = new JPanel(new BorderLayout());
    	//busquedaJPanel.setBounds(new Rectangle(190, 50, 690, 195));
    	//busquedadaJPanel.setBorder(BorderFactory.createTitledBorder(""));
    	TitledBorder titleborder = BorderFactory.createTitledBorder(border, "Buscar por");
    	busquedaJPanel.setBorder(titleborder);

    	JPanel subpanel1 = new JPanel (new FlowLayout(FlowLayout.CENTER));
		JPanel subpanel2 = new JPanel (new FlowLayout(FlowLayout.CENTER));
		JPanel subpanel3 = new JPanel (new FlowLayout(FlowLayout.CENTER));
    	
    	jLabelCodigo.setText("Codigo: ");
    	//jLabelCodigo.setBounds(new Rectangle(35, 25, 135, 25));
        jLabelCodigo.setFont(new Font("Tahoma", 0, 13));
        
    	//codigoLugarDeRealizaciónJTextArea.setBounds(new Rectangle(175, 25, 250, 30));
        codigoLugarDeRealizaciónJTextArea.setFont(new Font("Tahoma", 0, 13));
        //codigoLugarDeRealizaciónJTextArea.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    	
      //jLabelNombre.setBounds(new Rectangle(35, 65, 135, 25));
        jLabelNombre.setText("    Nombre Del Lugar:");
        jLabelNombre.setFont(new Font("Tahoma", 0, 13));
        
        nombreLugarDeRealizaciónJTextArea.setFont(new Font("Tahoma", 0, 13));
        
        buscarJButton.setText("Buscar");
        buscarJButton.setFont(new Font("Tahoma", 0, 13));
        buscarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buscarJButton_actionPerformed(e);
                }
            });
        
        jLabelDeporte.setText("Deporte: ");
        jLabelDeporte.setFont(new Font("Tahoma", 0, 13));
      
        deporteJComboBox.setMaximumSize(new Dimension(2147483647, 2147483647));
        deporteJComboBox.setMinimumSize(new Dimension(2, 20));
        deporteJComboBox.setPreferredSize(new Dimension(225,30));
        
        
       
        subpanel1.add(jLabelCodigo);
		subpanel1.add(codigoLugarDeRealizaciónJTextArea);
        subpanel2.add(jLabelNombre);
		subpanel2.add(nombreLugarDeRealizaciónJTextArea);
		subpanel2.add(buscarJButton);
		subpanel3.add(jLabelDeporte);
		subpanel3.add(deporteJComboBox);
		
		busquedaJPanel.add(subpanel1, BorderLayout.NORTH);
		busquedaJPanel.add(subpanel2, BorderLayout.CENTER);
		busquedaJPanel.add(subpanel3, BorderLayout.SOUTH);
        
    	return busquedaJPanel;
    }
     
    private JPanel _crearPCenter(){
    	JPanel resultadoJPanel = new JPanel(new BorderLayout());
    	TitledBorder titleborder = BorderFactory.createTitledBorder(border, "Resultados");
    	resultadoJPanel.setBorder(titleborder);
    	JPanel subpanel1 = new JPanel (new FlowLayout(FlowLayout.CENTER));
		JPanel subpanel2 = new JPanel (new FlowLayout(FlowLayout.CENTER));
		
		//VER SI USAMOS JTABLE O JLIST, VER MODELLIST ETC
		//jScrollPaneResultado.setBounds(new Rectangle(20, 25, 860, 23));
	    // jScrollBar1.setBounds(new Rectangle(870, 25, 15, 230));
		jScrollPaneResultado.setViewportView(tablaResultadosJTable);
		  
		nuevoLugarDeRealizaciónJButton.setText("Nuevo Lugar De Realización");
	    nuevoLugarDeRealizaciónJButton.setFont(new Font("Tahoma", 0, 13));
	    nuevoLugarDeRealizaciónJButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	                    nuevoLugarDeRealizaciónJButton_actionPerformed(e);
	                }
	            });
	        
	    modificarLugarDeRealizaciónJButton.setText("Modificar Lugar De Realización");
	    modificarLugarDeRealizaciónJButton.setFont(new Font("Tahoma", 0, 13));
	    modificarLugarDeRealizaciónJButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  modificarLugarDeRealizaciónJButton_actionPerformed(e);
	                }
	      });
	    
	    eliminarLugarDeRealizaciónJButton.setText("Eliminar  Lugar De Realización");
	    eliminarLugarDeRealizaciónJButton.setFont(new Font("Tahoma", 0, 13));
	    eliminarLugarDeRealizaciónJButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	             eliminarLugarDeRealizaciónJButton_actionPerformed(e);
	             }
	      });
        
		subpanel1.add(jScrollPaneResultado);
		subpanel2.add(nuevoLugarDeRealizaciónJButton);
		subpanel2.add(modificarLugarDeRealizaciónJButton);
		subpanel2.add(eliminarLugarDeRealizaciónJButton);
		
		// resultadoJPanel.add(jScrollBar1, null);
        resultadoJPanel.add(subpanel1, BorderLayout.CENTER);
        resultadoJPanel.add(subpanel2, BorderLayout.SOUTH);
        
        
    	return resultadoJPanel;
    }
    
    private JPanel _crearPSur(){  
   
    	JPanel aceptarCancelarJPanel = new JPanel(new BorderLayout());
    	//TitledBorder titleborder = BorderFactory.createTitledBorder(border);
		//aceptarCancelarJPanel.setBorder(titleborder);
    	aceptarCancelarJPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	aceptarJButton.setText("Aceptar");
        aceptarJButton.setFont(new Font("Tahoma", 0, 13));
 
        cancelarJButton.setText("Cancelar");
        cancelarJButton.setFont(new Font("Tahoma", 0, 13));
        cancelarJButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelarJButton_actionPerformed(e);
                }
            });
        aceptarCancelarJPanel.add(aceptarJButton);
        aceptarCancelarJPanel.add(cancelarJButton);
        
       return aceptarCancelarJPanel;
    }

    
    private void nuevoLugarDeRealizaciónJButton_actionPerformed(ActionEvent e) {
        AltaLugarDeRealizacion ven = new AltaLugarDeRealizacion(usuarioActual);
        ven.setVisible(true);
    }

    private void modificarLugarDeRealizaciónJButton_actionPerformed(ActionEvent e) {
        JOptionPane.showOptionDialog(null, "Por el momento esta funcionalidad no esta disponible"  , "Funcionalidad no disponible", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
    }

    private void eliminarLugarDeRealizaciónJButton_actionPerformed(ActionEvent e) {
    	//int x= getLocationOnScreen().x;
    	//int y= getLocationOnScreen().y;
  
        JOptionPane.showOptionDialog(cancelarJButton , "Por el momento esta funcionalidad no esta disponible"  , "Funcionalidad no disponible", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");

    }

    private void cancelarJButton_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        dispose();
    }

    private void buscarJButton_actionPerformed(ActionEvent e) {
        JOptionPane.showOptionDialog(null, "Por el momento esta funcionalidad no esta disponible"  , "Funcionalidad no disponible", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aceptar"},"Aceptar");
    }
}
