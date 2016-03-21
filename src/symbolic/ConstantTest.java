package symbolic;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class ConstantTest {

    Constant con = new Constant(5);

    @org.junit.Test
    public void getValue() throws Exception {

    }

    @org.junit.Test
    public void getName() throws Exception {
        assertEquals("-", con.getName());
    }

    @org.junit.Test
    public void eval() throws Exception {

    }

    @org.junit.Test
    public void getConstant() throws Exception {

    }
}