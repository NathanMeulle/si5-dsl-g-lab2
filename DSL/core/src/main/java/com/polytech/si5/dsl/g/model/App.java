package com.polytech.si5.dsl.g.model;

import java.util.List;

public class App extends NamedElement {

    private DisciplineType disciplineType;
    private List<Page> pages;

    App(String name) {
        super(name);
    }

}