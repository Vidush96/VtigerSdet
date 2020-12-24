package Practice_Java;

public class String_Palindrome_Recursion 
{
	public static String s="";
	public static void reverse(String str)
	{
		if(str.length()<=1)
			s+=str;
		else
		{
			s+=str.charAt(str.length()-1);
			reverse(str.substring(0, str.length()-1));
		}
	}
	public static void main(String[] args) {
		String name="nayan";
		reverse(name);
		String ans = name.equals(s)?"Palindrome":"Not Palindrome";
		System.out.println(ans);
	}
}
