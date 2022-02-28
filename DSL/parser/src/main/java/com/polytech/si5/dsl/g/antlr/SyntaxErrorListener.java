package com.polytech.si5.dsl.g.antlr;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.json.JSONObject;
import org.json.JSONArray;

public class SyntaxErrorListener extends BaseErrorListener {

    public JSONArray errors = new JSONArray();
    public int nbError = 0;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {

        JSONObject error = new JSONObject();
        error.put("information", offendingSymbol);
        error.put("message", msg);
        errors.put(error);
        nbError++;
    }

    public void printErrors(){
        System.out.println(errors.toString());
    }
}
