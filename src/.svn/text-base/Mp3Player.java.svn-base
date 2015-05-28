/**
 * @file
 * Classe Mp3Player.
 * 
 * Frame che contiene il lettore Mp3, estende JFrame e implementa
 * un WindowListener.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Desktop.*;

public class Mp3Player extends JFrame implements WindowListener
{
  private FileMultimediale fm ; /**<FileMultimediale da riprodurre*/
  private PannelloPlayer p; /**< Pannello della frame*/
  
  /**
   * Costruttore della classe Mp3Player.
   * 
   * @param fm FileMultimediale da riprodurre.
   */
  public Mp3Player (FileMultimediale fm)
  {
    super("Mp3 Player");
    this.fm = fm;
    
    p = new PannelloPlayer (fm);
    this.add(p);
    
    this.setBounds(300,200,500,150);
    this.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
    this.addWindowListener(this);
  }
  
  /**
   * Gestisce l'uscita dalla frame.
   */
    public void windowClosing(WindowEvent we)
  { 
      p.Esci();

  }
  public void windowDeactivated(WindowEvent e){}
  public void windowActivated(WindowEvent e){}
  public void windowDeiconified(WindowEvent e){}
  public void windowIconified(WindowEvent e){}
  public void windowOpened(WindowEvent e){}
  public void windowClosed(WindowEvent e){}
  
}