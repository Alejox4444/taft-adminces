package com.tatf.core.browser;


import com.tatf.core.driver.instance.DriverManagerSingleton;
import com.tatf.core.find.Find;
import com.tatf.core.interaction.Interaction;


public class BrowserImpl implements IBrowser {
    private final DriverManagerSingleton instance;
    private final boolean debugging;

    /**
     * Guarda el driver, el tiempo de espera y si está en modo debug.
     *
     * @param instance    Instancia del Singleton que provee el driver.
     * @param waitSeconds Tiempo de espera por defecto, en segundos.
     * @param debugging   Si es true, resalta los elementos al interactuar con ellos.
     */
    public BrowserImpl(DriverManagerSingleton instance, int waitSeconds, boolean debugging) {
        this.instance = instance;
        this.debugging = debugging;
    }

    @Override
    public Find find() {
        return new Find(instance, debugging);
    }

    @Override
    public Interaction interaction() {
        return new Interaction(instance);
    }

}