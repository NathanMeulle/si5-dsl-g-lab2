package com.polytech.si5.dsl.kernel;

import com.polytech.si5.dsl.g.visitor.Visitable;
import com.polytech.si5.dsl.g.visitor.Visitor;

public class App implements NamedElement, Visitable {

	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
