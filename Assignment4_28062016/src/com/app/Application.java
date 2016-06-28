package com.app;

import com.logic.BussinessLogic;
/*
 * 4.	Write an application that reads several lines of text and prints a table 
 * indicating the number of one-letter words, two-letter words, three-letter words
 */
public class Application 
{
	public static void main(String[] args) 
	{
		BussinessLogic bl = new BussinessLogic();
		String[] tmp=bl.readInputString();		
		bl.display(tmp);
	}
}
