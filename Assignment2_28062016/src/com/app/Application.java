package com.app;
import com.logic.BussinessLogic;

/*
 *  2.Write a program that reads a five-letter word from the user and produces all possible
 *  three- letter words that can be derived from the letters of the five-letter word. 
 *  For example, the three-letter words produced from the word "bathe" 
 *  include the commonly used words "ate", "bat", "bet", "tab", "hat", "the" and "tea."
 * @ Sunil Birute 28-06-2016
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
