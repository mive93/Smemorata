/**
 * @file
 * Classe MioPlayer.
 * 
 * Classe che definisce un player di mp3 utilizzando la libreria JLayer.
 * La riproduzione del brano è gestita con un thread, per rendere possibile
 * la pausa, lo stop e la ripresa della riproduzione.
 * 
 * E' stata utilizzata la libreria JLayer.
 * 
 */

import java.io.*;
import javazoom.jl.decoder.*;
import javazoom.jl.player.*;

public class MioPlayer 
{
  
  private final int NONINIZIATO = 0;  /**<Stato: non ancora in riproduzione*/
  private final int INESECUZIONE = 1; /**<Stato: in esecuzione*/
  private final int INPAUSA = 2;      /**<Stato: in pausa*/
  private final int FINITO = 3;       /**<Stato: esecuzione terminata*/
   
  private final Player player;        /**<Player che permette la riporduzione*/
  private final Object lock = new Object(); /**< Lock per la sincronizzazione*/
  private int stato = NONINIZIATO;    /**< Stato della riproduzione*/
  
  
  /**
   * Costruttore della classe MioPlayer.
   * 
   * Inisizalizza il player e scatenda una JavaLayerException.
   * 
   * @param is  file da riprodurre.
   */
  public MioPlayer(final InputStream is) throws JavaLayerException 
  {
    this.player = new Player(is);
  }
  
  /**
   * Fa partire il brano.
   * 
   * Gestisce sia il caso in cui il brano non sia mai andato prima in 
   * esecuzione, sia che il brano sia stato ripreso dopo una pausa.
   * Qui vi è la creazione e il lancio del thread.
   * Scatena una JavaLayerException.
   */
  
  public void play() throws JavaLayerException 
  {
    synchronized (lock) 
    {
      switch (stato) 
      {
        case NONINIZIATO:
          final Thread t = new Thread(){ public void run() { riproduci();}};
          stato = INESECUZIONE;
          t.start();
          break;
        case INPAUSA:
          riprendi();
          break;
        default:
          break;
      }
    }
  }
  
  
  /**
   * Mette in pausa la riproduzione.
   * 
   * Semplicemente cambia lo stato.
   */
  public void pausa() 
  {
    synchronized (lock) 
    {
      if (stato == INESECUZIONE) 
        stato = INPAUSA;
    }
  }
  
  /**
   * Riprende l'esecuzione dalla pausa.
   * 
   * Cambia lo stato della riproduzione e notifica il thread che dovrebbe
   * essere in stato di attesa, con notifyAll lo "risveglia".
   */
  public void riprendi() 
  {
    synchronized (lock) 
    {
      if (stato == INPAUSA)
      {
        stato = INESECUZIONE;
        lock.notifyAll();
      }
    }
  }
  
  /**
   * Stoppa l'esecuzione del brano.
   * 
   * Cambia lo stato della riproduzione e notifica il thread che dovrebbe
   * essere in stato di attesa, con notifyAll lo "risveglia".
   */
  public void stop() 
  {
    synchronized (lock) 
    {
      stato = FINITO;
      lock.notifyAll();
    }
  }
  
  /**
   * Riproduce effettivamente il brano.
   * 
   * Funzione che finchè vi sono frame da eseguire, le esegue.
   * Se lo stato è INPAUSA il thread viene "addormentato" con wait()
   * e verrà "risvegliato" solo con un notify() o un notifyAll()
   *
   * Se non vi sono più frame da eseguire (quando player.play(1) ritorna
   * false), viene invocato il metodo close(); 
   */
  private void riproduci() 
  {
    while (stato != FINITO) 
    {
      try {
        if (!player.play(1)) 
          break;
      } catch (final JavaLayerException e) {break;}
      
      
      synchronized (lock) 
      {
        while (stato == INPAUSA) 
        {
          try 
          {
            lock.wait();
          } catch (final InterruptedException e) 
          {
            break;
          }
        }
      }
    }
    close();
  }
  
  /**
   * Chiusura del player.
   * 
   * Cambia lo stato di riproduzione e chiude il player.
   */
  public void close() 
  {
    synchronized (lock) 
    {
      stato = FINITO;
    }
    try 
    {
      player.close();
    } catch (final Exception e) {System.out.println("Errore Chiusura");}
  }
}