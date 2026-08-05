package com.arsbog.monsterapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateMonsterHealthRequest(@NotNull @Positive Integer health) {
}