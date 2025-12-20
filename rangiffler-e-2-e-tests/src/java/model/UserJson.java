package java.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public record UserJson(@JsonProperty("id")
                       UUID id
                       ,@JsonProperty("username")
                       String username
                       ,@JsonProperty("firsname")
                       String firstname
                       ,@JsonProperty("surname")
                       String surname
                       ,@JsonProperty("avatar")
                       String avatar
                       ,@JsonProperty("location")
                       LocationJson location
                       ) {}
