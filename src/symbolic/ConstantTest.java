package symbolic;

import org.junit.Assert;
import symbolic.Constant;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class ConstantTest {

    Constant con = new Constant(5);


    @org.junit.Test
    public void getValue() throws Exception {
        assertEquals(5, con.getValue());
    }

    @org.junit.Test
    public void getName() throws Exception {
        System.out.println(con.getName());
        assertEquals("Constant", con.getName());
    }


    //används inte
    @org.junit.Test
    public void eval() throws Exception {

    }

    @org.junit.Test
    public void getConstant() throws Exception {
        System.out.println(con.getConstant());
        assertEquals(5,con.getConstant());
    }
}