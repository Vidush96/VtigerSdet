package Practice_Java;

public class String_Reverse_Recursion 
{
	public static void reverse(String str)
	{
		if(str.length()<=1)
			System.out.println(str);
		else
		{
			System.out.println(str.charAt(str.length()-1));
			reverse(str.substring(0, str.length()-1));
		}
	}
	public static void main(String[] args) {
		String name="Vidush";
		reverse(name);
	}
}
