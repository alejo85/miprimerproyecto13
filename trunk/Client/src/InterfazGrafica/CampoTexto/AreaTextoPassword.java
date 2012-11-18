package InterfazGrafica.CampoTexto;

import InterfazGrafica.Mensajes.MensajeError;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;


public class AreaTextoPassword extends JPasswordField
{
 private String texto;                  // Cadena que contendra la password.
 private int longitud;                  // Longitud de las cadenas de texto a ser ingresadas.
 private boolean buenDato = false;      // Determinara si el dato es bueno para ser procesado.
 
 private String expresion = "[A-ZÑa-zñ0-9]+";
 
 public AreaTextoPassword(int longitudMaxima)
 {
  longitud = longitudMaxima;
  this.setColumns(longitud);
  this.addKeyListener(new KeyAdapter() { public void keyPressed(KeyEvent evt) { tecleado(evt); } });
  this.addKeyListener(new KeyAdapter() { public void keyReleased(KeyEvent evt) { caracteres(evt); } });
  this.addFocusListener(new FocusAdapter() { public void focusGained(FocusEvent evt) { ganado(evt); } });
  this.addFocusListener(new FocusAdapter() { public void focusLost(FocusEvent evt) { perdido(evt); } });
 }
 
 public void ganado(FocusEvent evt) 
 {
  this.setForeground(Color.black);
  this.setBackground(Color.white);
 }
 
 public void perdido(FocusEvent evt) 
 {
  int lon;
  texto = this.getText();
  lon = texto.length();
  
  if ((!texto.matches(expresion)) || (texto == "") || (lon < 6))
  {
   this.setForeground(Color.white);
   this.setBackground(Color.red);
   buenDato = false;
  }
  else buenDato = true;
 }
 
 public boolean esCorrecto() { return buenDato; }
 
 private void caracteres(KeyEvent evt)
 {
  int lon;
  texto = this.getText();
  
  lon = texto.length();
  if ((!texto.matches(expresion)) && (lon > 0)) this.setText(texto.substring(0, lon-1));
 }
 
 private void tecleado(KeyEvent evt)
 {
  texto = this.getText();
  
  if (texto.length() >= (longitud)) this.setEditable(false);
  
  if ((evt.getKeyCode() == 8) && (texto.length() == (longitud)))
  {
   texto = texto.substring(0, longitud);
   this.setText(texto);
   this.setEditable(true);
  }
 }
 
 public boolean comparacion(String otraPassword)
 {
  boolean retorno = false;
  texto = this.getText();
  
  retorno = texto.equals(otraPassword);
  
  return retorno;
 }
    public void error(){
            this.setForeground(Color.white);
            this.setBackground(Color.red);
        }
 public String getPass() { return this.getText(); }
}
