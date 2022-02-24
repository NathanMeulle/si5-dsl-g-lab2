package com.polytech.si5.dsl.kernel.generator;

import com.polytech.si5.dsl.g.model.Champ;
import com.polytech.si5.dsl.g.model.Filtre;
import com.polytech.si5.dsl.g.model.FiltreCheckboxType;
import com.polytech.si5.dsl.g.model.Tableau;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToWiringTableau {

    private String name;
    private String dataSource;
    private List<Champ> champs;
    private List<Filtre> filtres;
    private FiltreCheckboxType filtreCheckboxType;
    private Integer size;
    private Integer nbItemPerPage;


    public ToWiringTableau(Tableau tableau) {
        this.size = tableau.getSize();
        this.name = tableau.getName().replaceAll( "\"", "");
        this.dataSource = tableau.getDataSource()==null?tableau.getName():tableau.getDataSource();
        this.champs = tableau.getChamps();
        this.filtres =  tableau.getFiltres();
        this.nbItemPerPage = tableau.getNbItemPerPage();
        this.filtreCheckboxType = tableau.getFiltreCheckboxType();
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
        String checkBoxStyle = this.filtreCheckboxType==null?"CHECKBOX":this.filtreCheckboxType.toString();
        res.append(String.format("<template>\n" +
                "  <div>\n" +
                "    <h4 class=\"text-left\">%s</h4>\n" +
                "    <Filtre v-if=\"activateFiltre\" \n" +
                        "      :checkBoxStyle=\"'%s'\"" +
                        "      :options=\"options\"\n" +
                        "      @updateFilterSelected=\"updateSelected\"\n" +
                        "    />\n" +
                "    <b-table striped hover id=\"classementTable\" \n" +
                        "      :items=\"items\" \n" +
                        "      :fields=\"fields\" \n" +
                        "      :per-page=\"perPage\"  \n" +
                        "      :current-page=\"currentPage\" \n" +
                        "      :filter=\"filter\" \n" +
                        "      :filter-function=\"filterTable\"\n" +
                        "      show-empty\n" +
                        "    >\n    </b-table>" +
                        getPagination() +
                "  </div>\n" +
                "</template>", this.name, checkBoxStyle));

        String optionsFilter = "[]";
        boolean activateFilter = this.filtres != null && !this.filtres.isEmpty();
        if (activateFilter) {
            optionsFilter = "[" + filtres.stream().map(x -> String.format("\n          { text: '%s', value: '%s' }", x.getChamp().getName(), x.getChamp().getName())).collect(Collectors.joining(", ")) + "]";
        }
        String tmp = this.dataSource.replaceAll("\"","");
        res.append(String.format("\n<script>\n" +
                "import Filtre  from \"./Filtre\"\n" +
                "var data_%s = require('../external/getData_%s');\n" +
                "  export default {\n" +
                "  components: {\n" +
                "    Filtre,\n" +
                "  }," +
                "  mounted() {\n" +
                "    this.items =  data_%s.%s().slice(0, %s);\n" +
                "  },\n" +
                "    data() {\n" +
                "      return {\n" +
                "        perPage: \"%s\",\n"+
                "        currentPage: 1,\n"+
                "        items: [],\n" +
                "        fields: [\n%s        ],\n" +
                "        filter: \"_\",\n" +
                "        activateFiltre:%s,\n" +
                "        selected: [],\n" +
                "        options: %s,\n" +
                "      }\n" +
                "     },\n" +
                ""
                ,tmp, tmp, tmp, tmp, this.size, this.nbItemPerPage,generateFields(), activateFilter, optionsFilter ));

        res.append(String.format(
                "     computed: {\n"+
                "       rows() {\n"+
                "           return %s\n"+
                "       }\n"+
                ""+
                "    },\n" +
                "     methods: {\n" +
                "      filterTable(row) {\n" +
                "        if (%s) {\n" +
                "          return false;\n" +
                "        } else {\n" +
                "          return true;\n" +
                "        }\n" +
                "      },\n" +
                "      updateSelected(value) {\n" +
                "        this.selected = value\n" +
                "      }\n" +
                "    }," +
                "  }\n" +
                "</script>", this.size, generateFilterLogic(filtres.stream().map(x->x.getChamp().getName()).collect(Collectors.toList()))));


        return res.toString();
    }

    private String generateFilterLogic(List<String> filtres) {
        StringBuilder res = new StringBuilder("(");
        if (filtres.isEmpty()) res.append("(this.selected.includes(\"\")?row==undefined:false))");
        else {
            for (String f : filtres){
                res.append(String.format("(this.selected.includes(\"%s\")?row.%s==undefined:false) ||", f, f));
            }
            res.append(" false)");
        }

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
