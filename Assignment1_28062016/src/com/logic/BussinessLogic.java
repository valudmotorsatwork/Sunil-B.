package com.logic;

import java.util.ArrayList;
import java.util.Scanner;

public class BussinessLogic 
{

	public ArrayList readInputString()
	{
		ArrayList<String> arInput = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		try
		{   
	    	String strInput="",tmpInput="";
	        int choice = 0;
	        System.out.println("Enter Words or Paragraph and For Quit Press 0");
	        System.out.println("Input String :");
	        
	        int cnt=0;
	        while (scanner.hasNext())
	        {
	        	tmpInput=scanner.next();
	        	arInput.add(tmpInput);
				strInput=strInput+tmpInput;
				if (scanner.hasNextInt())
	            {
	                choice = scanner.nextInt();
	                System.out.println("All String are Entered ");  
	                break;
	            }	           
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arInput;
	}
	
	
	public void display(ArrayList<String> strInput)
	{
	
	        System.out.println("***** Strings beginning with Letter b is ******"); 
	        for(int i=0;i<strInput.size();i++)
	        {
	        	String tmp=strInput.get(i);
	        	char x;
	        	x = tmp.charAt(0);
	            if(x =='b')
	            {
	               System.out.print(tmp+"\n ");
	            }
	        }
	}
}
