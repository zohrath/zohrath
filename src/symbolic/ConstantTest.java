package symbolic;

import org.junit.Assert;
import symbolic.Constant;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class ConstantTest {

    Constant con = new Constant(5);

    Map<String,Sexpr> variables = new HashMap<String,Sexpr>();

    @org.junit.Test
    public void getValue() throws Exception {
        assertEquals(5, con.getValue());
    }

    @org.junit.Test
    public void getName() throws Exception {
        assertEquals("Constant", con.getName());
    }


    //används inte
    @org.junit.Test
    public void eval() throws Exception {
        assertEquals(con,con.eval(variables));
    }

    @org.junit.Test
    public void getConstant() throws Exception {
        assertEquals((double)5,con.getValue(),(double)0.1);
    }
}