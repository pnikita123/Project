package restuarant;

public class Purchase {
	public int purchaseNumber;
	public String itemPurchased;
	public int quantity;
	public Purchase next = null;
	public FoodMenu firstFdItem = null;


public Purchase(int purchaseNumber,String itemPurchased, int quantity) {
		this.purchaseNumber = purchaseNumber;
		this.itemPurchased = itemPurchased;
		this.quantity = quantity;
	}

	public int getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(int purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public String getItemPurchased() {
		return itemPurchased;
	}


	public void setItemPurchased(String itemPurchased) {
		this.itemPurchased = itemPurchased;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
