package com.hohuuan;

import java.util.Scanner;

public class Program
{
    public static void main( String[] args )
    {
        PhoneDAO phoneDAO = new PhoneDAO();
        ManufactureDAO manufactureDAO = new ManufactureDAO();

        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("*********************************************************************");
            System.out.println("|                           PHONE                                   |");
            System.out.println("|   1. Add a new phone                                              |");
            System.out.println("|   2. Read detail of phone by id                                   |");
            System.out.println("|   3. Real all phone                                               |");
            System.out.println("|   4. Delete a phone by id                                         |");
            System.out.println("|   5. Delete a phone by data input                                 |");
            System.out.println("|   6. Update a phone by data input                                 |");
            System.out.println("|   7. The phone with the highest selling price.                    |");
            System.out.println("|   8. List of phones sorted by country name                        |");
            System.out.println("|   9. Check if there is a phone priced above 50 million VND.       |");
            System.out.println("|   10. First phone has the color 'Pink' and costs over 15 million  |");
            System.out.println("*********************************************************************");
            System.out.println("|                       MANUFACTURE                                 |");
            System.out.println("|   11. Add a new manufacture                                       |");
            System.out.println("|   12. Read detail of manufacture by id                            |");
            System.out.println("|   13. Real all manufacture                                        |");
            System.out.println("|   14. Delete a manufacture by id                                  |");
            System.out.println("|   15. Delete a manufacture by data input                          |");
            System.out.println("|   16. Update a manufacture by data input                          |");
            System.out.println("|   17. Check whether all manufacturers have more than 100 employees|");
            System.out.println("|   18. The sum of all employees of the manufactures                |");
            System.out.println("|   19. Last manufacturer in the list based in the US               |");
            System.out.println("*********************************************************************");
            System.out.println("|   20. Exit                                                        |");
            System.out.println("*********************************************************************");

            System.out.print("\nChoose from 1 to 20 respectively: ");
            int choose = sc.nextInt();

            switch (choose){
                //Add a new phone
                case 1:
                    sc.nextLine();
                    String idPhoneAdd = "";
                    String namePhoneAdd = "";
                    String colorPhoneAdd = "";
                    String countryPhoneAdd = "";
                    int price = 0;
                    int quantity = 0;

                    System.out.print("Enter ID: ");
                    while (idPhoneAdd.isEmpty()) {
                        idPhoneAdd = sc.nextLine();
                        if (idPhoneAdd.isEmpty()) {
                            System.out.print("ID cannot be empty. Please enter again: ");
                        }
                    }

                    System.out.print("Enter name: ");
                    while (namePhoneAdd.isEmpty()) {
                        namePhoneAdd = sc.nextLine();
                        if (namePhoneAdd.isEmpty()) {
                            System.out.print("Name cannot be empty. Please enter again: ");
                        }
                    }

                    System.out.print("Enter color: ");
                    while (colorPhoneAdd.isEmpty()) {
                        colorPhoneAdd = sc.nextLine();
                        if (colorPhoneAdd.isEmpty()) {
                            System.out.print("Color cannot be empty. Please enter again: ");
                        }
                    }

                    System.out.print("Enter country: ");
                    while (countryPhoneAdd.isEmpty()) {
                        countryPhoneAdd = sc.nextLine();
                        if (countryPhoneAdd.isEmpty()) {
                            System.out.print("Country cannot be empty. Please enter again: ");
                        }
                    }

                    System.out.print("Enter price: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Invalid input. Price must be an integer. Please enter again: ");
                        sc.next();
                    }
                    price = sc.nextInt();

                    System.out.print("Enter quantity: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Invalid input. Quantity must be an integer. Please enter again: ");
                        sc.next();
                    }
                    quantity = sc.nextInt();

                    if(phoneDAO.add(new Phone(idPhoneAdd,namePhoneAdd,price,colorPhoneAdd,countryPhoneAdd,quantity))){
                        System.out.println("Add product successfully");
                    }
                    else{
                        System.out.println("Add product fail");
                    }
                    break;

                //Read detail of phone by id
                case 2:
                    System.out.print("Enter ID: ");
                    String id = sc.next();
                    Phone p = phoneDAO.get(id);
                    if ( p != null){
                        System.out.println(p);
                    }
                    else{
                        System.out.println("Not Found");
                    }
                    break;

