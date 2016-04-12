package eLeave.Domain;

import java.util.ArrayList;
import java.util.List;

public class HRStaff extends Staff{

	
	
	public HRStaff(String pstaffID, String pstaffName, Staff psupervisor, int prole){
		
		super(pstaffID, pstaffName, psupervisor, prole);
	}

	

	/* 
	 * -----Return code 0 : create user successfully
	 * -----Return code 1 : user exists, fail to create user
	 */
	public int createUser(String pstaffID, String pstaffName, Staff psupervisor, StaffDB pdb, int prole){

		boolean userExist=false;
		
		for (Staff tmpStaff : pdb.getStaffList()) {
		
			if(tmpStaff.getStaffID().equals(pstaffID) && tmpStaff.getStaffName().equals(pstaffName)) {
				//-----[User exists]
				userExist=true;
			}
		}
		
		if(!userExist){
			Staff d =  new Staff(pstaffID,pstaffName,psupervisor,3);
			pdb.addStaffToList(d);
			return 0;
		}
		else{
			return 1;
		}
	}


	/*
	 * -----Return code 0 : delete user successfully
	 * -----Return code 1 : user not exists, fail to delete
	 */
	public int deleteUser(String pstaffName, StaffDB pdb){

		boolean userExist=false;
		int runningIndex=0,targetIndex=0;
		
		for (Staff tmpStaff : pdb.getStaffList()) {
		
			if(tmpStaff.getStaffName().equals(pstaffName)) {
				//-----[User remove]
				tmpStaff=null;
				targetIndex=runningIndex;	
				userExist=true;
			}
		
		runningIndex++;		
		}
		
		if(userExist && !pstaffName.equals("Mr. Director") && !pstaffName.equals("Mr. HR Admin")){
			pdb.removeStaffFromList(targetIndex);
			return 0;		
		}
		else{
			System.out.println("User not found or cannot be removed");
			return 1;
		}
				
	}

	

}
