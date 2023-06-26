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
![plantuml-21](https://github.com/youatik/A11.Web_App_TP/assets/112843400/890a1e2f-0b05-4d3f-b543-a91892f33ff1)<?xml version="1.0" encoding="UTF-8" standalone="no"?><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" contentStyleType="text/css" height="653px" preserveAspectRatio="none" style="width:870px;height:653px;background:#FFFFFF;" version="1.1" viewBox="0 0 870 653" width="870px" zoomAndPan="magnify"><defs/><g><!--MD5=[ce99c9de1d09f7d75a0c7ae000a2beeb]
cluster jdbc--><g id="cluster_jdbc"><path d="M33.04,6 L67.04,6 A3.75,3.75 0 0 1 69.54,8.5 L76.54,28.2969 L861.04,28.2969 A2.5,2.5 0 0 1 863.54,30.7969 L863.54,643.5 A2.5,2.5 0 0 1 861.04,646 L33.04,646 A2.5,2.5 0 0 1 30.54,643.5 L30.54,8.5 A2.5,2.5 0 0 1 33.04,6 " fill="none" style="stroke:#000000;stroke-width:1.5;"/><line style="stroke:#000000;stroke-width:1.5;" x1="30.54" x2="76.54" y1="28.2969" y2="28.2969"/><text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing" textLength="33" x="34.54" y="20.9951">jdbc</text></g><!--MD5=[e3f72718913f1e037c5bc72e44de49f6]
class client--><g id="elem_client"><rect codeLine="9" fill="#F1F1F1" height="123.7813" id="client" rx="2.5" ry="2.5" style="stroke:#181818;stroke-width:0.5;" width="195" x="321.04" y="506"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="39" x="399.04" y="523.9951">Client</text><line style="stroke:#181818;stroke-width:0.5;" x1="322.04" x2="515.04" y1="532.2969" y2="532.2969"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" text-decoration="underline" textLength="49" x="327.04" y="549.292">clientId</text><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="22" x="380.04" y="549.292">INT</text><line style="stroke:#181818;stroke-width:0.5;" x1="322.04" x2="515.04" y1="556.5938" y2="556.5938"/><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="329.04" y="567.2422"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="169" x="341.04" y="573.5889">firstName: VARCHAR(50)</text><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="329.04" y="583.5391"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="168" x="341.04" y="589.8857">lastName: VARCHAR(50)</text><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="329.04" y="599.8359"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="149" x="341.04" y="606.1826">email: VARCHAR(100)</text><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="329.04" y="616.1328"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="169" x="341.04" y="622.4795">address: VARCHAR(200)</text></g><!--MD5=[ba1befc50e6de48c221bc2393455d8f9]
class library--><g id="elem_library"><rect codeLine="17" fill="#F1F1F1" height="205.2656" id="library" rx="2.5" ry="2.5" style="stroke:#181818;stroke-width:0.5;" width="225" x="84.04" y="241"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="44" x="174.54" y="258.9951">Library</text><line style="stroke:#181818;stroke-width:0.5;" x1="85.04" x2="308.04" y1="267.2969" y2="267.2969"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" text-decoration="underline" textLength="80" x="104.04" y="284.292">ean_isbn13</text><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="46" x="188.04" y="284.292">BIGINT</text><rect fill="none" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="92.04" y="294.2422"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="130" x="104.04" y="300.5889">publishDate: DATE</text><rect fill="none" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="92.04" y="310.5391"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="114" x="104.04" y="316.8857">length: INTEGER</text><line style="stroke:#181818;stroke-width:0.5;" x1="85.04" x2="308.04" y1="324.1875" y2="324.1875"/><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="92.04" y="334.8359"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="138" x="104.04" y="341.1826">title: VARCHAR(145)</text><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="92.04" y="351.1328"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="170" x="104.04" y="357.4795">creators: VARCHAR(123)</text><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="92.04" y="367.4297"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="169" x="104.04" y="373.7764">firstName: VARCHAR(13)</text><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="92.04" y="383.7266"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="168" x="104.04" y="390.0732">lastName: VARCHAR(14)</text><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="92.04" y="400.0234"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="199" x="104.04" y="406.3701">description: VARCHAR(4769)</text><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="92.04" y="416.3203"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="168" x="104.04" y="422.667">publisher: VARCHAR(37)</text><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="92.04" y="432.6172"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="139" x="104.04" y="438.9639">price: NUMERIC(7,3)</text></g><!--MD5=[eca45803598a1795f2bde3316c543fc8]
class userAuthentication--><g id="elem_userAuthentication"><rect codeLine="30" fill="#F1F1F1" height="107.4844" id="userAuthentication" rx="2.5" ry="2.5" style="stroke:#181818;stroke-width:0.5;" width="209" x="638.04" y="290"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="136" x="674.54" y="307.9951">User Authentication</text><line style="stroke:#181818;stroke-width:0.5;" x1="639.04" x2="846.04" y1="316.2969" y2="316.2969"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" text-decoration="underline" textLength="49" x="644.04" y="333.292">clientId</text><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="22" x="697.04" y="333.292">INT</text><text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing" textLength="57" x="644.04" y="349.5889">clientId</text><line style="stroke:#181818;stroke-width:0.5;" x1="639.04" x2="846.04" y1="356.8906" y2="356.8906"/><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="646.04" y="367.5391"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="183" x="658.04" y="373.8857">username: VARCHAR(100)</text><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="646.04" y="383.8359"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="180" x="658.04" y="390.1826">password: VARCHAR(100)</text></g><!--MD5=[f7cdc6d2285e17f09c312952ede26341]
class clientOrder--><g id="elem_clientOrder"><rect codeLine="37" fill="#F1F1F1" height="107.4844" id="clientOrder" rx="2.5" ry="2.5" style="stroke:#181818;stroke-width:0.5;" width="221" x="382.04" y="290"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="82" x="451.54" y="307.9951">Client Order</text><line style="stroke:#181818;stroke-width:0.5;" x1="383.04" x2="602.04" y1="316.2969" y2="316.2969"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" text-decoration="underline" textLength="49" x="402.04" y="333.292">orderId</text><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="22" x="455.04" y="333.292">INT</text><text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing" textLength="57" x="402.04" y="349.5889">clientId</text><rect fill="none" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="390.04" y="359.5391"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="117" x="402.04" y="365.8857">orderDate: DATE</text><line style="stroke:#181818;stroke-width:0.5;" x1="383.04" x2="602.04" y1="373.1875" y2="373.1875"/><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="390.04" y="383.8359"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="195" x="402.04" y="390.1826">totalAmount: DECIMAL(10,2)</text></g><!--MD5=[813a40a839adcce9e0053fbac54d9150]
class payment--><g id="elem_payment"><rect codeLine="44" fill="#F1F1F1" height="107.4844" id="payment" rx="2.5" ry="2.5" style="stroke:#181818;stroke-width:0.5;" width="215" x="450.04" y="57.5"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="60" x="527.54" y="75.4951">Payment</text><line style="stroke:#181818;stroke-width:0.5;" x1="451.04" x2="664.04" y1="83.7969" y2="83.7969"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" text-decoration="underline" textLength="72" x="470.04" y="100.792">paymentId</text><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="22" x="546.04" y="100.792">INT</text><text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing" textLength="58" x="470.04" y="117.0889">orderId</text><rect fill="none" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="458.04" y="127.0391"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="114" x="470.04" y="133.3857">expiration: DATE</text><line style="stroke:#181818;stroke-width:0.5;" x1="451.04" x2="664.04" y1="140.6875" y2="140.6875"/><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="458.04" y="151.3359"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="189" x="470.04" y="157.6826">cardNumber: VARCHAR(16)</text></g><!--MD5=[db3fcf359968d7ec7f654797b8d02abf]
class orderItem--><g id="elem_orderItem"><rect codeLine="51" fill="#F1F1F1" height="140.0781" id="orderItem" rx="2.5" ry="2.5" style="stroke:#181818;stroke-width:0.5;" width="171" x="244.04" y="41"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="73" x="293.04" y="58.9951">Order Item</text><line style="stroke:#181818;stroke-width:0.5;" x1="245.04" x2="414.04" y1="67.2969" y2="67.2969"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" text-decoration="underline" textLength="12" x="264.04" y="84.292">id</text><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="22" x="280.04" y="84.292">INT</text><text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing" textLength="58" x="264.04" y="100.5889">orderId</text><text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing" textLength="89" x="264.04" y="116.8857">ean_isbn13</text><rect fill="none" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="252.04" y="126.8359"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="86" x="264.04" y="133.1826">quantity: INT</text><text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing" textLength="57" x="264.04" y="149.4795">clientId</text><line style="stroke:#181818;stroke-width:0.5;" x1="245.04" x2="414.04" y1="156.7813" y2="156.7813"/><rect fill="#F24D5C" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="252.04" y="167.4297"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="145" x="264.04" y="173.7764">price: DECIMAL(10,2)</text></g><!--MD5=[fcd76b3c463d68e3080587aa851a8d7e]
class shoppingCart--><g id="elem_shoppingCart"><rect codeLine="60" fill="#F1F1F1" height="107.4844" id="shoppingCart" rx="2.5" ry="2.5" style="stroke:#181818;stroke-width:0.5;" width="115" x="78.04" y="57.5"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="98" x="86.54" y="75.4951">Shopping Cart</text><line style="stroke:#181818;stroke-width:0.5;" x1="79.04" x2="192.04" y1="83.7969" y2="83.7969"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" text-decoration="underline" textLength="12" x="98.04" y="100.792">id</text><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="22" x="114.04" y="100.792">INT</text><text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing" textLength="57" x="98.04" y="117.0889">clientId</text><text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing" textLength="89" x="98.04" y="133.3857">ean_isbn13</text><rect fill="none" height="6" style="stroke:#C82930;stroke-width:1.0;" width="6" x="86.04" y="143.3359"/><text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing" textLength="86" x="98.04" y="149.6826">quantity: INT</text><line style="stroke:#181818;stroke-width:0.5;" x1="79.04" x2="192.04" y1="156.9844" y2="156.9844"/></g><!--MD5=[3620be8e6457a349ad0b8f0b99221563]
link orderItem to clientOrder--><g id="link_orderItem_clientOrder"><path codeLine="67" d="M378.45,181.16 C402.05,214.53 430.02,254.09 452.36,285.68 " fill="none" id="orderItem-to-clientOrder" style="stroke:#181818;stroke-width:1.0;"/><polygon fill="#181818" points="455.33,289.88,453.3891,280.2243,452.4387,285.8007,446.8623,284.8503,455.33,289.88" style="stroke:#181818;stroke-width:1.0;"/></g><!--MD5=[ea35d57024fe94828fdf746da73435ca]
link orderItem to client--><g id="link_orderItem_client"><path codeLine="68" d="M330.47,181.28 C332.86,249.64 340.56,356.6 364.54,446 C369.47,464.38 376.85,483.52 384.59,501 " fill="none" id="orderItem-to-client" style="stroke:#181818;stroke-width:1.0;"/><polygon fill="#181818" points="386.78,505.89,386.7485,496.0412,384.7347,501.3275,379.4485,499.3136,386.78,505.89" style="stroke:#181818;stroke-width:1.0;"/></g><!--MD5=[ab88f101a420259a309c38854584d3e6]
link orderItem to library--><g id="link_orderItem_library"><path codeLine="69" d="M289.64,181.16 C279.69,198.39 268.79,217.28 258.07,235.86 " fill="none" id="orderItem-to-library" style="stroke:#181818;stroke-width:1.0;"/><polygon fill="#181818" points="255.35,240.58,263.315,234.787,257.8507,236.2503,256.3874,230.7859,255.35,240.58" style="stroke:#181818;stroke-width:1.0;"/></g><!--MD5=[bf985faf353d7c16407223ffe55e5690]
link clientOrder to client--><g id="link_clientOrder_client"><path codeLine="70" d="M475,397.23 C464.66,428.34 451.47,467.99 440.44,501.14 " fill="none" id="clientOrder-to-client" style="stroke:#181818;stroke-width:1.0;"/><polygon fill="#181818" points="438.83,505.98,445.4576,498.6948,440.4026,501.2337,437.8636,496.1787,438.83,505.98" style="stroke:#181818;stroke-width:1.0;"/></g><!--MD5=[016a7cd566f22fc2ed3443b01cf88c4b]
link payment to clientOrder--><g id="link_payment_clientOrder"><path codeLine="71" d="M542.71,164.59 C532.6,200.45 519.21,247.94 508.8,284.83 " fill="none" id="payment-to-clientOrder" style="stroke:#181818;stroke-width:1.0;"/><polygon fill="#181818" points="507.42,289.73,513.7119,282.1529,508.7766,284.9176,506.012,279.9823,507.42,289.73" style="stroke:#181818;stroke-width:1.0;"/></g><!--MD5=[36f496291deb31253c696f1d8ec0ddb1]
link shoppingCart to client--><g id="link_shoppingCart_client"><path codeLine="72" d="M101.8,164.62 C61.32,235.12 6,361.18 66.54,446 C122.65,524.62 233.23,552.68 315.55,562.42 " fill="none" id="shoppingCart-to-client" style="stroke:#181818;stroke-width:1.0;"/><polygon fill="#181818" points="320.93,563.04,312.4315,558.0625,315.9611,562.4831,311.5405,566.0128,320.93,563.04" style="stroke:#181818;stroke-width:1.0;"/></g><!--MD5=[598209966340cafc6a7dc6bcdb303920]
link shoppingCart to library--><g id="link_shoppingCart_library"><path codeLine="73" d="M149.46,164.59 C155.06,185.77 161.74,211 168.28,235.71 " fill="none" id="shoppingCart-to-library" style="stroke:#181818;stroke-width:1.0;"/><polygon fill="#181818" points="169.58,240.64,171.1367,230.9149,168.297,235.8074,163.4045,232.9677,169.58,240.64" style="stroke:#181818;stroke-width:1.0;"/></g><!--MD5=[094ca63a88b6c059f74a5cd68bc949ca]
link userAuthentication to client--><g id="link_userAuthentication_client"><path codeLine="74" d="M682.88,397.26 C663.49,413.54 641.55,431.1 620.54,446 C589.03,468.35 553.25,490.69 520.65,509.98 " fill="none" id="userAuthentication-to-client" style="stroke:#181818;stroke-width:1.0;"/><polygon fill="#181818" points="516.28,512.55,526.0629,511.4119,520.5838,510.0049,521.9907,504.5258,516.28,512.55" style="stroke:#181818;stroke-width:1.0;"/></g><!--MD5=[186fc2b830829c09fd1a62284ed56c51]
@startuml
!define Table(name, desc) class name as "desc" << (T,#FFAAAA) >>
!define PrimaryKey(x) <u>x</u>
!define ForeignKey(x) <b>x</b>

hide circle
hide empty attributes

package "jdbc" {
  Table(client, "Client") {
    PrimaryKey(clientId) INT
    - firstName: VARCHAR(50)
    - lastName: VARCHAR(50)
    - email: VARCHAR(100)
    - address: VARCHAR(200)
  }

  Table(library, "Library") {
    PrimaryKey(ean_isbn13) BIGINT
    - title: VARCHAR(145)
    - creators: VARCHAR(123)
    - firstName: VARCHAR(13)
    - lastName: VARCHAR(14)
    - description: VARCHAR(4769)
    - publisher: VARCHAR(37)
    - publishDate: DATE
    - price: NUMERIC(7,3)
    - length: INTEGER
  }

  Table(userAuthentication, "User Authentication") {
    PrimaryKey(clientId) INT
    ForeignKey(clientId)
    - username: VARCHAR(100)
    - password: VARCHAR(100)
  }

  Table(clientOrder, "Client Order") {
    PrimaryKey(orderId) INT
    ForeignKey(clientId)
    - orderDate: DATE
    - totalAmount: DECIMAL(10,2)
  }

  Table(payment, "Payment") {
    PrimaryKey(paymentId) INT
    ForeignKey(orderId)
    - cardNumber: VARCHAR(16)
    - expiration: DATE
  }

  Table(orderItem, "Order Item") {
    PrimaryKey(id) INT
    ForeignKey(orderId)
    ForeignKey(ean_isbn13)
    - quantity: INT
    - price: DECIMAL(10,2)
    ForeignKey(clientId)
  }

  Table(shoppingCart, "Shopping Cart") {
    PrimaryKey(id) INT
    ForeignKey(clientId)
    ForeignKey(ean_isbn13)
    - quantity: INT
  }

  orderItem - -> clientOrder
  orderItem - -> client
  orderItem - -> library
  clientOrder - -> client
  payment - -> clientOrder
  shoppingCart - -> client
  shoppingCart - -> library
  userAuthentication - -> client
}
@enduml


   </g></svg>
