public class Customer {
   private int customerID;
   private String name;
   private String address;
   private int numberOfVisits;
   
   
   public Customer(int customerIDIn, String nameIn, String addressIn, int numberOfVisitsIn) {
      customerID = customerIDIn;
      name = nameIn;
      address = addressIn;
      numberOfVisits = numberOfVisitsIn;
   }
   public int getId() {
      return customerID;
   }
   public void setID(int customerIDIn) {
      customerID = customerIDIn;
   }
   public String getName() {
      return name;
   }
   public void setName(String nameIn) {
      name = nameIn;
   
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String addressIn) {
      address = addressIn;
   }
   public int getNumberOfVisits() {
      return numberOfVisits;
   }
   public void setNumberOfVisits(int numberOfVisitsIn) {
      numberOfVisits = numberOfVisitsIn;
      
   }


}