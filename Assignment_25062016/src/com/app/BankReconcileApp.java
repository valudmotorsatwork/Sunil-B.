package com.app;
import com.dao.ReconcileImpl;
/*
 * Program for generating Bank Reconciliation Report with Excel and PDF File
 * @ Sunil Birute
 * Date : 27-06-2016
 */
public class BankReconcileApp 
{	
	public static void main(String[] args) 
	{
		ReconcileImpl obj1 = new ReconcileImpl();
		obj1.ReconcileImplement();
	}
}