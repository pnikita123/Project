package restuarant;

import java.io.Serializable;

public class Booking implements Serializable {
	public int bookingNumber;
	public String customerName;
	public int numberOfPplBooking;
	public int tableNumberBooked;
	public Booking next = null;
	public Purchase firstPurchase = null;

	public Booking(int bookingNumber, String customerName, int numberOfPplBooking, int tableNumberBooked) {
		//super();
		this.bookingNumber = bookingNumber;
		this.customerName = customerName;
		this.numberOfPplBooking = numberOfPplBooking;
		this.tableNumberBooked = tableNumberBooked;
		
	}
	
	public int getbookingNumber() {
		return bookingNumber;
	}
	public void setBookingNumber(int bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	
	public String getCustomerName() {
		
		return customerName;
	}
	
	public void setCustomerName(String customerName) {

		this.customerName = customerName;
	}	

	public int getNumberOfPplBooking() {
		return numberOfPplBooking;
	}
	public void setNumberOfPplBooking(int numberOfPplBooking) {
		this.numberOfPplBooking = numberOfPplBooking;
	}
	public int getTableNumberBooked() {
		return tableNumberBooked;
	}
	public void setTableNumberBooked(int tableNumberBooked) {
		this.tableNumberBooked = tableNumberBooked;
	}
		
	@Override
	public String toString() {
		return "Booking [bookingNumber=" + bookingNumber+ ", customerName=" + customerName+ ", numberOfPplBooking=" + numberOfPplBooking+ ", tableNumberBooked=" + tableNumberBooked+ "]";
	}


}
