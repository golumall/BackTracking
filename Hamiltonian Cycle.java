import java.util.Scanner;
class Hamiltonian_Cycle
{
	int v;
	int g[][];
	int path[];
	Hamiltonian_Cycle(int v)
	{
		this.v=v;
		g=new int[v][v];
		path=new int[v];
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				g[i][j]=0;
			}
		}
		for(int i=0;i<v;i++)
		{
			path[i]=-1;
		}
	}
	void addEdge(int src,int dest)
	{
		g[src][dest]=1;
		g[dest][src]=1;
	}
	boolean isSafe(int b,int pos)
	{
		if(g[path[pos-1]][b]==0)
			return false;
		for(int i=0;i<v;i++)
			if(path[i]==b)
				return false;

	    return true;
	}
	boolean hamCycleUtil(int pos)
	{
		if(pos==v)
		{
			if(g[path[pos-1]][path[0]]==1)
				return true;
			else
				return false;
		}
		for(int i=0;i<v;i++)
		{
			if(isSafe(i,pos))
			{
				path[pos]=i;
				if(hamCycleUtil(pos+1)==true)
					return true;
				path[pos]=-1;
			}
		}
		return false;
	}
	void hamCycle()
	{
		path[0]=0;

		if(hamCycleUtil(1)==false)
			System.out.println("Path Does not Exist!");
		else
		{
			for(int i=0;i<v;i++)
				System.out.print(path[i]+" ");
		}

	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Hamiltonian_Cycle graph=new Hamiltonian_Cycle(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			graph.addEdge(src,dest);
		}
		graph.hamCycle();
	}

}
