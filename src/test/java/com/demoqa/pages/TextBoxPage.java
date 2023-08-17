package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    public SelenideElement
            userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submit = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");

        //Kill banners and footers
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String name) {
        userName.setValue(name);
        return this;
    }

    public TextBoxPage setUserEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String curAddress) {
        currentAddress.setValue(curAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permAddress) {
        permanentAddress.setValue(permAddress);
        return this;
    }

    public TextBoxPage submit(){
        submit.click();
        return this;
    }

    public TextBoxPage checkOutput(SelenideElement fieldName, String expectedValue) {
        fieldName.shouldHave(text(expectedValue));
        return this;
    }

}
