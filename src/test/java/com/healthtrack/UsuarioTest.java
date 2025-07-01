package com.healthtrack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testActualizarPeso() {
        Usuario usuario = new Usuario("Luis", 70.0);
        usuario.actualizarPeso(72.5);
        assertEquals(72.5, usuario.getPeso(), 0.01);
    }

    @Test
    public void testNombre() {
        Usuario usuario = new Usuario("Luis", 70.0);
        assertEquals("Luis", usuario.getNombre());
    }
}
