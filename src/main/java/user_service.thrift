namespace java user

struct User {
  1: i32 id,
  2: string name,
  3: string email
}

service UserService {
  void createUser(1: User user),
  User getUser(1: i32 id),
  void updateUser(1: User user),
  void deleteUser(1: i32 id)
}
