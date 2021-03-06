/** 
 * @file
 * Classe Video.
 * 
 * Tale classe definisce un oggetto del tipo video.
 * Estende la classe FileMultimediale.java .
 * 
 * Implementa l'interfaccia Serializable poichè in tal modo gli
 * oggetti di questa classe possono essere serializzati, ovvero salvati su 
 * file come oggetti.
 * 
 */

import java.io.*;

public class Video extends FileMultimediale implements Serializable
{
  private int Durata; /**< Durata del Video*/
  
  /**
   * Costruttore della classe Video.
   * 
   * Inizializza gli attributi della classe invocando il costruttore della
   * classe padre per poi inizializzare quelli propri della classe stessa.
   *
   * @param PercorsoFile  path del video
   * @param Titolo        titolo del video
   * @param Autore        autore del video
   * @param Anno          anno di creazione del video
   * @param Durata        durata del video
   */
  public Video(String PercorsoFile, String Titolo, String Autore, 
               int Anno, int Durata) 
  {
    super (PercorsoFile, Titolo, Autore, Anno);
    this.Durata = Durata;
  }
  
  /**
   * Modifica gli attributi dell'oggetto.
   * 
   * Gli attributi vengono modificati solo se sono validi.
   * 
   * @param percorsoFile            nuovo percorso 
   * @param titolo                  nuovo titolo
   * @param autore                  nuovo autore
   * @param anno                    nuovo anno
   * @param durata                  nuova durata
   */
  public void Modifica ( String percorsoFile, String titolo, 
                        String autore, int anno ,int durata)
  {
    super.Modifica(percorsoFile, titolo,autore, anno);
    if (durata != -1)this.Durata = durata;
  }
        
  /**
   * Redifinisce il metodo toString().
   * 
   * @return   Ritorna una stringa che concatena gli attributi del Video,
   *           ovvero ciò che si vuole stampare quando invoco 
   *           System.out.println(v); dove v è un Video.
   */
    public String toString () 
  {
    return super.toString()+"\nDurata: "+Durata;
  }
    
  /**
   * Cerca una stringa/sottostringa nei campi del Video.
   * 
   * Ridefinisce il metodo Cerca(String s) della classe padre.
   * 
   * @param s  stringa da ricercare
   * @return       ritorna vero solo se ha avuto almeno un match nelle 
   *               sottostringhe degli attributi del Video con la stringa s.
   */  
    public boolean Cerca (String s)
  {
    String durata = this.Durata+"";
    if(!super.Cerca(s) && durata.lastIndexOf(s) == -1 )
           return false;
    return true;
  }
}