/** 
 * @file
 * Classe FileMultimediale.
 * 
 * Tale classe astratta definisce un oggetto del tipo file multimediale.
 * 
 * Implementa l'interfaccia Serializable poichè in tal modo gli
 * oggetti di questa classe possono essere serializzati, ovvero salvati su 
 * file come oggetti.
 */

import java.io.*;

public abstract class FileMultimediale implements Serializable
{
  private String Titolo;        /**< Titolo del FileMultimediale*/
  private String Autore;        /**< Autore del FileMultimediale*/
  private int Anno;             /**< Anno di creazione del FileMultimediale*/
  private String PercorsoFile;  /**< Percorso relativo o assoluto 
                                  * del FileMultimediale*/
  
  /**
   * Costruttore della classe FileMultimediale.
   * 
   * Inizializza gli attributi della classe.
   * @param PercorsoFile   path del file multimediale
   * @param Titolo         titolo del file multimediale
   * @param Autore         autore del file multimediale
   * @param Anno           anno di creazione del file multimediale
   */
  public FileMultimediale ( String PercorsoFile, String Titolo, 
                           String Autore, int Anno )
  {
    this.Titolo = Titolo;
    this.Autore = Autore;
    this.Anno = Anno;
    this.PercorsoFile = PercorsoFile;
  }
  
  /**
   * Confronta due FileMultimediale.
   * 
   * Confronta il FileMultimediale stesso con quello passato per parametro
   * attraverso un confronto dei percorsi, poichè se due file hanno lo stesso
   * percorso, si tratta dello stesso file.
   * 
   * @param f   FileMultimediale da confrontare
   * @return    Ritorna vero solo se i due file sono ritenuti uguali, falso
   *            altrimenti.
   */
  public boolean Confronta (FileMultimediale f)
  {
    if ((this.PercorsoFile).equals(f.PercorsoFile))
      return true;
    return false;
  }
  
  /**
   * Modifica gli attributi dell'oggetto.
   * 
   * Gli attributi vengono modificati solo se sono validi.
   * 
   * @param percorsoFile nuovo percorso 
   * @param titolo       nuovo titolo
   * @param autore       nuovo autore
   * @param anno         nuovo anno
   */
  public void Modifica ( String percorsoFile, String titolo, 
                        String autore, int anno )
  {
    if (titolo != "") this.Titolo = titolo;
    if (autore != "") this.Autore = autore;
    if (anno != -1) this.Anno = anno;
    if (percorsoFile != "") this.PercorsoFile = percorsoFile;
  }
  
  /**
   * Restituisce l'attributo Titolo.
   * 
   * @return   Ritorna il titolo del FileMultimediale.
   */
  public String getTitolo ()
  {
    return Titolo;
  }
   
  /**
   * Restituisce l'attributo Autore.
   * 
   * @return   Ritorna l'autore del FileMultimediale.
   */
  public String getAutore ()
  {
    return Autore;
  }
  
  /**
   * Restituisce l'attributo Anno.
   * 
   * @return   Ritorna l'anno del FileMultimediale.
   */
  public int getAnno ()
  {
    return Anno;
  }
  
  /**
   * Restituisce l'attributo PercorsoFile.
   * 
   * @return   Ritorna il percorso del FileMultimediale.
   */
  public String getPercorsoFile()
  {
    return PercorsoFile;
  }
  
  /**
   * Redifinisce il metodo toString().
   * 
   * @return   Ritorna una stringa che concatena gli attributi del 
   *           FileMultimediale, ovvero ciò che si vuole stampare 
   *           quando invoco System.out.println(fm); dove fm è 
   *           un FileMultimediale.
   */
  public String toString () 
  {
    return "Titolo : "+Titolo+"\nAutore: "+Autore+"\nAnno: "+
      Anno+"\nPercorso: "+PercorsoFile;
  }
  
  /**
   * Cerca una stringa/sottostringa nei campi del FileMultimediale.
   * 
   * @param s      stringa da ricercare
   * @return       ritorna vero solo se ha avuto almeno un match nelle 
   *               sottostringhe degli attributi del FileMultimediale 
   *               con la stringa s.
   */  
  public boolean Cerca (String s)
  {
    String anno = this.Anno+"";
    if(this.PercorsoFile.lastIndexOf(s)!= -1 || this.Titolo.lastIndexOf(s)!= -1
         || this.Autore.lastIndexOf(s)!= -1 || anno.lastIndexOf(s)!= -1)
      return true;
    return false;
  }
}