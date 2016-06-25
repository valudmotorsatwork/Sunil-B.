import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
/*
 * Project for Daily Bank Reconciliation Report  
 */

public class ApplicationReconcile 
{
	String conBranch="";
	String conDate="";
	String conBranchCode="";
	String conTotRecon="";
	String conReconDiff="";
	String comCompany="";	
	//Calculate Reconilation Difference by delimiter    
	public double calculateReconDiff(String line, String delims)
	{
		double reconDiff=0.0d;
		StringTokenizer st = new StringTokenizer(line, delims);
		conBranch=st.nextToken();
		conDate=st.nextToken();
		conBranchCode=st.nextToken();
		conTotRecon=st.nextToken();
		conReconDiff=st.nextToken();
		comCompany=st.nextToken();
		reconDiff=Double.parseDouble(conReconDiff);
		return reconDiff;
	}
	//Calculate Reconilation Difference by delimiter by white space using substring
	public double calReconDiff(String line, String delims)
	{
		double reconDiff=0.0d;
		conBranch=line.substring(0,8);
		conDate=line.substring(8,19);
		conBranchCode=line.substring(19,22);		
		conTotRecon=line.substring(22,32);
		conReconDiff=line.substring(33,44);
		comCompany=line.substring(43,59);
		reconDiff=Double.parseDouble(conReconDiff);
		return reconDiff;
	}
	//Returns the Company name by white space using substring
	public String companyNameAndDateSpace(String line, String delims)
	{
		conBranch=line.substring(0,8);
		conDate=line.substring(8,19);
		conBranchCode=line.substring(19,22);		
		conTotRecon=line.substring(22,32);
		conReconDiff=line.substring(33,44);
		comCompany=line.substring(43,59);	
		return comCompany+", Date : "+conDate;
	}
	//Returns the Company name by white space using StringTokenizer
	public String companyNameAndDate(String line, String delims)
	{
		
		StringTokenizer st = new StringTokenizer(line, delims);
		conBranch=st.nextToken();
		conDate=st.nextToken();
		conBranchCode=st.nextToken();
		conTotRecon=st.nextToken();
		conReconDiff=st.nextToken();
		comCompany=st.nextToken();
		return comCompany+", Date : "+conDate;
	}

	public static void main(String[] args) 
	{

	BufferedReader br = null;
	ApplicationReconcile obj1= new ApplicationReconcile();
	String companyName="";
	File file = new File("./resources/ass1_output.txt");
	try {

		String line;
		br = new BufferedReader(new FileReader("./resources/ass1_input.txt"));
		int count=0;
		String delims="";
		StringTokenizer st = null;
		double reconDiff=0; 
		double sumReconDiff=0;
		while ((line = br.readLine()) != null) 
		{
			
			   if(count!=0)
			   {	
				   if(line.contains("|"))
				   {
					   delims="|";
					   reconDiff=obj1.calculateReconDiff(line,delims);
					   companyName=obj1.companyNameAndDate(line, delims);
//					   System.out.println(" Company "+companyName+ "Total "+reconDiff);
					   
				   }
				else if (line.contains(" ")) 
				{
					delims=" ";
					reconDiff=obj1.calReconDiff(line,delims);
					companyName=obj1.companyNameAndDateSpace(line, delims);
//					System.out.println(" Company "+companyName+ "Total "+reconDiff);

				}
				else if (line.contains(":")) 
				{
					
					delims=":";
					reconDiff=obj1.calculateReconDiff(line,delims);
					companyName=obj1.companyNameAndDate(line, delims);
//					System.out.println(" Company "+companyName+ "Total "+reconDiff);

				}
				else if (line.contains(";")) 
				{
					
					delims=";";
					reconDiff=obj1.calculateReconDiff(line,delims);
					companyName=obj1.companyNameAndDate(line, delims);
//					System.out.println(" Company "+companyName+ "Total "+reconDiff);
				}
				   sumReconDiff=reconDiff+sumReconDiff;
			}
			count++;
			
		}
		String content="TOT_RECON_DIFF : "+sumReconDiff+", Company Name : "+companyName;
		System.out.println("****************************************************");
		System.out.println(content);
		System.out.println("****************************************************");

		if (file.exists()) {
			file.delete();
		}
		if (!file.exists()) {
			file.createNewFile();
		}		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br != null)
				br.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	}
}