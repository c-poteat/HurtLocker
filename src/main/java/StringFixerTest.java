import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFixerTest {
    StringFixer stringFixer = new StringFixer();

    @Test
    public void matcherTest() {
        String x = "This is a new line=?xxx";
        Pattern ptrn = Pattern.compile("^(\\\\S+)$", Pattern.MULTILINE);
        Matcher matcher = ptrn.matcher(x);
            System.out.println(matcher);
        }
        }

