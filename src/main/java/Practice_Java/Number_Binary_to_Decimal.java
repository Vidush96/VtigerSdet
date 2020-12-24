package Practice_Java;

public class Number_Binary_to_Decimal 
{
	public static void main(String[] args) {
		int binary=1111;
		int decimal=0;
		int n=0;
		while(true)
		{
			if(binary==0)
				break;
			else
			{
				int rem= binary%10;
				decimal+= rem*(Math.pow(2, n));
				binary=binary/10;
				n++;
			}
		}
		System.out.println(decimal);
	}
}
