package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdminCESTest {

    private static IBrowser browser;
    private void iniciarSesion() {
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("input[type='password']").write("3)ea60e0be3ba12c6ecd%7297868%5c4");
        browser.find().css("button[type='submit']").click();
        browser.find().css("a[href='/adminces/login']").click();
        browser.find().name("inputEmail").write("yaniscorrea@gmail.com");
        browser.find().name("inputPassword").write("12345");
        browser.find().xpath("//button[contains(text(),'Iniciar Sesión')]").click();
        String mensajeObtenido = browser.find().id("swal2-html-container").getText();
        IVerify.create().verify("Sesión iniciada.", mensajeObtenido, "No se mostró el mensaje de inicio de sesión.");
        browser.find().xpath("//button[contains(text(),'OK')]").click();
    }

    @BeforeEach
    public void beforeAll() {
        browser = BrowserFactory.getBrowser(true);
    }

    @AfterEach
    public void afterEach() {
        BrowserFactory.quitBrowser();
    }

    @Test
    void crearAdministrador() {
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("input[type='password']").write("3)ea60e0be3ba12c6ecd%7297868%5c4");
        browser.find().css("button[type='submit']").click();
        browser.find().css("a[href='/adminces/register']").click();
        browser.find().name("inputFirstName").write("Nombre");
        browser.find().name("inputLastName").write("Apellido");
        browser.find().name("inputEmail").write("email@email.com");
        browser.find().name("inputPassword").write("123456");
        browser.find().name("inputRepeatPassword").write("123456");
        browser.find().name("inputCountry").write("Uruguay");
        browser.find().id("btnRegister").click();
        String mensajeObtenido = browser.find().id("swal2-html-container").getText();
        IVerify.create().verify("Usuario creado.", mensajeObtenido, "No se mostró el mensaje de creación de usuario Administrador.");
    }

    @Test
    void reiniciarContrasena() {
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("input[type='password']").write("3)ea60e0be3ba12c6ecd%7297868%5c4");
        browser.find().css("button[type='submit']").click();
        browser.find().css("a[href='/adminces/forgot-password']").click();
        browser.find().name("inputEmail").write("yaniscorrea@gmail.com");
        browser.find().name("inputPassword").write("123456");
        browser.find().name("inputRepeatPassword").write("123456");
        browser.find().id("btnReset").click();
        String mensajeObtenido = browser.find().id("swal2-html-container").getText();
        IVerify.create().verify("Contraseña reiniciada.", mensajeObtenido, "No se mostró el mensaje de reinicio de contraseña.");
    }

    @Test
    void crearTester() {
        iniciarSesion();

        browser.find().css("a[href='/adminces/create-user']").click();
        browser.find().name("inputFirstName").write("Nombre");
        browser.find().name("inputLastName").write("Apellido");
        browser.find().name("inputEmail").write("email@email.com");
        browser.find().name("inputPassword").write("123456");
        browser.find().name("inputCountry").selectValue("Uruguay");
        browser.find().id("testerJunior").click();
        browser.find().id("btnRegister").click();
        String mensajeObtenido = browser.find().id("swal2-html-container").getText();
        IVerify.create().verify("Usuario creado.", mensajeObtenido, "No se mostró el mensaje de creación de usuario Tester.");
    }

    @Test
    void eliminarTester() {
        iniciarSesion();

        browser.find().css("a[href='/adminces/view-users']").click();
        browser.find().css("button[id='jeniffer@gmail.com']").click();
        browser.find().xpath("//button[contains(text(),'Sí')]").click();
        String mensajeObtenido = browser.find().id("swal2-html-container").getText();
        IVerify.create().verify("Usuario eliminado.", mensajeObtenido, "No se mostró el mensaje de usuario eliminado.");
    }
}
