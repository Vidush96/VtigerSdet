package Practice_Java;

import java.util.Scanner;

public class Number_Amstrong 
{
	public static void main(String[] args) {
		int n=153,len=0,t1=n;
		while(t1!=0)
		{
			len+=1;
			t1=t1/10;
		}
		int t2=n,rem,arm = 0;
		while(t2!=0)
		{
			int mul=1;
			rem=t2%10;
			for (int i = 1; i <=len; i++) 
			{
				mul=mul*rem;
			}
			arm=arm+mul;
			t2=t2/10;
		}
		System.out.println(arm);
	}
}
