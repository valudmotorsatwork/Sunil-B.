package com.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BussinessLogic 
{

	public List readInput()
	{
		Scanner scan = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		System.out.print("Please Enter Numeric Values only \n");
		System.out.print("If You Want to Exit press 0 \n");
		try
		{
			while (true) 
			{	
				System.out.print("Input Pair Data : ");			
				String str= scan.nextLine();
				int pairValue =Integer.parseInt(str);
	    		if(pairValue==0)
		        {
		            break;
		        }
				list.add(pairValue);
		    }
			System.out.println("******* OUTPUT *********");
			System.out.println("Original Pairs");
			System.out.println(list);
		}
		catch(Exception e)
		{
			System.out.println("Please Enter Numeric Value Only");
			System.out.println("Try Again .....!!!");
		}
		return list;
	}
	
	public void removeBadPairs(List<Integer> arr)
	{
		List<Integer> originalList = new ArrayList();
		originalList=arr;
		if(!arr.isEmpty())
		{
			int x=arr.size()%2;
			if(x==1)
			{
				for(int i=0;i<arr.size()-1;i+=2)
				{
					int leftElement=(int)arr.get(i);
					int rightElement=(int)arr.get(i+1);
					if(leftElement>rightElement)
					{
						arr.remove(i);
						arr.remove(i);
					}
				}
			}
			else
			{
				for(int i=0;i<arr.size();i+=2)
				{
					int leftElement=(int)arr.get(i);
					int rightElement=(int)arr.get(i+1);
					if(leftElement>rightElement)
					{
						arr.remove(i);
						arr.remove(i);
					}
				}
			}

			System.out.println("After Removing Bad Pairs");
			System.out.println(arr);
		}
	}
	
}
