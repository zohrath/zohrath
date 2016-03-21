package symbolic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class QuitTest {

    Quit quit = new Quit();

    @Test
    public void getName() throws Exception {
        assertEquals("Quit", quit.getName());
    }

    @Test
    public void eval() throws Exception {

    }
}