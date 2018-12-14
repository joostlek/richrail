package nl.hu.richrail.application.cli;

import nl.hu.richrail.application.cli.parser.RichRailParser;

import nl.hu.richrail.services.TrainService;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.*;

import java.util.Scanner;

public class ApplicationCli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ExampleCliInputs();

        // get instance and print available rollingcomponents and trains
        TrainService trainService = TrainService.getInstance();
        System.out.println(trainService.getRollingComponentsString() + trainService.getTrainsString());

        while (true) {
            String line = scanner.nextLine();

            if (line.toLowerCase().equals("exit") || line.isEmpty()) {
                break;
            }

            Cli(line);
        }
    }

    public static void ExampleCliInputs() {
        // examples from richrail context
        Cli("new train tr1");
        Cli("new train tr2");
        Cli("new locomotive lm1");
        Cli("new wagon wg1");
        Cli("new wagon wg2 numseats 15");
        Cli("new wagon wg3 numseats 20");
        Cli("add wg2 to tr1");
        Cli("add wg3 to tr1");
        Cli("getnumseats train tr1");
        Cli("getnumseats wagon wg2");
        //Cli("remove wg2 from tr1");
        //Cli("delete train tr1");
        //Cli("delete train tr2");
    }

    public static void Cli(String input) {
        CharStream lineStream = CharStreams.fromString(input);

        // Tokenize / Lexical analysis
        Lexer lexer = new RichRailLexer(lineStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create Parse Tree
        parser.RichRailParser parser = new parser.RichRailParser(tokens);
        ParseTree tree = parser.command();

        // Create ParseTreeWalker and Custom Listener
        ParseTreeWalker walker = new ParseTreeWalker();
        RichRailListener listener = new RichRailParser();

        // Walk over ParseTree using Custom Listener that listens to enter/exit events
        walker.walk(listener, tree);
    }
}
