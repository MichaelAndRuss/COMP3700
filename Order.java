import java.util.Date;
import java.util.Calendar;

public class Order {
   private int orderID;
   private double subtotal;
   private double total;
   Product[] itemsOrdered;
   private Customer customer;
   
   
   public Order(int orderIDIn, double subtotalIn, double totalIn, Product[] itemsOrderedIn, Customer customerIn) {
      orderID = orderIDIn;
      subtotal = subtotalIn;
      total = totalIn;
      itemsOrdered = itemsOrderedIn;
      customer = customerIn;
   }
   
   public Order(int orderIDIn) {
      orderID = orderIDIn;
      subtotal = 0.0;
      total = 0.0;
      //itemsOrdered =
      //customer = "";
   }
   public int getID() {
      return orderID;
   }
   public void setID(int orderIDIn) {
      orderID = orderIDIn;
   }
   
   public Customer getCustomer() {
      return customer;
   }
   public void setCustomer(Customer customerIn) {
      customer = customerIn;
   }
   
   public double getSubtotal() {
      return subtotal;
   }
   public void setSubtotal(double subtotalIn) {
      subtotal = subtotalIn;
   
   }
  
   public double getTotal() {
      return total;
   }
   public void setTotal(double totalIn) {
      total = totalIn;
   }
   
   
   //Printing CURRENT date
   public static void main(String args[]) {
      Date time = new Date();
      System.out.print(time.toString());
   }

}