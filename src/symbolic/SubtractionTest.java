package symbolic;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class SubtractionTest {
    Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
    Constant cona =  new Constant(1337);
    Constant conb = new Constant(337);
    Subtraction sub = new Subtraction(cona,conb);
    Variable var = new Variable("a");
    Subtraction sub2 = new Subtraction(var,cona);
    @Test
    public void getName() throws Exception {
        assertEquals("-", sub.getName() );
    }

    @Test
    public void eval() throws Exception {
        assertEquals(1000,sub.eval(variables).getValue(),0);
        assertEquals(sub2,sub2.eval(variables));
    }

    @Test
    public void getResult() throws Exception {
        assertEquals(1000,sub.getResult(cona.getValue(),conb.getValue()),0);
    }
}