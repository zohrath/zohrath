package symbolic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class AdditionTest {
        Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
        Constant con = new Constant(2);
        Addition add = new Addition(con,con);
        Variable var = new Variable("a");
        Addition add2 = new Addition(var,con);
    @Test
    public void getName() throws Exception {
        assertEquals("+",add.getName());
    }
    //Gör test med variabler
    @Test
    public void eval() throws Exception {

        assertEquals((double)4,add.eval(variables).getValue(),(double)0);
        assertEquals("(a + 2.0)",add2.eval(variables).toString());

    }

    @Test
    public void getResult() throws Exception {
        assertEquals((double)10,add.getResult((double)5,(double)5),(double)0);
    }
}