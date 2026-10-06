package com.tatf.adminces.modules.register.task;

import com.tatf.adminces.modules.register.data.RegisterData;
import com.tatf.adminces.modules.register.pom.RegisterPO;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;

public class RegisterTask {
    private final IBrowser browser;
    private final RegisterPO register;

    public RegisterTask(IBrowser browser) {
        this.browser = browser;
        this.register = new RegisterPO(this.browser);

    }

    public void enterForm() {
        register.enterFirstName(RegisterData.nombre);
        register.enterLastName(RegisterData.apellido);
        register.enterEmail(RegisterData.email);
        register.enterPassword(RegisterData.contrasena);
        register.enterRepeatPassword(RegisterData.contrasena);
        register.enterCountry(RegisterData.pais);
        register.clickRegister();
    }


}