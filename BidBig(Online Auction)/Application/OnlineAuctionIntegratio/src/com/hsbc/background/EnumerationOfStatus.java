package com.hsbc.background;

public class EnumerationOfStatus{
	
	public EnumerationOfStatus() {
		// TODO Auto-generated constructor stub
	}
	
	public String getValue(String s)
	{
		if(s.equals("O"))
			return "Open";
		else if(s.equals("W"))
			return "Won";
		else if(s.equals("L"))
			return "Lost";
		else if(s.equals("C_W"))
			return "Completed and Won ";
		else if(s.equals("C_L"))
			return "Completed and Lost";
		else if(s.equals("N"))
			return "New";
		else 
			return "Not Known";
		
	}

}
