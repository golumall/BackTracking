import java.util.Scanner;
class Rat_In_Maze
{
	int n;
	int sol[][];
	Rat_In_Maze(int n)
	{
		this.n=n;
		sol=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				sol[i][j]=0;
			}
		}

	}

	boolean isSafe(int maze[][],int x,int y)
	{
		return (x>=0&&x<n&&y>=0&&y<n&&maze[x][y]==1);
	}
	void ratMaze(int maze[][])
	{
          if(ratMazeUtil(maze,0,0)==false)
          {
          	System.out.println("Solution Does Not Exist!..");
          }
          else
          {
          	System.out.print("\n\n");
          	for(int i=0;i<n;i++)
          	{
          		for(int j=0;j<n;j++)
          		{
          			System.out.print(sol[i][j]+" ");
          		}
          		System.out.println();
          	}
          }
	}
	boolean ratMazeUtil(int maze[][],int x,int y)
	{
		if(x==n-1&&y==n-1)
		{
			sol[x][y]=1;
			return true;
		}
		if(isSafe(maze,x,y)==true)
		{
			sol[x][y]=1;
			if(ratMazeUtil(maze,x+1,y))
				return true;
			if(ratMazeUtil(maze,x,y+1))
				return true;
			sol[x][y]=0;//BackTrack
			return false;

		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Rat_In_Maze ob=new Rat_In_Maze(n);
		int maze[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				maze[i][j]=sc.nextInt();
			}
		}
		ob.ratMaze(maze);
	}
	
}
