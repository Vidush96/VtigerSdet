package Practice_Java;

public class String_Reverse 
{
	public static void main(String[] args) {
		String name="Vidush";
		char []a=name.toCharArray();
		for (int i = a.length-1; i >=0; i--) 
		{
			System.out.println(a[i]);
		}
	}
}
