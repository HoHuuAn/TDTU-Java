package com.hohuuan;

import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Program
{
    public static void main( String[] args ) throws  SQLException {

        if (args.length != 1){
            System.out.println("Invalid Connection URL");
            return;
        }
        ProductDAO productDAO = new ProductDAO(args[0]);
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while(loop){

            System.out.println("**************************************");
            System.out.println("|   1. Real all products             |");
            System.out.println("|   2. Read detail of product by id  |");
            System.out.println("|   3. Add a new product             |");
            System.out.println("|   4. Update a product              |");
            System.out.println("|   5. Delete a product by id        |");
            System.out.println("|   6. Exit                          |");
            System.out.println("**************************************");

            System.out.print("\nChoose from 1 to 6 respectively: ");
            int choose = sc.nextInt();

            List<Product> products = productDAO.readAll();
            switch (choose){
//               Real all products
                case 1:
                    products.forEach(p -> System.out.println(p.toString()));
                    break;
//              Read detail of product by id
                case 2:
                    System.out.print("\nInput id of product: ");
                    int search = sc.nextInt();
                    Product product = productDAO.read(search);
                    if (product != null) {
                        System.out.println(product);
                    }
                    else {
                        System.out.println("Product not found");
                    }
                    break;
//              Add a new product
                case 3:
                    System.out.print("Enter product name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter product price: ");
                    int price = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter product color: ");
                    String color = sc.nextLine();
                    System.out.print("Enter product brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Enter product description: ");
                    String description = sc.nextLine();
                    System.out.print("Enter product quantity: ");
                    int quantity = sc.nextInt();
                    Product AddProduct = new Product(name, price, color, brand, description, quantity);

                    if(  productDAO.add(AddProduct) == 1){
                        System.out.println("Add product successfully");
                    }else{
                        System.out.println("Add product fail");
                    }
                    break;
//              Update a product
                case 4:
                    System.out.print("Enter product id: ");
                    int idFound = sc.nextInt();
                    Product productToUpdate = productDAO.read(idFound);
                    if (productToUpdate != null) {
                        System.out.println("Update information (enter to skip)");
                        int countUpdated = 0;
                        System.out.print("Enter product name: ");
                        sc.nextLine();
                        String nameUpdated = sc.nextLine();
                        if ( !Objects.equals(nameUpdated, "")){
                            productToUpdate.setName(nameUpdated);
                            countUpdated ++;
                        }

                        System.out.print("Enter product price: ");
                        String priceUpdated = sc.nextLine();
                        if (!Objects.equals(priceUpdated, "")){
                            productToUpdate.setPrice(Integer.parseInt(priceUpdated));
                            countUpdated ++;
                        }

                        System.out.print("Enter product color: ");
                        String colorUpdated = sc.nextLine();
                        if ( !Objects.equals(colorUpdated, "")){
                            productToUpdate.setColor(colorUpdated);
                            countUpdated ++;
                        }

                        System.out.print("Enter product brand: ");
                        String brandUpdated = sc.nextLine();
                        if ( !Objects.equals(brandUpdated, "")){
                            productToUpdate.setBrand(brandUpdated);
                            countUpdated ++;
                        }

                        System.out.print("Enter product description: ");
                        String descriptionUpdated = sc.nextLine();
                        if ( !Objects.equals(colorUpdated, "")){
                            productToUpdate.setDescription(descriptionUpdated);
                            countUpdated ++;
                        }

                        System.out.print("Enter product quantity: ");
                        String quantityUpdated = sc.nextLine();
                        if ( !Objects.equals(quantityUpdated, "")){
                            productToUpdate.setQuantity(Integer.parseInt(quantityUpdated));
                            countUpdated ++;
                        }

                        if (productDAO.update(productToUpdate) && countUpdated == 6){
                            System.out.println("Update Successfully");
                        }
                        else{
                            System.out.println("No information is Updated");
                        }
                    }
                    else {
                        System.out.println("Product not found");
                    }
                    break;
//              Delete a product by id
                case 5:
                    System.out.print("Enter product id: ");
                    int idToDelete  = sc.nextInt();
                    if (productDAO.delete(idToDelete)) {
                        productDAO.resetAutoIncrement();
                        System.out.println("Product deleted successfully");
                    } else {
                        System.out.println("No Product deleted");
                    }
                    break;
//              Exit
                case 6:
                    loop = false;
                    System.out.println("Good bye !!!!!!");
                    break;

                default:
                    System.out.println("Please choose from 1 to 6");
                    break;
            }

        }
        productDAO.close();
        sc.close();
    }
}
