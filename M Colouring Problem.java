import java.util.Scanner;
class K_Coloring
{
	static int n;
	int color[];
	K_Coloring(int n)
	{
	this.n=n;
	}
	static boolean isSafe(int v,int g[][],int color[],int c)
	{
		for(int i=0;i<n;i++)
		{
			if(g[v][i]==1&&c==color[i])
				return false;
		}
		return true;
	}
	static boolean coloRingUtil(int g[][],int m,int color[],int v)
	{
		if(v==n)
			return true;
		for(int i=1;i<=m;i++)
		{
			if(isSafe(v,g,color,i))
			{
				color[v]=i;
				if(coloRingUtil(g,m,color,v+1))
					return true;
				color[v]=0;
			}
		}
		return false;
	}
	void coloRing(int g[][],int m)
	{
		color=new int[n];
		for(int i=0;i<n;i++)
			color[i]=0;
		if(!coloRingUtil(g,m,color,0))
			System.out.println("Can be color");
		else
		{
			for(int i=0;i<n;i++)
				System.out.print(color[i]+" ");
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		K_Coloring graph=new K_Coloring(v);
		int g[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				g[i][j]=sc.nextInt();
			}
		}
		int k=sc.nextInt();
		graph.coloRing(g,k);
	}
}
