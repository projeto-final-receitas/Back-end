package com.projeto_final.receitas.controller;

import com.projeto_final.receitas.entity.Receita;
import com.projeto_final.receitas.service.receitasService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class receitaController {

    @Autowired
    private receitasService service;
    // CREATE
    @PostMapping
    public ResponseEntity<Receita> create(@RequestBody Receita obj) {

        Receita receita = service.create(obj);

        return ResponseEntity.ok(receita);
    }


    // GET ALL
    @GetMapping
    public ResponseEntity<List<Receita>> getAll() {

        List<Receita> receitas = service.getall();

        return ResponseEntity.ok(receitas);
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Receita> getById(@PathVariable Long id) {

        Receita receita = service.getById(id);

        return ResponseEntity.ok(receita);
    }


    // GET BY NOME
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Receita> getByNome(@PathVariable String nome) {

        Receita receita = service.getByNome(nome);

        return ResponseEntity.ok(receita);
    }


    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Receita> update(
            @PathVariable Long id,
            @RequestBody Receita obj) {

        obj.setId(id);

        Receita receita = service.update(obj);

        return ResponseEntity.ok(receita);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        Receita receita = service.getById(id);

        service.delete(receita);

        return ResponseEntity.noContent().build();
    }
}


