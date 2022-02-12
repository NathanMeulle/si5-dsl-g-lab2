package com.polytech.si5.dsl.g.model;

public abstract class DataDisplay extends NamedElement implements DispositionConsumer {
    private String dataSource;

    public DataDisplay(String name) {
        super(name);
    }
}
