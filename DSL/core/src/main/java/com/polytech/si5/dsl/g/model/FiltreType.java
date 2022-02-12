package com.polytech.si5.dsl.g.model;

public enum FiltreType {
    UNIQUE, MULTIPLE, RECHERCHE;

    FiltreType() {}

    public static FiltreType get(String name) {
        for (FiltreType current :FiltreType.values()) {
            if (current.name().equals(name)) return current;
        }
        return null;
    }
}
