import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

public class Order {
   private int orderID;
   private double subtotal;
   private double total;
   int[] itemsOrdered;
   private String customer;
   private static final double TAX = 1.09;
   private Date date;
   
   private List<OrderLine> lines;
   
   public Order(int orderIDIn, double subtotalIn, double totalIn, int[] itemsOrderedIn, String customerIn, Date dateIn) {
      orderID = orderIDIn;
      subtotal = subtotalIn;
      total = totalIn;
      itemsOrdered = itemsOrderedIn;
      customer = customerIn;
      date = dateIn;
      lines = new ArrayList<>();
   }
   
   public Order(int orderIDIn) {
      orderID = orderIDIn;
      subtotal = 0.0;
      total = 0.0;
      customer = "";
      itemsOrdered = null;
      date = date;
      lines = new ArrayList<>();
   }
   public Order() {
      orderID = 0;
      subtotal = 0.0;
      total = 0.0;
      customer = "";
      itemsOrdered = null;
      date = date;
      lines = new ArrayList<>();
   }
   public int getID() {
      return orderID;
   }
   public void setID(int orderIDIn) {
      orderID = orderIDIn;
   }
   
   public String getCustomer() {
      return customer;
   }
   public void setCustomer(String customerIn) {
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
   
   public Date getDate() {
      return date;
   }
   public void setDate(Date date) {
      this.date = date;
   }
   
   public void addLine(OrderLine line) {
      lines.add(line);
   }
   public void removeLine(OrderLine line) {
      lines.remove(line);
   }
   public List<OrderLine>getLines() {
      return lines;
   }
   
   

}