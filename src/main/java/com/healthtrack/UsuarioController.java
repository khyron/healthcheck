package com.healthtrack;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UsuarioController {

    private Usuario usuario;

    @PostMapping("/actualizarPeso")
    public String actualizarPeso(@RequestParam String nombre, @RequestParam double peso) {
        usuario = new Usuario(nombre, peso);
        usuario.actualizarPeso(peso);
        return "Usuario: " + usuario.getNombre() + ", Peso Actual: " + usuario.getPeso() + " kg";
    }
}
