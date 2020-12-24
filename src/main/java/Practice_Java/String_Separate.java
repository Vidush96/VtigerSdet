package Practice_Java;

public class String_Separate 
{
	public static void main(String[] args) {
		String name="viduharic96m@gmail.com";
		String alpha="";
		String number="";
		String specialChara="";
		int spchcount=0;
		char a[]=name.toCharArray();
		for (int i = 0; i < a.length; i++) {
			if(Character.isAlphabetic(a[i]))
			{
				alpha+=a[i];
			}
			else if(Character.isDigit(a[i]))
			{
				number+=a[i];
			}
			else
			{
				spchcount++;
				specialChara+=a[i];
				System.out.println(a[i]+" Spcial character count is "+spchcount);
			}
		}
		System.out.println(alpha);
		System.out.println(number);
		System.out.println(specialChara);
		System.out.println(spchcount);
	}
}
