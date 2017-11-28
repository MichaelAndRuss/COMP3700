import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
//Michael Lee
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame {

   private JButton btnCheckout = new JButton("Checkout");
   private JButton btnManage   = new JButton("Manage Product");
   //new buttons
   private JButton btnEditProfile = new JButton("Edit Profile");
   private JButton btnCreateNewUser = new JButton("Create New User");

   public HomeScreen() {
      this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(400, 300);
   
      btnManage.setPreferredSize(new Dimension(120, 50));
      btnCheckout.setPreferredSize(new Dimension(120, 50));
      btnEditProfile.setPreferredSize(new Dimension(120, 50));
      btnCreateNewUser.setPreferredSize(new Dimension(120, 50));
   
   
      JLabel title = new JLabel("Store Management System");
      title.setFont(new Font("Sans Serif", Font.BOLD, 24));
      JPanel panelTitle = new JPanel();
      panelTitle.add(title);
      this.getContentPane().add(panelTitle);
   
      JPanel panelButton = new JPanel();
      panelButton.add(btnCheckout);
      panelButton.add(btnManage);
      
      
     //new buttons
      panelButton.add(btnEditProfile);
      panelButton.add(btnCreateNewUser);
   
      this.getContentPane().add(panelButton);
   
      btnCheckout.addActionListener(
         new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
               Application.getInstance().getCheckoutScreen().setVisible(true);            }
         });
   
   
      btnManage.addActionListener(
         new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
               Application.getInstance().getProductView().setVisible(true);
            }
         });
         
         /*
         btnEditProfile.addActionListener(
         new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
               Application.getInstance().getUserView().setVisible(true);
            }
         });
         */
      btnCreateNewUser.addActionListener(
         new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
               Application.getInstance().getUserView().setVisible(true);
            }
         });
         
      btnEditProfile.addActionListener(
         new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
               
               Application.getInstance().getUserView().setVisible(true);
            }
         });
         
         
         
   }


}