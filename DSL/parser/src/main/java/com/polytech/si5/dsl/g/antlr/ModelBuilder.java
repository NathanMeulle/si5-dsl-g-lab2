package com.polytech.si5.dsl.g.antlr;

import com.polytech.si5.dsl.g.antlr.grammar.CompetitionMLBaseListener;
import com.polytech.si5.dsl.g.antlr.grammar.CompetitionMLParser;
import com.polytech.si5.dsl.g.model.App;
import com.polytech.si5.dsl.g.model.DisciplineType;


public class ModelBuilder extends CompetitionMLBaseListener {

    /********************
     ** Business Logic **
     ********************/

    private App theApp = null;
    private boolean built = false;

    public App retrieve() {
        if (built) { return theApp; }
        throw new RuntimeException("Cannot retrieve a model that was not created!");
    }

    /*******************
     ** Symbol tables **
     *******************/

    /**************************
     ** Listening mechanisms **
     **************************/

    @Override
    public void enterRoot(CompetitionMLParser.RootContext ctx) {
        built = false;
        theApp = new App("App");
    }

    @Override
    public void enterDiscipline(CompetitionMLParser.DisciplineContext ctx) {
        String discipline = ctx.name.getText();
        theApp.setName(discipline);
        theApp.setDisciplineType(DisciplineType.get(ctx.type.getText()));
    }

    @Override
    public void exitRoot(CompetitionMLParser.RootContext ctx) {
        this.built = true;
    }
}

