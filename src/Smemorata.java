/*
 * @file 
 * File contenente il main del programma.
 */

/**
 * @mainpage Smemorata
 *
 * Programma di gestione di una libreria multimediale, che cataloga 
 * file audio, video ed ebook e permette anche la loro riproduzione.
 * Inoltre è possibile attuare una ricerca nella libreria per trovare
 * uno specifico file multimediale.
 * 
 * Vedere la documentazione completa per maggiori dettagli
 * sulle classi, i metodi e l'implementazione della libreria.
 *
 * Funzione main contenuta in Smemorata.java
 *
 * @author Micaela Verucchi
 */

//-------------------------->Codice in 80 colonne <-----------------------------

import javax.swing.*;
import java.awt.*;

public class Smemorata
{
  public static void main (String args [])
  {    
    FrameLib f = new FrameLib ("Smemorata"); 
    f.setVisible (true);
  }
}