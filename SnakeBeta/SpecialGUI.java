import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
public class SpecialGUI 
{
	public static JPanel Panel;
	public static Listen c;
	public static JFrame Frame=new JFrame();
	
	public SpecialGUI()
	{
		Frame.setTitle("SNAKE 2.0");

		Frame.setResizable(false);
		Frame.setSize(660,427);
		Frame.setLocationRelativeTo(null);
		
		Container Contents=Frame.getContentPane();
		Panel=new Special();
		Contents.add(Panel);
		Panel.setBackground(Color.BLACK);
		Runnable r1=new Runnable()
		{
			public void run()
			{
				while(true)
				{
				try {Thread.sleep(PictureLoader.sleeper);}
				catch (InterruptedException e) {e.printStackTrace();}
				Panel = new Special();	
				if(Cheat.getischeat())
				{
					Frame.removeKeyListener(c);
				}
				Frame.repaint();
				}
			}
		};
		
		
		c=new Listen();
		Frame.addKeyListener(c);
		Thread a1=new Thread(r1);
		
		a1.start();
		
		Frame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e)
		{
		System.exit(0);
		} 
		});		
	}
	
}

