package com.polytech.si5.dsl.g.model;

import com.polytech.si5.dsl.g.visitor.Visitable;
import com.polytech.si5.dsl.g.visitor.Visitor;
import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Tableau extends DataDisplay implements Visitable {
    private int size;
    private List<Champ> champs;
    private List<Filtre> filtres;
    private FiltreCheckboxType filtreCheckboxType;
    private ActionDetailsType actionDetailsType = ActionDetailsType.CLICK;
    private final String htmlComponent = "<Tableau />";
    private int nbItemPerPage = 0;


    public Tableau(String name) {
        super(name);
        champs = new ArrayList<>();
        filtres = new ArrayList<>();
    }

    @Override
    public void consume(Disposition disposition) {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
