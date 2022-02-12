package com.polytech.si5.dsl.kernel.generator;

import com.polytech.si5.dsl.g.model.*;
import com.polytech.si5.dsl.g.visitor.Visitor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends Visitor<StringBuffer> {
	enum PASS {ONE, TWO}
	private List<Page> pages;
	private List<String> menuItems;


	public ToWiring() {
		this.result = new StringBuffer();
	}

	private void w(String s) {
		result.append(String.format("%s",s));
	}

	@Override
	public void visit(App app) {
		context.put("pass", PASS.ONE);
		pages = app.getPages();
		if (pages!=null && !pages.isEmpty()) {
			menuItems = pages.stream().map(NamedElement::getName).collect(Collectors.toList());
		}



		context.put("pass", PASS.TWO);

		w("<template>");
		w("\n\t<div id=\"app\">");
		w("\n\t\tHello");

		if (pages!=null && !pages.isEmpty()) {


		}


		w("\n\t</div>");
		w("\n</template>");
		w("\n\n<script>");
		w("\nexport default {");
		w("\n\tname: 'App'");
		w("\n}");
		w("\n</script>");
		w("\n}");

		// App Style
		w("\n\n<style>\n" +
				"#app {\n" +
				"  font-family: Avenir, Helvetica, Arial, sans-serif;\n" +
				"  -webkit-font-smoothing: antialiased;\n" +
				"  -moz-osx-font-smoothing: grayscale;\n" +
				"  text-align: center;\n" +
				"  color: #2c3e50;\n" +
				"}\n" +
				"html {\n" +
				"  min-height: 100%;\n" +
				"  position: relative;\n" +
				"}\n" +
				"body {\n" +
				"  height: 100%;\n" +
				"}\n" +
				"</style>");
	}

	@Override
	public void visit(Champ champ) {

	}

	@Override
	public void visit(ClassementPage classementPage) {

	}

	@Override
	public void visit(Disposition disposition) {

	}

	@Override
	public void visit(Filtre filtre) {

	}

	@Override
	public void visit(Style style) {

	}

	@Override
	public void visit(Tableau tableau) {

	}

}
