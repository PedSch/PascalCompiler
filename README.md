# New Compiler

An enhanced version of the Mini Pascal compiler with improved features and structure.

## Features

- Lexical Analysis with comprehensive token recognition
- Advanced parsing capabilities
- Symbol table with scope management
- P-code generation and simulation
- Support for arrays, procedures, and complex expressions

## Project Structure

- `Driver.java` - Main compiler driver
- `LexAnalyzer.java` - Lexical analyzer
- `Parser.java` - Parser implementation
- `CodeGenerator.java` - Code generator
- `SymbolTable.java` - Symbol table manager
- `Token.java` - Token class
- `Symbol.java` - Symbol class
- `StackHandler.java` - Stack handler
- `keywords.txt` - Language keywords
- `array.pas` - Test program
- `completedCompiler/` - Reference implementation and examples

## How to Build

```bash
javac *.java
```

## How to Run

```bash
java Driver <pascal-file>
```

Example:
```bash
java Driver array.pas
```

## Examples

See the `completedCompiler/examples/` directory for sample Pascal programs.

## Note

This compiler is under development. Some features like label statements are not fully implemented.

## Author

Pedro Schmidt - CSCI 465 (Principles of Translation)
