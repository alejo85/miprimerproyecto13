package InterfazGrafica.Mensajes;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MensajeInformacion 
{
 public MensajeInformacion(Component comp, String texto)
 {
  JOptionPane.showInternalMessageDialog(comp, texto, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
 }
}
