package com.tatf.adminces.modules.login.pom;

import com.tatf.core.browser.IBrowser;

public class LoginPO {
    private final IBrowser browser;

    private final String loginLink = "a[href='/adminces/login']";
    private final String emailInput = "inputEmail";
    private final String passwordInput = "inputPassword";
    private final String loginButton = "//button[contains(text(),'Iniciar Sesión')]";
    private final String okButton = "//button[contains(text(),'OK')]";
    private final String alertMessage = "swal2-html-container";

    public LoginPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickLoginLink() {
        this.browser.find().css(loginLink).click();
    }

    public void enterEmail(String value) {
        this.browser.find().name(emailInput).write(value);
    }

    public void enterPassword(String value) {
        this.browser.find().name(passwordInput).write(value);
    }

    public String getAlertMessage() {
        return this.browser.find().id(alertMessage).getText();
    }

    public void clickLogin() {
        this.browser.find().xpath(loginButton).click();
    }

    public void clickOk() {
        this.browser.find().xpath(okButton).click();
    }

}