package Practice_Java;

public class Number_Palindrome 
{
	public static void main(String[] args) {
		int n= 121,t1=n;
		int rev=0;
		int rem;
		while(t1!=0)
		{
			rem=t1%10;
			rev=rev*10+rem;
			t1=t1/10;
		}
		if(n==rev)
			System.out.println("Paindrome");
		else
			System.out.println("Not Palindrome");
	}
}
