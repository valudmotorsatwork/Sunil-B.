package com.dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.modal.Reconcile;
/*
 * This Class implement the logic for Reconciliation and writes the Excel and PDF Report
 * @Sunil Birute
 * Date 27-06-2016 
 */
public class ReconcileImpl 
{
	public void ReconcileImplement()
	{
		ReconcileDAO dao= new ReconcileDAO();
		Reconcile objRec= new Reconcile();
		BufferedReader br = null;	
		String line;
		String delims="";
		int count=0;
		try 
		{	
			// Input data file 
			File inputFile = new File("./resources/ass1_input.txt");
			// Output data file
			File outputFile = new File("./resources/ass1_output.txt");
			// Output Excel file
			File outputXlsFile = new File("./resources/ass2_oxls_utput.xlsx");
			// Output PDF file
			OutputStream pdffile = new FileOutputStream(new File("./resources/ass2_pdf_output.pdf"));
			
	        Document document = new Document();
	        PdfWriter.getInstance(document, pdffile);	          
			FileOutputStream outpXlsFile = new FileOutputStream(outputXlsFile);
			
			//Blank workbook
			XSSFWorkbook workbook = new XSSFWorkbook();
			//Create a blank sheet
			XSSFSheet sheet = workbook.createSheet("Bank Reconcilation Report");
			//Excel Setting Style
			XSSFCellStyle style = workbook.createCellStyle();
		    style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		    style.setFillPattern(CellStyle.LESS_DOTS);
            
		    XSSFCellStyle styleGrey = workbook.createCellStyle();
		    styleGrey.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		    styleGrey.setFillPattern(CellStyle.LESS_DOTS);
		    
		    XSSFCellStyle styleRed = workbook.createCellStyle();
		    styleRed.setFillBackgroundColor(IndexedColors.RED.getIndex());
		    styleRed.setFillPattern(CellStyle.LESS_DOTS);
             
		    
		    // pdf table  
		    PdfPTable table=new PdfPTable(6);
		    
			br = new BufferedReader(new FileReader(inputFile));	
			double reconDiff=0; 
			double sumReconDiff=0;
			double totRecon=0; 
			double sumtotRecon=0;
			
			// call Excel File Header
			xlsHeader(sheet,style);
			// call PDF File Header
			pdfHeader(document,table);
		
		    Row dataRow = null;
			while ((line = br.readLine()) != null) 
			{
		
			  
			   if(count!=0)
			   {	
				   if(line.contains("|"))
				   {
					   delims="|";
					   objRec=dao.calculateReconDiff(line,delims);
					   reconDiff=objRec.getConReconDiff();
					   totRecon=objRec.getConTotRecon();
					   if(reconDiff>=3000)
					   {
						   xlsWriteData(sheet, styleRed, count, objRec);
						   table.getDefaultCell().setBackgroundColor(GrayColor.RED);	      
						   pdfDataWrite(document,table,objRec);
					   }
					   else
					   {
						   xlsWriteData(sheet, styleGrey, count, objRec);
						   table.getDefaultCell().setBackgroundColor(GrayColor.GRAY);
						   pdfDataWrite(document,table,objRec);
					   }			   
				   }
					else if (line.contains(" ")) 
					{
			
						delims=" ";
						objRec=dao.calReconDiff(line, delims);
						reconDiff=objRec.getConReconDiff();
						totRecon=objRec.getConTotRecon();
						 if(reconDiff>=3000)
						   {
							   xlsWriteData(sheet, styleRed, count, objRec);
							   table.getDefaultCell().setBackgroundColor(GrayColor.RED);	      
							   pdfDataWrite(document,table,objRec);
						   }
						 else
						   {
							   xlsWriteData(sheet, styleGrey, count, objRec);
							   table.getDefaultCell().setBackgroundColor(GrayColor.GRAY);
							   pdfDataWrite(document,table,objRec);
						   }
					}
					else if (line.contains(":")) 
					{					
						delims=":";
						
						objRec=dao.calculateReconDiff(line,delims);
						dataRow = sheet.createRow(count);
						reconDiff=objRec.getConReconDiff();
						totRecon=objRec.getConTotRecon();
						 if(reconDiff>=3000)
						   {
							   xlsWriteData(sheet, styleRed, count, objRec);
							   table.getDefaultCell().setBackgroundColor(GrayColor.RED);	      
							   pdfDataWrite(document,table,objRec);
						   }
						 else
						   {
							   xlsWriteData(sheet, styleGrey, count, objRec);
							   table.getDefaultCell().setBackgroundColor(GrayColor.GRAY);
							   pdfDataWrite(document,table,objRec);
						   }			
					}
					else if (line.contains(";")) 
					{
						
						
						delims=";";
						objRec=dao.calculateReconDiff(line,delims);
					    reconDiff=objRec.getConReconDiff();
					    totRecon=objRec.getConTotRecon();
					    if(reconDiff>=3000)
						   {
							   xlsWriteData(sheet, styleRed, count, objRec);
							   table.getDefaultCell().setBackgroundColor(GrayColor.RED);	      
							   pdfDataWrite(document,table,objRec);
						   }
					    else
						   {
							   xlsWriteData(sheet, styleGrey, count, objRec);
							   table.getDefaultCell().setBackgroundColor(GrayColor.GRAY);
							   pdfDataWrite(document,table,objRec);
						   }
					}
				   sumReconDiff=reconDiff+sumReconDiff;
				   sumtotRecon=totRecon+sumtotRecon;
			   }
			   count++;			
			}
			
			dataRow = sheet.createRow(count);		    
		    DecimalFormat df = new DecimalFormat("#.##");
		    		    
			String content="TOT_RECON_DIFF : "+df.format(sumReconDiff)+", TOTAL_RECON  "+df.format(sumtotRecon);
//			System.out.println("****************************************************");
//			System.out.println(content);
//			System.out.println("****************************************************");
//			
			
			
			//Write Excel summary
			dataRow.createCell(0).setCellValue(content);
			table.getDefaultCell().setBackgroundColor(GrayColor.WHITE);
			//Write PDF summary
			document.add(new Paragraph(content));
			
			if (outputFile.exists()) 
			{
				outputFile.delete();
			}
			if (!outputFile.exists()) 
			{
				outputFile.createNewFile();
			}		
			
			// Text File close 
			FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();		
			
			// Excel File Close
		    workbook.write(outpXlsFile);
		    outpXlsFile.close();
		    
		    // PDF file close
		    document.close();		    
		    pdffile.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	// Method for Writing the Header in Excel
	public void xlsHeader(XSSFSheet sheet,XSSFCellStyle style)
	{
		XSSFRow row = sheet.createRow(0);			
		XSSFCell cell = null;
		XSSFCell cel2 = null;
		XSSFCell cel3 = null;
		XSSFCell cel4 = null;
		XSSFCell cel5 = null;
		XSSFCell cel6 = null;
		cell = row.createCell(0);
		cel2 = row.createCell(1);
		cel3 = row.createCell(2);
		cel4 = row.createCell(3);
		cel5 = row.createCell(4);
		cel6 = row.createCell(5);
        cell.setCellValue("Branch Name");
        cell.setCellStyle(style);
        cel2.setCellValue("Date");
        cel2.setCellStyle(style);
        cel3.setCellValue("Branch Code");
        cel3.setCellStyle(style);
        cel4.setCellValue("Total Reconcile");
        cel4.setCellStyle(style);
        cel5.setCellValue("Reconcile Difference");
        cel5.setCellStyle(style);
        cel6.setCellValue("Company Name");
        cel6.setCellStyle(style);
	}
	
	// Method for Writing the Data in Excel
	
	public void xlsWriteData(XSSFSheet sheet,XSSFCellStyle style,int count, Reconcile obj)
	{
		XSSFRow row = sheet.createRow(count);			
		XSSFCell cell = null;
		XSSFCell cel2 = null;
		XSSFCell cel3 = null;
		XSSFCell cel4 = null;
		XSSFCell cel5 = null;
		XSSFCell cel6 = null;
		cell = row.createCell(0);
		cel2 = row.createCell(1);
		cel3 = row.createCell(2);
		cel4 = row.createCell(3);
		cel5 = row.createCell(4);
		cel6 = row.createCell(5);
        cell.setCellValue(obj.getConBranch());
        cell.setCellStyle(style);
        cel2.setCellValue(obj.getConDate());
        cel2.setCellStyle(style);
        cel3.setCellValue(obj.getConBranchCode());
        cel3.setCellStyle(style);
        cel4.setCellValue(obj.getConTotRecon());
        cel4.setCellStyle(style);
        cel5.setCellValue(obj.getConReconDiff());
        cel5.setCellStyle(style);
        cel6.setCellValue(obj.getComCompany());
        cel6.setCellStyle(style);
	}
	
	// Method for Writing the Data in PDF
	public void pdfDataWrite(Document document,PdfPTable table,Reconcile obj)
	{
		try
		{   
		    table.addCell(obj.getConBranch());
		    table.addCell(obj.getConDate());
		    table.addCell(obj.getConBranchCode());
	        table.addCell(String.valueOf(obj.getConTotRecon()));
		    table.addCell(String.valueOf(obj.getConReconDiff()));
		    table.addCell(obj.getComCompany());
		    table.setSpacingBefore(30.0f);       // Space Before table starts, like margin-top in CSS
		    table.setSpacingAfter(30.0f);
		    
		    document.open();
		    document.add(table);
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	      
	}
	
	// Method for Writing the Header in PDF
	public void pdfHeader(Document document,PdfPTable table)
	{
		try
		{
			
			table.getDefaultCell().setBackgroundColor(GrayColor.GREEN);	      
		    table.addCell("Branch Name");
		    table.addCell("Date");
		    table.addCell("Branch Code");
	        table.addCell("Total Reconcile");
		    table.addCell("Reconcile Difference");
		    table.addCell("Company Name");
		    table.setSpacingBefore(30.0f);       
		    table.setSpacingAfter(30.0f);
		    
		    document.open();
		    document.add(table);
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	      
	}
	
}