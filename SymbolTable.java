public class SymbolTable {

    static class Scope {
        Symbol[] symbolTable = new Symbol[HASH_TABLE_SIZE]; //symbol table for the current scope
        Scope next = null; //pointer to the next outer scope
    }

     static final int HASH_TABLE_SIZE = 211;
     static Scope S = new Scope();

    public static int hash(String symbolName) {
        if (symbolName == null) {
            return 0;
        }
        int h = 0;
        for (char c : symbolName.toCharArray()) {
            h = h + h + c;
        }
        return Math.abs(h % HASH_TABLE_SIZE);
    }

    public static void insert(Symbol symbol) {
        int hashValue = hash(symbol.getName());

        Symbol current = S.symbolTable[hashValue];
        if (current == null) {
            S.symbolTable[hashValue] = symbol;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = symbol;
        }
    }

    public static Symbol lookupS(String symbolName) {
        if (symbolName == null) {
            return null;
        }
        int hashValue = hash(symbolName);
        Scope scopeCursor = S;
        while (scopeCursor != null) {
            Symbol current = scopeCursor.symbolTable[hashValue];
            while (current != null) {
                if (symbolName.equals(current.getName())) {
                    return current;
                }
                current = current.next;
            }
            scopeCursor = scopeCursor.next;
        }
        return null;
    }

    public static void addS() {
        Scope innerScope = new Scope();
        innerScope.next = S;
        S = innerScope;
    }

    public static void removeS() {
        S = S.next;
    }

    public static Scope getS() {
        return S;
    }
}