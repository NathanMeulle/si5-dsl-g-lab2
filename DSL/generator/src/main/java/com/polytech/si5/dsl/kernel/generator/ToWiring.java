package com.polytech.si5.dsl.kernel.generator;

import com.polytech.si5.dsl.g.visitor.Visitor;
import com.polytech.si5.dsl.kernel.App;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends Visitor<StringBuffer> {
	enum PASS {ONE, TWO}


	public ToWiring() {
		this.result = new StringBuffer();
	}

	private void w(String s) {
		result.append(String.format("%s",s));
	}

	@Override
	public void visit(App app) {
		context.put("pass", PASS.ONE);
		w("<template>");
		w("\t<div>");
		w("\t\tHello");
		w("\t</div>");
		w("</template>");
		w("<script>");
		w("export default {");
		w("\tname: 'App'");
		w("}");
		w("</script>");
		w("}");
	}

}
