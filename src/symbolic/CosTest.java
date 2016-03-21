package symbolic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/21/16.
 */
public class CosTest {
    Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
    Constant con = new Constant(1337);
    Cos cos = new Cos(con);
    Variable var = new Variable("a");
    Cos cos2 = new Cos(var);
    @Test
    public void getName() throws Exception {
        assertEquals("Cos",cos.getName());
    }

    @Test
    public void eval() throws Exception{
        assertEquals(Math.cos(1337),cos.eval(variables).getValue(),0.1);
        assertEquals(cos2,cos2.eval(variables));
    }
    @Test
    public void getResult() throws Exception {
        assertEquals(Math.cos(1337),cos.getResult(1337),0.1);
    }
}