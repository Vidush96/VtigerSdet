package Practice_Java;

public class Number_Strong 
{
	public static void main(String[] args) 
	{
		int n=145;
		int t=n;
		int fact;
		int sum=0;
		while(t!=0)
		{
			fact=1;
			int rem = t%10;
			for (int i = 1; i <=rem; i++) 
			{
				fact*=i;
			}
			sum+=fact;
			t=t/10;
		}
		System.out.println(sum);
	}
}
