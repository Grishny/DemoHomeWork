package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulTextBoxTest() {
        textBoxPage.openPage()
                .setUserName("Alex Egorov")
                .setUserEmail("alex@egorov.com")
                .setCurrentAddress("Some address 1")
                .setPermanentAddress("Another address 1")
                .clickSubmit()
                .checkResult("Alex Egorov", "alex@egorov.com", "Some address 1", "Another address 1");

    }
}