package com.dao;
import java.util.StringTokenizer;
import com.modal.Reconcile;
/*
 * This class setting the values to object
 * @ Sunil Birute
 * Date 27-06-2016
 */
public class ReconcileDAO 
{
	Reconcile obj1 = new Reconcile();

	//Setting values to object using StringTokenizer with passing delimiter
	public Reconcile calculateReconDiff(String line, String delims)
	{
		Reconcile objr1 = new Reconcile();
		StringTokenizer st = new StringTokenizer(line, delims);
		objr1.setConBranch(st.nextToken());
		objr1.setConDate(st.nextToken());
		objr1.setConBranchCode(st.nextToken());
		objr1.setConTotRecon(Double.parseDouble(st.nextToken()));
		objr1.setConReconDiff(Double.parseDouble(st.nextToken()));
		objr1.setComCompany(st.nextToken());
		return objr1;
	}
	
	//Setting values to object using Sub String with passing delimiter	
	public Reconcile calReconDiff(String line, String delims)
	{
		Reconcile objr1 = new Reconcile();
		objr1.setConBranch(line.substring(0,8));
		objr1.setConDate(line.substring(8,19));
		objr1.setConBranchCode(line.substring(19,22));
		objr1.setConTotRecon(Double.parseDouble(line.substring(22,32)));
		objr1.setConReconDiff(Double.parseDouble(line.substring(33,44)));
		objr1.setComCompany(line.substring(43,59));
		return objr1;
	}

}