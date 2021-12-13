
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class Main {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception {
//        String output = (new Main()).readRawDataToString();
//
        StringFixer stringFixer = new StringFixer();
//        stringFixer.replaceAllCharactersAddSpace();
//        stringFixer.formatString();
        try {
            FileWriter myWriter = new FileWriter("Output.txt");
            myWriter.write(stringFixer.formatString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {

    }


    }

}
