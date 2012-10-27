package InterfazGrafica.Mensajes;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MensajeError
{
 public MensajeError(Component comp, String texto)
 {
  JOptionPane.showInternalMessageDialog(comp, texto, "Error", JOptionPane.ERROR_MESSAGE);
 }
}
