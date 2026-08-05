package com.arsbog.monsterapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record MonsterRequest(@NotBlank String name, @NotBlank String type, @Positive int power, @Positive int health) {
}
