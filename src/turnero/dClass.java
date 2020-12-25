/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnero;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 *
 * @author maric
 */
public class dClass {
    
    Synthesiser synthesiser = new Synthesiser("es");
    
    
    public void speak(String texte) {
        
        try {
            System.out.println(texte);

            //Create a new Thread because JLayer is running on the current Thread and will make the application to lag
            Thread thread = new Thread(() -> {
                try {
                    
                    //Create a JLayer instance
                    AdvancedPlayer player = new AdvancedPlayer(synthesiser.getMP3Data(texte));
                    player.play();
                    
                    System.out.println("Successfully got back synthesizer data");
                    
                } catch (JavaLayerException e) {
                    
                    e.printStackTrace(); //Print the exception ( we want to know , not hide below our finger , like many developers do...)
                    
                } catch (IOException ex) {
                    Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            //We don't want the application to terminate before this Thread terminates
            thread.setDaemon(false);

            //Start the Thread
            thread.start();
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) {
        dClass d = new dClass();
        d.speak("en 15 minutos estaremos cerrando nuestras puertas hasta la próxima");
    }
}
