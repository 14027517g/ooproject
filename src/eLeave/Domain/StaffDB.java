package eLeave.Domain;

import java.util.ArrayList;
import java.util.List;

public class StaffDB {

	private List<Staff> runTimeStaffList = new ArrayList<Staff>();
	 
	public StaffDB() {
		
		Staff directorObj =  new Staff("DIR1111","Mr. Director",null,1);
		Staff hradminObj =  new HRStaff("HR1111","Mr. HR Admin",directorObj,2);
		
		Staff staffAObj =  new Staff("A1111","Ms. A",directorObj,3);
		Staff staffBObj =  new Staff("B2222","Mr. B",staffAObj,3);
		Staff staffCObj =  new Staff("C3333","Mr. C",staffAObj,3);
		Staff staffDObj =  new Staff("D4444","Mr. D",staffBObj,3);
		Staff staffEObj =  new Staff("E5555","Mr. E",staffBObj,3);
		Staff staffFObj =  new Staff("F6666","Mr. F",directorObj,3);
		Staff staffGObj =  new Staff("G7777","Mr. G",staffFObj,3);
		Staff staffHObj =  new Staff("H8888","Mr. H",staffFObj,3);
		Staff staffIObj =  new Staff("I9999","Mr. I",staffHObj,3);
		Staff staffJObj =  new Staff("J1111","Mr. J",staffHObj,3);
		
		this.runTimeStaffList.add(directorObj);
		this.runTimeStaffList.add(hradminObj);
		this.runTimeStaffList.add(staffAObj);
		this.runTimeStaffList.add(staffBObj);
		this.runTimeStaffList.add(staffCObj);
		this.runTimeStaffList.add(staffDObj);
		this.runTimeStaffList.add(staffEObj);
		this.runTimeStaffList.add(staffFObj);
		this.runTimeStaffList.add(staffGObj);
		this.runTimeStaffList.add(staffHObj);
		this.runTimeStaffList.add(staffIObj);
		this.runTimeStaffList.add(staffJObj);
	}
	

	public List<Staff> getStaffList() {
			
		return this.runTimeStaffList;
	}


	public void addStaffToList(Staff pstaff) {
		
		this.runTimeStaffList.add(pstaff);
	}
	
	
	public void removeStaffFromList(int pstaffIndex) {
	
		this.runTimeStaffList.remove(pstaffIndex);
	}


}
