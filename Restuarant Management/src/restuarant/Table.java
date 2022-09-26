package restuarant;
import java.io.Serializable;

public class Table implements Serializable{

	private static final long serialVersionUID = 1L;
	public int tableNumber;
	public int numberOfSeats;
	public Table next = null;
	public Booking firstBooking = null;
	//public Booking headTable;
	
	//public activeTables;
	
	public Table(int tableNumber, int numberOfSeats) {
		//super();
		
		
		this.tableNumber = tableNumber;
		this.numberOfSeats = numberOfSeats;
	}
	

	public int getTableNumber() {
		return tableNumber;
	}


	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}


	public int getNumberOfSeats() {
		return numberOfSeats;
	}


	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}


	public static void main(String[] args) {

	}



}
