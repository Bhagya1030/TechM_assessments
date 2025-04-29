package day2;

public class OnlinsShoppingSystem {
	 public static void main(String[] args) {
	        Prod phone = new Electronics(50000);
	        Prod shirt = new Clothing(2000);

	        System.out.println("Electronics Discount: ₹" + phone.calculateDiscount());
	        System.out.println("Clothing Discount: ₹" + shirt.calculateDiscount());
	    }
}