package com.polytech.si5.dsl.kernel.generator;

import com.polytech.si5.dsl.g.model.Champ;
import com.polytech.si5.dsl.g.model.Filtre;
import com.polytech.si5.dsl.g.model.Tableau;

import java.util.List;
import java.util.stream.Collectors;

public class ToWiringTableau {

    private String name;
    private String dataSource;
    private List<Champ> champs;
    private List<Filtre> filtres;
    private Integer size;


    public ToWiringTableau(Tableau tableau) {
        this.size = tableau.getSize();
        this.name = tableau.getName().replaceAll( "\"", "");
        this.dataSource = tableau.getDataSource()==null?"getData":tableau.getDataSource();
        this.champs = tableau.getChamps();
        this.filtres =  tableau.getFiltres();
    }

    public String generateHTML(){
        StringBuilder res = new StringBuilder();


        res.append(String.format("<template>\n" +
                "  <div>\n" +
                "    <h4 class=\"text-left\">%s</h4>\n" +
                "    <b-table striped hover :items=\"items\" :fields=\"fields\" :per-page=\"%s\" show-empty>></b-table>\n" +
                "  </div>\n" +
                "</template>", this.name, this.size));



        res.append(String.format("<script>\n" +
                "var data = require('../external/getData_%s');\n" +
                "  export default {\n" +
                "  mounted() {\n" +
                "    this.items =  data.%s();\n" +
                "  }," +
                "    data() {\n" +
                "      return {\n" +
                "        items: [],\n" +
                "        fields: %s,\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "</script>",this.dataSource, this.dataSource, this.champs.stream().map(x -> "'" + x.getName() + "'").collect(Collectors.toList())));


        return res.toString();
    }
}
