
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.IOUtils;


public class Main {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception {
         StringFixer stringFixer = new StringFixer();
        try {
            FileWriter myWriter = new FileWriter("Output.txt");
            myWriter.write(stringFixer.formatName());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {

    }

    }

}

