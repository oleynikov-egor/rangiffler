package Service;

import model.UserJson;

public interface UsersClient {
    UserJson createUser(UserJson userJson);
}
