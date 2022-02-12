package com.polytech.si5.dsl.kernel.generator;

import com.polytech.si5.dsl.g.model.*;
import com.polytech.si5.dsl.g.visitor.Visitor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ToWiring extends Visitor<StringBuffer> {
	enum PASS {ONE, TWO}

	private List<Page> pages;
	private List<String> menuItems;
	private final Path path = Paths.get("./ouput/src");;


	public ToWiring() {
		this.result = new StringBuffer();
	}

	private void w(String s) {
		result.append(String.format("%s", s));
	}
	private void w(FileWriter f, String s) {
		try {
			f.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void initProject() {
		try {
			Files.createDirectories(path);

		} catch (IOException e) {
			System.err.println("Failed to create directory!" + e.getMessage());

		}
	}
	private FileWriter createFile(String fileName) throws IOException {
		return new FileWriter(path + "/" + fileName);
	}
	@Override
	public void visit(App app) {
		initProject();
		FileWriter file = null;
		try {
			file = createFile("App.vue");
		} catch (IOException e) {
			e.printStackTrace();
		}

		context.put("pass", PASS.ONE);
		pages = app.getPages();
		if (pages != null && !pages.isEmpty()) {
			menuItems = pages.stream().map(x -> "'" + x.getName() + "'").collect(Collectors.toList());
		}


		context.put("pass", PASS.TWO);
		w(file, "<template>");
		w(file,"\n\t<div id=\"app\">");

		if (pages != null && !pages.isEmpty()) {
			w(file, String.format("\n      <b-navbar toggleable=\"lg\" class=\"navbar navbar-dark bg-primary justify-content-left\">\n" +
					"        <img class=\"mx-2\" :src=\"'https://drive.google.com/uc?export=view&id=1IXY8IZai07UAj0yamXUTTy-RA8baWN2I'\" width=\"30\" height=\"30\" alt=\"\"/>\n" +
					"        <b-navbar-brand href=\"#\">\n" +
					"          %s\n" +
					"        </b-navbar-brand>\n" +
					"        <b-navbar-toggle target=\"nav-collapse\"></b-navbar-toggle>\n" +
					"\n" +
					"        <b-collapse id=\"nav-collapse\" is-nav class=\"d-lg-block\">\n" +
					"          <b-navbar-nav>\n" +
					"            <b-nav-item v-for=\"item in %s\" :key=\"item.message\">\n" +
					"                <a class=\"nav-link\" href=\"#\">{{item}}</a>\n" +
					"            </b-nav-item>\n" +
					"          </b-navbar-nav>\n" +
					"        </b-collapse>\n" +
					"    </b-navbar>", app.getName(), menuItems));
		}

//		for (Page page : app.getPages()){
//			page.accept(this);
//		}


		w(file,"\n\t</div>");
		w(file,"\n</template>");
		w(file,"\n\n<script>");
		w(file,"\nexport default {");
		w(file,"\n\tname: 'App'");
		w(file,"\n}");
		w(file,"\n</script>");
		w(file,"\n}");

		// App Style
		w(file,"\n\n<style>\n" +
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

		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Test Tableau
//		Page firstPage = app.getPages().get(0);
//		ClassementPage classementPage = (ClassementPage) firstPage;
//		DataDisplay dataDisplay = classementPage.getDataDisplays().get(0);
//		Tableau tableau = (Tableau) dataDisplay;
//		tableau.accept(this);
	}

	@Override
	public void visit(Tableau tableau) {
		context.put("pass", PASS.TWO);

		w("\n");
		w("<template>");
		w("\n\t<div>");
		w("\n\t\t<b-table striped hover :items=\"items\"></b-table>");
		w("\n\t</div>");
		w("\n</template>");

		w("\n<script>");
		w("\nexport default {");
		w("\n\tdata() {");
		w("\n\t\treturn {");
		w("\n\t\t\titems: [");
		w("\n\t\t\t\t{ age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },");
		w("\n\t\t\t\t{ age: 21, first_name: 'Larsen', last_name: 'Shaw' },");
		w("\n\t\t\t\t{ age: 89, first_name: 'Geneva', last_name: 'Wilson' },");
		w("\n\t\t\t\t{ age: 38, first_name: 'Jami', last_name: 'Carney' }");
		w("\n\t\t\t]");
		w("\n\t\t}");
		w("\n\t}");
		w("\n}");
		w("\n</script>");


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



}
