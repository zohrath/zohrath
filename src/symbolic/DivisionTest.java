package symbolic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class DivisionTest {
    Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
    Constant conupp = new Constant(1337);
    Constant conner = new Constant(10);
    Division div = new Division(conupp,conner);
    Variable var = new Variable("a");
    Division div2 = new Division(var,conner);

    @Test
    public void getName() throws Exception {
        assertEquals("/",div.getName());
    }
    //testa med variabler
    @Test
    public void eval() throws Exception {
        assertEquals(133.7,div.eval(variables).getValue(),0.1);
        assertEquals("(a / 10.0)",div2.eval(variables).toString());
    }

    @Test
    public void getResult() throws Exception {
        assertEquals(133.7,div.getResult(1337,10),0.1);
    }
}