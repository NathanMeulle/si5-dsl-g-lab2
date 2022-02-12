package com.polytech.si5.dsl.kernel.generator;

import com.polytech.si5.dsl.g.model.App;
import com.polytech.si5.dsl.g.model.*;
import com.polytech.si5.dsl.g.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        App app = new App("Triathlon");
        List<Page> pages = new ArrayList<>();
        pages.add((new ClassementPage("Page de classement 1")));
        pages.add((new ClassementPage("Page de classement 2")));

        app.setPages(pages);



        Visitor codeGenerator = new ToWiring();
        app.accept(codeGenerator);

        // Printing the generated code on the console
        //System.out.println(codeGenerator.getResult());

    }
}
