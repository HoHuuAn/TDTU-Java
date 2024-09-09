# OverView
This is our midterm project of JAVA TECHNOLOGY about Student Information Management Application. 
The project includes the following components:

1. Source Code: The source code for the Student Information Management Application includes the implementation of various features and functionalities. It consists of code files written in Java language. The code provides instructions and guidelines on how to integrate and utilize different components of the application. Specifically, the user interface components are implemented using the Swing framework, which is a Java GUI toolkit.

2. PDF File: The project also includes a PDF file that contains a research report on Swing and JDBC technologies. The report provides a comprehensive overview of the features, capabilities, and best practices related to Swing for creating graphical user interfaces (GUIs) in Java, as well as JDBC for connecting Java applications to databases. It covers topics such as creating windows, layouts, event handling, and using JDBC to perform database operations such as retrieving and storing student information.

# Video Demo:
Google Drive: https://drive.google.com/file/d/1ho1P7mqzh8_Oyah9KXrNjZWsv8Azm6rF/view?usp=sharing
Youtube: https://youtu.be/KS-O9EZxw20

# Application Setup Instructions
Prerequisites
Ensure you have XAMPP installed on your machine.
# Database Setup:
Open `XAMPP` and start both the `MySQL` and `Apache servers`.
      Launch your web browser and go to http://localhost/phpmyadmin/.
      Or you can click the button `Admin` next to button start of MySQL

In the phpMyAdmin interface, navigate to the `Import` tab in the header.

Click on the `Choose File` button, then locate and select the `studentmanagementinformation.sql` file from your project directory.

Click `Import` to import the SQL file. This will automatically execute all the SQL commands in the file, creating the necessary tables and inserting the admin user.

# Configure Database Connection:
Open your preferred IDE (e.g., IntelliJ IDEA).
      + Navigate to the project directory and locate `src/main/java/com/Dao`  directory.
      + Locate the `ConnectionConfig`  file and open it
      + Change the connection string to your specific configuration :
      ` public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/studentmanagementinformation?user=root"; ` 

# Running the Application:
Navigate to the project directory and locate `src/main/java/main.` 
Start the `Login file `.
Once the Login file has started, log in to the system using the following credentials:
      + Username: admin
      + Password: admin

Now you should have successfully set up and logged into the Student Management Information System. Explore and manage the student information as needed.

# Test function:
We have provided 4 files for test import/export function:
+ certificateCSV.csv: importing certificates for student by using CSV file 
+ certiifcateExcek.xlsx: importing certificates for student by using Excel file 
+ studentCSV.csv: importing students by using CSV file 
+ studentExcel.xlsx: importing students by using Excel file 