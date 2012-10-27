package InterfazGrafica.Mensajes;

import java.awt.Component;

import javax.swing.JOptionPane;


public class MensajeConfirmacion 
{
 private int resultado;
 
 public MensajeConfirmacion(Component comp, String texto)
 {
  resultado = JOptionPane.showInternalConfirmDialog(comp, texto, "Confirmaci�n", JOptionPane.YES_NO_OPTION);
 }
 
 public int resultado() { return resultado; }
}
