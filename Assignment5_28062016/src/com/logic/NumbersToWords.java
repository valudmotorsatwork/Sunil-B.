package com.logic;

public class NumbersToWords
{
	private static final String[] lowNames = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten","eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	private static final String[] tensNames = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	public String convertNumbersToWords(int n) 
	{
		if (n < 20) 
		{
			return lowNames[n]; 
		}
		String s = tensNames[n / 10 - 2];
		if (n % 10 == 0) 
		{
			return s; 
		}
		return s + "-" + lowNames[n % 10]; 
	}
	

}
