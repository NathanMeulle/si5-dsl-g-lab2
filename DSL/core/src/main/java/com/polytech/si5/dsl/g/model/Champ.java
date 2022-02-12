package com.polytech.si5.dsl.g.model;

import com.polytech.si5.dsl.g.visitor.Visitable;
import com.polytech.si5.dsl.g.visitor.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Champ extends NamedElement implements Visitable, StyleConsumer {

    public Champ(String name) {
        super(name);
    }

    @Override
    public void consume(Style style) {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
