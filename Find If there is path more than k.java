import java.util.Scanner;
import java.util.LinkedList;
class Path_More_Than_K
{
	static class Edge
	{
		int dest;
		int weight;
		Edge(int dest,int weight)
		{
			this.dest=dest;
			this.weight=weight;
		}
	}
	int v;
	LinkedList<Edge> adj[];
	Path_More_Than_K(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int src,int dest,int weight)
	{
		Edge ob1=new Edge(dest,weight);
		Edge ob2=new Edge(src,weight);
		adj[src].add(ob1);
		adj[dest].add(ob2);
	}
	boolean paths(int src,int k)
	{
		boolean path[]=new boolean[v];
		path[src]=true;
		return pathMoreK(src,k,path);
	}
	boolean pathMoreK(int src,int k,boolean path[])
	{
		if(k<=0)
			return true;
		for(int i=0;i<v;i++)
		{
			for(Edge j:adj[i])
			{
				int w=j.weight;
				int n=j.dest;
				if(path[n]==true)
					continue;
				if(w>=k)
					return true;
				path[n]=true;
				if(pathMoreK(n,k-w,path))
					return true;
              
             path[j.dest]=false;

			}
			 
		}
      return false;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Path_More_Than_K g=new Path_More_Than_K(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int weight=sc.nextInt();
			g.addEdge(src,dest,weight);
		}
		int src=sc.nextInt();
		int k=sc.nextInt();
		if(g.paths(src,k))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
}
