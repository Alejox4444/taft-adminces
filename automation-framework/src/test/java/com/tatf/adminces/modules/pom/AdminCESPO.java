package com.tatf.adminces.modules.pom;

import com.tatf.core.browser.IBrowser;

public class AdminCESPO {
    private final IBrowser browser;


    private final String hashInput = "input[type='password']";
    private final String hashSubmitButton = "button[type='submit']";
    private final String loginLink = "a[href='/adminces/login']";
    private final String registerLink = "a[href='/adminces/register']";
    private final String forgotPasswordLink = "a[href='/adminces/forgot-password']";
    private final String createUserLink = "a[href='/adminces/create-user']";
    private final String viewUsersLink = "a[href='/adminces/view-users']";
    private final String firstNameInput = "inputFirstName";
    private final String lastNameInput = "inputLastName";
    private final String emailInput = "inputEmail";
    private final String passwordInput = "inputPassword";
    private final String repeatPasswordInput = "inputRepeatPassword";
    private final String countryInput = "inputCountry";
    private final String loginButton = "//button[contains(text(),'Iniciar Sesión')]";
    private final String registerButton = "btnRegister";
    private final String resetButton = "btnReset";
    private final String testerOption = "testerJunior";
    private final String alertMessage = "swal2-html-container";
    private final String okButton = "//button[contains(text(),'OK')]";
    private final String yesButton = "//button[contains(text(),'Sí')]";

    public AdminCESPO(IBrowser browser) {
        this.browser = browser;
    }

    public void navigateTo(String url) {
        this.browser.interaction().navigateTo(url);
    }

    public void enterHash(String hash) {
        this.browser.find().css(hashInput).write(hash);
    }

    public void clickHashSubmitButton() {
        this.browser.find().css(hashSubmitButton).click();
    }

    public void clickLoginLink() {
        this.browser.find().css(loginLink).click();
    }

    public void clickRegisterLink() {
        this.browser.find().css(registerLink).click();
    }

    public void clickForgotPasswordLink() {
        this.browser.find().css(forgotPasswordLink).click();
    }

    public void clickCreateUserLink() {
        this.browser.find().css(createUserLink).click();
    }

    public void clickViewUsersLink() {
        this.browser.find().css(viewUsersLink).click();
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

    public void selectCountry(String value) {
        this.browser.find().name(countryInput).selectValue(value);
    }

    public void clickLogin() {
        this.browser.find().xpath(loginButton).click();
    }

    public void clickRegister() {
        this.browser.find().id(registerButton).click();
    }

    public void clickReset() {
        this.browser.find().id(resetButton).click();
    }

    public void selectTesterJunior() {
        this.browser.find().id(testerOption).click();
    }

    public void clickDeleteUser(String email) {
        this.browser.find().css("button[id='"+ email + "']").click();
    }

    public String getAlertMessage() {
        return this.browser.find().id(alertMessage).getText();
    }

    public void clickOk() {
        this.browser.find().xpath(okButton).click();
    }

    public void clickYes() {
        this.browser.find().xpath(yesButton).click();
    }
}