package eLeave.Domain;

import java.util.ArrayList;
import java.util.List;

public class Staff {
	
private String staffID;
private String staffName;
private Staff supervisor;
private int role;
private List<LeaveApplication> waitingApprovalList;
private List<LeaveApplication> myApplicationList;


	public Staff(String pstaffID, String pstaffName, Staff psupervisor, int prole) { 
		this.staffID = pstaffID;
		this.staffName = pstaffName;
		this.supervisor = psupervisor;
		this.role = prole;
		this.waitingApprovalList = new ArrayList<LeaveApplication>();
		this.myApplicationList = new ArrayList<LeaveApplication>();
	}
	
	
	public String getStaffID(){
		return this.staffID;
	}

	
	public String getStaffName(){
		return this.staffName;
	}
	

	public Staff getSupervisor(){
		return this.supervisor;
	}

	
	public int getRole(){
		return this.role;
	}


	public List<LeaveApplication> getWaitingApprovalList(){
		return this.waitingApprovalList;
	}

	
	public List<LeaveApplication> getMyApplicationList(){
		return this.myApplicationList;
	}

	
	public void applyLeave(LeaveApplication pleaveApplication) {
	
		this.supervisor.waitingApprovalList.add(pleaveApplication);
		this.myApplicationList.add(pleaveApplication);
	}
	

	
	public void handleLeave(LeaveApplication pleaveApplication, String pstatus) {

		int tmpIndex=0,CurrSelectedLeaveAppIndex=0;
		
		for (LeaveApplication tmpLA : this.waitingApprovalList) {
			if(pleaveApplication.getApplicantName()==tmpLA.getApplicantName()&&
					pleaveApplication.getStartDate()==tmpLA.getStartDate()&&
					pleaveApplication.getEndDate()==tmpLA.getEndDate()){
				CurrSelectedLeaveAppIndex=tmpIndex;
			}
		tmpIndex++;
		}

		
				
		if (!this.waitingApprovalList.isEmpty()) { 
		
			pleaveApplication.setStatus(pstatus);	
			
			if (pstatus == "Declined"){

				//-----[handleLeave() - Application declined]
				this.waitingApprovalList.remove(CurrSelectedLeaveAppIndex);
			}
			
			//-----Status not decline 
			else {
					
				if(this.supervisor != null)	{
					this.supervisor.waitingApprovalList.add(pleaveApplication);
					this.waitingApprovalList.remove(CurrSelectedLeaveAppIndex);
				}
				else
				{
					//-----[handleLeave() - Reach director]
					this.waitingApprovalList.remove(CurrSelectedLeaveAppIndex);
				}	
		
			}
		
		//-----end of !this.waitingApprovalList.isEmpty()
		}
	//-----end of handleLeave()	
	}
	
//-----end of class Staff 	
}
