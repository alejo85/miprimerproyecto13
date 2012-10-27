package InterfazGrafica.CampoTexto;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AreaTextoCalle extends AreaTexto
{
 private String texto;
 private String teclasPermitidas = "[A-ZÁÉÍÓÚÑa-záéíóúñ0-9.\'\\s]*";
 private String esp = "\\s";
 private String nro = "([1-9]|[1-9][0-9])";
 private String tipo = "(Av.|Bv.|Pje.)";
 private String nom = "[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*";
 private String ape = "([A-ZÁÉÍÓÚÑ][a-záéíóúñ]*|[A-ZÁÉÍÓÚÑ]\'[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*|[A-ZÁÉÍÓÚÑ]\'\\s[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*)";
 private String con = "([de|De]|[del|Del]|[de\\sla|De\\sla|De\\sLa]|[de\\slas|De\\slas|De\\sLas]|[de\\slos|De\\slos|De\\sLos])*";
 private String nombre = "("+nom+"|"+nom+esp+nom+"|"+nom+esp+nom+esp+nom+"|"+nom+esp+nom+esp+nom+esp+nom+")";
 private String apellido = ape+"|"+ape+esp+ape+"|"+ape+esp+con+esp+ape+"|"+con+esp+ape+"|"+con+esp+ape+esp+ape+"|"+con+esp+ape+esp+con+esp+ape;
 private String calle = apellido+"|"+nombre+esp+apellido+"|"+nombre+esp+con+esp+apellido;
 
 private String formato = nro+esp+con+esp+apellido+"|"+calle+"|"+tipo+esp+nro+esp+con+esp+apellido+"|"+tipo+esp+calle+"|"+tipo+esp+con+esp+apellido;
 private String formatoFinal = "("+formato+")";
 
 public AreaTextoCalle(int longitudMaxima)
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
  
  if (texto.length() == 0) buenDato = true;
  else
  {
   if ((!texto.matches(formatoFinal)) || (texto.length() < 4))
   {
    this.setForeground(Color.white);
    this.setBackground(Color.orange);
    buenDato = false;
   }
   else buenDato = true;
  }
 }
}
