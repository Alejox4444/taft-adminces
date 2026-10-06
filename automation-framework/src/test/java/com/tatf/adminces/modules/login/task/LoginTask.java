package com.tatf.adminces.modules.login.task;

import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.pom.LoginPO;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;

public class LoginTask {
    private final IBrowser browser;
    private final LoginPO login;

    public LoginTask(IBrowser browser) {
        this.browser = browser;
        this.login = new LoginPO(this.browser);

    }

    public void logInAsAdmin() {
        login.clickLoginLink();
        login.enterEmail(LoginData.emailadmin);
        login.enterPassword(LoginData.contrasenaadmin);
        login.clickLogin();
        verifyMessage(LoginData.sesioniniciada, "No se mostró el mensaje de inicio de sesión.");
        login.clickOk();
    }

    public void verifyMessage(String expected, String errorMessage) {
        IVerify.create().verify(expected, login.getAlertMessage(), errorMessage);
    }
}