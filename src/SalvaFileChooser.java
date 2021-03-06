/**
 * @file
 * Classe SalvaFileChooser.
 * 
 * Questa classe estende JFileChooser e lo specializza per il
 * salvataggio di una LibreriaMultimediale sul file scelto
 * attraverso il FileChooser. 
 * 
 * Se il file selezionato è già esistente si apre una finestra di 
 * dialogo per confermare la sovrascrittura o annullarla.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SalvaFileChooser extends JFileChooser
{
  private LibreriaMultimediale lib;  /**<LibreriaMultimediale su cui lavorare */
  private FileOutputStream fileScrittura; /**< File su cui salvare la libreria*/
  private ObjectOutputStream os;       /**< Stream per salvare l'oggetto 
                                        * LibreriaMultimediale su di un file.*/
  private File fileSelezionato;          /**< File selezionato col fileChooser*/
  
  /**
   * Costruttore della classe SalvaFileChooser.
   * 
   * @param lib           libreria da salvare
   * @param fileScrittura file su cui salvare la libreria
   * @param os            stream dell'oggetto
   */
  public SalvaFileChooser ( LibreriaMultimediale lib,
                           FileOutputStream fileScrittura,ObjectOutputStream os)
  { 
    super();
    this.lib = lib;
    this.fileScrittura = fileScrittura;
    this.os = os;
  }
  
  /**
   * Determina cosa succede quando si approva il fileChooser.
   * 
   * Se il file esiste già appare una finestra di dialogo.
   * Se si preme Sì, il file viene sovrascritto, No o si 
   * chiude il file Chooser, si torna alla scelta del nome 
   * per il salvataggio, Annulla si chiude il file Chooser.
   */
  public void approveSelection()
  {
    fileSelezionato = getSelectedFile();
    if(fileSelezionato.exists())
    {
      int risposta = JOptionPane.showConfirmDialog(this,
                                       "Il file esiste già, sovrascrivere?",
                                       "File già esistente",
                                       JOptionPane.YES_NO_CANCEL_OPTION);
      switch(risposta){
        case JOptionPane.YES_OPTION:
          Salva();
          super.approveSelection();
          return;
        case JOptionPane.NO_OPTION:
          return;
        case JOptionPane.CLOSED_OPTION:
          return;
        case JOptionPane.CANCEL_OPTION:
          cancelSelection();
          return;
      }
    }
    else 
    {
      Salva();
      super.approveSelection();
    }
  }
  
  /**
   * Salvataggio effettivo della libreria su file.
   * 
   * La LibreriaMultimediale viene serializzata nel file scelto
   * col fileChooser.
   */
  public void Salva()
  {
    try
    {
      fileScrittura = new FileOutputStream (fileSelezionato+"");
    }
    
    catch(IOException ioe){System.err.println("Errore apertura FileScrittura");}
    try 
    {
      os = new ObjectOutputStream (fileScrittura);
      os.writeObject(lib);
      os.flush();
      os.close();
      fileScrittura.close();
    }
    catch(IOException ioe) {System.err.println("Errore Scrittura");}
  
  }
}