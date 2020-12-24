package Practice_Java;

import java.util.ArrayList;

public class Collections_Clone_Arraylist 
{
	public static void main(String[] args) {
		ArrayList<String> strlist = new ArrayList<String>();
		strlist.add("Clone");
		strlist.add("Arraylist");
		ArrayList<String> strlistclone = new ArrayList<String>();
		strlistclone=(ArrayList<String>) strlist.clone();
		System.out.println(strlist);
		System.out.println("=======================");
		System.out.println(strlistclone);
	}
}
