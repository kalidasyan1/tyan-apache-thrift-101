package client;

import generated.user.User;
import generated.user.UserService;
import generated.user.*;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class UserServiceClient {
  public static void main(String[] args) {
    try {
      // Connect to localhost:9090 (same as server port)
      TTransport transport = new TSocket("localhost", 9090);
      transport.open();

      TBinaryProtocol protocol = new TBinaryProtocol(transport);
      UserService.Client client = new UserService.Client(protocol);

      // Create a user
      User newUser = new User();
      newUser.setId(1);
      newUser.setName("Alice");
      newUser.setEmail("alice@example.com");

      client.createUser(newUser);
      System.out.println("User created successfully.");

      // Retrieve the user
      User retrieved = client.getUser(1);
      System.out.println("Retrieved User:");
      System.out.println("ID: " + retrieved.id);
      System.out.println("Name: " + retrieved.name);
      System.out.println("Email: " + retrieved.email);

      transport.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
