package eLeave.Domain;

import eLeave.UI.GUI;

public class Main {

	public static void main(String[] args) {

		//-----Preset some staff  
		StaffDB db =  new StaffDB();

		try {
	
			GUI runTimeUI = new GUI(db); 

		} 
		catch (Exception e) {

			e.printStackTrace();
		
		}
		
	}

		
}
