package com.polytech.si5.dsl.g.model;

import com.polytech.si5.dsl.g.visitor.Visitable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DataDisplay extends NamedElement implements Visitable,DispositionConsumer {
    private Titre titre;
    private String dataSource;
    private String htmlComponent;

    public DataDisplay(String name) {
        super(name);
    }
}
