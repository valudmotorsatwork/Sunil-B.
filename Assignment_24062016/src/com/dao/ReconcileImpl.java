package com.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
public class ReconcileImpl 
{
	public void ReconcileImplement()
	{
		ReconcileDAO dao= new ReconcileDAO();
		BufferedReader br = null;
		String companyName="";		
		String line;
		String delims="";
		int count=0;
		try 
		{				
			File inputFile = new File("./resources/ass1_input.txt");
			File outputFile = new File("./resources/ass1_output.txt");
			br = new BufferedReader(new FileReader(inputFile));	
			double reconDiff=0; 
			double sumReconDiff=0;
			while ((line = br.readLine()) != null) 
			{
							
			   if(count!=0)
			   {	
				   if(line.contains("|"))
				   {
					   delims="|";
					   reconDiff=dao.calculateReconDiff(line,delims);
					   companyName=dao.companyNameAndDate(line, delims);					   
				   }
					else if (line.contains(" ")) 
					{
						delims=" ";
						reconDiff=dao.calReconDiff(line,delims);
						companyName=dao.companyNameAndDateSpace(line, delims);
					}
					else if (line.contains(":")) 
					{					
						delims=":";
						reconDiff=dao.calculateReconDiff(line,delims);
						companyName=dao.companyNameAndDate(line, delims);				
					}
					else if (line.contains(";")) 
					{
						
						delims=";";
						reconDiff=dao.calculateReconDiff(line,delims);
						companyName=dao.companyNameAndDate(line, delims);
					}
				   sumReconDiff=reconDiff+sumReconDiff;
			   }
			   count++;			
			}
			String content="TOT_RECON_DIFF : "+sumReconDiff+", Company Name : "+companyName;
			System.out.println("****************************************************");
			System.out.println(content);
			System.out.println("****************************************************");
			if (outputFile.exists()) 
			{
				outputFile.delete();
			}
			if (!outputFile.exists()) 
			{
				outputFile.createNewFile();
			}		
			FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
