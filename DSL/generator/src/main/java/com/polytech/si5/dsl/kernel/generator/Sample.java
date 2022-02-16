package com.polytech.si5.dsl.kernel.generator;

import com.polytech.si5.dsl.g.model.App;
import com.polytech.si5.dsl.g.model.*;
import com.polytech.si5.dsl.g.visitor.Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        App app = new App("Triathlon");
        app.setColorNavBar("#aa3333");
        List<Page> pages = new ArrayList<>();

        ClassementPage cp1 = new ClassementPage("Page de classement 1");
        ClassementPage cp2 = new ClassementPage("Page de classement 2");
        pages.add(cp1);
        pages.add(cp2);

        Tableau t = new Tableau("Mon tableau");
        t.setDataSource("getDataTableau1");
        t.setSize(10);
        List<Champ> champs = new ArrayList<>();
        champs.add(new Champ("Nom"));
        champs.add(new Champ("Prenom"));
        champs.add(new Champ("Age"));
        champs.add(new Champ("Age", false, true));
        champs.add(new Champ("Role", true, true));
        t.setChamps(champs);

        List<DataDisplay> datas = new ArrayList<>();
        datas.add(t);
        cp1.setDataDisplays(datas);

        app.setPages(pages);


        Visitor codeGenerator = new ToWiring();
        app.accept(codeGenerator);

        // Printing the generated code on the console
        //System.out.println(codeGenerator.getResult());

    }
}
