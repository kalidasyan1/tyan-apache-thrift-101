package server;

import generated.user.User;
import generated.user.UserService;
import org.apache.thrift.TException;
import generated.user.*;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import java.util.HashMap;
import java.util.Map;

public class UserServiceServer {

  public static class UserServiceHandler implements UserService.Iface {
    private final Map<Integer, User> users = new HashMap<>();

    @Override
    public User getUser(int id) {
      return users.getOrDefault(id, new User(-1, "Unknown", "unknown@example.com"));
    }

    @Override
    public void updateUser(User user) throws TException {

    }

    @Override
    public void deleteUser(int id) throws TException {

    }

    @Override
    public void createUser(User user) {
      users.put(user.id, user);
      System.out.println("User created: " + user.name);
    }
  }

  public static void main(String[] args) {
    try {
      UserService.Processor<UserServiceHandler> processor =
          new UserService.Processor<>(new UserServiceHandler());

      TServerTransport serverTransport = new TServerSocket(9090);
      TSimpleServer server = new TSimpleServer(
          new TSimpleServer.Args(serverTransport).processor(processor)
              .protocolFactory(new TBinaryProtocol.Factory())
      );

      System.out.println("Starting the Java Thrift server on port 9090...");
      server.serve();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
