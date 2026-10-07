package com.tatf.adminces.modules.createUser.pom;

import com.tatf.core.browser.IBrowser;

public class CreateUserPO {
    private final IBrowser browser;

    private final String firstNameInput = "inputFirstName";
    private final String lastNameInput = "inputLastName";
    private final String emailInput = "inputEmail";
    private final String passwordInput = "inputPassword";
    private final String countryInput = "inputCountry";
    private final String registerButton = "btnRegister";
 //   private final String testerOption = "testerJunior";


    public CreateUserPO(IBrowser browser) {
        this.browser = browser;
    }

    public void enterFirstName(String value) {
        this.browser.find().name(firstNameInput).write(value);
    }

    public void enterLastName(String value) {
        this.browser.find().name(lastNameInput).write(value);
    }

    public void enterEmail(String value) {
        this.browser.find().name(emailInput).write(value);
    }

    public void enterPassword(String value) {
        this.browser.find().name(passwordInput).write(value);
    }

    public void selectCountry(String value) {
        this.browser.find().name(countryInput).selectValue(value);
    }

    public void clickRegister() {
        this.browser.find().id(registerButton).click();
    }

    public void selectTesterJunior(String testerOption) {
        this.browser.find().id(testerOption).click();
    }

}