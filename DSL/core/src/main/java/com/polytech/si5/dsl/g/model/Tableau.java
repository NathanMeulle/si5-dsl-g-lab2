package com.polytech.si5.dsl.g.model;

import java.util.List;

public class Tableau extends DataDisplay {
    private int size;
    private List<Champ> champs;
    private List<Filtre> filtres;

    public Tableau(String name) {
        super(name);
    }

    @Override
    public void consume(Disposition disposition) {

    }
}
