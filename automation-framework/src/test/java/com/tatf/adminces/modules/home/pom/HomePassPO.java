package com.tatf.adminces.modules.home.pom;

import com.tatf.core.browser.IBrowser;

public class HomePassPO {
    private final IBrowser browser;

    private final String loginLink = "a[href='/adminces/login']";
    private final String registerLink = "a[href='/adminces/register']";
    private final String forgotPasswordLink = "a[href='/adminces/forgot-password']";
    private final String createUserLink = "a[href='/adminces/create-user']";
    private final String alertMessage = "swal2-html-container";


    public HomePassPO(IBrowser browser) {
        this.browser = browser;
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

    public String getAlertMessage() {
        return this.browser.find().id(alertMessage).getText();
    }

}
