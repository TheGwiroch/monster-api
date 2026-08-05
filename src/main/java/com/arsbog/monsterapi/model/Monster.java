package com.arsbog.monsterapi.model;
import jakarta.validation.constraints.*;

public class Monster {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @Positive
    private int power;
    @Positive
    private int health;
    public Monster(){

    }
    public Monster(String name, String type, int power, int health){
        this.name = name;
        this.type = type;
        this.power = power;
        this.health = health;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
