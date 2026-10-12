package com.tatf.core.browser;

import com.tatf.core.find.Find;
import com.tatf.core.interaction.Interaction;


/**
 * Interfaz que define operaciones comunes para la gestión del navegador y la espera de elementos en una página web.
 */
public interface IBrowser {
    /**
     * Devuelve el buscador de elementos.
     */
    Find find();

    /**
     * Devuelve el manejador de interacciones del navegador.
     */
    Interaction interaction();

}
