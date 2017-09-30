public class Employee {
   private int employeeID;
   private String name;
   private String position;
   
   public Employee(int employeeIDIn, String nameIn, String positionIn) {
      employeeID = employeeIDIn;
      name = nameIn;
      position = positionIn;
   }
   public int getID() {
      return employeeID;
   }
   public void setID(int employeeIDIn) {
      employeeID = employeeIDIn;
   
   }
   public String getName() {
      return name;
   }
   public void setName(String nameIn) {
      name = nameIn;
   
   }
   public String getPosition() {
      return position;
   }
   public void setPosition(String positionIn) {
      position = positionIn;
   
   }
   public void checkOut(Customer customer, Order order) {
   
   }
   public void updateProduct(int productID) {
   
   }
   public void addProduct(int productID) {
   
   }

}