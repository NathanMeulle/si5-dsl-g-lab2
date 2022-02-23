package com.polytech.si5.dsl.g.antlr;

import com.polytech.si5.dsl.g.antlr.grammar.CompetitionMLBaseListener;
import com.polytech.si5.dsl.g.antlr.grammar.CompetitionMLParser;
import com.polytech.si5.dsl.g.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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

    private Map<CompetitionMLParser.ColumnContext,Champ> fields   = new HashMap<>();
    private Map<CompetitionMLParser.StylesContext, Style> styles = new HashMap<>();

    /**************************
     ** Listening mechanisms **
     **************************/

    @Override
    public void enterRoot(CompetitionMLParser.RootContext ctx) {
        built = false;
    }

    @Override
    public void enterApp(CompetitionMLParser.AppContext ctx) {
        theApp = new App("App");
        if(ctx.color !=null ){
            String color = ctx.color.getText();
            if(ColorValidator.isHexa(color)){
                theApp.setColorNavBar(color);
            }
        }
        if(ctx.logo!=null){
            theApp.setHaveLogo(true);
        }
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


    @Override
    public void enterStyles(CompetitionMLParser.StylesContext ctx) {
        Style style = new Style();
        for (CompetitionMLParser.StyleContext styleContext : ctx.style()) {
            if (styleContext.style_text != null) {
                switch (styleContext.style_text.getText()) {
                    case Constants.UNDERLINE:
                        style.setUnderline(true);
                        break;
                    case Constants.BOLD:
                        style.setBold(true);
                        break;
                    case Constants.HIDDEN:
                        style.setHidden(true);
                        break;
                }
            }

            if(styleContext.color != null ){
                String color = styleContext.color.getText();
                if(ColorValidator.isHexa(color)){
                    style.setHexaColor(color);
                }
            }
        }

        styles.put(ctx,style);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterColumn(CompetitionMLParser.ColumnContext ctx) {
        Champ champ = new Champ(ctx.name.getText());
        fields.put(ctx,champ);
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
        tableau.setSize(Integer.parseInt(ctx.max.getText()));
        tableau.setChamps(new ArrayList<>());
        tableau.setFiltres(new ArrayList<>());
        tableau.setChamps(new ArrayList<>());
        for(CompetitionMLParser.ColumnContext columnsContext: ctx.tableau_def().columns().column()){
            Champ champ = fields.get(columnsContext);
            tableau.getChamps().add(champ);
        }
        for(CompetitionMLParser.FiltresContext filtresContext :ctx.filtres()){
            Filtre filtre = new Filtre();
            FiltreType filtreType = FiltreType.get(filtresContext.type.getText());
            filtre.setFiltreType(filtreType);
            tableau.getFiltres().add(filtre);
        }
        for (CompetitionMLParser.ChampsContext champsContext : ctx.champs()){
            Style style = styles.get(champsContext.styles());
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

