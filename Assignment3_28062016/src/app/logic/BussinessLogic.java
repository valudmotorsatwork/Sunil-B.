package app.logic;

import java.util.HashMap;
import java.util.Scanner;

public class BussinessLogic 
{
	public String readInputString()
	{
		Scanner scanner = new Scanner(System.in);		
		HashMap<Character, Integer> mapString = new HashMap<>();
		System.out.println(" Enter Input Word :" );
		String tmp=scanner.nextLine();
		System.out.println(" You Enterd : "+tmp);
		for (char ch : tmp.toCharArray()) 
		{
			// Check character in String
//			System.out.println(" Input OUTPUT"+ch);
			if (mapString.containsKey(ch)) 
			{
				int val = mapString.get(ch);				
				mapString.put(ch, val + 1);
			}
			else 
			{
				mapString.put(ch, 1);
			}
		}
		return tmp;
	}
	
	public void display(String tmp)
	{	
		HashMap<Character, Integer> mapString = new HashMap<>();
		System.out.println("***** Output ******");
		for (char ch : tmp.toCharArray()) 
		{
			// Check character in String
			if (mapString.containsKey(ch)) 
			{
				int val = mapString.get(ch);				
				mapString.put(ch, val + 1);
			}
			else 
			{
				mapString.put(ch, 1);
			}
		}
		System.out.println(mapString);
	}

}
