package Practice_Java;

public class Number_Reversing 
{
	public static void main(String[] args) {
		int n=123;
		int t1=n,rem,rev=0;
		while(t1!=0)
		{
			rem=t1%10;
			rev=rev*10+rem;
			t1=t1/10;
		}
		System.out.println(rev);
	}
}
