package AProgramme1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AVersuch1
//extends JWindow
extends JFrame
implements ActionListener, KeyListener
{
	  private static final long serialVersionUID = 1L;
	  
	  public static int Zähler = 0;
	  public JPanel Platte;
	  private int x = 78;// y = 50;
	  private int Strecke;
	  private int Strecke2;
	  private Graphics Grafik;
	  private Image[] Bild = new Image[18];
	  private String[] Bilder = {"Agnes.png", "Onno.png", "Box1.png", "Box2.png","Peng1.png",
			  					"Peng2.png", "Sieg.png", "Verloren.png", "Matheheft1.png",
			  					"Labyrinth1.PNG", "Mama.png", "Klavier.png", "Noten.png", 
			  					"Rennbahn.PNG", "Labyrinth2.PNG", "Pfeil.png", "Nochmal.png",
			  					"Haus.png"};
	  final String Pfad = "G:\\Informatik\\Testfiles\\Testbilder\\Boxen\\";
	  private JButton[] AOKnopf = new JButton[2];
	  private String[] AOText = {"Agnes", "Onno"};
	  private Image AOBild;
	  private String AOBilder;
	  private String Spieler;
	  private Image[] FBild = new Image[5];
	  private String[] FBilder = {"F1.png", "F2.png", "F3.png", "F4.png", "F5.png"};
	  private int AgMenge, OnMenge;
	  private int Zahl1;
	  private int Zahl2;
	  private int ZOperator;
	  private int Ergebnis;
//	  private int Operator2;
	  private String Operator;
	  private String Eingabe;
	  private String Ergebnis2;
//	  private int Aufgabe;
	  private String Aufgabe;
	  private String StrZahl1;
	  private String StrZahl2;
	  private int Punkte;
	  private String StrPunkte;
	  private String Note;
//	  private String Nr;
	  private JButton[] L1Button = new JButton[3];
	  private JButton[] FButton = new JButton[5];
	  private String[] FText = {"Pascal", "Uschi", "Inge", "Robert", "Sascha"};
	  private String Freund;
	  private String F2Bilder;
	  private Image F2Bild;
	  private JButton[] L2Button = new JButton[3];
	  private String[] NText = {"FAFDHAFF", "FAFDHGFF", "GAGDHAFG", "GAGDHGFG"};
	  private String NText1 = "";
	  private JButton[] KButton = new JButton[7];
	  private String[] KBText = {"C", "D", "E", "F", "G", "A", "H"};
	  private int AOBreite;
	  private int FBreite;
	  private String[] FBRText = {"196", "200", "167", "196", "200"};
	  private int FHoehe;
	  private String[] FHText = {"185", "177", "198", "196", "146"};
	  private String StrFHoehe;
	  private String StrFBreite;
	  private int WZufall;
	  private int AOHoehe;
	  public static int xMenge1 = 78;
	  public static int xMenge2 = 78;
	  private JButton[] SLButton = new JButton[4];
	  private JLabel SAnzeige;
	  private String[] SBilder = {"vor1.png", "rückwerts1.png", "rechts1.png", "links1.png"};     //immer ...1.png
	  private String[] SText = {"VOR", "RECHTS", "VOR", "VOR", "RECHTS", "VOR", "LINKS", "VOR", "LINKS", "LINKS",
			  					"VOR", "RECHTS", "RÜCKWERTS", "RÜCKWERTS", "LINKS", "LINKS", "RÜCKWERTS", "RECHTS",
			  					"RÜCKWERTS", "RECHTS", "RECHTS", "RECHTS", "RÜCKWERTS", "LINKS", "LINKS", "LINKS",
			  					 "RÜCKWERTS", "RÜCKWERTS", "RECHTS", "VOR"};
	  public static int SMenge = 0;
	  private String SText2;
	  private int YMenge = 500;
	  private int XMenge3 = 400;
	  
	  private JPanel Platte2;
	  private JProgressBar Fortschritt;
	  private JButton Ende;
//	  private JButton NSB;
	  public static int Feld = 1;
	  public static int value = 0;
	  	
	 
	public AVersuch1() 
	{
//		super("");
		createComponents();
		collectImages ();
	}
	
	public void createComponents()	
	{
		System.out.println("CC");
				
		Platte = new JPanel ();
		Platte.setFocusable(true);
		Platte.addKeyListener(this);
		Platte.setBackground (Color.black);
	    Platte.setLayout (null);
	    Platte.setVisible(true);
	    setContentPane (Platte);
		
	    for (int i = 0; i < 2; i++)
	    {
	    	AOKnopf[i] = new JButton (AOText[i]);
	    	AOKnopf[i].addActionListener (this);
	    	Platte.add (AOKnopf[i]);
	    }
	    AOKnopf[0].setBounds(300, 200, 200, 50);
	    AOKnopf[1].setBounds(700, 200, 200, 50);
	    
	    for(int i = 0; i < 3; i++)
	    {
	    	L1Button[i] = new JButton();
	    	L1Button[i].addActionListener(this);
	    	L1Button[i].setIcon(new ImageIcon(Pfad+Bilder[15]));
	    	L1Button[i].setBorderPainted(false);
	    	L1Button[i].setVisible(false);
	    	Platte.add(L1Button[i]);
	    }
	    L1Button[0].setBounds(310, 620, 39, 53);
	    L1Button[1].setBounds(610, 620, 39, 53);
	    L1Button[2].setBounds(910, 620, 39, 53);
	    
	    for(int i = 0; i < 3; i++)
	    {
	    	L2Button[i] = new JButton();
	    	L2Button[i].addActionListener(this);
	    	L2Button[i].setIcon(new ImageIcon(Pfad+Bilder[15]));
	    	L2Button[i].setBorderPainted(false);
	    	L2Button[i].setVisible(false);
	    	Platte.add(L2Button[i]);
	    }
	    L2Button[0].setBounds(235, 637, 39, 53);
	    L2Button[1].setBounds(510, 637, 39, 53);
	    L2Button[2].setBounds(775, 637, 39, 53);
	    
	    for(int i = 0; i < 5; i++)
	    {
	    	FButton[i] = new JButton();
	    	FButton[i].addActionListener(this);
	    	FButton[i].setIcon(new ImageIcon(Pfad + FBilder[i]));
	    	FButton[i].setBorderPainted(false);
	    	FButton[i].setVisible(false);
	    	Platte.add(FButton[i]);
	    }
	    FButton[0].setBounds(300, 100, 196, 185);
	    FButton[1].setBounds(500, 100, 200, 177);
	    FButton[2].setBounds(700, 100, 167, 198);
	    FButton[3].setBounds(400, 400, 196, 196);
	    FButton[4].setBounds(600, 400, 200, 146);
	    
	    for(int i = 0; i < 7; i++)
	    {
	    	KButton[i] = new JButton();
	    	KButton[i].addActionListener(this);
	    	KButton[i].setBackground(Color.white);
	    	KButton[i].setToolTipText(KBText[i]);
	    	KButton[i].setVisible(false);
	    	Platte.add(KButton[i]);
	    }
	    KButton[0].setBounds(547, 327, 15, 53);
	    KButton[1].setBounds(568, 327, 15, 53);
	    KButton[2].setBounds(589, 327, 15, 53);				//x+23
	    KButton[3].setBounds(610, 327, 15, 53);
	    KButton[4].setBounds(631, 327, 15, 53);
	    KButton[5].setBounds(652, 327, 15, 53);
	    KButton[6].setBounds(673, 327, 15, 53);
	    	    
	    for(int i = 0; i < 4; i++)
	    {
	    	SLButton[i] = new JButton();
	    	SLButton[i].addActionListener(this);
	    	SLButton[i].setIcon(new ImageIcon(Pfad + SBilder[i]));
	    	SLButton[i].setBorderPainted(false);
	    	SLButton[i].setContentAreaFilled(false);
	    	SLButton[i].setVisible(false);
	    	Platte.add(SLButton[i]);
	    }
//	    SLButton[0].setBounds(800, 200, 120, 120);//vor
//	    SLButton[1].setBounds(800, 400, 120, 120);//rück
//	    SLButton[2].setBounds(900, 300, 120, 120);//rechts
//	    SLButton[3].setBounds(700, 300, 120, 120);//links
	    
	    SLButton[0].setBounds(1000, 200, 120, 120);//vor
	    SLButton[1].setBounds(1000, 400, 120, 120);//rück
	    SLButton[2].setBounds(1100, 300, 120, 120);//rechts
	    SLButton[3].setBounds(900, 300, 120, 120);//links	    
	
//	    SPanel1 = new JPanel();
////	    SPanel1.setPreferredSize(new Dimension());
//	    SPanel1.s
	    
	    SAnzeige = new JLabel("");
	    SAnzeige.setFont (new Font ("Arial", Font.PLAIN, 20));
	    SAnzeige.setBackground(Color.black);
	    SAnzeige.setForeground(Color.white);
//	    SAnzeige.setVisible(false);
	    Platte.add(SAnzeige);
	    SAnzeige.setBounds(450, 10, 500, 50);
	    
	    Platte2 = new JPanel();
	    Platte2.addKeyListener(this);
	    Platte2.setBackground (Color.black);
		Platte2.setLayout(null);
		Platte2.setVisible(false);
	    	
		Ende = new JButton();
		Ende.addActionListener(this);
		Ende.setIcon(new ImageIcon(Pfad + "Ende.png"));
		Ende.setBorderPainted(false);
    	Ende.setContentAreaFilled(false);
		Platte2.add(Ende);
		Ende.setBounds(1100, 10, 144, 144);
		
		Fortschritt = new JProgressBar(JProgressBar.HORIZONTAL, 0, 7);
//		Fortschritt.setStringPainted(true);
		Platte2.add(Fortschritt);
		Fortschritt.setBounds(100, 650, 800, 20);
//		return;
		
	    Platte.requestFocus();
	}
		
	public void collectImages ()
	{
		Toolkit Werkzeug = Toolkit.getDefaultToolkit();
	    MediaTracker Transporter = new MediaTracker (this);
	    for (int i = 0; i <= 17; i++)
	    {
	      Bild[i] = Werkzeug.getImage 
	       (Pfad + Bilder[i]);
	      Transporter.addImage (Bild[i], i);
	      try
	      {
	        Transporter.waitForID (i);
	      }
	      catch (InterruptedException x)
	      {
	        System.out.println("Bildstörung");
	      }
	    }
	    for (int i = 0; i <= 4 ; i++)
	    {
	    	FBild[i] = Werkzeug.getImage 
		    (Pfad + FBilder[i]);
		    Transporter.addImage (FBild[i], i);
		    try
		    {
		      Transporter.waitForID (i);
		    }
		    catch (InterruptedException x)
		    {
		    	System.out.println("Bildstörung");
		    }
	    }
	    AOBild = Werkzeug.getImage 
		(Pfad + AOBilder);
		Transporter.addImage (AOBild, 1);
		try
		{
		  Transporter.waitForID (1);
		}
		catch (InterruptedException x)
		{
			System.out.println("Bildstörung");
		}
	    
	    F2Bild = Werkzeug.getImage 
	    (Pfad + F2Bilder);
	    Transporter.addImage (F2Bild, 1);
	    try
	    {
	      Transporter.waitForID (1);
	    }
	    catch (InterruptedException x)
	    {
	    	System.out.println("Bildstörung");
	    }
	    
	    return;
	}
		
	public void moveImage1 (int xM, int Breite, int Hoehe)
	  {
	    Strecke = getWidth ();
	    System.out.println("moveI1");
//	    for (int i = x-1; i < Strecke-xBreite-x-1; i++)
//	    {
	      Grafik.copyArea (xM, 140, Breite, Hoehe, 1, 0);
	      try
	      {
	        Thread.sleep (10);
	      }
	      catch (InterruptedException x)
	      {
	    	  System.out.println("Schlafstörung");
	      }
	      xMenge1++;
	      return;
//	      Zähler = 7;
//	      Steuerung();
//	    }
	  }
	public void moveImage2 (int xM, int Breite, int Hoehe)
	  {
		System.out.println("moveI2");
	   
//	    for (int i = x-1; i < Strecke-xBreite-x-1; i++)
//	    {
	      Grafik.copyArea (xM, 417, Breite, Hoehe, 1, 0);
	      try
	      {
	        Thread.sleep (10);
	      }
	      catch (InterruptedException x)
	      {
	    	  System.out.println("Schlafstörung");
	      }
	      xMenge2++;
	      return;
//	      Zähler = 7;
//	      Steuerung();
//	    }
	  }
	public void moveImageVOR (int Start, int Ziel, int X, int Y, int Breite, int Hoehe)
	  {
		System.out.println("moveIVOR");
		Strecke = getWidth();
		for (int i = Start; i < Ziel; i++)
	    {
		  Grafik = getGraphics();
		  Grafik.drawImage(AOBild, XMenge3, YMenge, null);
	      Grafik.copyArea (X, Y, Breite, Hoehe, 0, -1);
	      try
	      {
	        Thread.sleep (10);
	      }
	      catch (InterruptedException x)
	      {
	    	  System.out.println("Schlafstörung");
	      }
	      YMenge--;
	    }
		return;
	  }	  
	public void moveImageRÜCK (int Start, int Ziel, int X, int Y, int Breite, int Hoehe)
	  {
		System.out.println("moveIRÜCK");
		Strecke = getWidth();
		for (int i = Start; i < Ziel; i++)
	    {
		  Grafik = getGraphics();
		  Grafik.drawImage(AOBild, XMenge3, YMenge, null);
	      Grafik.copyArea (X, Y, Breite, Hoehe, 0, 1);
	      try
	      {
	        Thread.sleep (10);
	      }
	      catch (InterruptedException x)
	      {
	    	  System.out.println("Schlafstörung");
	      }
	      YMenge++;
	    }
		return;
	  }	  
	public void moveImageRE (int Start, int Ziel, int X, int Y, int Breite, int Hoehe)
	  {
		System.out.println("moveIRE");
		Strecke = getWidth();
		for (int i = Start; i < Ziel; i++)
	    {
		  Grafik = getGraphics();
		  Grafik.drawImage(AOBild, XMenge3, YMenge, null);
	      Grafik.copyArea (X, Y, Breite, Hoehe, 1, 0);
	      try
	      {
	        Thread.sleep (10);
	      }
	      catch (InterruptedException x)
	      {
	    	  System.out.println("Schlafstörung");
	      }
	      XMenge3++;
	    }
		return;
	  }	  
	public void moveImageLI (int Start, int Ziel, int X, int Y, int Breite, int Hoehe)
	  {
		System.out.println("moveILI");
		Strecke = getWidth();
		for (int i = Start; i < Ziel; i++)
	    {
		  Grafik = getGraphics();
		  Grafik.drawImage(AOBild, XMenge3, YMenge, null);
	      Grafik.copyArea (X, Y, Breite, Hoehe, -1, 0);
	      try
	      {
	        Thread.sleep (10);
	      }
	      catch (InterruptedException x)
	      {
	    	  System.out.println("Schlafstörung");
	      }
	      XMenge3--;
	    }
		return;
	  }	
	
	
//	  public void moveImage (int Nr, int xDiff)
//	  {
//	    Strecke = getWidth ();
//	    int xStart = x - xDiff*4;
//	    int xZiel  = Strecke/2/xDiff;
//	    for (int i = xStart; i < xZiel; i++)
//	    {
//	      if (Nr == 2) Nr = 6; else Nr = 2;
//	      try
//	      {
//	        Thread.sleep (10);
//	      }
//	      catch (InterruptedException x)
//	      {
//	        setTitle ("Schlafstörung");
//	      }
//	    }
//	    showImage (1, 5*xZiel);
//	  }

		
	public void Steuerung()
	{
		System.out.println("Steuerung");
//		Platte.removeAll();
		Platte.getGraphics().fillRect(0, 0, 2000, 2000);
		Platte.setFocusable(true);
		repaint();
		
		if(Zähler == 0)
		Anfang();
		if(Zähler == 1)
		Boxen();
		if(Zähler == 2)
		BAuswertung();
		if(Zähler == 3)
		Mathe();
		if(Zähler == 4)
		Labyrinth1();
		if(Zähler == 5)
		Klavier();
		if(Zähler == 6)
		Freund();
		if(Zähler == 7)
		Wettrennen();
		if(Zähler == 8)
		WAuswertung();
		if(Zähler == 9)
		Sport();
		if(Zähler == 10)
		Labyrinth2();
		if(Zähler == 11)
		System.exit(0);
	}
	
	private void Anfang()
	{
		System.out.println("Anfang");
		createComponents();
	}
	
	private void Boxen()
	{
		System.out.println("Boxen");
		
//		System.out.println("Spieler = " + Spieler);
		Grafik = getGraphics();
		Grafik.drawImage (AOBild, 400, 430, null);
		
		Grafik = getGraphics();		
		Grafik.drawImage (Bild[2], 400, 200, null);
		Grafik.drawImage (Bild[3], 600, 200, null);
//		try{Thread.sleep (1000);}
//	    catch (InterruptedException x){}
		int Zufall;
		for(int i = 0; i < 10; i++)
		{
			Zufall = (int)(Math.random()*2);
			if(Zufall == 0)
			{
				AgMenge++;
				Grafik = getGraphics();
				Grafik.drawImage (Bild[4], 400, 200, null);
				try{Thread.sleep (300);}
			    catch (InterruptedException x){}
			    Grafik = getGraphics();
				Grafik.drawImage (Bild[2], 400, 200, null);
			}
			if(Zufall == 1)
			{
				OnMenge++;
				Grafik = getGraphics();
				Grafik.drawImage (Bild[5], 600, 200, null);
				try{Thread.sleep (300);}
			    catch (InterruptedException x){}
			    Grafik = getGraphics();
				Grafik.drawImage (Bild[3], 600, 200, null);				
			}
				
		}
		System.out.println("AG: " + AgMenge);
		System.out.println("ON: " + OnMenge);
		value = (value >= 7 ? 0 : value + 1);
		 Fortschritt.setValue(value);
		Zähler = 2;
    	Steuerung();
		
	}
	private void BAuswertung()
	{
		System.out.println("BAuswertung");
		if(Spieler.equals("Agnes"))
		{
			if(AgMenge > OnMenge)
			{
				Grafik = getGraphics();
				Grafik.drawImage (Bild[6], 500, 275, null);
				try{Thread.sleep (2000);}
			    catch (InterruptedException x){}
			    Zähler = 3;																	
			}
			if(AgMenge < OnMenge)
			{
				Grafik = getGraphics();
				Grafik.drawImage (Bild[7], 500, 275, null);
				try{Thread.sleep (2000);}
			    catch (InterruptedException x){}
			    Zähler = 4;																																	
			}
			if(AgMenge == OnMenge)
			{
				JOptionPane.showMessageDialog(null, "Du must noch eine Runde spielen!", "Gleichstand", 1);
				Zähler = 1;
			}
		}
		if(Spieler.equals("Onno"))
		{
			if(AgMenge < OnMenge)
			{
				Grafik = getGraphics();
				Grafik.drawImage (Bild[6], 500, 275, null);
				try{Thread.sleep (2000);}
			    catch (InterruptedException x){}
			    Zähler = 3;
			}
			if(AgMenge > OnMenge)
			{
				Grafik = getGraphics();
				Grafik.drawImage (Bild[7], 500, 275, null);
				try{Thread.sleep (2000);}
			    catch (InterruptedException x){}
			    Zähler = 4;
			}
			if(AgMenge == OnMenge)
			{
				JOptionPane.showMessageDialog(null, "Du must noch eine Runde spielen!", "Gleichstand", 1);
				Zähler = 1;
			}
		}
		
		Steuerung();
	}
	private void Mathe()
	{
		System.out.println("Mathe");
		
		Grafik = getGraphics();
		Grafik.drawImage (Bild[8], 150, 50, null);
		
		for(int i = 0; i < 10; i++)
		{
			Zahl1 = (int)(Math.random()*1000)+1;
			Zahl2 = (int)(Math.random()*1000)+1;
			ZOperator = (int)(Math.random()*4);
			if(ZOperator == 0)
			{
				Operator = "+";
				Ergebnis = Zahl1 + Zahl2;
			}
			if(ZOperator == 1)
			{
				Operator = "-";
				Ergebnis = Zahl1 - Zahl2;
			}
			if(ZOperator == 2)
			{
				Operator = "*";
				Ergebnis = Zahl1 * Zahl2;
			}
			if(ZOperator == 3)
			{
				Operator = "/";
				Ergebnis = Zahl1 / Zahl2;
			}
//			Operator2 = Integer.parseInt(Operator);
			StrZahl1 = Integer.toString(Zahl1);
			StrZahl2 = Integer.toString(Zahl2);
			Aufgabe = StrZahl1 + Operator + StrZahl2;
			Ergebnis2 = Integer.toString(Ergebnis);
			Eingabe = JOptionPane.showInputDialog(Aufgabe);
//			Nr = Integer.toString(i);
			if(Eingabe.equals(Ergebnis2))
			{
				JOptionPane.showMessageDialog(null, "RICHTIG");
				Punkte++;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "FALSCH");
			}
//			System.out.println(Zahl1 + Operator2 + Zahl2);
			System.out.println(StrZahl1 + Operator + StrZahl2);
			System.out.println(Aufgabe);
			System.out.println(Ergebnis);
		}
				
		if(Punkte == 10)Note = "1";
		if((Punkte == 9)||(Punkte == 8))Note = "2";
		if((Punkte < 8)&&(Punkte > 5))Note = "3";
		if((Punkte < 6)&&(Punkte > 3))Note = "4";
		if((Punkte == 3)||(Punkte == 2))Note = "5";
		if((Punkte == 1)||(Punkte == 0))Note = "6";
		StrPunkte = Integer.toString(Punkte);
		JOptionPane.showMessageDialog(null, "Note: " + Note, StrPunkte + "/10  Punkte", 1);
		
		value = (value >= 7 ? 0 : value + 1);
		 Fortschritt.setValue(value);
		Zähler = 5;
    	Steuerung();
	}
	private void Labyrinth1()
	{
		System.out.println("Labyrinth1");
		
		Grafik = getGraphics();
		Grafik.drawImage (Bild[9], 175, 100, null);
		Grafik = getGraphics();
		Grafik.drawImage (Bild[10], 570, 1, null);
		try{Thread.sleep (5000);}
	    catch (InterruptedException x){}
	    for(int i = 0; i < 3; i++)
	    {
	    	L1Button[i].setVisible(true);
	    }
//	    value = (value >= 7 ? 0 : value + 1);
//		 Fortschritt.setValue(value);
//		Zähler = 5;
//    	Steuerung();
	}
	private void Klavier()
	{
		System.out.println("Klavier");
		Grafik = getGraphics();
		Grafik.drawImage (Bild[11], 500, 275, null);											
		Grafik = getGraphics();
		Grafik.drawImage (Bild[12], 560, 200, null);
		try{Thread.sleep (3000);}
	    catch (InterruptedException x){}
	    for(int i = 0; i < 7; i++)
	    {
	    	KButton[i].setVisible(true);
	    	
	    }
//	    value = (value >= 7 ? 0 : value + 1);
//		 Fortschritt.setValue(value);
	}
	private void Freund()
	{
		System.out.println("Freund");
		
		for(int i = 0; i < 5; i++)
		{
			FButton[i].setVisible(true);
		}
//		value = (value >= 7 ? 0 : value + 1);
//		 Fortschritt.setValue(value);
	}
	private void Wettrennen()
	{
		System.out.println("Wettrennen");
		Platte.getGraphics().drawImage (Bild[13], 30, 50, null);
		Grafik = getGraphics();
		Grafik.drawImage (AOBild, 78, 140, null);
		
		Grafik = getGraphics();
		Grafik.drawImage (F2Bild, 78, 417, null);
		Strecke = getWidth ();
		Strecke2 = getWidth ();
		for (int i = x-1; i < Strecke+AOBreite+350 || i < Strecke2+FBreite+350; i++)
		{
			WZufall = (int)(Math.random()*2);
			System.out.println(WZufall);
			if(WZufall == 0)
			{
				moveImage1(xMenge1, AOBreite, AOHoehe);
			}
			if(WZufall == 1)
			{
				moveImage2(xMenge2, FBreite, FHoehe);
			}
		}
		try{Thread.sleep (1000);}
	    catch (InterruptedException x){}
	    value = (value >= 7 ? 0 : value + 1);
		 Fortschritt.setValue(value);
		Zähler = 8;
    	Steuerung();
	}
	private void WAuswertung()
	{
		System.out.println("WAuswertung");
		if(xMenge1 > xMenge2)
		{
			Grafik = getGraphics();
			Grafik.drawImage (Bild[6], 500, 275, null);
			try{Thread.sleep (2000);}
		    catch (InterruptedException x){}
		}
		if(xMenge1 < xMenge2)
		{
			Grafik = getGraphics();
			Grafik.drawImage (Bild[7], 500, 275, null);
			try{Thread.sleep (2000);}
		    catch (InterruptedException x){}
		}

		Zähler = 9;	
    	Steuerung();
	}
	private void Sport()
	{
		System.out.println("Sport");
		
		for(int i = 0; i < 4; i++)
		{
			SLButton[i].setVisible(true);
		}
		
		if(SMenge < 30)
		{
			Grafik = getGraphics();
			Grafik.drawImage(AOBild, XMenge3, YMenge, null);
			try{Thread.sleep (100);}
			catch (InterruptedException x){}
			SText2 = SText[SMenge];
			SAnzeige.setText(SText2);
			System.out.println(SText2 + SMenge);
		}

		if(SMenge == 30)
		{
			for(int i = 0; i < 4; i++)
				SLButton[i].setVisible(false);
			SAnzeige.setVisible(false);
			value = (value >= 7 ? 0 : value + 1);
			 Fortschritt.setValue(value);
			Zähler = 10;
	    	Steuerung();
		}
	}
	private void Labyrinth2()
	{
		System.out.println("Labyrinth2");
		
		Grafik = getGraphics();
		Grafik.drawImage (Bild[14], 175, 100, null);
		Grafik = getGraphics();
		Grafik.drawImage (Bild[17], 550, 1, null);
		try{Thread.sleep (5000);}
	    catch (InterruptedException x){}
	    for(int i = 0; i < 3; i++)
	    {
	    	L2Button[i].setVisible(true);
	    }
	}
	
	private void HauptMenu()
	{
		System.out.println("Menü");
		Fortschritt.setValue(value);
		Platte.setVisible(false);
		Platte2.setVisible(true);
		Platte2.setFocusable(true);
		setContentPane(Platte2);
		Platte2.requestFocus();
	}
		
	public void actionPerformed(ActionEvent Event)
	{
		System.out.println("ActionListener");
		 Object Quelle = Event.getSource();
		 
		if (Quelle == AOKnopf[0]) 
		{
			
		  	Spieler = "Agnes";
		  	AOBilder = "Agnes.png";
		  	collectImages();
		  	AOBreite = 194;
		  	AOHoehe = 162;
		   	System.out.println("Spieler = " + Spieler);
		   	Grafik = getGraphics();
			Grafik.drawImage (AOBild, 400, 430, null);
			for(int i = 0; i < 2; i++)
		    {
		    	AOKnopf[i].setVisible(false);
		    }
		   	Zähler = 1;																		//	Zähler = 1;	!!!!!!!!!!!!!!!!											
		   	Steuerung();
		}
		if (Quelle == AOKnopf[1])
		{
		   	Spieler = "Onno";
		   	AOBilder = "Onno.png";
		  	collectImages();
		   	AOBreite = 182;
		   	AOHoehe = 201;
		   	System.out.println("Spieler = " + Spieler);
		   	Grafik = getGraphics();
			Grafik.drawImage (AOBild, 600, 430, null);
			
			for(int i = 0; i < 2; i++)
		    {
//				Platte.remove(AOKnopf[i]);
		    	AOKnopf[i].setVisible(false);
		    }
//			AOKnopf[0].setVisible(false);
//			AOKnopf[1].setVisible(false);
		   	Zähler = 1;
		   	Steuerung();
		}
				   
		 if ((Quelle == L1Button[0])||(Quelle == L1Button[1]))
		 {
		   	JOptionPane.showMessageDialog(null, "FALSCH");
		    for(int i = 0; i < 3; i++)
		    {
		    	L1Button[i].setVisible(false);
		    }
		    Zähler = 4;
		   	Steuerung();
		 }
		 if (Quelle == L1Button[2])
		 {
		   	JOptionPane.showMessageDialog(null, "RICHTIG");
		   	for(int i = 0; i < 3; i++)
		    {
		    	L1Button[i].setVisible(false);
		    }
		   	value = (value >= 7 ? 0 : value + 1);
			 Fortschritt.setValue(value);
		   	Zähler = 5;
		   	Steuerung();
		 }
		 
		 if ((Quelle == L2Button[0])||(Quelle == L2Button[2]))
		 {
		   	JOptionPane.showMessageDialog(null, "FALSCH");
		    for(int i = 0; i < 3; i++)
		    {
		    	L2Button[i].setVisible(false);
		    }
		    Zähler = 10;
		   	Steuerung();
		 }
		 if (Quelle == L2Button[1])
		 {
		   	JOptionPane.showMessageDialog(null, "RICHTIG");
		   	for(int i = 0; i < 3; i++)
		    {
		    	L2Button[i].setVisible(false);
		    }
		   	value = (value >= 7 ? 0 : value + 1);
			 Fortschritt.setValue(value);
		   	Zähler = 11;
		   	Steuerung();
		 } 
		 
		 for(int i = 0; i < 5; i++)
		 {
			 if (Quelle == FButton[i])
			 {
			 	Freund = FText[i];
			 	F2Bilder = FBilder[i];
			 	collectImages();
			 	StrFBreite = FBRText[i];
			 	FBreite = Integer.parseInt(StrFBreite);
			 	StrFHoehe = FHText[i];
			 	FHoehe = Integer.parseInt(StrFHoehe);
			  	JOptionPane.showMessageDialog(null, Freund, "Du hast " + Freund + " ausgewählt.", 1, new ImageIcon(Pfad + FBilder[i]));
			  	FButton[0].setVisible(false);
			  	FButton[1].setVisible(false);
			  	FButton[2].setVisible(false);
			  	FButton[3].setVisible(false);
			  	FButton[4].setVisible(false);
			  	value = (value >= 7 ? 0 : value + 1);
				 Fortschritt.setValue(value);
			   	Zähler = 7;
			   	Steuerung();
			 }
		 }
		 
		 for(int i = 0; i < 7; i++)
		 {
			 if (Quelle == KButton[i])
			 {
				 System.out.println(NText1);
				 Grafik = getGraphics();
				 Grafik.drawImage (Bild[11], 500, 275, null);											
				 Grafik = getGraphics();
				 Grafik.drawImage (Bild[12], 560, 200, null);
				 try{Thread.sleep (2000);}
				 catch (InterruptedException x){}
				 
				 NText1 = NText1 + KBText[i];
				 if((NText1.equals(NText[0]))||(NText1.equals(NText[1]))||(NText1.equals(NText[2]))||(NText1.equals(NText[3])))
				 {
					 KButton[0].setVisible(false);
					 KButton[1].setVisible(false);
					 KButton[2].setVisible(false);
					 KButton[3].setVisible(false);
					 KButton[4].setVisible(false);
					 KButton[5].setVisible(false);
					 KButton[6].setVisible(false);
					 value = (value >= 7 ? 0 : value + 1);
					 Fortschritt.setValue(value);
					 Zähler = 6;
					 Steuerung();
				}
				 else
				 {
					 Zähler = 5;
					 Steuerung();
				 }
			 }	 
		 }
				 if (Quelle == SLButton[0])
				 {
					 if((SText2.equals(SText[0]))||(SText2.equals(SText[2]))||(SText2.equals(SText[3]))||(SText2.equals(SText[5]))
							 ||(SText2.equals(SText[7]))||(SText2.equals(SText[10]))||(SText2.equals(SText[29])))
					 {
						 SMenge++;
						 Grafik = getGraphics();
						 Grafik.drawImage(AOBild, XMenge3, YMenge, null);
						 moveImageVOR(0, 100, XMenge3, YMenge, AOBreite, AOHoehe);
					 }
					 else
					 {
						 //				FALSCH
					 }
					 try{Thread.sleep (100);}
					 catch (InterruptedException x){}
					 Sport();
					 					 
				 }
				 if (Quelle == SLButton[1])
				 {
					 if((SText2.equals(SText[12]))||(SText2.equals(SText[13]))||(SText2.equals(SText[16]))||(SText2.equals(SText[18]))
							 ||(SText2.equals(SText[22]))||(SText2.equals(SText[26]))||(SText2.equals(SText[27])))
					 {
						 SMenge++;
						 Grafik = getGraphics();
						 Grafik.drawImage(AOBild, XMenge3, YMenge, null);
						 moveImageRÜCK(0, 100, XMenge3, YMenge, AOBreite, AOHoehe);
					 }
					 else
					 {
						 //				FALSCH
					 }
					 try{Thread.sleep (100);}
					 catch (InterruptedException x){}
					 Sport();
					 
				 }
				 if (Quelle == SLButton[2])
				 {
					 if((SText2.equals(SText[1]))||(SText2.equals(SText[4]))||(SText2.equals(SText[11]))||(SText2.equals(SText[17]))
							 ||(SText2.equals(SText[19]))||(SText2.equals(SText[20]))||(SText2.equals(SText[21]))||(SText2.equals(SText[28])))
					 {
						 SMenge++;
						 Grafik = getGraphics();
						 Grafik.drawImage(AOBild, XMenge3, YMenge, null);
						 moveImageRE(0, 100, XMenge3, YMenge, AOBreite, AOHoehe);
					 }
					 else
					 {
						 //				FALSCH
					 }
					 try{Thread.sleep (100);}
					 catch (InterruptedException x){}
					 Sport();
					 
				 }
				 if (Quelle == SLButton[3])
				 {
					 if((SText2.equals(SText[6]))||(SText2.equals(SText[8]))||(SText2.equals(SText[9]))||(SText2.equals(SText[14]))
							 ||(SText2.equals(SText[15]))||(SText2.equals(SText[23]))||(SText2.equals(SText[24]))||(SText2.equals(SText[25])))
					 {
						 SMenge++;
						 Grafik = getGraphics();
						 Grafik.drawImage(AOBild, XMenge3, YMenge, null);
						 moveImageLI(0, 100, XMenge3, YMenge, AOBreite, AOHoehe);
					 }
					 else
					 {
						 //				FALSCH
					 }
					 try{Thread.sleep (100);}
					 catch (InterruptedException x){}
					 Sport();
					 
				 }
				 
				 if (Quelle == Ende) 
				 {
					System.exit(0); 
				 }
				 
				 

	}
		
	public void keyTyped(KeyEvent Event) 
	{
		System.out.println("KeyListener");
		Object Quelle = Event.getSource();
		char Taste = Event.getKeyChar();
		if(Taste == KeyEvent.VK_ESCAPE) 
		{			
			if(Quelle == Platte)
			{
				HauptMenu();
			}
				
			if(Quelle == Platte2)
			{
				Platte2.setVisible(false);
				Platte.setVisible(true);
				setContentPane(Platte);
				Steuerung();				
			}
				
		}
		
//		if(Taste == KeyEvent.VK_CONTROL && Taste == KeyEvent.VK_F1){Zähler = 1;Steuerung();}
//		if(Taste == KeyEvent.VK_CONTROL && Taste == KeyEvent.VK_F2){Zähler = 2;Steuerung();}
//		if(Taste == KeyEvent.VK_CONTROL && Taste == KeyEvent.VK_F3){Zähler = 3;Steuerung();}
//		if(Taste == KeyEvent.VK_CONTROL && Taste == KeyEvent.VK_F4){Zähler = 4;Steuerung();}
//		if(Taste == KeyEvent.VK_CONTROL && Taste == KeyEvent.VK_F5){Zähler = 5;Steuerung();}
//		if(Taste == KeyEvent.VK_CONTROL && Taste == KeyEvent.VK_F6){Zähler = 6;Steuerung();}
//		if(Taste == KeyEvent.VK_CONTROL && Taste == KeyEvent.VK_F7){Zähler = 7;Steuerung();}
//		if(Taste == KeyEvent.VK_CONTROL && Taste == KeyEvent.VK_F8){Zähler = 8;Steuerung();}
//		if(Taste == KeyEvent.VK_CONTROL && Taste == KeyEvent.VK_F9){Zähler = 9;Steuerung();}
//		if(Taste == KeyEvent.VK_CONTROL && Taste == KeyEvent.VK_F10){Zähler = 10;Steuerung();}
		
	}
	
	public void keyPressed(KeyEvent Event) 
	{
		System.out.println("KeyListenerPR");
	}
	public void keyReleased(KeyEvent Event) 
	{
		System.out.println("KeyListenerRE");
	}
	
	public static void main(String[] args) 
	{
		AVersuch1 Rahmen = new AVersuch1 ();
		Rahmen.setSize (1280,768);
	    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		Rahmen.setVisible(true);
	}
}
