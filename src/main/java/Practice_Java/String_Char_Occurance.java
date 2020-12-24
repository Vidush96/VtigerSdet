package Practice_Java;

public class String_Char_Occurance 
{
	public static void main(String[] args) {
		String name="Abcdbcasdfg";
		String value=name.toLowerCase();
		char []a = value.toCharArray();
		for (int i = 0; i < a.length; i++) {
			int count=1;
			for (int j = i+1; j < a.length; j++) {
				if(a[i]==a[j])
				{
					count++;
					a[j]=0;
				}
			}
			if(a[i]!=0)
			System.out.println("Character "+a[i]+" count is "+count);
		}
	}
}
