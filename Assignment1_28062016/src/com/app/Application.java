package com.app;

import java.util.ArrayList;
import com.logic.BussinessLogic;
/*
 * 1.	Write an application that reads a series of strings and outputs only those strings beginning with the letter "b."
 * @ Sunil Birute 28-06-2016
 */
public class Application {

	public static void main(String[] args) 
	{
		
		BussinessLogic bl = new BussinessLogic();
		ArrayList<String> arrOutput = new ArrayList<String>();
		arrOutput=bl.readInputString();
		bl.display(arrOutput);
	}

}
