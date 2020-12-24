package Practice_Java;

public class Number_Prime 
{
	public static void main(String[] args) {
		int n=7;
		boolean flag= false;
		for (int i = 2; i < n; i++) 
		{
			if(n%i==0)
				flag=true;
		}
		if(flag==false)
		System.out.println("no is prime");
		else
			System.out.println("no is not prime");
	}
}
