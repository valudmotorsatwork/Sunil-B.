package com.app;

import com.logic.BussinessLogic;
/*
 * A palindrome is a string that reads the same both forward and backward. Examples of
	palindromes are "radar" and "31413".
	(a) Write a boolean-valued method isPalindrome that has a single String parameter.
	The method should return true if and only if its parameter is a palindrome.
	(b) Modify your method so that it ignores cases of letters, punctuation marks, and
	blanks in making a decision about whether or not a string is a palindrome. For
	example, the string:
	"A man, a plan, a canal: Panama!"
	should be taken to be a palindrome.
 */
public class Application 
{

	public static void main(String args[])
	{
		BussinessLogic bl = new BussinessLogic();
		String str=bl.readInputString();
		boolean result = bl.isValidPalindrome(str);
		if(result==true)
			System.out.println("The String Entered is Palindrome");
		else
			System.out.println("The String Entered Is Not Palindrome");
	}
}
