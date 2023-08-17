package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void studentRegistrationFormTest() {

        //Open page, fill out and submit form
        registrationPage
                .openPage()
                .setFirstName("Piotr")
                .setLastName("Kurochkin")
                .setUserEmail("kura@gmail.com")
                .setGender("Male")
                .setUserNumber("2020327000")
                .setBirthDate("20", "September", "1994")
                .setSubjects("Hindi", "Computer Science", "Economics")
                .setHobbies("Reading", "Music")
                .setPicture("screen.jpg")
                .setCurrentAddress("str. Jenkins 15, 7, 98-452")
                .setState("Haryana")
                .setCity("Panipat")
                .submit();

        //Verify values
        registrationPage
                .checkResult("Piotr Kurochkin")
                .checkResult("Kurochkin")
                .checkResult("kura@gmail.com")
                .checkResult("2020327000")
                .checkResult("Male")
                .checkResult("20 September,1994")
                .checkResult("Hindi, Computer Science, Economics")
                .checkResult("Reading, Music")
                .checkResult("screen.jpg")
                .checkResult("str. Jenkins 15, 7, 98-452")
                .checkResult("Haryana Panipat");
    }

    @Test
    void studentRegistrationMinimalTest() {

        //Open page, fill out and submit form
        registrationPage
                .openPage()
                .setFirstName("Piotr")
                .setLastName("Kurochkin")
                .setUserEmail("kura@gmail.com")
                .setGender("Male")
                .setUserNumber("2020327000")
                .submit();

        //Verify values
        registrationPage
                .checkResult("Piotr Kurochkin")
                .checkResult("Kurochkin")
                .checkResult("kura@gmail.com")
                .checkResult("2020327000")
                .checkResult("Male");
    }
}
