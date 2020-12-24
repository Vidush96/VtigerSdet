package Practice_Java;

public class Number_Detect_Prime 
{
	public static void main(String[] args) {
		int n=20;
		int num;
		String primeNumbers="";
		for (int i = 3; i <=n; i++) 
		{
			int counter = 0;
			for (num = i;  num>=1; num--) 
			{
				if(i%num==0)
				{
					counter=counter+1;
				}
			}
			if(counter==2)
			{
				primeNumbers+=i+" ";
			}
		}
		System.out.println(primeNumbers);
	}
}
