package usermanagement.model;

import java.util.Date;

public class User {
    public String userID;
    public String userName;
    public String email;
    public String mobilePhone;
    public int isActive;
    public Date dateCreated;

    public User() {
        // Default constructor
    }

    public User(String userID, String userName, String email, String mobilePhone) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.mobilePhone = mobilePhone;
    }

    public User(String userID, String userName, String email, String mobilePhone, int isActive, Date dateCreated) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
    }

    public User(String id, String name, String email, String country, int active) {
        this.userID = id;
        this.userName = name;
        this.email = email;
        this.mobilePhone = country;
        this.isActive = active;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", isActive=" + isActive +
                ", dateCreated=" + dateCreated +
                '}';
    }
}