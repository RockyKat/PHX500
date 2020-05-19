package ngdemo.phxpoi.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ngdemo.phxpoi.domain.PHXPOI;
import ngdemo.tools.console.StartUp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.Iterator;

public class PHXPOIService {
	
	   StartUp startUpLog;
	   int indexType;
	   String strOutLog = null;
	
	public PHXPOI getDefaultPOI(StartUp start, int index) 
	{
       	
        startUpLog = start;
       	indexType = index;

       	try 
       	{
   			strOutLog = startUpLog.readStdOutLogFile(indexType);
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		
       	
           PHXPOI poi = new PHXPOI();
           poi.setFirstName("Apache POI");
           poi.setLastName("Demo Excel File Access");
           poi.setBmp("apache_poi_small.jpg");
           poi.setStrOutLog(strOutLog);

           return poi;
       }
   
	public void doDemoWrite()
	{
        String[] books = {
            "The Tempest",
            "Gitanjali",
            "Harry Potter"
        };
        String[] authors = {
            "William Shakespeare",
            "Rabindranath Tagore",
            "J. K. Rowling"
        };
        try
        {
       
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        sheet.setColumnWidth((short) 0, (short)((50 * 8) / ((double) 1 / 20)));
        sheet.setColumnWidth((short) 1, (short)((50 * 8) / ((double) 1 / 20)));
        workbook.setSheetName(0, "XSSFWorkbook example");
        Font font1 = workbook.createFont();
        font1.setFontHeightInPoints((short) 10);
        font1.setColor((short) 0xc); // make it blue
        font1.setBold(true);
        XSSFCellStyle cellStyle1 = (XSSFCellStyle) workbook.createCellStyle();
        cellStyle1.setFont(font1);
        Font font2 = workbook.createFont();
        font2.setFontHeightInPoints((short) 10);
        font2.setColor((short) Font.COLOR_NORMAL);
        XSSFCellStyle cellStyle2 = (XSSFCellStyle) workbook.createCellStyle();
        cellStyle2.setFont(font2);
        Row headerRow = sheet.createRow(0);
        Cell cell1 = headerRow.createCell(0);
        cell1.setCellValue("Book");
        cell1.setCellStyle(cellStyle1);
        Cell cell2 = headerRow.createCell(1);
        cell2.setCellValue("Author");
        cell2.setCellStyle(cellStyle1);
        int rownum;
        Row row = null;
        Cell cell = null;
        for (rownum = (short) 1; rownum <= books.length; rownum++) {
            row = sheet.createRow(rownum);
            cell = row.createCell(0);
            cell.setCellValue(books[rownum - 1]);
            cell.setCellStyle(cellStyle2);
            cell = row.createCell(1);
            cell.setCellValue(authors[rownum - 1]);
            cell.setCellStyle(cellStyle2);
        }
        String FILE_NAME  = "./xssf_example.xlsx";
               
        FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        }
        catch (Exception ee)
        {
        	ee.printStackTrace();
        }
    }
	
	public void doDemoRead() 
	{
		    try
		    {
		     System.out.println("\nTESTING EXCEL FILE READ BY POI");	
	        //final String FILE_NAME = "./xssf_example.xlsx";
		    String ruleFile = "/com/rule/xssf_example.xlsx";
			InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
		    //FileInputStream  ex = new FileInputStream(InputStream)		    	
	       // FileInputStream excelInputStream = new FileInputStream(new File(FILE_NAME));
	        Workbook workbook = new XSSFWorkbook(resourceAsStream);
	        Sheet sheet = workbook.getSheetAt(0);
	        Iterator < Row > rowItr = sheet.iterator();
	        int rowNum = 0;
	        while (rowItr.hasNext()) {
	            Row row = rowItr.next();
	            Iterator < Cell > cellItr = row.iterator();
	            System.out.print(rowNum + ". ");
	            while (cellItr.hasNext()) {
	                Cell cell = cellItr.next();
	                if (cell.getCellTypeEnum() == CellType.STRING) {
	                    System.out.print(cell.getStringCellValue() + "\t\t");
	                } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
	                    System.out.print(cell.getNumericCellValue() + "\t\t");
	                }
	            }
	            System.out.println();
	            rowNum++;
	        }
	        workbook.close();
	       // excelInputStream.close();
	        resourceAsStream.close();
	    }
		catch (Exception ee)
		    {
			ee.printStackTrace();
		    }
	}	
	
	
	public void ReadExcelFormula ()
	{
		try
		{
	    System.out.println("\nTESTING READING EXCEL FILE FORMULA BY POI");
	    String ruleFile = "/com/rule/FormulaMultiply.xlsx";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);		
						
			//assuming xlsx file
			Workbook workbook = new XSSFWorkbook(resourceAsStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) 
	        {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
	            
	            while (cellIterator.hasNext()) 
	            {
	            	Cell cell = cellIterator.next();
	            	switch(cell.getCellType()){
	            	case Cell.CELL_TYPE_NUMERIC:
	            		System.out.println("NUMERIC INPUT: "+cell.getNumericCellValue());
	            		break;
	            	case Cell.CELL_TYPE_FORMULA:
	            		System.out.println("Cell Formula="+cell.getCellFormula());
	            		System.out.println("Cell Formula Result Type="+cell.getCachedFormulaResultType());
	            		if(cell.getCachedFormulaResultType() == Cell.CELL_TYPE_NUMERIC){
	            			System.out.println("Formula Value="+cell.getNumericCellValue());
	            		}
	            	}
	            }
	        }
		}
		catch (Exception ee)
		{
			ee.printStackTrace();
		}
   }	
	
}