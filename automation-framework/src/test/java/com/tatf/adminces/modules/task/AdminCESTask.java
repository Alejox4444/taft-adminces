package com.tatf.adminces.modules.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.adminces.modules.data.AdminCESData;
import com.tatf.adminces.modules.pom.AdminCESPO;

public class AdminCESTask {
    private final IBrowser browser;
    private final AdminCESPO admin;

    public AdminCESTask(IBrowser browser) {
        this.browser = browser;
        this.admin = new AdminCESPO(this.browser);

    }

    public void enterToSystem() {
        admin.navigateTo(AdminCESData.url);
        admin.enterHash(AdminCESData.hash);
        admin.clickHashSubmitButton();
    }

    public void logInAsAdminAndVerify() {
        enterToSystem();
        admin.clickLoginLink();
        admin.enterEmail(AdminCESData.emailadmin);
        admin.enterPassword(AdminCESData.contrasenaadmin);
        admin.clickLogin();
        verifyMessage(AdminCESData.sesioniniciada, "No se mostró el mensaje de inicio de sesión.");
        admin.clickOk();
    }

    public void createAdminAndVerify() {
        enterToSystem();
        admin.clickRegisterLink();
        admin.enterFirstName(AdminCESData.nombre);
        admin.enterLastName(AdminCESData.apellido);
        admin.enterEmail(AdminCESData.email);
        admin.enterPassword(AdminCESData.contrasena);
        admin.enterRepeatPassword(AdminCESData.contrasena);
        admin.enterCountry(AdminCESData.pais);
        admin.clickRegister();
        verifyMessage(AdminCESData.usuariocreado, "No se mostró el mensaje de creación de usuario Administrador.");
    }

    public void resetPasswordAndVerify() {
        enterToSystem();
        admin.clickForgotPasswordLink();
        admin.enterEmail(AdminCESData.emailadmin);
        admin.enterPassword(AdminCESData.contrasena);
        admin.enterRepeatPassword(AdminCESData.contrasena);
        admin.clickReset();
        verifyMessage(AdminCESData.contrasenareiniciada, "No se mostró el mensaje de reinicio de contraseña.");
    }

    public void createTesterAndVerify() {
        logInAsAdminAndVerify();
        admin.clickCreateUserLink();
        admin.enterFirstName(AdminCESData.nombre);
        admin.enterLastName(AdminCESData.apellido);
        admin.enterEmail(AdminCESData.email);
        admin.enterPassword(AdminCESData.contrasena);
        admin.selectCountry(AdminCESData.pais);
        admin.selectTesterJunior();
        admin.clickRegister();
        verifyMessage(AdminCESData.usuariocreado, "No se mostró el mensaje de creación de usuario Tester.");
    }

    public void deleteTesterAndVerify() {
        logInAsAdminAndVerify();
        admin.clickViewUsersLink();
        admin.clickDeleteUser(AdminCESData.borrar);
        admin.clickYes();
        verifyMessage(AdminCESData.usuarioeliminado, "No se mostró el mensaje de usuario eliminado.");
    }

    private void verifyMessage(String expected, String errorMessage) {
        IVerify.create().verify(expected, admin.getAlertMessage(), errorMessage);
    }
}