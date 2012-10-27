package InterfazGrafica.CampoTexto;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AreaTextoAlfabetico extends AreaTexto
{
 private int longitud;
 private String texto;
 private String expresion = "[A-ZÑ]";
 
 public AreaTextoAlfabetico(int longitudMaxima)
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
     texto = this.getText();
       longitud = texto.length();
       
       if (longitud == 0) buenDato = true;
       else
       {
        if (!texto.matches(expresion))
        {
         this.setForeground(Color.white);
         this.setBackground(Color.orange);
         buenDato = false;
        }
        else buenDato = true;
       }
 }
 
 private void numeros(KeyEvent evt)
 {
  texto = this.getText();
  longitud = texto.length();
  
  if ((!texto.matches(expresion)) && (longitud > 0)) this.setText(texto.substring(0, longitud-1));
 }
}
