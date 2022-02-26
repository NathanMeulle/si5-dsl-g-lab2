const {InputStream} = require('antlr4')
const {CompetitionMLLexer} = require('./CompetitionMLLexer')

function createLexer(input) {
    const chars = new InputStream(input);
    const lexer = new CompetitionMLLexer(chars);
    lexer.strictMode = false;
    return lexer;
}

module.exports = {
    createLexer
}