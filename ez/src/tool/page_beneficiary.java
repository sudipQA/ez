package tool;

import org.apache.commons.math3.util.Pair;

public class page_beneficiary {
	
	public Pair<Integer, String>  benechecksecond(String val1,String val2) {
		if(val1.equalsIgnoreCase(val2)) {
		String	Errormsg = " Second Bene Length is wrong";
		return new Pair<Integer, String>(2, Errormsg); 
		}else {
			String	Errormsg1 = "Length is right";
			return new Pair<Integer, String>(1, Errormsg1); 

		}
	}	
	public  Pair<Integer, String>  benecheckthird(String val1,String val2) {
		if(val1.equalsIgnoreCase(val2)) {
			String	Errormsg = " Third bene Length is wrong";
			return new Pair<Integer, String>(2, Errormsg); 
		}else {
			String	Errormsg1 = "Length is right";
			return new Pair<Integer, String>(1, Errormsg1); 
		}
	}	

}
