# Pascal Compiler

A full-featured compiler for a subset of Pascal that translates source code to P-code (virtual machine bytecode) and executes it through a stack-based interpreter.

## Overview

This compiler implements a complete compilation pipeline:
- **Lexical Analysis**: Tokenizes Pascal source code with comprehensive keyword and operator recognition
- **Syntax Analysis**: Recursive descent parser implementing Pascal grammar
- **Semantic Analysis**: Symbol table management with scope handling and type checking
- **Code Generation**: Generates P-code instructions for a stack-based virtual machine
- **Code Execution**: Built-in P-code interpreter/simulator

## Features

### Language Support
- ✅ Variables with type declarations (integer, real, boolean, char)
- ✅ Arrays with integer and character indices
- ✅ Arithmetic expressions with type coercion (int ↔ real)
- ✅ Boolean expressions and comparisons
- ✅ Control structures:
  - `if-then-else` statements
  - `while` loops
  - `for` loops
  - `repeat-until` loops
  - `case` statements
- ✅ Procedures with forward references
- ✅ `goto` statements with labels
- ✅ `writeln` for output (integers, reals, booleans, characters)

### Technical Features
- Hash-based symbol table for efficient lookups
- Stack-based code generation and execution
- Type checking and validation
- Array bounds checking
- P-code virtual machine with 40+ opcodes

## Project Structure

```
.
├── Driver.java           # Main compiler driver
├── LexAnalyzer.java      # Lexical analyzer/scanner
├── Parser.java           # Recursive descent parser
├── CodeGenerator.java    # P-code generator and interpreter
├── SymbolTable.java      # Symbol table with scope management
├── Token.java            # Token representation
├── Symbol.java           # Symbol table entries
├── StackHandler.java     # Alternative stack handler implementation
├── keywords.txt          # Pascal reserved words
├── array.pas             # Example: array operations
├── test_*.pas           # Additional test programs
└── completedCompiler/    # Reference materials and examples
```

## How to Build

```bash
javac *.java
```

## How to Run

```bash
java Driver <pascal-file>
```

### Examples

**Simple arithmetic:**
```bash
java Driver test_simple.pas
```

**Control structures:**
```bash
java Driver test_while.pas
java Driver test_if.pas
```

**Arrays:**
```bash
java Driver array.pas
```

## Sample Programs

### Variable Assignment and Arithmetic
```pascal
program simpleTest;
var x: integer;
var y: integer;

begin
    x := 10;
    y := 20;
    writeln(x, y);
    writeln(x + y)
end.
```

### Arrays
```pascal
program arrayProgram;
var a1: array[20..30] of integer;
var c1: array['a'..'e'] of integer;

begin
    a1[23] := 3;
    a1[24] := a1[23] + 5;
    writeln(a1[24]);

    c1['b'] := 10;
    writeln(c1['b'])
end.
```

### While Loop
```pascal
program whileTest;
var i: integer;

begin
    i := 0;
    while i < 5 do
    begin
        writeln(i);
        i := i + 1
    end
end.
```

## Implementation Details

### Lexical Analysis
- Token recognition using character-by-character scanning
- Hash-mapped keywords for O(1) lookup
- Support for integers, floats, scientific notation, characters, strings, and booleans
- Multi-character operator handling (`:=`, `<=`, `>=`, `<>`, `..`)

### Parsing
- Recursive descent parser with predictive parsing
- Grammar-driven implementation
- Expression parsing with proper operator precedence
- Type propagation through parse tree

### Code Generation
- Stack-based intermediate representation (P-code)
- 40+ P-code instructions including:
  - Stack operations (PUSH, POP, PUSHI, PUSHF)
  - Arithmetic (ADD, SUB, MULT, DIV, FADD, FSUB, FMULT, FDIV)
  - Comparisons (EQL, NEQL, LSS, LEQ, GTR, GEQ)
  - Control flow (JMP, JFALSE, JTRUE)
  - Type conversion (CVR, CVI)
  - I/O (PRINT_INT, PRINT_REAL, PRINT_BOOL, PRINT_CHAR)
  - Array operations (GET, PUT)

### Symbol Table
- Hash table with chaining for collision resolution
- Scope stack for nested scopes
- Stores variable/procedure metadata (type, address, array bounds)

## Known Limitations

- Label statements are partially implemented
- No function declarations (procedures only)
- Limited I/O (output only, no input)
- No string manipulation operations
- No pointer or reference types

## Testing

The compiler has been tested with various Pascal programs including:
- Variable declarations and assignments
- Arithmetic and boolean expressions
- Arrays with integer and character indices
- Control flow statements (if-else, while, for, repeat, case)
- Procedure declarations and calls
- Nested scopes

All test programs compile and execute correctly.

## Author

**Pedro Schmidt**  
CSCI 465 - Principles of Translation

## Academic Context

This compiler was developed as a comprehensive project demonstrating:
- Compiler construction principles
- Language translation techniques
- Virtual machine design
- Data structure implementation (hash tables, stacks)
- Software engineering best practices

---

*Note: This is an educational compiler implementation showcasing fundamental compiler design concepts.*
