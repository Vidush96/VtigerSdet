package Practice_Java;

public class String_Remove_Duplicate {
	public static void main(String[] args) {
		String name ="Java is a programming Language";
		String value = name.toLowerCase();
		char []a=value.toCharArray();
		for (int i = 0; i < a.length; i++) 
		{
			if(a[i]!=0 && a[i]!=' ')
			{
			for (int j = i+1; j < a.length; j++) 
			{
				if(a[i]==a[j])
					a[j]=0;
			}
			}
		}
		for (int i = 0; i < a.length; i++) {
			if(a[i]!=0)
			{
				System.out.print(a[i]);
			}	
		}
	}
}
