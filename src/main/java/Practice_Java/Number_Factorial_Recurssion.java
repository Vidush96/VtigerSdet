package Practice_Java;

public class Number_Factorial_Recurssion 
{
	static int fact(int n)
	{
		if(n==0)
			return 1;
		else
		{
			return n*fact(n-1);
		}
	}
	public static void main(String[] args) 
	{
		int no=5;
		System.out.println(fact(no));
	}
}
