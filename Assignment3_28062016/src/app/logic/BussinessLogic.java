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
		return tmp;
	}
	

	public void display(String tmp)
	{	
		HashMap<Character, Integer> mapString = new HashMap<>();
		NumbersToWords numWords= new NumbersToWords();
		HashMap<Character, String> mapOutputString = new HashMap<>();
		System.out.println("***** Output ******");
		for (char ch : tmp.toCharArray()) 
		{
			if (mapString.containsKey(ch)) 
			{
				int val = mapString.get(ch);
				mapOutputString.put(ch,numWords.convertNumbersToWords(val + 1));
			}
			else 
			{	
				mapOutputString.put(ch, "One");
			}
		}
		
		System.out.println(mapOutputString);
	}
	
	
}
