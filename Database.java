import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




public class Database {
   public static void createNewDatabase(String fileName) {
      String url = "jdbc:sqlite:/Users/Michael/Desktop/COMP3700/" + fileName;
      
      try(Connection conn = DriverManager.getConnection(url)) {
         if (conn != null) {
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("The driver name is " + meta.getDriverName());
            System.out.println("A new database has been created.");
         }
      } 
      catch (SQLException e) {
         System.out.println(e.getMessage());
      }   
   }
   
 
             
                    
                     
   

//Create Tables
   public static void createNewTable() {
      //sqlite connection
      String url = "jdbc:sqlite:/Users/Michael/Desktop/COMP3700/database.db";
      
      //create table sql statement
      
      String productTable = "CREATE TABLE Product (\n" 
                     + " productID integer not null PRIMARY KEY, \n" 
                     + " productName text NOT NULL, \n"
                     + " Quantity integer, \n"
                     + " Price number(9,2), \n" 
                     + " Expiration datetime);";
                     
      String orderTable = "CREATE TABLE OrderTable (\n"  
                     + " orderNo int not null PRIMARY KEY, \n"  
                     + " orderTime datetime, \n" 
                     + " customer text NOT NULL, \n" 
                     + " subtotal number(9,2), \n" 
                     + " tax number(9,2), \n"   
                     + " total number(9,2));";
      
                     
      try(Connection conn = DriverManager.getConnection(url); 
         Statement stmt = conn.createStatement()) {
            //create table
         stmt.execute(productTable);
         stmt.execute(orderTable);
        
      } 
      catch (SQLException e) {
         System.out.println(e.getMessage());
      }
    
   }  


   public static void insertData() {
      String url = "jdbc:sqlite:/Users/Michael/Desktop/COMP3700/database.db";
   
      String insertProductData1 = "INSERT INTO Product VALUES (\n" 
                                + "100, 'Apple', 38, 1.50, date('2017-09-28'));";
      String insertProductData2 = "INSERT INTO Product VALUES (\n" 
                                + "101, 'Orange', 42, 1.65, date('2017-09-28'));";
      String insertProductData3 = "INSERT INTO Product VALUES (\n" 
                                + "103, 'Tomato', 24, 1.99, date('2017-09-28'));";
      String insertProductData4 = "INSERT INTO Product VALUES (\n" 
                                + "200, 'Soap', 20, 0.85, date('2099-05-15'));";                                                         
      String insertProductData5 = "INSERT INTO Product VALUES (\n" 
                                + "201, 'Shampoo', 17, 0.99, date('2024-07-22'));";
      String insertOrderData1 = "INSERT INTO OrderTable VALUES (\n" 
                                + "1001, datetime('2017-09-28 10:00:00'), 'Russ', 1.50, 0.09, 1.64);";
      String insertOrderData2 = "INSERT INTO OrderTable VALUES (\n" 
                                + "1002, datetime('2017-09-28 10:00:00'), 'Mike', 1.65, 0.09, 1.80);";
      String insertOrderData3 = "INSERT INTO OrderTable VALUES (\n" 
                                + "1003, datetime('2017-09-28 10:00:00'), 'Phong', 0.50, 0.09, 0.55);";  
                                
      String insertOrderData4 = "INSERT INTO OrderTable VALUES (\n" 
                                + "1004, datetime('2017-09-28 10:00:00'), 'Toon', 200.35, 0.09, 218.38);";
                                
      String insertOrderData5 = "INSERT INTO OrderTable VALUES (\n" 
                                + "1005, datetime('2017-09-28 10:00:00'), 'Jane', 0.99, 0.09, 1.08);";                                                                                   
                                
                                
                                                            
                                
   //String insertOrderData = "INSERT INTO Order VALUES (\n" 
      try(Connection conn = DriverManager.getConnection(url); 
         Statement stmt = conn.createStatement()) {
            //create table
         stmt.execute(insertProductData1);
         stmt.execute(insertProductData2);
         stmt.execute(insertProductData3);
         stmt.execute(insertProductData4);
         stmt.execute(insertProductData5);
         stmt.execute(insertOrderData1);
         stmt.execute(insertOrderData2);
         stmt.execute(insertOrderData3);
         stmt.execute(insertOrderData4);
         stmt.execute(insertOrderData5);
         
         
        
      } 
      catch (SQLException e) {
         System.out.println(e.getMessage());
      }                    
   }

   public static void main(String[] args) {
      createNewDatabase("database.db");
      createNewTable();
      insertData();
   }
   
   
}