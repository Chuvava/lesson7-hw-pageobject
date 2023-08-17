package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {

    public void checkResult(String value) {
        $(".table-responsive").shouldHave(text(value));
    }
}
