package utils;

import com.github.javafaker.Faker;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDataUtils {
    Faker faker = new Faker(new Locale("ru"));

    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public String randomFirstName() {
        return faker.name().firstName();
    }

    public String randomLastName(){
        return faker.name().lastName();
    }

    public String randomUserEmail(){
        return getRandomString(10) + "@mail.ru";
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String randomGenders(){
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public String getRandomItemFromArray(String[] array){
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public String randomNumber(){
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String randomDayOfBirth(){
        return String.valueOf(faker.number().numberBetween(10, 28));
    }

    public String randomMonthOfBirth(){
         return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String randomYearOfBirth(){
        return String.valueOf(faker.number().numberBetween(1901, 2020));
    }

   public String randomSubjects(){
        List<String> subjects = new ArrayList<>((Arrays.asList("Math", "Accounting", "Arts", "Social Studies", "Biology", "Chemistry", "Computer Science", "Commerce")));

        return faker.options().nextElement(subjects);
    }

    public String randomHobbies(){
        List<String> hobbies = new ArrayList<>((Arrays.asList("Sports", "Reading", "Music")));

        return faker.options().nextElement(hobbies);
    }

    public String randomAddress(){
        return faker.address().streetAddress();
    }

    private  Map <String, String[]> stateAndCity = new HashMap<>(); {

        stateAndCity.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        stateAndCity.put("Uttar Pradesh", new String[] {"Agra", "Lucknow", "Merrut"});
        stateAndCity.put("Haryana", new String[] {"Karnal", "Panipat"});
        stateAndCity.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    };

    public String randomState() {
        return faker.options().option(stateAndCity.keySet().toArray()).toString();
    }

    public String randomCity(String state) {
        return faker.options().option(stateAndCity.get(state));
    }

}
