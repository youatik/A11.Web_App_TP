You are asked to create a small web application (with at least 2 and up to 6 pages excluding the index page) that simulates some functionalities of a website offering product consultation and purchase of Books.
You are asked to create a dynamic website that includes:

* Access to a database (JDBC or persistence framework such as Hibernate, JPA):
* Displaying data from the database
* Searching the database based on multiple criteria (at least 4)
* Updating data in the database (modification or deletion)
* Data validation (input) can be done on the client-side (JavaScript) or server-side.
* Error handling (Exceptions)
* Etc.

General instructions:
* The presentation aspect is important.(Bootstrap suffices)
* The MVC model must be respected.
* Web pages that are not directly accessible to the user must be protected (by saving them in `/WEB-INF`).
* Separation of different types of files (js, css, jsp, html, images) into different folders.
* Class and file names must be meaningful.
* For data access, use a MySQL database.
* This will facilitate the grading process (I don't want to configure another DBMS). You should submit the physical schema of your database.
* The application must be internationalized (at least 2 user-selectable languages available on different pages).

What is currently done;
- A search page with and without filters,
- A results page with a table of books 
- A page that display all books 
- A few other pages testing displaying of clients and other features
- A MySQL schema (user=‘root’ password=’’)
- The creation and insertion script

What is currently needed;
- Login page
- Account page
    - See user details
    - View orders for the account
- View shopping cart
    - Check out cart
- Add to cart button in search page
- Internationalization in i18n for jsp pages, with use of properties files and resource bundle
- Internationalization in French and English with buttons to toggle (use google translate)

No CSS needed, only HTML at this point.
