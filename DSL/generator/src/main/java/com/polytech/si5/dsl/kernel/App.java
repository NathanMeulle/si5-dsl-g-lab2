package com.polytech.si5.dsl.kernel;

import com.polytech.si5.dsl.kernel.generator.Visitable;
import com.polytech.si5.dsl.kernel.generator.Visitor;

import java.util.ArrayList;
import java.util.List;

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
