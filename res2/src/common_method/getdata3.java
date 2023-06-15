package common_method;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class getdata3{
	public static ArrayList<String> getDataExcel(String testSheetName, String testCaseName) throws IOException
	{ 
		
		ArrayList<String>arrayData = new ArrayList<String>();
		//Step1-locate excel data file by creating object of file inputstream 
				FileInputStream fis= new FileInputStream(new File("C:\\Users\\admin\\Desktop\\req.xlsx"));
				//Step2-Create object of workbook to open file 
		
		//step 2 create the object of XSSFWorkbook to open the excel file
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		// step 3 access the desired sheet
		// step3.1 fetch the count of sheet available in th excel file
		int countOfSheet = workbook.getNumberOfSheets();
		
		//step 3.2 fetch the name of sheet and compare against desired sheet name
		for(int i=0; i<countOfSheet; i++)
		{
			String sheetname = workbook.getSheetName(i);
			if (sheetname.equalsIgnoreCase(testSheetName))
			{
		       // step 4 access the sheet and iterate through rows to fetch the column in which test cate name column is found
				XSSFSheet Sheet = workbook.getSheetAt(i);
				//Step 4.1 create iterator for rows 
			    Iterator<Row> Rows = Sheet.iterator();
			    Row firstRow = Rows.next();
			    
			    //Step 4.2 create iterator for cells 
			    Iterator<Cell> Cells = firstRow.cellIterator();
			    
				

			    int j=0;
			    int tc_column=0;
			    
			    //step 4.3 Read the cell values of row no1 to compare against the  test case name 
			    while(Cells.hasNext())
			    { 
			    	Cell cellvalue = Cells.next();
			    	if (cellvalue.getStringCellValue().equalsIgnoreCase("testcasename"))
			    	{
			    		tc_column= j;
			    	System.out.println(tc_column);
			  
			    	}
			    	j++;
			    }
			    // Step 5 fetch the data for designated test case
			    while(Rows.hasNext())
			    {
			    	Row dataRow = Rows.next();
			    	if (dataRow.getCell(tc_column).getStringCellValue().equalsIgnoreCase(testCaseName))
			    	{
			    		Iterator<Cell> dataCellvalue = dataRow.cellIterator();
			    		/*while(dataCellvalue.hasNext())
			    		{
			    			String testdata = dataCellvalue.next().getStringCellValue();
			    			System.out.println(testdata);
			    			*/
			    			
			    			Iterator<Cell> cellvaluedata = dataRow.cellIterator();
			    			
	                        while(cellvaluedata.hasNext())
	                        {
	                        	
	                        	
	                            Cell cell = cellvaluedata.next();
	                           
	                            if(cell.getCellType() == CellType.STRING)
	                            {
	                               String  testdata = cell.getStringCellValue();
	                              
	                               arrayData.add(testdata);
	                               
	                               // System.out.println(testdata);
	                            
	                            }
	                            else if( cell.getCellType() == CellType.NUMERIC)
                            {
                               int  testdata= (int) cell.getNumericCellValue();
                             // System.out.println(testdata);
                               
                               String stringtestData= Integer.toString(testdata);
                               arrayData.add(stringtestData);
                            }
	                        
	                        
	                            }
	                            
	                       
			    			
			    			/*CellType datatype=((Cell) dataCellvalue).getCellType();
			    			if(datatype.toString() == "NUMERIC") {
			    				
			    				
			                int inttestData=(int) ((Cell) dataCellvalue).getNumericCellValue();   
			    			System.out.println(inttestData);
			    			}
			                else {
			                	if(datatype.toString() == "STRING") {
				    				
				    				
					                String testdata1 =((Cell) dataCellvalue).getStringCellValue();   
					    			
			                	System.out.println(testdata1);
			                	}*/
			                }
			    		}
			    	}
			    }
		return arrayData;
	
            }
			
		}
	
	