                //Real all phone
                case 3:
                    phoneDAO.getAll().forEach(System.out::println);
                    break;

                //Delete a phone by id
                case 4:
                    System.out.print("Enter phone id: ");
                    sc.nextLine();
                    String idPhoneDelete  = sc.nextLine();
                    if (phoneDAO.remove(idPhoneDelete)) {
                        System.out.println("Phone deleted successfully");
                    } else {
                        System.out.println("No phone deleted");
                    }
                    break;

                //Delete a phone by data input
                case 5:
                    String IDPhoneDelete = null;
                    String namePhoneDelete = null;
                    String colorPhoneDelete = null;
                    String countryPhoneDelete = null;
                    int priceDelete = 0;
                    int quantityDelete = 0;
                    String manufactureIdDelete = null;

                    sc.nextLine();
                    System.out.print("Enter ID: ");
                    while (IDPhoneDelete == null || IDPhoneDelete.isEmpty()) {
                        IDPhoneDelete = sc.nextLine();
                        if (IDPhoneDelete.isEmpty()) {
                            System.out.print("ID cannot be empty. Please enter again: ");
                        }
                    }

                    System.out.print("Enter name: ");
                    while (namePhoneDelete == null || namePhoneDelete.isEmpty()) {
                        namePhoneDelete = sc.nextLine();
                        if (namePhoneDelete.isEmpty()) {
                            System.out.print("Name cannot be empty. Please enter again: ");
                        }
                    }

                    System.out.print("Enter color: ");
                    while (colorPhoneDelete == null || colorPhoneDelete.isEmpty()) {
                        colorPhoneDelete = sc.nextLine();
                        if (colorPhoneDelete.isEmpty()) {
                            System.out.print("Color cannot be empty. Please enter again: ");
                        }
                    }

                    System.out.print("Enter country: ");
                    while (countryPhoneDelete == null || countryPhoneDelete.isEmpty()) {
                        countryPhoneDelete = sc.nextLine();
                        if (countryPhoneDelete.isEmpty()) {
                            System.out.print("Country cannot be empty. Please enter again: ");
                        }
                    }

                    System.out.print("Enter price: ");
                    while (priceDelete <= 0) {
                        try {
                            priceDelete = Integer.parseInt(sc.nextLine());
                            if (priceDelete <= 0) {
                                System.out.print("Price must be a positive integer. Please enter again: ");
                            }
                        } catch (NumberFormatException e) {
                            System.out.print("Invalid format. Price must be a positive integer. Please enter again: ");
                        }
                    }

                    System.out.print("Enter quantity: ");
                    while (quantityDelete <= 0) {
                        try {
                            quantityDelete = Integer.parseInt(sc.nextLine());
                            if (quantityDelete <= 0) {
                                System.out.print("Quantity must be a positive integer. Please enter again: ");
                            }
                        } catch (NumberFormatException e) {
                            System.out.print("Invalid format. Quantity must be a positive integer. Please enter again: ");
                        }
                    }

                    System.out.print("Enter Manufacture ID: ");
                    while (manufactureIdDelete == null || manufactureIdDelete.isEmpty()) {
                        manufactureIdDelete = sc.nextLine();
                        if (manufactureIdDelete.isEmpty()) {
                            System.out.print("Manufacture ID cannot be empty. Please enter again: ");
                        }
                    }

                    if(phoneDAO.remove(new Phone(IDPhoneDelete, namePhoneDelete, priceDelete, colorPhoneDelete, countryPhoneDelete, quantityDelete, manufactureDAO.get(manufactureIdDelete)))){
                        System.out.println("Phone removed successfully");
                    }
                    else {
                        System.out.println("No phone deleted");
                    }
                    break;

                //Update a phone by data input
                case 6:
                    System.out.print("Enter ID: ");
                    sc.nextLine();
                    String IDPhoneUpdate = sc.nextLine();

                    while (IDPhoneUpdate.isEmpty()) {
                        System.out.print("ID cannot be empty. Enter ID: ");
                        IDPhoneUpdate = sc.nextLine();
                    }

                    System.out.print("Enter name updated: ");
                    String namePhoneUpdate = sc.nextLine();

                    while (namePhoneUpdate.isEmpty()) {
                        System.out.print("Name cannot be empty. Enter name updated: ");
                        namePhoneUpdate = sc.nextLine();
                    }

