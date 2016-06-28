package com.items;

import com.utility.DessertItem;

public class Candy extends DessertItem
{	
	private double weight;
	private double pound;	
	
	public Candy(String name,double weight, double pound)
	{
		super(name);
		this.weight=weight;
		this.pound=pound;
	}
	
	public int getCost()
	{
		int totalCost=0;
		totalCost=(int)(weight*pound);	
		return totalCost; 
	}


	

	
	
}
