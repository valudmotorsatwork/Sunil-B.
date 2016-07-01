package com.app;
import java.util.List;
import com.logic.BussinessLogic;
/*
 * Write a method removeBadPairs that accepts an ArrayList of integers and removes any adjacent 
 * pair of integers in the list if the left element of the pair is larger than the right element of the pair
 */
public class Application 
{
	public static void main(String [] args)
	{
		BussinessLogic bl = new BussinessLogic();
	  	List<Integer> list=bl.readInput();
        bl.removeBadPairs(list);
	}
}
