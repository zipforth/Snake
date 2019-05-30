import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Special extends JPanel 
{
	public void paintComponent(Graphics Gr) 
	{
		
		super.paintComponent(Gr);
		String[][] a=new String[PictureLoader.fI.length][PictureLoader.fI[0].length];
		for(int i=0;i<PictureLoader.fI.length;i++)
		{
			for(int b=0;b<PictureLoader.fI[0].length;b++)
			{
				a[i][b]=PictureLoader.fI[i][b];
			}
				
		}
		Gr.setColor(Color.LIGHT_GRAY);
		
		Gr.setFont(new Font("serif",Font.PLAIN,12));
			int x=3,y=12;	
			
		if(PictureLoader.loadScreen)	// generates menu screen
		{
			if(!PictureLoader.loadEnd)
			{
				
				if(PictureLoader.direction.equals("LEFT")||PictureLoader.direction.equals("UP"))
				{
				for(int i=0;i<PictureLoader.fI.length;i++)
				{
					for(int b=0;b<PictureLoader.fI[0].length;b++)
					{
						Gr.drawString(PictureLoader.text1[i][b]+"",x,y);
						x+=6;
					}
					x=3;
					y=y+12;
				}
				PictureLoader.poe="play";
				}
				if(PictureLoader.direction.equals("RIGHT")||PictureLoader.direction.equals("DOWN"))
				{
				for(int i=0;i<PictureLoader.fI.length;i++)
				{
					for(int b=0;b<PictureLoader.fI[0].length;b++)
					{
						Gr.drawString(PictureLoader.text2[i][b]+"",x,y);
						x+=6;
					}
					x=3;
					y=y+12;
				}
				PictureLoader.poe="exit";
				}
			}
			else
			{
				if(Cheat.getischeat())
				{
					PictureLoader.sleeper=10;
					SpecialGUI.c=new Listen();
					SpecialGUI.Frame.addKeyListener(SpecialGUI.c);
				}
				int something= PictureLoader.pos.size()-1;
				int other=something;
				if(something>PictureLoader.score)
				{
					PictureLoader.newName=PictureLoader.newName.trim();
					PictureLoader.score = something;
					if(PictureLoader.newName.length()<3)
					{
						PictureLoader.newName="IDK";
						
					}
					PictureLoader.name=PictureLoader.newName;
					try {
						
						BufferedWriter fw = new BufferedWriter(new FileWriter("hiscore"));
						fw.write(""+PictureLoader.score);
						fw.write("\n");
						fw.write(""+PictureLoader.newName.substring(0,3));
						
						fw.close();
					} catch (IOException e) {e.printStackTrace();}
				}
				int high=PictureLoader.score;
				int high2=PictureLoader.score;
				PictureLoader.text3[12][59]=""+high%10;
				high/=10;
				PictureLoader.text3[12][58]=""+high%10;
				high/=10;
				PictureLoader.text3[12][57]=""+high%10;
				high/=10;
				PictureLoader.text3[12][56]=""+high%10;
				PictureLoader.text4[12][59]=""+high2%10;
				high2/=10;
				PictureLoader.text4[12][58]=""+high2%10;
				high2/=10;
				PictureLoader.text4[12][57]=""+high2%10;
				high2/=10;
				PictureLoader.text4[12][56]=""+high2%10;
				//12 41
				PictureLoader.text3[18][78]=""+something%10;
				something/=10;
				PictureLoader.text3[18][77]=""+something%10;
				something/=10;
				PictureLoader.text3[18][76]=""+something%10;
				something/=10;
				PictureLoader.text3[18][75]=""+something%10;
				PictureLoader.text4[18][78]=""+other%10;
				other/=10;
				PictureLoader.text4[18][77]=""+other%10;
				other/=10;
				PictureLoader.text4[18][76]=""+other%10;
				other/=10;
				PictureLoader.text4[18][75]=""+other%10;
				int indices=0;
				PictureLoader.name=PictureLoader.name.toUpperCase();
				/*for(String[] dog:PictureLoader.fI)
				{
					System.out.println();
					for(String other2:dog)
					System.out.print(other2);
					
				}
				

				SpecialGUI.Frame.dispose();*/
				for(int i=63;i<69
						;i+=2)
				{
					PictureLoader.text3[12][i]=""+PictureLoader.name.charAt(indices);
					PictureLoader.text4[12][i]=""+PictureLoader.name.charAt(indices);
					indices++;
				}
		
				if(PictureLoader.direction.equals("LEFT")||PictureLoader.direction.equals("UP"))
				{a=PictureLoader.text3;
				for(int i=0;i<PictureLoader.fI.length;i++)
				{
					for(int b=0;b<PictureLoader.fI[0].length;b++)
					{
						Gr.drawString(PictureLoader.text3[i][b]+"",x,y);
						x+=6;
					}
					x=3;
					y=y+12;
				}
				PictureLoader.poe="play2";
				}
				if(PictureLoader.direction.equals("RIGHT")||PictureLoader.direction.equals("DOWN"))
				{a=PictureLoader.text4;
				for(int i=0;i<PictureLoader.fI.length;i++)
				{
				for(int b=0;b<PictureLoader.fI[0].length;b++)
				{
					Gr.drawString(PictureLoader.text4[i][b]+"",x,y);
					x+=6;
				}
				x=3;
				y=y+12;
				}
				PictureLoader.poe="exit";
				}
			}
		}
			for(int F=1;F<PictureLoader.pos.size();F++)
			{
				if(PictureLoader.pos.get(F)[1][0]==PictureLoader.pos.get(0)[1][0]
				   &&PictureLoader.pos.get(F)[0][0]==PictureLoader.pos.get(0)[0][0])
					PictureLoader.hit=true;
					
			}	
			if(PictureLoader.pos.get(0)[0][0]==0 ||PictureLoader.pos.get(0)[1][0]==0 ||
		       PictureLoader.pos.get(0)[0][0]==107 ||PictureLoader.pos.get(0)[1][0]==31||PictureLoader.hit)//"game over" screen
			{
				PictureLoader.hit=false;
				PictureLoader.loadEnd=true;
				PictureLoader.loadScreen=true;
				if(PictureLoader.running){
				PictureLoader.direction="LEFT";
				PictureLoader.running=false;
				}
			}
		else
		{
			if(Cheat.getischeat())
				PictureLoader.dirs.set(0, Cheat.nextDot(PictureLoader.fI));
			for(int Q=PictureLoader.pos.size();Q>=0;Q--)
			{
				
				if(PictureLoader.dirs.get(Q).equals("LEFT"))
				{
					PictureLoader.pos.get(Q)[0][0]--;
					if(Q>0)
					{
						int cols=PictureLoader.pos.get(Q)[0][0];
						int rows=PictureLoader.pos.get(Q)[1][0];
						
							if(PictureLoader.pos.get(Q-1)[0][0]!=cols-1)
							{
								PictureLoader.dirs.set(Q,PictureLoader.dirs.get(Q-1));
							}
						
					}
						
				}
				else
				if(PictureLoader.dirs.get(Q).equals("RIGHT"))
				{
					PictureLoader.pos.get(Q)[0][0]++;
					if(Q>0)
					{
						int cols=PictureLoader.pos.get(Q)[0][0];
						int rows=PictureLoader.pos.get(Q)[1][0];
					
						if(PictureLoader.pos.get(Q-1)[0][0]!=cols+1)
						{
							PictureLoader.dirs.set(Q,PictureLoader.dirs.get(Q-1));
						}
					}
						
				}
				else
				if(PictureLoader.dirs.get(Q).equals("UP"))
				{
					PictureLoader.pos.get(Q)[1][0]--;
					if(Q>0)
					{
						int cols=PictureLoader.pos.get(Q)[0][0];
						int rows=PictureLoader.pos.get(Q)[1][0];
					
						if(PictureLoader.pos.get(Q-1)[1][0]!=rows-1)
						{
							PictureLoader.dirs.set(Q,PictureLoader.dirs.get(Q-1));
						}
					}
				}
				else
				if(PictureLoader.dirs.get(Q).equals("DOWN"))
				{
					PictureLoader.pos.get(Q)[1][0]++;
					if(Q>0)
					{
						int cols=PictureLoader.pos.get(Q)[0][0];
						int rows=PictureLoader.pos.get(Q)[1][0];
					
						if(PictureLoader.pos.get(Q-1)[1][0]!=rows+1)
						{
							PictureLoader.dirs.set(Q,PictureLoader.dirs.get(Q-1));
						}
					}
				}
			}
			if(a[PictureLoader.posStars[1][0]][PictureLoader.posStars[0][0]]!="*")
			{
				PictureLoader.pos.add(new int[2][1]);
				PictureLoader.dirs.add("Down");
				PictureLoader.dirs.set(PictureLoader.index,PictureLoader.dirs.get(PictureLoader.index-1) );
				
				if(PictureLoader.dirs.get(PictureLoader.index-1).equals("LEFT"))
				{
					PictureLoader.pos.get(PictureLoader.index)[0][0]=PictureLoader.pos.get(PictureLoader.index-1)[0][0]+1;
					PictureLoader.pos.get(PictureLoader.index)[1][0]=PictureLoader.pos.get(PictureLoader.index-1)[1][0];
				}
				else
				if(PictureLoader.dirs.get(PictureLoader.index-1).equals("RIGHT"))
				{
					PictureLoader.pos.get(PictureLoader.index)[0][0]=PictureLoader.pos.get(PictureLoader.index-1)[0][0]-1;
					PictureLoader.pos.get(PictureLoader.index)[1][0]=PictureLoader.pos.get(PictureLoader.index-1)[1][0];
				}
				else
				if(PictureLoader.dirs.get(PictureLoader.index-1).equals("UP"))
				{
					PictureLoader.pos.get(PictureLoader.index)[0][0]=PictureLoader.pos.get(PictureLoader.index-1)[0][0];
					PictureLoader.pos.get(PictureLoader.index)[1][0]=PictureLoader.pos.get(PictureLoader.index-1)[1][0]+1;
				}
				else
				if(PictureLoader.dirs.get(PictureLoader.index-1).equals("DOWN"))
				{
					PictureLoader.pos.get(PictureLoader.index)[0][0]=PictureLoader.pos.get(PictureLoader.index-1)[0][0];
					PictureLoader.pos.get(PictureLoader.index)[1][0]=PictureLoader.pos.get(PictureLoader.index-1)[1][0]-1;
				}
				PictureLoader.posStars[1][0]=((int) (Math.random()*30))+1;
				PictureLoader.posStars[0][0]=(int) (Math.random()*106)+1;
				while(PictureLoader.posStars[1][0]==PictureLoader.pos.get(0)[1][0]
					  &&PictureLoader.pos.get(0)[0][0]==PictureLoader.posStars[0][0])
				{
					PictureLoader.posStars[1][0]=((int) (Math.random()*30))+1;
					PictureLoader.posStars[0][0]=(int) (Math.random()*106)+1;
				}
				a[PictureLoader.posStars[1][0]][PictureLoader.posStars[0][0]]="*";
				PictureLoader.index++;
				if(PictureLoader.sleeper>10)
					PictureLoader.sleeper-=5;
				
			}		
		
		for(int X=1;X<31;X++)
			for(int Y=1;Y<107;Y++)
				if(a[X][Y].equals("#"))
					a[X][Y]=" ";
			for(int S=0;S<PictureLoader.pos.size();S++)
			{
				a[PictureLoader.pos.get(S)[1][0]][PictureLoader.pos.get(S)[0][0]]="#";
			}
			for(int i=0;i<PictureLoader.fI.length;i++)//actual generator
			{
				for(int b=0;b<PictureLoader.fI[0].length;b++)
				{
					Gr.drawString(a[i][b]+"",x,y);
					x+=6;
				}
				x=3;
				y=y+12;
			}
			PictureLoader.fI=a;		
		}
		}	
	}				
	
	
