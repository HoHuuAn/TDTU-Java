/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.util.Comparator;

public class StudentComparator implements Comparator<ModelStudent> {

    private String sortCriteria;

    public StudentComparator(String sortCriteria) {
        this.sortCriteria = sortCriteria;
    }

    @Override
    public int compare(ModelStudent student1, ModelStudent student2) {
        switch (sortCriteria) {
            case "None":
                // If no sorting criteria is selected, maintain the current order
                return 0;
            case "START YEAR":
                // Compare based on start year (assuming getStartYear() returns an integer)
                return Integer.compare(student1.getBeginningYear(), student2.getBeginningYear());
            case "END YEAR":
                // Compare based on end year (assuming getEndYear() returns an integer)
                return Integer.compare(student1.getEndYear(), student2.getEndYear());
            case "STUDENT ID":
                // Compare based on student ID (assuming getStudentID() returns a String)
                return student1.getID().compareTo(student2.getID());
            default:
                // Default to no sorting
                return 0;
        }
    }
}