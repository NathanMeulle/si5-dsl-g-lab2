package com.polytech.si5.dsl.kernel.generator;

import com.polytech.si5.dsl.g.model.Champ;
import com.polytech.si5.dsl.g.model.Filtre;
import com.polytech.si5.dsl.g.model.Tableau;

import java.util.List;

public class ToWiringTableau {

    private String name;
    private String dataSource;
    private List<Champ> champs;
    private List<Filtre> filtres;

    public ToWiringTableau(Tableau tableau) {
        this.name = tableau.getName();
        this.dataSource = tableau.getDataSource()==null?"getData":tableau.getDataSource();
        this.champs = tableau.getChamps();
        this.filtres =  tableau.getFiltres();
    }

    public String generateHTML(){
        StringBuilder res = new StringBuilder();


        res.append("<template>\n" +
                "  <div>\n" +
                "    <b-table striped hover :items=\"items\"></b-table>\n" +
                "  </div>\n" +
                "</template>");


        res.append(String.format("<script>\n" +
                "var data = require('../external/getData_%s');\n" +
                "  export default {\n" +
                "  mounted() {\n" +
                "    this.items =  data.%s();\n" +
                "  }," +
                "    data() {\n" +
                "      return {\n" +
                "        items: []\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "</script>",this.dataSource, this.dataSource));


        return res.toString();
    }
}
