package symbolic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class MultiplicationTest {
    Map<String,Sexpr> variables = new HashMap<String,Sexpr>();

    Constant conupp = new Constant(1337);
    Constant conner = new Constant(10);
    Multiplication mult = new Multiplication(conupp,conner);
    Variable var = new Variable("a");
    Multiplication mult2 = new Multiplication(conner,var);

    @Test
    public void getName() throws Exception {
        assertEquals("*",mult.getName());
    }
    //Testa med variabler
    @Test
    public void eval() throws Exception {
        assertEquals(13370, mult.eval(variables).getValue(),0);
        assertEquals("(10.0 * a)",mult2.eval(variables).toString());
    }

    @Test
    public void getResult() throws Exception {
        assertEquals(13370, mult.getResult(conupp.getValue(),conner.getValue()),0);
    }
}