package com.polytech.si5.dsl.g.model;

public enum DisciplineType {
    TOURNOI, CHAMPIONNAT;

    DisciplineType() {}

    public static DisciplineType get(String name) {
        for (DisciplineType current :DisciplineType.values()) {
            if (current.name().equals(name.toUpperCase())) return current;
        }
        return null;
    }
}