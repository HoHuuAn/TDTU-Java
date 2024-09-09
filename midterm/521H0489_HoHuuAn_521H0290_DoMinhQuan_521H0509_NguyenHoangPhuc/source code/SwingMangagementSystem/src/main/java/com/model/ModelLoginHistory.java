package com.model;

import java.util.Date;
import javax.swing.ImageIcon;

public class ModelLoginHistory {

    private int LoginHistoryID;
    private int UserID;
    private Date TimeLogin;

    // Constructors, getters, and setters...

    public int getLoginHistoryID() {
        return LoginHistoryID;
    }

    public void setLoginHistoryID(int loginHistoryID) {
        this.LoginHistoryID = loginHistoryID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        this.UserID = userID;
    }

    public Date getTimeLogin() {
        return TimeLogin;
    }

    public void setTimeLogin(Date timeLogin) {
        this.TimeLogin = timeLogin;
    }

    // Method to create a row for a JTable
    public Object[] toRowTable() {
    
        

        String timeLoginString = (TimeLogin != null) ? TimeLogin.toString() : "Unknown";

        return new Object[]{  timeLoginString};
    }
}
