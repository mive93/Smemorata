/**
 * @file
 * Classe PannelloAggiungi.
 * 
 * Tale classe definisce il pannello utilizzato nella frame che appare
 * quando si seleziona la vode del menu File/Aggiungi.
 * Sono presenti tre radio button che ti permettono di scegliere
 * quale tipo di FileMultimediale si vuole aggiungere.
 * Dopodichè sono specificati i campi necessari per aggiungere ognuno dei
 * tre tipi di file.
 * 
 * Vi sono poi tre bottoni: 
 * 
 * aggiungi : per aggiungere effettivamente il file alla libreria
 * 
 * importa : per aggiungere più di un file, selezionandoli da una cartella
 * 
 * annulla : per annullare l'operazione
 * 
 * La classe estende la JPanel e implementa un ActionListener per gestire
 * gli eventi dei radio button, delle aree di testo e dei bottoni.
 * 
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.*;

public class PannelloAggiungi extends JPanel implements ActionListener{
  
  private LibreriaMultimediale lib; /**< LibreriaMultimediale su cui lavorare*/
  private JFrame frame;             /**< Frame in cui è contenuto il pannello*/
  private JTable tabella;     /**< JTable che contiene i dati della libreria*/
  
  private JLabel l1; /**< Etichetta Percorso*/
  private JLabel l2; /**< Etichetta Titolo*/
  private JLabel l3; /**< Etichetta Autore*/
  private JLabel l4; /**< Etichetta Anno*/
  private JLabel l5; /**< Etichetta Durata*/
  private JLabel l6; /**< Etichetta Frequenza di Campionamento*/
  private JLabel l7; /**< Etichetta Numero di Pagine*/
  
  private JTextField t1; /**< Inserimento testo per Percorso*/
  private JTextField t2; /**< Inserimento testo per Titolo*/
  private JTextField t3; /**< Inserimento testo per Autore*/
  private JTextField t4; /**< Inserimento testo per Anno*/
  private JTextField t5; /**< Inserimento testo per Durata*/
  private JTextField t6; /**< Inserimento testo per Frequenza di Campionamento*/
  private JTextField t7; /**< Inserimento testo per Numero di Pagine*/
  
  
  private JRadioButton rb1; /**< Scelta BranoMusicale*/
  private JRadioButton rb2; /**< Scelta Video*/
  private JRadioButton rb3; /**< Scelta EBook*/
  
  private ButtonGroup gruppo; /**< Gruppo dei radioButton*/
  
  private JButton aggiungi; /**< Bottone Aggiungi*/
  private JButton importa;  /**< Bottone Importa*/
  private JButton annulla;  /**< Bottone Annulla*/
  
  private JFileChooser fc;        /**< FileChooser per l'importazione*/
  FileNameExtensionFilter filtro; /**< Filtro per le estensioni nel fileChooser.
                                   * Possono essere selezionati solo file
                                   * del tipo specificato dal filtro.*/
  
  private boolean brano; /**<Booleano vero solo se è selezionato rb1*/
  private boolean ebook; /**<Booleano vero solo se è selezionato rb2*/
  private boolean video; /**<Booleano vero solo se è selezionato rb3*/
  
  
  /**
   * Costruttore della classe PannelloAggiungi.
   * 
   * Inizializza gli attributi della classe, li aggiunge al panello e
   * aggiunge ad essi l'ActionListener.
   * 
   * @param lib     libreria alla quale aggiungere un FileMultimediale
   * @param frame   frame nella quale è contenuto il pannello
   * @param tabella tabella nella quale saranno visibili i file
   */
  public PannelloAggiungi(LibreriaMultimediale lib,JFrame frame,JTable tabella)
  {
    super();
    this.lib = lib;
    this.frame = frame;
    this.tabella = tabella;
    
    l1 = new JLabel ("Percorso");
    l2 = new JLabel ("Titolo");
    l3 = new JLabel ("Autore");
    l4 = new JLabel ("Anno");
    l5 = new JLabel ("Durata");
    l6 = new JLabel ("Frequenza di Campionamento");
    l7 = new JLabel ("Numero Pagine");
    
    t1 = new JTextField (15);
    t2 = new JTextField (15);
    t3 = new JTextField (15);
    t4 = new JTextField (15);
    t5 = new JTextField (15);
    t6 = new JTextField (15);
    t7 = new JTextField (15);
    
    rb1 = new JRadioButton ("Brano Musicale");
    rb2 = new JRadioButton ("Video");
    rb3 = new JRadioButton ("Ebook");
    
    gruppo = new ButtonGroup();
    
    gruppo.add(rb1);
    gruppo.add(rb2);
    gruppo.add(rb3);
      
    aggiungi = new JButton ("Aggiungi");
    aggiungi.setEnabled(false);
    importa = new JButton ("Importa ");
    importa.setEnabled(false);
    annulla = new JButton ("Annulla");

    aggiungiAlPannello();
    
    brano = false;
    video = false;
    ebook = false;
  
    fc = new JFileChooser();
    fc.setCurrentDirectory(new File ("."));
    fc.setMultiSelectionEnabled(true);
       
    rb1.addActionListener(this);
    rb2.addActionListener(this);
    rb3.addActionListener(this);
    annulla.addActionListener(this);
    aggiungi.addActionListener(this);
    importa.addActionListener(this);
   
    
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
   *  gridwidth : setta quante colonne occupa l'elemento 
   *              (REMAINDER occupa spazio fino alla fine)
   * 
   * E' privata perchè serve solo per non appesantire il costruttore.
   */
  private void aggiungiAlPannello ()
  {
    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    
    c.gridx = 0; c.gridy = 0; c.ipadx = 80; 
    c.fill = GridBagConstraints.HORIZONTAL;
    add(rb1,c);
    c.gridx = 3 ; 
    add(rb2,c);
    c.gridx = 6; 
    add(rb3,c);

    c.gridx =0; c.gridy = 1; c.gridwidth= GridBagConstraints.REMAINDER;
    add(l1,c);
    c.gridx = 3;
    add(t1,c);
    c.gridx =0; c.gridy = 2;
    add(l2,c);
    c.gridx = 3;
    add(t2,c);
    c.gridx =0; c.gridy = 3;
    add(l3,c);
    c.gridx = 3; 
    add(t3,c);
    c.gridx =0; c.gridy = 4;
    add(l4,c);
    c.gridx = 3; 
    add(t4,c);
    c.gridx =0; c.gridy = 5;
    add(l5,c);
    c.gridx = 3;
    add(t5,c);
    c.gridx =0; c.gridy = 6;
    add(l6,c);
    c.gridx = 3; 
    add(t6,c);
    c.gridx = 0; c.gridy = 7;
    add(l7,c);
    c.gridx = 3;
    add(t7,c);

    c.gridx = 0; c.gridy = 8; c.gridwidth= 1;
    add(aggiungi,c);
    c.gridx = 3; 
    add(importa,c);
    c.gridx = 6;
    add(annulla,c);
    
  }
  
  /**
   * Determina cosa succede quando si scatena un evento nel PannelloAggiungi.
   * 
   * Finchè nessuno radio button è premuto, il bottone aggiungi 
   * e quello importa non sono premibili.
   * 
   * In base a quale radio button si preme alcuni
   * campi di inserimento diventano inutilizzabili.
   * 
   * Quando si preme  viene creato un dato oggetto, in base al radio
   * button premuto e al corrispondente booleano e viene aggiunto alla 
   * libreria, dopodichè viene chiusa la frame.
   * 
   * Quando si preme importa viene aperto un FileChooser che permette di 
   * importare più di un elemento senza dover specificare tutti i dati.
   * 
   * Quando si preme annulla viene chiusa la frame in cui il pannello
   * è contenuto.
   */
  
  public void actionPerformed(ActionEvent e) 
  {
    Object sorgente = e.getSource();
    FileMultimediale fm = null;
        

    if(sorgente == rb1) // BRANO MUSICALE
    {
      brano = true; ebook = false; video = false;
      
      aggiungi.setEnabled(true);
      importa.setEnabled(true);
      
      filtro = new FileNameExtensionFilter("File Mp3", "mp3");
      fc.setFileFilter(filtro);
      
      t5.setEditable(true);
      t6.setEditable(true);
      t7.setEditable(false);
      
    }
    else if(sorgente == rb2)// VIDEO
    {
      brano = false; ebook = false; video = true;
      
      aggiungi.setEnabled(true);
      importa.setEnabled(true);
      
      filtro = new FileNameExtensionFilter("File Video", "avi", "mpeg","flv");
      fc.setFileFilter(filtro);
      
      t5.setEditable(true);
      t6.setEditable(false);
      t7.setEditable(false);
      
    }
    else if (sorgente == rb3)// EBOOK
    {
      brano = false; ebook = true; video = false;
            
      aggiungi.setEnabled(true);
      importa.setEnabled(true);
      
      filtro = new FileNameExtensionFilter("Ebook", "pdf");
      fc.setFileFilter(filtro);
      
      t5.setEditable(false);
      t6.setEditable(false);
      t7.setEditable(true);
      
    }
    else if (sorgente == aggiungi) // AGGIUNGI
    {

      String percorso = t1.getText();
      String titolo = t2.getText();
      String autore = t3.getText();
      int anno=0;
      int durata=0;
      int frequenza=0;
      int pagine=0;
      
      try
      {
        anno = Integer.parseInt(t4.getText());
      }
      catch( NumberFormatException nfe)
      {
        JOptionPane.showMessageDialog(this,"Errore,Anno non inserito",
                                      "Inserire anno",
                                      JOptionPane.ERROR_MESSAGE);
      }
      
      if (brano) //aggiungi un brano
      {        
        if(!percorso.contains(".") || 
           (percorso.contains(".") && 
           !((percorso.substring(percorso.lastIndexOf("."),
                               percorso.length())).equals(".mp3"))) )
        {
          JOptionPane.showMessageDialog(this,
                                        "Errore,tipo di file non supportato",
                                        "File non supportato",
                                        JOptionPane.ERROR_MESSAGE);
        }
        else{
          try
          {
            durata = Integer.parseInt(t5.getText());
          }
          catch( NumberFormatException nfe)
          {
            JOptionPane.showMessageDialog(this,"Errore,Duarata non inserita",
                                          "Inserire durata",
                                          JOptionPane.ERROR_MESSAGE);
          }
          try
          {
            frequenza = Integer.parseInt(t6.getText());
            
            //se non ci sono stati problemi
            fm=new BranoMusicale(percorso, titolo, autore, anno, 
                                 durata, frequenza);
            lib.Aggiungi(fm);
          }
          
          catch( NumberFormatException nfe)
          {
            JOptionPane.showMessageDialog(this,"Errore,Frequenza non inserita",
                                          "Inserire frequenza",
                                          JOptionPane.ERROR_MESSAGE);
          }      
        }
      }
      else if (video) //aggiungi un video
      {
        try
        {
          durata = Integer.parseInt(t5.getText());
          
          //se non ci sono stati problemi
          fm = new Video (percorso, titolo, autore, anno, durata);
          lib.Aggiungi(fm);
        }
        catch( NumberFormatException nfe)
        {
          JOptionPane.showMessageDialog(this,"Errore,Duarata non inserita",
                                        "Inserire durata",
                                        JOptionPane.ERROR_MESSAGE);
        }
        
      }
      else if (ebook) //aggiungi un ebook
      {
        try
        {
          pagine = Integer.parseInt(t7.getText());
          
          //se non ci sono stati problemi
          fm = new EBook (percorso, titolo, autore, anno, pagine);
          lib.Aggiungi(fm);
        }
        catch( NumberFormatException nfe)
        {
          JOptionPane.showMessageDialog(this,"Errore,Numero pag non inserito",
                                        "Inserire numero pagine",
                                        JOptionPane.ERROR_MESSAGE);
        }
        
      }

      tabella.revalidate();
      chiudiFinestra();
      
    }
    else if (sorgente == importa) // IMPORTA
    {
      int returnVal = fc.showOpenDialog(PannelloAggiungi.this);
      if (returnVal == JFileChooser.APPROVE_OPTION) 
      {
        File files [] = fc.getSelectedFiles();
        
        if(brano)
        {
          for(int i=0; i<files.length; i++)
          {
            fm=new BranoMusicale(files[i]+"", files[i].getName(), "", 0, 0, 0);
            lib.Aggiungi(fm);
          }
          
        }
        else if (video)
        {
          for(int i=0; i<files.length; i++)
          {
            fm = new Video (files[i]+"", files[i].getName(), "", 0, 0);
            lib.Aggiungi(fm);
          }
          
        }
        else if (ebook)
        {
          for(int i=0; i<files.length; i++)
          {
            fm = new EBook (files[i]+"", files[i].getName(), "", 0, 0);
            lib.Aggiungi(fm);
          }
        }
      
        tabella.revalidate();
        chiudiFinestra();
      }
    }
    else if (sorgente == annulla) // ANNULLA
    {
      chiudiFinestra();
    }
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