                    System.out.print("Enter color updated: ");
                    String colorPhoneUpdate = sc.nextLine();

                    while (colorPhoneUpdate.isEmpty()) {
                        System.out.print("Color cannot be empty. Enter color updated: ");
                        colorPhoneUpdate = sc.nextLine();
                    }

                    System.out.print("Enter country updated: ");
                    String countryPhoneUpdate = sc.nextLine();

                    while (countryPhoneUpdate.isEmpty()) {
                        System.out.print("Country cannot be empty. Enter country updated: ");
                        countryPhoneUpdate = sc.nextLine();
                    }

                    System.out.print("Enter price updated: ");
                    int priceUpdate = 0;

                    while (priceUpdate <= 0) {
                        try {
                            priceUpdate = sc.nextInt();
                            if (priceUpdate <= 0) {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.print("Invalid price. Enter price updated: ");
                            sc.nextLine(); // Clear the input buffer
                        }
                    }

                    System.out.print("Enter quantity updated: ");
                    int quantityUpdate = 0;

                    while (quantityUpdate <= 0) {
                        try {
                            quantityUpdate = sc.nextInt();
                            if (quantityUpdate <= 0) {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.print("Invalid quantity. Enter quantity updated: ");
                            sc.nextLine();
                        }
                    }

                    System.out.print("Enter Manufacture ID updated: ");
                    sc.nextLine();
                    String manufactureIdUpdate = sc.nextLine();

                    while (manufactureIdUpdate.isEmpty()) {
                        System.out.print("Manufacture ID cannot be empty. Enter Manufacture ID updated: ");
                        manufactureIdUpdate = sc.nextLine();
                    }

                    if(phoneDAO.update(new Phone(IDPhoneUpdate, namePhoneUpdate, priceUpdate, colorPhoneUpdate, countryPhoneUpdate, quantityUpdate, manufactureDAO.get(manufactureIdUpdate)))){
                        System.out.println("Phone updated successfully");
                    }
                    else {
                        System.out.println("No phone updated");
                    }
                    break;

                //The phone with the highest selling price.
                case 7:
                    System.out.println("The phone with the highest selling price: "
                            + phoneDAO.getPhoneWithHighestSellingPrice());
                    break;

                // List of phones sorted by country name
                case 8:
                    System.out.println("List of phones sorted by country name: ");
                    phoneDAO.getPhonesSortedByCountryAndPrice().forEach(System.out::println);
                    break;

                // Check if there is a phone priced above 50 million VND.
                case 9:
                    System.out.println("Check if there is a phone priced above 50 million VND: "
                            + phoneDAO.isPhonePricedAbove50Million());
                    break;

                // First phone has the color 'Pink' and costs over 15 million
                case 10:
                    System.out.println("First phone has the color 'Pink' and costs over 15 million: "
                            + phoneDAO.getFirstPhoneWithPinkColorAndPriceOver15Million());
                    break;

                //Add a new manufacture
                case 11:
                    sc.nextLine();
                    System.out.print("Enter ID: ");
                    String idManufactureAdd = sc.nextLine();
                    while (idManufactureAdd.isEmpty()) {
                        System.out.print("Enter ID: ");
                        idManufactureAdd = sc.nextLine();
                    }
                    System.out.print("Enter name: ");
                    String nameManufactureAdd = sc.nextLine();
                    while (nameManufactureAdd.isEmpty()) {
                        System.out.print("Enter name: ");
                        nameManufactureAdd = sc.nextLine();
                    }

                    System.out.print("Enter location: ");
                    String locationManufactureAdd = sc.nextLine();
                    while (locationManufactureAdd.isEmpty()) {
                        System.out.print("Enter location: ");
                        locationManufactureAdd = sc.nextLine();
                    }

                    System.out.print("Enter employees: ");
                    int employeesManufactureAdd;
                    while (true) {
                        try {
                            employeesManufactureAdd = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.print("Invalid input. Please enter employees: ");
                        }
                    }

                    if(manufactureDAO.add(new Manufacture(idManufactureAdd,nameManufactureAdd,locationManufactureAdd,employeesManufactureAdd))){
                        System.out.println("Add manufacture successfully");
                    }
                    else{
                        System.out.println("Add manufacture fail");
                    }
                    break;

                //Read detail of manufacture by id
                case 12:
                    System.out.print("Enter ID: ");
                    String idManufacture = sc.next();
                    Manufacture m = manufactureDAO.get(idManufacture);
                    if ( m != null){
                        System.out.println(m);
                    }
                    else{
                        System.out.println("Not Found");
                    }
                    break;

                //Real all manufacture
                case 13:
                    manufactureDAO.getAll().forEach(System.out::println);
                    break;

                //Delete a manufacture by id
                case 14:
                    System.out.print("Enter manufacture id: ");
                    sc.nextLine();
                    String idManufactureDelete  = sc.nextLine();
                    if (manufactureDAO.remove(idManufactureDelete)) {
                        System.out.println("Manufacture deleted successfully");
                    } else {
                        System.out.println("No Manufacture deleted");
                    }
                    break;

                //Delete a manufacture by data input
                case 15:
                    sc.nextLine();
                    String manufactureDelete = "";
                    while (manufactureDelete.isEmpty()) {
                        System.out.print("Enter ID: ");
                        manufactureDelete = sc.nextLine();
                    }

                    String nameManufactureDelete = "";
                    while (nameManufactureDelete.isEmpty()) {
                        System.out.print("Enter name: ");
                        nameManufactureDelete = sc.nextLine();
                    }

                    String locationManufactureDelete = "";
                    while (locationManufactureDelete.isEmpty()) {
                        System.out.print("Enter location: ");
                        locationManufactureDelete = sc.nextLine();
                    }

                    int employeesManufactureDelete = 0;
                    boolean validInput = false;
                    while (!validInput) {
                        System.out.print("Enter employees: ");
                        String input = sc.nextLine();
                        try {
                            employeesManufactureDelete = Integer.parseInt(input);
                            validInput = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }
                    if(manufactureDAO.remove(new Manufacture(manufactureDelete, nameManufactureDelete, locationManufactureDelete, employeesManufactureDelete))){
                        System.out.println("Manufacture deleted successfully");
                    }
                    else{
                        System.out.println("No manufacture deleted");
                    }
                    break;

                //Update a manufacture by data input
                case 16:
                    sc.nextLine();

                    System.out.print("Enter ID: ");
                    String IDManufactureUpdate = sc.nextLine();
                    while (IDManufactureUpdate.isEmpty()) {
                        System.out.print("Invalid input. Please enter ID: ");
                        IDManufactureUpdate = sc.nextLine();
                    }

                    System.out.print("Enter name: ");
                    String nameManufactureUpdate = sc.nextLine();
                    while (nameManufactureUpdate.isEmpty()) {
                        System.out.print("Invalid input. Please enter name: ");
                        nameManufactureUpdate = sc.nextLine();
                    }

                    System.out.print("Enter location: ");
                    String locationManufactureUpdate = sc.nextLine();
                    while (locationManufactureUpdate.isEmpty()) {
                        System.out.print("Invalid input. Please enter location: ");
                        locationManufactureUpdate = sc.nextLine();
                    }

                    System.out.print("Enter employees: ");
                    int employeesManufactureUpdate;
                    while (true) {
                        try {
                            employeesManufactureUpdate = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.print("Invalid input. Please enter employees: ");
                        }
                    }

                    if(manufactureDAO.update(new Manufacture(IDManufactureUpdate, nameManufactureUpdate, locationManufactureUpdate, employeesManufactureUpdate))){
                        System.out.println("Manufacture updated successfully");
                    }
                    else{
                        System.out.println("No manufacture updated");
                    }
                    break;

                //Check whether all manufacturers have more than 100 employees
                case 17:
                    System.out.println("Check whether all manufacturers have more than 100 employees: "
                            + manufactureDAO.areAllManufacturersMoreThan100Employees());
                    break;

                //The sum of all employees of the manufactures
                case 18:
                    System.out.println("The sum of all employees of the manufactures: "
                            + manufactureDAO.getTotalEmployeesOfManufacturers());
                    break;

                //Last manufacturer in the list based in the US
                case 19:
                    System.out.println(manufactureDAO.getLastManufacturerBasedInUS());
                    break;

                //Exit
                case 20:
                    loop = false;
                    System.out.println("Good bye !!!!!!");
                    break;
                default:
                    System.out.println("Please choose from 1 to 20");
                    break;
            }
        }
        phoneDAO.close();
        manufactureDAO.close();
    }
}