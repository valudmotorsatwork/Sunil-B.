package com.app;

import app.logic.BussinessLogic;
/*
 * 3.	Write an application that reads several lines of text from the keyboard and prints a table indicating the number of occurrences of each letter of the alphabet in the text. For example, the phrase.
 *	    To be, or not to be: that is the question
 *     @ Sunil Birute
 */
public class Application 
{
	public static void main(String[] args) 
	{
		BussinessLogic bl = new BussinessLogic();
		String tmp=bl.readInputString();		
		bl.display(tmp);
	}	
}
