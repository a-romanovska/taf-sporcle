package com.sporcle;

import com.github.javafaker.Faker;

public class User {
    private String email;
    private String password;

    private final Faker faker = new Faker();

    public String getEmail() {
        email = faker.internet().emailAddress();
        return email;
    }

    public String getPassword(){
        password = faker.internet().password();
        return password;
    }
}
