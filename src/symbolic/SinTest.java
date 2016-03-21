package symbolic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class SinTest {
    Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
    Constant con =  new Constant(1337);
    Sin sin = new Sin(con);
    Variable var = new Variable("a");
    Sin sin2 = new Sin(var);
    @Test
    public void getName() throws Exception {
        assertEquals("Sin", sin.getName());
    }

    @Test
    public void eval() throws Exception {
        assertEquals(Math.sin(1337),sin.eval(variables).getValue(),0.1);
        assertEquals("Sin(a)",sin2.eval(variables).toString());
    }

    @Test
    public void getResult() throws Exception {
        assertEquals(Math.sin(1337),sin.getResult(1337),0.1);
    }
}