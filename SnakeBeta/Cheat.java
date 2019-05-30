import java.util.ArrayList;

public class Cheat 
{
	private static boolean ischeat=false;
	public Cheat()
	{
		ischeat=true;
	}
	public static String findBest(String[][] fI)
	//debug checkBlocked
	//maybe still issues with getting caught in a box
	//also code for path detection i.e. tail is in the way of direct path or need to do a u-turn
	{
		
		String[][] aS=new String[fI.length][fI[0].length];
		String[][] bS=new String[fI.length][fI[0].length];
		String[][] cS=new String[fI.length][fI[0].length];
		String[][] dS=new String[fI.length][fI[0].length];
		
		for(int r=0;r<fI.length;r++)
		{
			for(int c=0;c<fI[0].length;c++)
			{
				aS[r][c]=new String(fI[r][c]);
				bS[r][c]=new String(fI[r][c]);
				cS[r][c]=new String(fI[r][c]);
				dS[r][c]=new String(fI[r][c]);
			}
		}
		
		
			if(PictureLoader.dirs.get(0).equals("UP")||
			   PictureLoader.dirs.get(0).equals("DOWN"))
			{
				if(findBestV(aS,PictureLoader.pos.get(0)[1][0],PictureLoader.pos.get(0)[0][0]+1)
				==findBestV(bS,PictureLoader.pos.get(0)[1][0],PictureLoader.pos.get(0)[0][0]-1))
				{
					return "==";
				}
				if(findBestV(cS,PictureLoader.pos.get(0)[1][0],PictureLoader.pos.get(0)[0][0]+1)
				<findBestV(dS,PictureLoader.pos.get(0)[1][0],PictureLoader.pos.get(0)[0][0]-1))
				{
					return"LEFT";
				}
				else
				{
					
					return "RIGHT";
				}
					
			}
			if(PictureLoader.dirs.get(0).equals("LEFT")||
			   PictureLoader.dirs.get(0).equals("RIGHT"))
			{
				if(findBestV(aS,PictureLoader.pos.get(0)[1][0]+1,PictureLoader.pos.get(0)[0][0])
				==findBestV(bS,PictureLoader.pos.get(0)[1][0]-1,PictureLoader.pos.get(0)[0][0]))
				{
					return "==";
				}
				if(findBestV(cS,PictureLoader.pos.get(0)[1][0]+1,PictureLoader.pos.get(0)[0][0])
				<findBestV(dS,PictureLoader.pos.get(0)[1][0]-1,PictureLoader.pos.get(0)[0][0]))
				{
					return"UP";
				}
				else
				{
					
					return "DOWN";
				}
			}
		
		return PictureLoader.dirs.get(0);
	}
	public static int findBestV(String[][] fI,int locx,int locy)
	{
		if((fI[locx][locy].equals(" ")||fI[locx][locy].equals("*"))&&!fI[locx][locy].equals("0"))
		{
			fI[locx][locy]="&";
			return 1+findBestV(fI,locx+1,locy)+findBestV(fI,locx-1,locy)+
				   findBestV(fI,locx,locy+1)+findBestV(fI,locx,locy-1);
		}
		return 0;
	}
	public static String genericBlock(String[][]fI)//keep checking
	{
		String[][] aS=new String[fI.length][fI[0].length];
		String[][] bS=new String[fI.length][fI[0].length];
		String[][] cS=new String[fI.length][fI[0].length];
		String[][] dS=new String[fI.length][fI[0].length];
		
		for(int r=0;r<fI.length;r++)
		{
			for(int c=0;c<fI[0].length;c++)
			{
				aS[r][c]=new String(fI[r][c]);
				bS[r][c]=new String(fI[r][c]);
				cS[r][c]=new String(fI[r][c]);
				dS[r][c]=new String(fI[r][c]);
			}
		}
		int aSize,bSize,cSize,dSize;
		aSize=findBestV(aS,PictureLoader.pos.get(0)[1][0]+1,PictureLoader.pos.get(0)[0][0]);
		bSize=findBestV(bS,PictureLoader.pos.get(0)[1][0]-1,PictureLoader.pos.get(0)[0][0]);
		cSize=findBestV(cS,PictureLoader.pos.get(0)[1][0],PictureLoader.pos.get(0)[0][0]+1);
		dSize=findBestV(dS,PictureLoader.pos.get(0)[1][0],PictureLoader.pos.get(0)[0][0]-1);
		int maxSize=3180-PictureLoader.pos.size();
		int counta=-2,countb=-3,countc=-4,countd=-5;
		if(aSize<maxSize&&aSize!=0){counta=aSize;}
		if(bSize<maxSize&&bSize!=0){countb=bSize;}
		if(cSize<maxSize&&cSize!=0){countc=cSize;}
		if(dSize<maxSize&&dSize!=0){countd=dSize;}
		ArrayList<Integer> sizes= new ArrayList<Integer>();
		sizes.add(counta);
		sizes.add(countb);
		sizes.add(countc);
		sizes.add(countd);
		if(counta==countb||counta==countc||counta==countd||countb==countc||countb==countd||countc==countd)
		{
			sizes.sort(null);
			int highestNum=0;
			int count=0;
			for(int index=0;index<4;index++)
			{
				if(sizes.get(index)>maxSize-1000)
					return "END";
				
				if(sizes.get(index)==highestNum&&highestNum>0)
					count++;
				if(sizes.get(index)>highestNum&&highestNum>0)
				{
					return "END";
				}
				if(sizes.get(index)>highestNum)
				{
					highestNum=sizes.get(index);
					count=1;
				}
					
			}
	//		System.out.println(sizes.toString()+"\n"+count);
			if(count==2)
			{
				return "BEGIN";
			}
		}
		
		
		return "END";
	}
	/*public static String checkBlocked(String[][]fI)
	{
		if(PictureLoader.pos.get(0)[1][0]==2 ||PictureLoader.pos.get(0)[1][0]==29)
		{
			for(int i=1,c=0;i<PictureLoader.dirs.size();i++)
			{
				if(PictureLoader.dirs.get(i).equals("UP")||PictureLoader.dirs.get(i).equals("DOWN"))
				{
					c++;
					if(c>=29)
					{
						if((PictureLoader.dirs.get(0).equals("UP")&&PictureLoader.pos.get(0)[1][0]==2)||
						(PictureLoader.dirs.get(0).equals("DOWN")&&PictureLoader.pos.get(0)[1][0]==29))
						{
							
								if(fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+1].equals("#"))
								{
									return "LEFT";
								}
								else
									return "RIGHT";
							
						}
					}
				}
				else
					c=0;
			}
			
		}
		
		return "==";
	}*/
	
