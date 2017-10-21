//Michael Lee
import java.sql.*;

public class DataAdapter {
   private Connection connection;

   public DataAdapter(Connection connection) {
      this.connection = connection;
   }

   public Product loadProduct(int id) {
      try {
         String query = "SELECT * FROM Product WHERE ProductID = " + id;
      
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query);
         if (resultSet.next()) {
            Product product = new Product();
            product.setID(resultSet.getInt(1));
            product.setName(resultSet.getString(2));
            product.setQuantity(resultSet.getInt(3));
            product.setPrice(resultSet.getDouble(4));

            resultSet.close();
            statement.close();
         
            return product;
         }
      
      } 
      catch (SQLException e) {
         System.out.println("Database access error!");
         e.printStackTrace();
      }
      return null;
   }

   public boolean saveProduct(Product product) {
      try {
         PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE ProductID = ?");
         statement.setInt(1, product.getID());
      
         ResultSet resultSet = statement.executeQuery();
      
         if (resultSet.next()) { // this product exists, update its fields
            statement = connection.prepareStatement("UPDATE Product SET ProductName = ?, Price = ?, Quantity = ? WHERE ProductID = ?");
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setInt(4, product.getID());
         }
         else { // this product does not exist, use insert into
            statement = connection.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?)");
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.setInt(1, product.getID());
         }
         statement.execute();
         resultSet.close();
         statement.close();
         return true;        // save successfully
      
      } 
      catch (SQLException e) {
         System.out.println("Database access error!");
         e.printStackTrace();
         return false; // cannot save!
      }
   }

   public Order loadOrder(int id) {
      try {
         Order order = null;
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM OrderTable WHERE OrderID = " + id);
      
         if (resultSet.next()) {
            order = new Order();
            order.setID(resultSet.getInt("OrderID"));
            order.setCustomer(resultSet.getString("Customer"));
            order.setTotal(resultSet.getDouble("TotalCost"));
            order.setDate(resultSet.getDate("OrderDate"));
            resultSet.close();
            statement.close();
         }
      
         // loading the order lines for this order
         resultSet = statement.executeQuery("SELECT * FROM OrderLine WHERE OrderID = " + id);
      
         while (resultSet.next()) {
            OrderLine line = new OrderLine();
            line.setOrderID(resultSet.getInt(1));
            line.setProductID(resultSet.getInt(2));
            line.setQuantity(resultSet.getInt(3));
            line.setCost(resultSet.getDouble(4));
            order.addLine(line);
         }
      
         return order;
      
      } 
      catch (SQLException e) {
         System.out.println("Database access error!");
         e.printStackTrace();
         return null;
      }
   }

   public boolean saveOrder(Order order) {
      try {
         PreparedStatement statement = connection.prepareStatement("INSERT INTO OrderTable VALUES (?, ?, ?, ?)");
         statement.setInt(1, order.getID());
         statement.setString(2, order.getCustomer());
       //  statement.setDouble(4, order.getSubtotal());
         statement.setDouble(3, order.getTotal());
         statement.setDate(4, order.getDate());

      
         statement.execute();    // commit to the database;
         statement.close();
      
         statement = connection.prepareStatement("INSERT INTO OrderLine VALUES (?, ?, ?, ?)");
         for (OrderLine line: order.getLines()) { // store for each order line!
            statement.setInt(1, line.getOrderID());
            statement.setInt(2, line.getProductID());
            statement.setDouble(3, line.getQuantity());
            statement.setDouble(4, line.getCost());
         
            statement.execute();    // commit to the database;
         }
         statement.close();
         return true; // save successfully!
      }
      catch (SQLException e) {
         System.out.println("Database access error!");
         e.printStackTrace();
         return false;
      }
   }
}
