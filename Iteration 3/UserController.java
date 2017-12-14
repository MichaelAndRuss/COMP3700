//Michael Lee
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController implements ActionListener {
   private UserView userView;
   private DataAdapter dataAdapter; // to save and load product information

   public UserController(UserView userView, DataAdapter dataAdapter) {
      this.dataAdapter = dataAdapter;
      this.userView = userView;
   
      //productView.getBtnLoad().addActionListener(this);
      userView.getBtnSave().addActionListener(this);
   }


   public void actionPerformed(ActionEvent e) {
      String username;
      try {
         username = userView.getTxtUsername().getText();
      }
      catch (NumberFormatException b) {
         JOptionPane.showMessageDialog(null, "Invalid username! Please provide a valid username!");
         return;
      }
      User user = dataAdapter.loadUser(username);
      if (user == null) {
         saveUser();
      }
      else {
         loadUser(user);
      }
   }

   private void saveUser() {
      int userID;
      try {
         userID = Integer.parseInt(userView.getTxtUserID().getText());
      }
      catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(null, "Invalid user ID! Please provide a valid userID!");
         return;
      }
   
      String username;
      try {
         username = userView.getTxtUsername().getText();
      }
      catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(null, "Invalid username! Please provide a valid username!");
         return;
      }
   
      String password;
      try {
         password = userView.getTxtPassword().getText();
      }
      catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(null, "Invalid password! Please provide a valid password!");
         return;
      }
      
      String displayName = userView.getTxtDisplayName().getText();
      
      String manager = userView.getTxtIsManager().getText().trim();
   
      //check for true or false here
      
      /*if (isManager.length() == 0) {
         JOptionPane.showMessageDialog(null, "Invalid product name! Please provide a non-empty product name!");
         return;
      }*/
   
      // Done all validations! Make an object for this product!
   
      User user = new User();
      user.setUserID(userID);
      user.setUsername(username);
      user.setPassword(password);
      user.setDisplayName(displayName);
      user.setManager(manager);
   
      // Store the product to the database
   
   //change to .saveUser
      dataAdapter.saveUser(user);
   }

   /*private void loadProduct() {
      int productID = 0;
      try {
         productID = Integer.parseInt(productView.getTxtProductID().getText());
      }
      catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(null, "Invalid product ID! Please provide a valid product ID!");
         return;
      }
   
      Product product = dataAdapter.loadProduct(productID);
   
      if (product == null) {
         JOptionPane.showMessageDialog(null, "This product ID does not exist in the database!");
         return;
      }
   
      productView.getTxtProductName().setText(product.getName());
      productView.getTxtProductPrice().setText(String.valueOf(product.getPrice()));
      productView.getTxtProductQuantity().setText(String.valueOf(product.getQuantity()));
   }*/

   private void loadUser(User user) {
   
      String username;
      try {
         username = userView.getTxtUsername().getText();
      }
      catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(null, "Invalid username! Please provide a valid username!");
         return;
      }
   
      String password;
      try {
         password = userView.getTxtPassword().getText();
      }
      catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(null, "Invalid password! Please provide a valid password!");
         return;
      }
      
      String displayName = userView.getTxtDisplayName().getText();
      
      String manager = userView.getTxtIsManager().getText().trim();
   
      //check for true or false here
      
      /*if (isManager.length() == 0) {
         JOptionPane.showMessageDialog(null, "Invalid product name! Please provide a non-empty product name!");
         return;
      }*/
   
      // Done all validations! Make an object for this product!
   
      user.setUsername(username);
      user.setPassword(password);
      user.setDisplayName(displayName);
      user.setManager(manager);
   
      // Store the product to the database
   
   //change to .saveUser
      dataAdapter.saveUser(user);
   }
}