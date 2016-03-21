package symbolic;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/21/16.
 */
public class ExpTest {

    Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
    Constant con =  new Constant(15);
    Exp exp = new Exp(con);
    Variable var = new Variable("a");
    Exp exp2 = new Exp(var);
    @Test
    public void getName() throws Exception {
        assertEquals("Exp", exp.getName());
    }

    @Test
    public void getResult() throws Exception {
        assertEquals(Math.exp(15),exp.getResult(15),0);
    }

    @Test
    public void eval() throws Exception {
        assertEquals(Math.exp(15),exp.getResult(15),0);
        assertEquals("Exp(a)",exp2.eval(variables).toString());
    }
}