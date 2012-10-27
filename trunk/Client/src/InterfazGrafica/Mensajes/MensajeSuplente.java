package InterfazGrafica.Mensajes;

import java.awt.Component;

import javax.swing.JOptionPane;


public class MensajeSuplente
{
 private int resultado;
 private ModificacionSuplente titular;
 
 public MensajeSuplente(Component comp, String nombre)
 {
  titular = new ModificacionSuplente(nombre);
  resultado = JOptionPane.showInternalConfirmDialog(comp, titular, "Futbolista", JOptionPane.YES_NO_OPTION);
 }
 
 public int eleccion()
 {
  int ele = 0;
  
  if ((resultado == 0) && (titular.seleccion() == 1)) ele = 1; // a Suplente
  if ((resultado == 0) && (titular.seleccion() == 2)) ele = 2; // se Elimina
  
  if (resultado == 1) ele = 0; // No se efectuan operaciones
  
  return ele;
 }
}
