package eLeave.Domain;

public class LeaveApplication {

	private Staff applicant;
	private String startDate;
	private String endDate;
	private String status; 

	public LeaveApplication(Staff papplicant, String pstartDate, String pendDate, String pstatus) {

		this.applicant = papplicant;
		this.startDate = pstartDate;
		this.endDate = pendDate;
		this.status = pstatus;

	}

	
	public String getStatus() {
		
		return this.status;
	}

	public String getApplicantName() {
		
		return this.applicant.getStaffName();
	}


	public String getStartDate() {
		
		return this.startDate;
	}

	public String getEndDate() {
		
		return this.endDate;
	}
	

	public void setStatus(String pstatus) {
	
		this.status = pstatus;
	}


}
