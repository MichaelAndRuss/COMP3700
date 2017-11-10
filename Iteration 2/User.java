public class User {
   private int userID;
   private String username;
   private String password;
   private String displayName;
   private boolean isManager;
   
   public User() {
      userID = 0;
      username = "";
      password = "";
      displayName = "";
      isManager = false;
   }
   
   public int getUserID() {
      return userID;
   }
   public void setUserID(int userIDIn) {
      userID = userIDIn;
   }
   public String getUsername() {
      return username;
   }
   public void setUsername(String usernameIn) {
      username = usernameIn;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String passwordIn) {
      password = passwordIn;
   }
   public String getDisplayName() {
      return displayName;
   }
   public void setDisplayName(String displayNameIn) {
      displayName = displayNameIn;
   }
   
   public boolean isManager() {
      isManager = false;
      return isManager;
   }
   public void setManager(boolean manager) {
      isManager = manager;
   }
   
   



}