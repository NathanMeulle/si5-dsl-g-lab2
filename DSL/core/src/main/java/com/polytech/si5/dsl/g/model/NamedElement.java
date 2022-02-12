package com.polytech.si5.dsl.g.model;

import com.polytech.si5.dsl.g.visitor.Visitable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class NamedElement implements Visitable {
    protected String name;

    public NamedElement(String name) {
        this.name = name;
    }
}
