package com.items;

public class Sundae extends IceCream
{

	protected int topCost;
	
	public Sundae(String name,int cost,String sname,int topCost)
	{
		super(name,cost);
		this.name=sname;
		this.topCost=topCost;	
	}
	
	public int getTopCost() {
		
		return cost+topCost;
	}
	
	
}