	public static String checkonexone(String[][] fI)
	{
		String[][] aS=new String[fI.length][fI[0].length];
		String[][] bS=new String[fI.length][fI[0].length];
		String[][] cS=new String[fI.length][fI[0].length];
		String[][] dS=new String[fI.length][fI[0].length];
		
		for(int r=0;r<fI.length;r++)
		{
			for(int c=0;c<fI[0].length;c++)
			{
				aS[r][c]=new String(fI[r][c]);
				bS[r][c]=new String(fI[r][c]);
				cS[r][c]=new String(fI[r][c]);
				dS[r][c]=new String(fI[r][c]);
			}
		}
		if(PictureLoader.dirs.get(0).equals("UP"))
		{
			if((fI[PictureLoader.pos.get(0)[1][0]-1][PictureLoader.pos.get(0)[0][0]+1].equals("#"))
			||fI[PictureLoader.pos.get(0)[1][0]-1][PictureLoader.pos.get(0)[0][0]-1].equals("#"))
			{
				int a,b,d;
				a=findBestV(aS,PictureLoader.pos.get(0)[1][0]-1,PictureLoader.pos.get(0)[0][0]);
				b=findBestV(bS,PictureLoader.pos.get(0)[1][0],PictureLoader.pos.get(0)[0][0]-1);
				d=findBestV(dS,PictureLoader.pos.get(0)[1][0],PictureLoader.pos.get(0)[0][0]+1);
				if(a<b||a<d)
				{
					if(b<d)
					{
						return "RIGHT";
					}
					else
						return "LEFT";
				}
				
			}
		}
		if(PictureLoader.dirs.get(0).equals("DOWN"))
		{
			if((fI[PictureLoader.pos.get(0)[1][0]+1][PictureLoader.pos.get(0)[0][0]+1].equals("#"))
			||fI[PictureLoader.pos.get(0)[1][0]+1][PictureLoader.pos.get(0)[0][0]-1].equals("#"))
			{
				int a,b,d;
				a=findBestV(aS,PictureLoader.pos.get(0)[1][0]+1,PictureLoader.pos.get(0)[0][0]);
				b=findBestV(bS,PictureLoader.pos.get(0)[1][0],PictureLoader.pos.get(0)[0][0]-1);
				d=findBestV(dS,PictureLoader.pos.get(0)[1][0],PictureLoader.pos.get(0)[0][0]+1);
				if(a<b||a<d)
				{
					if(b<d)
					{
						return "RIGHT";
					}
					else
						return "LEFT";
				}
			}
		}
		if(PictureLoader.dirs.get(0).equals("LEFT"))
		{
			if((fI[PictureLoader.pos.get(0)[1][0]-1][PictureLoader.pos.get(0)[0][0]-1].equals("#"))
			||fI[PictureLoader.pos.get(0)[1][0]+1][PictureLoader.pos.get(0)[0][0]-1].equals("#"))
			{
				int a,b,d;
				a=findBestV(aS,PictureLoader.pos.get(0)[1][0],PictureLoader.pos.get(0)[0][0]-1);
				b=findBestV(bS,PictureLoader.pos.get(0)[1][0]-1,PictureLoader.pos.get(0)[0][0]);
				d=findBestV(dS,PictureLoader.pos.get(0)[1][0]+1,PictureLoader.pos.get(0)[0][0]);
				if(a<b||a<d)
				{
					if(b<d)
					{
						return "DOWN";
					}
					else
						return "UP";
				}
			}
		}
		if(PictureLoader.dirs.get(0).equals("RIGHT"))
		{
			if((fI[PictureLoader.pos.get(0)[1][0]-1][PictureLoader.pos.get(0)[0][0]+1].equals("#"))
			||fI[PictureLoader.pos.get(0)[1][0]+1][PictureLoader.pos.get(0)[0][0]+1].equals("#"))
			{
				int a,b,d;
				a=findBestV(aS,PictureLoader.pos.get(0)[1][0],PictureLoader.pos.get(0)[0][0]+1);
				b=findBestV(bS,PictureLoader.pos.get(0)[1][0]-1,PictureLoader.pos.get(0)[0][0]);
				d=findBestV(dS,PictureLoader.pos.get(0)[1][0]+1,PictureLoader.pos.get(0)[0][0]);
				if(a<b||a<d)
				{
					if(b<d)
					{
						return "DOWN";
					}
					else
						return "UP";
				}
			}
		}
		return "==";
	}
	
