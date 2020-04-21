package tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.util.Pair;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class base {

	
	
	static String autopath;
	static String autocontrol;
	static String testNm;
	
	
//Result
	
	private  FileOutputStream fileOut;
	private XSSFWorkbook workbook ;
	private XSSFSheet sheet ;
	private XSSFRow row  ;
	private XSSFCell cell ;
	public  String outpath;
	public static String valk;	
	//public String mainoutput;
		public	void automain() throws IOException {
	
			
		String outputfile = resfolder();
		//End Result path - outpath
		outpath = outputfile;
		readauto autofile = new readauto(autopath);
		readcontrol controlfile = new readcontrol(autocontrol);
		
		//Pages
		page_beneficiary bene = new page_beneficiary();
	
		int count_SH_Control = controlfile.sheetcount();
		
		//Number of sheet of Controller == Loop 
			for(int i = 0; i < count_SH_Control; i++) {
				String SHName_Control = controlfile.sheetNm(i);
				
		//Number of column of that sheet in controller
				int Count_col_controller	= controlfile.getColumnCount(SHName_Control);
			
				for(int k = 0;k<=Count_col_controller;k++) {
					String colNm_Control = controlfile.getCellData(SHName_Control,k,1);
					
			//	Work with Automation Datasheet to match sheet name and find the match column 
					
					/*
					 * RowNmTc --> Row of the Searched Test Case 
					 * ColNmTC -->Match the Column of the Control with AUtomation Datasheet return column number of automation datasheet
					 * ControlSH_Value --> Next row value(2 - not the header) of Controller sheet
					 * AutoDaSH_Value --> Value from automation datasheet 
					 * 				
					 */
					int RowNmTc = autofile.getCellRowNum(SHName_Control,"TCName",testNm);
					int ColNmTC = autofile.getCellColNum(SHName_Control,colNm_Control);
					
					String ControlSH_Value = controlfile.getCellData(SHName_Control,k,2);
					String AutoDaSH_Value =	autofile.getCellData(SHName_Control,ColNmTC,RowNmTc);
					String otpath =valk;	
					switch(SHName_Control) {
					
					/*
					 * Automation and controller sheet name should be same
					 * Created Switch cases with sheet name
					 * 
					 */
				
					case "Beneficiary":
						
						//Create If loop for each of the column for validation 
						  //Header --> secondName
							if(colNm_Control.equalsIgnoreCase("secondName")) {
								
							
								Pair<Integer, String> p = bene.benechecksecond(AutoDaSH_Value, ControlSH_Value);	
								
								
								if(p.getKey()==1) {
									failReport(SHName_Control,ColNmTC,RowNmTc);
									String errormsg = p.getValue();
									
									summaryreport(SHName_Control,colNm_Control,errormsg,otpath);
								}
							}
						//header --> ThirdName	
							
							if(colNm_Control.equalsIgnoreCase("ThirdName")) {
								Pair<Integer, String> p = bene.benecheckthird(AutoDaSH_Value,ControlSH_Value);	
									
								if(p.getKey()==1) {
										
										failReport(SHName_Control,ColNmTC,RowNmTc);
										String errormg = p.getValue();
										summaryreport(SHName_Control,colNm_Control,errormg,otpath);
									}
								}
							
						
						
						break;
					case "owner":
						break;
						
					
					}
					
				}
					
				
				
			}
			
			
			
		
	}
		
		//Beneficiary Validation :
		/*public int  benechecksecond(String val1,String val2) {
			if(val1.equalsIgnoreCase(val2)) {
			return 2 ;
			}else {
				return 1;
			}
		}	
		public int  benecheckthird(String val1,String val2) {
			if(val1.equalsIgnoreCase(val2)) {
			return 2 ;
			}else {
				return 1;
			}
		}	*/

	
		public String resfolder() {
			
			File file = new File("D:\\Tool_AutoDataSh");
			
			if (!file.exists()) {
	        	file.mkdir();
	        	String path = fileNm();
	        	 valk = path;
	        	copyfile(path);
	        	
	        	 String src = path+"\\datasheetauto.xlsx";
	        	 String tar = path+"\\datasheetautoq.xlsx";
	        	 changefileNm(src,tar);
	        	 createfile();
	        	 
	        	 
	        	return tar;

			}else {
				
				String path = fileNm();
				 copyfile(path);
				 valk = path;
				 String src = path+"\\datasheetauto.xlsx";
	        	 String tar = path+"\\datasheetautoq.xlsx";
	        	 changefileNm(src,tar);
	        	 createfile();
	        	
	        	return tar;

			}
						
		}
		public void createfile() {
			String path = fileNm();
			File myObj = new File(path +"\\sumarry.txt");
			try {
				myObj.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void copyfile(String path) {
			File sourceFile = new File(autopath);
			
			String targetFilePath = path+"\\";
			File targetFile = new File(targetFilePath);
			
			try {
				FileUtils.copyFileToDirectory(sourceFile, targetFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
								     
		
		}
		public String fileNm() {
			Date d = new Date();
			String FileNm  = d.toString().replace(":", "_").replace(" ", "_");
			String path = "D:\\Tool_AutoDataSh\\"+FileNm;
			File fileRest = new File(path);
			fileRest.mkdir();
			return path;

		}
		public void changefileNm(String oldfil,String newfil) {
			File oldfile =new File(oldfil);
			File newfile =new File(newfil);
			if(oldfile.renameTo(newfile)){
				System.out.println("Rename succesful");
				
			}else{
				System.out.println("Rename failed");
				
			}
			
		}

		public  void failReport (String sheetName,int colnum,int rowNum)throws FileNotFoundException, IOException {  
	        try (FileInputStream fis = new FileInputStream(outpath)) {  
	        	
	        	//System.out.println(sheetName + "" + colnum + "" + rowNum );
	        	//System.out.println(outpath);
	        	Workbook wb = new XSSFWorkbook(fis); 
	        	
	        	int index = wb.getSheetIndex(sheetName);
	    		
	        	Sheet sheet = wb.getSheetAt(index);
	        	CellStyle style = wb.createCellStyle();
	        	//style.setFillBackgroundColor(IndexedColors.RED.getIndex());   
	        	///style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	        	
	        	style.setFillBackgroundColor(IndexedColors.RED.getIndex());
	        	style.setFillPattern(CellStyle.THIN_FORWARD_DIAG);
	        	 
	        	Row row0 = sheet.getRow(rowNum);
	    		Cell cellA = row0.getCell(colnum);
	    		cellA.setCellStyle(style);
	            
	    		FileOutputStream fileOut = new FileOutputStream(outpath);

	    		wb.write(fileOut);

	    	    fileOut.close();	
	             
	            }catch(Exception e) {  
	                System.out.println(e.getMessage());  
	            }  
	    }  
		
		public void summaryreport(String sheetNm,String colNm,String Errormsg,String pathout) throws IOException {
			FileWriter fw = null;
			
			//String mainpath = path +"\\sumarry.txt";
			//String mainpath = "D:\\Tool_AutoDataSh\\Sat_Apr_18_21_59_10_IST_2020" +"\\sumarry.txt";
			String mainpath = pathout +"\\sumarry.txt";
			//System.out.println(mainpath);
			String textToAppend = sheetNm + "--" + colNm + "--" + Errormsg;
			BufferedWriter writer = new BufferedWriter(new FileWriter(mainpath,true));
			writer.newLine();   //Add new line
		    writer.write(textToAppend);
		    writer.close();	
			
		    
			
		}
		
		
				
		
		}
