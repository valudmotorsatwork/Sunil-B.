package com.checkout;

import java.util.ArrayList;

import com.utility.DessertItem;
import com.utility.DessertShoppe;

public class Checkout 
{
	
	ArrayList<DessertItem> desertItem = new ArrayList<DessertItem>();	
	DessertShoppe ds= new DessertShoppe();
	int count=0;
	
	public Checkout()
	{
		
	}
	public int numberOfItems()
	{
		int items=0;
		items=desertItem.size();
		return items;
	}
	
	public void enterItem(DessertItem item)
	{
		desertItem.add(item);
	}

	public void clear()
	{
		desertItem.clear();
	}
	
	public int totalCost()
	{
		int cost=0;
		int sumCost=0;
		int siz=desertItem.size();
		for(int i=0;i<siz;i++)
		{
			cost=desertItem.get(0).getCost();
			sumCost=sumCost+cost;
		}
		return sumCost;
	}
	
	public double totalTax()
	{
		double tax=0;
		tax=(Math.round(totalCost()*ds.TAX_RATE)/100);
		return tax;
	}
	
	
	public String toString()
	{
		
		int siz=desertItem.size();
		int count=1;
		String str = "";
		str ="********** "+ DessertShoppe.STORE_NAME+ " **********\n";
		str=str+"********** Purchase Detail **********\n";
		str=str+"Description                          Cost\n";
		for(int i=0;i<siz;i++)
		{	
			str =str+ String.format(count+"> "+"%-30s%10s", desertItem.get(i).getName(), desertItem.get(i).getCost())+"\n";	
		    count++;
		}
		str=str+"------------------------------------------------";
		return str;
	}
	
}
