import java.util.Scanner;
class Nqueen_Problem
{
static int n;
Nqueen_Problem(int n)
{
this.n=n;
}
static boolean isSafe(int q[][],int row,int col)
{
	int i,j;
	for(i=0;i<col;i++)
        if(q[row][i]==1)
        	return false;

    for(i=row,j=col;i>=0&&j>=0;i--,j--)
    {
    	if(q[i][j]==1)
    		return false;
    }
    for(i=row,j=col;j>=0&&i<n;i++,j--)
    	if(q[i][j]==1)
    		return false;

    	return true;

}
void nq(int q[][])
{
	if(nqUtil(q,0)==false)
		System.out.println("Solution Does Not Exist...");
	else
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(q[i][j]+" ");
			}
			System.out.println();
		}
	}
}
static boolean nqUtil(int q[][],int col)
{
	if(col>=n)
		return true;
	for(int i=0;i<n;i++)
	{
		if(isSafe(q,i,col))
		{
			q[i][col]=1;
			if(nqUtil(q,col+1))
				return true;
			q[i][col]=0;//Backtrack
		}
	}
	return false;
} 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Nqueen_Problem ob=new Nqueen_Problem(n);
		int q[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				q[i][j]=0;
			}
		}
		ob.nq(q);
	}
}
