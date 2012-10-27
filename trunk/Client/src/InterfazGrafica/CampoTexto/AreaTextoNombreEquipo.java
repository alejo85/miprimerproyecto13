package InterfazGrafica.CampoTexto;

import java.awt.Color;
import java.awt.event.FocusEvent;

public class AreaTextoNombreEquipo extends AreaTexto
{
 private String[] clubes;
 
 public AreaTextoNombreEquipo(int longitudMaxima)
 {
  super(longitudMaxima);
  clubes = null;
 }
 
 public void setClubes(String[] clubes) { this.clubes = clubes; }
 public String[] getClubes() { return clubes; }
 
 public void ganado(FocusEvent evt)
 {
  this.setForeground(Color.black);
  this.setBackground(Color.white);
 }
 
 public void perdido(FocusEvent evt)
 {
  if ((vacio()) || (priVacia()) || (!nombreEquipoNoEsClub()))
  {
   this.setForeground(Color.white);
   this.setBackground(Color.orange);
  }
 }
 
 public boolean vacio()
 {
  return (this.getText().isEmpty());
 }
 
 public boolean priVacia()
 {
  boolean retorno = false;
  
  if (this.getText().isEmpty()) retorno = true;
  else {if (this.getText().substring(0, 1).equals(" ")) retorno = true; }
  
  return retorno;
 }
 
 public boolean nombreEquipoNoEsClub()
 {
  int i = 1;
  boolean retorno = true;
  String club;
  String nombre = this.getText().toUpperCase();
  
  while ((i < 21) && (retorno))
  {
   club = clubes[i].toUpperCase();
   
   if (club.equals(nombre)) retorno = false;
   else i++;
  }
  
  return retorno;
 }
}
