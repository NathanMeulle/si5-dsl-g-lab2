package com.polytech.si5.dsl.g.model;

import com.polytech.si5.dsl.g.visitor.Visitable;
import com.polytech.si5.dsl.g.visitor.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Style implements Visitable {
    private String hexaColor="#FFFFFF";
    private boolean bold=false;
    private boolean underline=false;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void setHexaColor(String hexaColor) {

        this.hexaColor = hexaColor;
    }

    public void setBold(boolean bold) {

        this.bold = bold;
    }

    public void setUnderline(boolean underline) {

        this.underline = underline;
    }
}
