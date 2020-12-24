package Practice_Java;

public class Number_Perfect 
{
	public static void main(String[] args) {
		int n=28;
		int sum=0;
		for (int i = 1; i <n; i++) 
		{
			if(n%i==0)
			{
				sum+=i;
			}
		}
		if(sum==n)
			System.out.println("Number Perfect");
		else
			System.out.println("Number is not perfect");
	}
}
