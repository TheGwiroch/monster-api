package com.arsbog.monsterapi.dto;

import java.util.Map;

public record ValidationErrorResponse(int status, Map<String, String> errors) {
}
