package com.restfull.enums;

import java.util.stream.Stream;

public enum Race {
    HUMAN("human"),
    ELF("elf"),
    ORC("orc"),
    DWARF("dwarf");

    private String value;

    Race(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Race of(String value) {
        return Stream.of(Race.values())
                .filter(val -> val.getValue().equals(value))
                .findFirst()
                .orElseThrow();
    }
}
