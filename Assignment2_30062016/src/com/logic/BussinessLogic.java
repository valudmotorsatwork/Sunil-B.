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
			System.out.print("Input Pair Data : ");			
			String pairValue = scan.nextLine();
    		if(pairValue.equals("0"))
	        {
	            break;
	        }
    		
			list.add(pairValue);
	       
	    }
		return list;
		
	}
	public void switchPairs(List<String> list)
	{
		 	String temp;
		    String temp2;
		    int x=list.size()%2;
		    if(x==1)
	 	    {
		    	
		    	for(int i=0; i<list.size()-1;i+=2 ) 
			    {	
		    		temp = list.get(i);
	  	      		list.set(i, list.get(i+1));
	  	      		list.set(i+1, temp);
			    }
	 	    }
	    	else
	    	{
	    		for(int i = 0; i <list.size() ; i+=2) 
			    {
	    			temp2 = list.get(i);
	  	      		list.set(i, list.get(i+1));
	  	      		list.set(i+1, temp2);
			    }	
	       }  
		    System.out.println("Your Swap List : "+list);
	}

}
