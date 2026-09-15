package syntax;

import java.util.*;

/**
 * Lexical Analyzer for CS354 programming language 
 * scans a program and returns the next token in the program.
 * @author CS354 Instructors, and Jacob Smith
 */
public class Lexer {

    private String program;      // source program being interpreted
    private int position;        // index of next char in program

    private Set<String> whitespace = new HashSet<>();
    private Set<String> letters = new HashSet<>();
    private Set<String> digits = new HashSet<>();
    private Set<String> keywords = new HashSet<>();


    /**
     * Creates a new lexical analyzer
     *
     * @param program - the program text to scan
     */
    public Lexer(String program) {
        this.program = program;
        position = 0;
        initWhitespace(whitespace);
        initLetters(letters);
        initDigits(digits);
        initKeywords(keywords);
    }

    private void initKeywords(Set<String> keywords2) {
        //.... no keywords yet
    }

    private void initLetters(Set<String> s) {
        fill(s, 'A', 'Z');
        fill(s, 'a', 'z');
    }

    private void initDigits(Set<String> s) {
        fill(s, '0', '9');
    }

    private void fill(Set<String> s, char lo, char hi) {
        for (char c = lo; c <= hi; c++) {
            s.add(c + "");
        }
    }

    /**
     * Initializes the whitespace set with the whitespace characters.
     * @param s
     */
    private void initWhitespace(Set<String> s) {
        s.add(" ");
        s.add("\n");
        s.add("\t");
    }

    /**
     * Advances the position of the lexer by one character.
     */
    private void advance() {
        this.position++;
    }

    /**
     * Returns the character at the current position of the lexer.
     *
     * @return the character at the current position, or null if at end of program
     */
    private String peek() {
        if (hasChar()) {
            return program.charAt(position) + "";
        } else {
            return null;
        }
    }

    /**
     * Scans an identifier or keyword. Identifiers may contain letters and digits after starting with a letter.
     * @return the scanned token, either an identifier or a keyword
     * @throws SyntaxException if the identifier is invalid
     */
    private Token nextKwID() {

        int old = this.position;
        advance();

        // Identifiers may contain letters and digits after
        // starting with a letter.
        while (hasChar() &&
                (letters.contains(peek()) || digits.contains(peek()))) {
            advance();
        }

        String lexeme = program.substring(old, position);

        if (keywords.contains(lexeme))
            return new Token(lexeme, lexeme);
        else
            return new Token("id", lexeme);
    }

    /**
     * Scans an integer or floating point number.
     */
    private Token nextNum() {

        int old = this.position;

        // Read digits before the decimal point.
        while (hasChar() && digits.contains(peek())) {
            advance();
        }

        // Read an optional decimal point and digits after it.
        if (hasChar() && peek().equals(".")) {
            advance();

            while (hasChar() && digits.contains(peek())) {
                advance();
            }
        }

        String lexeme = program.substring(old, position);

        return new Token("num", lexeme);
    }


    /**
     * Determines the kind of the next token (e.g., "id") and calls the
     * appropriate method to scan the token's lexeme (e.g., "foo").
     *
     * @return the scanned token.
     */
    public Token next() {

        // Skip whitespace.
        while (hasChar() && whitespace.contains(peek())) {
            advance();
        }

        // End of program.
        if (!hasChar()) {
            return new Token("EOF");
        }

        // Skip // comments.
        if (peek().equals("/") &&
                position + 1 < program.length() &&
                program.charAt(position + 1) == '/') {

            while (hasChar() && !peek().equals("\n")) {
                advance();
            }

            return next();
        }

        // Identifier
        if (letters.contains(peek())) {
            return nextKwID();
        }

        // Number
        if (digits.contains(peek()) ||
                (peek().equals(".") &&
                        position + 1 < program.length() &&
                        Character.isDigit(program.charAt(position + 1)))) {

            return nextNum();
        }

        // Operators
        String operators = "+-*/;=()";

        if (operators.contains(peek())) {
            String operator = peek();
            advance();

            return new Token(operator, operator);
        }

        // Illegal character
        System.err.println("illegal character at position " + position);
        position++;

        return next();
    }


    /**
     * Determines if the current position of the lexer is in the bounds of the
     * program
     *
     * @return true if there are more characters in program
     */
    public boolean hasChar() {
        return position < program.length();
    }


    /**
     * Getter for position of the lexer in the program
     *
     * @return index of the current position of the scanner
     */
    public int getPosition() {
        return position;
    }
}