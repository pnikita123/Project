package restuarant;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;



public class Menu implements Serializable {
        private static Scanner sc= new Scanner(System.in);
         

	public Table headTable=null;
	private int tableNum=0;
    private Booking firstBooking=null;
    private int bookingNum=0;
    private FoodMenu firstFdItem=null;
    private int fdMenuNum=0;
	private Purchase firstPurchase = null;
    private int purchase=0;
	private FoodMenu fdm;
 
	public static void main(String[] args) {
		
		
        
		Menu app = new Menu();
		app.runMenu();
		
		try {
			app = Menu.load();
			app.runMenu();
			
		} catch (Exception e) {
			app = new Menu();
			app.runMenu();
		}
	}
	
	private static Menu load() {
		// TODO Auto-generated method stub
		return null;
	}

	private int mainMenu() {
		System.out.println("*****************************************");
		System.out.println("               WELCOME");
		System.out.println("   .....Restuarent Management System......");
		System.out.println("*****************************************");
		System.out.println("----------------------------------------");
		System.out.println("_________MENU_________");
		System.out.println("----------------------------------------");
		System.out.println("  1. Veg Menu");
		System.out.println("  2. Non-Veg Menu");
		System.out.println("----------------------------------------");
		
		
		System.out.println("****TABLE MENU****");
		System.out.println("----------------------------------------");
		System.out.println("  3. Add a Table");
		System.out.println("  4. View Table");
		System.out.println("----------------------------------------");
		System.out.println("****BOOKING MENU****");
		System.out.println("----------------------------------------");
		System.out.println("  5. Add a Booking");
		System.out.println("  6. View Booking");
		System.out.println("  7. Delete Booking");
		System.out.println("----------------------------------------");
		System.out.println("  8. Add New Food Order");
		System.out.println("  9. View Food ordered");
		System.out.println("  10. Delete Food ordered");
		System.out.println("-----------------------------------------");
		System.out.println("****PURCHASE MENU****");
		System.out.println("-----------------------------------------");
		System.out.println("  11. Add a Purchase");
	        System.out.println("  12. View All Purchases");
	        System.out.println("  13. Delete Purchase");
	        System.out.println("  14. View All Tables & Bookings & Orders");
	        System.out.println("  15. Reset");
	        System.out.println("  16. Check Out!");
	        System.out.println("   0. Exit");
		System.out.println("********************************************");
		System.out.println("********************************************");
		
		System.out.print("--> ");
		int option = sc.nextInt();
		return option;
	}

	
	private void runMenu() {
		int option = mainMenu();
		while (option != 0) {

			switch (option) {
			case 1:
				System.out.println("Veg Menu");
				System.out.println("   1. Panner Masala       200/-");
				System.out.println("   2. Dal makhani         250/-");
				System.out.println("   3. Pakora               80/-");
				System.out.println("   4. Kofta               180/-");
				System.out.println("   5. Pulav               100/-");
				System.out.println("   6. Gira Rice           120/-");
				System.out.println("   7. Mix Veg             160/-");
				System.out.println("   8. Roti                 45/-");
				System.out.println("   9. Aloo Tikki          100/-");
				System.out.println("   10.Sweet Potato         90/-");
			
				break;
			case 2:
				System.out.println("Non-Veg Menu");
				System.out.println("   1. Grilled Chicken       250/-");
				System.out.println("   2. Mutton Korma          350/-");
				System.out.println("   3. Tandoori              200/-");
				System.out.println("   4. Fish Fry              180/-");
				System.out.println("   5. Biryani               180/-");
				System.out.println("   6. Lemon Chicken         170/-");
				System.out.println("   7. Egg Curry             100/-");
				
			
				
				break;
			case 3:
				addTable();
				break;
			case 4:
				viewTables();
				break;
			
			case 5 :
				addBooking();
				break;
			case 6:
				viewBookings();
				break;
			case 7:
				sc.nextLine();
				deleteBookings(promptForString("Enter Customer Name to delete"));
				break;
			case 8:
				addNewFoodAndDrinkItem();
				break;
			case 9:
				viewFoodItems();
				break;
			case 10:
				sc.nextLine();
				deleteFoodItems(promptForString("Enter item to delete"));
				break;
			case 11:
				addPurchase();
				break;
			case 12:
				viewAllPurchases();
				break;
			case 13: 
				sc.nextLine();
				deletePurchases(promptForString("Enter Item Purchased to delete"), firstBooking);
				break;
			case 14:
				viewAllTablesAndBookings();
				break;
			
			case 15:
				reset();
				break;
		
			case 16:
				try {
					load();
				} catch (Exception e) {
					System.out.print("Error reading from file: " + e);
				}
				break;
			
				
			default:
				System.out.println("Invalid option entered: " + option);
				break;
			}
			
			
			System.out.println("\nPress any key to continue...");
			sc.nextLine();
			sc.nextLine(); 
			
			option = mainMenu();
		}


		System.out.println("Exiting... bye");
		System.exit(0);
	}
	

