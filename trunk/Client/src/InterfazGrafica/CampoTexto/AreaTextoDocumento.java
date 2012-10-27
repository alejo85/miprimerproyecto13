package InterfazGrafica.CampoTexto;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AreaTextoDocumento extends AreaTexto
{
 private int longitud;
 private String texto;
 private String expresion = "[1-9]{1}[0-9]*";
 
 public AreaTextoDocumento(int longitudMaxima)
 {
  super(longitudMaxima);
  this.addKeyListener(new KeyAdapter() { public void keyReleased(KeyEvent evt) { numeros(evt); } });
 }
 
 public void ganado(FocusEvent evt)
 {
  this.setForeground(Color.black);
  this.setBackground(Color.white);
 }
 
 public void perdido(FocusEvent evt)
 {
  Integer numero = new Integer(0);
  texto = this.getText();
  longitud = texto.length();
  
  if (longitud != 0) numero = new Integer(texto);
  
  if ((longitud == 0) || (longitud < 7) || (numero > 50000000))
  {
   this.setForeground(Color.white);
   this.setBackground(Color.orange);
   buenDato = false;
  }
  else buenDato = true;
 }
 
 private void numeros(KeyEvent evt)
 {
  texto = this.getText();
  longitud = texto.length();
  
  if ((!texto.matches(expresion)) && (longitud > 0)) this.setText(texto.substring(0, longitud-1));
 }
 
 public int getNumero()
 {
  Integer numero = new Integer(0);
  longitud = this.getText().length();
  
  try { if (longitud != 0) numero = new Integer(this.getText()); }
  catch(Exception e) { }
  
  return (int)numero;
 }
}
