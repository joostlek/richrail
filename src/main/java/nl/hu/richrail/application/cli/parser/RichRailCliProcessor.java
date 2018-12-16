package nl.hu.richrail.application.cli.parser;

import nl.hu.richrail.services.TrainService;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.RichRailLexer;
import parser.RichRailParser;

public class RichRailCliProcessor {

    private final RichRailCli listener;

    public RichRailCliProcessor(TrainService trainService, RichRailCliCallback callback) {
        this.listener = new RichRailCli(trainService, callback);
    }

    public void parse(String command) {
        // Tokenize / Lexical analysis
        Lexer lexer = new RichRailLexer(CharStreams.fromString(command));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create Parse Tree
        RichRailParser parser = new RichRailParser(tokens);
        ParseTree tree = parser.command();

        // Create ParseTreeWalker and Custom Listener
        ParseTreeWalker walker = new ParseTreeWalker();

        // Walk over ParseTree using Custom Listener that listens to enter/exit events
        walker.walk(this.listener, tree);
    }

}
