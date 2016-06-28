package com.logic;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BussinessLogic 
{
	public List<String> readInputString()
	{
		Scanner sc = new Scanner( System.in ); 
		System.out.print("Enter Input Word : "); 
		String input = sc.nextLine(); 
		System.out.print("Word Accepted\n ");
		List<String> list = Arrays.asList(input.split(" ")); 
		return list;
	}
	
	public void display(List<String> list)
	{	 
		System.out.println("***** Output ******");
        Set<String> uniqueWords = new HashSet<String>(list);
        for (String word : uniqueWords) 
        {
            System.out.println(word + ": " + Collections.frequency(list, word));
        }
	}
}
