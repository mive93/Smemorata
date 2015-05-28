/**
 * @file
 * Classe PannelloPlayer.
 * 
 * Pannello del Mp3Player, estende JPanel e implementa un ActionListener 
 * per gestire i bottoni.
 * 
 * E' una semplice interfaccia che visualizza il titolo e l'autore
 * del BranoMusicale in esecuzione. Inoltre vi sono quattro bottoni
 * per far partire, mettere in pausa, riprendere e bloccare la rirpoduzione
 * del file mp3.
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.Desktop.*;
import java.io.*;

public class PannelloPlayer extends JPanel implements ActionListener
{
  private JButton play;     /**<Bottone play*/
  private JButton pausa;    /**<Bottone pausa*/
  private JButton stop;     /**<Bottone stop*/
  private JButton riprendi; /**<Bottone riprendi*/
  
  private ImageIcon Iplay;     /**<Icona per bottone play*/
  private ImageIcon Istop;     /**<Icona per bottone stop*/
  private ImageIcon Ipausa;    /**<Icona per bottone pausa*/
  private ImageIcon Iriprendi; /**<Icona per bottone riprendi*/
  
  private JLabel l1; /**<Etichetta per il Titolo*/
  private JLabel l2; /**<Etichetta per l'Autore*/
  
  private FileMultimediale fm; /**<File multimediale da riprodurre*/
  private MioPlayer player;    /**<Player per riprodurre*/
  
  
  /**
   * Costruttore classe PannelloPlayer.
   * 
   * Inizializza gli attributi della classe, li aggiunge al panello e
   * aggiunge ad essi l'ActionListener.
   * 
   * @param fm  FileMultimediale da riprodurre.
   */
  public PannelloPlayer (FileMultimediale fm)
  {
    super();
    this.fm = fm;
    
    l1 = new JLabel ("Titolo: "+fm.getTitolo());
    l2 = new JLabel ("Autore: "+fm.getAutore());
   
    Iplay = new ImageIcon("../img/Play.png");
    Ipausa = new ImageIcon("../img/Pause.png");
    Istop = new ImageIcon("../img/Stop.png");
    Iriprendi = new ImageIcon("../img/Resume.png");
    
    play = new JButton (Iplay);
    pausa = new JButton (Ipausa);
    stop = new JButton (Istop);
    riprendi = new JButton (Iriprendi);
    
    pausa.setEnabled(false);
    stop.setEnabled(false);
    riprendi.setEnabled(false);
    
    AggiungiAlPannello();
    
    play.addActionListener(this);
    pausa.addActionListener(this);
    riprendi.addActionListener(this);
    stop.addActionListener(this);
    
  }
  
  
  /**
   * Aggiunge gli elementi al pannello.
   * 
   * Utilizza un GridBagLayout per disporre ordinatamente gli elementi.
   * 
   * Necessaria per il posizionamento degli elmenti con tale layout è una
   * GridBagConstraints di cui vanno modificato alcuni attributi come :
   *  gridx     : setta la posizione x dell'elemento (la colonna)
   *  gridy     : setta la posizione y dell'elemento (la riga)
   *  ipadx     : spanna lo spazio occupato dall'elemento (quanti pixel)
   *  fill      : riempe la cella dell'elemento in una data direzione 
   * 
   * E' privata perchè serve solo per non appesantire il costruttore.
   */
    private void AggiungiAlPannello()
  {
    setLayout(new GridBagLayout());
    
    GridBagConstraints c = new GridBagConstraints();
    
    c.gridx = 0; c.gridy = 0; c.ipadx = 30; 
    c.fill = GridBagConstraints.HORIZONTAL; c.gridwidth = 4;
    add(l1,c);
    c.gridx = 0; c.gridy = 1;
    add(l2,c);
    c.gridx = 0; c.gridy = 2;c.gridwidth = 1;
    add(play,c);
    c.gridx = 1;
    add(pausa,c);
    c.gridx = 2; 
    add(riprendi,c);
    c.gridx = 3; 
    add(stop,c);
    
    }
  
    /**
     * Determina cosa succede quando si scatena un evento nel PannelloPlayer.
     * 
     * Vi sono quattro bottoni :
     * Play : inzia la riproduzione del file.
     * Pausa : la riproduzione è messa in pausa.
     * Riprendi : la riproduzione è ripresa da dove era stata messa in pausa.
     * Stop : la riproduzione è fermata e il player è chiuso.
     * 
     */
   public void actionPerformed(ActionEvent e) 
   {
     Object sorgente = e.getSource();
     if(sorgente == play) //PLAY
     {
       play.setEnabled(false);
       pausa.setEnabled(true);
       stop.setEnabled(true);
       
       try
       {
         FileInputStream input = new FileInputStream(fm.getPercorsoFile()); 
         player = new MioPlayer(input);
         player.play();
       }
       catch(Exception ex){ System.out.println("Errore PLAY");}
     }
     else if(sorgente == pausa) //PAUSA
     {
       riprendi.setEnabled(true);
       pausa.setEnabled(false);
       stop.setEnabled(true);
       
       try
       {
         player.pausa();
       }
       catch(Exception ex){ System.out.println("Errore PAUSA");}
       
     }
     else if (sorgente == riprendi) //RIPRENDI
     {
       riprendi.setEnabled(false);
       pausa.setEnabled(true);
       stop.setEnabled(true);
       
       try
       {
         player.riprendi();
       }
       catch(Exception ex){ System.out.println("Errore RIPRENDI");}
       
     }
     else if(sorgente == stop) //STOP
     {
       play.setEnabled(true);
       pausa.setEnabled(false);
       stop.setEnabled(false);
       riprendi.setEnabled(false);
       
       try
       {
         player.stop();
         player.close();
       }
       catch(Exception ex){ System.out.println("Errore STOP");}
     }
   }
   
   /**
    * Gestisce l'uscita dal Mp3Player.
    * 
    * Il player viene stoppato poi chiuso.
    */
   public void Esci ()
   {
     try
     {
       player.stop();
       player.close();
     }
     catch(Exception ex){ System.out.println("Errore ESCI");}
   }
}