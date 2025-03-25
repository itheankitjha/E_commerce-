Online Shopping Cart (E-Commerce Website)

📹 Introduction & Demo

Watch the full project introduction, demo, and setup guide.

This is an E-Commerce Website built for selling electronics products online.

📖 About the Project

This project allows users to:

Browse & Search: Explore available products, filter by categories, and search for specific items.

User Authentication: Register and log in to manage shopping activities.

Shopping Cart: Add, remove, and update product quantities in the cart.

Checkout: Simulate payment and place orders (for demo purposes).

Order Tracking: View order details and track shipping status.

🛠️ Admin Features:

Add, update, and delete products.

Manage inventory.

Track and update order statuses (e.g., shipped, delivered).

📧 Email Notifications:

Users will receive email notifications for:

Successful registration.

Order placement confirmation.

Product availability (if previously out of stock).

Shipment and delivery updates.

Note: Payment integration is for demo purposes. Any credit card details will be accepted without real payment processing.

📊 Tech Stack

Front-End Development:

CSS (86.4%)

Java (7.2%)

HTML (6.2%)

JavaScript (0.2%)

Back-End Development:

Java (JDK 8+)

JDBC

Servlet

JSP

Database:

MySQL

💻 Software & Tools Required

Git

Java JDK 8+

Eclipse EE (Enterprise Edition)

Apache Maven

Tomcat v8.0+

MySQL Server

MySQL Workbench

🗂️ Dummy Database Initialization

Open MySQL Command Prompt or MySQL Workbench.

Login as admin: mysql -u <username> -p

Execute the SQL script from databases/mysql_query.sql.

📧 Configuring Gmail for Mailing

Ensure 2-Step Verification is enabled on your Gmail account.

Generate an App Password:

Select Other (Custom Name): Enter "Ellison Electronics".

Copy the 16-digit password for later use.

🚀 Importing & Running the Project

Open Eclipse EE.

Import the project via Git:

File > Import > Git > Projects from Git > Clone URI

Select the master branch and finish the import.

Update application.properties:

Set db.username and db.password for MySQL.

Set mailer.email and mailer.password using your Gmail and App Password.

Build the project:

Right-click project > Run As > Maven Build

Enter goal: clean install > Apply > Run.

Resolve dependencies (if needed):

Right-click project > Maven > Update Project (select Force Update).

Configure Tomcat Server:

If Tomcat is NOT configured:

Run As > Run on Server > Define new server.

Select Tomcat v8.0+ and add the project.

If Tomcat is already configured:

Use the Server tab to run/debug the project.

Access the project:

Default URL: http://localhost:8080/shopping-cart/

Change port (if needed):

Open the Server tab.

Double-click Tomcat Server > Ports.

Update the port to 8083, then save and restart.

🔑 Default Credentials

Admin: admin@gmail.com / admin

User: guest@gmail.com / guest

❓ FAQ

1. Unable to Connect to Database?

Ensure MySQL is installed correctly.

Verify database credentials in application.properties.

Run maven clean install and Force Update the project.

Restart Eclipse and Tomcat.

2. Payment Gateway Issues?

This project uses a mock payment system for demo purposes.

Feel free to raise issues or contribute to this project on GitHub.

