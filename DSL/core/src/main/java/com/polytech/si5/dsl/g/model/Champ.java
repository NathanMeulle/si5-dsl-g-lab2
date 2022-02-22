package com.polytech.si5.dsl.g.model;

import com.polytech.si5.dsl.g.visitor.Visitable;
import com.polytech.si5.dsl.g.visitor.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Champ extends NamedElement implements Visitable, StyleConsumer {

    private boolean hide;
    private boolean inDetail;
    private Style style;
    public Champ(String name) {
        super(name);
        this.hide = false;
        this.inDetail = false;
    }
    public Champ(String name, boolean hide) {
        super(name);
        this.hide = hide;
        this.inDetail = false;
    }
    public Champ(String name, boolean hide, boolean inDetail) {
        super(name);
        this.hide = hide;
        this.inDetail = inDetail;
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
