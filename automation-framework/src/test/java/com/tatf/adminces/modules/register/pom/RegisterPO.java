package com.tatf.adminces.modules.register.pom;

import com.tatf.core.browser.IBrowser;

public class RegisterPO {
    private final IBrowser browser;

    private final String firstNameInput = "inputFirstName";
    private final String lastNameInput = "inputLastName";
    private final String emailInput = "inputEmail";
    private final String passwordInput = "inputPassword";
    private final String repeatPasswordInput = "inputRepeatPassword";
    private final String countryInput = "inputCountry";
    private final String registerButton = "btnRegister";


    public RegisterPO(IBrowser browser) {
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

    public void enterRepeatPassword(String value) {
        this.browser.find().name(repeatPasswordInput).write(value);
    }

    public void enterCountry(String value) {
        this.browser.find().name(countryInput).write(value);
    }

    public void clickRegister() {
        this.browser.find().id(registerButton).click();
    }


    }

