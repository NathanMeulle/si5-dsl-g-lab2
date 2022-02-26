// Generated from CompetitionML.g4 by ANTLR 4.7
// jshint ignore: start
var antlr4 = require('antlr4/index');
var CompetitionMLListener = require('./CompetitionMLListener').CompetitionMLListener;
var grammarFileName = "CompetitionML.g4";

var serializedATN = ["\u0003\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964",
    "\u0003\u001ap\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t",
    "\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007\u0004",
    "\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004\f\t\f\u0004",
    "\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0003\u0002\u0003\u0002",
    "\u0003\u0002\u0003\u0002\u0003\u0002\u0003\u0003\u0003\u0003\u0003\u0003",
    "\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0005\u0003\u0005",
    "\u0003\u0005\u0003\u0005\u0003\u0006\u0003\u0006\u0005\u00061\n\u0006",
    "\u0003\u0006\u0003\u0006\u0005\u00065\n\u0006\u0003\u0007\u0003\u0007",
    "\u0003\u0007\u0003\b\u0003\b\u0003\b\u0003\b\u0003\t\u0003\t\u0003\t",
    "\u0003\t\u0003\t\u0003\t\u0007\tD\n\t\f\t\u000e\tG\u000b\t\u0003\t\u0007",
    "\tJ\n\t\f\t\u000e\tM\u000b\t\u0003\n\u0003\n\u0003\n\u0003\n\u0003\u000b",
    "\u0003\u000b\u0003\u000b\u0007\u000bV\n\u000b\f\u000b\u000e\u000bY\u000b",
    "\u000b\u0003\f\u0003\f\u0003\r\u0003\r\u0003\r\u0003\r\u0003\u000e\u0003",
    "\u000e\u0003\u000e\u0003\u000e\u0003\u000e\u0003\u000e\u0007\u000eg",
    "\n\u000e\f\u000e\u000e\u000ej\u000b\u000e\u0003\u000f\u0003\u000f\u0005",
    "\u000fn\n\u000f\u0003\u000f\u0002\u0002\u0010\u0002\u0004\u0006\b\n",
    "\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0002\u0002\u0002",
    "h\u0002\u001e\u0003\u0002\u0002\u0002\u0004#\u0003\u0002\u0002\u0002",
    "\u0006&\u0003\u0002\u0002\u0002\b*\u0003\u0002\u0002\u0002\n0\u0003",
    "\u0002\u0002\u0002\f6\u0003\u0002\u0002\u0002\u000e9\u0003\u0002\u0002",
    "\u0002\u0010=\u0003\u0002\u0002\u0002\u0012N\u0003\u0002\u0002\u0002",
    "\u0014R\u0003\u0002\u0002\u0002\u0016Z\u0003\u0002\u0002\u0002\u0018",
    "\\\u0003\u0002\u0002\u0002\u001a`\u0003\u0002\u0002\u0002\u001cm\u0003",
    "\u0002\u0002\u0002\u001e\u001f\u0005\u0004\u0003\u0002\u001f \u0005",
    "\u0006\u0004\u0002 !\u0005\b\u0005\u0002!\"\u0007\u0002\u0002\u0003",
    "\"\u0003\u0003\u0002\u0002\u0002#$\u0007\u0003\u0002\u0002$%\u0007\u0014",
    "\u0002\u0002%\u0005\u0003\u0002\u0002\u0002&\'\u0007\u0004\u0002\u0002",
    "\'(\u0007\u0011\u0002\u0002()\u0007\u0012\u0002\u0002)\u0007\u0003\u0002",
    "\u0002\u0002*+\u0007\u0005\u0002\u0002+,\u0007\u0011\u0002\u0002,-\u0005",
    "\n\u0006\u0002-\t\u0003\u0002\u0002\u0002.1\u0005\f\u0007\u0002/1\u0005",
    "\u0010\t\u00020.\u0003\u0002\u0002\u00020/\u0003\u0002\u0002\u00021",
    "4\u0003\u0002\u0002\u000225\u0005\f\u0007\u000235\u0005\u0010\t\u0002",
    "42\u0003\u0002\u0002\u000243\u0003\u0002\u0002\u00025\u000b\u0003\u0002",
    "\u0002\u000267\u0007\u0006\u0002\u000278\u0005\u000e\b\u00028\r\u0003",
    "\u0002\u0002\u00029:\u0007\u0007\u0002\u0002:;\u0007\u0015\u0002\u0002",
    ";<\u0007\b\u0002\u0002<\u000f\u0003\u0002\u0002\u0002=>\u0007\t\u0002",
    "\u0002>?\u0007\u0011\u0002\u0002?@\u0007\n\u0002\u0002@A\u0007\u0015",
    "\u0002\u0002AE\u0005\u0012\n\u0002BD\u0005\u0018\r\u0002CB\u0003\u0002",
    "\u0002\u0002DG\u0003\u0002\u0002\u0002EC\u0003\u0002\u0002\u0002EF\u0003",
    "\u0002\u0002\u0002FK\u0003\u0002\u0002\u0002GE\u0003\u0002\u0002\u0002",
    "HJ\u0005\u001a\u000e\u0002IH\u0003\u0002\u0002\u0002JM\u0003\u0002\u0002",
    "\u0002KI\u0003\u0002\u0002\u0002KL\u0003\u0002\u0002\u0002L\u0011\u0003",
    "\u0002\u0002\u0002MK\u0003\u0002\u0002\u0002NO\u0007\u000b\u0002\u0002",
    "OP\u0005\u0014\u000b\u0002PQ\u0007\f\u0002\u0002Q\u0013\u0003\u0002",
    "\u0002\u0002RW\u0005\u0016\f\u0002ST\u0007\r\u0002\u0002TV\u0005\u0016",
    "\f\u0002US\u0003\u0002\u0002\u0002VY\u0003\u0002\u0002\u0002WU\u0003",
    "\u0002\u0002\u0002WX\u0003\u0002\u0002\u0002X\u0015\u0003\u0002\u0002",
    "\u0002YW\u0003\u0002\u0002\u0002Z[\u0007\u0016\u0002\u0002[\u0017\u0003",
    "\u0002\u0002\u0002\\]\u0007\u000e\u0002\u0002]^\u0005\u0014\u000b\u0002",
    "^_\u0007\u0016\u0002\u0002_\u0019\u0003\u0002\u0002\u0002`a\u0007\u000f",
    "\u0002\u0002ab\u0005\u0014\u000b\u0002bc\u0007\u0010\u0002\u0002ch\u0005",
    "\u001c\u000f\u0002de\u0007\u0017\u0002\u0002eg\u0005\u001c\u000f\u0002",
    "fd\u0003\u0002\u0002\u0002gj\u0003\u0002\u0002\u0002hf\u0003\u0002\u0002",
    "\u0002hi\u0003\u0002\u0002\u0002i\u001b\u0003\u0002\u0002\u0002jh\u0003",
    "\u0002\u0002\u0002kn\u0007\u0013\u0002\u0002ln\u0007\u0014\u0002\u0002",
    "mk\u0003\u0002\u0002\u0002ml\u0003\u0002\u0002\u0002n\u001d\u0003\u0002",
    "\u0002\u0002\t04EKWhm"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

var sharedContextCache = new antlr4.PredictionContextCache();

var literalNames = [ null, "'app'", "'discipline'", "'classement'", "'disposition'", 
                     "'padding'", "'px'", "'tableau'", "'top'", "'['", "']'", 
                     "'|'", "'filtres'", "'champs'", "'en'", null, null, 
                     null, null, null, null, "','" ];

var symbolicNames = [ null, null, null, null, null, null, null, null, null, 
                      null, null, null, null, null, null, "IDENTIFIER", 
                      "DISCIPLINE", "STYLE_TEXT", "COLOR_HEXA", "INTEGER", 
                      "WORD", "COMA", "NEWLINE", "WS", "COMMENT" ];

var ruleNames =  [ "root", "app", "discipline", "classement", "declaration", 
                   "disposition", "padding", "tableau", "tableau_def", "columns", 
                   "column", "filtres", "champs", "style" ];

function CompetitionMLParser (input) {
	antlr4.Parser.call(this, input);
    this._interp = new antlr4.atn.ParserATNSimulator(this, atn, decisionsToDFA, sharedContextCache);
    this.ruleNames = ruleNames;
    this.literalNames = literalNames;
    this.symbolicNames = symbolicNames;
    return this;
}

CompetitionMLParser.prototype = Object.create(antlr4.Parser.prototype);
CompetitionMLParser.prototype.constructor = CompetitionMLParser;

Object.defineProperty(CompetitionMLParser.prototype, "atn", {
	get : function() {
		return atn;
	}
});

CompetitionMLParser.EOF = antlr4.Token.EOF;
CompetitionMLParser.T__0 = 1;
CompetitionMLParser.T__1 = 2;
CompetitionMLParser.T__2 = 3;
CompetitionMLParser.T__3 = 4;
CompetitionMLParser.T__4 = 5;
CompetitionMLParser.T__5 = 6;
CompetitionMLParser.T__6 = 7;
CompetitionMLParser.T__7 = 8;
CompetitionMLParser.T__8 = 9;
CompetitionMLParser.T__9 = 10;
CompetitionMLParser.T__10 = 11;
CompetitionMLParser.T__11 = 12;
CompetitionMLParser.T__12 = 13;
CompetitionMLParser.T__13 = 14;
CompetitionMLParser.IDENTIFIER = 15;
CompetitionMLParser.DISCIPLINE = 16;
CompetitionMLParser.STYLE_TEXT = 17;
CompetitionMLParser.COLOR_HEXA = 18;
CompetitionMLParser.INTEGER = 19;
CompetitionMLParser.WORD = 20;
CompetitionMLParser.COMA = 21;
CompetitionMLParser.NEWLINE = 22;
CompetitionMLParser.WS = 23;
CompetitionMLParser.COMMENT = 24;

CompetitionMLParser.RULE_root = 0;
CompetitionMLParser.RULE_app = 1;
CompetitionMLParser.RULE_discipline = 2;
CompetitionMLParser.RULE_classement = 3;
CompetitionMLParser.RULE_declaration = 4;
CompetitionMLParser.RULE_disposition = 5;
CompetitionMLParser.RULE_padding = 6;
CompetitionMLParser.RULE_tableau = 7;
CompetitionMLParser.RULE_tableau_def = 8;
CompetitionMLParser.RULE_columns = 9;
CompetitionMLParser.RULE_column = 10;
CompetitionMLParser.RULE_filtres = 11;
CompetitionMLParser.RULE_champs = 12;
CompetitionMLParser.RULE_style = 13;

function RootContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_root;
    return this;
}

RootContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
RootContext.prototype.constructor = RootContext;

RootContext.prototype.app = function() {
    return this.getTypedRuleContext(AppContext,0);
};

RootContext.prototype.discipline = function() {
    return this.getTypedRuleContext(DisciplineContext,0);
};

RootContext.prototype.classement = function() {
    return this.getTypedRuleContext(ClassementContext,0);
};

RootContext.prototype.EOF = function() {
    return this.getToken(CompetitionMLParser.EOF, 0);
};

RootContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterRoot(this);
	}
};

RootContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitRoot(this);
	}
};




CompetitionMLParser.RootContext = RootContext;

CompetitionMLParser.prototype.root = function() {

    var localctx = new RootContext(this, this._ctx, this.state);
    this.enterRule(localctx, 0, CompetitionMLParser.RULE_root);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 28;
        this.app();
        this.state = 29;
        this.discipline();
        this.state = 30;
        this.classement();
        this.state = 31;
        this.match(CompetitionMLParser.EOF);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function AppContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_app;
    this.color = null; // Token
    return this;
}

AppContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
AppContext.prototype.constructor = AppContext;

AppContext.prototype.COLOR_HEXA = function() {
    return this.getToken(CompetitionMLParser.COLOR_HEXA, 0);
};

AppContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterApp(this);
	}
};

AppContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitApp(this);
	}
};




CompetitionMLParser.AppContext = AppContext;

CompetitionMLParser.prototype.app = function() {

    var localctx = new AppContext(this, this._ctx, this.state);
    this.enterRule(localctx, 2, CompetitionMLParser.RULE_app);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 33;
        this.match(CompetitionMLParser.T__0);
        this.state = 34;
        localctx.color = this.match(CompetitionMLParser.COLOR_HEXA);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function DisciplineContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_discipline;
    this.name = null; // Token
    this.type = null; // Token
    return this;
}

DisciplineContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
DisciplineContext.prototype.constructor = DisciplineContext;

DisciplineContext.prototype.IDENTIFIER = function() {
    return this.getToken(CompetitionMLParser.IDENTIFIER, 0);
};

DisciplineContext.prototype.DISCIPLINE = function() {
    return this.getToken(CompetitionMLParser.DISCIPLINE, 0);
};

DisciplineContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterDiscipline(this);
	}
};

DisciplineContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitDiscipline(this);
	}
};




CompetitionMLParser.DisciplineContext = DisciplineContext;

CompetitionMLParser.prototype.discipline = function() {

    var localctx = new DisciplineContext(this, this._ctx, this.state);
    this.enterRule(localctx, 4, CompetitionMLParser.RULE_discipline);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 36;
        this.match(CompetitionMLParser.T__1);
        this.state = 37;
        localctx.name = this.match(CompetitionMLParser.IDENTIFIER);
        this.state = 38;
        localctx.type = this.match(CompetitionMLParser.DISCIPLINE);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function ClassementContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_classement;
    this.name = null; // Token
    return this;
}

ClassementContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ClassementContext.prototype.constructor = ClassementContext;

ClassementContext.prototype.declaration = function() {
    return this.getTypedRuleContext(DeclarationContext,0);
};

ClassementContext.prototype.IDENTIFIER = function() {
    return this.getToken(CompetitionMLParser.IDENTIFIER, 0);
};

ClassementContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterClassement(this);
	}
};

ClassementContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitClassement(this);
	}
};




CompetitionMLParser.ClassementContext = ClassementContext;

CompetitionMLParser.prototype.classement = function() {

    var localctx = new ClassementContext(this, this._ctx, this.state);
    this.enterRule(localctx, 6, CompetitionMLParser.RULE_classement);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 40;
        this.match(CompetitionMLParser.T__2);
        this.state = 41;
        localctx.name = this.match(CompetitionMLParser.IDENTIFIER);
        this.state = 42;
        this.declaration();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function DeclarationContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_declaration;
    return this;
}

DeclarationContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
DeclarationContext.prototype.constructor = DeclarationContext;

DeclarationContext.prototype.disposition = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(DispositionContext);
    } else {
        return this.getTypedRuleContext(DispositionContext,i);
    }
};

DeclarationContext.prototype.tableau = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(TableauContext);
    } else {
        return this.getTypedRuleContext(TableauContext,i);
    }
};

DeclarationContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterDeclaration(this);
	}
};

DeclarationContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitDeclaration(this);
	}
};




CompetitionMLParser.DeclarationContext = DeclarationContext;

CompetitionMLParser.prototype.declaration = function() {

    var localctx = new DeclarationContext(this, this._ctx, this.state);
    this.enterRule(localctx, 8, CompetitionMLParser.RULE_declaration);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 46;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case CompetitionMLParser.T__3:
            this.state = 44;
            this.disposition();
            break;
        case CompetitionMLParser.T__6:
            this.state = 45;
            this.tableau();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
        this.state = 50;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case CompetitionMLParser.T__3:
            this.state = 48;
            this.disposition();
            break;
        case CompetitionMLParser.T__6:
            this.state = 49;
            this.tableau();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function DispositionContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_disposition;
    return this;
}

DispositionContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
DispositionContext.prototype.constructor = DispositionContext;

DispositionContext.prototype.padding = function() {
    return this.getTypedRuleContext(PaddingContext,0);
};

DispositionContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterDisposition(this);
	}
};

DispositionContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitDisposition(this);
	}
};




CompetitionMLParser.DispositionContext = DispositionContext;

CompetitionMLParser.prototype.disposition = function() {

    var localctx = new DispositionContext(this, this._ctx, this.state);
    this.enterRule(localctx, 10, CompetitionMLParser.RULE_disposition);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 52;
        this.match(CompetitionMLParser.T__3);
        this.state = 53;
        this.padding();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function PaddingContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_padding;
    this.value = null; // Token
    return this;
}

PaddingContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
PaddingContext.prototype.constructor = PaddingContext;

PaddingContext.prototype.INTEGER = function() {
    return this.getToken(CompetitionMLParser.INTEGER, 0);
};

PaddingContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterPadding(this);
	}
};

PaddingContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitPadding(this);
	}
};




CompetitionMLParser.PaddingContext = PaddingContext;

CompetitionMLParser.prototype.padding = function() {

    var localctx = new PaddingContext(this, this._ctx, this.state);
    this.enterRule(localctx, 12, CompetitionMLParser.RULE_padding);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 55;
        this.match(CompetitionMLParser.T__4);
        this.state = 56;
        localctx.value = this.match(CompetitionMLParser.INTEGER);
        this.state = 57;
        this.match(CompetitionMLParser.T__5);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function TableauContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_tableau;
    this.name = null; // Token
    this.max = null; // Token
    return this;
}

TableauContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
TableauContext.prototype.constructor = TableauContext;

TableauContext.prototype.tableau_def = function() {
    return this.getTypedRuleContext(Tableau_defContext,0);
};

TableauContext.prototype.IDENTIFIER = function() {
    return this.getToken(CompetitionMLParser.IDENTIFIER, 0);
};

TableauContext.prototype.INTEGER = function() {
    return this.getToken(CompetitionMLParser.INTEGER, 0);
};

TableauContext.prototype.filtres = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(FiltresContext);
    } else {
        return this.getTypedRuleContext(FiltresContext,i);
    }
};

TableauContext.prototype.champs = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ChampsContext);
    } else {
        return this.getTypedRuleContext(ChampsContext,i);
    }
};

TableauContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterTableau(this);
	}
};

TableauContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitTableau(this);
	}
};




CompetitionMLParser.TableauContext = TableauContext;

CompetitionMLParser.prototype.tableau = function() {

    var localctx = new TableauContext(this, this._ctx, this.state);
    this.enterRule(localctx, 14, CompetitionMLParser.RULE_tableau);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 59;
        this.match(CompetitionMLParser.T__6);
        this.state = 60;
        localctx.name = this.match(CompetitionMLParser.IDENTIFIER);
        this.state = 61;
        this.match(CompetitionMLParser.T__7);
        this.state = 62;
        localctx.max = this.match(CompetitionMLParser.INTEGER);
        this.state = 63;
        this.tableau_def();
        this.state = 67;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===CompetitionMLParser.T__11) {
            this.state = 64;
            this.filtres();
            this.state = 69;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 73;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===CompetitionMLParser.T__12) {
            this.state = 70;
            this.champs();
            this.state = 75;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function Tableau_defContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_tableau_def;
    return this;
}

Tableau_defContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
Tableau_defContext.prototype.constructor = Tableau_defContext;

Tableau_defContext.prototype.columns = function() {
    return this.getTypedRuleContext(ColumnsContext,0);
};

Tableau_defContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterTableau_def(this);
	}
};

Tableau_defContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitTableau_def(this);
	}
};




CompetitionMLParser.Tableau_defContext = Tableau_defContext;

CompetitionMLParser.prototype.tableau_def = function() {

    var localctx = new Tableau_defContext(this, this._ctx, this.state);
    this.enterRule(localctx, 16, CompetitionMLParser.RULE_tableau_def);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 76;
        this.match(CompetitionMLParser.T__8);
        this.state = 77;
        this.columns();
        this.state = 78;
        this.match(CompetitionMLParser.T__9);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function ColumnsContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_columns;
    return this;
}

ColumnsContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ColumnsContext.prototype.constructor = ColumnsContext;

ColumnsContext.prototype.column = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ColumnContext);
    } else {
        return this.getTypedRuleContext(ColumnContext,i);
    }
};

ColumnsContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterColumns(this);
	}
};

ColumnsContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitColumns(this);
	}
};




CompetitionMLParser.ColumnsContext = ColumnsContext;

CompetitionMLParser.prototype.columns = function() {

    var localctx = new ColumnsContext(this, this._ctx, this.state);
    this.enterRule(localctx, 18, CompetitionMLParser.RULE_columns);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 80;
        this.column();
        this.state = 85;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===CompetitionMLParser.T__10) {
            this.state = 81;
            this.match(CompetitionMLParser.T__10);
            this.state = 82;
            this.column();
            this.state = 87;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function ColumnContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_column;
    this.name = null; // Token
    return this;
}

ColumnContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ColumnContext.prototype.constructor = ColumnContext;

