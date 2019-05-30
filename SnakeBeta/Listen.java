import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.KeyStroke;
public class Listen extends KeyAdapter
{
	public static char mander;
	public static String direction="";
	public ArrayList<Character> keysPressed=new ArrayList<Character>();
	public void keyPressed(KeyEvent event)
	{	
		
		mander =event.getKeyChar();
		if(mander=='g'||mander=='h')
		keysPressed.add(event.getKeyChar());
		if(keysPressed.contains('g')&&keysPressed.contains('h'))
		{
			
			PictureLoader.text1[31][107]="$";
			PictureLoader.text2[31][107]="$";
			
		}
		
		
		
		if(mander=='w'||event.getKeyCode()==KeyEvent.VK_UP)
		{
			if(PictureLoader.loadScreen)
			PictureLoader.direction= "UP";
			else
			{
				if(!direction.equals("UP")&&!direction.equals("DOWN"))
					PictureLoader.sleeper=PictureLoader.sleeper*2;
					direction="UP";
				PictureLoader.dirs.set(0,"UP");
			}
		}
		if(mander=='a'||event.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(PictureLoader.loadScreen)
			PictureLoader.direction= "LEFT";
			else
			{
				if(!direction.equals("LEFT")&&!direction.equals("RIGHT"))
					PictureLoader.sleeper=PictureLoader.sleeper/2;
					direction="LEFT";
				PictureLoader.dirs.set(0,"LEFT");
			}
		}
		if(mander=='s'||event.getKeyCode()==KeyEvent.VK_DOWN)
		{
			if(PictureLoader.loadScreen)
			PictureLoader.direction= "DOWN";
			else
			{
				if(!direction.equals("UP")&&!direction.equals("DOWN"))
					PictureLoader.sleeper=PictureLoader.sleeper*2;
					direction="DOWN";
				PictureLoader.dirs.set(0,"DOWN");
			}
		}
		if(mander=='d'||event.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(PictureLoader.loadScreen)
			PictureLoader.direction= "RIGHT";
			else
			{
				if(!direction.equals("RIGHT")&&!direction.equals("LEFT"))
				PictureLoader.sleeper=PictureLoader.sleeper/2;
				direction="RIGHT";
				PictureLoader.dirs.set(0,"RIGHT");
			}
		}
		if(event.getKeyCode()==KeyEvent.VK_ENTER)
		{
			if((keysPressed.contains('g')&&keysPressed.contains('h')))
			{
				Cheat amcheating = new Cheat();
				SpecialGUI.Frame.removeKeyListener(SpecialGUI.c);
			}
			PictureLoader.direction="";
			if(PictureLoader.poe.equals("play2"))
			{
				try {
					for(int i=PictureLoader.pos.size()-1;i>=0;i--)
						PictureLoader.pos.remove(i);
					for(int i=PictureLoader.dirs.size()-1;i>=0;i--)
						PictureLoader.dirs.remove(i);
					PictureLoader.sleeper=200;
					PictureLoader.loadScreen=false;
					PictureLoader.hit=false;
					PictureLoader.running=true;
					PictureLoader.win.Frame.repaint();
					PictureLoader.index=1;
					PictureLoader.score=0;
					PictureLoader.game();
					
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}
			PictureLoader.loadScreen=false;
			if(PictureLoader.poe.equals("exit"))
				System.exit(0);
		}
		
		
				
	}
	public void keyReleased(KeyEvent event)
	{
		
			keysPressed.clear();
			
				PictureLoader.text1[31][107]="0";
				PictureLoader.text2[31][107]="0";
			
		
		
	}

}
