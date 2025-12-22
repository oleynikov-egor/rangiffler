package model;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonProperty("id")
//                       UUID id
//                       ,
public record UserJson(@JsonProperty("username")
                       String username
                       ,@JsonProperty("password")
                       String password
                       ) {}
