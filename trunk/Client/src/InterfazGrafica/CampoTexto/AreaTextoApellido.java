package InterfazGrafica.CampoTexto;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AreaTextoApellido extends AreaTexto
{
 private String texto;
 private String teclasPermitidas = "[A-ZÁÉÍÓÚÑa-záéíóúñ\'\\s]*";
 private String esp = "\\s";
 private String ape = "([A-ZÁÉÍÓÚÑ][a-záéíóúñ]*|[A-ZÁÉÍÓÚÑ]\'[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*|[A-ZÁÉÍÓÚÑ]\'\\s[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*)";
 private String con = "([de|De]|[del|Del]|[de\\sla|De\\sla|De\\sLa]|[de\\slas|De\\slas|De\\sLas]|[de\\slos|De\\slos|De\\sLos])*";
 private String formato = ape+"|"+ape+esp+ape+"|"+ape+esp+con+esp+ape+"|"+con+esp+ape+"|"+con+esp+ape+esp+ape+"|"+con+esp+ape+esp+con+esp+ape;
 private String formatoFinal = "("+formato+")";
 
 public AreaTextoApellido(int longitudMaxima)
 {
  super(longitudMaxima);
  this.addKeyListener(new KeyAdapter() { public void keyReleased(KeyEvent evt) { caracteres(evt); } });
 }
 
 private void caracteres(KeyEvent evt)
 {
  int longitud;
  texto = this.getText();
  
  longitud = texto.length();
  if ((!texto.matches(teclasPermitidas)) && (longitud > 0)) this.setText(texto.substring(0, longitud-1));
 }
 
 public void ganado(FocusEvent evt)
 {
  this.setForeground(Color.black);
  this.setBackground(Color.white);
 }
 
 public void perdido(FocusEvent evt)
 {
  texto = this.getText();
  
  if ((!texto.matches(formatoFinal)) || (texto == "") || (texto.length() < 3))
  {
   this.setForeground(Color.white);
   this.setBackground(Color.red);
   buenDato = false;
  }
  else buenDato = true;
 }
}
