import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LibraryTest {
    @Test
    public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertThat(classUnderTest.someLibraryMethod(), is(true));
    }
}
