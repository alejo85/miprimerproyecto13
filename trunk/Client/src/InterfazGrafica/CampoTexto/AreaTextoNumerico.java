package InterfazGrafica.CampoTexto;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AreaTextoNumerico extends AreaTexto
{
 private int longitud;
 private String texto;
 private String expresion = "[0-9]{1}[0-9]*" ;
 private boolean estricto = true;
 
 public AreaTextoNumerico(int longitudMaxima)
 {
  super(longitudMaxima);
  this.addKeyListener(new KeyAdapter() { public void keyReleased(KeyEvent evt) { numeros(evt); } });
 }
 
 public void perdido(FocusEvent evt)
 {
     texto = this.getText();
       
       if ((texto.length() == 0) && (estricto)) this.setBackground(Color.orange);
       
       if (texto.matches(expresion)) buenDato = true;
       else buenDato = false;
 }
 
 private void numeros(KeyEvent evt)
 {
  texto = this.getText();
  
  longitud = texto.length();
  
  if ((!texto.matches(expresion)) && (longitud > 0)) this.setText(texto.substring(0, longitud-1));
 }
 
 public void setEstricto(boolean valor) { estricto = valor; }
 
 public int getNumero()
 {
  Integer numero = new Integer(0);
  
  longitud = this.getText().length();
  
  try { if (longitud != 0) numero = new Integer(this.getText()); }
  catch(Exception e) { }
  
  return (int)numero;
 }
}
