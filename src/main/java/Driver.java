import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public final class Driver {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Error: No input file specified");
            System.err.println("Usage: java Driver <pascal-file>");
            System.exit(1);
        }

        File inputFile = new File(args[0]);
        if (!inputFile.exists()) {
            System.err.println("Error: File not found: " + args[0]);
            System.exit(1);
        }

        if (!inputFile.canRead()) {
            System.err.println("Error: Cannot read file: " + args[0]);
            System.exit(1);
        }

        try {
            // Creates array list and then begins lex analysis
            ArrayList<Token> tokenArrayList = LexAnalyzer.scan(inputFile);
            // begins parser with the array list
            Parser.beginParse(tokenArrayList);
            // instructions stored in a byte array
            Byte[] instructions = Parser.parse();
            // Sends byte array to code generator to generate P-code
            CodeGenerator.setInstructions(instructions);
            CodeGenerator.simulate();
        } catch (FileNotFoundException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Compilation error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}