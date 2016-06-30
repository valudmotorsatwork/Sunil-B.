package com.app;

import java.util.List;
import com.logic.BussinessLogic;
/*
 * 5.	Write an application that reads several lines of text and prints a table indicating 
 * the number of occurrences of each different word in the text. The first version of your 
 * program should include the words in the table in the same order in which they appear in the text
 * @Sunil Birute
 */
public class Application 
{
	public static void main(String[] args) 
	{
		BussinessLogic bl = new BussinessLogic();
		List<String> tmp=bl.readInputString();		
		bl.display(tmp);
	}
}
