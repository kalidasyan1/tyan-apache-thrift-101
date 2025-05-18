
# 🧩 Thrift UserService (Java)

A simple RPC service built using **Apache Thrift** in **Java** that allows clients to create and retrieve user data.

## 📁 Project Structure
```
thrift-java-user-service/
├── user_service.thrift         # Thrift IDL definition
├── gen-java/                   # Generated Java code from Thrift compiler
├── server/
│   └── UserServiceServer.java  # Java implementation of the Thrift server
└── client/
└── UserServiceClient.java  # Java client that calls the server
```
---

## ⚙️ Prerequisites

- Java JDK 8 or higher
- Apache Thrift installed (`thrift` CLI)
- Optionally: Apache Maven (for build automation)

---

## 📜 Step 1: Define the Service (`user_service.thrift`)

```thrift
namespace java user

struct User {
  1: i32 id,
  2: string name,
  3: string email
}

exception UserNotFound {
  1: string message
}

service UserService {
  User getUser(1:i32 id) throws (1: UserNotFound notFound),
  void createUser(1:User user)
}
```


##  🛠️ Step 2: Generate Java Code
```
thrift --gen java user_service.thrift
```

This creates files under gen-java/user/, including:
* UserService.java
* User.java
* UserNotFound.java



## 🖥️ Step 3: Run the Server

server/UserServiceServer.java

Implements the logic for storing and retrieving users. Start the server:
```
javac -cp .:gen-java server/UserServiceServer.java
```

Output:

Starting the Java Thrift server on port 9090...


## 🤖 Step 4: Run the Client

client/UserServiceClient.java

Sends RPC requests to the server:
```
javac -cp .:gen-java client/UserServiceClient.java
```

Expected output:
```
User created successfully.
Retrieved User:
ID: 1
Name: Alice
Email: alice@example.com
```



## 📦 Optional: Using Maven?

Add this dependency to your pom.xml:
```
<dependency>
  <groupId>org.apache.thrift</groupId>
  <artifactId>libthrift</artifactId>
  <version>0.21.0</version>
</dependency>
```


## 🔒 Advanced Features
	•	Exception handling (UserNotFound)
	•	Support for binary, JSON, and compact protocols
	•	Multithreaded servers using TThreadPoolServer
	•	SSL with TSSLTransportFactory (optional)


## 📚 Resources
	•	Apache Thrift Docs
	•	Thrift Java Examples
	•	Thrift GitHub Repo


## 🧠 License
This project is for educational and demo purposes. You are free to modify, distribute, and use it as a base for other projects.
