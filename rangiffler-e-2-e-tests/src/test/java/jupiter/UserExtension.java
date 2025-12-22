package jupiter;

import Service.UsersDbClient;
import com.github.javafaker.Faker;
import model.UserJson;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.support.AnnotationSupport;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace;

public class UserExtension implements BeforeEachCallback, ParameterResolver {
    public static final Namespace NAMESPACE = ExtensionContext.Namespace.create(UserJson.class);
    private final UsersDbClient usersDbClient = new UsersDbClient();

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        AnnotationSupport.findAnnotation(
                context.getTestMethod(),
                User.class
        ).ifPresent(
                anno -> {
                    UserJson userJson = new UserJson(
                            Faker.instance().elderScrolls().firstName(),
                            Faker.instance().internet().password(4,12)
                    );
                    usersDbClient.createUser(userJson);
                    context.getStore(NAMESPACE).put(context.getUniqueId(), userJson);
                }
        );
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(UserJson.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return extensionContext.getStore(NAMESPACE).get(extensionContext.getUniqueId(), UserJson.class);
    }
}
