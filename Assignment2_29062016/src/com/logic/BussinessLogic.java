package com.logic;

import java.util.Scanner;

public class BussinessLogic 
{
	public String readInputString()
	{		
		Scanner input = new Scanner(System.in);
		String str="";
		System.out.println("Please Enter String : ");
		str = input.nextLine();
		System.out.println("String Accepted : "+str);		
		return str;
	}
    
	public static boolean isValidPalindrome(String s)
	{
		System.out.println("************* OUTPUT *****************");
		if(s==null||s.length()==0) return false;
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s); 
		for(int i = 0; i < s.length() ; i++)
		{
			if(s.charAt(i) != s.charAt(s.length() - 1 - i))
			{
				System.out.println(s.charAt(i)); 
				return false;
			}
		} 
		return true;
	}
}
