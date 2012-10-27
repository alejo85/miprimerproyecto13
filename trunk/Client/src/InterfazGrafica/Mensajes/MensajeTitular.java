package InterfazGrafica.Mensajes;

import java.awt.Component;

import javax.swing.JOptionPane;


public class MensajeTitular
{
 private int resultado;
 private ModificacionTitular titular;
 
 public MensajeTitular(Component comp, String nombre)
 {
  titular = new ModificacionTitular(nombre);
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
