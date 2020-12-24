package Practice_Java;

public class String_Palindrome 
{
	public static void main(String[] args) {
		String name="nayan";
		String s="";
		char []a = name.toCharArray();
		for (int i = a.length-1; i >=0; i--) 
		{
			s+=a[i];
		}
		String ans = name.equals(s)?"Palindrome":"Not Palindrome";
		System.out.println(ans);
	}
}
