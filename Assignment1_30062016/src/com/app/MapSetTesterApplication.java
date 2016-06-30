package com.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/*
 * Tv Network Program
 * @Sunil Birute
 */
public class MapSetTesterApplication 
{
	public static void main(String[] args) 
	{
		System.out.println("***** Enter TV Network and Shows *****");
		Map<String,TreeSet<String>> networkMap = new HashMap<String,TreeSet<String>>();
		Scanner scan = new Scanner(System.in);
		while (true) 
		{
			System.out.print("Input type Network : ");
			String network = scan.nextLine();
    		System.out.print("Input Type Show " + network + ": ");
    		String show = scan.nextLine();
    		
    		
    		TreeSet<String> showSet = networkMap.get(network);
    		if (showSet == null) 
    		{
    			showSet = new TreeSet<String>();
    			showSet.add(show);
    			networkMap.put(network, showSet);
    		}
    		else 
    		{
    			showSet.add(show);
    		}
    		System.out.print("Do you want to continue ? Yes/No : ");
    		String choice = scan.nextLine();
    		if(choice.equals("no") || choice.equals("NO") ||  choice.equals("nO") ||  choice.equals("No"))
	        {
	            break;
	        }
	       
	    }
		System.out.println("\n ******** Entry Inserted ******** \n");
		System.out.println(networkMap);
		System.out.println("\n ******************************** \n");
		
		System.out.println("\n ******** Sorted Order ******** \n");
		ArrayList<String> keyList = new ArrayList<String>(networkMap.keySet());
		Collections.sort(keyList);
		for (String networka: keyList) 
		{
			System.out.println(networka + ": " + networkMap.get(networka));
		}		
	}
}
