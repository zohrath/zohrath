package symbolic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class LogTest {
    Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
    Constant con = new Constant(1337);
    Log log = new Log(con);
    Variable var = new Variable("d");
    Log log2 = new Log(var);
    Log logresult = new Log(con);

    @Test
    public void getName() throws Exception {
        assertEquals("Log",log.getName());
    }

    @Test
    public void eval() throws Exception {
        assertEquals(Math.log(1337),log.eval(variables).getValue(),0);

        assertEquals("Log(d)",log2.eval(variables).toString());
    }

    @Test
    public void getResult() throws Exception{
        assertEquals(Math.log(1337), log.getResult(1337),0);

    }

}