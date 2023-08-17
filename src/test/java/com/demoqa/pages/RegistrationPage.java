package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    ResultsTableComponent results = new ResultsTableComponent();

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsContainer input"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateCity = $("#stateCity-wrapper"),
            selectState = stateCity.$(byText("Select State")),
            selectCity = stateCity.$(byText("Select City")),
            submit = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        //Kill banners and footers
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendar.setDate("20", "September", "1994");
        return this;
    }

    public RegistrationPage setSubjects(String ... subjects) {
        for(String subject : subjects) {
            subjectInput.setValue(subject).pressEnter();
        }
        return this;
    }

    public RegistrationPage setHobbies(String ... hobbies) {
        for(String hobby : hobbies) {
            hobbiesInput.$(byText(hobby)).click();
        }
        return this;
    }

    public RegistrationPage setPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddressValue) {
        currentAddress.setValue(currentAddressValue);
        return this;
    }

    public RegistrationPage setState(String state) {
        selectState.click();
        stateCity.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        selectCity.click();
        stateCity.$(byText(city)).click();
        return this;
    }

    public RegistrationPage submit() {
        submit.click();
        return this;
    }

    public RegistrationPage checkResult(String value) {
        results.checkResult(value);
        return this;
    }

}
