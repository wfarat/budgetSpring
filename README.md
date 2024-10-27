
---
# Budget Planner Project

A **Budget Planner** application that allows users to track their personal finances. This project includes a **Spring Boot backend** connected to a **MariaDB database** for managing financial records and **React Native mobile app integration** using **Firebase Authentication** for user management.

## Table of Contents

1. [Features](#features)
2. [Architecture](#architecture)
3. [Technologies Used](#technologies-used)
4. [Getting Started](#getting-started)
5. [Setup and Configuration](#setup-and-configuration)
6. [API Documentation](#api-documentation)
7. [Usage](#usage)
8. [Security](#security)
9. [Future Enhancements](#future-enhancements)

---

## Features

- User Authentication with Firebase (email/password, Google, etc.)
- Secure JWT-based API calls to the Spring Boot backend
- Financial account and transaction management (create, read, update, delete)
- Persistent data storage using MariaDB
- RESTful APIs for mobile integration
- Docker setup for easy containerization and deployment

## Architecture

The project is divided into three main components:

1. **React Native Mobile App**:
    - Firebase Authentication for managing user sign-in/sign-up.
    - Sends requests to the backend API with Firebase-provided JWT tokens.

2. **Spring Boot Backend**:
    - RESTful API to handle budgeting operations (account creation, transactions, etc.).
    - Verifies Firebase JWT tokens for authentication.
    - Communicates with a MariaDB database for persistent storage of user data.

3. **MariaDB Database**:
    - Stores user financial data (accounts, transactions).
    - Automatically managed through Spring Data JPA.

## Technologies Used

- **Frontend**: React Native, Firebase Authentication
- **Backend**: Spring Boot, Spring Data JPA, Firebase Admin SDK
- **Database**: MariaDB
- **Containerization**: Docker (optional)
- **Others**: Lombok (for code reduction), JWT (for secure token handling)

---

## Getting Started

### Prerequisites

- **Java 17+** (for Spring Boot 3 compatibility)
- **MariaDB** or **MySQL** (for local database setup)
- **Node.js** and **npm** (for React Native)
- **Firebase Account** (for Authentication setup)
- **Docker** (optional, for containerization)

### Firebase Setup

1. Go to the Firebase Console and create a new project.
2. Enable Firebase Authentication and configure sign-in methods (email/password, Google, etc.).
3. Download the Firebase configuration file (JSON for Android).
4. Store the Firebase service account JSON file in the Spring Boot project for Firebase Admin setup.

### Spring Boot Setup

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/budget-planner.git
   cd budget-planner
   ```

2. Configure **application.properties** (or **application.yml**) in `src/main/resources`:
   ```properties
   spring.datasource.url=jdbc:mariadb://localhost:3306/budget_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

   # Firebase Configuration
   firebase.config.path=path/to/your/firebase/serviceAccountKey.json
   ```

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

### MariaDB Setup

1. Install MariaDB locally or use Docker to spin up a MariaDB container:
   ```bash
   docker run --name budget-db -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=budget_db -p 3306:3306 -d mariadb
   ```
2. Ensure your database credentials in **application.properties** match your MariaDB setup.

---

## API Documentation

### Authentication

The backend relies on Firebase for user authentication. Users must log in via Firebase in the mobile app and then send requests to the backend with the Firebase JWT token for authorization.

### User Management Endpoints

- **POST /api/users** - Creates a user in the database
- **GET /api/users/{id}** - Retrieves a user’s profile

### Account Management Endpoints

- **POST /api/accounts** - Creates a new financial account
- **GET /api/accounts/{id}** - Retrieves account details
- **PUT /api/accounts/{id}** - Updates account information
- **DELETE /api/accounts/{id}** - Deletes an account

### Transaction Management Endpoints

- **POST /api/transactions** - Creates a new transaction
- **GET /api/transactions/{id}** - Retrieves transaction details
- **GET /api/accounts/{accountId}/transactions** - Lists all transactions for a specific account
- **PUT /api/transactions/{id}** - Updates a transaction
- **DELETE /api/transactions/{id}** - Deletes a transaction

---

## Usage

1. **React Native Authentication**:
    - Users sign in to the mobile app using Firebase Authentication.
    - Once logged in, the app obtains a Firebase JWT token to include in all backend requests.

2. **Backend Requests**:
    - The mobile app sends HTTP requests to the Spring Boot backend.
    - The backend verifies the JWT token, then processes requests to manage user financial data.

3. **Database Operations**:
    - The Spring Boot backend handles all interactions with the MariaDB database through JPA repositories.
    - All user financial data is securely stored in MariaDB.

---

## Security

- **Firebase Authentication**: Provides secure login, registration, and authentication flow.
- **JWT Token Verification**: Spring Boot verifies Firebase JWT tokens to confirm user identity.
- **Environment Configuration**: Sensitive data (like database credentials) should be stored in environment variables or secured configuration files.
- **Role-Based Access (optional)**: Extend user management to include roles (e.g., admin, user) to restrict API access further.

---

## Future Enhancements

- **Budget Insights**: Add functionality to analyze spending trends and provide insights.
- **Notifications**: Integrate push notifications for budget alerts.
- **Multi-User Support**: Enable shared accounts for family or group budgeting.
- **Enhanced Security**: Implement OAuth2 for additional security layers.

---

## Contributing

If you would like to contribute, please fork the repository and make pull requests for any features, bug fixes, or enhancements.

## License

This project is open-source and available under the MIT License.

---