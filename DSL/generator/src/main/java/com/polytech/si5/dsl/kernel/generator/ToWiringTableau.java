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
    private Integer nbItemPerPage;


    public ToWiringTableau(Tableau tableau) {
        this.size = tableau.getSize();
        this.name = tableau.getName().replaceAll( "\"", "");
        this.dataSource = tableau.getDataSource()==null?tableau.getName():tableau.getDataSource();
        this.champs = tableau.getChamps();
        this.filtres =  tableau.getFiltres();
        this.nbItemPerPage = tableau.getNbItemPerPage();
    }

    public String getPagination(){
        String pagination = String.format("    <b-pagination\n"+
                "      v-model=\"currentPage\"\n" +
                "      :total-rows=\"rows\"\n" +
                "      :per-page=\"perPage\"\n"+
                "      aria-controls=\"classementTable\"\n" +
                "    ></b-pagination>\n");

        if (nbItemPerPage==0) {
            nbItemPerPage = size;
            return "";
        }
        return pagination;
    }

    public String generateHTML(){
        StringBuilder res = new StringBuilder();

        res.append(String.format("<template>\n" +
                "  <div>\n" +
                "    <h4 class=\"text-left\">%s</h4>\n" +
                "    <b-table striped hover id=\"classementTable\" :items=\"items\" :fields=\"fields\" :per-page=\"perPage\"  :current-page=\"currentPage\" show-empty></b-table>\n" +
                        getPagination() +
                "  </div>\n" +
                "</template>", this.name));


        res.append(String.format("<script>\n" +
                "var data = require('../external/getData_%s');\n" +
                "  export default {\n" +
                "  mounted() {\n" +
                "    this.items =  data.%s().slice(0, %s);\n" +
                "  },\n" +
                "    data() {\n" +
                "      return {\n" +
                "        perPage: \"%s\",\n"+
                "        currentPage: 1,\n"+
                "        items: [],\n" +
                "        fields: [\n%s        ],\n" +
                "      }\n" +
                ""+
                "     },\n"+
                "     computed: {\n"+
                "       rows() {\n"+
                "           return %s\n"+
                "       }\n"+
                ""+
                "    }\n" +
                "  }\n" +
                "</script>",this.dataSource.replaceAll("\"",""), this.dataSource.replaceAll("\"",""), this.size, this.nbItemPerPage, generateFields(), this.size));


        return res.toString();
    }

    private String generateFields(){
        StringBuilder res = new StringBuilder();
        for (Champ champ : this.champs){
            res.append("        {\n          key:'").append(champ.getName()).append("'\n");
            if (champ.getStyle() != null && champ.getStyle().isBold()){
                res.append("          class:\"font-weight-bold\"\n");
            }
            res.append("        },\n");
        }
        return res.toString();
    }
}
