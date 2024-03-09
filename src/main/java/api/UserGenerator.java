package api;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    @Step("Генерация корректного юзера")
    public static UserData getRandomUser() {
        UserData userData = new UserData();
        Faker faker = new Faker();
        userData.setEmail(faker.internet().emailAddress());
        userData.setPassword(RandomStringUtils.randomAlphanumeric(7));
        userData.setName(faker.name().name());
        return userData;
    }

}