ColumnContext.prototype.WORD = function() {
    return this.getToken(CompetitionMLParser.WORD, 0);
};

ColumnContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterColumn(this);
	}
};

ColumnContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitColumn(this);
	}
};




CompetitionMLParser.ColumnContext = ColumnContext;

CompetitionMLParser.prototype.column = function() {

    var localctx = new ColumnContext(this, this._ctx, this.state);
    this.enterRule(localctx, 20, CompetitionMLParser.RULE_column);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 88;
        localctx.name = this.match(CompetitionMLParser.WORD);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function FiltresContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_filtres;
    this.type = null; // Token
    return this;
}

FiltresContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
FiltresContext.prototype.constructor = FiltresContext;

FiltresContext.prototype.columns = function() {
    return this.getTypedRuleContext(ColumnsContext,0);
};

FiltresContext.prototype.WORD = function() {
    return this.getToken(CompetitionMLParser.WORD, 0);
};

FiltresContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterFiltres(this);
	}
};

FiltresContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitFiltres(this);
	}
};




CompetitionMLParser.FiltresContext = FiltresContext;

CompetitionMLParser.prototype.filtres = function() {

    var localctx = new FiltresContext(this, this._ctx, this.state);
    this.enterRule(localctx, 22, CompetitionMLParser.RULE_filtres);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 90;
        this.match(CompetitionMLParser.T__11);
        this.state = 91;
        this.columns();
        this.state = 92;
        localctx.type = this.match(CompetitionMLParser.WORD);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function ChampsContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_champs;
    return this;
}

ChampsContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ChampsContext.prototype.constructor = ChampsContext;

ChampsContext.prototype.columns = function() {
    return this.getTypedRuleContext(ColumnsContext,0);
};

ChampsContext.prototype.style = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(StyleContext);
    } else {
        return this.getTypedRuleContext(StyleContext,i);
    }
};

ChampsContext.prototype.COMA = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(CompetitionMLParser.COMA);
    } else {
        return this.getToken(CompetitionMLParser.COMA, i);
    }
};


ChampsContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterChamps(this);
	}
};

ChampsContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitChamps(this);
	}
};




CompetitionMLParser.ChampsContext = ChampsContext;

CompetitionMLParser.prototype.champs = function() {

    var localctx = new ChampsContext(this, this._ctx, this.state);
    this.enterRule(localctx, 24, CompetitionMLParser.RULE_champs);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 94;
        this.match(CompetitionMLParser.T__12);
        this.state = 95;
        this.columns();
        this.state = 96;
        this.match(CompetitionMLParser.T__13);
        this.state = 97;
        this.style();
        this.state = 102;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===CompetitionMLParser.COMA) {
            this.state = 98;
            this.match(CompetitionMLParser.COMA);
            this.state = 99;
            this.style();
            this.state = 104;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function StyleContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = CompetitionMLParser.RULE_style;
    this.style_text = null; // Token
    this.color = null; // Token
    return this;
}

StyleContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
StyleContext.prototype.constructor = StyleContext;

StyleContext.prototype.STYLE_TEXT = function() {
    return this.getToken(CompetitionMLParser.STYLE_TEXT, 0);
};

StyleContext.prototype.COLOR_HEXA = function() {
    return this.getToken(CompetitionMLParser.COLOR_HEXA, 0);
};

StyleContext.prototype.enterRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.enterStyle(this);
	}
};

StyleContext.prototype.exitRule = function(listener) {
    if(listener instanceof CompetitionMLListener ) {
        listener.exitStyle(this);
	}
};




CompetitionMLParser.StyleContext = StyleContext;

CompetitionMLParser.prototype.style = function() {

    var localctx = new StyleContext(this, this._ctx, this.state);
    this.enterRule(localctx, 26, CompetitionMLParser.RULE_style);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 107;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case CompetitionMLParser.STYLE_TEXT:
            this.state = 105;
            localctx.style_text = this.match(CompetitionMLParser.STYLE_TEXT);
            break;
        case CompetitionMLParser.COLOR_HEXA:
            this.state = 106;
            localctx.color = this.match(CompetitionMLParser.COLOR_HEXA);
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


exports.CompetitionMLParser = CompetitionMLParser;
