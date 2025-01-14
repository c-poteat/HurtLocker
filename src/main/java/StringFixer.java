import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFixer {

    private String liteParser;

    public StringFixer() {
        this.liteParser = loadFile();
    }

    public String loadFile() {
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

    public String replaceAllCharactersAddSpace() {
        String replace = " ";
        Pattern newPattern = Pattern.compile("[#;:^@%*!]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = newPattern.matcher(liteParser);
        return matcher.replaceAll(replace).replaceAll("\\s+ "," ").trim();
    }

    public String formatString() {
        String str = replaceAllCharactersAddSpace();
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(str);
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase() + m.group(2).toLowerCase());
        }
        return(m.appendTail(sb).toString());
    }

    public String formatCookies() {
        // Set String to replace
        String replace = "Cookies";
        // Find value to replace with
        Pattern newPattern = Pattern.compile("Co0Kies", Pattern.CASE_INSENSITIVE);
        // Look up data according to hamlet file
        Matcher matcher = newPattern.matcher(formatString());

        return matcher.replaceAll(replace);
    }

    public String formatName() {
        // Set String to replace
        String replace = "\n Name";
        // Find value to replace with
        Pattern newPattern = Pattern.compile("Name", Pattern.CASE_INSENSITIVE);
        // Look up data according to hamlet file
        Matcher matcher = newPattern.matcher(formatCookies());

        return matcher.replaceAll(replace);
    }

}

