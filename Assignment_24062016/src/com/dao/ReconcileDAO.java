package com.dao;

import java.util.StringTokenizer;

import com.modal.Reconcile;

public class ReconcileDAO 
{
	Reconcile obj1 = new Reconcile();

	public double calculateReconDiff(String line, String delims)
	{
		double reconDiff=0.0d;
		StringTokenizer st = new StringTokenizer(line, delims);
		obj1.setConBranch(st.nextToken());
		obj1.setConDate(st.nextToken());
		obj1.setConBranchCode(st.nextToken());
		obj1.setConTotRecon(st.nextToken());
		obj1.setConReconDiff(st.nextToken());
		obj1.setComCompany(st.nextToken());
		reconDiff=Double.parseDouble(obj1.getConReconDiff());
		return reconDiff;
	}
	//Calculate Reconilation Difference by delimiter by white space using substring
	public double calReconDiff(String line, String delims)
	{
		double reconDiff=0.0d;
		obj1.setConBranch(line.substring(0,8));
		obj1.setConDate(line.substring(8,19));
		obj1.setConBranchCode(line.substring(19,22));
		obj1.setConTotRecon(line.substring(22,32));
		obj1.setConReconDiff(line.substring(33,44));
		obj1.setComCompany(line.substring(43,59));
		reconDiff=Double.parseDouble(obj1.getConReconDiff());
		return reconDiff;
	}
	//Returns the Company name by white space using substring
	public String companyNameAndDateSpace(String line, String delims)
	{
		obj1.setConBranch(line.substring(0,8));
		obj1.setConDate(line.substring(8,19));
		obj1.setConBranchCode(line.substring(19,22));
		obj1.setConTotRecon(line.substring(22,32));
		obj1.setConReconDiff(line.substring(33,44));
		obj1.setComCompany(line.substring(43,59));
		return obj1.getComCompany()+", Date : "+obj1.getConDate();
	}
	//Returns the Company name by white space using StringTokenizer
	public String companyNameAndDate(String line, String delims)
	{
		
		StringTokenizer st = new StringTokenizer(line, delims);
		obj1.setConBranch(st.nextToken());
		obj1.setConDate(st.nextToken());
		obj1.setConBranchCode(st.nextToken());
		obj1.setConTotRecon(st.nextToken());
		obj1.setConReconDiff(st.nextToken());
		obj1.setComCompany(st.nextToken());
		return obj1.getComCompany()+", Date : "+obj1.getConDate();
	}
}
