

public class Product {
   private int productID;
   private String name;
   private double price;
   private int quantity;
   private double tax;
   
   public Product(int productIDIn, String nameIn, double priceIn, int quantityIn, double taxIn) {
      productID = productIDIn;
      name = nameIn;
      price = priceIn;
      quantity = quantityIn;
      tax = taxIn;
   }
   
   public Product (int productIDIn)
   {
      productID = productIDIn;
      name = "";
      price = 00.00;
      quantity = 0;
      tax = 00.00;
   }
   
   public int getID() {
      return productID;
   }
   public void setID(int productIDIn) {
      productID = productIDIn;
   }
   public String getName() {
      return name;
   }
   public void setName(String nameIn) {
      name = nameIn;
   }
   public double getPrice() {
      return price;
   }
   public void setPrice(double priceIn) {
      price = priceIn;
   }
   public int getQuantity() {
      return quantity;
   }
   public void setQuantity(int quantityIn) {
      quantity = quantityIn;
   }
   
   
}