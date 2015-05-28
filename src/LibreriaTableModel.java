/** 
 * @file
 * Classe LibreriaTableModel.
 * 
 * Tale classe definisce il modello della tabella che verrà visualizzata.
 * Estende la classe AbrstactTableModel.
 */

import javax.swing.table.AbstractTableModel;


public class LibreriaTableModel extends AbstractTableModel 
{
  private LibreriaMultimediale lib; /**<Libreria da visualizzare*/
  private String [] Intestazione = {"Titolo", "Autore","Anno","Percorso File"};
                                    /**<Titoli delle colonne*/
  
  /**
   * Costrtuttore della classe LibreriaTableModel.
   * 
   * Inizializza gli attributi della classe.
   * @param lib    LibreriaMultimediale da cui deve prendere i dati 
   */
  public LibreriaTableModel(LibreriaMultimediale lib)
  { 
    this.lib = lib;
  }
  
  /**
   * Setta in numero di colonne (metodo Holliwood).
   * 
   * Il numero di colonne è fisso, ovvero è il numero di attributi della
   * classe FileMultimediale.
   */
  public int getColumnCount ()
  {
    return 4;
  }
  
  /**
   * Setta in numero di righe (metodo Holliwood).
   * 
   * Il numero di righe dipende dal numero di elementi presenti nella libreria.
   */
  public int getRowCount ()
  {
    return lib.Lunghezza();
  }

  /**
   * Inserisce gli elementi nelle celle (metodo Holliwood).
   * 
   * @param row   numero di righe
   * @param col   numero di colonne
   */
  public Object getValueAt (int row, int col)
  {
    FileMultimediale f = lib.getFile(row);
    switch (col)
    {
      case 0: return f.getTitolo();
      case 1: return f.getAutore();
      case 2: return f.getAnno();
      case 3: return f.getPercorsoFile();
      default : return "";
    }

  }

  /**
   * Setta il nome delle colonne (metodo Holliwood).
   */
  public String getColumnName (int col)
  {
    return Intestazione [col];
  }
}
