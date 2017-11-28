//Michael Lee
import java.sql.*;

public class Application {

   private static Application instance;   // Singleton pattern

   public static Application getInstance() {
      if (instance == null) {
         instance = new Application();
      }
      return instance;
   }
   // Main components of this application

   private Connection connection;

   public Connection getConnection() {
      return connection;
   }

   private DataAdapter dataAdapter;
   
  
   private User currentUser = null;

   public void setCurrentUser(User user) {
      this.currentUser = user;
   }
   // Create the Product View and Controller here!

   private ProductView productView = new ProductView();

   private CheckoutScreen checkoutScreen = new CheckoutScreen();

   private HomeScreen homeScreen = new HomeScreen();

   public HomeScreen getHomeScreen() {
      return homeScreen;
   }

   public ProductView getProductView() {
      return productView;
   }

   public CheckoutScreen getCheckoutScreen() {
      return checkoutScreen;
   }

   public LoginScreen loginScreen = new LoginScreen();

   public LoginScreen getLoginScreen() {
      return loginScreen;
   }

   public LoginController loginController;
   private ProductController productController;

   public ProductController getProductController() {
      return productController;
   }

   private CheckoutController checkoutController;

   public CheckoutController getCheckoutController() {
      return checkoutController;
   }
   //getUserView
   private UserView userView = new UserView();
   public UserView getUserView() {
      return userView;
   }
   private UserController userController;
   public UserController getUserController() {
      return userController;
   }
   public DataAdapter getDataAdapter() {
      return dataAdapter;
   }

   private void initializeDatabase(Statement stmt) throws SQLException {
      // create the tables and insert sample data here!
   
    //  stmt.execute("create table Product (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity int)");
      //    stmt.execute("create table Order (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity double)");
      String productTable = "CREATE TABLE Product (\n" 
                     + " ProductID integer not null PRIMARY KEY, \n" 
                     + " ProductName text NOT NULL, \n"
                     + " Quantity integer, \n"
                     + " Price number(9,2));";
                     
      String orderTable = "CREATE TABLE OrderTable (\n"  
                     + " OrderID int not null PRIMARY KEY, \n"  
                     + " Customer text NOT NULL, \n" 
                     + " Total number(9,2), \n"
                     + " OrderDate datetime);";
                     
      String orderLine = "CREATE TABLE OrderLine (\n"  
                     + " OrderID int not null, \n"  
                     + " ProductID integer not null, \n" 
                     + " Quantity int NOT NULL, \n" 
                     + " Cost number(9,2), \n"
                     + " PRIMARY KEY (OrderID, ProductID));";
      String userTable = "CREATE TABLE User (\n"
                     + "UserID int not null, \n"
                     + "Username text NOT NULL, \n"
                     + "Password text NOT NULL, \n"
                     + "DisplayName text NOT NULL, \n"
                     + "isManager text NOT NULL, \n"
                     + " PRIMARY KEY (UserID));";
      String userDefault = "INSERT INTO User (UserID, Username, Password, DisplayName, isManager) \n"
                     + "VALUES ('1234', 'mml0017', 'wareagle', 'Mike', 'True')";
      
      stmt.execute(userDefault);
      stmt.execute(userTable);               
      stmt.execute(productTable);
      stmt.execute(orderTable);
      stmt.execute(orderLine);
   
   }
   
   private Application() {
      // create SQLite database connection here!
      try {
         Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection("jdbc:sqlite:/Users/Michael/Desktop/COMP3700/toMikeLee/StoreDB.db");
         Statement stmt = connection.createStatement();
         //if (!stmt.executeQuery("select * from Product").next()) {
         //initializeDatabase(stmt);
         //}   
      }
      catch (ClassNotFoundException ex) {
         System.out.println("SQLite is not installed. System exits with error.");
         System.exit(1);
      }
      catch (SQLException ex) {
         System.out.println("SQLite database not ready. System exits with error." + ex.getMessage());
         System.exit(2);
      }
      // Create data adapter here!
      dataAdapter = new DataAdapter(connection);
   
      productController = new ProductController(productView, dataAdapter);
   
      checkoutController = new CheckoutController(checkoutScreen, dataAdapter);
   
      loginController = new LoginController(loginScreen, dataAdapter);
      
      userController = new UserController(userView, dataAdapter);
   }

   public static void main(String[] args) {
      Application.getInstance().getLoginScreen().setVisible(true);
   }
}
