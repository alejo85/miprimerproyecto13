package InterfazGrafica.CampoTexto;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AreaTextoCorreo extends AreaTexto
{
 private String texto;
 private String teclasPermitidas = "[A-Za-z0-9.@_-]+";
 private String car = "[A-Za-z0-9]+";
 private String nombre = "("+car+"|"+car+"_"+car+"|"+car+"-"+car+"|"+car+"."+car+")+";
 private String tipo = "(com|net|edu|gov|org)";
 private String fin = "[a-z]{2}";
 private String don = "("+tipo+"|"+tipo+"."+fin+")";
 private String dominio = nombre+"."+don;
 
 private String formato = nombre+"@"+dominio;
 private String formatoFinal = "("+formato+")";
 
 public AreaTextoCorreo(int longitudMaxima)
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
  
  if ((!texto.matches(formatoFinal)) || (texto == ""))
  {
   this.setForeground(Color.white);
   this.setBackground(Color.red);
   buenDato = false;
  }
  else buenDato = true;
 }
 
}