	public String promptForString(String prompt) {
		System.out.print(prompt+": ");
		return sc.nextLine();
	}
	
		public void addTable() {
			System.out.print("Please Enter the number of seats: ");
			int numberOfSeats = sc.nextInt();
		
			tableNum++;
			Table nt=new Table(tableNum,numberOfSeats);
			
			nt.next=headTable;
			headTable=nt;			
		}

		
		public void viewTables() {
			Table temp=headTable;
			System.out.print("Table Details"+" \n ");
			while(temp!=null){
				System.out.print("\t"+"Table No. "+temp.getTableNumber()+", Seats "+temp.getNumberOfSeats()+ " \n ");
				temp=temp.next;
			}
		}
		
		
		 public void addBooking() {
			System.out.print("Please Enter your Name: ");
			String customerName = sc.nextLine();
			customerName = sc.nextLine();
			System.out.print("Number of People booking: ");
			int numberOfPplBooking= sc.nextInt();
			System.out.print("Table Number being booked: ");
			int tableNumberBooked = sc.nextInt();
			
			bookingNum++;
			Booking nb=new Booking(bookingNum,customerName,numberOfPplBooking,tableNumberBooked);
			nb.next=firstBooking;
			firstBooking=nb;
		 }

			 public void viewBookings() {
					Booking temp2=firstBooking;
					System.out.println("Booking Details:"+" \n ");
					while(temp2!=null)
					{
						System.out.println("Booking Details: "+" \n " + "\t"+"Booking No.: "+temp2.getbookingNumber() +" \n " +"\t" + "Customer Name: "+temp2.getCustomerName()+" \n " +
						"\t" + "Number of People Booking: "+temp2.getNumberOfPplBooking()+" \n " +"\t" + "Table Number Booked: "+temp2.getTableNumberBooked());
			 			temp2=temp2.next;
					}
			}
			 public void deleteBookings(String name) {
					Booking temp3=firstBooking,temp4=null;
					
					while(temp3!=null && !temp3.customerName.equals(name)) { 
						temp4=temp3;
						temp3 = temp3.next;
					}
					
					if(temp3!=null) { 
					
						if(temp4!=null) temp4.next=temp3.next; 
						else firstBooking=firstBooking.next; 
						System.out.println("Item "+name+" deleted.");
					}
					else {
						System.out.println("Item "+name+" not found.");
					} 

					}
			

			public void addNewFoodAndDrinkItem() {	
				
				System.out.print("Please Enter Name Of The Food Item: "+ " \n ");
				String fdMenuItem = sc.nextLine();
				fdMenuItem = sc.nextLine();
				System.out.print("Please Enter Price: "+ " \n ");
				double itemPrice= sc.nextInt();
				addNewFoodAndDrinkItem(fdMenuItem,itemPrice);
			}
	
			
			
