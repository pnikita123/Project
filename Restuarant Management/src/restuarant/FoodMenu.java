package restuarant;

public class FoodMenu
{
	int foodMenuNumber;
	String fdMenuItem;
	public double itemPrice;
	public FoodMenu next= null;	
	
public FoodMenu(int foodMenuNumber,String fdMenuItem, double itemPrice) {
		
		this.foodMenuNumber = foodMenuNumber;
		this.fdMenuItem = fdMenuItem;
		this.itemPrice = itemPrice ;
}

public int getFoodMenuNumber() {
	return foodMenuNumber;
}

public void setFoodMenuNumber(int foodMenuNumber) {
	this.foodMenuNumber = foodMenuNumber;
}


public String getFdMenuItem() {
	return fdMenuItem;
}

public void setFdMenuItem(String fdMenuItem) {
	this.fdMenuItem = fdMenuItem;
}

public double getItemPrice() {
	return itemPrice;
}



public void setItemPrice(double itemPrice) {
	this.itemPrice = itemPrice;
}
	

}
