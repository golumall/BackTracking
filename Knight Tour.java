
//Sources

//https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/


import java.util.Scanner;
class Knight_Tour
{
	static int N=8;
	static boolean isSafe(int x,int y,int sol[][])
	{
		if(x>=0&&x<N&&y>=0&&y<N&&sol[x][y]==-1)
			return true;
		else
			return false;
	}
	static void print(int sol[][])
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}
	static boolean kT()
	{
		int sol[][]=new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				sol[i][j]=-1;
	    int x[]={2,1,-1,-2,-2,-1,1,2};
	    int y[]={1,2,2,1,-1,-2,-2,-1};
      sol[0][0]=0;
      if(!kTUtil(0,0,1,sol,x,y))
      {
      	System.out.println("Solution Does Not Exist");
      	return false;
      }
      else
      	print(sol);
      return  true;
	}
	static boolean kTUtil(int x,int y,int move,int sol[][],int xMove[],int yMove[])
	{
		int k,next_x,next_y;
		if(move==N*N)
			return true;
		for(k=0;k<N;k++)
		{
			next_x=x+xMove[k];
			next_y=y+yMove[k];
			if(isSafe(next_x,next_y,sol))
			{
				sol[next_x][next_y]=move;
				if(kTUtil(next_x,next_y,move+1,sol,xMove,yMove))
					return true;
				else
					sol[next_x][next_y]=-1;//BackTrack
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		kT();
	}
}
