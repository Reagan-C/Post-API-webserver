package com.reagan.webservertask.enums;

import lombok.Getter;

@Getter
public enum Operation {
    ADDITION("addition"),
    SUBTRACTION("subtraction"),
    MULTIPLICATION("multiplication"),
    UNKNOWN("invalid operation type");

    private final String value;

    Operation(String value) {
        this.value = value.toLowerCase();
    }
}
