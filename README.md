👤 User Management System

📖 How It Works

This User Management System allows users to create an account, log in securely, manage their profile information, and log out. All user details are stored and retrieved from a MySQL database using JDBC and Servlets.

When a new user visits the application, they can register by providing their username, email, mobile number, and password. After registration, the user can log in using their username or email along with their password.

Once logged in, the user is redirected to the Dashboard, where they can view their profile details. The user can also edit their profile information, and any changes made are updated in the database. When finished, the user can log out, which ends the session and redirects them back to the Home Page.

✨ Features

🔹 User Registration<br>
🔹 User Login using Username or Email<br>
🔹 Password Show/Hide 👁️<br>
🔹 User Dashboard<br>
🔹 Edit Profile<br>
🔹 Session Management<br>
🔹 Secure Logout<br>
🔹 MySQL Database Connectivity<br>
🔹 Responsive and Modern UI

🏠 Home Page
Users are welcomed with two options:
* 🔑 Login
* 📝 Register

📝 Registration
New users can create an account by entering:
* Username
* Email
* Mobile Number
* Password
The details are stored in the MySQL database.

🔐 Login
Users can login using:
* Username or Email
* Password
After successful authentication, they are redirected to the Dashboard.

📊 Dashboard
The dashboard displays:
* User ID
* Username
* Email
* Mobile Number
* Account Creation Date

✏️ Edit Profile
Users can update their:
* Username
* Email
* Mobile Number
* Password
The updated information is saved in the database.

🚪 Logout
The session is invalidated and the user is redirected back to the Home Page.

🛠️ Technologies Used
💻 Java
🌐 JSP
⚙️ Servlets
🗄️ JDBC
🐬 MySQL
🎨 HTML
🎨 CSS
🚀 Apache Tomcat


📂 Project Flow

A[🏠 Home Page]
--> B[📝 Register Page]

B --> C[💾 Store User Details in MySQL Database]

C --> D[🔐 Login Page]

D --> E[✅ User Authentication]

E --> F[📊 Dashboard]

F --> G[✏️ Edit Profile]

G --> H[💾 Update Details in Database]

H --> I[📊 Dashboard]

I --> J[🚪 Logout]

J --> K[🏠 Home Page]



🎯 Purpose
This project was developed to learn and implement:
* Java Web Development
* JSP and Servlets
* JDBC Connectivity
* Session Handling
* CRUD Operations
* Frontend Styling with CSS
