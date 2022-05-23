import org.junit.jupiter.api.Test;
import utils.StandardLibraryUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static utils.StandardLibraryUtils.addImportsToFile;

public class TestStandardLibrary {

    private final String programsDirectory = "Tests/StandardLibrary/";

    void runImportsEquals(String programName,
                          String expected) throws IOException {

        final String RUNNABLE_PROGRAM_PATH = "run.txt";
        addImportsToFile(programName, RUNNABLE_PROGRAM_PATH);
        File runnableFile = new File(RUNNABLE_PROGRAM_PATH);
        var test = Main.run(RUNNABLE_PROGRAM_PATH, false);
        runnableFile.delete();
        StandardLibraryUtils.usedImports = new ArrayList<>();
        assertEquals(expected, test);
    }

    void runImportsException(String programName,
                             String expectedMessage) throws IOException {
        final String RUNNABLE_PROGRAM_PATH = "run.txt";
        File runnableFile = new File(RUNNABLE_PROGRAM_PATH);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            addImportsToFile(programName, RUNNABLE_PROGRAM_PATH);
        });
        String actualMessage = exception.getMessage();
        runnableFile.delete();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testStandardLibrary1() throws IOException {
        String programName = programsDirectory + "stdTest1.txt";
        String expected = "10\n";
        runImportsEquals(programName, expected);
    }

    @Test
    void testWrongImport() throws IOException {
        String programName = programsDirectory + "stdTest2.txt";
        String expectedMessage = "You did not specified the name of library to import!";
        runImportsException(programName, expectedMessage);
    }

    @Test
    void testHardImport() throws IOException {
        String programName = programsDirectory + "hardImportTest.txt";
        String expected = "10\n" +
                "10\n" +
                "0\n";
        runImportsEquals(programName, expected);
    }
}
