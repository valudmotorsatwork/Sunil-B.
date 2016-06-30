package com.app;
import java.util.List;

import com.logic.BussinessLogic;
/*
 * SwitchPairs that switches the order of values in an ArrayList of Strings in a pairwise fashion
 * @Sunil Birute
 */
public class Application 
{
	public static void main(String args[])
	{
		BussinessLogic b= new BussinessLogic();
		List list=b.readInput();
		b.switchPairs(list);
	}
}
