package Practice_Java;

public class Number_Factorial 
{
	public static void main(String[] args) 
	{
		int no=5;
		int fact = 1;
		for (int i = no; i >=1; i--) 
		{
			fact*=i;
		}
		System.out.println(fact);
	}
}
