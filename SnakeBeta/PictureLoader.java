import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class PictureLoader 
{
	public static String[][] fI,fI2,text1,text2,text3,text4;
	public static ArrayList <int[][]> pos=new ArrayList<int[][]>();
	public static ArrayList <String> dirs=new ArrayList<String>();
	public static int[][] posStars = new int[2][1];
	public static String direction="LEFT";
	public static SpecialGUI win;
	public static JFrame pop;
	public static JTextField b;
	public static boolean loadScreen;
	public static boolean loadEnd;
	public static boolean running=true;
	public static boolean hit=false;
	public static boolean naming=false;
	public static String poe;
	public static int score=0;
	public static int index=1;
	public static int anotheranother=1;
	public static int sleeper=200;
	public static String name="";
	public static String newName="";
	
	public static void main(String[] args)throws Exception
	{
		poe="name";
		pop = new JFrame();loadScreen=false;
		game();
		

				
				GridBagLayout layout= new GridBagLayout();
				pop.setLayout(layout);
				GridBagConstraints g= new GridBagConstraints();
				pop.setTitle("");
				pop.setSize(250,150);
				pop.setLocationRelativeTo(null);
				Container Contents=pop.getContentPane();
				Contents.setBackground(Color.BLACK);
				JLabel b1=new JLabel("Enter 3 Character ID for High Score");
				b1.setForeground(Color.WHITE);
				 g.gridwidth=3;
			        g.gridx=1;
			        g.gridy=0;
				Contents.add(b1,g);
				JLabel b2=new JLabel("Then Hit Enter");
				b2.setForeground(Color.WHITE);
				g.gridwidth=3;
		        g.gridx=1;
		        g.gridy=1;
		        Contents.add(b2,g);
				b= new JTextField("               ");
				b.setForeground(Color.WHITE);
				b.setBackground(Color.BLACK);
				b.setCaretColor(Color.WHITE);
				b.setFont(new Font("serif",Font.PLAIN,20));
				g.gridwidth=3;
				 g.gridx=1;
			     g.gridy=2;
				Contents.add(b,g);
				pop.setResizable(false);
				pop.show();
				
				b.addKeyListener(new KeyListener(){
				
					

					@Override
					public void keyPressed(KeyEvent e) 
					{
							if(e.getKeyCode()==KeyEvent.VK_ENTER)
							{
								PictureLoader.newName=PictureLoader.b.getText();
								pop.dispose();
								win = new SpecialGUI();
								win.Frame.setVisible(true);
								win.Frame.show();
							}
					}
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				pop.setVisible(true);
				
		
		
				
		
	}
		public static void game() throws FileNotFoundException
		{
//			InputStream input = getClass().getResourceAsStream("/Snake.txt");
			InputStream stream = PictureLoader.class.getResourceAsStream("/resources/Snake");
			Scanner f = null;
			try {
			 f = new Scanner (stream);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Scanner error");
			}
			
			fI= new String[32][108];
			fI2=new String[32][108];
			
			InputStream stream2 = PictureLoader.class.getResourceAsStream("/resources/load screen");
			Scanner fa = null;
			try {
			 fa = new Scanner (stream2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Scanner error");
			}
			text1= new String[32][108];
			text2= new String[32][108];
			text3= new String[32][108];
			text4= new String[32][108];
			
			
			Scanner fb = null;
			try {
			 fb = new Scanner (new File("hiscore"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Scanner error");
			}
			
			score=fb.nextInt();
			fb.nextLine();
			name=fb.nextLine();
			String a= "";
			for(int x=0;x<32;x++){a+=f.nextLine();}//string of everything
			int ind=0;
			for(int b=0;b<32;b++)//lines
			{
				for(int i=0; i<108;i++)//rows
				{
					fI[b][i]=""+a.charAt(ind);
					ind++;	
				}	
			}
			for(int b=0;b<32;b++)//lines
			{
				for(int i=0; i<108;i++)//rows
				{
					fI2[b][i]=fI[b][i];
				}	
			}
			a= "";
			for(int x=0;x<32;x++)//string of everything
			{
				a+=fa.nextLine();
			}
			ind=0;
			for(int b=0;b<32;b++)//lines
			{
				for(int i=0; i<108;i++)//rows
				{
					text1[b][i]=""+a.charAt(ind);
					ind++;	
				}	
			}
			a= "";
			ind=0;
			for(int x=0;x<32;x++){a+=fa.nextLine();}//string of everything
				for(int b=0;b<32;b++)//lines
				{
					for(int i=0; i<108;i++)//rows
					{
						text2[b][i]=""+a.charAt(ind);
						ind++;	
					}	
				}	
				a= "";
				ind=0;
				for(int x=0;x<32;x++){a+=fa.nextLine();}//string of everything
					for(int b=0;b<32;b++)//lines
					{
						for(int i=0; i<108;i++)//rows
						{
							text3[b][i]=""+a.charAt(ind);
							ind++;
						}	
					}
				a= "";
				ind=0;
				for(int x=0;x<32;x++){a+=fa.nextLine();}//string of everything
					for(int b=0;b<32;b++)//lines
					{
						for(int i=0; i<108;i++)//rows
						{
							text4[b][i]=""+a.charAt(ind);
							ind++;	
						}	
					}			
			pos.add(new int[2][1]);
			pos.get(0)[0][0]=1;
			pos.get(0)[1][0]=1;
			dirs.add("");
			dirs.add("");
			posStars[1][0]=((int) (Math.random()*30))+1;
			posStars[0][0]=((int) (Math.random()*106))+1;
			fI[posStars[1][0]][posStars[0][0]]="*";
			loadScreen=true;
				
		}
		}
		
