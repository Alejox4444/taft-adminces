package com.tatf.adminces.modules.home.test;

import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.createUser.task.CreateUserTask;
import com.tatf.adminces.modules.forgotPass.task.ForgotPassTask;
import com.tatf.adminces.modules.hash.task.HashTask;
import com.tatf.adminces.modules.home.data.HomeData;
import com.tatf.adminces.modules.home.task.HomeTask;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.register.task.RegisterTask;
import com.tatf.adminces.modules.viewUser.task.ViewUserTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AdminCESTest extends BaseTest {

    private HashTask hash;
    private HomeTask home;
    private LoginTask login;
    private RegisterTask register;
    private ForgotPassTask forgotPass;
    private CreateUserTask createUser;
    private ViewUserTask viewUser;

    void loginAdmin(String emailadmin, String contrasenaadmin) {
        home.clickLogin();
        login.logInAsAdmin(emailadmin,contrasenaadmin);
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

    @ParameterizedTest
    @DisplayName("Crea un usuario Administrador")
    @CsvFileSource(
            resources = "/datos_crearAdmin.csv",
            useHeadersInDisplayName = true
    )
    void crearAdministrador(String nombre, String apellido, String email, String contrasena, String pais) {
        home.clickRegister();
        register.enterForm(nombre,apellido,email,contrasena,pais);
        home.verifyMessage(HomeData.usuariocreado, "No se mostró el mensaje de creación de usuario Administrador.");
    }

    @ParameterizedTest
    @DisplayName("Reinicia la contraseña de un Administrador")
    @CsvFileSource(
            resources = "/datos_reinicioAdmin.csv",
            useHeadersInDisplayName = true
    )
    void reiniciarContrasena(String emailadmin, String contrasenaadmin) {
        home.clickForgotPassword();
        forgotPass.resetPassword(emailadmin,contrasenaadmin);
        home.verifyMessage(HomeData.contrasenareiniciada, "No se mostró el mensaje de reinicio de contraseña.");
    }


    @ParameterizedTest
    @DisplayName("Crea un usuario Tester")
    @CsvFileSource(
            resources = "/datos_crearTester.csv",
            useHeadersInDisplayName = true
    )
    void crearTester(String emailadmin, String contrasenaadmin, String nombre, String apellido, String email, String contrasena, String pais,String tipotester) {
        loginAdmin(emailadmin,contrasenaadmin);
        home.clickCreateUser();
        createUser.createTester(nombre,apellido,email,contrasena,pais,tipotester);
        home.verifyMessage(HomeData.usuariocreado, "No se mostró el mensaje de creación de usuario Tester.");
    }

    @ParameterizedTest
    @DisplayName("Elimina un usuario Tester")
    @CsvFileSource(
            resources = "/datos_borrar.csv",
            useHeadersInDisplayName = true
    )
    void eliminarTester(String emailadmin, String contrasenaadmin, String emailborrar) {
        loginAdmin(emailadmin,contrasenaadmin);
        viewUser.deleteTester(emailborrar);
        home.verifyMessage(HomeData.usuarioeliminado, "No se mostró el mensaje de usuario eliminado.");
    }
}