package com.polytech.si5.dsl.g.model;

import com.polytech.si5.dsl.g.visitor.Visitable;
import com.polytech.si5.dsl.g.visitor.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Titre extends NamedElement implements Visitable, StyleConsumer {

    private Style style;

    public Titre(String name) {
        super(name);
    }

    @Override
    public void consume(Style style) {
        this.style = style;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
