package 操作系统课程设计GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class MainPanel {
	static {
		 GUINM();		  
	}
	public static void GUINM() {
	   	 try {
	   		 UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
	   		// UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceFieldOfWheatLookAndFeel");
			//UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	public static JFrame f= new JFrame();
	public static JPanel pm1 = new JPanel();
	public static JPanel pm2 = new JPanel();
    public static JLayeredPane  p = new JLayeredPane();
    public static JButton fifo = new JButton("FIFO");
    public static JButton lru = new JButton("LRU");
    public static JButton clock = new JButton("CLOCK");
    public static JButton nur = new JButton("NUR");
	public static void showpanel() {
		button();
		f.setSize(670, 400);
		f.setLayout(new BorderLayout());
		pm1.setLayout(new BorderLayout());
		JLabel img = new JLabel();
		ImageIcon czxt = new ImageIcon("D:\\Documents\\Downloads\\czxt.jpg");
		img.setIcon(czxt);
		pm2.setLayout(new GridLayout(4,1));
		pm1.add(img);
		pm1.setBounds(0,0 , 600, 370);
		pm2.setBounds(0,0 , 600, 370);
		
		pm2.add(fifo);
		pm2.add(lru);
		pm2.add(clock);
		pm2.add(nur);
	
		FIFOListener fifolistener = new FIFOListener();
		ClockListener clocklistener = new ClockListener();
		LRUListener lrulistener = new LRUListener();
		NURListener nrulistener = new NURListener();
		fifo.addActionListener(fifolistener);
		clock.addActionListener(clocklistener);
		lru.addActionListener(lrulistener);
		nur.addActionListener(nrulistener);
		f.add(pm1);
		f.getContentPane().add(pm2,BorderLayout.WEST);
		f.setLocation(300, 300);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void button() {
		 ImageIcon pfifo = new ImageIcon("D:\\Documents\\Downloads\\ubuntu.jpg");	
		 fifo.setIcon(pfifo);
		 fifo.setVerticalTextPosition(JButton.BOTTOM);
		 fifo.setHorizontalTextPosition(JButton.CENTER);
		 fifo.setBounds(10, 10, 10, 10);
		 ImageIcon plru = new ImageIcon("D:\\Documents\\Downloads\\centos.jpg");	
		 lru.setIcon(plru);
		 lru.setVerticalTextPosition(JButton.BOTTOM);
		 lru.setHorizontalTextPosition(JButton.CENTER);
		 ImageIcon pclock = new ImageIcon("D:\\Documents\\Downloads\\redhat.jpg");	
		 clock.setIcon(pclock);
		 clock.setVerticalTextPosition(JButton.BOTTOM);
		 clock.setHorizontalTextPosition(JButton.CENTER);
		 ImageIcon pnur = new ImageIcon("D:\\Documents\\Downloads\\MacOS.png");	
		 nur.setIcon(pnur);
		 nur.setVerticalTextPosition(JButton.BOTTOM);
		 nur.setHorizontalTextPosition(JButton.CENTER);
	}
	 public static void main(String[] args) {
		
		 showpanel();
	}
	 
	 
	

}
