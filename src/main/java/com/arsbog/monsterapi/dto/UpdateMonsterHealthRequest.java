package com.arsbog.monsterapi.dto;

import org.springframework.web.bind.annotation.PatchMapping;

public record UpdateMonsterHealthRequest(Integer health) {}
