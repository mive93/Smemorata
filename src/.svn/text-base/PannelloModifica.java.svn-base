/**
 * @file
 * Classe PannelloModifica.
 * 
 * Tale classe definisce il pannello utilizzato nella frame che appare
 * quando si vuole modificare un FileMultimediale.
 * 
 * In base al tipo di FileMultimediale selezionato l'interfaccia è diversa
 * poichè appaiono solo i campi della determinata classe figlia.
 * I campi che si vogliono modificare si devono scegliere attraverso le
 * checkbox, in questo modo è possibile modificare uno o più campi.
 * 
 * Vi sono due bottoni:
 * 1) Modifica: per attuare la modifica sulla libreria
 * 2) Annulla : per annullare l'operazione.
 * 
 * La classe estende la JPanel e implementa un ActionListener per gestire
 * gli eventi dei bottoni e delle checkbox.
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class PannelloModifica extends JPanel implements ActionListener
{
  private FileMultimediale file; /**< FileMultimediale da modificare*/
  private JFrame frame;          /**< Frame a cui appartiene tale pannello*/
  private JTable tabella;        /**< JTable in cui vengono visualizzati 
                                  * i file in PannelloLibreria*/ 
  
  private JButton modifica;  /**< Bottone Modifica*/
  private JButton annulla;   /**< Bottone Annulla*/
    
  private JCheckBox cb1; /**<CheckBox per Percorso*/
  private JCheckBox cb2; /**<CheckBox per Titolo*/
  private JCheckBox cb3; /**<CheckBox per Autore*/
  private JCheckBox cb4; /**<CheckBox per Anno*/
  private JCheckBox cb5; /**<CheckBox per Durata*/
  private JCheckBox cb6; /**<CheckBox per Frequenza di Campionamento*/
  private JCheckBox cb7; /**<CheckBox per Numero di Pagine*/
   
  private JTextField t1; /**<Inserimento nuovo Percorso*/
  private JTextField t2; /**<Inserimento nuovo Titolo*/ 
  private JTextField t3; /**<Inserimento nuovo Autore*/
  private JTextField t4; /**<Inserimento nuovo Anno*/
  private JTextField t5; /**<Inserimento nuova Durata*/
  private JTextField t6; /**<Inserimento nuova Frequenza di Campionamento*/
  private JTextField t7; /**<Inserimento nuovo Numero di Pagine*/
  

  
  /**
   * Costruttore della classe PannelloModifica.
   * 
   * Inizializza gli attributi della classe, li aggiunge al panello e
   * aggiunge ad essi l'ActionListener.
   * 
   * @param file    FileMultimediale che si vuole modificare
   * @param frame   frame nella quale è contenuto il pannello
   * @param tabella tabella nella quale saranno visibili i file
   */
  public PannelloModifica (FileMultimediale file, JFrame frame, JTable tabella)
  {
    super();
    this.file = file;
    this.frame = frame;
    this.tabella = tabella;
    
    cb1 = new JCheckBox ("Percorso");
    cb2 = new JCheckBox ("Titolo");
    cb3 = new JCheckBox ("Autore");
    cb4 = new JCheckBox ("Anno");
    cb5 = new JCheckBox ("Durata");
    cb6 = new JCheckBox ("Frequenza di Campionamento");
    cb7 = new JCheckBox ("Numero Pagine");
    
    t1 = new JTextField (15);
    t1.setEditable(false);
    t2 = new JTextField (15);
    t2.setEditable(false);
    t3 = new JTextField (15);
    t3.setEditable(false);
    t4 = new JTextField (15);
    t4.setEditable(false);
    t5 = new JTextField (15);
    t5.setEditable(false);
    t6 = new JTextField (15);
    t6.setEditable(false);
    t7 = new JTextField (15);
    t7.setEditable(false);
    
    modifica = new JButton ("Modifica");
    annulla = new JButton ("Annulla");
    
    AggiungiAlPannello();
    
    cb1.addActionListener(this);
    cb2.addActionListener(this);
    cb3.addActionListener(this);
    cb4.addActionListener(this);
    cb5.addActionListener(this);
    cb6.addActionListener(this);
    cb7.addActionListener(this);
    modifica.addActionListener(this);
    annulla.addActionListener(this);
    
  }
  
  
  /**
   * Aggiunge gli elementi al pannello.
   * 
   * Gli elementi vengono aggiungi in modi differenti in base
   * al tipo di istanza del file da modificare, ovvero se si tratta di un
   * BranoMusicale, di un EBook o di un Video.
   * 
   * Utilizza un GridBagLayout per disporre ordinatamente gli elementi.
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
    
    c.gridx = 0; c.gridy = 0; c.ipadx = 80; 
    c.fill = GridBagConstraints.HORIZONTAL;
    add(cb1,c);
    c.gridx = 1;
    add(t1,c);
    c.gridx = 0; c.gridy = 1;
    add(cb2,c);
    c.gridx = 1; 
    add(t2,c);
    c.gridx = 0; c.gridy = 2;
    add(cb3,c);
    c.gridx = 1; 
    add(t3,c);
    c.gridx = 0; c.gridy = 3;
    add(cb4,c);
    c.gridx = 1; 
    add(t4,c);
    
    if(file instanceof BranoMusicale)
    {
      c.gridx = 0; c.gridy = 4;
      add(cb5,c);
      c.gridx = 1; 
      add(t5,c);
      c.gridx = 0; c.gridy = 5;
      add(cb6,c);
      c.gridx = 1; 
      add(t6,c);  
    }
    else if (file instanceof EBook)
    {
      c.gridx = 0; c.gridy = 4;
      add(cb7,c);
      c.gridx = 1; c.gridy = 4;
      add(t7,c);
    }
    else if (file instanceof Video)
    {
      c.gridx = 0; c.gridy = 4;
      add(cb5,c);
      c.gridx = 1; c.gridy = 4;
      add(t5,c);
    }
    
    c.gridx = 0; c.gridy = 6;
    add(modifica,c);
    c.gridx = 1;
    add(annulla,c);
    
  }
  
  /**
   * Determina cosa succede quando si scatena un evento nel PannelloModifica.
   * 
   * Quando una JCheckBox è selezionata semplicemente viene attivato
   * il relativo JTextField, nel quale si deve inserire il nuovo 
   * valore dell'attributo che si vuole modificare.
   * 
   * Se viene premuto il tasto annulla semplicemente si chiude la frame.
   * 
   * Se viene premuto il tasto modifica si apportano le modifiche inserite
   * al FileMultimediale della libreria, infine si chiude la frame.
   */
  public void actionPerformed(ActionEvent e) 
  {
    Object sorgente = e.getSource();
    
    if (cb1.isSelected())     t1.setEditable(true);
    else      t1.setEditable(false);
    if (cb2.isSelected())     t2.setEditable(true);
    else      t2.setEditable(false);
    if (cb3.isSelected())     t3.setEditable(true);
    else      t3.setEditable(false);
    if (cb4.isSelected())     t4.setEditable(true);
    else      t4.setEditable(false);
    if (cb5.isSelected())     t5.setEditable(true);
    else      t5.setEditable(false);
    if (cb6.isSelected())     t6.setEditable(true);
    else      t6.setEditable(false);
    if (cb7.isSelected())     t7.setEditable(true);
    else      t7.setEditable(false);
    
    if(sorgente == modifica) //MODIFICA
    {
      try
      {
      if(file instanceof BranoMusicale)    
        ((BranoMusicale)file).Modifica(getPercorso(),getTitolo(),
                                       getAutore(),getAnno(),
                                       getDurata(),getFrequenza());
      else if (file instanceof EBook)
        ((EBook)file).Modifica(getPercorso(),getTitolo(),getAutore(),
                               getAnno(),getPagine());
      else if (file instanceof Video)
        ((Video)file).Modifica(getPercorso(),getTitolo(),getAutore(),
                               getAnno(),getDurata());
      
      }
      catch (NumberFormatException nfe)
      {
        JOptionPane.showMessageDialog(this,
                                      "Inserire tutto ciò che è selezionato",
                                      "Errore inserimento",
                                      JOptionPane.ERROR_MESSAGE);
      }
      tabella.revalidate();
      chiudiFinestra();
    }
    else if (sorgente == annulla) //ANNULLA
      chiudiFinestra();
  }
  
  /**
   * Determina il nuovo PercorsoFile del FileMultimediale.
   * 
   * @return    ritorna la stringa letta nella JTextField in caso
   *            sia selezionata, una stringa vuota altrimenti.
   */
  private String getPercorso ()
  {
    if (cb1.isSelected())
      return t1.getText();
    return "";
  }
  
  /**
   * Determina il nuovo Titolo del FileMultimediale.
   * 
   * @return    ritorna la stringa letta nella JTextField in caso
   *            sia selezionata, una stringa vuota altrimenti.
   */
  private String getTitolo ()
  {
    if (cb2.isSelected())
      return t2.getText();
    return "";
  }

  /**
   * Determina il nuovo Autore del FileMultimediale.
   * 
   * @return    ritorna la stringa letta nella JTextField in caso
   *            sia selezionata, una stringa vuota altrimenti.
   */
  private String getAutore ()
  {
    if (cb3.isSelected())
      return t3.getText();
    return "";
  }
  
  /**
   * Determina il nuovo Anno del FileMultimediale.
   * 
   * Se non è inserito nulla scatena una NumberFormatException.
   * @return    ritorna l'intero letto nella JTextField in caso
   *            sia selezionata, -1 altrimenti.
   */
  private int getAnno () throws NumberFormatException
  {
    if (cb4.isSelected())
      return Integer.parseInt(t4.getText());
    return -1;
  }
  

  /**
   * Determina la nuova Durata del BranoMusicale/Video.
   *     
   * Se non è inserito nulla scatena una NumberFormatException.
   * @return    ritorna l'intero letto nella JTextField in caso
   *            sia selezionata, -1 altrimenti.
   */
    private int getDurata  ()throws NumberFormatException
  {
    if (cb5.isSelected())
      return Integer.parseInt(t5.getText());
    return -1;
  }
    
  /**
   * Determina la nuova FrequenzaCampionamento del BranoMusicale.
   * 
   * Se non è inserito nulla scatena una NumberFormatException.
   * @return    ritorna l'intero letto nella JTextField in caso
   *            sia selezionata, -1 altrimenti.
   */   
      private int getFrequenza ()throws NumberFormatException
  {
    if (cb6.isSelected())
      return Integer.parseInt(t6.getText());
    return -1;
  }
      
  /**
   * Determina il nuovo NumPagine dell'EBook
   * 
   * Se non è inserito nulla scatena una NumberFormatException.
   * @return    ritorna l'intero letto nella JTextField in caso
   *            sia selezionata, -1 altrimenti.
   */
  private int getPagine ()throws NumberFormatException
  {
    if (cb7.isSelected())
      return Integer.parseInt(t7.getText());
    return -1;
  }
  
  /**
   * Chiude la frame in cui è contenuto il pannello.
   * 
   * E' un metodo privato perchè serve solo internamente alla classe.
   */
  private void chiudiFinestra ()
  {
     WindowEvent eventoChiudi = new WindowEvent( frame, 
                                                WindowEvent.WINDOW_CLOSING );
     Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(eventoChiudi);
  }
}
  