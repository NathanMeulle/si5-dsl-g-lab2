package com.polytech.si5.dsl.g.antlr;

import org.antlr.v4.runtime.ParserRuleContext;

public class SemanticError extends RuntimeException {
    public SemanticError(ParserRuleContext ctx, String msg) {
        super(String.format("Semantic error at %s: %s",ctx.toStringTree(),msg));
    }
}
