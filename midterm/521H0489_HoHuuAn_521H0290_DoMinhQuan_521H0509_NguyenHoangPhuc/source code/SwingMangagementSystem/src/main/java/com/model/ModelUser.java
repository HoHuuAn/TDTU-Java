/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author konod
 */
package  com.model;
import javax.swing.ImageIcon;
import com.EventInterface.EventActionUser;
import java.io.File;
import java.net.URL;

public class ModelUser {
    private int UserID; // Corresponds to ID in UserManagement table
    private String UserName; // Corresponds to UserName in UserManagement table
    private String Password; // Corresponds to Password in UserManagement table
    private String ProfilePicture; // Corresponds to ProfilePicture in UserManagement table
    private int Age; // Corresponds to Age in UserManagement table
    private String PhoneNumber; // Corresponds to PhoneNumber in UserManagement table
    private int Status; // Corresponds to Status in UserManagement table
    private int UserRole; // Corresponds to UserRole in UserManagement table
    private  String currentFolder = System.getProperty("user.dir") ; 
    
    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        this.UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getProfilePicture() {
        return ProfilePicture;
    }

    public void setProfilePicture(String profilePicture) {
  this.ProfilePicture =  currentFolder + profilePicture.replace("/", File.separator).replace("\\", File.separator);
       
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        this.Status = status;
    }

    public int getUserRole() {
        return UserRole;
    }

    public void setUserRole(int userRole) {
        this.UserRole = userRole;
    }

  

    public ModelUser(int userID, String userName, String password, String profilePicture, int age, String phoneNumber, int status, int userRole) {
        this.UserID = userID;
        this.UserName = userName;
        this.Password = password;
        this.ProfilePicture =currentFolder + profilePicture.replace("/", File.separator).replace("\\", File.separator);
        this.Age = age;
        this.PhoneNumber = phoneNumber;
        this.Status = status;
        this.UserRole = userRole;
   
    }

    public Object[] toRowTable(EventActionUser event) {
       
        ImageIcon icon = new ImageIcon( this.ProfilePicture);
        String statusString = (Status == 0) ? "Normal" : "Blocked";
        String roleString = (UserRole == 0) ? "Manager" : (UserRole == 1) ? "Employee" : (UserRole == 2) ? "Admin" : "Unknown";


        return new Object[]{new ModelProfile(icon), UserName, Age, PhoneNumber, statusString,roleString, new ModelActionUser(this, event)};

    }
    
    @Override
    public String toString() {
        return "ModelUser{" +
                "UserID=" + UserID +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", ProfilePicture='" + ProfilePicture + '\'' +
                ", Age=" + Age +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Status=" + Status +
                ", UserRole=" + UserRole +
                '}';
    }
}
