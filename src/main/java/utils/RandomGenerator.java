package utils;

import com.github.javafaker.Faker;

public class RandomGenerator {

    public static final Faker faker = new Faker();
    public static final String randomProjectName = faker.funnyName().name();
}
