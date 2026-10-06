package com.tatf.adminces.modules.forgotPass.pom;

import com.tatf.core.browser.IBrowser;

public class ForgotPassPO {
    private final IBrowser browser;

    private final String forgotPasswordLink = "a[href='/adminces/forgot-password']";
    private final String emailInput = "inputEmail";
    private final String passwordInput = "inputPassword";
    private final String repeatPasswordInput = "inputRepeatPassword";
    private final String resetButton = "btnReset";


    public ForgotPassPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickForgotPasswordLink() {
        this.browser.find().css(forgotPasswordLink).click();
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

    public void clickReset() {
        this.browser.find().id(resetButton).click();
    }

}