package com.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BussinessLogic 
{

	public List readInput()
	{
		Scanner scan = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		System.out.print("If You Want to Exit press 0 \n");
		while (true) 
		{	
			System.out.print("Input Data in ArrayList: ");			
			String pairValue = scan.nextLine();
    		if(pairValue.equals("0"))
	        {
	            break;
	        }
    		
			list.add(pairValue);
	       
	    }
		System.out.println("Your Input List : "+list);
		return list;
		
	}
	
	public void markLength4(List<String> array) 
	{
	    for (int i = 0; i < array.size(); i++) 
	    {
	        if (array.get(i).length()==4) 
	        {
	            array.add(i, "****");
	            i++;
	        }
	    }
	    for (int i = 0; i < array.size(); i++) 
        {
			System.out.println(array.get(i));
		}
	    
	}
}
