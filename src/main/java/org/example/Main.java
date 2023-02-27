package org.example;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverConditions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.title;

public class Main {
    public static void main(String[] args) {
        Configuration.browser = "Firefox";
        open("https://google.com/ncr");

        $(By.name("q")).val("selenide").pressEnter();

        $$("div#rso > div").shouldHave(sizeGreaterThanOrEqual(6));
        $$("div#rso > div").first().shouldHave(text("selenide"));

        $$("div#rso > div").first().$("h3").click();


        webdriver().shouldHave(title("Selenide: concise UI tests in Java"));

    }
}