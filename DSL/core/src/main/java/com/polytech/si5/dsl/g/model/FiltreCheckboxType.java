package com.polytech.si5.dsl.g.model;

public enum FiltreCheckboxType {
    RADIO, SWITCH, CHECKBOX;

    FiltreCheckboxType() {}

    public static FiltreCheckboxType get(String name) {
        for (FiltreCheckboxType current : FiltreCheckboxType.values()) {
            if (current.name().equals(name.toUpperCase())) return current;
        }
        return null;
    }
}
