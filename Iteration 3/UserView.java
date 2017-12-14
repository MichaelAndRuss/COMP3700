import javax.swing.*;

public class UserView extends JFrame {
   private JTextField txtUserID  = new JTextField(10);
   private JTextField txtUsername  = new JTextField(30);
   private JTextField txtPassword  = new JTextField(10);
   private JTextField txtIsManager  = new JTextField(10);
   private JTextField txtDisplayName  = new JTextField(10);

   //private JButton btnLoad = new JButton("Add User");
   private JButton btnSave = new JButton("Save User");

   public UserView() {
      this.setTitle("User View");
      this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
      this.setSize(500, 200);
   
      JPanel panelButton = new JPanel();
      //panelButton.add(btnLoad);
      panelButton.add(btnSave);
      this.getContentPane().add(panelButton);
   
      JPanel panelUserID = new JPanel();
      panelUserID.add(new JLabel("User ID: "));
      panelUserID.add(txtUserID);
      txtUserID.setHorizontalAlignment(JTextField.RIGHT);
      this.getContentPane().add(panelUserID);
   
      JPanel panelUsername = new JPanel();
      panelUsername.add(new JLabel("Username: "));
      panelUsername.add(txtUsername);
      this.getContentPane().add(panelUsername);
   
      JPanel panelPassword = new JPanel();
      panelPassword.add(new JLabel("Password: "));
      panelPassword.add(txtPassword);
      txtPassword.setHorizontalAlignment(JTextField.RIGHT);
      this.getContentPane().add(panelPassword);
   
      JPanel panelDisplayName = new JPanel();
      panelDisplayName.add(new JLabel("DisplayName: "));
      panelDisplayName.add(txtDisplayName);
      txtDisplayName.setHorizontalAlignment(JTextField.RIGHT);
   
      this.getContentPane().add(panelDisplayName);
   
   
      JPanel panelIsManager = new JPanel();
      panelIsManager.add(new JLabel("IsManager: "));
      panelIsManager.add(txtIsManager);
      txtIsManager.setHorizontalAlignment(JTextField.RIGHT);
   
      this.getContentPane().add(panelIsManager);
   
   }

   /*public JButton getBtnLoad() {
      return btnLoad;
   }*/

   public JButton getBtnSave() {
      return btnSave;
   }

   public JTextField getTxtUserID() {
      return txtUserID;
   }

   public JTextField getTxtUsername() {
      return txtUsername;
   }

   public JTextField getTxtPassword() {
      return txtPassword;
   }

   public JTextField getTxtIsManager() {
      return txtIsManager;
   }
   public JTextField getTxtDisplayName() {
      return txtDisplayName;
   }
}