package symbolic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class SinTest {

    Constant con =  new Constant(1337);
    Sin sin = new Sin(con);

    @Test
    public void getName() throws Exception {
        assertEquals("Sin", sin.getName());
    }

    @Test
    public void eval() throws Exception {
        assertEquals(Math.sin(1337),sin.eval().getConstant(),0.1);
    }

    @Test
    public void getResult() throws Exception {
        assertEquals(Math.sin(1337),sin.getResult(1337),0.1);
    }
}