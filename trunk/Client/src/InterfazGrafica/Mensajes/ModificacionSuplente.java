package InterfazGrafica.Mensajes;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;


public class ModificacionSuplente extends JPanel
{
 private String nombre;
 private JLabel nombreJugador = new JLabel();
 private JSeparator separador = new JSeparator();
 private JRadioButton titular = new JRadioButton();
 private JRadioButton eliminar = new JRadioButton();
 private ButtonGroup opciones = new ButtonGroup();
 
 public ModificacionSuplente(String nombreFutbolista)
 {
  nombre = nombreFutbolista;
  try { jbInit(); }
  catch (Exception e) { e.printStackTrace(); }
 }
 
 private void jbInit() throws Exception
 {
  this.setLayout( null );
  this.setSize(new Dimension(295, 80));
  this.setPreferredSize(new Dimension(295, 80));
  
  nombreJugador.setText(nombre);
  nombreJugador.setBounds(new Rectangle(10, 10, 275, 20));
  nombreJugador.setFont(new Font("SansSerif", 1, 14));
  separador.setBounds(new Rectangle(5, 35, 280, 2));
  titular.setText("Titular");
  titular.setBounds(new Rectangle(30, 50, 86, 18));
  titular.setFont(new Font("SansSerif", 1, 12));
  titular.setSelected(true);
  eliminar.setText("Eliminar del Equipo");
  eliminar.setBounds(new Rectangle(130, 49, 130, 20));
  eliminar.setFont(new Font("SansSerif", 1, 12));
  
  opciones.add(titular);
  opciones.add(eliminar);
  
  this.add(eliminar, null);
  this.add(titular, null);
  this.add(separador, null);
  this.add(nombreJugador, null);
 }
     
 public int seleccion()
 {
  int selec = 0;
  
  if (titular.isSelected()) selec = 1;
  if (eliminar.isSelected()) selec = 2;
  
  return selec;
 }
}
