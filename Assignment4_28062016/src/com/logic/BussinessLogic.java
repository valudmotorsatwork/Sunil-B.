package com.logic;

import java.util.HashMap;
import java.util.Scanner;

public class BussinessLogic 
{

	public String[] readInputString()
	{
		Scanner sc = new Scanner( System.in ); 
		System.out.print("Enter Input Word : "); 
		String input = sc.nextLine(); 
		System.out.print("Word Accepted ");
		String [] words = input.split(" ");
		return words;
	}
	public void display(String[] words)
	{
		System.out.println("\n***** Output ******");
		
		int maxno = 0; 
		for (int i = 0; i < words.length; i++) 
		{ 
			maxno = Math.max( words[i].length(), maxno);
		} 
		int [] frequencies = new int[maxno+1]; 

		for (int i = 0; i < words.length; i++) 
		{ 
			frequencies[words[i].length()]++;
		} 
		System.out.println("*Word Length* | *Occurrences*");
		for (int i = 0; i < frequencies.length; i++) 
		{ 
			if (frequencies[i] > 0 ) 
			{ 
				System.out.println("    "+i +"              " +frequencies[i]);
//				System.out.println("There are " + frequencies[i] +" " + i + "-letter words"); 
			} 
		}
	}
	
	
}
