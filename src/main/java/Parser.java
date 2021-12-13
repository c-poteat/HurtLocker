import javafx.scene.shape.Path;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private String liteParser;

    public Parser() {
        this.liteParser = loadFile();
    }
    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        StringBuilder result = new StringBuilder("");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public String removeWeirdCharacters() {
        String replace = "";
        Pattern newPattern = Pattern.compile("[#%*!@]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = newPattern.matcher(liteParser);
        System.out.println(replace);
        System.out.println(matcher.replaceAll(replace));
        return matcher.replaceAll(replace);
    }


    public int findCount() {
        // Create a counter
        int count= 0;
        // Set value to find
        Pattern newPattern = Pattern.compile("name", Pattern.CASE_INSENSITIVE);
        // Search for value in hamlet text
        Matcher newMatcher = newPattern.matcher(liteParser);
        // Set up while loop to count all instances of Horatio
        while(newMatcher.find()) {
            count++;
        }
        System.out.println(count);
        return count;
    }
}