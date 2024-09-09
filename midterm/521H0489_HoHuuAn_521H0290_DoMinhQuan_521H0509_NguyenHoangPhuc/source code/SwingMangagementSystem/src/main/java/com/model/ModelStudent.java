package com.model;

import com.EventInterface.EventActionStudent;

public class ModelStudent {

    private String ID;
    private String name;
    private int beginningYear;
    private int endYear;
    private String major;
    private String educationQuality;
    private String phone;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public int getBeginningYear() {
        return beginningYear;
    }

    public void setBeginningYear(int beginningYear) {
        this.beginningYear = beginningYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducationQuality() {
        return educationQuality;
    }

    public void setEducationQuality(String educationQuality) {
        this.educationQuality = educationQuality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ModelStudent(String ID, String name,
            int beginningYear, int endYear, String major, String educationQuality, String phone) {
        this.ID = ID;
        this.name = name;
      
        this.beginningYear = beginningYear;
        this.endYear = endYear;
        this.major = major;
        this.educationQuality = educationQuality;
        this.phone = phone;
    }

  public Object[] toRowTable(EventActionStudent event) {
        return new Object[]{ID, name, beginningYear, endYear, major, educationQuality, phone, new ModelActionStudent(this, event)};
    }
}
