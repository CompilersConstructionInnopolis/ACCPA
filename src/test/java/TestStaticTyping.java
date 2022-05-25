import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestStaticTyping {
    private final String programsDirectory = "Tests/Interpreter/";
    private final String setQDirectory = "SetQ/";

    void runCompilerEquals(String programName, String expected) throws IOException {
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    void runCompilerException(String programName, String expectedMessage) throws IOException {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Compiler compiler = new Compiler(programName);
            compiler.interpret();
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testSetQReassignmentAtomValue() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_reassignment_atom_value.txt";
        String expected = "'(5 6 6)\n";
        runCompilerEquals(programName, expected);
    }


}
