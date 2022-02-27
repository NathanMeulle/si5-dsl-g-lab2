package com.polytech.si5.dsl.g.model;

import com.polytech.si5.dsl.g.visitor.Visitable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Page extends NamedElement implements Visitable, DispositionConsumer, StyleConsumer {
    private Titre titre;

    public Page(String name) {
        super(name);
        titre = new Titre(name);
    }
}
