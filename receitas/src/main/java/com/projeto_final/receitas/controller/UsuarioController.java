package com.projeto_final.receitas.controller;

import com.projeto_final.receitas.entity.Usuario;
<<<<<<< HEAD
import com.projeto_final.receitas.service.*;
=======
import com.projeto_final.receitas.service.UsuarioService;
>>>>>>> origin/usuarios
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired

    private UsuarioService service;

    @PostMapping
=======
@RequestMapping(value = "/")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping(value = "/auth/register")
>>>>>>> origin/usuarios
    public ResponseEntity<Usuario> create(@RequestBody Usuario obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

<<<<<<< HEAD
=======
    @PostMapping(value = "/auth/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario obj) {

        Usuario usuario = service.login(obj.getEmail(), obj.getPassword());

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(usuario);
    }


>>>>>>> origin/usuarios
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getId(id));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

<<<<<<< HEAD

=======
>>>>>>> origin/usuarios
    @PutMapping(value = "/{id}")

    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj) {
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }
}