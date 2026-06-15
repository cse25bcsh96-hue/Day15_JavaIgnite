package JAVA_DAY_15;
class Classroom
{
	boolean attendanceStarted = false;
	
	synchronized public void waitForAttendance(String name)
	{
		while(attendanceStarted==false)
		{
			System.out.println("Student "+name+" waiting....");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Student "+name+" Marked Present");
	}
	
	synchronized public void startAttendance()
	{
		attendanceStarted= true;
		
		System.out.println("\nTeacher Started Attendance\n");
		
		notifyAll();
	}
}

class TeacherThread extends Thread
{
	Classroom classroom;
	TeacherThread(Classroom classroom)
	{
		this.classroom = classroom;
	}
	public void run()
	{
		classroom.startAttendance();
	}
}

class StudentThread extends Thread
{
	Classroom classroom;
	StudentThread(Classroom classroom)
	{
		this.classroom = classroom;
	}
	public void run()
	{
		classroom.waitForAttendance(Thread.currentThread().getName());
	}
}
public class CLASSROOM_ATTENDANCE_SYSTEM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Classroom attendance = new Classroom();
		StudentThread student1 = new StudentThread(attendance);
		StudentThread student2 = new StudentThread(attendance);
		StudentThread student3 = new StudentThread(attendance);
		StudentThread student4 = new StudentThread(attendance);
		StudentThread student5 = new StudentThread(attendance);
		
		TeacherThread teacher = new TeacherThread(attendance);
		
		student1.setName("STWATRA");
		student2.setName("SUBHENDU");
		student3.setName("BALDEV");
		student4.setName("HRUSHIKESH");
		student5.setName("GURUDUTTA");
		
		student1.start();
		student2.start();
		student3.start();
		student4.start();
		student5.start();
		
		try {
		    Thread.sleep(3000); 
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		teacher.start();

	}

}
