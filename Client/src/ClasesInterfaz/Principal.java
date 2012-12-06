package ClasesInterfaz;

import ClasesLogicas.Usuario;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal {
    public Principal() {
    	
        /// muestra los look and feel instalados
        
        UIManager.LookAndFeelInfo plaf[] = UIManager.getInstalledLookAndFeels();
         
        for (int i=0; i < plaf.length; i++){
         
              System.out.println("Nombre: " + plaf[i].getName());
         
              System.out.println("Nombre de la clase: "+ plaf[i].getClassName());
         
        }
       
        
        
        //// seteamos look and feel
        
        try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); //aca pasamos de parametro una funcion
                                                                                    //que toma el look and feel del sistema, para pasar uno
                                                                                    //especifico se pasa asi ("nombredellookandfeel")
                																	//UIManager.getSystemLookAndFeelClassName()
                }
                catch (UnsupportedLookAndFeelException e) {
                   // handle exception
                }
                catch (ClassNotFoundException e) {
                   // handle exception
                }
                catch (InstantiationException e) {
                   // handle exception
                }
                catch (IllegalAccessException e) {
                   // handle exception
                }
    	
    	
    	
        JFrame frame = new Central();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible(true);
    }
    public Principal(Usuario usuario) {
        JFrame frame = new Central(usuario);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible(true);
    }

  
}
