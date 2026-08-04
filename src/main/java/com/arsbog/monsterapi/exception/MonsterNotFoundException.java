package com.arsbog.monsterapi.exception;

import javax.swing.text.html.HTMLDocument;

public class MonsterNotFoundException extends RuntimeException {
    public MonsterNotFoundException(Long id){
        super("Monster with id " + id + " not found");
    }
}
