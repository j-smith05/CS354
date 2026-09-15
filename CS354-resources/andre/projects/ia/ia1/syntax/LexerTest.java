package syntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for syntax.Lexer
 *
 * Uses JUnit 5.
 */
public class LexerTest {

    /**
     * Tests that the lexer can recognize a number.
     *
     * @throws SyntaxException
     */
    @Test
    public void test() throws SyntaxException {

        String prg = "4";
        Lexer lexer = new Lexer(prg);

        assertEquals(new Token("num", "4"), lexer.next());
        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }


    /**
     * Tests that the lexer can recognize an identifier.
     *
     * @throws SyntaxException
     */
    @Test
    public void testOneIdentifier() throws SyntaxException {

        String prg = "x";
        Lexer lexer = new Lexer(prg);

        assertEquals(new Token("id", "x"), lexer.next());
        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }


    /**
     * Tests that the lexer can recognize an operator.
     *
     * @throws SyntaxException
     */
    @Test
    public void testOneOperator() throws SyntaxException {

        String prg = ";";
        Lexer lexer = new Lexer(prg);

        assertEquals(new Token(";", ";"), lexer.next());
        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }


    /**
     * Tests that the lexer can recognize multiple tokens.
     *
     * @throws SyntaxException
     */
    @Test
    public void testMultipleTokens() throws SyntaxException {

        String prg = "x = 12 + 3;";
        Lexer lexer = new Lexer(prg);

        assertEquals(new Token("id", "x"), lexer.next());
        assertEquals(new Token("=", "="), lexer.next());
        assertEquals(new Token("num", "12"), lexer.next());
        assertEquals(new Token("+", "+"), lexer.next());
        assertEquals(new Token("num", "3"), lexer.next());
        assertEquals(new Token(";", ";"), lexer.next());
        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }


    /**
     * Tests identifiers that contain digits.
     *
     * @throws SyntaxException
     */
    @Test
    public void testIdentifierWithDigits() throws SyntaxException {

        String prg = "move2Up hi8friends";
        Lexer lexer = new Lexer(prg);

        assertEquals(new Token("id", "move2Up"), lexer.next());
        assertEquals(new Token("id", "hi8friends"), lexer.next());
        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }


    /**
     * Tests integer and floating point numbers.
     *
     * @throws SyntaxException
     */
    @Test
    public void testNumbers() throws SyntaxException {

        String prg = "12 12.3 .1 1.";
        Lexer lexer = new Lexer(prg);

        assertEquals(new Token("num", "12"), lexer.next());
        assertEquals(new Token("num", "12.3"), lexer.next());
        assertEquals(new Token("num", ".1"), lexer.next());
        assertEquals(new Token("num", "1."), lexer.next());
        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }


    /**
     * Tests all operators supported by the lexer.
     *
     * @throws SyntaxException
     */
    @Test
    public void testAllOperators() throws SyntaxException {

        String prg = "+ - * / ; = ( )";
        Lexer lexer = new Lexer(prg);

        assertEquals(new Token("+", "+"), lexer.next());
        assertEquals(new Token("-", "-"), lexer.next());
        assertEquals(new Token("*", "*"), lexer.next());
        assertEquals(new Token("/", "/"), lexer.next());
        assertEquals(new Token(";", ";"), lexer.next());
        assertEquals(new Token("=", "="), lexer.next());
        assertEquals(new Token("(", "("), lexer.next());
        assertEquals(new Token(")", ")"), lexer.next());
        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }


    /**
     * Tests that whitespace and newlines are ignored.
     *
     * @throws SyntaxException
     */
    @Test
    public void testNewlinesAndWhitespace() throws SyntaxException {

        String prg = "x = 5;\ny = 10;";
        Lexer lexer = new Lexer(prg);

        assertEquals(new Token("id", "x"), lexer.next());
        assertEquals(new Token("=", "="), lexer.next());
        assertEquals(new Token("num", "5"), lexer.next());
        assertEquals(new Token(";", ";"), lexer.next());

        assertEquals(new Token("id", "y"), lexer.next());
        assertEquals(new Token("=", "="), lexer.next());
        assertEquals(new Token("num", "10"), lexer.next());
        assertEquals(new Token(";", ";"), lexer.next());

        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }


    /**
     * Tests that illegal characters are reported and ignored.
     *
     * @throws SyntaxException
     */
    @Test
    public void testIllegalCharacter() throws SyntaxException {

        String prg = "x @ 5";
        Lexer lexer = new Lexer(prg);

        assertEquals(new Token("id", "x"), lexer.next());
        assertEquals(new Token("num", "5"), lexer.next());
        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }


    /**
     * Tests that // comments are ignored.
     *
     * @throws SyntaxException
     */
    @Test
    public void testComment() throws SyntaxException {

        String prg = "x = 5; // this is a comment\ny = 10;";
        Lexer lexer = new Lexer(prg);

        assertEquals(new Token("id", "x"), lexer.next());
        assertEquals(new Token("=", "="), lexer.next());
        assertEquals(new Token("num", "5"), lexer.next());
        assertEquals(new Token(";", ";"), lexer.next());

        assertEquals(new Token("id", "y"), lexer.next());
        assertEquals(new Token("=", "="), lexer.next());
        assertEquals(new Token("num", "10"), lexer.next());
        assertEquals(new Token(";", ";"), lexer.next());

        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }


    /**
     * Tests a comment that continues to the end of the program.
     *
     * @throws SyntaxException
     */
    @Test
    public void testCommentAtEOF() throws SyntaxException {

        String prg = "x = 5; // end of program";
        Lexer lexer = new Lexer(prg);

        assertEquals(new Token("id", "x"), lexer.next());
        assertEquals(new Token("=", "="), lexer.next());
        assertEquals(new Token("num", "5"), lexer.next());
        assertEquals(new Token(";", ";"), lexer.next());
        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }
}