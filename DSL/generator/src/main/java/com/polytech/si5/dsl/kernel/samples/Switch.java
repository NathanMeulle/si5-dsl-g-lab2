package com.polytech.si5.dsl.kernel.samples;

import com.polytech.si5.dsl.kernel.App;
import com.polytech.si5.dsl.kernel.generator.ToWiring;
import com.polytech.si5.dsl.g.visitor.Visitor;

public class Switch {

	public static void main(String[] args) {

		// Building the App
		App theSwitch = new App();
		theSwitch.setName("Switch!");

		// Generating Code
		Visitor codeGenerator = new ToWiring();
		theSwitch.accept(codeGenerator);

		// Printing the generated code on the console
		System.out.println(codeGenerator.getResult());
	}

}
