/** 
 * @file
 * Classe LibreriaMultimediale.
 * 
 * Tale classe definisce un oggetto del tipo libreria multimediale.
 * Tale classe vuole gestire un insieme di file multimediali della 
 * classe FileMultimediale.
 * 
 * La libreria è implementata con un array di FileMultimediale e un
 * indice che conteggia quanti elementi sono presenti al momento.
 * 
 * Implementa l'interfaccia Serializable poichè in tal modo gli
 * oggetti di questa classe possono essere serializzati, ovvero salvati su 
 * file come oggetti.
 * 
 */
import java.io.*;

public class LibreriaMultimediale implements Serializable
{
  private FileMultimediale fm [] ;/**< Libreria: un array di FileMultimediale*/
  private int indice;             /**< indica il numero attuale di 
                                   * elementi nella libreria*/
 
  
  /**
   * Costruttore della classe LibreriaMultimediale.
   * 
   * Inizializza l'indice contatore degli elementi della libreria a 0.
   */
  public LibreriaMultimediale () 
  {
    indice = 0; 
  }
  
  /**
   * Aggiunge un FileMultimediale alla libreria.
   * 
   * Crea un array temporaneo con un elemento in più in cui copia 
   * il vecchio array, dopodichè sostituisce il vecchio array col nuovo.
   * 
   * @param f   FileMultimediale da aggiungere.
   */
  public void Aggiungi (FileMultimediale f) 
  {
   
    FileMultimediale tmp [] = new FileMultimediale[indice+1];
    for(int i=0; i<indice; i++)
      tmp[i] = fm [i];
    tmp[indice] = f;
    
    fm = tmp;
    indice++;
  }
  
  /**
   * Modifica un dato FileMultimediale della libreria.
   * 
   * Il medoto ricerca il FileMultimediale da modificare, dopodichè 
   * semplicemente invoca il metodo Modifica della classe FileMultimediale
   * per cambiare gli attributi.
   * 
   * @param f             FileMultimediale da modificare
   * @param PercorsoFile  nuovo path
   * @param Titolo        nuovo titolo
   * @param Autore        nuovo autore
   * @param Anno          nuovo anno
   */
  public void Modifica (FileMultimediale f, String PercorsoFile, String Titolo,
                        String Autore, int Anno) 
  {
    for(int i= 0; i<indice; i++)
    {
      if(fm[i].Confronta(f))
        fm[i].Modifica(PercorsoFile, Titolo, Autore, Anno);
    }
  }

  /**
   * Elimina un FileMultimediale dalla libreria.
   * 
   * Il metodo ricerca il FileMultimediale dato dopodichè crea
   * un array temporaneo con tutti gli oggetti eccetto quello dato 
   * e sostituisce il vecchio array col nuovo.
   * 
   * @param f    FileMultimediale da eliminare dalla libreria. 
   */
  public boolean Elimina (FileMultimediale f) 
  {
    if(indice == 0)
      return false;
    else
    {
      FileMultimediale tmp [] = new FileMultimediale[indice-1];
      int j=0;
      for(int i=0; i< indice ; i++)
      {
        if(!fm[i].Confronta(f))
        {
          tmp[j] = fm[i];
          j++;
        }
      }
      
      fm = tmp;
      indice --;
      return true;
    }  
  }
  
  /**
   * Restituisce il numero di elementi della libreria.
   * 
   * @return   ritorna l'attributo indice, ovvero gli elementi
   *           presenti al momento nella libreria.
   */
  
  public int Lunghezza()
  {
    return indice;
  }
  
  /**
   * Cerca una stringa/sottostringa nei file della LibreriaMultimediale.
   * 
   * Scorre tutti i file della LibreriaMultimediale cercando un match
   * con la stringa passata.
   * 
   * @param s   stringa da ricercare
   * @return    ritorna una LibreriaMultimediale composta solo dai
   *            file multimediali che compongono la stringa ricercata.
   * 
   */
  public LibreriaMultimediale Cerca(String s)
  {
    LibreriaMultimediale l = new LibreriaMultimediale ();
    
    for(int i =0; i<indice; i++)
      if(fm[i].Cerca(s))
        l.Aggiungi(fm[i]);
    
    return l;
  }
 
  /**
   * Restituisce un FileMultimediale ad un dato indice.
   * 
   * @param i   indice del FileMultimediale
   * @return    FileMultimediale della libreria al determinato indice
   */
  public FileMultimediale getFile (int i)
  {
    return fm[i];
  }
   
}