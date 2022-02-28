package com.polytech.si5.dsl.kernel.generator;

import com.polytech.si5.dsl.g.model.*;
import com.polytech.si5.dsl.g.visitor.Visitor;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ToWiring extends Visitor<StringBuffer> {
	enum PASS {ONE, TWO}

	private List<Page> pages;
	private List<String> menuItems;
	private final Path path = Paths.get("../output/src");
	private List<Filtre> filtres;
	private String pageName;
	private List<String> componentsTableau = new ArrayList<>();
	private List<String> dataTableauImport = new ArrayList<>();
	private List<String> dataTableauItems = new ArrayList<>();
	private List<String> dataTableauSelected= new ArrayList<>();
	private List<String> dataTableauOptions= new ArrayList<>();
	private List<String> dataTableauFields= new ArrayList<>();
	private List<String> methodsTableauFilter= new ArrayList<>();
	private List<String> methodsTableauUpdateSelected= new ArrayList<>();


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

	private String generateRandomDataArray(DataDisplay d){
		List<String> lorem = Arrays.asList("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed commodo rutrum posuere. Sed molestie semper nulla quis molestie. Nunc vitae est eros. Etiam at sem ut neque feugiat pharetra. Donec malesuada purus erat, vitae bibendum ante mollis eget. Praesent sit amet velit fringilla, tincidunt mi sit amet, maximus ante.".split(" "));
		String tmp = "{"+((Tableau)d).getChamps().stream().map(x -> "'" + x.getName() + "': '" + lorem.get(new Random().nextInt(lorem.size())).replaceAll("[^a-zA-Z0-9]", " ") +"'").collect(Collectors.joining(", "))+"},";
		return tmp;
	}

	private void createExternalRessource(DataDisplay d){
		String functionName = d.getDataSource();
		boolean isTableau = d.getHtmlComponent().contains("Tableau");
		FileWriter file = null;
		if (functionName == null) functionName = d.getName().replaceAll(" |\"","").toLowerCase();
		try {
			File testFile = new File(path + "/external/getData_" + functionName + "_" + pageName + ".js");
			if (!testFile.exists()) {
				file = new FileWriter(testFile);
			} else {
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// mock Data to display the array, will be replaced by []
		StringBuilder mockData = new StringBuilder("[]");


		if (isTableau){
			mockData = new StringBuilder("[");
			for (int k = 0; k<100; k++) mockData.append(generateRandomDataArray(d));
			mockData.append("]");
		}

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

	public void createExternalRessourceLogo() {
		FileWriter file = null;

		try {
			File testFile = new File(path + "/external/getData_logoUrl.js");
			if (!testFile.exists()) {
				file = new FileWriter(testFile);
			} else {
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		w(file, "function getLogoUrl(){\n" +
				"    return  'https://drive.google.com/uc?export=view&id=1IXY8IZai07UAj0yamXUTTy-RA8baWN2I'\n" +
				"}\n" +
				"module.exports = {\n" +
				"    getLogoUrl,\n" +
				"}");

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
		String logo = "";
		if (app.isHaveLogo()){
			logo = " :logoUrl=\"logoUrl\"\n";
		}

		w(file, "<template>");
		w(file,"\n\t<div id=\"app\">");
		if (pages != null && !pages.isEmpty()) {
			w(file, String.format("\n    <Navbar" + logo +
							"      :NavbarTitle=\"'%s'\"\n" +
							"      :MenuItems=\"%s\"\n" +
							"      :colorNavBar=\"'%s'\"\n" +
							"      @swapComponent=\"loadComponent\"\n" +
							"    />\n",
					app.getName().replaceAll("\"", ""),
					menuItems.stream().map(x -> "'" + x + "'").collect(Collectors.toList()), app.getColorNavBar()));
		}
		w(file, "    <div class=\"container\">\n" +
				"      <div :is=\"currentComponent\"></div>\n" +
				"    </div>");

		String menuImports = menuItems.stream().map(x -> "\nimport " + x.replaceAll(" ", "").toLowerCase() + "_component" + " from './views/" + x.replaceAll(" ", "").toLowerCase() + "_component.vue'" ).collect(Collectors.joining());
		if (app.isHaveLogo()) {
			menuImports+="\nvar logoUrlData = require('./external/getData_logoUrl');\n";
			createExternalRessourceLogo();
		}
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
				menuImports, menuItems.stream().map(x -> x.replaceAll(" ", "").toLowerCase()+"_component").collect(Collectors.joining(", "))));

		w(file,  String.format("  data() {\n" +
				"    return {\n" +
				"      currentComponent: %s,\n" +
				(app.isHaveLogo()?"      logoUrl: String,\n":"") +
				"    }\n" +
				"  },\n" +
				"  methods: {\n" +
				"    loadComponent: function(component)\n" +
				"    {\n" +
				"        this.currentComponent = component.toLowerCase()\n" +
				"    }\n" +
		"  },", menuItems.get(0).replaceAll(" ", "").toLowerCase()+"_component"));

		if (app.isHaveLogo()){
			w(file, String.format("\n  mounted() {\n" +
					"    this.logoUrl =  logoUrlData.getLogoUrl();\n" +
					"  },  "));
		}
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

	private String generateFilterLogic(List<String> filtres, String identifier) {
		StringBuilder res = new StringBuilder("(");
		if (filtres.isEmpty()) res.append(String.format("(this.selected_%1$s.includes(\"\")?row==undefined:false))", identifier));
		else {
			for (String f : filtres){
				res.append(String.format("(this.selected_%1$s.includes(\"%2$s\")?row.%2$s==undefined:false) ||", identifier, f));
			}
			res.append(" false)");
		}

		return res.toString();
	}

	private String generateFields(Tableau tableau){
		StringBuilder res = new StringBuilder(" [\n");
		for (Champ champ : tableau.getChamps()){
			if(!champ.isInDetail()) {
				res.append("        {\n          key:'").append(champ.getName()).append("',\n");
				if (champ.getStyle() != null && champ.getStyle().isBold()) {
					res.append("          class:\"font-weight-bold\"\n");
				}
				if (champ.isSortable()) {
					res.append("          sortable: true\n\n");
				}
				res.append("        },\n");
			}
		}
		res.append("        ],\n");
		return res.toString();
	}


	private List<String> champsInDetails(Tableau tableau){
		List<String> detailsList = new ArrayList<>();
		for(Champ champ : tableau.getChamps()){
			if(champ.isInDetail()){
				detailsList.add("\'"+champ.getName()+"\'");
			}
		}
		return detailsList;
	}

	@Override
	public void visit(Tableau tableau) {
		createExternalRessource(tableau);
		filtres = new ArrayList<>();
		String identifier = tableau.getName().replaceAll(" |\"","") + "_" + pageName;
		for (Filtre f: tableau.getFiltres()){
			this.visit(f);
		}
		boolean activateFilter = this.filtres != null && !this.filtres.isEmpty();

		componentsTableau.add(String.format(
				"    <Tableau\n" +
				"      :title=\"'%5$s'\"\n" +
				"      :perPage=\"%2$d\"\n" +
				"      :items=\"items_data_%1$s\"\n" +
				"      :fields=\"fields_%1$s\"\n" +
				"      :filterTable=\"filterMethod_%1$s\"\n" +
				"      :activateFiltre=\"%3$s\"\n" +
				"      :rowNb=\"%4$d\"\n" +
				"      :options=\"options_%1$s\"\n" +
				"      :checkBoxStyle=\"checkBoxStyle_%1$s\"\n" +
				"      @updateFilterSelected=\"updateSelected_%1$s\"\n" +
				"      :details=\"%6$s\"\n" +
				"      :detailEvent=\"'%7$s'\"\n" +
				"    />\n",
				identifier,
				tableau.getNbItemPerPage(),
				activateFilter,
				tableau.getSize(),
				tableau.getName().replaceAll("\"",""),
				champsInDetails(tableau),
				tableau.getActionDetailsType()
				));

		dataTableauImport.add(String.format("var data_%1$s = require('../external/getData_%1$s');\n",
				identifier));

		dataTableauItems.add(String.format("    this.items_data_%1$s =  data_%1$s.%2$s().slice(0, %3$d);\n",
				identifier,
				tableau.getName().replaceAll(" |\"", ""),
				tableau.getSize()));

		dataTableauSelected.add(String.format(
				"        selected_%1$s: [],\n" +
				"        checkBoxStyle_%1$s: \"%2$s\",\n",
				identifier,
				tableau.getFiltreCheckboxType()==null?"":tableau.getFiltreCheckboxType().name()));

		String optionsFilter = "[],";
		if (activateFilter) {
			optionsFilter = "[" + filtres.stream().map(x -> String.format("\n          { text: '%s', value: '%s' }", x.getChamp().getName(), x.getChamp().getName())).collect(Collectors.joining(", ")) + "],";
		}
		dataTableauOptions.add(String.format("        options_%s: %s\n", identifier, optionsFilter));

		dataTableauFields.add(String.format("        fields_%s:%s", identifier, generateFields(tableau)));

		methodsTableauFilter.add(String.format(
				"       filterMethod_%1$s(row) {\n" +
				"         if %2$s {\n" +
				"          return false;\n" +
				"        } else {\n" +
				"          return true;\n" +
				"        }\n" +
				"       },",
				identifier,
				generateFilterLogic(tableau.getFiltres().stream().map(x->x.getChamp().getName()).collect(Collectors.toList()), identifier)));

		methodsTableauUpdateSelected.add(String.format(
				"     updateSelected_%1$s(value) {\n" +
				"        this.selected_%1$s = value\n" +
				"      },",
				identifier));
	}

	@Override
	public void visit(Champ champ) {

	}

	@Override
	public void visit(ClassementPage classementPage) {
		FileWriter file = null;
		componentsTableau.clear();
		dataTableauImport.clear();
		dataTableauItems.clear();
		dataTableauSelected.clear();
		dataTableauOptions.clear();
		dataTableauFields.clear();
		methodsTableauFilter.clear();
		methodsTableauUpdateSelected.clear();

		pageName = classementPage.getName().replaceAll(" |\"","") ;

		String classmentComponentVue = classementPage.getName().replaceAll(" ", "").toLowerCase()+"_component"+".vue";
		try {
			file = createFile("views/"+classmentComponentVue);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<DataDisplay> dataDisplays = classementPage.getDataDisplays();
		if (dataDisplays != null){
			for (DataDisplay d : dataDisplays){
				d.accept(this);
			}
		}
		w(file, String.format("<template>\n" +
						"  <b-container>\n" +
						"    <h3>%s</h3>\n" +
						"%s\n" +
						"  </b-container>\n" +
						"</template>" + "\n<script>\n" +
						"import Tableau from '../components/Tableau.vue'\n" +
						"%s\n" +
						"export default {\n" +
						"  name: 'Classement',\n" +
						"  components: {\n" +
						"    Tableau\n" +
						"  },\n" +
						"  created: function () {\n" +
						"%s\n" +
						"  },\n" +
						"   data() {\n" +
						"      return {\n" +
						"%s\n" +
						"%s\n" +
						"%s\n" +
						"      }\n" +
						"     },\n" +
						"     methods: {\n" +
						"%s\n" +
						"%s\n" +
						"     }\n" +
						"}\n" +
						"</script>"
				,classementPage.getName(),
				String.join("", componentsTableau),
				String.join("", dataTableauImport),
				String.join("", dataTableauItems),
				String.join("", dataTableauSelected),
				String.join("", dataTableauOptions),
				String.join("", dataTableauFields),
				String.join("", methodsTableauFilter),
				String.join("", methodsTableauUpdateSelected)
				));
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
		this.filtres.add(filtre);
	}

	@Override
	public void visit(Style style) {

	}
}
