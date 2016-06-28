package com.items;

import com.utility.DessertItem;

public class Cookie extends DessertItem 
{

	private double noOfCookies;
	private double pricePerDozen;
	
	public Cookie(String name,double noOfCookies,double pricePerDozen)
	{
		super(name);
		this.noOfCookies=noOfCookies;
		this.pricePerDozen=pricePerDozen;
	}
		
	public int getCost()
	{
		double pricePerCookies=pricePerDozen/12;		
		return (int)pricePerCookies*(int)noOfCookies;
	}	
}
