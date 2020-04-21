package tool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ABC {
	
	public static void main(String[] args) throws IOException {
		ABC hh= new ABC();
		
		hh.summaryreport("1aa","nn","India1");
		hh.summaryreport("1aa","nn","India2");
		hh.summaryreport("1aa","nn","India3");

	}
	public void summaryreport(String sheetNm,String colNm,String Errormsg) throws IOException {
		System.out.println(sheetNm + " " + colNm + " " + Errormsg);
		
		String mainpath = "D:\\Tool_AutoDataSh\\Sat_Apr_18_21_59_10_IST_2020" +"\\sumarry.txt";
		String textToAppend = sheetNm + "--" + colNm + "--" + Errormsg;
		BufferedWriter writer = new BufferedWriter(new FileWriter(mainpath,true));
		writer.newLine();   //Add new line
	    writer.write(textToAppend);
	    writer.close();	  
		
	}
}


/*String textToAppend = sheetNm + "--" + colNm + "--" + Errormsg;

BufferedWriter writer;
try {
	fw = new FileWriter(mainpath,true);
	writer = new BufferedWriter(fw);
	writer.newLine();   //Add new line
	writer.write(textToAppend);
    writer.close();
} 
	
catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally{
    if(fw != null){
    	fw.close();
    }*/