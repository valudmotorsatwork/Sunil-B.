package com.app;

/*
 *  Write a program that reads a string and then prints a diamond shaped array based on
	the characters of the string. As an example, if the string has the value "SAMPLE", then
	the program should print the pattern
	@ Sunil Birute
 */
import com.logic.BussinessLogic;

public class Application 
{
	public static void main(String [] args)
	{
		BussinessLogic bl = new BussinessLogic();
		String str=bl.readInputString();
		bl.display(str);	
	}
}
