package tests;

import utils.RandomDataUtils;

public class TestData {
    RandomDataUtils utils = new RandomDataUtils();

    public String firstName = utils.randomFirstName();
    public String lastName = utils.randomLastName();
    public String userEmail = utils.randomUserEmail();
    public String gender = utils.randomGenders();
    public String numberPhone = utils.randomNumber();
    public String dayOfBirth = utils.randomDayOfBirth();
    public String monthOfBirth = utils.randomMonthOfBirth();
    public String yearOfBirth = utils.randomYearOfBirth();
    public String subjects = utils.randomSubjects();
    public String hobbies = utils.randomHobbies();
    public String img = "selenide-logo-big.png";
    public String address = utils.randomAddress();
    public String state = utils.randomState();
    public String city = utils.randomCity(state);

}
