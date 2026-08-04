package com.arsbog.monsterapi.controller;

import com.arsbog.monsterapi.dto.UpdateMonsterHealthRequest;
import com.arsbog.monsterapi.model.Monster;
import com.arsbog.monsterapi.service.MonsterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/monsters")
public class MonsterController {
    private final MonsterService service;

    public MonsterController(MonsterService service) {
        this.service = service;
    }

    @GetMapping
    public List<Monster> findAll(@RequestParam(required = false) Integer minPower) {
        if (minPower == null) {
            return service.findAll();
        }
        return service.findByMinPower(minPower);
    }

    @PostMapping
    public ResponseEntity<Monster> create(@RequestBody Monster monster) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(monster));
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

    @PutMapping("/{id}")
    public ResponseEntity<Monster> update(@PathVariable Long id, @RequestBody Monster monster) {
        return service.update(id, monster).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Monster> updateHealth(@PathVariable Long id, @RequestBody UpdateMonsterHealthRequest updateMonsterHealthRequest) {
        return service.updateHealth(id, updateMonsterHealthRequest.health()).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
