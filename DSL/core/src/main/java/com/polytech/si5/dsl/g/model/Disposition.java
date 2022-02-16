package com.polytech.si5.dsl.g.model;

import com.polytech.si5.dsl.g.visitor.Visitable;
import com.polytech.si5.dsl.g.visitor.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Disposition implements Visitable {
    private int padding;
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
