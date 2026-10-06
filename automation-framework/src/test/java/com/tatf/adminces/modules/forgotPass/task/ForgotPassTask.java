package com.tatf.adminces.modules.forgotPass.task;

import com.tatf.adminces.modules.forgotPass.data.ForgotPassData;
import com.tatf.adminces.modules.forgotPass.pom.ForgotPassPO;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;

public class ForgotPassTask {
    private final IBrowser browser;
    private final ForgotPassPO admin;

    public ForgotPassTask(IBrowser browser) {
        this.browser = browser;
        this.admin = new ForgotPassPO(this.browser);

    }

    public void resetPassword() {

        admin.clickForgotPasswordLink();
        admin.enterEmail(ForgotPassData.emailadmin);
        admin.enterPassword(ForgotPassData.contrasena);
        admin.enterRepeatPassword(ForgotPassData.contrasena);
        admin.clickReset();

    }

}