package com.logic;

import java.util.ArrayList;
import java.util.Scanner;

public class BussinessLogic 
{
	public String readInputString()
	{
		Scanner scanner = new Scanner(System.in);		
		System.out.println(" Enter Input Word :" );
		String tmp=scanner.nextLine();
		System.out.println(" You Entered String is : "+tmp );
		return tmp;
	}
	public void display(String tmp)
	{
		System.out.println("***** Output ******");
		for (int i = 0; i < tmp.length(); i++) 
		{            
		    for (int j = 0; j < tmp.length(); j++) 
		    {        
		        for (int k = 0; k < tmp.length(); k++) 
		        {    
		            System.out.printf("%c%c%c\n", tmp.charAt(i), tmp.charAt(j), tmp.charAt(k));
		        }
		    }
		}
	}
		
}
