package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModal {

    public void checkResult(String key, String value) {
        $(".modal-content").$(byText(key)).parent()
                .shouldHave(text(value));

    }
}
