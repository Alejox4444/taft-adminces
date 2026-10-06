package com.tatf.adminces.modules.home.task;

import com.tatf.adminces.modules.home.data.HomeData;
import com.tatf.adminces.modules.home.pom.HomePassPO;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;

public class HomeTask {
    private final IBrowser browser;
    private final HomePassPO home;

    public HomeTask(IBrowser browser) {
        this.browser = browser;
        this.home = new HomePassPO(this.browser);
    }

    public void clickRegister() {
        home.clickRegisterLink();
    }

    public void clickLogin() {
        home.clickLoginLink();
    }

    public void clickForgotPassword() {
        home.clickForgotPasswordLink();
    }

    public void clickCreateUser() {
        home.clickCreateUserLink();
    }

    public void verifyMessage(String expected, String errorMessage) {
        IVerify.create().verify(expected, home.getAlertMessage(), errorMessage);
    }
}