package com.arsbog.monsterapi.controller;

import com.arsbog.monsterapi.model.Monster;
import com.arsbog.monsterapi.service.MonsterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<Monster> create(@RequestBody Monster monster) {
        Optional<Monster> createdMonster = Optional.ofNullable(service.create(monster));
        if (createdMonster.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMonster.get());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monster> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        boolean response = service.deleteById(id);
        if (response) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
