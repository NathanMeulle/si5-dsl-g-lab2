package com.polytech.si5.dsl.g.antlr;

import com.polytech.si5.dsl.g.antlr.grammar.CompetitionMLBaseListener;
import com.polytech.si5.dsl.g.antlr.grammar.CompetitionMLParser;
import com.polytech.si5.dsl.g.model.*;

import java.util.ArrayList;


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

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPadding(CompetitionMLParser.PaddingContext ctx) {
        int value = Integer.parseInt(ctx.value.getText());
        Disposition disposition = new Disposition();
        disposition.setPadding(value);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterTableau(CompetitionMLParser.TableauContext ctx) { }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterColumns(CompetitionMLParser.ColumnsContext ctx) {
    }


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitTableau(CompetitionMLParser.TableauContext ctx) {
        Tableau tableau = new Tableau(ctx.name.getText());
        tableau.setChamps(new ArrayList<>());
        for(CompetitionMLParser.ColumnContext columnsContext: ctx.tableau_def().columns().column()){
            Champ champ = new Champ(columnsContext.name.getText());
            tableau.getChamps().add(champ);
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPadding(CompetitionMLParser.PaddingContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitColumns(CompetitionMLParser.ColumnsContext ctx) { }

    @Override
    public void exitRoot(CompetitionMLParser.RootContext ctx) {
        this.built = true;
    }


}

