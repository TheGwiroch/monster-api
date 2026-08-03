package com.arsbog.monsterapi.service;

import com.arsbog.monsterapi.model.Monster;
import com.arsbog.monsterapi.repository.MonsterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {
    private final MonsterRepository repository;

    public MonsterService(MonsterRepository repository) {
        this.repository = repository;
    }

    public List<Monster> findAll() {
        return repository.findAll();
    }

    public Optional<Monster> findById(Long id) {
        return repository.findById(id);
    }

    public Monster create(Monster monster) {
        return repository.save(monster);
    }

    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }
    public Optional<Monster> update (Long id, Monster updatedMonster){
        return repository.update(id, updatedMonster);
    }
}
