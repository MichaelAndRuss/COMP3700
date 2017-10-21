

public class Product {
   private int productID;
   private String name;
   private double price;
   private int quantity;
   private double tax;
   private String expiration;
   
   public Product(int productIDIn, String nameIn, double priceIn, int quantityIn, double taxIn, String expirationIn) {
      productID = productIDIn;
      name = nameIn;
      price = priceIn;
      quantity = quantityIn;
      tax = taxIn;
      expiration = expirationIn;
   }
   
   public Product (int productIDIn)
   {
      productID = productIDIn;
      name = "";
      price = 00.00;
      quantity = 0;
      tax = 00.00;
      expiration = "";
   }
   public Product() {
      productID = 0;
      name = "";
      price = 00.00;
      quantity = 0;
      tax = 00.00;
      expiration = ""; 
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
   public String getExpiration() {
      return expiration;
   }
   public void setExpiration(String expirationIn) {
      expiration = expirationIn;
   }
   
   
}