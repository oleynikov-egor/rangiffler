package Service;

import config.Config;
import model.UserJson;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.DriverManager;
import java.util.UUID;

public class UsersDbClient implements UsersClient{

    private final Config config = Config.getInstance();
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public UserJson createUser(UserJson userJson) {
        try{
            final JdbcTemplate jdbcTemplate = new JdbcTemplate(
                    new SingleConnectionDataSource(
                            DriverManager.getConnection(
                                    config.usersJdbcUrl(),
                                    config.dbUsername(),
                                    config.dbPassword()
                            ),
                            true
                    )
            );
            final String userId = UUID.randomUUID().toString();
            jdbcTemplate.update("INSERT INTO `rangiffler-auth`.`user`(id, username, password, enabled, account_non_expired,account_non_locked, credentials_non_expired) VALUES (UUID_TO_BIN(?,true), ?, ?, ?, ?, ?, ?)",
                    userId,
                    userJson.username(),
                    passwordEncoder.encode(userJson.password()),
                    1,
                    1,
                    1,
                    1);
            jdbcTemplate.update("INSERT INTO `rangiffler-auth`.`authority` (id, user_id, authority) VALUES (UUID_TO_BIN(?, true),UUID_TO_BIN(?, true),?)",
                    UUID.randomUUID().toString(),
                    userId,
                    "write");
            return userJson;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
