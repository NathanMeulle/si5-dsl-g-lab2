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
    private ClassementPage classementPage;

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
    @Override public void enterClassement(CompetitionMLParser.ClassementContext ctx) {
        this.classementPage = new ClassementPage(ctx.name.getText().replace("\"",""));
        this.theApp.getPages().add(classementPage);

    }


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitTableau(CompetitionMLParser.TableauContext ctx) {
        Tableau tableau = new Tableau(ctx.name.getText());
        tableau.setChamps(new ArrayList<>());
        tableau.setFiltres(new ArrayList<>());
        tableau.setChamps(new ArrayList<>());
        for(CompetitionMLParser.ColumnContext columnsContext: ctx.tableau_def().columns().column()){
            Champ champ = new Champ(columnsContext.name.getText());
            tableau.getChamps().add(champ);
        }
        for(CompetitionMLParser.FiltresContext filtresContext :ctx.filtres()){
            Filtre filtre = new Filtre();
            FiltreType filtreType = FiltreType.get(filtresContext.type.getText());
            filtre.setFiltreType(filtreType);
            tableau.getFiltres().add(filtre);
        }
        for (CompetitionMLParser.ChampsContext champsContext : ctx.champs()){
            Style style = new Style();
            for(CompetitionMLParser.StyleContext styleContext :champsContext.style()){
                if(styleContext.style_text != null){
                    switch (styleContext.style_text.getText()){
                        case Constants.UNDERLINE:
                            style.setUnderline(true);
                            break;
                        case Constants.BOLD:
                            style.setBold(true);
                            break;

                    }
                }
                if(styleContext.color !=null ){
                    String color = styleContext.color.getText();
                    if(ColorValidator.isHexa(color)){
                        style.setHexaColor(color);
                    }
                }


            }

        }
        this.classementPage.getDataDisplays().add(tableau);
    }


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitClassement(CompetitionMLParser.ClassementContext ctx) { }

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

