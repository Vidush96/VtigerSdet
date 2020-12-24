package Practice_Java;

public class Number_No_Is_Present 
{
	public static void main(String[] args) 
	{
		boolean flag=false;
		long no=123456789632145l;
		while(no!=0)
		{
			long rem = no%100;
			if(rem==63)
			{
				flag=true;
			}
			no=no/10;
		}
		String ans=(flag==true)?"No is Present":"No is not present";
		System.out.println(ans);
	}
}
