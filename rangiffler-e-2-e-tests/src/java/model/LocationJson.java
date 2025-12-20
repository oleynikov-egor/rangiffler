package java.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LocationJson(@JsonProperty("name")
                           String name
                           ,@JsonProperty("code")
                           String code) {}