	public static String nextDot(String[][] fI) //1,0 is rows
	{
		PictureLoader.sleeper=0;
		ArrayList<String> moves=new ArrayList<String>();
		if(genericBlock(fI).equals("BEGIN"))
		{
		
			/*
			 *won't work when perfect horizontal instance, should still leave a space but doesn't
			 *
			 * still requires an area cap to ensure it isn't confused
			 */
			if(PictureLoader.dirs.get(0).equals("LEFT"))
			{
				if(!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]-1].equals("#")
						&&!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]-1].equals("0"))
					{
						
							if(!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]-2].equals("#")
									&&!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]-2].equals("0"))
								{
									return "LEFT";
								}	
					}
					else
					{
						if(fI[PictureLoader.pos.get(0)[1][0]+1][PictureLoader.pos.get(0)[0][0]].equals("#")||
								fI[PictureLoader.pos.get(0)[1][0]+1][PictureLoader.pos.get(0)[0][0]].equals("0"))
						{
							return "UP";
						}
						if(fI[PictureLoader.pos.get(0)[1][0]-1][PictureLoader.pos.get(0)[0][0]].equals("#")||
								fI[PictureLoader.pos.get(0)[1][0]-1][PictureLoader.pos.get(0)[0][0]].equals("0"))
						{
							return "DOWN";
						}
						
					}
			}
			if(PictureLoader.dirs.get(0).equals("RIGHT"))
			{
				if(!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+1].equals("#")
						&&!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+1].equals("0"))
						{
					if(!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+2].equals("#")
							&&!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+2].equals("0"))
							{
								return "RIGHT";
							}
						}
						else
						{
							if(fI[PictureLoader.pos.get(0)[1][0]+1][PictureLoader.pos.get(0)[0][0]].equals("#")||
									fI[PictureLoader.pos.get(0)[1][0]+1][PictureLoader.pos.get(0)[0][0]].equals("0"))
							{
								return "UP";
							}
							if(fI[PictureLoader.pos.get(0)[1][0]-1][PictureLoader.pos.get(0)[0][0]].equals("#")||
									fI[PictureLoader.pos.get(0)[1][0]-1][PictureLoader.pos.get(0)[0][0]].equals("0"))
							{
								return "DOWN";
							}
							
						}
				
			}
			if(PictureLoader.dirs.get(0).equals("UP"))
			{
				if(!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]-1].equals("#")
						&&!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]-1].equals("0"))
						{
							return"LEFT";
						}
				if(!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+1].equals("#")
						&&!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+1].equals("0"))
						{
							return"RIGHT";
						}
				return "UP";
			}
			if(PictureLoader.dirs.get(0).equals("DOWN"))
			{
				if(!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]-1].equals("#")
						&&!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]-1].equals("0"))
						{
							return"LEFT";
						}
				if(!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+1].equals("#")
						&&!fI[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+1].equals("0"))
						{
							return"RIGHT";
						}
				return "DOWN";
			}
			
		}
		if(!notinTheWay(fI,PictureLoader.dirs.get(0)))
		{
			String holddir=findBest(fI);
			if(!holddir.equals("=="))
			return holddir;
		}
		String hold=checkonexone(fI);
		if(!hold.equals("=="))
		{
			return hold;
		}
	//	String hold2=checkBlocked(fI);
	//	if(!hold2.equals("=="))
		{
	//		return hold2;
		}
		
		
		if(!(PictureLoader.posStars[1][0]==PictureLoader.pos.get(0)[1][0]
		   &&PictureLoader.posStars[0][0]==PictureLoader.pos.get(0)[0][0]))
		{
			if(PictureLoader.posStars[1][0]<PictureLoader.pos.get(0)[1][0])
			{
				if(!PictureLoader.dirs.get(0).equals("DOWN"))
				{
					if(notinTheWay(fI,"UP"))
					{
						PictureLoader.sleeper=PictureLoader.sleeper*2;
						return "UP";
					}
					
				}
				
				
			}
			if(PictureLoader.posStars[1][0]>PictureLoader.pos.get(0)[1][0])
			{
				if(!PictureLoader.dirs.get(0).equals("UP"))
				{
					if(notinTheWay(fI,"DOWN"))
					{
						PictureLoader.sleeper=PictureLoader.sleeper*2;
						return "DOWN";
					}
				}
				
				
			}
			if(PictureLoader.posStars[0][0]<PictureLoader.pos.get(0)[0][0])
			{
				if(!PictureLoader.dirs.get(0).equals("RIGHT"))
				{
					if(notinTheWay(fI,"LEFT"))
					{
						
						return "LEFT";
					}
				}
				
			}
			if(PictureLoader.posStars[0][0]>PictureLoader.pos.get(0)[0][0])
			{
				if(!PictureLoader.dirs.get(0).equals("LEFT"))
				{
					if(notinTheWay(fI,"RIGHT"))
					{
						
						return "RIGHT";
					}
				}
				
			}
		}
		if(notinTheWay(fI,PictureLoader.dirs.get(0)))
		{
			return PictureLoader.dirs.get(0);
		}
		else
		{
			return pickNewWay(fI);
		}
			
	}
	
	public static boolean getischeat()
	{
		return ischeat;
	}
	public static void setischeat(boolean f)
	{
		ischeat=f;
	}
	private static boolean notinTheWay(String[][] layout, String direc)
	{
		if(direc.equals("UP"))
		{
			if(layout[PictureLoader.pos.get(0)[1][0]-1][PictureLoader.pos.get(0)[0][0]].equals("0")
			 ||layout[PictureLoader.pos.get(0)[1][0]-1][PictureLoader.pos.get(0)[0][0]].equals("#"))
			{
				return false;
			}
		}
		if(direc.equals("DOWN"))
		{
			if(layout[PictureLoader.pos.get(0)[1][0]+1][PictureLoader.pos.get(0)[0][0]].equals("0")
			 ||layout[PictureLoader.pos.get(0)[1][0]+1][PictureLoader.pos.get(0)[0][0]].equals("#"))
				{
					return false;
				}
		}
		if(direc.equals("LEFT"))
		{
			if(layout[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]-1].equals("0")
			 ||layout[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]-1].equals("#"))
				{
					return false;
				}
		}
		if(direc.equals("RIGHT"))
		{
			if(layout[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+1].equals("0")
			 ||layout[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+1].equals("#"))
				{
					return false;
				}
		}
		return true;
	}
	private static String pickNewWay(String[][] layout)
	{
		if(!(layout[PictureLoader.pos.get(0)[1][0]-1][PictureLoader.pos.get(0)[0][0]].equals("0")
			 ||layout[PictureLoader.pos.get(0)[1][0]-1][PictureLoader.pos.get(0)[0][0]].equals("#")))
			{
				PictureLoader.sleeper=PictureLoader.sleeper*2;
				return "UP";
			}
		
		if(!(layout[PictureLoader.pos.get(0)[1][0]+1][PictureLoader.pos.get(0)[0][0]].equals("0")
			 ||layout[PictureLoader.pos.get(0)[1][0]+1][PictureLoader.pos.get(0)[0][0]].equals("#")))
				{
					PictureLoader.sleeper=PictureLoader.sleeper*2;
					return "DOWN";
				}
		
		if(!(layout[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]-1].equals("0")
			 ||layout[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]-1].equals("#")))
				{
					return "LEFT";
				}
		
		if(!(layout[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+1].equals("0")
			 ||layout[PictureLoader.pos.get(0)[1][0]][PictureLoader.pos.get(0)[0][0]+1].equals("#")))
				{
					return "RIGHT";
				}
		
		return PictureLoader.dirs.get(0);
	}
}
