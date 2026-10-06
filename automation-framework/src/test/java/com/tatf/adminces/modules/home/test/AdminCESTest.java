package com.tatf.adminces.modules.home.test;

import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.createUser.task.CreateUserTask;
import com.tatf.adminces.modules.forgotPass.task.ForgotPassTask;
import com.tatf.adminces.modules.hash.task.HashTask;
import com.tatf.adminces.modules.home.data.HomeData;
import com.tatf.adminces.modules.home.task.HomeTask;
import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.register.task.RegisterTask;
import com.tatf.adminces.modules.viewUser.task.ViewUserTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdminCESTest extends BaseTest {

    private HashTask hash;
    private HomeTask home;
    private LoginTask login;
    private RegisterTask register;
    private ForgotPassTask forgotPass;
    private CreateUserTask createUser;
    private ViewUserTask viewUser;

    void loginAdmin() {
        home.clickLogin();
        login.logInAsAdmin();
    }

    @BeforeEach
    public void configurar() {
        this.hash = new HashTask(browser);
        this.home = new HomeTask(browser);
        this.login = new LoginTask(browser);
        this.register = new RegisterTask(browser);
        this.forgotPass = new ForgotPassTask(browser);
        this.createUser = new CreateUserTask(browser);
        this.viewUser = new ViewUserTask(browser);
        hash.enterToSystem();

    }

    @Test
    @DisplayName("Crea un usuario Administrador")
    void crearAdministrador() {
        home.clickRegister();
        register.enterForm();
        home.verifyMessage(HomeData.usuariocreado, "No se mostró el mensaje de creación de usuario Administrador.");
    }

    @Test
    @DisplayName("Reinicia la contraseña de un Administrador")
    void reiniciarContrasena() {
        home.clickForgotPassword();
        forgotPass.resetPassword();
        home.verifyMessage(HomeData.contrasenareiniciada, "No se mostró el mensaje de reinicio de contraseña.");
    }

    @Test
    @DisplayName("Crea un usuario Tester")
    void crearTester() {
        loginAdmin();
        home.clickCreateUser();
        createUser.createTester();
        home.verifyMessage(HomeData.usuariocreado, "No se mostró el mensaje de creación de usuario Tester.");
    }

    @Test
    @DisplayName("Elimina un usuario Tester")
    void eliminarTester() {
        loginAdmin();
        viewUser.deleteTester();
        home.verifyMessage(HomeData.usuarioeliminado, "No se mostró el mensaje de usuario eliminado.");
    }
}