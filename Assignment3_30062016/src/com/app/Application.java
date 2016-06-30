package com.app;

import java.util.List;
import com.logic.BussinessLogic;
/*
 * Write Program, markLength4 that takes an ArrayList of Strings as a parameter and that places a string of four asterisks "****"
 */
public class Application 
{
	public static void main(String args[])
	{
		  	BussinessLogic bl = new BussinessLogic();
		  	List list=bl.readInput();
	        bl.markLength4(list);
	}

}
