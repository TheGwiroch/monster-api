package com.arsbog.monsterapi.service;

import com.arsbog.monsterapi.exception.MonsterNotFoundException;
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

    public List<Monster> findByMinPower(Integer minPower) {
        return repository.findAll().stream().filter((monster -> monster.getPower() >= minPower)).toList();
    }

    public Monster findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new MonsterNotFoundException(id));
    }

    public Monster create(Monster monster) {
        return repository.save(monster);
    }

    public void deleteById(Long id) {
        boolean deleted = repository.deleteById(id);
        if (!deleted){
            throw new MonsterNotFoundException(id);
        }
    }

    public Monster update(Long id, Monster updatedMonster) {
        return repository.update(id, updatedMonster).orElseThrow(() -> new MonsterNotFoundException(id));
    }
    public Monster updateHealth(Long id, Integer health){
        return repository.updateHealth(id, health).orElseThrow(()-> new MonsterNotFoundException(id));
    }
}
