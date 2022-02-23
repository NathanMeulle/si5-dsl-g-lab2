package com.polytech.si5.dsl.g.model;

import com.polytech.si5.dsl.g.visitor.Visitable;
import com.polytech.si5.dsl.g.visitor.Visitor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class App extends NamedElement implements Visitable {

    private DisciplineType disciplineType;
    private List<Page> pages=new ArrayList<>();
    private String colorNavBar;
    private String fontFamily;
    private String genericFont;
    private boolean haveLogo=false;

    public App(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
