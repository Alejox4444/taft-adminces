package com.tatf.adminces.modules.register.task;

//import com.tatf.adminces.modules.register.data.RegisterData;
import com.tatf.adminces.modules.register.pom.RegisterPO;
import com.tatf.core.browser.IBrowser;

public class RegisterTask {
    private final IBrowser browser;
    private final RegisterPO register;

    public RegisterTask(IBrowser browser) {
        this.browser = browser;
        this.register = new RegisterPO(this.browser);
    }

    public void enterForm(String nombre, String apellido, String email, String contrasena, String pais) {
        register.enterFirstName(nombre);
        register.enterLastName(apellido);
        register.enterEmail(email);
        register.enterPassword(contrasena);
        register.enterRepeatPassword(contrasena);
        register.enterCountry(pais);
        register.clickRegister();
    }
}