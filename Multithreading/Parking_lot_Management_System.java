package JAVA_DAY_15;
class ParkingLot
{
	int availableSlots = 3;
	
	synchronized public void parkCar(String carName)
	{
		if(availableSlots>0)
		{
			System.out.println(carName+" parked");
			availableSlots-=1;
			
			System.out.println("Available slots: "+availableSlots);
		}
		else
		{
			System.out.println("No parking available for "+carName);
		}
	}
}

class CarThread extends Thread
{
	ParkingLot parkinglot;
	CarThread(ParkingLot parkinglot)
	{
		this.parkinglot = parkinglot;
	}
	public void run()
	{
		parkinglot.parkCar(Thread.currentThread().getName());
	}
	
}
public class PARKING_SLOT_MANAGEMENT_SYSTEM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParkingLot park = new ParkingLot();
		CarThread car1 = new CarThread(park);
		CarThread car2 = new CarThread(park);
		CarThread car3 = new CarThread(park);
		CarThread car4 = new CarThread(park);
		CarThread car5 = new CarThread(park);
		CarThread car6 = new CarThread(park);
		
		car1.setName("RANGE ROVER");
		car2.setName("DEFENDER");
		car3.setName("ENDAVOUR");
		car4.setName("LAND CRUISER");
		car5.setName("HUMMER");
		car6.setName("THAR");
		
		car1.start();
		car2.start();
		car3.start();
		car4.start();
		car5.start();
		car6.start();
		
	}

}
