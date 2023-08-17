package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {

        //Open page, fill out all the fields and submit
        textBoxPage
                .openPage()
                .setUserName("Alex Egorov")
                .setUserEmail("alex@egorov.com")
                .setCurrentAddress("Some address 1")
                .setPermanentAddress("Another address 1")
                .submit();

        //Verify output
        textBoxPage
                .checkOutput(textBoxPage.outputName, "Alex Egorov")
                .checkOutput(textBoxPage.outputEmail, "alex@egorov.com")
                .checkOutput(textBoxPage.outputCurrentAddress, "Some address 1")
                .checkOutput(textBoxPage.outputPermanentAddress, "Another address 1");
    }
}