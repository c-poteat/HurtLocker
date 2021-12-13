import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFixerTest {
    StringFixer stringFixer = new StringFixer();

    @Test
    public void matcherTest() {
        String strMain = stringFixer.formatString();
        String[] arrSplit_3 = strMain.split("\\s");
        for (int i = 0; i < arrSplit_3.length; i++) {
            System.out.println(arrSplit_3[i]);
        }
    }
}
