public class User {
   private int userID;
   private String username;
   private String password;
   private String displayName;
   private String isManager;
   
   public User() {
      userID = 0;
      username = "";
      password = "";
      displayName = "";
      isManager = "";
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
   
   public String isManager() {
      return isManager;
   }
   public void setManager(String manager) {
      isManager = manager;
   }
   
   



}