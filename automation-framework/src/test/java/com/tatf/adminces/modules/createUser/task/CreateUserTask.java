package com.tatf.adminces.modules.createUser.task;

import com.tatf.adminces.modules.createUser.data.CreateUserData;
import com.tatf.adminces.modules.createUser.pom.CreateUserPO;
import com.tatf.core.browser.IBrowser;

public class CreateUserTask {
    private final IBrowser browser;
    private final CreateUserPO createUser;

    public CreateUserTask(IBrowser browser) {
        this.browser = browser;
        this.createUser = new CreateUserPO(this.browser);
    }

    public void createTester() {
        createUser.enterFirstName(CreateUserData.nombre);
        createUser.enterLastName(CreateUserData.apellido);
        createUser.enterEmail(CreateUserData.email);
        createUser.enterPassword(CreateUserData.contrasena);
        createUser.selectCountry(CreateUserData.pais);
        createUser.selectTesterJunior();
        createUser.clickRegister();

    }
}