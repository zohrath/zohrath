
package symbolic;


import org.junit.Test;
import symbolic.Negation;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class NegationTest {

    Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
    Constant con = new Constant(1337);
    Negation neg = new Negation(con);
    Variable var = new Variable("a");
    Negation neg2 = new Negation(var);
    @Test
    public void getName() {
        assertEquals(neg.getName(),"-");
    }

    @Test
    public void eval() throws Exception {
        assertEquals(-1337,neg.eval(variables).getValue(),0);
        assertEquals("(-a)",neg2.eval(variables).toString());
    }

    @Test
    public void getResult() throws Exception{
        assertEquals(-1337,neg.getResult(1337),0);

    }
}