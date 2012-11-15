package InterfazGrafica.CampoTexto;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;


public abstract class AreaTexto extends JTextField 
{
 private int longitud;          // Longitud de las cadenas de texto a ser ingresadas.
 protected boolean buenDato;    // Determinara si el dato es bueno para ser procesado.
 
 public AreaTexto(int longitudMaxima)
 {
  longitud = longitudMaxima;
  this.setColumns(longitud);
  this.addKeyListener(new KeyAdapter() { public void keyPressed(KeyEvent evt) { tecleado(evt); } });
  this.addFocusListener(new FocusAdapter() { public void focusGained(FocusEvent evt) { ganado(evt); } });
  this.addFocusListener(new FocusAdapter() { public void focusLost(FocusEvent evt) { perdido(evt); } });
 }
 
 public void ganado(FocusEvent evt) { this.setBackground(Color.white); }
 public void perdido(FocusEvent evt) {}
 public boolean esCorrecto() { return buenDato; }
 
 private void tecleado(KeyEvent evt)
 {
  String texto = this.getText();
  
  if (texto.length() >= (longitud)) this.setEditable(false);
  
  if ((evt.getKeyCode() == 8) && (texto.length() == (longitud)))
  {
   texto = texto.substring(0, longitud);
   this.setText(texto);
   this.setEditable(true);
  }
 }
    public void error(){
            this.setForeground(Color.white);
            this.setBackground(Color.red);
        }
 public String getTexto() { return this.getText(); }
}

