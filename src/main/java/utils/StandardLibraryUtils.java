package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StandardLibraryUtils {

    public static List<String> usedImports = new ArrayList<>();

    public static void addImportsToFile(String programSourcePath,
                                        String runnablePath) throws IOException {

        // creating file for runnable path since it is not exist in the beggining of the program
        File file = new File(runnablePath);
        file.createNewFile();

        // with the help of writer we will write to runnablePath
        BufferedWriter writer = new BufferedWriter(new FileWriter(runnablePath, true));

        // Getting all the lines from default program file
        var linesOfProgram = getAllLinesFromFile(programSourcePath);

        for (String line : linesOfProgram) {
            var strippedLine = line.strip();
            if (isCommentedLine(strippedLine)) {
                // skip
            } else {
                if (strippedLine.contains("import")) {

                    // getting all the file names from imports
                    var listOfImports = getAllImportFilesFromLine(strippedLine);

                    // appending runnable txt file with code that is not connected with imports but was written in the same line
                    // for example: import std.txt func sum (a) (plus a a))
                    // we should add func sum... to our runnable txt file
                    writer.append(getStringWithoutImports(strippedLine));
                    writer.append("\n");

                    // going through all the imports from the file and appending their code to our runnable txt file
                    for (var nameOfImport : listOfImports) {
                        if (!usedImports.contains(nameOfImport)) {
                            usedImports.add(nameOfImport);
                            final String pathOfStandartLibrary = "StandartLibrary/" + nameOfImport;
                            addImportsToFile(pathOfStandartLibrary, runnablePath);

//                            Path filePathOfAdditionalLibrary = Paths.get(pathOfStandartLibrary);
//                            Charset charsetOfAdditionalLibrary = StandardCharsets.UTF_8;
//                            var textOfStandartLibrary =
//                                    readFile(filePathOfAdditionalLibrary, charsetOfAdditionalLibrary);
//                            FileWriter fw = new FileWriter(runnablePath, true);
//                            BufferedWriter bw = new BufferedWriter(fw);
//                            bw.write(textOfStandartLibrary);
//                            bw.newLine();
//                            bw.close();
                        }
                    }


                } else {
                    writer.append(line);
                    writer.append("\n");
                }
            }
        }
        writer.close();
    }

    public static String readFile(Path path,
                                  Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(path);
        return new String(encoded, encoding);
    }

    public static List<String> getAllLinesFromFile(String path) {
        Path filePath = Paths.get(path);
        Charset charset = StandardCharsets.UTF_8;
        try {
            return Files.readAllLines(filePath, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isCommentedLine(String line) {
        if (line.isEmpty()){
            return false;
        }
        return line.charAt(0) == ';';
    }

    public static List<String> getAllImportFilesFromLine(String line) {
        var resultedListOfNamesOfFilesToImport = new ArrayList<String>();
        var splittedLine = line.split(" ");
        for (int i = 0; i < splittedLine.length; i++) {
            try {
                if (splittedLine[i].equals("import")) {
                    resultedListOfNamesOfFilesToImport.add(splittedLine[i + 1]);
                }
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new RuntimeException("You did not specified the name of library to import!");
            }

        }
        return resultedListOfNamesOfFilesToImport;
    }

    public static String getStringWithoutImports(String line) {
        var listOfWords = line.split(" ");
        String resultedString = "";
        for (int i = 0; i < listOfWords.length; i++) {
            if (!listOfWords[i].equals("import") && !listOfWords[i - 1].equals("import")) {
                resultedString = resultedString + " " + listOfWords[i];
            }
        }
        return resultedString.strip();
    }
}
