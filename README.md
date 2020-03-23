# Library-management-system
A system that helps librarians manage records of books.

# How to launch the system
To launch the application, all you need is to dobule click on the Application.jar file.

# Database
In order to use the system privately:
  1. you need to create your own database and change the code or
  2. copy the sql code into a MySQL compiler and run it (the code is in MySQLDatabase.txt).

If the second option is chosen, you also need to copy the MySQL creation functions into the compiler (the code is in MYSQL.txt).

![Image of the database](https://github.com/SamoPritrznik/Library-management-system/blob/master/Database%20image.png)

# Admins
An admin CANNOT be created in the application. It can be created only in the MySQL database directly.

An admins role in the application is to create new librarians and manage them (edit, delete). An admin alse has access to the view librarians window which enables him better control.

In this public trial version, admin has the username: root and the password: root.

# Librarians
Librarians CAN ONLY BE CREATED by admins. Their role is to add new books to the library, rent out those books to people and return the books once the people return the books. The librarians have access to all the books in the database and all the rented out books.
