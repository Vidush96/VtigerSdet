package Practice_Java;

import java.util.ArrayList;

public class Collections_Arraylist_Contains_Elements 
{
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		System.out.println("Elements are present in Collection =====>"+list.containsAll(list));
	}
}
