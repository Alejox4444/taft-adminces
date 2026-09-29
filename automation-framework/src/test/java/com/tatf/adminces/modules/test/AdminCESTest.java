package com.tatf.adminces.modules.test;

import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.task.AdminCESTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdminCESTest extends BaseTest {

    private AdminCESTask admin;

    @BeforeEach
    public void configurar() {
        this.admin = new AdminCESTask(browser);
    }

    @Test
    @DisplayName("Crea un usuario Administrador")
    void crearAdministrador() {
        admin.createAdminAndVerify();
    }

    @Test
    @DisplayName("Reinicia la contraseña de un Administrador")
    void reiniciarContrasena() {
        admin.resetPasswordAndVerify();
    }

    @Test
    @DisplayName("Crea un usuario Tester")
    void crearTester() {
        admin.createTesterAndVerify();
    }

    @Test
    @DisplayName("Elimina un usuario Tester")
    void eliminarTester() {
        admin.deleteTesterAndVerify();
    }
}