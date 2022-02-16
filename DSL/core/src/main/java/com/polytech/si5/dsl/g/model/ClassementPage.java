package com.polytech.si5.dsl.g.model;

import com.polytech.si5.dsl.g.visitor.Visitable;
import com.polytech.si5.dsl.g.visitor.Visitor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClassementPage extends Page implements Visitable {

    private List<DataDisplay> dataDisplays=new ArrayList<>();

    public ClassementPage(String name) {
        super(name);
    }

    @Override
    public void consume(Disposition disposition) {

    }

    @Override
    public void consume(Style style) {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
