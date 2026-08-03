package com.arsbog.monsterapi.controller;

import com.arsbog.monsterapi.model.Monster;
import com.arsbog.monsterapi.service.MonsterService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monsters")
public class MonsterController {
    private final MonsterService service;

    public MonsterController(MonsterService service) {
        this.service = service;
    }

    @GetMapping
    public List<Monster> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Monster create(@RequestBody Monster monster) {
        return service.create(monster);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monster> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
