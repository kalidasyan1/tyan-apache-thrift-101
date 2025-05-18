package schemaOnly;

import generated.user.User;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;


public class UserSerDeser {

  public static void main(String[] args) throws TException {
    User user = new User();
    user.setId(1);
    user.setName("Alice");
    user.setEmail("alice@example.com");

    // Serialize to byte array
    TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
    byte[] data = serializer.serialize(user);

    // Deserialize
    TDeserializer deserializer = new TDeserializer(new TBinaryProtocol.Factory());
    User newUser = new User();
    deserializer.deserialize(newUser, data);

    System.out.println(newUser.getName());  // "Alice"
  }
}
