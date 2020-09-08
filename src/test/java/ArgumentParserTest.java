import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ArgumentParserTest {
    private ArgumentParser p;


    @Before
    public void setup() {
        p = new ArgumentParser();
    }


    @Test
    public void testCanHoldArguments() {
        p.addArgument("length");
        assertThat(p.hasArgument("length"), is(true));
    }

    @Test
    public void testDoesNotHoldArgument() {
        p.addArgument("length");
        assertThat(p.hasArgument("width"), is(false));
    }

    @Test
    public void testRetrieveLength() {
        p.addArgument("length");
        String[] args = {"42"};
        p.parse(args);
        assertThat(p.get("length"), is("42"));
    }

    @Test
    public void testRetrieveLengthAndWidth() {
        p.addArgument("length");
        p.addArgument("width");
        String[] args = {"42", "7"};
        p.parse(args);
        assertThat(p.get("length"), is("42"));
        assertThat(p.get("width"), is("7"));
    }

    @Test
    public void testRetrieveHeightIsNotThere() {
        p.addArgument("length");
        p.addArgument("width");
        p.addArgument("height");
        String[] args = {"42", "7"};
        try {
            p.parse(args);
            assertTrue(false);
        } catch(ArgumentNotFoundException e) {
            assertTrue(true);
        }
    }

}

/*

public static void main(String[] args) {
    ArgumentParser p = new ArgumentParser();
    p.addArgument("length");
    p.addArgument("width");
    p.addArgument("height");
    
    p.parse(args);
    
    float len = Float.parseFloat(p.get("length"));
}
*/
