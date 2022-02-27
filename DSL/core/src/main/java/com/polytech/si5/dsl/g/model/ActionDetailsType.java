package com.polytech.si5.dsl.g.model;

public enum ActionDetailsType {
    CLICK, DOUBLECLICK, HOVER;

    ActionDetailsType() {}

    public static ActionDetailsType get(String name) {
        for(ActionDetailsType current : ActionDetailsType.values()) {
            if (current.name().equals(name.toUpperCase())) return current;
        }
        return null;
    }
}
