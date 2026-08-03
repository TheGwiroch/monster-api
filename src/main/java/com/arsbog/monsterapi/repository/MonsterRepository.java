package com.arsbog.monsterapi.repository;

import com.arsbog.monsterapi.model.Monster;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Repository
public class MonsterRepository {
    private final List<Monster> monsters = new ArrayList<>();
    private long nextId = 1;

    public Monster save(Monster monster) {
        monster.setId(nextId++);
        monsters.add(monster);
        return monster;
    }

    public List<Monster> findAll() {
        return monsters;
    }

    public Optional<Monster> findById(Long id) {
        return monsters.stream().filter(monster -> monster.getId().equals(id)).findFirst();
    }

    public boolean deleteById(Long id) {
        return monsters.removeIf(monster -> monster.getId().equals(id));
    }

    public Optional<Monster> update(Long id, Monster updatedMonster) {
        Optional<Monster> monster = findById(id);
            monster.get().setHealth(updatedMonster.getHealth());
            monster.get().setName(updatedMonster.getName());
            monster.get().setPower(updatedMonster.getPower());
            monster.get().setType(updatedMonster.getType());
        return monster;
    }
}
