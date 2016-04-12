******************************
COMP5134 ¡V Individual Programming Project
Student Name : Lee Tsun Yin, Julian
Student ID : 14027517G
Version : 1.1
******************************


Constraint
******************************
1) Since the program is compiled by [32-bit JDK8], therefore please use [32-bit JRE8] to run the dist/eLeave.jar

2) For the best view, please use 1280 x 1024

3) The Director and HRAdmin object instances are not allowed to be removed.

4) In order to acquire the current leave application status, sometimes reselect the current staff in the combo box 
   may be required.
******************************


In this project, the package and class structure are as below:-
******************************
eLeave/
	Domain/
		Staff.java
		HRStaff.java
		LeaveApplication.java
		StaffDB.java
		Main.java

	UI/
		GUI.java
******************************


Class Description
******************************
[Class Staff]
The class Staff is used for representing staff in the project. Since each staff has only 
one Supervisor and it is required to assign a staff as another staff¡¦s supervisor, 
therefore there is an attribute(supervisor) with type Staff is defined. 
-----private Staff supervisor; -----

Besides, in order to apply the Chain of Responsibility design pattern, an array list(waitingApprovalList)
of LeaveApplication is defined to store the leave application request from subordinate. 
-----private List<LeaveApplication> waitingApprovalList; -----

In the applyLeave method, the LeaveApplication instance from subordinate will be sent to 
his supervisor¡¦s waitingApprovalList for endorsement or decline. 
-----this.supervisor.waitingApprovalList.add(pleaveApplication); -----

In the handleLeave method, the supervisor can process the LeaveApplication instance(s) from his/her subordinates.
If the staff S chooses ¡§Endorse¡¨, the LeaveApplication instance will be sent to the S¡¦s supervisor 
for further processing. 
-----this.supervisor.waitingApprovalList.add(pleaveApplication); -----

If the staff S chooses ¡§Decline¡¨, the leave application will not be further pass up. The leave application 
will be removed from S¡¦s waitingApprovalList and his subordinate can check the leave application status 
from the myApplicationList accordingly.
-----this.waitingApprovalList.remove(CurrSelectedLeaveAppIndex); ----- 
-----private List<LeaveApplication> myApplicationList; -----

There is an attribute(int role) to identify the role in the program.
1 : Director
2 : HR Admin
3 : Normal Staff


[Class HRStaff]
The class HRStaff is the subclass of class Staff, it is used for representing the Human Resource Staff, 
only HRStaff can add or remove staff. It not only extends the class Staff but also with 2 additional methods, 
createUser() and deleteUser() for adding and removing Staff object instances.


[Class LeaveApplication]
The class LeaveApplication is used for representing the leave application. 


[Class StaffDB]
The class StaffDB is used for storing 12 preset staff and create the according runtime Staff ArrayList for the program. 

Since only one staff(Director) is allowed to have no supervisor, therefore the Director object instance 
will has a null value in the supervisor attribute as below.
-----Staff directorObj = new Staff("DIR1111","Mr. Director",null,1); -----

Besides, a staff can supervise multiple staff, therefore the design are as below. 
For example, the staffAObj is supervising the staffBObj and staffCObj.
-----Staff staffAObj = new Staff("A1111","Ms. A",directorObj,3); -----
-----Staff staffBObj = new Staff("B2222","Mr. B",staffAObj,3); -----
-----Staff staffCObj = new Staff("C3333","Mr. C",staffAObj,3); -----


[Class Main]
The class Main is the main class of the project, it contains the public static void main() method to start the program.
In addition, it will new a StaffDB object instance and GUI object instance.


[Class GUI]
The class GUI is responsible for all graphical user interface of the project. It is also responsible for capturing inputs and displaying outputs.
******************************
