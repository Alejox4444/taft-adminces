package com.tatf.adminces.modules.createUser.task;

import com.tatf.adminces.modules.createUser.pom.CreateUserPO;
import com.tatf.core.browser.IBrowser;

public class CreateUserTask {
    private final IBrowser browser;
    private final CreateUserPO createUser;

    public CreateUserTask(IBrowser browser) {
        this.browser = browser;
        this.createUser = new CreateUserPO(this.browser);
    }

    public void createTester(String nombre, String apellido, String email, String contrasena, String pais, String tipotester) {
        createUser.enterFirstName(nombre);
        createUser.enterLastName(apellido);
        createUser.enterEmail(email);
        createUser.enterPassword(contrasena);
        createUser.selectCountry(pais);
        createUser.selectTesterJunior(tipotester);
        createUser.clickRegister();

    }
}