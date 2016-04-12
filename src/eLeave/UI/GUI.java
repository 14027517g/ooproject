package eLeave.UI;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;

import eLeave.Domain.HRStaff;
import eLeave.Domain.LeaveApplication;
import eLeave.Domain.Staff;
import eLeave.Domain.StaffDB;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class GUI {
 
	private JFrame frmg;
	
	private JTextField StaffIDtextField;
	private JTextField NametextField;
		
	private JComboBox CurrUsercomboBox;
	private JComboBox SupervisorcomboBox;
	private JComboBox AllUsercomboBox;
	private JComboBox FromYearcomboBox;
	private JComboBox FromMonthcomboBox;
	private JComboBox FromDaycomboBox;
	private JComboBox ToYearcomboBox;
	private JComboBox ToMonthcomboBox;
	private JComboBox ToDaycomboBox;
	private JComboBox WaitApprovalcomboBox;
	private JComboBox MyApplicationcomboBox;
	
	private List<Staff> globalStaffList;
	private HRStaff hradmin;
	private StaffDB db;
	private int currSelectedStaffIndex;
		 
	

	public GUI(StaffDB pdb) {
		this.db=pdb;
		
		this.globalStaffList = pdb.getStaffList();
		
		HRStaff HRObj = (HRStaff) pdb.getStaffList().get(1);
		this.hradmin = HRObj;
		
		this.initialize();
	}

	
	
	private void initialize() {

		
		frmg = new JFrame();
		frmg.setTitle("Individual Project - eLeave Application[14027517G]");
		frmg.setBounds(100, 100, 515, 700);
		frmg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmg.getContentPane().setLayout(null);
	
		JLabel lblCurrentUser = new JLabel("Current Staff");
		lblCurrentUser.setBounds(31, 34, 75, 15);
		frmg.getContentPane().add(lblCurrentUser);
		
		JComboBox CurrUsercomboBox = new JComboBox();
		CurrUsercomboBox.setBounds(136, 31, 150, 21);
		frmg.getContentPane().add(CurrUsercomboBox);
		
		JLabel lblStaffId = new JLabel("Staff ID");
		lblStaffId.setBounds(31, 120, 46, 15);
		frmg.getContentPane().add(lblStaffId);
		
		StaffIDtextField = new JTextField();
		StaffIDtextField.setBounds(136, 117, 150, 21);
		frmg.getContentPane().add(StaffIDtextField);
		StaffIDtextField.setColumns(10);
		StaffIDtextField.setEnabled(false);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(31, 167, 46, 15);
		frmg.getContentPane().add(lblName);
		
		NametextField = new JTextField();
		NametextField.setBounds(136, 164, 150, 21);
		frmg.getContentPane().add(NametextField);
		NametextField.setColumns(10);
		NametextField.setEnabled(false);

		JLabel lblSupervisor = new JLabel("Supervisor");
		lblSupervisor.setBounds(31, 214, 75, 21);
		frmg.getContentPane().add(lblSupervisor);
		
		JComboBox SupervisorcomboBox = new JComboBox();
		SupervisorcomboBox.setBounds(136, 214, 150, 20);
		frmg.getContentPane().add(SupervisorcomboBox);
		SupervisorcomboBox.setEnabled(false);
				
		JButton CreateUserbtn = new JButton("Create Staff");
		CreateUserbtn.setBounds(320, 116, 116, 23);
		frmg.getContentPane().add(CreateUserbtn);
		CreateUserbtn.setEnabled(false);
		
		JLabel lblAllUser = new JLabel("All Staff");
		lblAllUser.setBounds(31, 293, 75, 15);
		frmg.getContentPane().add(lblAllUser);
		
		JComboBox AllUsercomboBox = new JComboBox();
		AllUsercomboBox.setBounds(31, 318, 251, 23);
		frmg.getContentPane().add(AllUsercomboBox);
		AllUsercomboBox.setEnabled(false);
				
		JButton Deletebtn = new JButton("Delete Staff");
		Deletebtn.setBounds(319, 318, 117, 23);
		frmg.getContentPane().add(Deletebtn);
		Deletebtn.setEnabled(false);

		JLabel lblFromDate = new JLabel("From");
		lblFromDate.setBounds(33, 402, 46, 15);
		frmg.getContentPane().add(lblFromDate);
		
		JLabel lblToDate = new JLabel("To");
		lblToDate.setBounds(212, 402, 46, 15);
		frmg.getContentPane().add(lblToDate);
		
		JComboBox FromYearcomboBox = new JComboBox();
		FromYearcomboBox.setEnabled(false);
		FromYearcomboBox.setBounds(33, 427, 57, 21);
		frmg.getContentPane().add(FromYearcomboBox);
		
		JComboBox FromMonthcomboBox = new JComboBox();
		FromMonthcomboBox.setEnabled(false);
		FromMonthcomboBox.setBounds(95, 427, 38, 21);
		frmg.getContentPane().add(FromMonthcomboBox);
		
		JComboBox FromDaycomboBox = new JComboBox();
		FromDaycomboBox.setEnabled(false);
		FromDaycomboBox.setBounds(138, 427, 46, 21);
		frmg.getContentPane().add(FromDaycomboBox);
		
		JComboBox ToYearcomboBox = new JComboBox();
		ToYearcomboBox.setEnabled(false);
		ToYearcomboBox.setBounds(212, 427, 55, 21);
		frmg.getContentPane().add(ToYearcomboBox);
		
		JComboBox ToMonthcomboBox = new JComboBox();
		ToMonthcomboBox.setEnabled(false);
		ToMonthcomboBox.setBounds(273, 427, 39, 21);
		frmg.getContentPane().add(ToMonthcomboBox);
		
		JComboBox ToDaycomboBox = new JComboBox();
		ToDaycomboBox.setEnabled(false);
		ToDaycomboBox.setBounds(317, 427, 47, 21);
		frmg.getContentPane().add(ToDaycomboBox);
		
		JButton ApplyLeavebtn = new JButton("Apply Leave");
		ApplyLeavebtn.setEnabled(false);
		ApplyLeavebtn.setBounds(376, 426, 106, 23);
		frmg.getContentPane().add(ApplyLeavebtn);

		JLabel lblWaitingForYour = new JLabel("Waiting for your apporval list");
		lblWaitingForYour.setBounds(33, 487, 171, 15);
		frmg.getContentPane().add(lblWaitingForYour);

		JComboBox WaitApprovalcomboBox = new JComboBox();
		WaitApprovalcomboBox.setBounds(32, 512, 217, 21);
		frmg.getContentPane().add(WaitApprovalcomboBox);

		JLabel lblYourApplicationList = new JLabel("Your application list");
		lblYourApplicationList.setBounds(31, 561, 144, 15);
		frmg.getContentPane().add(lblYourApplicationList);

		JComboBox MyApplicationcomboBox = new JComboBox();
		MyApplicationcomboBox.setBounds(31, 587, 315, 21);
		frmg.getContentPane().add(MyApplicationcomboBox);

		JButton Endorsebtn = new JButton("Endorse");
		Endorsebtn.setEnabled(false);
		Endorsebtn.setBounds(277, 511, 87, 23);
		frmg.getContentPane().add(Endorsebtn);
		
		JButton Declinebtn = new JButton("Decline");
		Declinebtn.setEnabled(false);
		Declinebtn.setBounds(373, 511, 87, 23);
		frmg.getContentPane().add(Declinebtn);
				
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 264, 449, 2);
		frmg.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 94, 449, 2);
		frmg.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(31, 383, 449, 2);
		frmg.getContentPane().add(separator_2);


		
		//-----add item to CurrUsercomboBox  
		for (Staff tmpStaff : globalStaffList) {
			
			CurrUsercomboBox.addItem(tmpStaff.getStaffName());

		}
		//-----end of add item to CurrUsercomboBox
		
		
		//-----Date comboBox
		for(int tmpYear=2016;tmpYear<=2025;tmpYear++) {
			
			FromYearcomboBox.addItem(tmpYear);
			ToYearcomboBox.addItem(tmpYear);

		}

		for(int tmpMonth=1;tmpMonth<=12;tmpMonth++) {
			
			FromMonthcomboBox.addItem(tmpMonth);
			ToMonthcomboBox.addItem(tmpMonth);

		}


		for(int tmpDay=1;tmpDay<=31;tmpDay++) {
			
			FromDaycomboBox.addItem(tmpDay);
			ToDaycomboBox.addItem(tmpDay);

		}
		//-----end of Date comboBox
		
		CurrUsercomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			if(CurrUsercomboBox.getItemCount()!=0)				
			{				
			//-----set current staff	
			int tmpIndex1=0, tmpIndex2=0;
			for (Staff tmpStaff : globalStaffList) {
				if(tmpStaff.getStaffName().equals(CurrUsercomboBox.getItemAt(CurrUsercomboBox.getSelectedIndex()).toString()))
				{tmpIndex2=tmpIndex1;}
			tmpIndex1++;
			}	
				
			currSelectedStaffIndex=tmpIndex2;
			
			
			//-----Enable and disable button	
			//-----Director
			if(globalStaffList.get(currSelectedStaffIndex).getRole()==1)
			{
				StaffIDtextField.setEnabled(false);
				NametextField.setEnabled(false);
				SupervisorcomboBox.setEnabled(false);
				CreateUserbtn.setEnabled(false);
				AllUsercomboBox.setEnabled(false);
				Deletebtn.setEnabled(false);
				FromYearcomboBox.setEnabled(false);
				FromMonthcomboBox.setEnabled(false);
				FromDaycomboBox.setEnabled(false);
				ToYearcomboBox.setEnabled(false);
				ToMonthcomboBox.setEnabled(false);
				ToDaycomboBox.setEnabled(false);
				ApplyLeavebtn.setEnabled(false);
			}
			//-----HRAdmin
			else if(globalStaffList.get(currSelectedStaffIndex).getRole()==2)
			{
				StaffIDtextField.setEnabled(true);
				NametextField.setEnabled(true);
				SupervisorcomboBox.setEnabled(true);
				CreateUserbtn.setEnabled(true);
				AllUsercomboBox.setEnabled(true);
				Deletebtn.setEnabled(true);
				FromYearcomboBox.setEnabled(true);
				FromMonthcomboBox.setEnabled(true);
				FromDaycomboBox.setEnabled(true);
				ToYearcomboBox.setEnabled(true);
				ToMonthcomboBox.setEnabled(true);
				ToDaycomboBox.setEnabled(true);
				ApplyLeavebtn.setEnabled(true);
			}	
			else
			{
				StaffIDtextField.setEnabled(false);
				NametextField.setEnabled(false);
				SupervisorcomboBox.setEnabled(false);
				CreateUserbtn.setEnabled(false);
				AllUsercomboBox.setEnabled(false);
				Deletebtn.setEnabled(false);
				FromYearcomboBox.setEnabled(true);
				FromMonthcomboBox.setEnabled(true);
				FromDaycomboBox.setEnabled(true);
				ToYearcomboBox.setEnabled(true);
				ToMonthcomboBox.setEnabled(true);
				ToDaycomboBox.setEnabled(true);
				ApplyLeavebtn.setEnabled(true);
			}	
			
			//-----waiting for approval and my app list
			WaitApprovalcomboBox.removeAllItems();
			MyApplicationcomboBox.removeAllItems();
			
			
			if (!globalStaffList.get(currSelectedStaffIndex).getWaitingApprovalList().isEmpty()){
				
				for (LeaveApplication tmpLA : globalStaffList.get(currSelectedStaffIndex).getWaitingApprovalList()) {

					String tmpMessage1=tmpLA.getApplicantName() + " " +
							tmpLA.getStartDate() + " " +
							tmpLA.getEndDate();
					
					WaitApprovalcomboBox.addItem(tmpMessage1);
				}
					Endorsebtn.setEnabled(true);
					Declinebtn.setEnabled(true);
			
			}
			else {
				WaitApprovalcomboBox.addItem("No item in the queue.");
				Endorsebtn.setEnabled(false);
				Declinebtn.setEnabled(false);
			}	

			if (!globalStaffList.get(currSelectedStaffIndex).getMyApplicationList().isEmpty()){
				
				for (LeaveApplication tmpLA2 : globalStaffList.get(currSelectedStaffIndex).getMyApplicationList()) {
				
					String tmpMessage2=tmpLA2.getApplicantName() + " " +
							tmpLA2.getStartDate() + " " +
							tmpLA2.getEndDate() + " " +
							tmpLA2.getStatus();
					
					MyApplicationcomboBox.addItem(tmpMessage2);
				}
			}
			else {
				MyApplicationcomboBox.addItem("No item in the queue.");
			}	

			
			//-----end of waiting for approval and my app list
			
			}
			
			//-----end of CurrUsercomboBox.getItemCount()!=0
			}			
			
		});

		
		//-----add item to SupervisorcomboBox 
		for (Staff tmpStaff : globalStaffList) {
			
			SupervisorcomboBox.addItem(tmpStaff.getStaffName());

		}
		//-----end of add item to SupervisorcomboBox
		

		//-----add item to AllUsercomboBox
		for (Staff tmpStaff : globalStaffList) {
			
			AllUsercomboBox.addItem(tmpStaff.getStaffName());
										
		}
		//-----end of add item to AllUsercomboBox
		

		CreateUserbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int createUserReturnCode;
				
				if(StaffIDtextField.getText().isEmpty() || NametextField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "ID or Name field cannot be empty.");					
				}
				
				else{

				
				String selectedSupervisor = SupervisorcomboBox.getItemAt(SupervisorcomboBox.getSelectedIndex()).toString();
				int tmpIndex=0, supervisorIndex=0;

				for (Staff tmpStaff : globalStaffList) {
					
					if(tmpStaff.getStaffName().equals(SupervisorcomboBox.getItemAt(SupervisorcomboBox.getSelectedIndex()).toString()))
					{supervisorIndex=tmpIndex;}

				tmpIndex++;
				}
		
				
				createUserReturnCode=hradmin.createUser(StaffIDtextField.getText(),NametextField.getText(),globalStaffList.get(supervisorIndex),db,3);
				
				if(createUserReturnCode==0){
					
					//-----refresh item
					CurrUsercomboBox.removeAllItems();
					SupervisorcomboBox.removeAllItems();
					AllUsercomboBox.removeAllItems();
					
					StaffIDtextField.setText("");
					NametextField.setText("");
					
					for (Staff tmpStaff : globalStaffList) {
						
						CurrUsercomboBox.addItem(tmpStaff.getStaffName());
						SupervisorcomboBox.addItem(tmpStaff.getStaffName());
						AllUsercomboBox.addItem(tmpStaff.getStaffName());
						
					}
					//-----end of refresh item
					
					JOptionPane.showMessageDialog(null, "Create staff successfully.");
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Fail to create staff, staff exists.");
				}
				
				
				//-----end of check empty
				}
			//-----end of action perform
			}
		});
		

		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int deleteUserReturnCode;

				deleteUserReturnCode=hradmin.deleteUser(AllUsercomboBox.getItemAt(AllUsercomboBox.getSelectedIndex()).toString(),db);
				
				if(deleteUserReturnCode==0){
				
					//-----refresh item
					CurrUsercomboBox.removeAllItems();
					SupervisorcomboBox.removeAllItems();
					AllUsercomboBox.removeAllItems();
							
				
					for (Staff tmpStaff : globalStaffList) {
					
					SupervisorcomboBox.addItem(tmpStaff.getStaffName());
					AllUsercomboBox.addItem(tmpStaff.getStaffName());
					CurrUsercomboBox.addItem(tmpStaff.getStaffName());

					}
					//-----end of refresh item
					
					JOptionPane.showMessageDialog(null, "Remove staff successfully.");
				
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Staff cannot be removed.");
				}

				
			}
		});
		
		
		
		ApplyLeavebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				String LAFromDate = FromYearcomboBox.getSelectedItem().toString() + "-" +
									FromMonthcomboBox.getSelectedItem().toString() + "-" +
									FromDaycomboBox.getSelectedItem().toString();
						
				String LAToDate = ToYearcomboBox.getSelectedItem().toString() + "-" +
						ToMonthcomboBox.getSelectedItem().toString() + "-" +
						ToDaycomboBox.getSelectedItem().toString();

				
				LeaveApplication LeaveAppObj = new LeaveApplication(globalStaffList.get(currSelectedStaffIndex),LAFromDate,LAToDate,"Submitted");
				
				globalStaffList.get(currSelectedStaffIndex).applyLeave(LeaveAppObj);
				
				//-----refresh combobox
				MyApplicationcomboBox.removeAllItems();

				if (!globalStaffList.get(currSelectedStaffIndex).getMyApplicationList().isEmpty()){
					for (LeaveApplication tmpLA2 : globalStaffList.get(currSelectedStaffIndex).getMyApplicationList()) {
						String tmpMessage2=tmpLA2.getApplicantName() + " " +
											tmpLA2.getStartDate() + " " +
											tmpLA2.getEndDate() + " " +
											tmpLA2.getStatus();
									
									MyApplicationcomboBox.addItem(tmpMessage2);
					}
				}
				else {
					MyApplicationcomboBox.addItem("No item in the queue.");
				}	
				//-----end of refresh combobox				
				
							
				JOptionPane.showMessageDialog(null, "Leave applied.");
				
			}
		});

		
		

		Endorsebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int currSelectedWaitingApprovalIndex=0;
				String tmpStatusMessage;
				
				if(globalStaffList.get(currSelectedStaffIndex).getRole()==1){
					globalStaffList.get(currSelectedStaffIndex).handleLeave(globalStaffList.get(currSelectedStaffIndex).getWaitingApprovalList().get(WaitApprovalcomboBox.getSelectedIndex()), "Approved");
					tmpStatusMessage="Approved";
				}
				else {
					globalStaffList.get(currSelectedStaffIndex).handleLeave(globalStaffList.get(currSelectedStaffIndex).getWaitingApprovalList().get(WaitApprovalcomboBox.getSelectedIndex()), "Endorsed");
					tmpStatusMessage="Endorsed";
				}

				
				//-----refresh combobox
				WaitApprovalcomboBox.removeAllItems();
				
				if (!globalStaffList.get(currSelectedStaffIndex).getWaitingApprovalList().isEmpty()){
					
					for (LeaveApplication tmpLA : globalStaffList.get(currSelectedStaffIndex).getWaitingApprovalList()) {

						String tmpMessage1=tmpLA.getApplicantName() + " " +
								tmpLA.getStartDate() + " " +
								tmpLA.getEndDate();
						
						WaitApprovalcomboBox.addItem(tmpMessage1);
					}
				
				}
				else {
					WaitApprovalcomboBox.addItem("No item in the queue.");
				}	
				//-----end of refresh combobox
				
				
				Endorsebtn.setEnabled(false);
				Declinebtn.setEnabled(false);
				
				JOptionPane.showMessageDialog(null, "Leave " + tmpStatusMessage + ".");
			}
		});
		
		

		Declinebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				globalStaffList.get(currSelectedStaffIndex).handleLeave(globalStaffList.get(currSelectedStaffIndex).getWaitingApprovalList().get(WaitApprovalcomboBox.getSelectedIndex()), "Declined");
				
				//-----refresh combobox
				WaitApprovalcomboBox.removeAllItems();
				
				if (!globalStaffList.get(currSelectedStaffIndex).getWaitingApprovalList().isEmpty()){
					
					for (LeaveApplication tmpLA : globalStaffList.get(currSelectedStaffIndex).getWaitingApprovalList()) {

						String tmpMessage1=tmpLA.getApplicantName() + " " +
								tmpLA.getStartDate() + " " +
								tmpLA.getEndDate();
						
						WaitApprovalcomboBox.addItem(tmpMessage1);
					}
				
				}
				else {
					WaitApprovalcomboBox.addItem("No item in the queue.");
				}	
				//-----end of refresh combobox

				Endorsebtn.setEnabled(false);
				Declinebtn.setEnabled(false);

				JOptionPane.showMessageDialog(null, "Leave declined.");
			}
		});
		
						

		frmg.setVisible(true);		
		
		
	
		
		
		
	//----end of init
	}
}
