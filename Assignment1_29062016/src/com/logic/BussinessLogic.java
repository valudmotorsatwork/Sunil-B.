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
			if(str.length()>10)
			{
				str=str.substring(0,10);
				System.out.println("String Length is greater than 10 ");
			}
						
			System.out.println("Actual String After trim : "+str);
			return str;
		}
	    
		public void display(String str)
		{
			System.out.println("************ OUTPUT *************"); 
			int i;
			StringBuilder sb;
			for(i=1; i<=str.length(); i++)
			{
				System.out.print(addSpace(str.length()-i) + str.substring(0,i));
				if(i>1)
				{
					sb = new StringBuilder(str.substring(0,i-1));
					sb = sb.reverse();
					System.out.print(sb.toString());
				}
				System.out.println();
			}
			for(i=str.length()-1; i>0; i--)
			{
				System.out.print(addSpace(str.length()-i) + str.substring(0,i));
				if(i>1)
				{
					sb = new StringBuilder(str.substring(0,i-1));
					sb = sb.reverse();
					System.out.print(sb.toString());
				}
				System.out.println();
			}
		}
		public String addSpace(int x)
		{
			String s = "";
			for(int i=0; i<x; i++)
			{
				s += " ";
			}
			return s;
		}
}