			public void addNewFoodAndDrinkItem(String fdMenuItem, double itemPrice) {	
				fdMenuNum++;
				FoodMenu nf=new FoodMenu(fdMenuNum,fdMenuItem,itemPrice);
					
				
				
				if(firstFdItem!=null) {
					fdm = firstFdItem; 
					while(fdm.next!=null) fdm=fdm.next;
					fdm.next=nf;
				}
				else firstFdItem=nf;
				
			}
     public void viewFoodItems()
     {		
	  fdm = firstFdItem; 
	  System.out.println("FOOD ITEM DETAILS: \n=====================================\n");
		while(fdm!=null)
			{
			System.out.println("Number: "+ fdm.getFoodMenuNumber() +""+" \n " +"\t" + "Food Item Name: "+fdm.getFdMenuItem()+" \n " +"\t" + "Food Item Cost.: "+fdm.getItemPrice());
			fdm=fdm.next;
					
			}	
		}
     public void deleteFoodItems(String item) {
    	 FoodMenu temp1=firstFdItem,temp2=null;
				
				while(temp1!=null && !temp1.getFdMenuItem().equals(item)) { 
					temp2=temp1;
					temp1 = temp1.next;
				}
				
				if(temp1!=null) { 
				
					if(temp2!=null) temp2.next=temp1.next; 
					else firstFdItem=firstFdItem.next; 
					System.out.println("Item "+item+" deleted.");
				}
				else {
					System.out.println("Item "+item+" not found.");
				} 

				}	
			
			
			
			public void addPurchase() {
				System.out.print("Enter Booking Id for Purchase: ");
				int bid = sc.nextInt();
				
				
				Booking thebooking=firstBooking;
				
				
				if(thebooking==null){
					System.out.println("No Bookings Found!");
					return; 
					}
				else{ 
					while(thebooking.getbookingNumber()!=bid) thebooking=thebooking.next;
				}
				
				System.out.print("Menu Item being purchased: ");
				String itemPurchased = sc.nextLine();
				itemPurchased = sc.nextLine();
				System.out.print("Quantities of Purchase: ");
				int quantity= sc.nextInt();
				
				purchase++;
				Purchase np=new Purchase(purchase,itemPurchased,quantity);
				
				
				np.next=thebooking.firstPurchase;
				thebooking.firstPurchase=np;
			 }
			
			
			
			public void viewAllPurchases() {
				
				
				Booking thebooking=firstBooking;
				while(thebooking!=null) {		
			
					Purchase pMenu=thebooking.firstPurchase; 
					
					System.out.println("Booking Details: "+"===================\n " +"\t" + "Booking No.: "+thebooking.bookingNumber +" \n " +"\t" + "Table: "+thebooking.getTableNumberBooked()+" \n " +"\t" + "Customer Name: "+thebooking.getCustomerName());
					
					while(pMenu!=null)
					{		
				    System.out.println("Purchase Details: "+" \n " +"\t" + "Purchase No.: "+pMenu.getPurchaseNumber() +" \n " +
				    "\t" + "FoodItem being Purchased: "+pMenu.getItemPurchased()+" \n " +"\t" + "Quantity: "+pMenu.getQuantity());
					pMenu=pMenu.next;
					}
					thebooking=thebooking.next;
				}
			}
				
			public void deletePurchases(String itemP, Booking booking) {
			Purchase temp5=booking.firstPurchase,temp6=null;
				
				while(temp5!=null && !temp5.itemPurchased.equals(itemP)) { 
					temp6=temp5;
					temp5 = temp5.next;
				}
				
				if(temp5!=null) { 
				
					if(temp6!=null) temp6.next=temp5.next; 
					else firstFdItem=firstFdItem.next; 
					System.out.println("Item "+itemP+" deleted.");
				}
				else {
					System.out.println("Item "+itemP+" not found.");
				} 
			}		
			
	     public void viewAllTablesAndBookings() {
				Table temp=headTable;
				Booking temp2=firstBooking; 
				FoodMenu temp3=firstFdItem;
				
				while(temp!=null && temp2!=null){
					System.out.print("Table Details: "+" \n " +"\t" + "Table No. "+temp.getTableNumber() +" \n " +"\t" + "No. of Seats "+temp.getNumberOfSeats()+ " \n ");
					System.out.println("Booking Details:"+" \n " +"\t" + "Booking No.: "+temp2.getbookingNumber() +" \n " +"\t" + "Customer Name: "+temp2.getCustomerName()+" \n " +
					"\t" + "Number of People Booking: "+temp2.getNumberOfPplBooking()+" \n " +"\t" + "Table Number Booked: "+temp2.getTableNumberBooked()+" \n " +"\t" + "Food Item Name: "+temp3.getFdMenuItem());
					temp=temp.next;
					temp2=temp2.next;
					temp3=temp3.next;
				}
			}
			
		 public void reset() {
		  headTable=null;
			System.out.println("Reset Successful");
		 }
    }
