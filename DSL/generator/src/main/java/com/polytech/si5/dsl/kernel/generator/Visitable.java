package com.polytech.si5.dsl.kernel.generator;

public interface Visitable {

	public void accept(Visitor visitor);

}
