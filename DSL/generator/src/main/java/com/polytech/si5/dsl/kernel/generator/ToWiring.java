package com.polytech.si5.dsl.kernel.generator;

import com.polytech.si5.dsl.g.model.*;
import com.polytech.si5.dsl.g.visitor.Visitor;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ToWiring extends Visitor<StringBuffer> {
	enum PASS {ONE, TWO}

	private List<Page> pages;
	private List<String> menuItems;
	private final Path path = Paths.get("../output/src");


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
		createDirectory("views");
		createDirectory("components");
		createDirectory("external");
	}

	private void createDirectory(String name){
		try {
			Path p = Paths.get("../output/src/" + name);;
			Files.createDirectories(p);
		} catch (IOException e) {
			System.err.println("Failed to create directory!" + e.getMessage());
		}
	}

	private FileWriter createFile(String fileName) throws IOException {
		return new FileWriter(path + "/" + fileName);
	}

	private void createExternalRessource(String functionName){
		FileWriter file = null;
		try {
			file = createFile("external/getData_" + functionName + ".js");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// mock Data to display the array, will be replaced by []
		String mockData = "[{ role: 'PDG', age: 23, first_name: 'Thibaut', last_name: 'esteve' },\n" +
				"        { role: 'CP', age: 22, first_name: 'David', last_name: 'lebrisse' },\n" +
				"        { role: 'BA', age: 22, first_name: 'Nathan', last_name: 'M' },\n" +
				"        { role: 'Dev', age: 22, first_name: 'MArtin', last_name: 'Bruel' },\n" +
				"        { role: 'LT', age: 22, first_name: 'Kevin', last_name: 'Ushaka' }]";

		w(file, String.format("function %s(){\n" +
				"        return  %s\n" +
				"}", functionName, mockData));

		w(file, String.format("module.exports = {\n" +
				"    %s,\n" +
				"}", functionName));

		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			menuItems = pages.stream().map(NamedElement::getName).collect(Collectors.toList());
			for (Page page : app.getPages()){
				page.accept(this);
			}
		}

		context.put("pass", PASS.TWO);
		w(file, "<template>");
		w(file,"\n\t<div id=\"app\">");
		if (pages != null && !pages.isEmpty()) {
			w(file, String.format("\n    <Navbar :logoUrl=\"'https://drive.google" +
							".com/uc?export=view&id=1IXY8IZai07UAj0yamXUTTy-RA8baWN2I'\"\n" +
							"      :NavbarTitle=\"'%s'\"\n" +
							"      :MenuItems=\"%s\"\n" +
							"      :colorNavBar=\"'%s'\"\n" +
							"      @swapComponent=\"loadComponent\"\n" +
							"    />\n", app.getName(),
					menuItems.stream().map(x -> "'" + x + "'").collect(Collectors.toList()), app.getColorNavBar()));
		}
		w(file, "    <div class=\"container\">\n" +
				"      <div :is=\"currentComponent\"></div>\n" +
				"    </div>");

		String menuImports = menuItems.stream().map(x -> "\nimport " + x.replaceAll(" ", "") + " from './views/" + x.replaceAll(" ", "") + ".vue'" ).collect(Collectors.joining());
		w(file, String.format("\n  </div>\n" +
				"</template>\n" +
				"<script>\n" +
				"import Navbar from './components/Navbar.vue'" +
				"%s\n" +
				"export default {\n" +
				"  name: 'App',\n" +
				"  components: {\n" +
				"    Navbar, %s\n" +
				"  },\n",
				menuImports, menuItems.stream().map(x -> x.replaceAll(" ", "")).collect(Collectors.joining(", "))));

		w(file, "  data() {\n" +
				"    return {\n" +
				"      currentComponent: null,\n" +
				"    }\n" +
				"  },\n" +
				"  methods: {\n" +
				"    loadComponent: function(component)\n" +
				"    {\n" +
				"        this.currentComponent = component\n" +
				"    }\n" +
				"  }");
		w(file, "\n}\n\n" +
				"</script>");
		// App Style
		w(file, "\n\n<style>\n" + "#app {\n" + "  font-family: "+app.getFontFamily()+", "+app.getGenericFont()+";\n" + "  -webkit" +
				"-font-smoothing: antialiased;\n" + "  -moz-osx-font-smoothing: grayscale;\n" + "  text-align: center;" +
				"\n" + "  color: #2c3e50;\n" + "}\n" + "html {\n" + "  min-height: 100%;\n" + "  position: relative;" +
				"\n" + "}\n" + "body {\n" + "  height: 100%;\n" + "}\n" + "#nav a {\n" + "  font-weight: bold;\n" + " " +
				" color: #000;\n" + "}\n" + "\n" + "#nav a.router-link-exact-active {\n" + "  color: #fff;\n" + "}\n" + "</style>");

		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void visit(Tableau tableau) {
		FileWriter file = null;
		try {
			file = createFile("components/Tableau.vue");
		} catch (IOException e) {
			e.printStackTrace();
		}

		ToWiringTableau wt = new ToWiringTableau(tableau);
		w(file, wt.generateHTML());

		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void visit(Champ champ) {

	}

	@Override
	public void visit(ClassementPage classementPage) {
		FileWriter file = null;
		try {
			file = createFile("views/"+classementPage.getName().replaceAll(" ", "")+".vue");
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<DataDisplay> dataDisplays = classementPage.getDataDisplays();
		StringBuilder dataDisplaysHtml = new StringBuilder();
		if (dataDisplays != null){
			for (DataDisplay d : dataDisplays){
				dataDisplaysHtml.append(d.getHtmlComponent()).append("\n");
				d.accept(this);
				createExternalRessource(d.getDataSource());
			}
		}
		boolean hasTableau = dataDisplaysHtml.toString().contains("Tableau");


		w(file, String.format("<template>\n" +
				"  <b-container>\n" +
				"    <h3>%s</h3>\n" +
				"    %s" +
				"  </b-container>\n" +
				"</template>", classementPage.getName(), dataDisplaysHtml));

		w(file, String.format("<script>\n" +
				(hasTableau? "import Tableau from '../components/Tableau.vue'\n":"") +
				"export default {\n" +
				"  name: 'Classement',\n" +
				"  components: {\n" +
				(hasTableau? "    Tableau\n":"") +
				"  }\n" +
				"}\n" +
				"</script>", classementPage.getName().replaceAll(" ", "")));


		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
