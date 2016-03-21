
package symbolic;


import org.junit.Test;
import symbolic.Negation;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class NegationTest {


    Constant con = new Constant(1337);
    Negation neg = new Negation(con);

    @Test
    public void getName() {
        assertEquals(neg.getName(),"-");
    }

    @Test
    public void eval() throws Exception {
        assertEquals(-1337,neg.eval().getValue(),0);
    }

    @Test
    public void getResult() throws Exception{
        assertEquals(-1337,neg.getResult(1337),0);

    }
}